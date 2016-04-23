package controller.station;

import controller.application.BaseController;
import model.bean.GenericMessage;
import model.bean.Station;
import model.logic.Constants;
import model.repository.station.StationRepository;
import model.service.station.StationService;
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
    private StationRepository stationRepository;

    @Autowired
    private StationService stationService;

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
        long id = 0;

        try {

            //station exits? 
            if (stationService.existStation(station.getName())) {                
                genericMessage = new GenericMessage(
                        id,
                        Constants.UNPROSSABLE_ENTITY,
                        "station already exist");
            } else {
                id = stationRepository.save(station).getId();
                genericMessage = getSuccessfulMessage(id);
            }

        } catch (Exception e) {
            genericMessage = handleException("StationCreate.createStation", e, StationCreate.class);
        }

        return genericMessage;

    }

}
