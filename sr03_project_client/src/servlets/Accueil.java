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
public class Accueil extends HttpServlet {
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
        ObjectMapper mapper = new ObjectMapper();
        String data = this.getDataFromAPI("http://localhost:8080/sr03_project_server/getGames");
           Jeu[] jeu_liste = mapper.readValue(data, Jeu[].class);
        data = this.getDataFromAPI("http://localhost:8080/sr03_project_server/getFormComponents");
        HashMap<String, String> formComponents = mapper.readValue(data, HashMap.class);
//        System.out.println(formComponents.get("editeurs"));
		request.setAttribute("liste", jeu_liste);
		request.setAttribute("plateformes", formComponents.get("plateformes"));
		request.setAttribute("editeurs", formComponents.get("editeurs"));
 	   request.getRequestDispatcher("GamesList.jsp").forward(request, response);


	}
	private String getDataFromAPI(String path)
	{
		try {
			URL url = new URL (path);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setDoOutput (true);
			connection.setDoInput (true);
			connection.setRequestProperty("Content-Type","application/x-www-form-urlencoded;charset=UTF-8");

			OutputStream os = connection.getOutputStream();
			//TODO: optionally, send something through the OutputStream to your servlet
			os.flush();
			os.close();
			   BufferedReader br = new BufferedReader(
					   new InputStreamReader(connection.getInputStream(),"UTF-8"));
				//TODO: retrieve your results.getInputStream()));
			   StringBuilder sb = new StringBuilder();
			   String line;
			   while ((line = br.readLine()) != null) {
			       sb.append(line+"\n");
			   }
			   return sb.toString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
