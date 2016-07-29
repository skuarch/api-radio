package controller.keyword;

import controller.application.BaseController;
import model.bean.GenericMessage;
import model.persistence.Keyword;
import model.repository.keyword.KeywordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author skuarch
 */
@RestController
public class KeywordCreate extends BaseController {

    @Autowired
    private GenericMessage genericMessage;

    @Autowired
    private KeywordRepository keywordRepository;
    
    //==========================================================================
    @RequestMapping(value = {"/v1/keyword/create"})
    public GenericMessage createKeyword(@ModelAttribute Keyword keyword) {

        long id;

        try {

            //keyword already exists?
            if (keywordRepository.findByName(keyword.getName()) == null) {
                id = keywordRepository.save(keyword).getId();
                genericMessage = getSuccessfulMessage(id);
            } else {
                genericMessage.setMessage("keyword already exits");
            }

        } catch (Exception e) {
            genericMessage = handleException("KeywordCreate.createKeyword", e, getClass());
        }

        return genericMessage;

    }

}
