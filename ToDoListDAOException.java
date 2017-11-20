package il.hit.model;


/*
 * Exception class that handle database actions exceptions.
 */
public class ToDoListDAOException extends Exception 
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ToDoListDAOException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public ToDoListDAOException(String message) {
		super(message); 
		
	}	

}
