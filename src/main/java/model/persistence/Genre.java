package model.persistence;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * bean.
 *
 * @author skuarch
 */
@Entity
@Table(name = "genre")
@NamedQueries({
    @NamedQuery(name = Genre.GET_GENRES, query = "from Genre g"),
    @NamedQuery(name = Genre.GET_ENGLISH_GENRES, query = "from Genre g order by g.nameEnglish asc"),
    @NamedQuery(name = Genre.GET_SPANISH_GENRES, query = "from Genre g order by g.nameSpanish asc"),
    @NamedQuery(name = Genre.FIND_BY_NAME_ENGLISH, query = "from Genre g where g.nameEnglish = ?1 order by g.nameEnglish asc"),
    @NamedQuery(name = Genre.FIND_BY_NAME_SPANISH, query = "from Genre g where g.nameSpanish = ?1 order by g.nameSpanish asc"),
    @NamedQuery(name = Genre.FIND_BY_ID, query = "from Genre g where g.id = ?1")
})
public class Genre implements Serializable {

    private static final long serialVersionUID = 940879716174195007L;
    public static final String GET_GENRES = "Genre.getGenres";
    public static final String GET_ENGLISH_GENRES = "Genre.getEnglishGenres";
    public static final String GET_SPANISH_GENRES = "Genre.getSpanishGenres";
    public static final String FIND_BY_NAME_ENGLISH = "Genre.findByNameEnglish";
    public static final String FIND_BY_NAME_SPANISH = "Genre.findByNameSpanish";
    public static final String FIND_BY_ID = "Genre.findById";

    @Id
    @Column(name = "genre_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @NotEmpty
    @Column(name = "genre_name_es", nullable = false)
    private String nameSpanish = null;

    @NotNull
    @NotEmpty
    @Column(name = "genre_name_en", nullable = false)
    private String nameEnglish = null;

    //==========================================================================
    /**
     * constructor.
     */
    public Genre() {
    }

    //==========================================================================
    /**
     * getter.
     *
     * @return id
     */
    public long getId() {
        return id;
    }

    //==========================================================================
    /**
     * setter.
     *
     * @param id long
     */
    public void setId(long id) {
        this.id = id;
    }

    //==========================================================================
    public String getNameSpanish() {
        return nameSpanish;
    }

    //==========================================================================
    public void setNameSpanish(String nameSpanish) {
        if (nameSpanish == null || nameSpanish.length() < 1) {
            throw new IllegalArgumentException("nameSpanish is null or empty");
        }
        this.nameSpanish = nameSpanish;
    }

    //==========================================================================
    public String getNameEnglish() {
        return nameEnglish;
    }

    //==========================================================================
    public void setNameEnglish(String nameEnglish) {
        if (nameEnglish == null || nameEnglish.length() < 1) {
            throw new IllegalArgumentException("nameEnglish is null or empty");
        }
        this.nameEnglish = nameEnglish;
    }

    //==========================================================================
    /**
     * to string.
     *
     * @return String
     */
    @Override
    public String toString() {
        return "id=" + id + " nameEnglish=" + nameEnglish + " nameSpanish=" + nameSpanish;
    }

} // end class
