package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import beans.Jeu;

/**
 * Servlet implementation class GameController
 */
@WebServlet("/getAllGame")
public class GameController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GameController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	      ObjectMapper mapper = new ObjectMapper();
	        String data = APIContact.getDataFromAPI("http://localhost:8080/sr03_project_server/getGames");
	           Jeu[] jeu_liste = mapper.readValue(data, Jeu[].class);
	        request.setAttribute("liste", jeu_liste);
	  	   request.getRequestDispatcher("GameTable.jsp").forward(request, response);

	        
	        }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
