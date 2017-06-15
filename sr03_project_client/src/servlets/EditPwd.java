package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import beans.Client;

/**
 * Servlet implementation class EditPwd
 */
@WebServlet("/EditPwd")
public class EditPwd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditPwd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Client client = (Client)request.getSession().getAttribute("client");
		System.out.println("ANCIEN MDP "+client.getPwd());
		System.out.println("HASH TEMOIN "+hashMdp("Pass5"));
		System.out.println("NOUV MDP "+hashMdp(request.getParameter("oldPwd")));
		if(client.getPwd().equals(hashMdp(request.getParameter("oldPwd"))) == false)
		{
			ObjectMapper mapper  = new ObjectMapper();
			String data = mapper.writeValueAsString(false);
			PrintWriter out = response.getWriter();
			out.print(data);
			out.flush();
			return;
		}
		
		StringBuffer requestURL = request.getRequestURL();
		if (request.getQueryString() != null) {
		    requestURL.append("?").append(request.getQueryString());
		}
		String completeURL = requestURL.toString();
		 completeURL =  completeURL.substring(completeURL.indexOf('?'));
		 String client_id = ((Client)request.getSession().getAttribute("client")).getId().toString();
		  String data = APIContact.getDataFromAPI("http://localhost:8080/sr03_project_server/Client"+completeURL+"&action=pwd&id="+client_id);

		  ObjectMapper mapper= new ObjectMapper();
		   client = (Client) mapper.readValue(data, Client.class);
		  request.getSession().setAttribute("client", client);
	        request.getRequestDispatcher("Profile.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
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
