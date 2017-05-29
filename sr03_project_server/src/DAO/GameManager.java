package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import com.sun.xml.internal.ws.message.PayloadElementSniffer;

import beans.Country;
import beans.Editeur;
import beans.Jeu;import beans.Pegi;
import beans.Plateforme;
import sun.security.krb5.internal.PAEncTSEnc;

public class GameManager {
public static ArrayList<Jeu> getAllGame(){
	ArrayList<Jeu> liste = new ArrayList<Jeu>();
	ConnexionBDD mysqlConnect = new ConnexionBDD();
	String sql = "SELECT test.Jeu.*, test.Pegi.description AS Pegi_description, test.Editeur.nom AS Editeur_name, test.Pays.nom AS Country_name, "
			+ " Jeu_Plateforme.prix as Prix, Jeu_Plateforme.id,Plateforme.nom as plat_name "
			+ " FROM test.Jeu"
			+ " INNER JOIN test.Jeu_Plateforme ON test.Jeu_Plateforme.jeu_fk = test.Jeu.id"
			+ " INNER JOIN test.Plateforme ON test.Jeu_Plateforme.plateforme_fk=test.Plateforme.id"
			+ " INNER JOIN test.Pegi ON test.Pegi.id=test.Jeu.pegi_fk"
			+ " INNER  JOIN test.Editeur ON test.Editeur.id=test.Jeu.editeur_fk"
			+ " iNNER  JOIN test.Pays ON test.Pays.id=test.Editeur.country_fk" ;
	try {
	Connection connection =  mysqlConnect.connect();
	PreparedStatement statement=	connection.prepareStatement(sql);

	ResultSet res = statement.executeQuery();
	Jeu jeu;
	Editeur editeur; 
	Country pays;
	Pegi pegi;
	Plateforme plateforme;
	while(res.next()){
		jeu = new Jeu();
		editeur = new Editeur();
		editeur.setDescription(res.getString("Editeur_name"));
		pays = new Country();
		pays.setNom(res.getString("Country_name"));
		editeur.setCountry_fk(pays);
		pegi = new Pegi();
		pegi.setDescription(res.getString("Pegi_description"));
		
		plateforme = new Plateforme();
		plateforme.setName(res.getString("plat_name"));
		jeu.setId(res.getInt("Jeu.id"));
		jeu.setPrix(res.getDouble("Prix"));
		jeu.setFk_editeur(editeur);
		jeu.setFk_pegi(pegi);
		jeu.setNote(res.getDouble("note"));
		jeu.setSummary(res.getString("summary"));
		jeu.setTitle(res.getString("title"));
		jeu.setPlateforme(plateforme);
		jeu.setPlateforme_jeu_fk(res.getInt("Jeu_Plateforme.id"));
		liste.add(jeu);
//	(Integer id, String title, Integer fk_pegi, Double note, String summary, Integer fk_editeur)
	}
	
	res.close();	
	mysqlConnect.disconnect();
	}			
	catch (Exception e) {
		System.out.println(e.toString());
		// TODO: handle exception
	}
	return liste;
}

public static Jeu getGameUsingId(Integer valueOf) {
	Jeu jeu = null;
	ConnexionBDD mysqlConnect = new ConnexionBDD();
String sql = "SELECT test.Jeu.* , test.Plateforme.nom, test.Jeu_Plateforme.id, test.Jeu_Plateforme.prix "
		+ " FROM test.Jeu "
		+ "LEFT OUTER JOIN test.Jeu_Plateforme ON test.Jeu_Plateforme.jeu_fk = test.Jeu.id "
		+ " LEFT OUTER JOIN test.Plateforme ON test.Plateforme.id = test.Jeu_Plateforme.plateforme_fk "
		+ "WHERE test.Jeu_Plateforme.id = ? ";

Connection connection =  mysqlConnect.connect();
try {
	PreparedStatement statement=	connection.prepareStatement(sql);
	statement.setInt(1, valueOf);
	ResultSet res = statement.executeQuery();
	if(res.next())
	{
		jeu = new Jeu();
		jeu.setId(res.getInt("Jeu.id"));
		jeu.setPrix(res.getDouble("prix"));
		jeu.setTitle(res.getString("title"));
		jeu.setPlateforme_jeu_fk(res.getInt("Jeu_Plateforme.id"));
		Plateforme plateforme = new Plateforme();
		plateforme.setName("Plateforme.nom");
		jeu.setPlateforme(plateforme);

		}
return jeu;
	
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

	
	return null;
}

public static ArrayList<Jeu> getGameUsingFields(String title, Integer plateform, Integer editor, Double priceMin,
		Double priceMax, Date date) {
	ArrayList<Jeu> liste = new ArrayList<Jeu>();

	ConnexionBDD mysqlConnect = new ConnexionBDD();
	Connection connection =  mysqlConnect.connect();

	String sql = "SELECT test.Jeu.*, test.Pegi.description AS Pegi_description, test.Editeur.nom AS Editeur_name, test.Pays.nom AS Country_name, "
			+ " Jeu_Plateforme.prix as Prix, Jeu_Plateforme.id,Plateforme.nom as plat_name "
			+ " FROM test.Jeu"
			+ " INNER JOIN test.Jeu_Plateforme ON test.Jeu_Plateforme.jeu_fk = test.Jeu.id"
			+ " INNER JOIN test.Plateforme ON test.Jeu_Plateforme.plateforme_fk=test.Plateforme.id"
			+ " INNER JOIN test.Pegi ON test.Pegi.id=test.Jeu.pegi_fk"
			+ " INNER  JOIN test.Editeur ON test.Editeur.id=test.Jeu.editeur_fk"
			+ " iNNER  JOIN test.Pays ON test.Pays.id=test.Editeur.country_fk "
			+" WHERE ";
	String add= " ";
	int i = 0;
	if(title!= null) { 
		System.out.println("ici");
		if (add== " ") add= add+"  Jeu.title LIKE \' ? \' ";
		i = i+1;}
	if(plateform != null) {if (add== " ") add= add+" Plateforme.id= ? "; else add =add+" AND Plateforme.id= ? "; i = i+1; }
	if(editor != null) {if (add== " ") add= add+" Editeur.id= ? "; else add =add+" AND Editeur.id= ? "; i = i+1; }
	if(priceMin != null) {if (add== " ") add= add+" Jeu_Plateforme.prix <= ? "; else add =add+" AND Jeu_Plateforme.prix <= ?  "; i = i+1; }
	if(priceMax != null) {if (add== " ") add= add+" Jeu_Plateforme.prix >= ? "; else add =add+" AND Jeu_Plateforme.prix >= ?  "; i = i+1; }
	sql=sql+add;
	try {
		PreparedStatement statement=connection.prepareStatement(sql);
	
			if(priceMax != null)
			{
				statement.setDouble(i, priceMax);
				i = i - 1;
			}
			if(priceMin != null)
			{
				statement.setDouble(i, priceMin);
				i = i - 1;
			}
			if(editor != null)
			{
				statement.setInt(i, editor);
				i = i - 1;
			}
			if (plateform != null) {
				statement.setInt(i, plateform);
				i = i - 1 ;
			}
			if(title != null )
			{
				statement.setString(i, title);
				i = i - 1 ;
			}
			
			System.out.println(statement);
			ResultSet res = statement.executeQuery();
			Jeu jeu;
			Editeur editeur; 
			Country pays;
			Pegi pegi;
			Plateforme plateforme;
			while(res.next()){
				jeu = new Jeu();
				editeur = new Editeur();
				editeur.setDescription(res.getString("Editeur_name"));
				pays = new Country();
				pays.setNom(res.getString("Country_name"));
				editeur.setCountry_fk(pays);
				pegi = new Pegi();
				pegi.setDescription(res.getString("Pegi_description"));
				
				plateforme = new Plateforme();
				plateforme.setName(res.getString("plat_name"));
				jeu.setId(res.getInt("Jeu.id"));
				jeu.setPrix(res.getDouble("Prix"));
				jeu.setFk_editeur(editeur);
				jeu.setFk_pegi(pegi);
				jeu.setNote(res.getDouble("note"));
				jeu.setSummary(res.getString("summary"));
				jeu.setTitle(res.getString("title"));
				jeu.setPlateforme(plateforme);
				jeu.setPlateforme_jeu_fk(res.getInt("Jeu_Plateforme.id"));
				liste.add(jeu);
			}
			
			res.close();	
			mysqlConnect.disconnect();
			
		return liste;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}


	// TODO Auto-generated method stub
	return null;
}
}
