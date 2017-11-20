package il.hit.controler;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import il.hit.model.HibernateToListDAO;
import il.hit.model.Items;
import il.hit.model.ToDoListDAOException;
import il.hit.model.User;
/*
 * The Controller class is the connection between the view and the model,
 * this class handles all the POST/GET requests from the client
 * by creating connection to the database via hibernate framework. 
 */
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       /**
        * This class is the main function of the controller class
        * this function knows to forward all the client requests by analyze the url
        * that came with the client request. 
        */
	@SuppressWarnings("deprecation")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getPathInfo();
		RequestDispatcher dispatcher = null;
		switch (path) {

		case "/Youtube":
			dispatcher = getServletContext().getRequestDispatcher("/youtube.jsp");
			dispatcher.forward(request, response);
			break;
			
		case "/Login":
			
			int flag=1;
		  	String name=request.getParameter("userName");  
	        String password=request.getParameter("password");  
	        System.out.println( name + "  " + password);
	        boolean result = false;
			try {
				result = HibernateToListDAO.getInstance().authenticateUser(name, password);
			} catch (ToDoListDAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				dispatcher = getServletContext().getRequestDispatcher("/error.jsp");
				dispatcher.forward(request, response);
			}
	        request.getSession().setAttribute("name", name);
			try {
				User user = HibernateToListDAO.getInstance().getUserByUserName(name);
			} catch (ToDoListDAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				dispatcher = getServletContext().getRequestDispatcher("/error.jsp");
				dispatcher.forward(request, response);
			}
	        if(result == true){
	        	
	        	dispatcher = getServletContext().getRequestDispatcher("/home.jsp");
				List<Items> allDoList = new ArrayList<Items>();
				String userName=(String) request.getSession().getAttribute("name");
					try {
						allDoList=HibernateToListDAO.getInstance().getAllItemsPerUser(userName);
					} catch (ToDoListDAOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						dispatcher = getServletContext().getRequestDispatcher("/error.jsp");
						dispatcher.forward(request, response);
					}
				request.getSession().setAttribute("allDoList", allDoList);
				dispatcher.forward(request, response);
	        }
	        else{
	        	flag=0;
	        	 request.getSession().setAttribute("flag", flag);
	        	RequestDispatcher rd=request.getRequestDispatcher("/loginerror.jsp");  
		        rd.forward(request, response);  
	        }
			
			break;
		
		case "/LoginAgain":
			dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
			dispatcher.forward(request, response);
			break;
			
		case "/AddTask":
			dispatcher = getServletContext().getRequestDispatcher("/addtask.jsp");
			dispatcher.forward(request, response);
			break;

		case "/Logout":
			
			HttpSession session=request.getSession();
			if(!session.isNew())
			{
				session.invalidate();
				session=request.getSession();
			}
			dispatcher = request.getRequestDispatcher("/login.jsp");
			dispatcher.forward(request, response);
			break;
			
	   case "/Delete":
		
		 	String taskToDelete=request.getParameter("taskToDelete");
		 	System.out.println(taskToDelete);
		 	try {
				HibernateToListDAO.getInstance().deleteItem(taskToDelete);
			} catch (ToDoListDAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				dispatcher = getServletContext().getRequestDispatcher("/error.jsp");
				dispatcher.forward(request, response);
			}
			dispatcher=request.getRequestDispatcher("/Controller/Home");  
			dispatcher.forward(request, response); 
			break;
			
		case "/AddingTask":
			
		  	String taskName=request.getParameter("taskName");  
	        String priority=request.getParameter("Priority");  
	        @SuppressWarnings("deprecation") Date date = new Date(19, 2, 16);
	        String status=request.getParameter("Status");
		  	String note=request.getParameter("Note");  
		  	System.out.println(taskName + "" + priority + "" + status + "" + note);
		  	if((taskName=="") || (priority=="") || (status=="") || (note==""))
		  	{
		  		dispatcher = getServletContext().getRequestDispatcher("/addingtaskemptyfields.jsp");
				dispatcher.forward(request, response);
				break;
		  	}
		  	String user1=(String) request.getSession().getAttribute("name");
		  	Items item = new Items();
		  	item.setUserName(user1);
	        item.setItemName(taskName);
	        item.setPriority(priority);
	        item.setStatus(status);
	        item.setNote(note);
	        item.setDueDate(date);
			try {
				HibernateToListDAO.getInstance().addItem(item);
			} catch (ToDoListDAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				dispatcher = getServletContext().getRequestDispatcher("/error.jsp");
				dispatcher.forward(request, response);
			}
			dispatcher=request.getRequestDispatcher("/Controller/Home");  
			dispatcher.forward(request, response); 
			break;	
			
		case "/Home":
			dispatcher = getServletContext().getRequestDispatcher("/home.jsp");
			List<Items> allDoList = new ArrayList<Items>();
			String userName=(String) request.getSession().getAttribute("name");
			try {
				allDoList=HibernateToListDAO.getInstance().getAllItemsPerUser(userName);
			} catch (ToDoListDAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				dispatcher = getServletContext().getRequestDispatcher("/error.jsp");
				dispatcher.forward(request, response);
			}
			request.getSession().setAttribute("allDoList", allDoList);
			dispatcher.forward(request, response);
			break;
			
		case "/UpdateTask":
			dispatcher=request.getRequestDispatcher("/updatetask.jsp");  
			dispatcher.forward(request, response);
			break;	
			
		case "/UpdateingTask":
		  	String oldTaskName=request.getParameter("oldTaskName"); 
		  	String newTaskName=request.getParameter("newTaskName");  
	         priority=request.getParameter("Priority");  
	        date = new Date(19, 2, 16);
	        status=request.getParameter("Status");
		  	note=request.getParameter("Note");  
		  	String userStr=(String) request.getSession().getAttribute("name");
		  	Items itemToUpdate = new Items();
		  	itemToUpdate.setUserName(userStr);
		  	itemToUpdate.setItemName(newTaskName);
		  	itemToUpdate.setPriority(priority);
		  	itemToUpdate.setStatus(status);
		  	itemToUpdate.setNote(note);
		  	itemToUpdate.setDueDate(date);
			try {
				HibernateToListDAO.getInstance().updateItem(itemToUpdate, oldTaskName);
			} catch (ToDoListDAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				dispatcher = getServletContext().getRequestDispatcher("/error.jsp");
				dispatcher.forward(request, response);
			}
			dispatcher=request.getRequestDispatcher("/Controller/Home");  
			dispatcher.forward(request, response);
			break;	
			
		case "/Register":
			RequestDispatcher rdReg;
			String nameReg = null;
			String passwordReg = null;
			String rePassword = null;
			String email = null;
			do{
				nameReg=request.getParameter("userName");  
				passwordReg=request.getParameter("password");
				rePassword=request.getParameter("repassword");
	            email=request.getParameter("email");
	        if (!passwordReg.equals(rePassword))
	        {
	        	rdReg=request.getRequestDispatcher("/passworderror.jsp");  
	        	rdReg.forward(request, response); 
	        }
	        if(nameReg.equals("") || passwordReg.equals("") || email.equals(""))
	        {
	        	rdReg=request.getRequestDispatcher("/registererroremptyfields.jsp");  
	        	rdReg.forward(request, response); 
	        	return;
	        }
			}while((nameReg.equals("")) || (passwordReg.equals("")) || (email.equals("")));
			
	        User user2;
		
			try {
				user2 = HibernateToListDAO.getInstance().getUserByUserName(nameReg);
		
				 if(user2.getUserName().equals("---")){
			        	user2.setPassword(passwordReg);
			        	user2.setUserName(nameReg);
			        	user2.setEmail(email);
			        	HibernateToListDAO.getInstance().addUser(user2);
			        }
			        else
			        {
			        	rdReg=request.getRequestDispatcher("/registererror.jsp");  
			        	rdReg.forward(request, response);  
			        }
	
			} catch (ToDoListDAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				dispatcher = getServletContext().getRequestDispatcher("/error.jsp");
				dispatcher.forward(request, response);
			}    
	       
	        rdReg=request.getRequestDispatcher("/login.jsp");  
	        rdReg.forward(request, response);  
			break;
		default:

		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

	
}


