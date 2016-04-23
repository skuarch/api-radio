package model.repository.language;

import java.util.List;
import model.bean.Language;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author skuarch
 */
public interface LanguageRepository extends CrudRepository<Language, Long> {

    //==========================================================================
    /**
     * return a List with all the languages.
     *
     * @return List
     */
    List<Language> getLanguages();

}
