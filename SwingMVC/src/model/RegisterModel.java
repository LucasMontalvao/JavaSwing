package model;

import java.util.Date;

public class RegisterModel {
	private int id;
	private String firstName;
	private String lastName;
	private String cpf;
	private String rg;
	private String email;
	private Date birthDate;
	private String user;
	private String password;
	
	public RegisterModel() {}
	
	public RegisterModel(int id, String firstName, String lastName, String cpf,
			String rg, String email, Date birthDate, String user, String password ) {
		setId(id);
		setFirstName(firstName);
		setLastName(lastName);
		setCpf(cpf);
		setRg(rg);
		setEmail(email);
		setBirthDate(birthDate);
		setUser(user);
		setPassword(password);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
