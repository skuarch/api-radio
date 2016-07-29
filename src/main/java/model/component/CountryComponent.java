package model.component;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author skuarch
 */
@Component
public class CountryComponent {

    //==========================================================================
    public CountryComponent() {
    }

    //==========================================================================
    public model.bean.Country castPersistedCountryToBeanCountry(model.persistence.Country persistedCountry, String locale) {

        if (locale == null || locale.length() < 1) {
            throw new IllegalArgumentException("locale is null or empty");
        }

        if (persistedCountry == null) {
            throw new IllegalArgumentException("persistedCountry is null");
        }

        model.bean.Country beanCountry = null;

        switch (locale) {

            case "en":
                beanCountry = new model.bean.Country(
                        persistedCountry.getId(), persistedCountry.getNameEnglish()
                );
                break;
            case "es":
                beanCountry = new model.bean.Country(
                        persistedCountry.getId(), persistedCountry.getNameSpanish()
                );
                break;

        }

        return beanCountry;

    }

    //==========================================================================
    public List<model.bean.Country> castPersistedCountryToBeanCountry(List<model.persistence.Country> persistedCountries, String locale) {

        if (locale == null || locale.length() < 1) {
            throw new IllegalArgumentException("locale is null or empty");
        }

        if (persistedCountries == null || persistedCountries.size() < 1) {
            throw new IllegalArgumentException("persistedCountry is null or empty");
        }

        List<model.bean.Country> beanCountries = new ArrayList<>();

        persistedCountries.stream().forEach((persistedCountry) -> {
            beanCountries.add(
                    castPersistedCountryToBeanCountry(persistedCountry, locale)
            );
        });

        return beanCountries;

    }

}
