package model.bean;

import java.io.Serializable;

/**
 *
 * @author skuarch
 */
public class Country implements Serializable {

    private static final long serialVersionUID = 7461217241950251807L;
    private long id;
    private String name = null;

    //==========================================================================
    /**
     * constructor.
     */
    public Country() {
    }

    //==========================================================================
    public Country(long id, String name) {
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
     * toString.
     *
     * @return String
     */
    @Override
    public String toString() {
        return "id=" + id + " name=" + name;
    }

} // end class
