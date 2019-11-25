package main;

import java.awt.Dimension;

import javax.swing.JFrame;

import controller.RegisterController;
import model.RegisterModel;
import service.RegisterService;
import view.RegisterView;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RegisterModel registerModel = new RegisterModel();
		RegisterView registerScreen = new RegisterView();
		RegisterService registerService = new RegisterService();
		RegisterController controller = new RegisterController(registerService,registerScreen);
		registerScreen.setTitle("Formulário");
		registerScreen.setResizable(false);
		//registerScreen.setPreferredSize(new Dimension(500,300));
		registerScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
