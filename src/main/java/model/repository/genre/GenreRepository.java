/**
 *
 * @author skuarch
 */
package model.repository.genre;

import java.util.List;
import model.bean.Genre;
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
    List<Genre> getGenres();

    /**
     * find genre by name.
     *
     * @param name String
     * @return Genre
     */
    Genre findByName(String name);

}
