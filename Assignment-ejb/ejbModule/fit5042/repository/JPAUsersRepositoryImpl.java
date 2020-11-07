package fit5042.repository;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import fit5042.repository.entity.Users;

@Stateless
public class JPAUsersRepositoryImpl implements UsersRepository{
    @PersistenceContext(unitName = "Assignment")
    private EntityManager entityManager;
	
	@Override
	public void addUsers(Users user) throws Exception {		
        entityManager.persist(user);
        entityManager.createNativeQuery("INSERT INTO GROUPS (GROUPNAME, USERNAME) VALUES (?,?)")
        .setParameter(1, "customer")
        .setParameter(2, user.getUsername())
        .executeUpdate();
	}

	@Override
	public Users getUsers(int id) throws Exception {
		Users user = entityManager.find(Users.class, id);
        return user;
	}

	@Override
	public List<Users> getAllUsers() throws Exception {
    	List<Users> users =  entityManager.createNamedQuery(Users.GET_ALL_QUERY_NAME).getResultList(); 
   		return users;
	}

	@Override
	public void deleteUsers(int userID) throws Exception {
		Users user = this.getUsers(userID);

        if (user != null) {
            entityManager.remove(user);
        }
	}

	@Override
	public void editUsers(Users users) throws Exception {
		try {
            entityManager.merge(users);
        } catch (Exception ex) {
            
        }
	}
	
    @Override
	public Users searchUsersByUsername(String username) {
    	TypedQuery<Users> query =
      			 entityManager.createQuery("SELECT u FROM Users u where u.username = :username", Users.class);
    	query.setParameter("username", username);
      	Users results = query.getSingleResult();
      	return results;
	}

}
