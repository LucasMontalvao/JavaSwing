package controller;

import java.text.ParseException;

import model.RegisterModel;
import service.RegisterService;
import view.RegisterView;

public class RegisterController implements IRegisterController {
	private RegisterService registerService;
	private RegisterView registerView;
	
	public RegisterController() {}
	public RegisterController(RegisterService registerService, RegisterView registerView) {
		this.registerService = registerService;
		this.registerView = registerView;
	}
	
	@Override
	public void notifyView(RegisterModel form) {
		
		
	}
	
	public void addRegister(RegisterView form) throws ParseException {
		registerService.addUser(form);
		
	}
	
	public void notifyWarning() {
		registerView.sendErrorNotification();
	}


}
