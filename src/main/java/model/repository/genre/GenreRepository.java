/**
 *
 * @author skuarch
 */
package model.repository.genre;

import java.util.List;
import model.persistence.Genre;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author skuarch
 */
@Repository
public interface GenreRepository extends CrudRepository<Genre, Long> {

    //==========================================================================
    /**
     * return a List with all the genre.
     *
     * @return List
     */
    List<Genre> getEnglishGenres();

    //==========================================================================
    /**
     * return a List with all the genre.
     *
     * @return List
     */
    List<Genre> getSpanishGenres();
    
    List<Genre> getGenres();

    //==========================================================================
    Genre findByNameEnglish(String name);

    //==========================================================================
    Genre findByNameSpanish(String nameSpanish);

    //==========================================================================
    /**
     * find genre by id.
     *
     * @param id long
     * @return Genre
     */
    Genre findById(long id);

}
