package controller.application;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
    @RequestMapping(value = { "/", "welcome", "/index" })
    public String welcome() {
        return "application/index";
    }

}
