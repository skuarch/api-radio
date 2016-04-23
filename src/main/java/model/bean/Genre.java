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
 * bean.
 *
 * @author skuarch
 */
@Entity
@Table(name = "genre")
@NamedQueries({
    @NamedQuery(name = Genre.GET_GENRES, query = "from Genre g order by g.name asc"),
    @NamedQuery(name = Genre.FIND_BY_NAME, query = "from Genre g where g.name = ?1")
})
public class Genre implements Serializable {

    private static final long serialVersionUID = 940879717204195007L;
    public static final String GET_GENRES = "Genre.getGenres";
    public static final String FIND_BY_NAME = "Genre.findByName";

    @Id
    @Column(name = "genre_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "genre_name", nullable = false)
    private String name = null;

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
