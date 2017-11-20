package il.hit.model;



/*
 * Test class of the Model.
 */
public class TestClass {

	public static void main(String[] args) {
		
		User a1=new	User("or", "678","");
		User a2=new	User("p", "111","asdsasd");
		
		
		try {
			HibernateToListDAO.getInstance().addUser(a1);
			HibernateToListDAO.getInstance().addUser(a2);
		} catch (ToDoListDAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
