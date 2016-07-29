package model.component;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author skuarch
 */
@Component
public class GenreComponent {

    //==========================================================================
    public GenreComponent() {
    }

    //==========================================================================
    public model.bean.Genre castPersistedGenreToBeanGenre(model.persistence.Genre persistedGenre, String locale) {

        model.bean.Genre beanGenre = null;

        try {

            switch (locale) {

                case "en":
                    beanGenre = new model.bean.Genre(
                            persistedGenre.getId(), persistedGenre.getNameEnglish()
                    );
                    break;
                case "es":
                    beanGenre = new model.bean.Genre(
                            persistedGenre.getId(), persistedGenre.getNameSpanish()
                    );
            }

        } catch (Exception e) {
            throw e;
        }

        return beanGenre;

    }

    //==========================================================================
    public List<model.bean.Genre> castPersistedGenreToBeanGenre(List<model.persistence.Genre> persistedGenres, String locale) {

        List<model.bean.Genre> beanGenres = new ArrayList<>();

        try {

            persistedGenres.stream().forEach((persistedGenre) -> {
                beanGenres.add(
                        castPersistedGenreToBeanGenre(persistedGenre, locale)
                );
            });

        } catch (Exception e) {
            throw e;
        }

        return beanGenres;

    }

}
