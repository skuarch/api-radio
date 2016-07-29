package model.service.genre;

import java.util.List;
import model.component.GenreComponent;
import model.repository.genre.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author skuarch
 */
@Service
public class GenreService {

    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    private GenreComponent genreComponent;

    //==========================================================================
    public GenreService() {
    }

    //==========================================================================
    public List<model.bean.Genre> getGenre(String locale) throws Exception {

        if (locale == null || locale.length() < 1) {
            throw new IllegalArgumentException("locale is null or empty");
        }

        List<model.bean.Genre> beanGenres;
        List<model.persistence.Genre> persistedGenres;

        try {

            persistedGenres = genreRepository.getGenres();
            beanGenres = genreComponent.castPersistedGenreToBeanGenre(persistedGenres, locale);

        } catch (Exception e) {
            throw e;
        }

        return beanGenres;

    }

}
