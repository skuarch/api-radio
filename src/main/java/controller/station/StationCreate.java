package controller.station;

import controller.application.BaseController;
import model.bean.GenericMessage;
import model.component.StationComponent;
import model.persistence.Station;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * RestController.
 *
 * @author skuarch
 */
@RestController
public class StationCreate extends BaseController {

    @Autowired
    private StationComponent stationComponent;

    //==========================================================================
    /**
     * create station.
     *
     * @param station Station
     * @return GenericMessage
     */
    @RequestMapping(value = "/v1/station/create", method = RequestMethod.POST)
    public GenericMessage createStation(@ModelAttribute Station station) {

        GenericMessage genericMessage;
        long id;

        try {

            genericMessage = stationComponent.createStationIfDoesntExist(station);

        } catch (Exception e) {
            genericMessage = handleException("StationComponent.createStation", e, StationCreate.class);
        }

        return genericMessage;

    }

}
