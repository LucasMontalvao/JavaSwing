package controller;

import java.text.ParseException;
import model.RegisterModel;
import service.RegisterService;
import view.RegisterView;


public class RegisterController implements IRegisterController {
	private RegisterService registerService;
	private RegisterView registerView;
	
	public RegisterController() {};
	public RegisterController(RegisterView registerView) {
		this.registerView = registerView;
		registerService = new RegisterService();
	}
	
	@Override
	public void notifyView(RegisterModel form) {
		
	}
	
	public void addRegister() throws ParseException {
		if(checkFirstNameField() 		||
				checkLastNameField() 	|| 
				checkCpfField()			|| 
				checkRgField() 		 	|| 
				checkEmailField()	 	|| 
				checkBirthdayField()	||
				checkPassWordField()) 
		{
			notifyWarning();
		}
		else {
			addUser(registerView);
		}
		
	}
	
	public void notifyWarning() {
		registerView.sendErrorNotification();
	}
	@Override
	public void addUser(RegisterView form) throws ParseException {
		registerService.addUser(form);
	}
	
	public boolean checkFirstNameField() {
		boolean check;
		if(registerView.getFisrtNameField().getText() == null) {
			check = true;
		}else {
			check = false;
		}
		return check;
	}
	public boolean checkLastNameField() {
		boolean check;
		if(registerView.getLastNamefield().getText() == null) {
			check = true;
		}else {
			check = false;
		}
		return check;
	}
	public boolean checkCpfField() {
		boolean check;
		if(registerView.getCpfField().getText() == null) {
			check = true;
		}else {
			check = false;
		}
		return check;
	}
	public boolean checkRgField() {
		boolean check;
		if(registerView.getRgField().getText() == null) {
			check = true;
		}else {
			check = false;
		}
		return check;
	}
	public boolean checkEmailField() {
		boolean check;
		if(registerView.getEmailField().getText() == null) {
			check = true;
		}else {
			check = false;
		}
		return check;
	}
	public boolean checkBirthdayField() {
		boolean check;
		if(registerView.getBirthdayField().getText() == null) {
			check = true;
		}else {
			check = false;
		}
		return check;
	}
	public boolean checkPassWordField() {
		boolean diffPasswords = false;
		boolean check;
		char[] senha = registerView.getPasswordField().getPassword();
		char[] confirmPassword = registerView.getConfirmPasswordField().getPassword();
		for(int i = 0; i < confirmPassword.length; i++) {
			if(senha[i] == confirmPassword[i]) {
				diffPasswords = false;
			}else {
				diffPasswords = true;
			}
		}
		if(senha != null && diffPasswords){
			check = true;
		}else {
			check = false;
		}
		senha = null;
		confirmPassword = null;
		return check;
	}
}
