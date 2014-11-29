package cachet.controller;

import cachet.helper.PersonHelper;
import cachet.model.PersonFriends;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 *
 * @author econesa
 */
@ManagedBean(name = "fmanager")
@RequestScoped
public class FriendManager {

    PersonHelper helper;
    PersonFriends current;
    private DataModel people = null;

    @ManagedProperty(value="#{user.personId}")
    private String pid;

    public void setPid(String pid) {
        this.pid = pid;
    }

    public PersonFriends getSelected() {
        if (current == null) {
            current = new PersonFriends();
        }
        return current;
    }

    public DataModel getPeople() {
        people = new ListDataModel(helper.getFriends(pid, 1, 1));
        return people;
    }

    /** Creates a new instance of FriendManager */
    public FriendManager() {
        helper = new PersonHelper();
    }
}
