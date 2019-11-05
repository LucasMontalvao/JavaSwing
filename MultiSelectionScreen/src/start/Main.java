package start;

import java.awt.Dimension;

import javax.swing.JFrame;

import screens.MultipaneScreen;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MultipaneScreen frame = new MultipaneScreen();
		frame.setTitle("Nova Janela");
		frame.setPreferredSize(new Dimension(500, 300));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
