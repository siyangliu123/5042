package fit5042.mbeans;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import fit5042.repository.UsersRepository;
import fit5042.repository.entity.Users;


@ManagedBean(name = "usersManagedBean")
@SessionScoped
public class UsersManagedBean {
	@EJB
	UsersRepository usersRepository;
	
	
    public void editUsers(Users user)
    {
        try {
        	String password = user.getPassword();
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            digest.reset();
            digest.update(password.getBytes("utf8"));
            String s = String.format("%064x", new BigInteger(1, digest.digest()));
            user.setPassword(s);
        	usersRepository.editUsers(user);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(password));
        } catch (Exception ex) {
            Logger.getLogger(UsersManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public List<Users> getAllUsers() {
		try {
            List<Users> users = usersRepository.getAllUsers();
            return users;
        } catch (Exception ex) {
            Logger.getLogger(UsersManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
	}
    
    public Users searchUsersByUsername() {
    	ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        String username = ec.getRemoteUser();
    	try {
            return usersRepository.searchUsersByUsername(username);
        } catch (Exception ex) {
            Logger.getLogger(UsersManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
    
	public Users getUser(int userID) {
		try {
            return usersRepository.getUsers(userID);
        } catch (Exception ex) {
            Logger.getLogger(UsersManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
	}


	public void addUser(fit5042.controllers.Users localUser) throws UnsupportedEncodingException, NoSuchAlgorithmException {
    	Users user = convertUserToEntity(localUser);
        try {
        	usersRepository.addUsers(user);
        } catch (Exception ex) {
            Logger.getLogger(UsersManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private Users convertUserToEntity(fit5042.controllers.Users localUser) throws UnsupportedEncodingException, NoSuchAlgorithmException {
    	Users user = new Users();
        String username = localUser.getUsername();
        
        String password = localUser.getPassword();
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        digest.reset();
        digest.update(password.getBytes("utf8"));
        String s = String.format("%064x", new BigInteger(1, digest.digest()));
        user.setUsername(username);
        user.setPassword(s);
        return user;
	}


	public void removeUsers(int userId) {
		try {
            usersRepository.deleteUsers(userId);
        } catch (Exception ex) {
            Logger.getLogger(UsersManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
}
