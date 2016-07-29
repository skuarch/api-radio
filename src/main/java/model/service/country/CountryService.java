package model.service.country;

import java.util.List;
import model.component.CountryComponent;
import model.repository.country.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author skuarch
 */
@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private CountryComponent countryComponent;

    //==========================================================================
    public CountryService() {
    }

    //==========================================================================
    public List<model.bean.Country> getCountries(String locale) {

        if (locale == null || locale.length() < 1) {
            throw new IllegalArgumentException("locale is null or empty");
        }

        List<model.bean.Country> beanCountries = null;
        List<model.persistence.Country> persistedCountries;

        try {

            persistedCountries = countryRepository.getCountries();
            beanCountries = countryComponent.castPersistedCountryToBeanCountry(persistedCountries, locale);

        } catch (Exception e) {
            throw e;
        }

        return beanCountries;

    }

}
