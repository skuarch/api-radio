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
 *
 * @author skuarch
 */
@Entity
@Table(name = "language")
@NamedQueries({
    @NamedQuery(name = Language.GET_LANGUAGES, query = "from Language l")
})
public class Language implements Serializable {

    private static final long serialVersionUID = 3405178041950251807L;
    public static final String GET_LANGUAGES = "Language.getLanguages";

    @Id
    @Column(name = "language_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @NotEmpty
    @Column(name = "language_name_en", nullable = false)
    private String nameEnglish = null;

    @NotNull
    @NotEmpty
    @Column(name = "language_name_es", nullable = false)
    private String nameSpanish = null;

    //==========================================================================
    /**
     * Constructor.
     */
    public Language() {
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
    /**
     * getter.
     *
     * @return name String
     */
    public String getNameEnglish() {
        return nameEnglish;
    }

    //==========================================================================
    /**
     * setter.
     *
     * @param nameEnglish String
     */
    public void setNameEnglish(String nameEnglish) {
        this.nameEnglish = nameEnglish;
    }

    //==========================================================================
    /**
     * getter.
     *
     * @return String
     */
    public String getNameSpanish() {
        return nameSpanish;
    }

    //==========================================================================
    /**
     * setter.
     *
     * @param nameSpanish String
     */
    public void setNameSpanish(String nameSpanish) {
        this.nameSpanish = nameSpanish;
    }

    //==========================================================================
    /**
     * to string.
     *
     * @return String
     */
    @Override
    public String toString() {
        return "id=" + id + " nameEnglish=" + nameEnglish;
    }

} // end class
