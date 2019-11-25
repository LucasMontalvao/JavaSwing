package service;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import controller.RegisterController;
import model.RegisterModel;
import view.RegisterView;

public class RegisterService implements IService {
	private RegisterController registerController;
	private RegisterModel registerModel;
	
	public RegisterService() {}
	
	public RegisterService(RegisterController registerController, RegisterModel registerModel) {
		this.registerController = registerController;
		this.registerModel = registerModel;
	}

	@Override
	public void notifyError() {
		registerController.notifyWarning();
	}

	@Override
	public void addUser(RegisterView form) throws ParseException {
		if(form.getFisrtNameField().getText() == null 	|| form.getLastNamefield().getText() == null ||
				form.getCpfField().getText() == null 	|| form.getRgField().getText() == null 		 || 
				form.getEmailField().getText() == null 	|| form.getBirthdayField().getText() == null ||
				(form.getPasswordField().getText() == null || (form.getPasswordField().getText() != 
				form.getConfirmPasswordField().getText()))) 
		{
			notifyError();
		}
		else {
			registerModel.setFirstName(form.getFisrtNameField().getText());
			registerModel.setLastName(form.getLastNamefield().getText());
			registerModel.setCpf(form.getCpfField().getText());
			registerModel.setRg(form.getRgField().getText());
			registerModel.setEmail(form.getEmailField().getText());
			registerModel.setBirthDate(new SimpleDateFormat("dd/MM/yyyy").parse(form.getBirthdayField().getText()));
			registerModel.setUser(form.getUserField().getText());
			registerModel.setPassword(form.getPasswordField().getText());
		}
	}
}
