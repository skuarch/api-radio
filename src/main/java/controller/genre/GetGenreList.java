package controller.genre;

import controller.application.BaseController;
import java.util.Collections;
import java.util.List;
import model.service.genre.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
    private GenreService genreService;

    //==========================================================================
    /**
     * get the list of genres.
     *
     * @param locale String
     * @return List
     */
    @RequestMapping(value = { "/v1/genres/{locale}" }, method = RequestMethod.GET)
    public List<model.bean.Genre> getGenresList(@PathVariable("locale") String locale) {

        List<model.bean.Genre> beanGenres;

        try {

            beanGenres = genreService.getGenre(locale);

        } catch (Exception e) {
            handlerExceptionRedirect(e, this.getClass());
            beanGenres = (List<model.bean.Genre>) Collections.EMPTY_LIST;
        }

        return beanGenres;
    }

}
