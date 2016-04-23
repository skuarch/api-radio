package controller.country;

import controller.application.BaseController;
import java.util.List;
import model.bean.Country;
import model.repository.country.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    private CountryRepository countryRepository;

    //==========================================================================
    /**
     * get list of countries.
     *
     * @return List
     */
    @RequestMapping(value = { "/v1/country/get/list" })
    public List<Country> getCountries() {

        List<Country> countries = null;

        try {

            countries = countryRepository.getCountries();

        } catch (Exception e) {
            handlerExceptionRedirect(e, this.getClass());
        }

        return countries;

    }

}
