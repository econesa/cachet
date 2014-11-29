package cachet.model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author econesa
 */
public class User implements Serializable {

    private Integer id;

    private String firstname;

    private String lastname;

    private String username;

    private String password;

    private String email;

    private Date since;

    /** Creates a new instance of Wuser */
    public User() {
    }

    public User(Integer id) {
        this.id = id;
    }

    public User(Integer id, String firstname, String lastname, String username, String password) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return this.lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getSince() {
        return this.since;
    }

    public void setSince(Date since) {
        this.since = since;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || !this.getClass().equals(object.getClass())) {
            return false;
        }
        User other = (User)object;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) return false;
        return true;
    }

    @Override
    public String toString() {
        //TODO change toString() implementation to return a better display name
        return "" + this.id;
    }

}
