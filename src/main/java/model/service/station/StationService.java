package model.service.station;

import java.util.List;
import model.component.StationComponent;
import model.persistence.Station;
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

    @Autowired
    private StationComponent stationComponent;

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
    public List<model.bean.Station> getStationsPageable(int page, int size, String locale) {

        if (page < 0) {
            throw new IllegalArgumentException("page is less than 0");
        }

        if (size < 0) {
            throw new IllegalArgumentException("size is less than 1");
        }

        Pageable pageable;
        Page<Station> stationPage;
        List<Station> persistedStations;
        List<model.bean.Station> beanStations;

        try {

            pageable = new PageRequest(page, size);
            stationPage = stationRepository.getActiveStations(pageable);
            persistedStations = stationPage.getContent();
            beanStations = stationComponent.castPersistedStationsToBeanStations(persistedStations, locale);

        } catch (Exception e) {
            throw e;
        }

        return beanStations;

    }

    //==========================================================================
    public List<model.bean.Station> getActiveStations(String locale) {

        if (locale == null || locale.length() < 1) {
            throw new IllegalArgumentException("locale is null or empty");
        }

        List<Station> persistedStations;
        List<model.bean.Station> beanStations = null;

        try {

            persistedStations = stationRepository.getActiveStations();
            beanStations = stationComponent
                    .castPersistedStationsToBeanStations(persistedStations, locale);

        } catch (Exception e) {
            throw e;
        }

        return beanStations;

    }

    //==========================================================================
    /**
     * create station.
     *
     * @param station
     * @return long
     */
    public long createStation(model.persistence.Station station) {

        //validations
        if (station.getName() == null || station.getName().length() < 1) {
            throw new IllegalArgumentException("station name is null or empty");
        }

        if (station.getCountry() == null) {
            throw new IllegalArgumentException("station country is null");
        }

        if (station.getGenre() == null) {
            throw new IllegalArgumentException("station genre is null");
        }

        if (station.getKeyword() == null) {
            throw new IllegalArgumentException("station keyword is null");
        }

        if (station.getLanguage() == null) {
            throw new IllegalArgumentException("station language is null");
        }

        if (station.getStationType() == null) {
            throw new IllegalArgumentException("station type is null");
        }

        if (station.getUrlStreaming() == null || station.getUrlStreaming().length() < 1) {
            throw new IllegalArgumentException("station url streaming is null or empty");
        }

        long id = 0;

        try {

            id = stationRepository.save(station).getId();

        } catch (Exception e) {
            throw e;
        }

        return id;

    }

}
