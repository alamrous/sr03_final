package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import beans.Plateforme;

public class PlateformeManager {

	public static ArrayList<Plateforme> getPlateforme(){
		ArrayList<Plateforme> plateforme_list= new ArrayList<>();
		ConnexionBDD mysqlConnect = new ConnexionBDD();
		String sql = "SELECT * FROM test.Plateforme ";
		Connection connection = mysqlConnect.connect();
		try {
			PreparedStatement statement=	connection.prepareStatement(sql);
			ResultSet res = statement.executeQuery();
			Plateforme plateforme = new Plateforme();
			while(res.next())
			{
				plateforme = new Plateforme();
				plateforme.setId(res.getInt("id"));
				plateforme.setName(res.getString("nom"));
				plateforme_list.add(plateforme);
			}
			return plateforme_list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		return null;
		
	}
}
