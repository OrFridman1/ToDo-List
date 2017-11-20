package il.hit.model;


import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import il.hit.model.User;
import org.hibernate.cfg.AnnotationConfiguration;
import il.hit.model.Items;

/*
 * This class implements the interface IToDoListDAO
 * the class using the singleton pattern. 
 *  We create connection to the database by using session,
 *  and then we define new transaction.
 *  In this transaction we do all the relevant actions for the relevant method.
 *  
 *  @member factory defines the sessionFactory according 
 *  the hibernate.cfg.xml.
 *  
 *  @member HibernateToListDAO is the instance of the class
 */

public class HibernateToListDAO implements IToDoListDAO {
	
	private SessionFactory factory = null;
	private static HibernateToListDAO _instanceDAO;
	/*
	 * The constractor of the class,
	 * create SessionFactory(Singleton) according to the hibernate.cfg.xml.
	 * This xml file contains the settings of the connection to the database.
	 */
	private HibernateToListDAO(){
		factory = new AnnotationConfiguration().addPackage("il.hit.model") //the fully qualified package name
                .addAnnotatedClass(User.class).addAnnotatedClass(Items.class)
                .addResource("hibernate.cfg.xml").configure().buildSessionFactory();
	}
	
	/*
	 * Return the instance of the class  
	 */
	public static HibernateToListDAO getInstance()
	{
		if(_instanceDAO == null) {
			_instanceDAO = new HibernateToListDAO();
	      }
		return _instanceDAO;
	}

	/*
	 * This method adding user to the database
	 * @param user is the user we adding to the database
	 */
	@Override
	public void addUser(User user) throws ToDoListDAOException{
		Session session = factory.openSession();
		try
		{
			session.beginTransaction();
			session.save(user);
			session.getTransaction().commit();
		}
		catch (HibernateException e)
		{
			e.printStackTrace();
			if(session.getTransaction()!=null) session.getTransaction().rollback();
		}
		finally
		{
			if(session != null) 
			{ 
				session.close(); 
			}
		}
	}
	
	/*
	 * This method return user object by his username
	 * @param userName help us to identify the user object. 
	 */
	public User getUserByUserName(String userName) throws ToDoListDAOException{
	
		Session session = factory.openSession();
        Transaction tx = null;
        User user = new User();
        int flag=0;
        List<User> allUsers = new ArrayList<User>();
        try {
            tx = session.getTransaction();
            tx.begin();
            allUsers = session.createQuery("from User").list();
            for (User singleUser : allUsers) {
				if(singleUser.getUserName().equals(userName)){
					user.setUserName(singleUser.getUserName());
			        user.setPassword(singleUser.getPassword());
			        user.setEmail(singleUser.getEmail());
					flag=1;
			        break;
				}
			}
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
        	if(session != null) 
			{ 
				session.close(); 
			}
        }
    if(flag==0)
    	user.setUserName("---");
       	
   	return user;
    
	}
	
	/*
	 * Return true if the user is exist in the database and the user input is correct,
	 * else return false.
	 * @param  userName , user input
	 * @param  password , user input
	 */
	public boolean authenticateUser(String userName,String password) throws ToDoListDAOException{
		
		 User user = getUserByUserName(userName);    
		 System.out.println(userName + "  " + password);
	     if(user!=null && user.getUserName().equals(userName) && user.getPassword().equals(password)){
	            return true;
	        }else{
	            return false;
	        }
		
	}

	/*
	 * This method deleting user from the database
	 * @param userName is the user we deleting from the database
	 */
	@Override
	public void deleteUser(String userName) throws ToDoListDAOException{
		Session session = factory.openSession();

		try
		{
		  session.beginTransaction();
	   	  Query query = session.createQuery("delete from User where userName = :user");
	   	  query.setParameter("user", userName);
	   	  int id= query.executeUpdate();
	   	  System.out.println(id);

	   	  session.getTransaction().commit();
		}
		catch (HibernateException e)
		{
			e.printStackTrace();
			if(session.getTransaction()!=null) session.getTransaction().rollback();
		}
		finally
		{
			if(session != null) 
			{ 
				session.close(); 
			}
		}		
	}

