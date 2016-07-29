package controller.language;

import controller.application.BaseController;
import java.util.List;
import model.service.language.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
    private LanguageService languageService;

    //==========================================================================
    /**
     * get list of languages.
     *
     * @return List
     */
    @RequestMapping(value = { "/v1/languages/{locale}" })
    public List<model.bean.Language> getLanguageList(@PathVariable String locale) {

        List<model.bean.Language> languages = null;

        try {

            languages = languageService.getLanguages(locale);

        } catch (Exception e) {
            handlerExceptionRedirect(e, this.getClass());
        }

        return languages;

    }

}
