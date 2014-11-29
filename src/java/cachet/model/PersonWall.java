package cachet.model;
// Generated May 21, 2010 6:31:20 PM by Hibernate Tools 3.2.1.GA



/**
 * PersonWall generated by hbm2java
 */
public class PersonWall  implements java.io.Serializable {


     private PersonWallId id;
     private int appId;
     private String message;

    public PersonWall() {
    }

	
    public PersonWall(PersonWallId id, int appId) {
        this.id = id;
        this.appId = appId;
    }
    public PersonWall(PersonWallId id, int appId, String message) {
       this.id = id;
       this.appId = appId;
       this.message = message;
    }
   
    public PersonWallId getId() {
        return this.id;
    }
    
    public void setId(PersonWallId id) {
        this.id = id;
    }
    public int getAppId() {
        return this.appId;
    }
    
    public void setAppId(int appId) {
        this.appId = appId;
    }
    public String getMessage() {
        return this.message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }




}


