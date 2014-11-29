package cachet.controller;

import cachet.helper.PaginationHelper;
import cachet.helper.PersonHelper;
import cachet.model.PersonFriends;
import cachet.model.PersonFriendsId;
import cachet.model.PublicPerson;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.servlet.http.HttpSession;

/**
 *
 * @author econesa
 */
@ManagedBean(name="searchFriendBean")
@SessionScoped
public class SearchFriendController {

    private PersonHelper helper;
    private PublicPerson current;
    private DataModel people = null;
    private PaginationHelper pagination;

    @ManagedProperty(value="#{user.personId}")
    private String personId;

    private int selectedItemIndex;
    private int count;

    @ManagedProperty(value="#{sessionScope.keys}")
    private String keys;

    public String getKeys() {
        return keys;
    }

    public void setKeys(String keys) {
        this.keys = keys;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    private int getCount() {
        return count;
    }

    private void recreateModel() {
        people = null;
    }

    public DataModel getPeople() {
        if (keys == null)
            keys ="";
        people = new ListDataModel(helper.findPerson(keys, 1, 1));
        return people;
    }

    public PaginationHelper getPagination() {
        if (pagination == null) {
            pagination = new PaginationHelper(10) {

                @Override
                public int getItemsCount() {
                    return getCount();
                }

                @Override
                public DataModel createPageDataModel() {
                    return new ListDataModel(
                            helper.findPerson(keys, getPageFirstItem(), getPageFirstItem() + getPageSize()));
                }
            };
        }
        return pagination;
    }

    public String next() {
        getPagination().nextPage();
        recreateModel();
        return "List";
    }

    public String previous() {
        getPagination().previousPage();
        recreateModel();
        return "List";
    }

    public String add() {
        current = (PublicPerson) getPeople().getRowData();
        Logger.getLogger(SearchFriendController.class.getName()).log(Level.INFO, "Data: "+personId+" "+current.getPersonId(), "Hola");
//        
//        HttpServletRequest request  = (HttpServletRequest) context.getExternalContext().getRequest();
//        personId = (String) request.getParameter("personId");
//        Logger.getLogger(SearchFriendController.class.getName()).log(Level.INFO, "B: "+personId, "Hola");

        PersonFriends newFriend = new PersonFriends();
        newFriend.setId(new PersonFriendsId(personId, current.getPersonId(), 1));
        newFriend.setPrivileges("all");
        newFriend.setRelationship("Amigos");
        helper.addFriend(newFriend);
        FacesContext context = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
        session.removeAttribute(keys);
        keys = "";
        return "app-main";
    }

    public String prepareView() {
        return null;
    }

    public String prepareList() {
        recreateModel();
        return "List";
    }

    public PublicPerson getSelected() {
        if (current == null) {
            current = new PublicPerson();
            selectedItemIndex = -1;
        }
        return current;
    }

    /** Creates a new instance of SearchFriendController */
    public SearchFriendController() {
        helper = new PersonHelper();
    }
}
