package servlets;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;

import beans.Jeu;

/**
 * Servlet implementation class GameDetails
 */
@WebServlet("/Game")
public class GameDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GameDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 ObjectMapper mapper = new ObjectMapper();
		 	String game_id = request.getParameter("id");
	        String data = APIContact.getDataFromAPI("http://localhost:8080/sr03_project_server/Detail?id="+game_id);
	           Jeu jeu = mapper.readValue(data, Jeu.class);	
	        request.setAttribute("jeu", jeu);
	  	   request.getRequestDispatcher("Game.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
