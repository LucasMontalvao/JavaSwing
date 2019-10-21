package br.univille.MyScreen;


import java.awt.Dimension;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.JLabel;

public class TelaLogin extends JFrame{

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setTitle("Nova Janela");
		frame.setSize(350,300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		JPanel painel = new JPanel();
		 painel.setLayout(null);
	        painel.setBackground(Color.LIGHT_GRAY);
	        painel.setBorder(
	                BorderFactory.createCompoundBorder(
	                        BorderFactory.createEmptyBorder(5, 5, 5, 5),
	                        BorderFactory.createTitledBorder(
	                                BorderFactory.createLineBorder(Color.BLACK),
	                                "Login"
	                        )
	                )
	        );
		// Borda sem linha, funciona como margens
		
		JLabel label = new JLabel();
		label.setText("Usuário");
		//label.setPreferredSize(new Dimension(280,10));
		label.setBounds(40, 40, 200, 10);
		
		JLabel label2 = new JLabel();
		label2.setText("Senha");
		//label.setPreferredSize(new Dimension(280,10));
		label2.setBounds(40, 80, 200, 10);
		
		JTextField text = new JTextField();
		text.setBounds(100, 30, 200, 30);

		JPasswordField text2 = new JPasswordField();
		text2.setBounds(100, 70, 200, 30);
		
		JButton btn = new JButton();
		btn.setBounds(140, 120, 100, 30);
		btn.setText("Acessar");
		btn.setBackground(Color.black);
		btn.setForeground(Color.white);
		
		JRadioButton radiobtn = new JRadioButton();
		radiobtn.setSelected(false);
		radiobtn.setBackground(Color.LIGHT_GRAY);
		radiobtn.setBounds(100, 175, 20, 10);
		
		JLabel label3 = new JLabel();
		label3.setText("Manter acessado");
		label3.setBounds(140, 175, 100, 10);
		label3.setBackground(Color.black);
		
		JLabel label4 = new JLabel();
		label4.setText("Esqueci minha senha");
		label4.setBounds(130, 210, 200, 10);
		label4.setForeground(Color.MAGENTA);
		
		painel.add(label);
		painel.add(text);
		painel.add(label2);
		painel.add(text2);
		painel.add(btn);
		painel.add(radiobtn);
		painel.add(label3);
		painel.add(label4);
		frame.add(painel);
		
		frame.setVisible(true);
		frame.show();
	}

}
