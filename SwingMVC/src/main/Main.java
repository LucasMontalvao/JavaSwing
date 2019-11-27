package main;

import java.awt.Dimension;

import javax.swing.JFrame;

import controller.RegisterController;
import model.RegisterModel;
import view.RegisterView;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RegisterView registerScreen = new RegisterView();
		registerScreen.setTitle("Formulário");
		registerScreen.setResizable(false);
		//registerScreen.setPreferredSize(new Dimension(500,300));
		registerScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
