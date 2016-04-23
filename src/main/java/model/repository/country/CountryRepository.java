package model.repository.country;

import java.util.List;
import model.bean.Country;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository.
 *
 * @author skuarch
 */
@Repository
public interface CountryRepository extends CrudRepository<Country, Long> {

    List<Country> getCountries();

}
