package model;

import java.text.SimpleDateFormat;
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
	private char[] passWord;
	
	public RegisterModel() {}
	
	public RegisterModel(int id, String firstName, String lastName, String cpf,
			String rg, String email, Date birthDate, String user, char[] passWord ) {
		setId(id);
		setFirstName(firstName);
		setLastName(lastName);
		setCpf(cpf);
		setRg(rg);
		setEmail(email);
		setBirthDate(birthDate);
		setUser(user);
		setPassword(passWord);
	}
	
	public void addUser() {
		RegisterDAO registerDAO = new RegisterDAO();
		registerDAO.addUser(this);
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
		return this.cpf.replace(".", "").replace("-", "");
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return this.rg.replace(".", "");
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
	public String getBirthDate() {
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");  
	    String strDate= formatter.format(this.birthDate);
		return strDate;
	}
	public void setBirthDate(Date date) {
		this.birthDate = date;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		String sPassword = "";
		for(int i = 0; i < this.passWord.length; i++) {
			sPassword = sPassword.concat(Character.toString(this.passWord[i]));
		}
		return sPassword;
	}
	public void setPassword(char[] cs) {
		this.passWord = cs;
	}

}
