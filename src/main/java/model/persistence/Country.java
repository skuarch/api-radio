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
@Table(name = "country")
@NamedQueries({
    @NamedQuery(name = Country.GET_COUNTRIES, query = "from Country c"),
    @NamedQuery(name = Country.FIND_BY_NAME, query = "from Country c where c.nameEnglish = ?1")
})
public class Country implements Serializable {

    private static final long serialVersionUID = 7461217241950251807L;
    public static final String GET_COUNTRIES = "Country.getCountries";
    public static final String FIND_BY_NAME = "Country.findByName";

    @Id
    @Column(name = "country_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @NotEmpty
    @Column(name = "country_name_en", nullable = false)
    private String nameEnglish = null;

    @NotNull
    @NotEmpty
    @Column(name = "country_name_es", nullable = false)
    private String nameSpanish = null;

    //==========================================================================
    /**
     * constructor.
     */
    public Country() {
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
    public String getNameEnglish() {
        return nameEnglish;
    }

    //==========================================================================
    public void setNameEnglish(String nameEnglish) {
        this.nameEnglish = nameEnglish;
    }

    //==========================================================================
    public String getNameSpanish() {
        return nameSpanish;
    }

    //==========================================================================
    public void setNameSpanish(String nameSpanish) {
        this.nameSpanish = nameSpanish;
    }

    //==========================================================================
    /**
     * toString.
     *
     * @return String
     */
    @Override
    public String toString() {
        return "id=" + id + " nameEnglish=" + nameEnglish + " nameSpanish=" + nameSpanish;
    }

} // end class
