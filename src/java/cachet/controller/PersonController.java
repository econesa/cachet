package cachet.controller;

import cachet.helper.PersonHelper;
import cachet.model.Person;
import java.util.ResourceBundle;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
//import java.util.logging.Level;
//import java.util.logging.Logger;

/**
 *
 * @author econesa
 */
public class PersonController {

    private PersonHelper helper;
    private Person person;

    public Person getPerson() {
        if (person == null) {
            person = new Person();
        }
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String save() {
        person = getPerson();
        person.setRole("user");
//        Logger.getLogger(PersonController.class.getName()).log(Level.INFO, "persona: "+person.getPersonId(), "Hola");
        helper.savePerson(person);
        return "app-main";
    }

    protected String getMessageForKey(String key) {
        FacesContext ctx = FacesContext.getCurrentInstance();
        ResourceBundle rb = ctx.getApplication().getResourceBundle(ctx, "i18n");
        return rb.getString(key);
    }

    protected FacesMessage getFacesMessageForKey(String key) {
        return new FacesMessage(getMessageForKey(key));
    }

    public void validateEmail(FacesContext context, UIComponent component, Object newValue) {
        final String aEmailAddress = (String) newValue;
        if (aEmailAddress == null) {
            return;
        }
        String[] tokens = aEmailAddress.split("@");
        if (tokens != null) {
            if (tokens.length == 2) {
                if (!tokens[0].isEmpty() && !tokens[1].isEmpty()) {
                    return;
                }
            }
        }
        throw new ValidatorException(getFacesMessageForKey("error.email"));
    }

//    public String validate() {"Malo muy mal";//
//        FacesContext context = FacesContext.getCurrentInstance();
//        FacesMessage message;
////        Person user = getPerson();
//        Person p = getPerson();
//        if (p != null) {
//            if (p.getPersonId().isEmpty()) {
//                message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
//                                           "Registro no completado",
//                                           "Debe indicar un Person Id. Ej: miguel.perez");
//                context.addMessage(null, message);
//                return null;
//            }
//            if (p.getName().isEmpty() || p.getSurname().isEmpty()) {
//                message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
//                                           "Registro no completado",
//                                           "Los campos con asterisco (*) son obligatorios");
//                context.addMessage(null, message);
//                return null;
//            }
//            save();
//            return "app-main";
//        } else {
//            message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
//                                           "Registro no completado",
//                                           "Los campos con asterisco (*) son obligatorios");
//            context.addMessage(null, message);
//            return null;
//        }
//    }
    /** Creates a new instance of FriendController */
    public PersonController() {
        helper = new PersonHelper();
    }
}
