package servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.corba.se.impl.oa.poa.ActiveObjectMap.Key;

import beans.Client;
import beans.Editeur;
import beans.Jeu;
import beans.Plateforme;

/**
 * Servlet implementation class GameController
 */
@WebServlet("/Accueil")
public class Accueil extends HttpServlet implements APIContact {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Accueil() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Client client = new Client();
		client.setId(3);
		request.getSession().setAttribute("client", client);

        ObjectMapper mapper = new ObjectMapper();
//        String data = APIContact.getDataFromAPI("http://localhost:8080/sr03_project_server/getGames");
//           Jeu[] jeu_liste = mapper.readValue(data, Jeu[].class);
//        request.setAttribute("liste", jeu_liste);
        String data = APIContact.getDataFromAPI("http://localhost:8080/sr03_project_server/getFormComponents");
        HashMap<String, String> formComponents = mapper.readValue(data, HashMap.class);
//        System.out.println(formComponents.get("editeurs"));
		request.setAttribute("plateformes", formComponents.get("plateformes"));
		request.setAttribute("editeurs", formComponents.get("editeurs"));
 	   request.getRequestDispatcher("GamesList.jsp").forward(request, response);


	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
