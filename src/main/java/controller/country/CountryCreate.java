package controller.country;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import controller.application.BaseController;
import model.bean.GenericMessage;
import model.logic.Constants;
import model.persistence.Country;
import model.repository.country.CountryRepository;

/**
 * controller.
 *
 * @author skuarch
 */
@RestController
public class CountryCreate extends BaseController {

    private static final String CLASS_METHOD_NAME = "CountryCreate.createCountry";

    @Autowired
    private GenericMessage genericMessage;

    @Autowired
    private CountryRepository countryRepository;

    // =========================================================================
    /**
     * creates Country into DB.
     *
     * @param country Country
     * @return GenericMessage
     */
    @RequestMapping(value = { "/v1/country/create" }, method = RequestMethod.POST)
    public GenericMessage createCountry(@ModelAttribute Country country) {

        long id = 0;

        try {

            //country doesn't exits?
            if (countryRepository.findByName(country.getNameEnglish()) == null) {
                id = countryRepository.save(country).getId();
                genericMessage = getSuccessfulMessage(id);
            } else {
                genericMessage.setMessage(Constants.COUNTRY_ALREADY_EXITS);
                genericMessage.setCode(Constants.HTTP_CONFLIT);
                genericMessage.setId(id);
                setErrorCode(Constants.HTTP_CONFLIT);
            }

        } catch (Exception e) {
            genericMessage = handleException(CLASS_METHOD_NAME, e, this.getClass());
        }

        return genericMessage;
    }

}
