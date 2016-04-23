package controller.keyword;

import controller.application.BaseController;
import java.util.List;
import model.bean.Keyword;
import model.repository.keyword.KeywordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * RestController.
 *
 * @author skuarch
 */
@RestController
public class GetKeywordList extends BaseController {

    @Autowired
    private KeywordRepository keywordRepository;

    //==========================================================================
    /**
     * get the list of keywords.
     *
     * @return List
     */
    @RequestMapping(value = { "/v1/keyword/get/list" }, method = RequestMethod.GET)
    public List<Keyword> getKeywords() {

        List<Keyword> keywords = null;

        try {

            keywords = keywordRepository.getKeywords();

        } catch (Exception e) {
            handlerExceptionRedirect(e, this.getClass());
        }

        return keywords;

    }

}
