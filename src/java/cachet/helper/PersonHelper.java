/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cachet.helper;

import cachet.model.Person;
import cachet.model.PersonFriends;
import cachet.model.PublicPerson;
import cachet.utils.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author econesa
 */
public class PersonHelper {

    Session session = null;

    public Person getPerson(String personId) {
        Person person = null;
        try {
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Person as person where person.personId = '"+personId+"'");
            person = (Person) q.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return person;
    }

    public List<PublicPerson> findPerson(String keys, int n, int m){
        String k = keys;
        List<PublicPerson> people = null;
        try {
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Person as p where p.personId = '"+k+"'"+
                    " or p.name like '%"+k+"%' or p.surname like '%"+k+"%'");
            people = (List<PublicPerson>) q.list();

//            Logger.getLogger(PersonHelper.class.getName()).log(Level.INFO, "P: "+people.get(0).getPersonId(), "Hola");

            return people;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<PersonFriends> getFriends(String pid, int n, int m){
        String id = pid;
        List<PersonFriends> people = null;
        try {
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from PersonFriends as p where p.id.personId = '"+id+"'");
            people = (List<PersonFriends>) q.list();
            return people;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addFriend(PersonFriends newFriend) {
        PersonFriends friend = newFriend;
        try {
            org.hibernate.Transaction tx = session.beginTransaction();
            session.save(friend);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updatePerson(Person person) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public void savePerson(Person newPerson) {
        Person person = newPerson;
        try {
            org.hibernate.Transaction tx = session.beginTransaction();
            session.save(person);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /////////////////////////////////////////////////////////   Constructor
    public PersonHelper() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

}
