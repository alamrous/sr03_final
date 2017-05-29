package beans;


public class Jeu {
private Integer id;
private String title;
private Pegi fk_pegi;
private Double note;
private String summary;
private Editeur fk_editeur;
private Integer plateforme_jeu_fk;
private Plateforme plateforme;
private double prix;
public Jeu() {
	
	super();
	// TODO Auto-generated constructor stub
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public Pegi getFk_pegi() {
	return fk_pegi;
}
public void setFk_pegi(Pegi fk_pegi) {
	this.fk_pegi = fk_pegi;
}
public Double getNote() {
	return note;
}
public void setNote(Double note) {
	this.note = note;
}
public String getSummary() {
	return summary;
}
public void setSummary(String summary) {
	this.summary = summary;
}
public Editeur getFk_editeur() {
	return fk_editeur;
}
public void setFk_editeur(Editeur fk_editeur) {
	this.fk_editeur = fk_editeur;
}
public Jeu(Integer id, String title, Pegi fk_pegi, Double note, String summary, Editeur fk_editeur) {
	super();
	this.id = id;
	this.title = title;
	this.fk_pegi = fk_pegi;
	this.note = note;
	this.summary = summary;
	this.fk_editeur = fk_editeur;
}
public void setPrix(double double1) {
	// TODO Auto-generated method stub
	this.prix = double1;
}
public Plateforme getPlateforme() {
	return plateforme;
}
public void setPlateforme(Plateforme plateforme) {
	this.plateforme = plateforme;
}
public double getPrix() {
	return prix;
}
public Integer getPlateforme_jeu_fk() {
	return plateforme_jeu_fk;
}
public void setPlateforme_jeu_fk(Integer plateforme_jeu_fk) {
	this.plateforme_jeu_fk = plateforme_jeu_fk;
}

}
