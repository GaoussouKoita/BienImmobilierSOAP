package sn.app.sgl.ui;

import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.Color;

public class UIConnexion extends JFrame{
	
	private static final long serialVersionUID = -3259697904844405682L;
	
	//Decalaration des composants graphiques
	private JTextField loginTF;
	private JPasswordField passwordTF;
	private JButton btnConnexion;
	
	public UIConnexion() {
		setResizable(false);
		setTitle("Systeme de Gestion de Loyer");
		setSize(new Dimension(545, 510));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
		flowLayout.setVgap(10);
		panel.add(panel_2, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Connexion");
		lblNewLabel.setFont(new Font("Algerian", Font.BOLD, 24));
		panel_2.add(lblNewLabel);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3, BorderLayout.CENTER);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(UIConnexion.class.getResource("/images/img-user.png")));
		panel_3.add(lblNewLabel_3);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Login");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(145, 11, 116, 25);
		panel_1.add(lblNewLabel_1);
		
		loginTF = new JTextField();
		loginTF.setFont(new Font("Tahoma", Font.PLAIN, 16));
		loginTF.setBounds(165, 46, 245, 25);
		panel_1.add(loginTF);
		loginTF.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(145, 72, 116, 25);
		panel_1.add(lblNewLabel_2);
		
		passwordTF = new JPasswordField();
		passwordTF.setFont(new Font("Tahoma", Font.PLAIN, 16));
		passwordTF.setEchoChar('*');
		passwordTF.setColumns(15);
		passwordTF.setBounds(165, 108, 245, 25);
		panel_1.add(passwordTF);
		
		btnConnexion = new JButton("Connexion");
		btnConnexion.setToolTipText("");
		btnConnexion.setBackground(Color.BLUE);
		btnConnexion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnConnexion.setBounds(214, 157, 149, 25);
		panel_1.add(btnConnexion);
	}
	
	//Execution de la fenetre, elle rend la fenetre visible
	public void run() {
		this.setVisible(true);
	}

	/*
	 * Les Getters dur les champs TextFields de la fenetre
	 * ils retournent la chaines de caracteres contenues dans les 2 champs de saisis
	 */
	public String getLoginTF() {
		return loginTF.getText();
	}

	public String getPasswordTF() {
		return String.valueOf(passwordTF.getPassword());
	}
	
	
	//Intialise les champs de saisis les vidant
	public void clearTF() {
		loginTF.setText("");
		passwordTF.setText("");
	}

	//Ecouteur sur le bouton connexion de la fenetre
	public void addBtnConnexionListener(ActionListener actionListener) {
		btnConnexion.addActionListener(actionListener); 
		
	}

	//Affiche une boite de dailogue a l'ecran
	public void showMessage(String message, String titre, int errorMessage) {
		JOptionPane.showMessageDialog(null, message, titre, errorMessage);
		
	}
	
	//Fermer la fenetre en liberant les ressources
	public void exitView() {
		dispose();
	}
	
	
}
