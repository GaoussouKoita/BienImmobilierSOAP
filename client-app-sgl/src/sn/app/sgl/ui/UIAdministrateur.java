package sn.app.sgl.ui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import sn.app.gsl.ws.BienImmobilier;
import sn.app.gsl.ws.User;

import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;

public class UIAdministrateur extends JFrame{

	private static final long serialVersionUID = 272586446566837974L;
	
	//Declaration des composants graphiques
	private JTextField idUserTF;
	private JTextField nomUserTF;
	private JTextField prenomUserTF;
	private JTextField contactUserTF;
	private JTextField emailUserTF;
	private JTextField dateNaissanceUserTF;
	private JTextField adresseUserTF;
	private JTextField loginUserTF;
	private JTextField passwordUserTF;
	private JTextField rechercheTFUser;
	private JTextField rechercheTFBI;
	private JTable tableUsers;
	private JTable tableBI;
	private JTextField idTFBI;
	private JTextField adresseTFBI;
	private JTextField nbrePiecesBI;
	private JTextField loyerBI;
	private JRadioButton rdbtnAdmin;
	private JRadioButton rdbtnGestionnaire;
	private JButton btnSauvegarder;
	private JButton btnSupprimerUser;
	private JButton btnActualiserUser;
	private JButton btnRechercherUser;
	private JRadioButton rdbtnUpdateUser;
	private JButton btnDeconnexionUser;
	private JButton btnDesactiverBI;
	private JButton btnActualiserBI;
	private JButton btnRechercherBI;
	private JRadioButton rdbtnUpdateBI;
	private JButton btnDeconnexionBI;
	private JComboBox<String> comboMeuble;
	private JComboBox<String> comboTypeBI;
	private JComboBox<String> comboStatus;
	private JButton btnSauvegarderBI;
	private JComboBox<String> combUserSexe;
	private JTextArea detailsTFA;
	private String[] titleBien;
	private Object[][] dataBien;
	private Object[][] dataUsers;
	private String[] titleUsers;
	private JPanel panel_4;
	
	
	

