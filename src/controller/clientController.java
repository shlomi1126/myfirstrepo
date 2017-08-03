package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import da.DAclient;
import model.client;


@WebServlet("/clientController")
public class clientController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static String clientlist = "/listClient.jsp"; 
	public static String form_client = "/clientForm.jsp";
	public static String form_find_client = "/getclient.jsp";
	
    DAclient clientDa; 
	
    public clientController() {
        super();
        clientDa = new DAclient();
    }
    

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		String forward = "";
		
		if(action.equalsIgnoreCase("clientlist")){
			forward = clientlist;
			List <client> clients = clientDa.getAllClient();
			request.setAttribute("clients", clients);
			response.setContentType("text/html");
		}
		else if(action.equalsIgnoreCase("find")){
			request.setCharacterEncoding("UTF-8"); //חשוב בישראל,למי שכותב עברית!
			forward = form_find_client;
			int clientid = Integer.valueOf(request.getParameter("id"));
			client client = clientDa.getClientById(clientid);
			request.setAttribute("cli", client);
			response.setContentType("text/html");
		}
		else if(action.equalsIgnoreCase("add")){
			forward = form_client;	
			request.setAttribute("action","toAdd" );

		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(forward);
		dispatcher.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		String action = request.getParameter("action_type");
		client client = new client();
		String forward = "";
		request.setCharacterEncoding("UTF-8");
		
		String f_name = request.getParameter("fn") ;
		String l_name = request.getParameter("ln") ;
		String client_id = request.getParameter("id");
		String client_mail = request.getParameter("cm");
		String client_phone = request.getParameter("cp");
		
		client.setF_name(f_name);
		client.setL_name(l_name);
		client.setMail_client(client_mail);
		client.setPhone_client(Long.valueOf(client_phone));
		client.setClient_id(Integer.valueOf(client_id));
		
			if (action.equals("Add"))
				{
				clientDa.addClient(client);
				}
			
		List <client> list = clientDa.getAllClient();
		request.setAttribute("clients", list);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(clientlist);
		response.setCharacterEncoding("UTF-8");
		dispatcher.forward(request, response);
		
	}

}
