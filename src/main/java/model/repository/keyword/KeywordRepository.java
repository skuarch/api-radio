package model.repository.keyword;

import java.util.List;
import model.bean.Keyword;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author skuarch
 */
public interface KeywordRepository extends CrudRepository<Keyword, Long> {

    //==========================================================================
    /**
     * return a List with all the keywords.
     *
     * @return List
     */
    List<Keyword> getKeywords();

    //==========================================================================
    /**
     * find keyword by name.
     *
     * @param name String
     * @return Keyword
     */
    Keyword findByName(String name);

}
