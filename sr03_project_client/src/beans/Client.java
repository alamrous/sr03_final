package beans;

import java.util.Date;


public class Client {
	public Client() {
		// TODO Auto-generated constructor stub
	}
	public Client(String name, String firstname, String pseudo, String email, Date birthdate, Date date_creation,
			String pwd, char gender, Integer state, String address, Integer id) {
		super();
		this.name = name;
		this.firstname = firstname;
		this.pseudo = pseudo;
		this.email = email;
		this.birthdate = birthdate;
		this.date_creation = date_creation;
		this.pwd = pwd;
		this.gender = gender;
		this.state = state;
		this.address = address;
		this.id = id;
	}
	private String name;
	private String firstname;
	private String pseudo;
	private String email;
	private Date birthdate;
	private Date date_creation;
	private String pwd;
	private char gender;
	private Integer state;
	private String address;
	
private Integer id;
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getFirstname() {
	return firstname;
}
public void setFirstname(String firstname) {
	this.firstname = firstname;
}
public String getPseudo() {
	return pseudo;
}
public void setPseudo(String pseudo) {
	this.pseudo = pseudo;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public Date getBirthdate() {
	return birthdate;
}
public void setBirthdate(Date birthdate) {
	this.birthdate = birthdate;
}
public Date getDate_creation() {
	return date_creation;
}
public void setDate_creation(Date date_creation) {
	this.date_creation = date_creation;
}
public String getPwd() {
	return pwd;
}
public void setPwd(String pwd) {
	this.pwd = pwd;
}
public char getGender() {
	return gender;
}
public void setGender(char gender) {
	this.gender = gender;
}
public Integer getState() {
	return state;
}
public void setState(Integer state) {
	this.state = state;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public void setGender(String string) {
	// TODO Auto-generated method stub
	this.gender = string.toCharArray()[0];
}


}
