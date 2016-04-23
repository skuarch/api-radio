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

/**
 *
 * @author skuarch
 */
@Entity
@Table(name = "language")
@NamedQueries({
    @NamedQuery(name = Language.GET_LANGUAGES, query = "from Language l order by l.name asc")
})
public class Language implements Serializable {

    private static final long serialVersionUID = 3405178041950251807L;
    public static final String GET_LANGUAGES = "Language.getLanguages";

    @Id
    @Column(name = "language_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "language_name", nullable = false)
    private String name = null;

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
    public String getName() {
        return name;
    }

    //==========================================================================
    /**
     * setter.
     *
     * @param name String
     */
    public void setName(String name) {
        this.name = name;
    }

    //==========================================================================
    /**
     * to string.
     *
     * @return String
     */
    @Override
    public String toString() {
        return "id=" + id + " name=" + name;
    }

} // end class
