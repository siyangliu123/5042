package fit5042.controllers;

import javax.el.ELContext;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;


@Named(value = "usersController")
@RequestScoped
public class UsersController {

    private int userID;
    
    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
    private fit5042.repository.entity.Users user;
    

    public UsersController() {
    	userID = Integer.valueOf(FacesContext.getCurrentInstance()
                .getExternalContext()
                .getRequestParameterMap()
                .get("userID"));
        user = getUser();
    }

    public fit5042.repository.entity.Users getUser() {
        if (user == null) {
            ELContext context
                    = FacesContext.getCurrentInstance().getELContext();
            UsersApplication app
                    = (UsersApplication) FacesContext.getCurrentInstance()
                            .getApplication()
                            .getELResolver()
                            .getValue(context, null, "usersApplication");
            return app.getUsers().get(--userID); 
        }
        return user;
    }
}
