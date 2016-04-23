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
 * Bean.
 *
 * @author skuarch
 */
@Entity
@Table(name = "keyword")
@NamedQueries({
    @NamedQuery(name = Keyword.GET_KEYWORDS, query = "from Keyword k order by k.name asc"),
    @NamedQuery(name = Keyword.FIND_BY_NAME, query = "from Keyword k where k.name = ?1")
})
public class Keyword implements Serializable {

    private static final long serialVersionUID = 2425278242952231808L;
    public static final String GET_KEYWORDS = "Keyword.getKeywords";
    public static final String FIND_BY_NAME = "Keyword.findByName";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "keyword_id")
    private long id;

    @Column(name = "keyword_name")
    private String name;

    /**
     * constructor.
     */
    public Keyword() {
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
     *
     * @param name String
     */
    public void setName(String name) {
        this.name = name;
    }

}
