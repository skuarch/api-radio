package model.repository.user;

import model.bean.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author skuarch
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    //==========================================================================
    /**
     * get user by password and id.
     *
     * @param email String
     * @param password String
     * @return User
     */
    User getUser(String email, String password);

}
