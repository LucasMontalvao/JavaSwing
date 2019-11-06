package screens;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.text.DecimalFormat;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;


public class MultipaneScreen extends JFrame {
	
	
	public MultipaneScreen() {
		//menu principal
		JMenuBar topMenuBar = new JMenuBar();
		
		// Cria o menu Arquivo
		JMenu menuFile = new JMenu("Arquivo");
		menuFile.setMnemonic(KeyEvent.VK_A);
				
		// Cria os itens do menu
		JMenuItem item = new JMenuItem("Sair",KeyEvent.VK_I);
		item.addActionListener(new ActionListener() {
					
			@Override
			public void actionPerformed(ActionEvent e) {
			// Fecha a tela
			//frame.setVisible(false);
			//frame.dispose();
					dispatchEvent(new WindowEvent(MultipaneScreen.this, WindowEvent.WINDOW_CLOSING));
			}
		});
		
		menuFile.add(item);
		
		//Cria menu editar
		JMenu menuEdit = new JMenu("Editar");
		JMenuItem cleanFields = new JMenuItem("Limpar Campos");
		cleanFields.setSelected(true);
		cleanFields.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				JOptionPane.showMessageDialog(null, "Item selecionado? "+ cleanFields.isSelected());
			}
		});
		
		JCheckBoxMenuItem flagButtonCoins = new JCheckBoxMenuItem("Exibir Moedas");
		JCheckBoxMenuItem flagButtonTemp = new JCheckBoxMenuItem("Exibir Temperaturas");
		JCheckBoxMenuItem flagButtonLenghts = new JCheckBoxMenuItem("Exibir Comprimentos");
		
		ButtonGroup flagButtonGroup = new ButtonGroup();
		flagButtonGroup.add(flagButtonCoins);
		flagButtonGroup.add(flagButtonTemp);
		flagButtonGroup.add(flagButtonLenghts);
		
		menuEdit.add(cleanFields);
		menuEdit.addSeparator();
		menuEdit.add(flagButtonCoins);
		menuEdit.add(flagButtonTemp);
		menuEdit.add(flagButtonLenghts);
		
		//Cria menu Ajuda
		JMenu menuHelp = new JMenu("Ajuda");
		JMenuItem developerOption = new JMenuItem("Desenvolvedores");
		JMenuItem gitRepositoryOption = new JMenuItem("Repositório do Github");
		gitRepositoryOption.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Programinha de conversão de valores");
			}
		});
		JMenuItem aboutOption = new JMenuItem("Sobre");
		aboutOption.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Programinha de conversão de valores");
			}
		});
		
		menuHelp.add(developerOption);
		menuHelp.add(gitRepositoryOption);
		menuHelp.add(aboutOption);
		
		// Adicina o menu na barra
		topMenuBar.add(menuFile);
		topMenuBar.add(menuEdit);
		topMenuBar.add(menuHelp);
				
		//Adiciona Menu Bar
		setJMenuBar(topMenuBar);
		
		
		
		
		JTabbedPane tabPane = new JTabbedPane();
		ImageIcon icon = new ImageIcon("/imgs/icone_folder.png");
		tabPane.addTab("moeda", icon, createCoinPanel(), "Hint to Tab");
		tabPane.addTab("temperatura", icon, createTempPanel(), "Hint to Tab");
		tabPane.addTab("comprimento", icon, createLengthPanel(), "Hint to Tab");
		
		add(tabPane);
		pack();
		show();
		
		
	}
	private JPanel createCoinPanel() {
		JPanel panel = new JPanel();
		JTextField originalLabel = new JTextField();
		JTextField convertedLabel = new JTextField();
		JLabel fromConvertedLabel = new JLabel("De: ");
		String coinComboBox [] = {"Real","Dollar","Euro"};
		
		JComboBox<String> comboBoxInicialValue = new JComboBox<String>(coinComboBox);
		comboBoxInicialValue.setSelectedIndex(0);
		JLabel toConvertedLabel = new JLabel("                    Para: ");
		JComboBox<String> comboBoxConvertedValue = new JComboBox<String>(coinComboBox);
		comboBoxConvertedValue.setSelectedIndex(0);
		originalLabel.setPreferredSize(new Dimension(65, 25));
		convertedLabel.setPreferredSize(new Dimension(65, 25));
		JButton convertButton = new JButton();
		convertButton.setPreferredSize(new Dimension(130, 25));
		convertButton.setText("Converter");
		convertButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String tempDe = (String) comboBoxInicialValue.getSelectedItem();
				String tempPara = (String) comboBoxConvertedValue.getSelectedItem();
				double valorDe = Double.parseDouble(originalLabel.getText());
				double valorPara = 0;
				if(tempDe.equals("Real") && tempPara.equals("Euro")) {
					valorPara = valorDe * 0.23;
				}
				if(tempDe.equals("Real") && tempPara.equals("Dollar")) {
					valorPara = valorDe * 0.25; 
				}
				if(tempDe.equals("Dollar") && tempPara.equals("Euro")) {
					valorPara = valorDe * 0.90; 
				}
				if(tempDe.equals("Dollar") && tempPara.equals("Real")) {
					valorPara = valorDe * 4.00; 
				}
				if(tempDe.equals("Euro") && tempPara.equals("Dollar")) {
					valorPara = valorDe * 1.11; 
				}
				if(tempDe.equals("Euro") && tempPara.equals("Real")) {
					valorPara = valorDe * 4.42; 
				}
				if((tempDe.equals("Euro")) && tempPara.equals("Euro") || (tempDe.equals("Dollar") && tempPara.equals("Dollar")) || 
						(tempDe.equals("Real") && tempPara.equals("Real"))){
					valorPara = valorDe;
				}
				DecimalFormat df = new DecimalFormat("#.00");
				convertedLabel.setText(df.format(valorPara));
				valorDe = 0;
				valorPara = 0;
			}
		});
		
		
		panel.setBorder(BorderFactory.createEmptyBorder(0,0, 0, 10));
		panel.add(fromConvertedLabel);
		panel.add(comboBoxInicialValue);
		panel.add(originalLabel);
		JPanel x = new JPanel();
		x.setPreferredSize(new Dimension(0,10));
		panel.add(x);
		panel.add(toConvertedLabel);
		panel.add(comboBoxConvertedValue);
		panel.add(convertedLabel);
		panel.add(convertButton);
		panel.setPreferredSize(new Dimension(450, 250));
		return panel;
	}
	private JPanel createTempPanel() {
		JPanel painel1 = new JPanel();
		JTextField originalLabel = new JTextField();
		JTextField convertedLabel = new JTextField();
		JLabel fromConvertedLabel = new JLabel("De: ");
		String tempComboBox [] = {"Celsius","Kelvin"};
		
		JComboBox<String> comboBoxInicialValue = new JComboBox<String>(tempComboBox);
		
		comboBoxInicialValue.setSelectedIndex(0);
		JLabel toConvertedLabel = new JLabel("                    Para: ");
		
		originalLabel.setPreferredSize(new Dimension(65, 25));
		convertedLabel.setPreferredSize(new Dimension(65, 25));
		JButton convertButton = new JButton();
		convertButton.setPreferredSize(new Dimension(130, 25));
		convertButton.setText("Converter");
		
		JComboBox<String> comboBoxConvertedValue = new JComboBox<String>(tempComboBox);
		comboBoxConvertedValue.setSelectedIndex(0);
		convertButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String tempDe = (String) comboBoxInicialValue.getSelectedItem();
				String tempPara = (String) comboBoxConvertedValue.getSelectedItem();
				double valorDe = Double.parseDouble(originalLabel.getText());
				double valorPara = 0;
				if(tempDe.equals("Celsius") && tempPara.equals("Kelvin")) {
					valorPara = valorDe + 273;
				}
				if(tempDe.equals("Kelvin") && tempPara.equals("Celsius")) {
					valorPara = valorDe - 273; 
				}
				if((tempDe.equals("Celsius")) && tempPara.equals("Celsius") || (tempDe.equals("Kelvin") && tempPara.equals("Kelvin"))){
					valorPara = valorDe;
				}
				convertedLabel.setText(Double.toString(valorPara));
				valorDe = 0;
				valorPara = 0;
			}
		});
		painel1.setBorder(BorderFactory.createEmptyBorder(0,0, 0, 10));
		painel1.add(fromConvertedLabel);
		painel1.add(comboBoxInicialValue);
		painel1.add(originalLabel);
		JPanel x = new JPanel();
		x.setPreferredSize(new Dimension(0,10));
		painel1.add(x);
		painel1.add(toConvertedLabel);
		painel1.add(comboBoxConvertedValue);
		painel1.add(convertedLabel);
		painel1.add(convertButton);
		painel1.setPreferredSize(new Dimension(450, 250));
		return painel1;
	}
	
	private JPanel createLengthPanel() {
		JPanel panel = new JPanel();
		JTextField originalLabel = new JTextField();
		JTextField convertedLabel = new JTextField();
		JLabel fromConvertedLabel = new JLabel("De: ");
		String lengthUnitsComboBox [] = {"Metro","Milimetro"};
		JComboBox<String> comboBoxInicialValue = new JComboBox<String>(lengthUnitsComboBox);
		comboBoxInicialValue.setSelectedIndex(0);
		JLabel toConvertedLabel = new JLabel("                    Para: ");
		originalLabel.setPreferredSize(new Dimension(65, 25));
		convertedLabel.setPreferredSize(new Dimension(65, 25));
		JComboBox<String> comboBoxConvertedValue = new JComboBox<String>(lengthUnitsComboBox);
		comboBoxConvertedValue.setSelectedIndex(0);
		JButton convertButton = new JButton();
		convertButton.setPreferredSize(new Dimension(130, 25));
		convertButton.setText("Converter");
		convertButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String tempDe = (String) comboBoxInicialValue.getSelectedItem();
				String tempPara = (String) comboBoxConvertedValue.getSelectedItem();
				double valorDe = Double.parseDouble(originalLabel.getText());
				double valorPara = 0;
				if(tempDe.equals("Metro") && tempPara.equals("Milimetro")) {
					valorPara = valorDe * 1000;
				}
				if(tempDe.equals("Milimetro") && tempPara.equals("Metro")) {
					valorPara = valorDe / 1000; 
				}
				if((tempDe.equals("Metro")) && tempPara.equals("Metro") || (tempDe.equals("Milimetro") && tempPara.equals("Milimetro"))){
					valorPara = valorDe;
				}
				convertedLabel.setText(Double.toString(valorPara));
				valorDe = 0;
				valorPara = 0;
			}
		});
		
		

		panel.setBorder(BorderFactory.createEmptyBorder(0,0, 0, 10));
		panel.add(fromConvertedLabel);
		panel.add(comboBoxInicialValue);
		panel.add(originalLabel);
		panel.add(toConvertedLabel);
		panel.add(comboBoxConvertedValue);
		panel.add(convertedLabel);
		panel.add(convertButton);
		panel.setPreferredSize(new Dimension(450, 250));
		return panel;
	}
}
