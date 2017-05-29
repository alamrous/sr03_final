package beans;

public class Country {
public Country(Integer id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}
public Country() {
	// TODO Auto-generated constructor stub
}
public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
private Integer id;
private String nom;
}
