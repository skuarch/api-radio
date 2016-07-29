package model.persistence;

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
@Table(name = "user")
@NamedQueries({
    @NamedQuery(name = User.GET_USER, query = "from User u where u.email = ?1 and u.password = ?2")
})
public class User implements Serializable {

    public static final String GET_USER = "User.getUser";
    private static final long serialVersionUID = 350175341955852557L;
    private static final byte MAX_PASSWORD_LENGTH = 32;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private long id;

    @NotNull
    @NotEmpty
    @Column(name = "user_email")
    private String email;

    @NotNull
    @NotEmpty
    @Column(name = "user_password")
    private String password;

    @Column(name = "user_is_soft_deleted", nullable = false, columnDefinition = "int(1) default 0")
    private byte isSoftDeleted = 0;

    @Column(name = "user_is_active", nullable = false, columnDefinition = "int(1) default 0")
    private byte isActive = 1;

    //==========================================================================
    /**
     * constructor.
     */
    public User() {
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
    public String getEmail() {
        return email;
    }

    //==========================================================================
    /**
     * setter.
     *
     * @param email String
     */
    public void setEmail(String email) {
        this.email = email;
    }

    //==========================================================================
    /**
     * getter.
     *
     * @return String
     */
    public String getPassword() {
        return password;
    }

    //==========================================================================
    /**
     * setter.
     *
     * @param password String
     */
    public void setPassword(String password) {
        if (password.length() != MAX_PASSWORD_LENGTH) {
            throw new IllegalArgumentException("length of the password is incorrect");
        }
        this.password = password;
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
     * @param isSoftDeleted byte
     */
    public void setIsSoftDeleted(byte isSoftDeleted) {
        this.isSoftDeleted = isSoftDeleted;
    }

    //==========================================================================
    /**
     * getter.
     *
     * @return byte
     */
    public byte getIsActive() {
        return isActive;
    }

    //==========================================================================
    /**
     * setter.
     *
     * @param isActive byte
     */
    public void setIsActive(byte isActive) {
        this.isActive = isActive;
    }

}
