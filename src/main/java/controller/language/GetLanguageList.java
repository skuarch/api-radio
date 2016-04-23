package controller.language;

import controller.application.BaseController;
import java.util.List;
import model.bean.Language;
import model.repository.language.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * RestController.
 *
 * @author skuarch
 */
@RestController
public class GetLanguageList extends BaseController {

    @Autowired
    private LanguageRepository languageRepository;

    //==========================================================================
    /**
     * get list of languages.
     *
     * @return List
     */
    @RequestMapping(value = { "/v1/language/get/list" })
    public List<Language> getLanguageList() {

        List<Language> languages = null;

        try {

            languages = languageRepository.getLanguages();

        } catch (Exception e) {
            handlerExceptionRedirect(e, this.getClass());
        }

        return languages;

    }

}
