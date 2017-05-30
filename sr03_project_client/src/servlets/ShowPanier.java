package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import beans.Client;
import beans.Jeu;
import beans.Panier;

/**
 * Servlet implementation class ShowPanier
 */
@WebServlet("/ShowPanier")
public class ShowPanier extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowPanier() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	      ObjectMapper mapper = new ObjectMapper();	 
	      Client client = (Client) request.getSession().getAttribute("client");

	        String data = APIContact.getDataFromAPI("http://localhost:8080/sr03_project_server/Panier?client="+client.getId());
			ArrayList panier_map = (ArrayList) mapper.readValue(data,Panier[].class);
			Panier[] paniers =  (Panier[]) panier_map.get(0);
			request.getSession().setAttribute("panier", paniers);
			request.getSession().setAttribute("achats",(Panier[]) panier_map.get(1));


			if(paniers.length >=1){
			double total =0 ;
			for (int i = 0; i < paniers.length; i++) {
				total = total + paniers[i].getJeu().getPrix();
			}
			request.getSession().setAttribute("total", total);
			}
			
	
			request.getRequestDispatcher("PanierView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
