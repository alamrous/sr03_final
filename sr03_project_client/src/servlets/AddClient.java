package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import beans.Client;
import sun.management.CompilerThreadStat;

/**
 * Servlet implementation class AddClient
 */
@WebServlet("/AddClient")
public class AddClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddClient() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		StringBuffer requestURL = request.getRequestURL();
		if (request.getQueryString() != null) {
		    requestURL.append("?").append(request.getQueryString());
		}
		String completeURL = requestURL.toString();
		 completeURL =  completeURL.substring(completeURL.indexOf('?'));
		  String data = APIContact.getDataFromAPI("http://localhost:8080/sr03_project_server/Client"+completeURL+"&action=add");
	        ObjectMapper mapper= new ObjectMapper();
	        Client client = (Client) mapper.readValue(data, Client.class);
	        request.getSession().setAttribute("client", client);
//	        request.getRequestDispatcher("Accueil").forward(request, response);
		  	  response.sendRedirect("Accueil"); 

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
