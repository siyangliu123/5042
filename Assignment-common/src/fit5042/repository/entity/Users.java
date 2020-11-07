package fit5042.repository.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "Users")
@NamedQueries({@NamedQuery(name = Users.GET_ALL_QUERY_NAME, query = "SELECT u FROM Users u")})
public class Users implements Serializable{
	public static final String GET_ALL_QUERY_NAME = "Users.getAll";
	
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "ID")
	private int userID;
    @Column
	private String username;
    @Column
	private String password;
    
    public Users() {
    	
    }

	public Users(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
    
    

}
