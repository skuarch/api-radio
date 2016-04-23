package model.service.station;

import java.util.List;
import model.bean.Station;
import model.repository.station.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 *
 * @author skuarch
 */
@Service
public class StationService {

    @Autowired
    private StationRepository stationRepository;

    //==========================================================================
    public StationService() {
    }

    //==========================================================================
    public boolean existStation(long id) {

        if (id < 1) {
            throw new IllegalArgumentException("id is less than 1");
        }

        boolean exists;
        Station station;

        try {
            station = stationRepository.findOne(id);
            exists = station != null;
        } catch (Exception e) {
            throw e;
        }

        return exists;

    }

    //==========================================================================
    public boolean existStation(String stationName) {

        if (stationName == null || stationName.length() < 1) {
            throw new IllegalArgumentException("stationName is null or empty");
        }

        boolean exists;
        Station station;

        try {
            station = stationRepository.getStationByName(stationName);
            exists = station != null;
        } catch (Exception e) {
            throw e;
        }

        return exists;

    }
    
    //==========================================================================
    public List<Station> getStationsPageable(int page, int size) {

        if(page < 0){
            throw new IllegalArgumentException("page is less than 0");
        }
        
        if(size < 0){
            throw new IllegalArgumentException("size is less than 1");
        }
        
        Pageable pageable;
        Page<Station> stationPage;
        List<Station> stations;

        try {

            pageable = new PageRequest(page, size);
            stationPage = stationRepository.getActiveStations(pageable);
            stations = stationPage.getContent();

        } catch (Exception e) {
            throw e;
        }

        return stations;

    }

}
