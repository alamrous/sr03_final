package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import DAO.EditeurManager;
import DAO.PlateformeManager;
import beans.Editeur;
import beans.Plateforme;

/**
 * Servlet implementation class FormComponentService
 */
@WebServlet("/getFormComponents")
public class FormComponentService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormComponentService() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String  option="";
		String editeurOption= "";
		ArrayList<Plateforme> plateformes = PlateformeManager.getPlateforme();
		for (Iterator iterator = plateformes.iterator(); iterator.hasNext();) {
			Plateforme plateforme = (Plateforme) iterator.next();
			option=option+"<option value=\""+plateforme.getId()+"\">"+plateforme.getName()+"</option> ";
		}
		ArrayList<Editeur> editeurs = EditeurManager.getEditeurs();
		for (Iterator iterator = editeurs.iterator(); iterator.hasNext();) {
			Editeur editeur= (Editeur) iterator.next();
			editeurOption=editeurOption+"<option value=\""+editeur.getId()+"\">"+editeur.getDescription()+"</option> ";
		}
		HashMap<String, String> formComponents = new HashMap<>();
		formComponents.put("plateformes", option);
		formComponents.put("editeurs", editeurOption);

		ObjectMapper mapper = new ObjectMapper();
		String data =mapper.writeValueAsString(formComponents);
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
