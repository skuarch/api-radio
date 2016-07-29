package controller.user;

import controller.application.BaseController;
import model.bean.GenericMessage;
import model.persistence.User;
import model.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author skuarch
 */
@RestController
public class Authentication extends BaseController {

    @Autowired
    private GenericMessage genericMessage;

    @Autowired
    private UserRepository userRepository;

    //==========================================================================
    /**
     *
     * @param user User
     * @return GenericMessage
     */
    @RequestMapping(value = { "/v1/user/authentication" }, method = RequestMethod.POST)
    public GenericMessage userAuthentication(@ModelAttribute User user) {

        User userAuthenticated;

        try {

            setHeaderNoChache();

            userAuthenticated = userRepository.getUser(user.getEmail(), user.getPassword());

            if (userAuthenticated == null) {
                genericMessage.setMessage("false");
            } else {
                genericMessage.setId(userAuthenticated.getId());
                genericMessage.setMessage("true");
            }

        } catch (Exception e) {
            genericMessage = handleException("Authentication.userAuthentication", e, Authentication.class);
            genericMessage.setMessage("false");
        }

        return genericMessage;
    }

}
