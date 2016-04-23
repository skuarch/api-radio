package model.bean;

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
    @NamedQuery(name = Country.GET_COUNTRIES, query = "from Country c order by c.name asc")
})
public class Country implements Serializable {

    private static final long serialVersionUID = 7461217241950251807L;
    public static final String GET_COUNTRIES = "Country.getCountries";

    @Id
    @Column(name = "country_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @NotEmpty
    @Column(name = "country_name", nullable = false)
    private String name = null;

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
    /**
     * getter.
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    //==========================================================================
    /**
     * setter.
     * @param name String
     */
    public void setName(String name) {
        this.name = name;
    }

    //==========================================================================
    /**
     * toString.
     *
     * @return String
     */
    @Override
    public String toString() {
        return "id=" + id + " name=" + name;
    }

} // end class
