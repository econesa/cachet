package cachet.model;
// Generated May 21, 2010 6:31:20 PM by Hibernate Tools 3.2.1.GA


import java.util.Date;

/**
 * Person generated by hbm2java
 */
public class Person extends PublicPerson implements java.io.Serializable {

     private String password;
     private String role;
     private String relationshipStatus;
     private String email;
     private String aboutMe;
     private String books;
     private String music;
     private String movies;
     private Date birthdate;
     private Date updated;

    public Person() {
    }

	
    public Person(String personId, String name, String surname) {
        this.personId = personId;
        this.name = name;
        this.surname = surname;
    }
    public Person(String personId, String password, String role, String name, String surname, String relationshipStatus, String sexualOrientation, String gender, String email, String aboutMe, String books, String music, String movies, Date birthdate, Date updated) {
       this.personId = personId;
       this.password = password;
       this.role = role;
       this.name = name;
       this.surname = surname;
       this.relationshipStatus = relationshipStatus;
       this.sexualOrientation = sexualOrientation;
       this.gender = gender;
       this.email = email;
       this.aboutMe = aboutMe;
       this.books = books;
       this.music = music;
       this.movies = movies;
       this.birthdate = birthdate;
       this.updated = updated;
    }
   
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public String getRole() {
        return this.role;
    }
    
    public void setRole(String role) {
        this.role = role;
    }
    
    public String getRelationshipStatus() {
        return this.relationshipStatus;
    }
    
    public void setRelationshipStatus(String relationshipStatus) {
        this.relationshipStatus = relationshipStatus;
    }
    
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public String getAboutMe() {
        return this.aboutMe;
    }
    
    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }
    public String getBooks() {
        return this.books;
    }
    
    public void setBooks(String books) {
        this.books = books;
    }
    public String getMusic() {
        return this.music;
    }
    
    public void setMusic(String music) {
        this.music = music;
    }
    public String getMovies() {
        return this.movies;
    }
    
    public void setMovies(String movies) {
        this.movies = movies;
    }
    public Date getBirthdate() {
        return this.birthdate;
    }
    
    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }
    public Date getUpdated() {
        return this.updated;
    }
    
    public void setUpdated(Date updated) {
        this.updated = updated;
    }

}


