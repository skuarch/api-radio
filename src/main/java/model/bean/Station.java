package model.bean;


import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * bean.
 *
 * @author skuarch
 */
public class Station implements Serializable {

    private static final long serialVersionUID = 7404172341950854507L;   
    private long id;
    private String name = null;
    private String urlStreaming = null;
    private String website = null;
    private List<model.persistence.Keyword> keyword = null;
    private List<Genre> genre;
    private String description = null;
    private List<Language> language = null;
    private String frecuencie = null;
    private byte active = 1;
    private Country country = null;
    private model.persistence.StationType stationType = null;
    private int clicks = 0;
    private String modulating = null;
    private int position = 0;
    private String creationDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    private byte isSoftDeleted = 0;

    //==========================================================================
    /**
     * create a instance.
     */
    public Station() {
    }

    //==========================================================================
    /**
     * getter.
     *
     * @return long
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
     * @return String
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
     * getter.
     *
     * @return String
     */
    public String getUrlStreaming() {
        return urlStreaming;
    }

    //==========================================================================
    /**
     * setter.
     *
     * @param urlStreaming String
     */
    public void setUrlStreaming(String urlStreaming) {
        this.urlStreaming = urlStreaming;
    }

    //==========================================================================
    /**
     * getter.
     *
     * @return String
     */
    public String getWebsite() {
        return website;
    }

    //==========================================================================
    /**
     * setter.
     *
     * @param website String
     */
    public void setWebsite(String website) {
        this.website = website;
    }

    //==========================================================================
    /**
     * getter.
     *
     * @return List
     */
    public List<model.persistence.Keyword> getKeyword() {
        return keyword;
    }

    //==========================================================================
    /**
     * setter.
     *
     * @param keyword List
     */
    public void setKeyword(List<model.persistence.Keyword> keyword) {
        this.keyword = keyword;
    }

    //==========================================================================
    /**
     * getter.
     *
     * @return List
     */
    public List<Genre> getGenre() {
        return genre;
    }

    //==========================================================================
    /**
     * setter.
     *
     * @param genre List
     */
    public void setGenre(List<Genre> genre) {
        this.genre = genre;
    }

    //==========================================================================
    /**
     * getter.
     *
     * @return String
     */
    public String getDescription() {
        return description;
    }

    //==========================================================================
    /**
     * setter.
     *
     * @param description String
     */
    public void setDescription(String description) {
        this.description = description;
    }

    //==========================================================================
    /**
     * getter.
     *
     * @return language List
     */
    public List<Language> getLanguage() {
        return language;
    }

    //==========================================================================
    /**
     * setter.
     *
     * @param language List
     */
    public void setLanguage(List<Language> language) {
        this.language = language;
    }

    //==========================================================================
    /**
     * getter.
     *
     * @return String
     */
    public String getFrecuencie() {
        return frecuencie;
    }

    //==========================================================================
    /**
     * setter.
     *
     * @param frecuencie String
     */
    public void setFrecuencie(String frecuencie) {
        this.frecuencie = frecuencie;
    }

    //==========================================================================
    /**
     * getter.
     *
     * @return byte
     */
    public byte getActive() {
        return active;
    }

    //==========================================================================
    /**
     * setter.
     *
     * @param active byte
     */
    public void setActive(byte active) {
        this.active = active;
    }

    //==========================================================================
    /**
     * getter.
     *
     * @return Country
     */
    public Country getCountry() {
        return country;
    }

    //==========================================================================
    /**
     * setter.
     *
     * @param country Country.
     */
    public void setCountry(Country country) {
        this.country = country;
    }

    //==========================================================================
    /**
     * getter.
     *
     * @return StationType
     */
    public model.persistence.StationType getStationType() {
        return stationType;
    }

    //==========================================================================
    /**
     * setter.
     *
     * @param stationType StationType
     */
    public void setStationType(model.persistence.StationType stationType) {
        this.stationType = stationType;
    }

    //==========================================================================
    /**
     * getter.
     *
     * @return int
     */
    public int getClicks() {
        return clicks;
    }

    //==========================================================================
    /**
     * setter.
     *
     * @param clicks int
     */
    public void setClicks(int clicks) {
        this.clicks = clicks;
    }

    //==========================================================================
    /**
     * getter.
     *
     * @return String
     */
    public String getModulating() {
        return modulating;
    }

    //==========================================================================
    /**
     * setter.
     *
     * @param modulating String
     */
    public void setModulating(String modulating) {
        this.modulating = modulating;
    }

    //==========================================================================
    /**
     * getter.
     *
     * @return int
     */
    public int getPosition() {
        return position;
    }

    //==========================================================================
    /**
     * setter.
     *
     * @param position int
     */
    public void setPosition(int position) {
        this.position = position;
    }

    //==========================================================================
    /**
     * getter.
     *
     * @return byte
     */
    public byte getIsSoftDeleted() {
        return isSoftDeleted;
    }

    //==========================================================================
    /**
     * setter.
     *
     * @param isSoftDeleted byte.
     */
    public void setIsSoftDeleted(byte isSoftDeleted) {
        this.isSoftDeleted = isSoftDeleted;
    }

    //==========================================================================
    /**
     * getter.
     *
     * @return creationDate.
     */
    public String getCreationDate() {
        return creationDate;
    }

    //==========================================================================
    /**
     * setter.
     *
     * @param creationDate String
     */
    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    //==========================================================================
    @Override
    public String toString() {
        return "id=" + id + " name=" + name + " urlStreaming=" + urlStreaming + " description= " + description + " keyword=" + keyword + " website=" + website + " frecuencie=" + frecuencie + " modulating=" + modulating + " active=" + active + " clicks=" + clicks + " country=" + country + " genre=" + genre + " position=" + position + " isSoftDeleted=" + isSoftDeleted;
    }
} // end class
