package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.org.apache.bcel.internal.generic.AALOAD;

import DAO.ClientManager;
import beans.Client;

/**
 * Servlet implementation class CustomerService
 */
@WebServlet("/Client")
public class CustomerService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CustomerService() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//		response.getWriter().append("Served at: ").append(request.getContextPath());
		String action_name = request.getParameter("action");
		Client client = new Client(); 
		if(action_name != null && action_name.equals("add"))
		{
			client = this.addNewClient(request, client);
		}
		//Cas ou on édite le profil 
		else if(action_name != null && action_name.equals("edit") ){
			client = this.updateClient(request, client);
		}
		//Cas de l'authentification	
		if(client.getId() == null)
		{
			client.setEmail(request.getParameter("email"));
			client.setPwd(request.getParameter("pwd"));

			client = ClientManager.selectClientUsingEmailUsingPwd(client.getEmail(), client.getPwd());
		}
		ObjectMapper mapper  = new ObjectMapper();
		String data = mapper.writeValueAsString(client);
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.print(data);
		out.flush();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	private Client addNewClient(HttpServletRequest request, Client client )
	{
		client.setName(request.getParameter("name"));
		client.setFirstname(request.getParameter("firstname"));
		client.setPseudo(request.getParameter("pseudo"));
		client.setPwd(request.getParameter("pwd"));
		client.setAddress(request.getParameter("adress"));
		client.setEmail(request.getParameter("email"));
		if(request.getParameter("birthdate") == null)
		{
			client.setBirthdate(null);
		}
		else{
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Date date;
		try {
			date = formatter.parse(request.getParameter("birthdate"));
			client.setBirthdate(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		client.setGender(request.getParameter("gender"));
		try {
			ClientManager.insertIntoClient(client);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		client = ClientManager.selectClientUsingEmailUsingPwd(client.getEmail(), client.getPwd());

		return client;
	}
	private Client updateClient(HttpServletRequest request, Client client){
		Integer client_id = Integer.valueOf(request.getParameter("id"));

		client = ClientManager.selectClientUsingId(client_id);
		//Modification des champs
		if(client.getFirstname() != request.getParameter("firstname")) 
			client.setFirstname(request.getParameter("firstname"));
		if(client.getName() != request.getParameter("name"))
			client.setName(request.getParameter("name"));
		if(client.getAddress() != request.getParameter("adress")) 
			client.setAddress(request.getParameter("adress"));
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		if(request.getParameter("birthdate").equals(""))
		{
			client.setBirthdate(null);
		}
		
		if (client.getBirthdate() != null) {
			Date date;
			try {
				date = formatter.parse(request.getParameter("birthdate"));
				if (client.getBirthdate() != date)
					client.setBirthdate(date);

			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		if(client.getEmail() != request.getParameter("email")) 
			client.setEmail(request.getParameter("email"));
		if(client.getPseudo()!= request.getParameter("pseudo")) 
			client.setPseudo(request.getParameter("pseudo"));
		if(client.getGender() != request.getParameter("gender").charAt(0)) 
			client.setGender(request.getParameter("gender"));
		//MAJ des infos du client
		ClientManager.updateClientProfile(client);
		//Recupération du client
		client = ClientManager.selectClientUsingId(client.getId());
		return client;
	}
}
