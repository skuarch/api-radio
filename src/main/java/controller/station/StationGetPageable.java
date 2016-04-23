package controller.station;

import controller.application.BaseController;
import java.util.List;
import model.bean.Station;
import model.service.station.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author skuarch
 */
@RestController
public class StationGetPageable extends BaseController {

    @Autowired
    private StationService stationService;

    //==========================================================================
    @RequestMapping(value = { "/v1/station/get/pageable" }, method = RequestMethod.GET)
    public List<Station> getPageableStations(@RequestParam("page") int page, @RequestParam("size") int size) {

        List<Station> stations = null;

        try {

            stations = stationService.getStationsPageable(page, size);

        } catch (Exception e) {            
            handlerExceptionRedirect(e, StationGetPageable.class);
        }

        return stations;

    }

}
