package model.component;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author skuarch
 */
@Component
public class LanguageComponent {

    //==========================================================================
    public LanguageComponent() {
    }

    //==========================================================================
    public model.bean.Language castPersistedLanguageToBeanLanguage(model.persistence.Language persistedLanguage, String locale) {

        model.bean.Language beanLanguage = null;

        try {

            switch (locale) {

                case "en":
                    beanLanguage = new model.bean.Language(
                            persistedLanguage.getId(), persistedLanguage.getNameEnglish()
                    );
                    break;
                case "es":
                    beanLanguage = new model.bean.Language(
                            persistedLanguage.getId(), persistedLanguage.getNameSpanish()
                    );
            }

        } catch (Exception e) {
            throw e;
        }

        return beanLanguage;

    }

    //==========================================================================
    public List<model.bean.Language> castPersistedLanguageToBeanLanguage(List<model.persistence.Language> persistedLanguages, String locale) {

        List<model.bean.Language> beanLanguages = new ArrayList<>();

        try {

            persistedLanguages.stream().forEach((persistedLanguage) -> {
                beanLanguages.add(
                        castPersistedLanguageToBeanLanguage(persistedLanguage, locale)
                );
            });

        } catch (Exception e) {
            throw e;
        }

        return beanLanguages;

    }

}
