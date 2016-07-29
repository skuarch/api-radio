package model.bean;

import java.io.Serializable;

/**
 *
 * @author skuarch
 */
public class Language implements Serializable {

    private static final long serialVersionUID = 3405178041950251807L;
    private long id;
    private String name = null;

    //==========================================================================
    /**
     * Constructor.
     */
    public Language() {
    }

    public Language(long id, String name) {
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
