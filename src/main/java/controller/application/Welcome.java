package controller.application;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Controller.
 * @author skuarch
 */
@Controller
public class Welcome extends BaseController {

    // =========================================================================
    /**
     * welcome controller.
     * @return String
     */
    @RequestMapping(value = { "/", "welcome", "/index" }, method = RequestMethod.GET)
    public String welcome() {
        return "application/index";
    }

}
