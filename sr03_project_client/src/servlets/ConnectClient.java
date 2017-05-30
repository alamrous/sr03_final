package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import beans.Client;
import beans.Jeu;

/**
 * Servlet implementation class ConnectClient
 */
@WebServlet("/ConnectClient")
public class ConnectClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConnectClient() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		String pwd =request.getParameter("pwd");
	      ObjectMapper mapper = new ObjectMapper();
	        String data = APIContact.getDataFromAPI("http://localhost:8080/sr03_project_server/Client?email="+email+"&pwd="+pwd);
	           Client client = mapper.readValue(data, Client.class);
	           request.getSession().setAttribute("client", client);
//	        request.setAttribute("liste", jeu_liste);
	  	   request.getRequestDispatcher("Accueil").forward(request, response);
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
