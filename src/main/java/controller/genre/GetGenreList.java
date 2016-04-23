package controller.genre;

import controller.application.BaseController;
import java.util.List;
import model.bean.Genre;
import model.repository.genre.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author skuarch
 */
@RestController
public class GetGenreList extends BaseController {

    @Autowired
    private GenreRepository genreRepository;

    //==========================================================================
    /**
     * get the list of genres.
     *
     * @return List
     */
    @RequestMapping(value = { "/v1/genre/get/list" }, method = RequestMethod.GET)
    public List<Genre> getGenresList() {

        List<Genre> genres = null;

        try {

            genres = genreRepository.getGenres();

        } catch (Exception e) {
            handlerExceptionRedirect(e, this.getClass());
        }

        return genres;

    }

}
