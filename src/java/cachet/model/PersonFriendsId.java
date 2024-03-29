package cachet.model;
// Generated May 21, 2010 6:31:20 PM by Hibernate Tools 3.2.1.GA



/**
 * PersonFriendsId generated by hbm2java
 */
public class PersonFriendsId  implements java.io.Serializable {


     private String personId;
     private String friendId;
     private int appId;

    public PersonFriendsId() {
    }

    public PersonFriendsId(String personId, String friendId, int appId) {
       this.personId = personId;
       this.friendId = friendId;
       this.appId = appId;
    }
   
    public String getPersonId() {
        return this.personId;
    }
    
    public void setPersonId(String personId) {
        this.personId = personId;
    }
    public String getFriendId() {
        return this.friendId;
    }
    
    public void setFriendId(String friendId) {
        this.friendId = friendId;
    }
    public int getAppId() {
        return this.appId;
    }
    
    public void setAppId(int appId) {
        this.appId = appId;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof PersonFriendsId) ) return false;
		 PersonFriendsId castOther = ( PersonFriendsId ) other; 
         
		 return ( (this.getPersonId()==castOther.getPersonId()) || ( this.getPersonId()!=null && castOther.getPersonId()!=null && this.getPersonId().equals(castOther.getPersonId()) ) )
 && ( (this.getFriendId()==castOther.getFriendId()) || ( this.getFriendId()!=null && castOther.getFriendId()!=null && this.getFriendId().equals(castOther.getFriendId()) ) )
 && (this.getAppId()==castOther.getAppId());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getPersonId() == null ? 0 : this.getPersonId().hashCode() );
         result = 37 * result + ( getFriendId() == null ? 0 : this.getFriendId().hashCode() );
         result = 37 * result + this.getAppId();
         return result;
   }   


}


