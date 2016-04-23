package controller.country;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import controller.application.BaseController;
import model.bean.Country;
import model.bean.GenericMessage;
import model.repository.country.CountryRepository;

/**
 * controller.
 * @author skuarch
 */
@RestController
public class CountryCreate extends BaseController {

    @Autowired
    private CountryRepository countryRepository;

    // =========================================================================
    /**
     * creates Country into DB.
     * @param country Country
     * @return GenericMessage
     */
    @RequestMapping(value = { "/v1/country/create" }, method = RequestMethod.POST)
    public GenericMessage createCountry(@ModelAttribute Country country) {

        GenericMessage genericMessage;
        long id = 0;

        try {

            id = countryRepository.save(country).getId();
            genericMessage = getSuccessfulMessage(id);

        } catch (Exception e) {
            genericMessage = handleException("CountryCreate.createCountry()", e, this.getClass());
        }

        return genericMessage;
    }

}
