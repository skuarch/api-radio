package model.repository.request;

import org.springframework.data.repository.CrudRepository;
import model.bean.RequestBean;
import org.springframework.stereotype.Repository;

/**
 * Repository.
 * @author skuarch
 */
@Repository
public interface RequestBeanRepository extends CrudRepository<RequestBean, Long> {

}
