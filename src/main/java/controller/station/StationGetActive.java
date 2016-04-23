package controller.station;

import controller.application.BaseController;
import java.util.List;
import model.bean.Station;
import model.repository.station.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    private StationRepository stationRepository;

    //==========================================================================
    /**
     * get active stations, this controller returns only active stations, that
     * means only stations with the flag active = 1 and is softDeleted = 0.
     *
     * @return List
     */
    @RequestMapping(value = "/v1/station/getActiveStations", method = RequestMethod.GET)
    public List<Station> getActiveStations() {

        List<Station> stations = null;

        try {

            stations = stationRepository.getActiveStations();

        } catch (Exception e) {
            handleException("StationGetActive.getActiveStations", e, StationGetActive.class);
        }

        return stations;
    }

}
