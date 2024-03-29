package cachet.model;
// Generated May 21, 2010 6:31:20 PM by Hibernate Tools 3.2.1.GA


import java.util.Date;

/**
 * PersonFriends generated by hbm2java
 */
public class PersonFriends  implements java.io.Serializable {


     private PersonFriendsId id;
     private String relationship;
     private String privileges;
     private Date updated;

    public PersonFriends() {
    }

	
    public PersonFriends(PersonFriendsId id) {
        this.id = id;
    }
    public PersonFriends(PersonFriendsId id, String relationship, String privileges, Date updated) {
       this.id = id;
       this.relationship = relationship;
       this.privileges = privileges;
       this.updated = updated;
    }
   
    public PersonFriendsId getId() {
        return this.id;
    }
    
    public void setId(PersonFriendsId id) {
        this.id = id;
    }
    public String getRelationship() {
        return this.relationship;
    }
    
    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }
    public String getPrivileges() {
        return this.privileges;
    }
    
    public void setPrivileges(String privileges) {
        this.privileges = privileges;
    }
    public Date getUpdated() {
        return this.updated;
    }
    
    public void setUpdated(Date updated) {
        this.updated = updated;
    }




}


