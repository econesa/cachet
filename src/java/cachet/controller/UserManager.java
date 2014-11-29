package cachet.controller;

import cachet.helper.PersonHelper;
import cachet.model.Person;
import cachet.model.User;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 * <p>A simple managed bean to mediate between the user
 * and the persistence layer.</p>
 * @author econesa
 */
public class UserManager {

    
    public static final String USER_SESSION_KEY = "user";
    
    /**
     * <p>User properties.</p>
     */
    private String username;
    private String password;
    private String passwordv;
    private String fname;
    private String lname;
    private PersonHelper helper;
    
    // -------------------------------------------------------------- Properties
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getPasswordv() {
        return passwordv;
    }
    
    public void setPasswordv(String passwordv) {
        this.passwordv = passwordv;
    }
    
    public String getFname() {
        return fname;
    }
    
    public void setFname(String fname) {
        this.fname = fname;
    }
    
    public String getLname() {
        return lname;
    }
    
    public void setLname(String lname) {
        this.lname = lname;
    }
    
    
    // ---------------------------------------------------------- Public Methods
    
    
    /**
     * <p>Validates the user.  If the user doesn't exist or the password
     * is incorrect, the appropriate message is added to the current
     * <code>FacesContext</code>.  If the user successfully authenticates,
     * navigate them to the page referenced by the outcome <code>app-main</code>.
     * </p>
     *
     * @return <code>app-main</code> if the user authenticates, otherwise
     *  returns <code>null</code>
     */
    public String validateUser() {   
        FacesContext context = FacesContext.getCurrentInstance();
//        Person user = getPerson();
        Person user = getPerson();
        if (user != null) {
            if (!user.getPassword().equals(password)) {
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                           "Login Failed!",
                                           "The password specified is not correct.");
                context.addMessage(null, message);
                return null;
            }
            
            context.getExternalContext().getSessionMap().put(USER_SESSION_KEY, user);
            if(user.getRole().equals("admin")) {
                return "person-list";
            }
            return "app-main";
        } else {           
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Login Failed!",
                    "Username '" + username + "' does not exist.");
            context.addMessage(null, message);
            return null;
        }
    }
    
    /**
     * <p>When invoked, it will invalidate the user's session
     * and move them to the login view.</p>
     *
     * @return <code>login</code>
     */
    public String logout() {
        HttpSession session = (HttpSession)
             FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return "login";
        
    }
    
    // --------------------------------------------------------- Private Methods

    private Person getPerson() {
        Person user = helper.getPerson(username);
        return user;
    }

    // ---------------------------------------------------------   Constructor
    public UserManager() {
        helper = new PersonHelper();
    }


   
}

