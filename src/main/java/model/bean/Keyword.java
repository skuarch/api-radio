package model.bean;

import java.io.Serializable;

/**
 * Bean.
 *
 * @author skuarch
 */
public class Keyword implements Serializable {

    private static final long serialVersionUID = 2425278242952231808L;
    private long id;
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
