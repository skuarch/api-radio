package model.bean;

import java.io.Serializable;

/**
 * bean.
 *
 * @author skuarch
 */
public class Genre implements Serializable {

    private static final long serialVersionUID = 940879717204195007L;
    private long id;
    private String name = null;

    //==========================================================================
    /**
     * constructor.
     */
    public Genre() {
    }

    public Genre(long id, String name) {
        this.id = id;
        this.name = name;
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

    public String getName() {
        return name;
    }

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
        return "id=" + id + " name=" + name + " name=" + name;
    }

} // end class
