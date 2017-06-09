package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.org.apache.bcel.internal.generic.AALOAD;
import com.sun.tracing.dtrace.ProviderAttributes;

import DAO.ClientManager;
import beans.Client;
import org.apache.commons.lang.StringEscapeUtils;

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
		escapeValuesOfRequest(request);
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
			client.setEmail(StringEscapeUtils.escapeHtml(request.getParameter("email")));
			client.setPwd(StringEscapeUtils.escapeHtml(hashMdp(request.getParameter("pwd"))));

			client = ClientManager.selectClientUsingEmailUsingPwd(client.getEmail(), client.getPwd());
		}
		System.out.println(client);

		ObjectMapper mapper  = new ObjectMapper();
		String data = mapper.writeValueAsString(client);
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.print(data);
		out.flush();
	}

	private void escapeValuesOfRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		 Enumeration<String> parameterNames = request.getParameterNames();
	
		         while (parameterNames.hasMoreElements()) {
		        	 
		           System.out.println( request.getParameter(parameterNames.nextElement()));
		  
		         }


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
		client.setName(StringEscapeUtils.escapeHtml(request.getParameter("name")));
		client.setFirstname(StringEscapeUtils.escapeHtml(request.getParameter("firstname")));
		client.setPseudo(StringEscapeUtils.escapeHtml(request.getParameter("pseudo")));
		client.setPwd(StringEscapeUtils.escapeHtml(request.getParameter("pwd")));
		client.setPwd(hashMdp(client.getPwd())); 
		client.setAddress(StringEscapeUtils.escapeHtml(request.getParameter("adress")));
		client.setEmail(StringEscapeUtils.escapeHtml(request.getParameter("email")));
		
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
			client.setFirstname(StringEscapeUtils.escapeHtml(request.getParameter("firstname")));
		if(client.getName() != request.getParameter("name"))
			client.setName(StringEscapeUtils.escapeHtml(request.getParameter("name")));
		if(client.getAddress() != request.getParameter("adress")) 
			client.setAddress(StringEscapeUtils.escapeHtml(request.getParameter("adress")));
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
			client.setEmail(StringEscapeUtils.escapeHtml(request.getParameter("email")));
		if(client.getPseudo()!= request.getParameter("pseudo")) 
			client.setPseudo(StringEscapeUtils.escapeHtml(request.getParameter("pseudo")));
		if(client.getGender() != request.getParameter("gender").charAt(0)) 
			client.setGender(request.getParameter("gender"));
		//MAJ des infos du client
		ClientManager.updateClientProfile(client);
		//Recupération du client
		client = ClientManager.selectClientUsingId(client.getId());
		return client;
	}
	private String hashMdp(String pwd){
		String passwordToHash = pwd;
        String generatedPassword = null;
        try {
            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            //Add password bytes to digest
            md.update(passwordToHash.getBytes());
            //Get the hash's bytes 
            byte[] bytes = md.digest();
            //This bytes[] has bytes in decimal format;
            //Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            //Get complete hashed password in hex format
            generatedPassword = sb.toString();
        } 
        catch (NoSuchAlgorithmException e) 
        {
            e.printStackTrace();
        }
        System.out.println(generatedPassword);
        return generatedPassword;
	}
}
