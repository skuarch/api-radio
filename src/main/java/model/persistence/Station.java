package model.persistence;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * bean.
 *
 * @author skuarch
 */
@Entity
@Table(name = "station")
@NamedQueries({
    @NamedQuery(name = Station.GET_STATION_BY_NAME, query = "from Station s where s.isSoftDeleted = 0 and s.name = ?1 order by s.position desc"),
    @NamedQuery(name = Station.GET_ACTIVE_STATION_BY_NAME, query = "from Station s where s.isSoftDeleted = 0 and s.active = 1 order by s.position desc"),
    @NamedQuery(name = Station.GET_STATIONS, query = "from Station s where s.isSoftDeleted = 0 order by s.position desc"),
    @NamedQuery(name = Station.GET_ACTIVE_STATIONS, query = "from Station s where s.active = 1 and s.isSoftDeleted = 0"),
    @NamedQuery(name = Station.GET_STATIONS_BY_ORDER, query = "from Station s where s.isSoftDeleted = 0"),
    @NamedQuery(name = Station.GET_ACTIVE_STATIONS_BY_ORDER, query = "from Station s where s.isSoftDeleted = 0 and s.active = 1")
})
public class Station implements Serializable {

    private static final long serialVersionUID = 7404172341950854507L;
    public static final String GET_STATION_BY_NAME = "Station.getStationByName";
    public static final String GET_ACTIVE_STATION_BY_NAME = "Station.getActiveStationByName";
    public static final String GET_STATIONS = "Station.getStations";
    public static final String GET_ACTIVE_STATIONS = "Station.getActiveStations";
    public static final String GET_STATIONS_BY_ORDER = "Station.getStationsByOrder";
    public static final String GET_ACTIVE_STATIONS_BY_ORDER = "Station.getActiveStationsByOrder";

    @Id
    @Column(name = "station_id", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @NotEmpty
    @Column(name = "station_name", unique = true, nullable = false)
    private String name = null;

    @NotNull
    @NotEmpty
    @Column(name = "station_url_streaming", unique = true, nullable = false)
    private String urlStreaming = null;

    @Column(name = "station_website")
    private String website = null;

    @NotNull
    @OneToMany(fetch = FetchType.LAZY, targetEntity = Keyword.class)
    @Fetch(FetchMode.JOIN)
    @JoinTable(name = "station_keyword",
            joinColumns = {
                @JoinColumn(name = "station_id", unique = false, nullable = false, updatable = false)},
            inverseJoinColumns = {
                @JoinColumn(name = "keyword_id", unique = false, nullable = false, updatable = false)}
    )
    private List<Keyword> keyword = null;

    @NotNull
    @OneToMany(fetch = FetchType.LAZY, targetEntity = Genre.class)
    @Fetch(FetchMode.JOIN)
    @JoinTable(name = "station_genre",
            joinColumns = {
                @JoinColumn(name = "station_id", unique = false, nullable = false, updatable = false)},
            inverseJoinColumns = {
                @JoinColumn(name = "genre_id", unique = false, nullable = false, updatable = false)}
    )
    private List<Genre> genre;

    @NotNull
    @Column(name = "station_description")
    private String description = null;

    @NotNull
    @OneToMany(fetch = FetchType.LAZY, targetEntity = Language.class)
    @Fetch(FetchMode.JOIN)
    @JoinTable(name = "station_language",
            joinColumns = {
                @JoinColumn(name = "station_id", unique = false, nullable = false, updatable = false)},
            inverseJoinColumns = {
                @JoinColumn(name = "language_id", unique = false, nullable = false, updatable = false)}
    )
    private List<Language> language = null;

    @Column(name = "station_frecuencie")
    private String frecuencie = null;

    @Column(name = "station_active")
    private byte active = 1;

    @NotNull
    @OneToOne
    @JoinColumn(name = "station_country_id", nullable = false)
    private Country country = null;

    @NotNull
    @OneToOne
    @JoinColumn(name = "station_type_id", nullable = false)
    private StationType stationType = null;

    @Column(name = "station_clicks")
    private int clicks = 0;

    @Column(name = "station_modulating")
    private String modulating = null;

    @Column(name = "station_position")
    private int position = 0;

    @Column(name = "station_creation_date")
    private String creationDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

    @Column(name = "station_is_soft_deleted", nullable = false, columnDefinition = "int(1) default 0")
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
        if (id < 1) {
            throw new IllegalArgumentException("id is less than 0");
        }
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
        if (name == null || name.length() < 1) {
            throw new IllegalArgumentException("name is empty or null");
        }
        this.name = name.trim();
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
        if (urlStreaming == null || urlStreaming.length() < 1 || !urlStreaming.contains("http://")) {
            throw new IllegalArgumentException("urlStreaming is empty, null or doesn't contains the http protocol");
        }
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
    public List<Keyword> getKeyword() {
        return keyword;
    }

    //==========================================================================
    /**
     * setter.
     *
     * @param keyword List
     */
    public void setKeyword(List<Keyword> keyword) {
        if (keyword == null) {
            throw new IllegalArgumentException("keyword is empty or null");
        }
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
        if (genre == null) {
            throw new IllegalArgumentException("genre is null");
        }
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
        if (language == null) {
            throw new IllegalArgumentException("language is null");
        }
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
        if (active < 0 || active > 1) {
            throw new IllegalArgumentException("active is incorrect just 0 or 1 are allowed");
        }
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
        if (country == null) {
            throw new IllegalArgumentException("country is null");
        }
        this.country = country;
    }

    //==========================================================================
    /**
     * getter.
     *
     * @return StationType
     */
    public StationType getStationType() {
        return stationType;
    }

    //==========================================================================
    /**
     * setter.
     *
     * @param stationType StationType
     */
    public void setStationType(StationType stationType) {
        if (stationType == null) {
            throw new IllegalArgumentException("stationType is null");
        }
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
