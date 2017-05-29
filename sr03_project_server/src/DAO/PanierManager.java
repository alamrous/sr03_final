package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.swing.undo.StateEdit;

import com.sun.xml.internal.org.jvnet.fastinfoset.RestrictedAlphabet;

import beans.Client;
import beans.Jeu;
import beans.Panier;
import beans.Plateforme;

public class PanierManager {

	private static final int EN_ATTENTE_STATE = 1;
	private static final int ACHETE_STATE = 2;
	public static int insertIntoPanier(Jeu jeu, Integer id) throws SQLException {
		// TODO Auto-generated method stub
		int res = 0;
		
		ConnexionBDD mysqlConnect = new ConnexionBDD();
		String sql = "INSERT INTO `test`.`Panier`"
				+ "(`client_fk`,`date_creation`,`plateforme_jeu_fk`,`etat_achat_fk`)VALUES(?,CURDATE(),?,?);";
		try {
	  Connection connection =  mysqlConnect.connect();

	  //Execution et traitement de la réponse
		PreparedStatement statement=	connection.prepareStatement(sql);
		statement.setInt(1, id);
		statement.setInt(2, jeu.getPlateforme_jeu_fk());
		statement.setInt(3, PanierManager.EN_ATTENTE_STATE);
		statement.execute();
		}
		finally {
		    mysqlConnect.disconnect();
		}

		return res;
		
	}
	public static Panier[] getClientPanier(Integer client_id)
	{
		ConnexionBDD mysqlConnect = new ConnexionBDD();
		String sql = "SELECT test.Jeu.*, test.Jeu_Plateforme.*, test.Panier.* , test.Plateforme.*"
				+ "	FROM test.Panier"
				+ " INNER JOIN test.Jeu_Plateforme ON  test.Jeu_Plateforme.id = test.Panier.plateforme_jeu_fk "
				+ " INNER JOIN  test.Plateforme ON test.Plateforme.id = test.Jeu_Plateforme.plateforme_fk "
				+ " INNER JOIN test.Jeu ON test.Jeu.id=test.Jeu_Plateforme.jeu_fk "
				+ " WHERE test.Panier.client_fk = ? AND test.Panier.etat_achat_fk = ?";
		Connection connection =  mysqlConnect.connect();
			try {
				PreparedStatement statement=	connection.prepareStatement(sql);
				statement.setInt(1, client_id);
				statement.setInt(2, PanierManager.EN_ATTENTE_STATE);
				ArrayList<Panier> panier_list= new ArrayList<>();
				ResultSet res = statement.executeQuery();
				while(res.next())
				{
					Panier panier= new Panier();
					panier.setClient_fk(client_id);
					panier.setId(res.getInt("Panier.id"));
					
					Jeu jeu = new Jeu();
					Plateforme plateforme = new Plateforme();
					plateforme.setName(res.getString("Plateforme.nom"));
					
					jeu.setId(res.getInt("Jeu.id"));
					jeu.setPrix(res.getDouble("prix"));
					jeu.setTitle(res.getString("title"));
					jeu.setPlateforme_jeu_fk(res.getInt("Jeu_Plateforme.id"));
					jeu.setPlateforme(plateforme);
					
					panier.setJeu(jeu);
					panier.setDate_creation(res.getDate("Panier.date_creation"));
					panier_list.add(panier);
				}
				Panier[] result = panier_list.toArray(new Panier[panier_list.size()]);
				
				return result;

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}


		return null;
		
	}
	public static void removePanierItemUsingId(Integer panier_id) throws SQLException {
		// TODO Auto-generated method stub
		boolean res= false;
		ConnexionBDD mysqlConnect = new ConnexionBDD();
		Connection connection =  mysqlConnect.connect();
		String sql = "DELETE FROM test.Panier WHERE Panier.id= ?";
		
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, panier_id);
		  statement.execute();

		try {
			statement = connection.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
	}
	public static void buyPanierItemUsingClientId(Integer client_id)throws SQLException{
		// TODO Auto-generated method stub
				
				ConnexionBDD mysqlConnect = new ConnexionBDD();
				String sql = "UPDATE test.Panier "
						+ "SET etat_achat_fk= ? , date_achat=CURDATE() "
						+ "WHERE Panier.client_fk= ? AND Panier.etat_achat_fk= ?";
				try {
			  Connection connection =  mysqlConnect.connect();

			  //Execution et traitement de la réponse
				PreparedStatement statement=	connection.prepareStatement(sql);
				statement.setInt(1, PanierManager.ACHETE_STATE);
				statement.setInt(2, client_id);
				statement.setInt(3, PanierManager.EN_ATTENTE_STATE);
				statement.execute();
				
				
				}
				finally {
				    mysqlConnect.disconnect();
				}

				
	}
	public static Panier[] getClientBoughtItem(Integer id) {
		ArrayList<Panier> achats = new ArrayList<>();
		ConnexionBDD mysqlConnect = new ConnexionBDD();
		String sql = "SELECT test.Jeu.*, test.Jeu_Plateforme.*, test.Panier.* , test.Plateforme.*"
				+ "	FROM test.Panier"
				+ " INNER JOIN test.Jeu_Plateforme ON  test.Jeu_Plateforme.id = test.Panier.plateforme_jeu_fk "
				+ " INNER JOIN  test.Plateforme ON test.Plateforme.id = test.Jeu_Plateforme.plateforme_fk "
				+ " INNER JOIN test.Jeu ON test.Jeu.id=test.Jeu_Plateforme.jeu_fk "
				+ " WHERE test.Panier.client_fk = ? AND test.Panier.etat_achat_fk = ?";
		Connection connection =  mysqlConnect.connect();
			try {
				PreparedStatement statement=	connection.prepareStatement(sql);
				statement.setInt(1, id);
				statement.setInt(2, PanierManager.ACHETE_STATE);
				ResultSet res = statement.executeQuery();
				while(res.next())
				{
					Panier panier= new Panier();
					panier.setClient_fk(id);
					panier.setId(res.getInt("Panier.id"));
					panier.setDate_achat(res.getDate("Panier.date_achat"));
					
					Jeu jeu = new Jeu();
					Plateforme plateforme = new Plateforme();
					plateforme.setName(res.getString("Plateforme.nom"));
					
					jeu.setId(res.getInt("Jeu.id"));
					jeu.setPrix(res.getDouble("prix"));
					jeu.setTitle(res.getString("title"));
					jeu.setPlateforme_jeu_fk(res.getInt("Jeu_Plateforme.id"));
					jeu.setPlateforme(plateforme);
					
					panier.setJeu(jeu);
					panier.setDate_creation(res.getDate("Panier.date_creation"));
					achats.add(panier);
				}
				Panier[] result = achats.toArray(new Panier[achats.size()]);
				
				return result;

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
		return null;
	}
}
