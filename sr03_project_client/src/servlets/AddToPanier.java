package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.org.apache.xml.internal.security.c14n.CanonicalizationException;

import beans.Client;
import beans.Jeu;

/**
 * Servlet implementation class AddToPanier
 */
@WebServlet("/AddToPanier")
public class AddToPanier extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToPanier() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String client =((Client) request.getSession().getAttribute("client")).getId().toString();
		String game_id = request.getParameter("gameId");
	      ObjectMapper mapper = new ObjectMapper();
	      String data = APIContact.getDataFromAPI("http://localhost:8080/sr03_project_server/getGames?gameId="+game_id+"&client="+client);
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
