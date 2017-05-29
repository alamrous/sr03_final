package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
import javafx.scene.chart.PieChart.Data;

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
		liste = GameManager.getAllGame();
       try {
    		Jeu[] jeu_liste = liste.toArray(new Jeu[liste.size()]);
    		request.setAttribute("liste", jeu_liste);
    		ObjectMapper mapper  = new ObjectMapper();
    		String data = mapper.writeValueAsString(jeu_liste);
    		response.setContentType("application/json");
    		PrintWriter out = response.getWriter();
    		out.print(data);
    		out.flush();
//    	   request.getRequestDispatcher("GamesList.jsp").forward(request, response);

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
