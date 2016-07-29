package model.service.language;

import java.util.List;
import model.component.LanguageComponent;
import model.repository.language.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author skuarch
 */
@Service
public class LanguageService {

    @Autowired
    private LanguageComponent languageComponent;

    @Autowired
    private LanguageRepository languageRepository;

    //==========================================================================
    public LanguageService() {
    }

    //==========================================================================
    public List<model.bean.Language> getLanguages(String locale) {

        if (locale == null || locale.length() < 1) {
            throw new IllegalArgumentException("locale is null or empty");
        }

        List<model.bean.Language> beanLanguages;
        List<model.persistence.Language> persistedLanguages;

        try {

            persistedLanguages = languageRepository.getLanguages();
            beanLanguages = languageComponent.castPersistedLanguageToBeanLanguage(persistedLanguages, locale);

        } catch (Exception e) {
            throw e;
        }

        return beanLanguages;

    }

}
