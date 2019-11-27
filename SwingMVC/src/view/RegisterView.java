package view;

import java.awt.Dimension;
import java.text.ParseException;


import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.RegisterController;

public class RegisterView extends JFrame implements IRegisterView{
	private JPanel panel;
	private JTextField fisrtNameField;
	private JTextField lastNamefield;
	private JTextField emailField;
	private JTextField userField;
	private JFormattedTextField cpfField;
	private JFormattedTextField rgField;
	private JFormattedTextField birthdayField;
	private JPasswordField passwordField;
	private JPasswordField confirmPasswordField;
	private JButton addUser;
	private JButton cancel;
	

	private RegisterController registerController;
	
	
	public RegisterView() {
		registerController =  new RegisterController(this);
		panel = new JPanel();
		panel.setLayout(null); //se não desabilitar essa merda nada mais funciona
		panel.setPreferredSize(new Dimension(600, 270));
		
		panel.add(createLabel("Digite seu nome:", 10, 10, 100, 20));
		fisrtNameField = createTextField(110, 10, 230, 25);
		panel.add(fisrtNameField);
		
		panel.add(createLabel("Digite seu sobrenome:", 10, 40, 130, 20));
		lastNamefield = createTextField(140, 40, 200, 25);
		panel.add(lastNamefield);
		
		panel.add(createLabel("Digite seu CPF:", 350, 10, 90, 20));
		cpfField = createMaskedTextField("###.###.###-##", 450, 10, 95, 25);
		panel.add(cpfField);
		
		panel.add(createLabel("Digite seu RG:", 350, 40, 80, 20));
		rgField = createMaskedTextField("#.###.###", 450, 40, 65, 25);
		panel.add(rgField);
		
		panel.add(createLabel("Digite seu email:", 10, 70, 100, 20));
		emailField = createTextField(110, 70, 230, 25); 
		panel.add(emailField);
		
		panel.add(createLabel("Digite sua data de nascimento:", 350, 70, 180, 25));
		birthdayField = createMaskedTextField("##/##/####", 530, 70, 70, 25); 
		panel.add(birthdayField);
		
		panel.add(createLabel("Seu usuário de sistema:", 100, 130, 140, 25));
		userField = createTextField(250, 130, 190, 25); 
		panel.add(userField);
		
		panel.add(createLabel("Digite sua senha:", 10, 180, 100, 25));
		passwordField = createPasswordField(110, 180, 250, 25); 
		panel.add(passwordField);
		
		panel.add(createLabel("Digite a senha novamente:", 10, 210, 150, 25));
		confirmPasswordField = createPasswordField(160, 210, 200, 25);
		panel.add(confirmPasswordField);
		
		cancel = createButton("Cancelar", 200, 240, 100, 25);
		panel.add(cancel);
		addUser = createButton("Cadastrar", 300, 240, 100, 25);
		panel.add(addUser);
		
		add(panel);
		pack();
		show();
	}
	
	public JLabel createLabel(String text,int x, int y, int width, int height) {
		JLabel label = new JLabel();
		label.setText(text);
		label.setBounds(x, y, width, height);
		return label;
	}
	
	public JTextField createTextField(int x, int y, int width, int height) {
		JTextField field = new JTextField();
		field.setBounds(x, y, width, height);
		return field;
	}
	
	public JFormattedTextField createMaskedTextField(String format, int x, int y, int width, int height) {
		JFormattedTextField maskedField = new JFormattedTextField();
		try {
			maskedField = new JFormattedTextField(new MaskFormatter(format));
		}catch(ParseException e) {
			e.printStackTrace();
		}
		maskedField.setBounds(x, y, width, height);
		return maskedField;
	}
	
	public JPasswordField createPasswordField(int x, int y, int width, int height) {
		JPasswordField passwordField = new JPasswordField();
		passwordField.setBounds(x , y, width, height);
		return passwordField;
	}
	
	public JButton createButton(String text, int x, int y, int width, int height) {
		JButton button = new JButton();
		button.setText(text);
		button.setBounds(x, y, width, height);
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if(button.getText() == "Cadastrar") {
						newRegisterAdded();
					}
				}catch (Exception e1) {
					e1.printStackTrace();
				}
			}
			
		});
		return button;
	}
	@Override
	public void newRegisterAdded() throws ParseException {
		registerController.addRegister();
	}
	
	public void sendErrorNotification() {
		JOptionPane.showMessageDialog(panel, "Há um erro no formulário, "
				+ "ou algum campo está vazio", "Inane warning", JOptionPane.WARNING_MESSAGE);
	}

	public JTextField getFisrtNameField() {
		return fisrtNameField;
	}

	public void setFisrtNameField(JTextField fisrtNameField) {
		this.fisrtNameField = fisrtNameField;
	}

	public JTextField getLastNamefield() {
		return lastNamefield;
	}

	public void setLastNamefield(JTextField lastNamefield) {
		this.lastNamefield = lastNamefield;
	}

	public JTextField getEmailField() {
		return emailField;
	}

	public void setEmailField(JTextField emailField) {
		this.emailField = emailField;
	}

	public JTextField getUserField() {
		return userField;
	}

	public void setUserField(JTextField userField) {
		this.userField = userField;
	}

	public JFormattedTextField getCpfField() {
		return cpfField;
	}

	public void setCpfField(JFormattedTextField cpfField) {
		this.cpfField = cpfField;
	}

	public JFormattedTextField getRgField() {
		return rgField;
	}

	public void setRgField(JFormattedTextField rgField) {
		this.rgField = rgField;
	}

	public JFormattedTextField getBirthdayField() {
		return birthdayField;
	}

	public void setBirthdayField(JFormattedTextField birthdayField) {
		this.birthdayField = birthdayField;
	}

	public JPasswordField getPasswordField() {
		return passwordField;
	}

	public void setPasswordField(JPasswordField passwordField) {
		this.passwordField = passwordField;
	}

	public JPasswordField getConfirmPasswordField() {
		return confirmPasswordField;
	}

	public void setConfirmPasswordField(JPasswordField confirmPasswordField) {
		this.confirmPasswordField = confirmPasswordField;
	}
	public JButton getAddUser() {
		return addUser;
	}

	public void setAddUser(JButton addUser) {
		this.addUser = addUser;
	}

	public JButton getCancel() {
		return cancel;
	}

	public void setCancel(JButton cancel) {
		this.cancel = cancel;
	}
	
}
