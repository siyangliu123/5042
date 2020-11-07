package fit5042.controllers;

import javax.el.ELContext;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import fit5042.mbeans.UsersManagedBean;


@RequestScoped
@Named("removeUsers")
public class RemoveUsers {
    @ManagedProperty(value="#{usersManagedBean}") 
    UsersManagedBean usersManagedBean;
    
    private boolean showForm = true;
    private Users users;
    UsersApplication app;
    
    public void setUsers(Users users){
        this.users = users;
    }
    
    public Users getUsers(){
        return users;
    }
    
    public boolean isShowForm() {
        return showForm;
    }

    public RemoveUsers() {
        ELContext context
                = FacesContext.getCurrentInstance().getELContext();

        app = (UsersApplication) FacesContext.getCurrentInstance()
                        .getApplication()
                        .getELResolver()
                        .getValue(context, null, "usersApplication");
        app.updateUserList();
        
        //instantiate usersManagedBean
        ELContext elContext = FacesContext.getCurrentInstance().getELContext();
        usersManagedBean = (UsersManagedBean) FacesContext.getCurrentInstance().getApplication()
        .getELResolver().getValue(elContext, null, "usersManagedBean");
    }


    public void removeUsers(int userId) {
       try
       {
            usersManagedBean.removeUsers(userId);
            ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
            String username = ec.getRemoteUser();
            app.updateUserList();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Users has been deleted succesfully"));     
       }
       catch (Exception ex)
       {
           
       }
       showForm = true;

    }
 
}