	/*
	 * Return all the existing users in the database  
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUsers() throws ToDoListDAOException{
		Session session = factory.openSession();
		
		List<User> allUsers = new ArrayList<User>();
		
		try
		{
			session.beginTransaction();
			allUsers = session.createQuery("from User").list();
			session.getTransaction().commit();
		}
		catch (HibernateException e)
		{
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		finally
		{
			if(session != null) 
			{ 
				session.close(); 
			}
		}
		
		return allUsers;
	}
	
	/*
	 * Return all the existing items in the database  
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Items> getAllItems() throws ToDoListDAOException{
		
		Session session = factory.openSession();
		
		List<Items> allDoList = new ArrayList<Items>();
		
		try
		{
			session.beginTransaction();
			allDoList = session.createQuery("from Items").list();
			session.getTransaction().commit();
		}
		catch (HibernateException e)
		{
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		finally
		{
			if(session != null) 
			{ 
				session.close(); 
			}
		}
		
		return allDoList;
	}
	
	
	/*
	 * Return all the existing items(into list) for each user in the database
	 * @param userName, return the items for this user
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Items> getAllItemsPerUser(String userName) throws ToDoListDAOException{
	Session session = factory.openSession();
		
		List<Items> allDoList = new ArrayList<Items>();
		List<Items> userItemList = new ArrayList<Items>();
		
		
		try
		{
			session.beginTransaction();
			allDoList = session.createQuery("from Items").list();
			for (Items item : allDoList) {
				if(item.getUserName().equals(userName))
					userItemList.add(item);
			
			}
			
			session.getTransaction().commit();
		}
		catch (HibernateException e)
		{
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		finally
		{
			if(session != null) 
			{ 
				session.close(); 
			}
		}
		
		return userItemList;
	}

	/*
	 * update the user details in the database
	 * @param user, this user we updating. 
	 */
	@Override
	public void updateUser(User user) throws ToDoListDAOException{
		// TODO Auto-generated method stub
		 Session session = factory.openSession();
		   try
		   {
		    session.beginTransaction();
		     Query query = session.createQuery("from User where userName = :user");
		     User ifUserExist =(User) query.setParameter("user",user.getUserName()).uniqueResult();
		     long id = ifUserExist.getId();
		    Query query2 = session.createQuery("UPDATE User SET password = :pass , userName= :user" +
		    " where id = :d");
		    query2.setParameter("pass", user.getPassword());
		    query2.setParameter("user", user.getUserName());
		    query2.setParameter("d", id);
		    query2.executeUpdate();
		    session.getTransaction().commit();
		    
		   }
		   catch (HibernateException e)
		   {
		    e.printStackTrace();
		    if(session.getTransaction()!=null) session.getTransaction().rollback();
		   }
		   finally
		   {
			   if(session != null) 
				{ 
					session.close(); 
				} 
		   }  
	}

	/*
	 * Adding item to the database per user.
	 * @param item, this item we add to the database.
	 */
	@Override
	public void addItem(Items item) throws ToDoListDAOException{
		// TODO Auto-generated method stub
		   Session session = factory.openSession();
		   List<Items> allItems = new ArrayList<Items>();
		   int flag=0;
		   try
		   {
			   allItems = session.createQuery("from Items").list();
			   for (Items item1 : allItems) {
					if(item1.getUserName().equals(item.getUserName()) && item1.getItemName().equals(item.getItemName())){
						flag=1;
						JOptionPane.showMessageDialog(null, "You need to choose other name for this task", "Error", JOptionPane.INFORMATION_MESSAGE);
				        break;
					}	
				}   
			   if(flag==0)
			   {
				  session.beginTransaction();
				  session.save(item);
				  session.getTransaction().commit();
			   }
		   }
		   catch (HibernateException e)
		   {
		    e.printStackTrace();
		    if(session.getTransaction()!=null) session.getTransaction().rollback();
		   }
		   finally
		   {
			   if(session != null) 
				{ 
					session.close(); 
				} 
		   }	
	}
	
	/*
	 * Deleting item from the database per user.
	 * @param itemName, this item we delete from the database.
	 */
	public void deleteItem(String itemName) throws ToDoListDAOException{
		// TODO Auto-generated method stub
		Session session = factory.openSession();

		   try
		   {
		     session.beginTransaction();
		        Query query = session.createQuery("delete from Items where itemName = :itemName");
		        query.setParameter("itemName", itemName);
		        int id1= query.executeUpdate();
		        if(id1==0)
		        {
					JOptionPane.showMessageDialog(null, "The Item Name isn't correct, you didn't delete anything", "Error", JOptionPane.INFORMATION_MESSAGE);
		        }
		        session.getTransaction().commit();
		   }
		   catch (HibernateException e)
		   {
		    e.printStackTrace();
		    if(session.getTransaction()!=null) session.getTransaction().rollback();
		   }
		   finally
		   {
			   if(session != null) 
				{ 
					session.close(); 
				}
		   }  
	}

	
	/*
	 * Updating item details as the user wish.
	 * @param updateItem, the new item will be updated.
	 * @param itemNameToUpdate, the item we wish to be updated
	 */
	@Override
	public void updateItem(Items updateItem, String itemNameToUpdate) throws ToDoListDAOException{
		// TODO Auto-generated method stub
		  Session session = factory.openSession();
		   try
		   {
		    session.beginTransaction();
		    Query query = session.createQuery("from Items where userName = :user AND ItemName = :item");
		    query.setParameter("user", updateItem.getUserName());
		    Items ifItemExist =(Items) query.setParameter("item", itemNameToUpdate).uniqueResult();
		    
		    long id=0;
		    if(ifItemExist != null){
		    	id = ifItemExist.getId();
		    }
		    System.out.println(id + "    " + ifItemExist );
		    Query query2 = session.createQuery("UPDATE Items SET status = :stat , itemName = :item , userName= :user , priority= :prio , dueDate= :date , note= :note" +
		    " where id = :d");
		    query2.setParameter("stat", updateItem.getStatus());
		    query2.setParameter("item", updateItem.getItemName());
		    query2.setParameter("user", updateItem.getUserName());
		    query2.setParameter("prio", updateItem.getPriority());
		    query2.setParameter("date", updateItem.getDueDate());
		    query2.setParameter("note", updateItem.getNote());
		    query2.setParameter("d", id);
		    query2.executeUpdate();
		    session.getTransaction().commit();
		    
		   }
		   catch (HibernateException e)
		   {
		    e.printStackTrace();
		    if(session.getTransaction()!=null) session.getTransaction().rollback();
		   }
		   finally
		   {
			   if(session != null) 
				{ 
					session.close(); 
				}
		   }  

	}
}
