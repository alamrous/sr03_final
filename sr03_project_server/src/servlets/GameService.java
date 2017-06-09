package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.resteasy.plugins.server.servlet.Cleanable;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.corba.se.impl.oa.poa.ActiveObjectMap.Key;

import DAO.ClientManager;
import DAO.EditeurManager;
import DAO.GameManager;
import DAO.PlateformeManager;
import beans.Client;
import beans.Editeur;
import beans.Jeu;
import beans.Plateforme;

/**
 * Servlet implementation class GameController
 */
@WebServlet("/getGames")

public class GameService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GameService() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		ArrayList<Jeu> liste= new ArrayList<Jeu>();
		if(request.getParameter("action") == null)
		liste = GameManager.getAllGame();
		else{
			String title=  request.getParameter("title");
			Integer plateform= (request.getParameter("plateforme") == null)?null: Integer.valueOf(request.getParameter("plateforme"));
			Double priceMin= (request.getParameter("minPrice") == null)?null: Double.valueOf(request.getParameter("minPrice"));
			Double priceMax= (request.getParameter("maxPrice") == null)?null: Double.valueOf(request.getParameter("maxPrice"));
			Integer editor=  (request.getParameter("editeur") == null)?null:Integer.valueOf(request.getParameter("editeur"));
			Date year = null;
			if(request.getParameter("year") != null){
				try {
					SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
					year = formatter.parse(request.getParameter("year"));

				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}
			liste =GameManager.getGameUsingFields(title, plateform, editor, priceMin, priceMax, year);
			System.out.println(liste);

		}
       try {
    		Jeu[] jeu_liste = liste.toArray(new Jeu[liste.size()]);
    		request.setAttribute("liste", jeu_liste);
    		ObjectMapper mapper  = new ObjectMapper();
    		String data = mapper.writeValueAsString(jeu_liste);
    		response.setContentType("application/json");
    		PrintWriter out = response.getWriter();
    		out.print(data);
    		out.flush();

	} catch (Exception e) {
		// TODO: handle exception
		System.out.println("DISPATCHER "+e.toString());
	}

//		request.getRequestDispatcher("/WebContent/GamesList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
