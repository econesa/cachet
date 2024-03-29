package cachet.model;
// Generated May 21, 2010 6:31:20 PM by Hibernate Tools 3.2.1.GA



/**
 * PersonAppId generated by hbm2java
 */
public class PersonAppId  implements java.io.Serializable {


     private String personId;
     private int appId;

    public PersonAppId() {
    }

    public PersonAppId(String personId, int appId) {
       this.personId = personId;
       this.appId = appId;
    }
   
    public String getPersonId() {
        return this.personId;
    }
    
    public void setPersonId(String personId) {
        this.personId = personId;
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
		 if ( !(other instanceof PersonAppId) ) return false;
		 PersonAppId castOther = ( PersonAppId ) other; 
         
		 return ( (this.getPersonId()==castOther.getPersonId()) || ( this.getPersonId()!=null && castOther.getPersonId()!=null && this.getPersonId().equals(castOther.getPersonId()) ) )
 && (this.getAppId()==castOther.getAppId());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getPersonId() == null ? 0 : this.getPersonId().hashCode() );
         result = 37 * result + this.getAppId();
         return result;
   }   


}


