package service;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import controller.RegisterController;
import model.RegisterDAO;
import model.RegisterModel;
import view.RegisterView;

public class RegisterService implements IService {
	private RegisterController registerController;
	
	public RegisterService() {}
	
	public RegisterService(RegisterController registerController, RegisterModel registerModel) {
		this.registerController = new RegisterController();
	}

	@Override
	public void notifyError() {
		registerController.notifyWarning();
	}

	@Override
	public void addUser(RegisterView form) throws ParseException {
		RegisterModel registerModel = new RegisterModel();
		registerModel.setFirstName(form.getFisrtNameField().getText());
		registerModel.setLastName(form.getLastNamefield().getText());
		registerModel.setCpf(form.getCpfField().getText());
		registerModel.setRg(form.getRgField().getText());
		registerModel.setEmail(form.getEmailField().getText());
		registerModel.setBirthDate(new SimpleDateFormat("dd/MM/yyyy").parse(form.getBirthdayField().getText()));
		registerModel.setUser(form.getUserField().getText());
		registerModel.setPassword(form.getPasswordField().getPassword());
		registerModel.addUser();
	}
	public void invokeDAO(RegisterModel registerModel) {
		RegisterDAO registerDAO = new RegisterDAO();
		registerDAO.addUser(registerModel);
	}
}
