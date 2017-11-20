package il.hit.model;
import java.util.List;


/*
 * This interface is implemented in the HibernateToListDAO class.
 */
public interface IToDoListDAO {
	public void addUser(User user) throws ToDoListDAOException;
	public User getUserByUserName(String userName) throws ToDoListDAOException;
	public boolean authenticateUser(String userName,String password) throws ToDoListDAOException; 
	
	public void deleteUser(String userName) throws ToDoListDAOException;
	public void updateUser(User user) throws ToDoListDAOException;
	
	public List<User> getAllUsers() throws ToDoListDAOException;
	
	public void addItem(Items item) throws ToDoListDAOException;
	public void deleteItem(String itemName) throws ToDoListDAOException;
	public void updateItem(Items updateItem, String itemNameToUpdate) throws ToDoListDAOException;
	
	public List<Items> getAllItems() throws ToDoListDAOException;//returns the all items of all users
	public List<Items> getAllItemsPerUser(String userName) throws ToDoListDAOException;

	
}
