package controller.country;

import controller.application.BaseController;
import java.util.List;
import model.service.country.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * RestController
 *
 * @author skuarch
 */
@RestController
public class GetCountryList extends BaseController {

    @Autowired
    private CountryService countryService;

    //==========================================================================
    /**
     * get list of countries.
     *
     * @param locale String
     * @return List
     */
    @RequestMapping(value = { "/v1/countries/{locale}" })
    public List<model.bean.Country> getCountries(@PathVariable String locale) {

        List<model.bean.Country> countries = null;

        try {

            countries = countryService.getCountries(locale);

        } catch (Exception e) {
            handlerExceptionRedirect(e, this.getClass());
        }

        return countries;

    }

}
