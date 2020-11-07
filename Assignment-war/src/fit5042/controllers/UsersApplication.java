package fit5042.controllers;

import java.util.ArrayList;

import javax.el.ELContext;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.annotation.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import fit5042.mbeans.UsersManagedBean;
import fit5042.repository.entity.Users;


@Named(value = "usersApplication")
@ApplicationScoped

public class UsersApplication {
	@ManagedProperty(value="#{usersManagedBean}") 
    UsersManagedBean usersManagedBean;
    
    private ArrayList<Users> usersList;

    private boolean showForm = true;
  
    public boolean isShowForm() {
        return showForm;
    }

    public UsersApplication() throws Exception {       
    	usersList = new ArrayList<>();
        
        ELContext elContext = FacesContext.getCurrentInstance().getELContext();
        usersManagedBean = (UsersManagedBean) FacesContext.getCurrentInstance().getApplication()
        .getELResolver().getValue(elContext, null, "usersManagedBean");
        
        searchAll();
    }

    public ArrayList<Users> getUsers() {
        return usersList;
    }
    
    private void setUsers(ArrayList<Users> newUsers) {
        this.usersList = newUsers;
    }
    
    public void updateUserList()
    {
    	
        if (usersList != null && usersList.size() > 0)
        {
            
        }
        else
        {
        	usersList.clear();
    		for (fit5042.repository.entity.Users user : usersManagedBean.getAllUsers())
            {
    			usersList.add(user);
            }
            setUsers(usersList);
        }
    }
    
    public void searchUserById(int userID)
    {
    	usersList.clear();
        
    	usersList.add(usersManagedBean.getUser(userID));
    }
    

    
    
    public void searchAll()
    {
    	usersList.clear();
        
        for (Users user : usersManagedBean.getAllUsers())
        {
        	usersList.add(user);
        }
        
        setUsers(usersList);
    }
}
