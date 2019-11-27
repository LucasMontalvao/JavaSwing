package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import model.RegisterModel;
import view.RegisterView;


public class RegisterController implements IRegisterController {
	private RegisterModel registerModel;
	private RegisterView registerView;
	
	public RegisterController(RegisterView registerView) {
		this.registerModel = new RegisterModel();
		this.registerView = registerView;
	}
	
	@Override
	public void notifyView(RegisterModel form) {
		
	}
	
	public void addRegister() throws ParseException {
		if(registerView.getFisrtNameField().getText() == null 	|| registerView.getLastNamefield().getText() == null ||
				registerView.getCpfField().getText() == null 	|| registerView.getRgField().getText() == null 		 || 
				registerView.getEmailField().getText() == null 	|| registerView.getBirthdayField().getText() == null ||
				(registerView.getPasswordField().getText() == null || (registerView.getPasswordField().getText() != 
						registerView.getConfirmPasswordField().getText()))) 
		{
			notifyWarning();
		}
		else {
			registerModel.setFirstName(registerView.getFisrtNameField().getText());
			registerModel.setLastName(registerView.getLastNamefield().getText());
			registerModel.setCpf(registerView.getCpfField().getText());
			registerModel.setRg(registerView.getRgField().getText());
			registerModel.setEmail(registerView.getEmailField().getText());
			registerModel.setBirthDate(new SimpleDateFormat("dd/MM/yyyy").parse(registerView.getBirthdayField().getText()));
			registerModel.setUser(registerView.getUserField().getText());
			registerModel.setPassword(registerView.getPasswordField().getText());
		}
		
	}
	
	public void notifyWarning() {
		registerView.sendErrorNotification();
	}
	@Override
	public void addUser(RegisterView form) {
		
	}


}
