package beans;

import java.util.Date;

public class Panier {
private Integer id;
private Integer client_fk;
private Jeu jeu;
private Date date_creation;
private Date date_achat=null;
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public Integer getClient_fk() {
	return client_fk;
}
public void setClient_fk(Integer client_fk) {
	this.client_fk = client_fk;
}
public Jeu getJeu() {
	return jeu;
}
public void setJeu(Jeu jeu) {
	this.jeu = jeu;
}
public Date getDate_creation() {
	return date_creation;
}
public void setDate_creation(Date date_creation) {
	this.date_creation = date_creation;
}
public Date getDate_achat() {
	return date_achat;
}
public void setDate_achat(Date date_achat) {
	this.date_achat = date_achat;
}
}
