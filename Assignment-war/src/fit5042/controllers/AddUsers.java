package fit5042.controllers;

import javax.el.ELContext;
import javax.enterprise.context.RequestScoped;
import javax.faces.annotation.ManagedProperty;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import fit5042.mbeans.UsersManagedBean;


@RequestScoped
@Named("addUsers")
public class AddUsers {
    @ManagedProperty(value="#{usersManagedBean}") 
    UsersManagedBean usersManagedBean;
    
    private boolean showForm = true;

    private Users users;
    
    UsersApplication app;
    
    public void setUsers(Users Users){
        this.users = Users;
    }
    
    public Users getUsers(){
        return users;
    }
    
    public boolean isShowForm() {
        return showForm;
    }

    public AddUsers() 
    {
        ELContext context
                = FacesContext.getCurrentInstance().getELContext();

        app  = (UsersApplication) FacesContext.getCurrentInstance()
                        .getApplication()
                        .getELResolver()
                        .getValue(context, null, "usersApplication");
        
        ELContext elContext = FacesContext.getCurrentInstance().getELContext();
        usersManagedBean = (UsersManagedBean) FacesContext.getCurrentInstance().getApplication()
        .getELResolver().getValue(elContext, null, "usersManagedBean");
    }

    public void addUsers(fit5042.controllers.Users localUser) {
 	   
       try
       {
    	   usersManagedBean.addUser(localUser);
           app.searchAll();
           FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("User has been added succesfully"));
       }
       catch (Exception ex)
       {
           
       }
        showForm = true;
    }
   
}

