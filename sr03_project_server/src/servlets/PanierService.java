package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.rpc.holders.IntegerWrapperHolder;

import com.fasterxml.jackson.databind.ObjectMapper;

import DAO.GameManager;
import DAO.PanierManager;
import beans.Client;
import beans.Jeu;
import beans.Panier;

/**
 * Servlet implementation class PanierService
 */
@WebServlet("/Panier")
public class PanierService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PanierService() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String client_id = request.getParameter("client");
		String action_name = request.getParameter("action");
		if(action_name != null && action_name.equals("delete") ){
			String item_to_delete = request.getParameter("item_id");
			try {
				 PanierManager.removePanierItemUsingId(Integer.valueOf(item_to_delete));

					response.setContentType("application/json");
					boolean status = true;
					ObjectMapper mapper = new ObjectMapper();
					String data = mapper.writeValueAsString(status);
					PrintWriter out = response.getWriter();
					out.print(data);
					out.flush();
					return;	 
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			
		}
		else if (action_name != null && action_name.equals("buy")) {
			try {
				PanierManager.buyPanierItemUsingClientId(Integer.valueOf(client_id));
				response.setContentType("application/json");
				boolean status = true;
				ObjectMapper mapper = new ObjectMapper();
				String data = mapper.writeValueAsString(status);
				PrintWriter out = response.getWriter();
				out.print(data);
				out.flush();
				return;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		else if (action_name != null && action_name.equals("add")) {
			Jeu jeu = GameManager.getGameUsingId(Integer.valueOf(request.getParameter("gameId")));
			if(jeu != null)
			{
				try {
					PanierManager.insertIntoPanier(jeu,Integer.valueOf(client_id));
					response.setContentType("application/json");
					boolean status = true;
					ObjectMapper mapper = new ObjectMapper();
					String data = mapper.writeValueAsString(status);
					PrintWriter out = response.getWriter();
					out.print(data);
					out.flush();
					return;
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
		}
		Panier[] paniers = null;
		//Mise en forme du Panier
		if(request.getParameter("object").equals("Panier"))
		{
		 paniers = PanierManager.getClientPanier(Integer.valueOf(client_id));
		}
		 else if(request.getParameter("object").equals("Achats"))
		 {
			 paniers = PanierManager.getClientBoughtItem(Integer.valueOf(client_id));
		 }
		
		ObjectMapper mapper = new ObjectMapper();
		String data = mapper.writeValueAsString(paniers);
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.print(data);
		out.flush();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
