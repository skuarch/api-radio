package controller.station;

import controller.application.BaseController;
import java.util.List;
import model.bean.Station;
import model.service.station.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * RestController.
 *
 * @author skuarch
 */
@RestController
public class StationGetActive extends BaseController {

    @Autowired
    private StationService stationService;

    //==========================================================================
    /**
     * get active stations, this controller returns only active stations, that
     * means only stations with the flag active = 1 and is softDeleted = 0.
     *
     * @param locale String
     * @return List
     */
    @RequestMapping(value = "/v1/station/getActiveStations/{locale}", method = RequestMethod.GET)
    public List<Station> getActiveStations(@PathVariable String locale) {

        if(locale == null || locale.length() < 1){
            throw new IllegalArgumentException("locale is null or empty");
        }
        
        List<Station> stations = null;

        try {

            stations = stationService.getActiveStations(locale);

        } catch (Exception e) {
            handleException("StationGetActive.getActiveStations", e, StationGetActive.class);
        }

        return stations;
    }

}
