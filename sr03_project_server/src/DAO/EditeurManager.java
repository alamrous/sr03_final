package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.Editeur;
import beans.Plateforme;

public class EditeurManager {
	public static ArrayList<Editeur> getEditeurs(){
		ArrayList<Editeur> editeurs_list= new ArrayList<>();
		ConnexionBDD mysqlConnect = new ConnexionBDD();
		String sql = "SELECT * FROM test.Editeur ";
		Connection connection = mysqlConnect.connect();
		try {
			PreparedStatement statement=	connection.prepareStatement(sql);
			ResultSet res = statement.executeQuery();
			Editeur editeur = new Editeur();
			while(res.next())
			{
				editeur = new Editeur();
				editeur.setId(res.getInt("id"));
				editeur.setDescription(res.getString("nom"));
				editeurs_list.add(editeur);
			}
			return editeurs_list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
		
	}
}
