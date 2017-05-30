package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class RemoveFromPanier
 */
@WebServlet("/RemoveFromPanier")
public class RemoveFromPanier extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveFromPanier() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String panier_id = request.getParameter("item_id");
        String data = APIContact.getDataFromAPI("http://localhost:8080/sr03_project_server/"
        		+ "Panier?action=delete&item_id="+panier_id);
        ObjectMapper mapper= new ObjectMapper();
        boolean res = mapper.readValue(data, boolean.class);
        if(res)
        {
	    	 request.getRequestDispatcher("ShowPanier").forward(request, response);

        }

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
