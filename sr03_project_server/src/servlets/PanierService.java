package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
		System.out.println(request.getParameter("action"));
		if(action_name != null && action_name.equals("delete") ){
			String item_to_delete = request.getParameter("item_id");
			try {
				 PanierManager.removePanierItemUsingId(Integer.valueOf(item_to_delete));
				
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
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			response.setContentType("application/json");
			boolean status = true;
			ObjectMapper mapper = new ObjectMapper();
			String data = mapper.writeValueAsString(status);
			PrintWriter out = response.getWriter();
			out.print(data);
			out.flush();
			return;
		}
		
		//Mise en forme du Panier
		HashMap<String, Panier[]> panier_map = new HashMap<>();
		Panier[] paniers = PanierManager.getClientPanier(Integer.valueOf(client_id));
		panier_map.put("Panier", paniers);
		Panier[] achats = PanierManager.getClientBoughtItem(Integer.valueOf(client_id));
		panier_map.put("Achats", achats);
		ObjectMapper mapper = new ObjectMapper();
		String data = mapper.writeValueAsString(panier_map);
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
