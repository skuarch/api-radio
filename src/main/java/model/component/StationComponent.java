package model.component;

import java.util.ArrayList;
import java.util.List;
import model.bean.GenericMessage;
import model.logic.Constants;
import model.service.station.StationService;
import model.util.GenericMessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author skuarch
 */
@Component
public class StationComponent {

    @Autowired
    private GenreComponent genreComponent;

    @Autowired
    private LanguageComponent languageComponent;

    @Autowired
    private CountryComponent countryComponent;

    @Autowired
    private StationService stationService;

    //==========================================================================
    public StationComponent() {
    }

    //==========================================================================
    public List<model.bean.Station> castPersistedStationsToBeanStations(List<model.persistence.Station> persistedStations, String locale) {

        if (locale == null || locale.length() < 1) {
            throw new IllegalArgumentException("locale is null or empty");
        }

        final List<model.bean.Station> beanStations = new ArrayList<>();

        try {

            persistedStations.stream().forEach((persistedStation) -> {

                model.bean.Station beanStation = new model.bean.Station();
                beanStation.setActive(persistedStation.getActive());
                beanStation.setClicks(persistedStation.getClicks());

                beanStation.setCountry(countryComponent.castPersistedCountryToBeanCountry(
                        persistedStation.getCountry(), locale)
                );

                beanStation.setCreationDate(persistedStation.getCreationDate());
                beanStation.setDescription(persistedStation.getDescription());
                beanStation.setFrecuencie(persistedStation.getFrecuencie());

                List<model.bean.Genre> listBeanGenre = new ArrayList<>();
                List<model.persistence.Genre> listPersistedGenre = persistedStation.getGenre();
                listPersistedGenre.stream().forEach((persistedGenre) -> {
                    listBeanGenre.add(genreComponent.castPersistedGenreToBeanGenre(persistedGenre, locale));
                });
                beanStation.setGenre(listBeanGenre);

                beanStation.setId(persistedStation.getId());
                beanStation.setIsSoftDeleted(persistedStation.getIsSoftDeleted());
                beanStation.setKeyword(persistedStation.getKeyword());

                List<model.bean.Language> listBeanLanguage = new ArrayList<>();
                List<model.persistence.Language> listPersistedlanguage = persistedStation.getLanguage();
                listPersistedlanguage.stream().forEach((persitedLanguage) -> {
                    listBeanLanguage.add(languageComponent.castPersistedLanguageToBeanLanguage(persitedLanguage, locale));
                });
                beanStation.setLanguage(listBeanLanguage);

                beanStation.setModulating(persistedStation.getModulating());
                beanStation.setName(persistedStation.getName());
                beanStation.setPosition(persistedStation.getPosition());
                beanStation.setStationType(persistedStation.getStationType());
                beanStation.setUrlStreaming(persistedStation.getUrlStreaming());
                beanStation.setWebsite(persistedStation.getWebsite());

                beanStations.add(beanStation);
            });

        } catch (Exception e) {
            throw e;
        }

        return beanStations;

    }

    //==========================================================================
    /**
     * creates the station if station not exists. if the station exists, an
     * exception will be throw.
     *
     * @param station
     * @return
     */
    public GenericMessage createStationIfDoesntExist(model.persistence.Station station) {

        if (station == null) {
            throw new IllegalArgumentException("station is null");
        }

        GenericMessage genericMessage;
        long id = 0;

        try {

            //station exits? 
            if (stationService.existStation(station.getName())) {
                genericMessage = new GenericMessage(
                        id,
                        Constants.UNPROSSABLE_ENTITY,
                        "station already exist");
            } else {
                //creates station
                id = stationService.createStation(station);
                genericMessage = GenericMessageUtil.getSuccessfulMessage(id);
            }

        } catch (Exception e) {
            throw e;
        }

        return genericMessage;

    }

}
