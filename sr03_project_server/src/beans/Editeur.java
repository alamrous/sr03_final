package beans;

public class Editeur {
public Editeur(Integer id, String description, Country country_fk) {
		super();
		this.id = id;
		this.description = description;
		this.country_fk = country_fk;
	}
public Editeur() {
	// TODO Auto-generated constructor stub
}
public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Country getCountry_fk() {
		return country_fk;
	}
	public void setCountry_fk(Country country_fk) {
		this.country_fk = country_fk;
	}
private Integer id;
private String description;
private Country country_fk;

}
