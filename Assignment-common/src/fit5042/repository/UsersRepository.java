package fit5042.repository;

import java.util.List;

import javax.ejb.Remote;

import fit5042.repository.entity.Users;


@Remote
public interface UsersRepository {
    public void addUsers(Users user) throws Exception;

    public Users getUsers(int id) throws Exception;

    public List<Users> getAllUsers() throws Exception;
        
    public void deleteUsers(int userID) throws Exception;
    
    public void editUsers(Users users) throws Exception;

	Users searchUsersByUsername(String username);
}
