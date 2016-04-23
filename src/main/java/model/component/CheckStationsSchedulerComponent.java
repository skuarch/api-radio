package model.component;

import java.util.List;
import model.bean.Station;
import model.logic.Constants;
import model.logic.StationChecker;
import model.repository.station.StationRepository;
import model.util.StationUtilities;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 *
 * @author skuarch
 */
@Component
public class CheckStationsSchedulerComponent {

    private static final Logger LOGGER = Logger.getLogger(CheckStationsSchedulerComponent.class);

    @Autowired
    private StationRepository stationRepository;

    //==========================================================================
    @Scheduled(fixedRate = 3600000)
    public void updateStation() {

        List<Station> stations;

        try {

            stations = stationRepository.getStations();

            stations.stream().forEach((station) -> {

                try {                    
                    boolean active = checkStation(station);                    
                    updateStation(station, active);
                } catch (Exception e) {
                    LOGGER.error("CheckStationsSchedulerComponent.updateStation.forEach", e);
                }

            });

        } catch (Exception e) {
            LOGGER.error("CheckStationsSchedulerComponent.updateStation", e);
        }

    }

    //==========================================================================
    private synchronized boolean checkStation(final Station station) throws Exception {

        boolean activeUrl = false;
        boolean activePort = false;
        String ip;
        int port;
        String streamingUrl;

        try {

            port = StationUtilities.getPort(station.getUrlStreaming());
            streamingUrl = station.getUrlStreaming();
            ip = StationUtilities.getIPAddress(station.getUrlStreaming());

            if (port < 0) {
                port = 80;
            }

            //checking by port            
            activePort = checkPort(ip, port);

            if (activePort) {
                return true;
            } else {

                //check by url                
                activeUrl = checkUrl(streamingUrl);

                if (activeUrl) {
                    return true;
                } else {

                    //clean url
                    if (streamingUrl.contains("/;") || streamingUrl.contains("stream.mp3")) {
                        streamingUrl = streamingUrl.replace("/;stream.mp3", "");
                        streamingUrl = streamingUrl.replace("stream.mp3", "");
                        streamingUrl = streamingUrl.replace("/;", "");
                        activeUrl = checkUrl(streamingUrl);
                    }

                    if (activeUrl) {
                        return true;
                    } else {

                        //check with / at the end
                        if (!streamingUrl.endsWith("/")) {
                            streamingUrl = streamingUrl + "/";
                        }
                        activeUrl = checkUrl(streamingUrl + "/");
                        return activeUrl;                        

                    }

                }

            }

        } catch (Exception e) {            
            return false;
        }

    } // end checkStation

    //==========================================================================
    private void updateStation(final Station station, final boolean isActive) {

        new Thread(() -> {

            try {

                if (isActive) {
                    station.setActive((byte) 1);
                } else {
                    station.setActive((byte) 0);
                }

                stationRepository.save(station);

            } catch (Exception e) {
                LOGGER.error("updateStation", e);
            }

        }).start();

    }

    //==========================================================================
    private boolean checkUrl(String streamingUrl) {

        try {
            return new StationChecker().checkStationUrl(streamingUrl, Constants.STOP_SECONDS, Constants.MAX_BYTES);
        } catch (Exception e) {
            return false;
        }

    }

    //==========================================================================
    private boolean checkPort(String ip, int port) {

        try {
            return new StationChecker().checkStationSocket(ip, port, Constants.STOP_SECONDS, Constants.MAX_BYTES);
        } catch (Exception e) {
            return false;
        }

    }

}