	public UIAdministrateur() {
		setTitle("Administrateur");
		setResizable(false);
		setSize(new Dimension(900, 510));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Welcome Administrator");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		panel_1.add(tabbedPane);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Utilisateurs",new ImageIcon(UIAdministrateur.class.getResource("/images/img-users.png")), panel_2, null);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		panel_4 = new JPanel();
		panel_2.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 614, 380);
		panel_4.add(scrollPane);
		
		//initialisation de la table Users
		dataUsers = new Object[][] {};
		titleUsers = new String[] {
				"Id", "Nom", "Prenom", "Contact", "Email", "Date de Naissance", "Sexe", "Adresse", "Login", "Password", "Type de Compte"
			};
		
		tableUsers = new JTable(dataUsers, titleUsers);
		initTableUsers();
		
		scrollPane.setViewportView(tableUsers);
		
		JLabel lblNewLabel_1 = new JLabel("Id : ");
		lblNewLabel_1.setBounds(624, 12, 86, 14);
		panel_4.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nom : ");
		lblNewLabel_2.setBounds(624, 38, 67, 14);
		panel_4.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Prenom : ");
		lblNewLabel_3.setBounds(624, 63, 86, 14);
		panel_4.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Email : ");
		lblNewLabel_4.setBounds(624, 113, 86, 14);
		panel_4.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Date de Naissance : ");
		lblNewLabel_5.setBounds(624, 138, 118, 14);
		panel_4.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Sexe : ");
		lblNewLabel_6.setBounds(624, 163, 86, 14);
		panel_4.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Contact : ");
		lblNewLabel_7.setBounds(624, 88, 86, 14);
		panel_4.add(lblNewLabel_7);
		
		idUserTF = new JTextField();
		idUserTF.setEditable(false);
		idUserTF.setBounds(767, 9, 112, 20);
		panel_4.add(idUserTF);
		idUserTF.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Adresse : ");
		lblNewLabel_8.setBounds(624, 188, 118, 14);
		panel_4.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Login : ");
		lblNewLabel_9.setBounds(624, 213, 86, 14);
		panel_4.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Password : ");
		lblNewLabel_10.setBounds(624, 238, 118, 14);
		panel_4.add(lblNewLabel_10);
		
		nomUserTF = new JTextField();
		nomUserTF.setBounds(767, 35, 112, 20);
		panel_4.add(nomUserTF);
		
		
		prenomUserTF = new JTextField();
		prenomUserTF.setBounds(767, 60, 112, 20);
		panel_4.add(prenomUserTF);
		prenomUserTF.setColumns(10);
		
		contactUserTF = new JTextField();
		contactUserTF.setBounds(767, 85, 112, 20);
		panel_4.add(contactUserTF);
		contactUserTF.setColumns(10);
		
		emailUserTF = new JTextField();
		emailUserTF.setBounds(767, 110, 112, 20);
		panel_4.add(emailUserTF);
		emailUserTF.setColumns(10);
		
		dateNaissanceUserTF = new JTextField();
		dateNaissanceUserTF.setBounds(767, 135, 112, 20);
		panel_4.add(dateNaissanceUserTF);
		dateNaissanceUserTF.setColumns(10);
		
		adresseUserTF = new JTextField();
		adresseUserTF.setBounds(767, 185, 112, 20);
		panel_4.add(adresseUserTF);
		adresseUserTF.setColumns(10);
		
		loginUserTF = new JTextField();
		loginUserTF.setBounds(767, 210, 112, 20);
		panel_4.add(loginUserTF);
		loginUserTF.setColumns(10);
		
		passwordUserTF = new JTextField();
		passwordUserTF.setBounds(767, 235, 112, 20);
		panel_4.add(passwordUserTF);
		passwordUserTF.setColumns(10);
		combUserSexe = new JComboBox<String>(new DefaultComboBoxModel<String>(new String[] {"Homme", "Femme"}));
		combUserSexe.setMaximumRowCount(333);
		combUserSexe.setBounds(767, 160, 112, 20);
		panel_4.add(combUserSexe);
		
		rdbtnAdmin = new JRadioButton("Administrateur");
		rdbtnAdmin.setBounds(636, 277, 118, 23);
		rdbtnAdmin.setSelected(true);
		panel_4.add(rdbtnAdmin);
		
		rdbtnGestionnaire = new JRadioButton("Gestionnaire");
		rdbtnGestionnaire.setBounds(770, 277, 109, 23);
		panel_4.add(rdbtnGestionnaire);
		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnAdmin);
		bg.add(rdbtnGestionnaire);
		
		btnSauvegarder = new JButton("Sauvegarder");
		btnSauvegarder.setIcon(new ImageIcon(UIAdministrateur.class.getResource("/images/img-save.png")));
		btnSauvegarder.setBounds(689, 307, 150, 23);
		panel_4.add(btnSauvegarder);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.add(panel_5, BorderLayout.NORTH);
		panel_5.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JLabel lblNewLabel_11 = new JLabel("LISTE");
		lblNewLabel_11.setFont(new Font("Arial", Font.BOLD, 15));
		panel_5.add(lblNewLabel_11);
		
		Component horizontalStrut = Box.createHorizontalStrut(50);
		panel_5.add(horizontalStrut);
		
		btnSupprimerUser = new JButton("Supprimer");
		btnSupprimerUser.setIcon(new ImageIcon(UIAdministrateur.class.getResource("/images/img-delete.png")));
		panel_5.add(btnSupprimerUser);
		
		btnActualiserUser = new JButton("Actualiser");
		btnActualiserUser.setIcon(new ImageIcon(UIAdministrateur.class.getResource("/images/img-list.png")));
		panel_5.add(btnActualiserUser);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		panel_5.add(horizontalStrut_1);
		
		rechercheTFUser = new JTextField();
		panel_5.add(rechercheTFUser);
		rechercheTFUser.setColumns(10);
		
		btnRechercherUser = new JButton("Rechercher");
		btnRechercherUser.setIcon(new ImageIcon(UIAdministrateur.class.getResource("/images/img-research.png")));
		panel_5.add(btnRechercherUser);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		panel_5.add(horizontalStrut_2);
		
		rdbtnUpdateUser = new JRadioButton("Update");
		panel_5.add(rdbtnUpdateUser);
		
		Component horizontalStrut_1_1 = Box.createHorizontalStrut(20);
		panel_5.add(horizontalStrut_1_1);
		
		btnDeconnexionUser = new JButton("Deconnexion");
		btnDeconnexionUser.setIcon(new ImageIcon(UIAdministrateur.class.getResource("/images/img-deconnexion.png")));
		panel_5.add(btnDeconnexionUser);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Bien Immobilier", new ImageIcon(UIAdministrateur.class.getResource("/images/img-bien.png")), panel_3, null);
		panel_3.setLayout(new BorderLayout(0, 0));

		JPanel panel_5_1 = new JPanel();
		panel_5_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.add(panel_5_1, BorderLayout.NORTH);
		panel_5_1.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JLabel lblNewLabel_11_1 = new JLabel("LISTE");
		lblNewLabel_11_1.setFont(new Font("Arial", Font.BOLD, 15));
		panel_5_1.add(lblNewLabel_11_1);
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(50);
		panel_5_1.add(horizontalStrut_3);
		
		btnDesactiverBI = new JButton("Desactiver");
		btnDesactiverBI.setIcon(new ImageIcon(UIAdministrateur.class.getResource("/images/img-delete.png")));
		panel_5_1.add(btnDesactiverBI);
		
		btnActualiserBI = new JButton("Actualiser");
		btnActualiserBI.setIcon(new ImageIcon(UIAdministrateur.class.getResource("/images/img-list.png")));
		panel_5_1.add(btnActualiserBI);
		
		Component horizontalStrut_1_2 = Box.createHorizontalStrut(20);
		panel_5_1.add(horizontalStrut_1_2);
		
		rechercheTFBI = new JTextField();
		rechercheTFBI.setColumns(10);
		panel_5_1.add(rechercheTFBI);
		
		btnRechercherBI = new JButton("Rechercher");
		btnRechercherBI.setIcon(new ImageIcon(UIAdministrateur.class.getResource("/images/img-research.png")));
		panel_5_1.add(btnRechercherBI);
		
		Component horizontalStrut_2_1 = Box.createHorizontalStrut(20);
		panel_5_1.add(horizontalStrut_2_1);
		
		rdbtnUpdateBI = new JRadioButton("Update");
		panel_5_1.add(rdbtnUpdateBI);
		
		Component horizontalStrut_1_1_1 = Box.createHorizontalStrut(20);
		panel_5_1.add(horizontalStrut_1_1_1);
		
		btnDeconnexionBI = new JButton("Deconnexion");
		btnDeconnexionBI.setIcon(new ImageIcon(UIAdministrateur.class.getResource("/images/img-deconnexion.png")));
		panel_5_1.add(btnDeconnexionBI);
		
		JPanel panel_7 = new JPanel();
		panel_3.add(panel_7, BorderLayout.CENTER);
		panel_7.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 0, 646, 376);
		panel_7.add(scrollPane_1);
		
		//Initialisation de la table Bien Immobilier
		dataBien = new Object[][] {};
		titleBien = new String[] {
				"Id", "Adresse", "Nombre de Pieces", "Loyer", "Details", "Meuble", "TypeBI", "Status"
			};
		tableBI = new JTable(dataBien, titleBien);
		initTableBI();
		
		scrollPane_1.setViewportView(tableBI);
		
		JLabel lblNewLabel_12 = new JLabel("Id : ");
		lblNewLabel_12.setBounds(656, 26, 73, 14);
		panel_7.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("Adresse : ");
		lblNewLabel_13.setBounds(656, 51, 84, 14);
		panel_7.add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("Nombre de Pieces : ");
		lblNewLabel_14.setBounds(656, 91, 101, 14);
		panel_7.add(lblNewLabel_14);
		
		JLabel lblNewLabel_15 = new JLabel("Loyer : ");
		lblNewLabel_15.setBounds(656, 129, 92, 14);
		panel_7.add(lblNewLabel_15);
		
		JLabel lblNewLabel_16 = new JLabel("Meuble");
		lblNewLabel_16.setBounds(656, 222, 73, 14);
		panel_7.add(lblNewLabel_16);
		
		idTFBI = new JTextField();
		idTFBI.setEditable(false);
		idTFBI.setBounds(778, 23, 101, 20);
		panel_7.add(idTFBI);
		idTFBI.setColumns(10);
		
		adresseTFBI = new JTextField();
		adresseTFBI.setBounds(778, 54, 101, 20);
		panel_7.add(adresseTFBI);
		adresseTFBI.setColumns(10);
		
		nbrePiecesBI = new JTextField();
		nbrePiecesBI.setBounds(778, 88, 101, 20);
		panel_7.add(nbrePiecesBI);
		nbrePiecesBI.setColumns(10);
		
		loyerBI = new JTextField();
		loyerBI.setBounds(778, 126, 101, 20);
		panel_7.add(loyerBI);
		loyerBI.setColumns(10);
		
		JLabel lblNewLabel_18 = new JLabel("Type Bien : ");
		lblNewLabel_18.setBounds(656, 260, 84, 14);
		panel_7.add(lblNewLabel_18);
		
		JLabel lblNewLabel_19 = new JLabel("Status : ");
		lblNewLabel_19.setBounds(656, 285, 92, 14);
		panel_7.add(lblNewLabel_19);
		
		comboMeuble = new JComboBox<String>();
		comboMeuble.setModel(new DefaultComboBoxModel<String>(new String[] {"OUI", "NON"}));
		comboMeuble.setFont(new Font("Tahoma", Font.PLAIN, 11));
		comboMeuble.setBounds(778, 219, 101, 20);
		panel_7.add(comboMeuble);
		
		comboTypeBI = new JComboBox<String>();
		comboTypeBI.setModel(new DefaultComboBoxModel<String>(new String[] {"Appartement", "Studio", "Villa"}));
		comboTypeBI.setBounds(778, 250, 101, 20);
		panel_7.add(comboTypeBI);
		
		comboStatus = new JComboBox<String>();
		comboStatus.setModel(new DefaultComboBoxModel<String>(new String[] {"Disponible", "Occup\u00E9"}));
		comboStatus.setBounds(778, 282, 101, 20);
		panel_7.add(comboStatus);
		
		btnSauvegarderBI = new JButton("Sauvegarder");
		btnSauvegarderBI.setIcon(new ImageIcon(UIAdministrateur.class.getResource("/images/img-save.png")));
		btnSauvegarderBI.setBounds(682, 310, 161, 23);
		panel_7.add(btnSauvegarderBI);
		
		JLabel lblNewLabel_17 = new JLabel("Details : ");
		lblNewLabel_17.setBounds(656, 162, 46, 14);
		panel_7.add(lblNewLabel_17);
		
		detailsTFA = new JTextArea();
		detailsTFA.setLineWrap(true);
		detailsTFA.setColumns(10);
		detailsTFA.setRows(2);
		detailsTFA.setBounds(778, 157, 101, 51);
		panel_7.add(detailsTFA);
	}

	/*
	 * Methode d'initialisation de la tableBI
	 * Elle definit l'en tete et le corps de la table
	 */
	public void initTableBI() {
		
		tableBI.setModel(new DefaultTableModel(
			dataBien,
			titleBien
		) {
			private static final long serialVersionUID = 1L;
			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, Double.class, String.class, String.class, String.class, String.class
			};
			@SuppressWarnings({ "unchecked", "rawtypes" })
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
	}


	/*
	 * Methode d'initialisation de la tableUsers
	 * elle definit l'en tete et le corps de la tableUsers
	 */
	public void initTableUsers() {
		
		tableUsers.setModel(new DefaultTableModel(
			dataUsers,
			titleUsers
		) {
			
			private static final long serialVersionUID = 1L;
			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class
			};
			@SuppressWarnings({ "unchecked", "rawtypes" })
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
	}


	/*
	 * Les Getters sur les champs de saisis de la fenetre
	 * Ils retournent le contenu des differents champs
	 */
	public int getIdUserTF() {
		if(idUserTF.getText().isEmpty())
			return 0;
		return Integer.valueOf(idUserTF.getText());
	}


	public String getNomUserTF() {
		return nomUserTF.getText();
	}


	public String getPrenomUserTF() {
		return prenomUserTF.getText();
	}


	public String getContactUserTF() {
		return contactUserTF.getText();
	}


	public String getEmailUserTF() {
		return emailUserTF.getText();
	}


	public String getDateNaissanceUserTF() {
		return dateNaissanceUserTF.getText();
	}


	public String getAdresseUserTF() {
		return adresseUserTF.getText();
	}


	public String getLoginUserTF() {
		return loginUserTF.getText();
	}


	public String getPasswordUserTF() {
		return passwordUserTF.getText();
	}


	public int getRechercheTFUser() {
		return Integer.valueOf(rechercheTFUser.getText());
	}


	public int getRechercheTFBI() {
		return Integer.valueOf(rechercheTFBI.getText());
	}


	public int getIdTFBI() {
		if(idTFBI.getText().isEmpty())
			return 0;
		return Integer.valueOf(idTFBI.getText());
	}


	public String getAdresseTFBI() {
		return adresseTFBI.getText();
	}


	public int getNbrePiecesBI() {
		return Integer.valueOf(nbrePiecesBI.getText());
	}


	public double getLoyerBI() {
		return Double.valueOf(loyerBI.getText());
	}


	public String checkAdminSelected() {
		if (rdbtnGestionnaire.isSelected()) {
			return "Gestionnaire";
		}else {
			return "Administrateur";
		}
		
	}
	
	public boolean checkUpdateUser() {
		return rdbtnUpdateUser.isSelected();
	}


	public boolean checkUpdateBI() {
		return rdbtnUpdateBI.isSelected();
	}


	public String getComboMeuble() {
		return comboMeuble.getSelectedItem().toString();
	}


	public String getComboTypeBI() {
		return comboTypeBI.getSelectedItem().toString();
	}


	public String getComboStatus() {
		return comboStatus.getSelectedItem().toString();
	}


	public String getCombUserSexe() {
		return combUserSexe.getSelectedItem().toString();
	}
	
	

	public String getDetailsTFA() {
		return detailsTFA.getText();
	}
	
	//Vide les champs de saisis de la fenetre
	public void clearTF() {
		 	idUserTF.setText("");
			nomUserTF.setText("");
			prenomUserTF.setText("");
			contactUserTF.setText("");
			emailUserTF.setText("");
			dateNaissanceUserTF.setText("");
			adresseUserTF.setText("");
			loginUserTF.setText("");
			passwordUserTF.setText("");
			rechercheTFUser.setText("");
			rechercheTFBI.setText("");
			idTFBI.setText("");
			adresseTFBI.setText("");
			nbrePiecesBI.setText("");
			loyerBI.setText("");
			detailsTFA.setText("");
		
	}

	//Affiche une boite de dialogue de confirmation sur certaines actions
	public boolean conifrmeSuppression() {
		if(JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null, "Etes-vous sûr ?")){
			return true;
		}return false;
	}

	
	//Affiche les donnees d'un User sur une ligne dans la tableUser
	public void showInTableUser(User user) {
		((DefaultTableModel) tableUsers.getModel()).addRow(new Object[] 
				{user.getId(), user.getNom(), user.getPrenom(), user.getContact(), user.getEmail(),
						user.getDateNaissance(), user.getSexe(), user.getAdresse(), 
						user.getLogin(), user.getPassword(), user.getTypeCompte()});
	}
	
	
	//Affiche les donnees d'un Bien sur une ligne dans la tableBienDispo
	public void showInTableBienDispo(BienImmobilier bien) {
		((DefaultTableModel) tableBI.getModel()).addRow(new Object[] 
				{bien.getId(),	bien.getAdresse(),bien.getNbrePiece(), bien.getLoyer(), 
						bien.getDetails(), bien.getMeuble(), bien.getTypeBI(), bien.getStatus()});
	}
	
	/*
	 * Recupere les donnees d'une ligne dans la tableUsers
	 * Puis remplit les champs de saisis avec ces donnees
	 */
	public void selectLineInTableUsers() {
		
		DefaultTableModel model=(DefaultTableModel) tableUsers.getModel();
		int ligne = tableUsers.getSelectedRow();
		
		int id = (int) model.getValueAt(ligne, 0);
		String nom = (String) model.getValueAt(ligne, 1);
		String prenom = (String) model.getValueAt(ligne, 2);
		String contact= (String) model.getValueAt(ligne, 3);
		String email = (String) model.getValueAt(ligne, 4);
		String dateNaissance = (String) model.getValueAt(ligne, 5);
		String adresse = (String) model.getValueAt(ligne, 7);
		String login = (String) model.getValueAt(ligne, 8);
		String password = (String) model.getValueAt(ligne, 9);
		
		idUserTF.setText(String.valueOf(id));
		nomUserTF.setText(nom);
		prenomUserTF.setText(prenom);
		contactUserTF.setText(contact);
		emailUserTF.setText(email);
		dateNaissanceUserTF.setText(dateNaissance);
		adresseUserTF.setText(adresse);
		loginUserTF.setText(login);
		passwordUserTF.setText(password);
		
	}
	
	/*
	 * Recupere les donnees d'une ligne dans la tableBI
	 * Puis remplit les champs de saisis avec ces donnees
	 */
	public void selectLineInTableBI() {
		DefaultTableModel model = (DefaultTableModel) tableBI.getModel();
		int ligne = tableBI.getSelectedRow();
		
		int id = (int) model.getValueAt(ligne, 0);
		String adresse =(String) model.getValueAt(ligne, 1);
		int nbrePiece = (int) model.getValueAt(ligne, 2);
		double loyer = (double) model.getValueAt(ligne, 3);
		String detail = (String) model.getValueAt(ligne, 4);
		
		idTFBI.setText(String.valueOf(id));
		adresseTFBI.setText(adresse);
		nbrePiecesBI.setText(String.valueOf(nbrePiece));
		loyerBI.setText(String.valueOf(loyer));
		detailsTFA.setText(detail);
		
	}
	
	//Execute la fenetre en le rendant visible
	public void run() {
		this.setVisible(true);
		
	}

	/*
	 * Ajout des ecouteurs sur les boutons de la fenetre
	 */
	public void addBtnSauvegarderUserListener(ActionListener actionListener) {
		btnSauvegarder.addActionListener(actionListener);
		
	}
	
	public void addBtnSupprimerUserListener(ActionListener actionListener) {
		btnSupprimerUser.addActionListener(actionListener);
		
	}

	public void addBtnActualiserUserListener(ActionListener actionListener) {
		btnActualiserUser.addActionListener(actionListener);
		
	}
	
	public void addBtnRechercherUserListener(ActionListener actionListener) {
		btnRechercherUser.addActionListener(actionListener);
		
	}

	public void addBtnDeconnexionUserListener(ActionListener actionListener) {
		btnDeconnexionUser.addActionListener(actionListener);
		
	}


	public void addBtnSauvegarderBIListener(ActionListener actionListener) {
		btnSauvegarderBI.addActionListener(actionListener);
		
	}


	public void addBtnDesactiverBIListener(ActionListener actionListener) {
		btnDesactiverBI.addActionListener(actionListener);
		
	}

	public void addBtnActualiserBIListener(ActionListener actionListener) {
		btnActualiserBI.addActionListener(actionListener);
	}
	
	public void addBtnRechercherBIListener(ActionListener actionListener) {
		btnRechercherBI.addActionListener(actionListener);
	}

	public void addBtnDeconnexionBIListener(ActionListener actionListener) {
		btnDeconnexionBI.addActionListener(actionListener);
		
	}
	
	/*
	 * Ajout des ecouteurs sur le clic sur une ligne des tables Users et Bien immobilier
	 */
	public void addSelectLineTableUserListerner(MouseAdapter adapter) {
		tableUsers.addMouseListener(adapter);
	}
	
	public void addSelectLineTableBienListener(MouseAdapter adapter) {
		tableBI.addMouseListener(adapter);
	}
}