package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import beans.Client;

/**
 * Servlet implementation class EditPwd
 */
@WebServlet("/EditPwd")
public class EditPwd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditPwd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Client client = (Client)request.getSession().getAttribute("client");
		if(client.getPwd().equals(request.getParameter("pwd_old")) == false)
		{
			ObjectMapper mapper  = new ObjectMapper();
			String data = mapper.writeValueAsString(false);
			PrintWriter out = response.getWriter();
			out.print(data);
			out.flush();
			return;
		}
		
		StringBuffer requestURL = request.getRequestURL();
		if (request.getQueryString() != null) {
		    requestURL.append("?").append(request.getQueryString());
		}
		String completeURL = requestURL.toString();
		 completeURL =  completeURL.substring(completeURL.indexOf('?'));
		 String client_id = ((Client)request.getSession().getAttribute("client")).getId().toString();
		  String data = APIContact.getDataFromAPI("http://localhost:8080/sr03_project_server/Client"+completeURL+"&action=pwd&id="+client_id);

		  ObjectMapper mapper= new ObjectMapper();
		   client = (Client) mapper.readValue(data, Client.class);
		  request.getSession().setAttribute("client", client);
	        request.getRequestDispatcher("Profile.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
