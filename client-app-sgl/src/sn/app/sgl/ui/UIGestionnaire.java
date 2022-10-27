package sn.app.sgl.ui;

import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JTabbedPane;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import sn.app.gsl.ws.BienImmobilier;
import sn.app.gsl.ws.Locataire;
import sn.app.gsl.ws.Payement;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;

public class UIGestionnaire extends JFrame{

	private static final long serialVersionUID = -4509034021451586456L;
	
	//Decalaratin des composants graphiques
	private JTextField recherchePayement;
	private JTable tableLocataire;
	private JTextField idLoc;
	private JTextField nomLoc;
	private JTextField prenomLoc;
	private JTextField contactLoc;
	private JTextField emailLoc;
	private JTextField dateNaissanceLoc;
	private JTextField numCINLoc;
	private JTextField idBienLoc;
	private JTable tableBien;
	private JTable tablePayement;
	private JTextField idPayement;
	private JTextField datePayement;
	private JTextField montantPayement;
	private JTextField nomLocPayement;
	private JTextField prenomLocPayement;
	private JTextField idBienPayement;
	private JButton btnSauvegarderLoc;
	private JButton btnDeconnexionLoc;
	private JButton btnSauvegarderPayement;
	private JButton btnSupprimerPayement;
	private JButton btnRechercherPayement;
	private JRadioButton rdbtnUpdatePayement;
	private JButton btnDeconnexionPayement;
	private JButton btnLibererBien;
	private JButton btnActualiserLoc;
	private JButton btnActualiserBI;
	private JButton btnDeconnexionBI;
	private JButton btnActualiserPayement;
	private JComboBox<String> sexeLoc;
	private Object[][] dataPayement;
	private String[] titlePayement;
	private Object[][] dataLocataire;
	private String[] titleLocataire;
	private Object[][] dataBien;
	private String[] titleBIen;
	private JComboBox<String> comboTypeLocation;
	

	public UIGestionnaire() {
		setTitle("Gestionnaire");
		setResizable(false);
		setSize(new Dimension(900, 510));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Welcome Manager");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		panel_1.add(tabbedPane);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Locataires", new ImageIcon(UIGestionnaire.class.getResource("/images/img-locataire.jpg")), panel_2, null);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_6 = new JPanel();
		panel_2.add(panel_6, BorderLayout.CENTER);
		panel_6.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 630, 370);
		panel_6.add(scrollPane);
		
		//Initialisation de la table Locataire
		dataLocataire = new Object[][] {};
		titleLocataire = new String[] {
				"Id", "Nom", "Prenom", "Contact", "Email", "Date de naissance", "Sexe", "Numero CIN", "Type Location", "Id Bien"
			};
		tableLocataire = new JTable(dataLocataire, titleLocataire);	
		initTableLocataire();	
		scrollPane.setViewportView(tableLocataire);
		
		JLabel lblNewLabel_1 = new JLabel("Id : ");
		lblNewLabel_1.setBounds(640, 31, 102, 14);
		panel_6.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nom : ");
		lblNewLabel_2.setBounds(640, 56, 77, 14);
		panel_6.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Prenom : ");
		lblNewLabel_3.setBounds(640, 81, 77, 14);
		panel_6.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Contact : ");
		lblNewLabel_4.setBounds(640, 106, 77, 14);
		panel_6.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Email : ");
		lblNewLabel_5.setBounds(640, 131, 77, 14);
		panel_6.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Date de naissance:");
		lblNewLabel_6.setBounds(640, 156, 105, 14);
		panel_6.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Numero CIN : ");
		lblNewLabel_7.setBounds(640, 206, 87, 14);
		panel_6.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Sexe : ");
		lblNewLabel_8.setBounds(640, 181, 60, 14);
		panel_6.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Type de Location : ");
		lblNewLabel_9.setBounds(636, 243, 115, 14);
		panel_6.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Id Bien : ");
		lblNewLabel_10.setBounds(640, 268, 77, 14);
		panel_6.add(lblNewLabel_10);
		
		btnSauvegarderLoc = new JButton("Sauvegarder");
		btnSauvegarderLoc.setIcon(new ImageIcon(UIGestionnaire.class.getResource("/images/img-save.png")));
		btnSauvegarderLoc.setBounds(668, 304, 154, 23);
		panel_6.add(btnSauvegarderLoc);
		
		idLoc = new JTextField();
		idLoc.setEditable(false);
		idLoc.setBounds(761, 11, 118, 20);
		panel_6.add(idLoc);
		idLoc.setColumns(10);
		
		nomLoc = new JTextField();
		nomLoc.setBounds(761, 39, 118, 20);
		panel_6.add(nomLoc);
		nomLoc.setColumns(10);
		
		prenomLoc = new JTextField();
		prenomLoc.setBounds(761, 72, 118, 20);
		panel_6.add(prenomLoc);
		prenomLoc.setColumns(10);
		
		contactLoc = new JTextField();
		contactLoc.setBounds(761, 103, 118, 20);
		panel_6.add(contactLoc);
		contactLoc.setColumns(10);
		
		emailLoc = new JTextField();
		emailLoc.setBounds(761, 128, 118, 20);
		panel_6.add(emailLoc);
		emailLoc.setColumns(10);
		
		dateNaissanceLoc = new JTextField();
		dateNaissanceLoc.setBounds(761, 153, 118, 20);
		panel_6.add(dateNaissanceLoc);
		dateNaissanceLoc.setColumns(10);
		
		sexeLoc = new JComboBox<String>();
		sexeLoc.setModel(new DefaultComboBoxModel<String>(new String[] {"Homme", "Femme"}));
		sexeLoc.setBounds(761, 178, 118, 20);
		panel_6.add(sexeLoc);
		
		numCINLoc = new JTextField();
		numCINLoc.setBounds(761, 203, 118, 20);
		panel_6.add(numCINLoc);
		numCINLoc.setColumns(10);
		
		idBienLoc = new JTextField();
		idBienLoc.setBounds(761, 265, 118, 20);
		panel_6.add(idBienLoc);
		idBienLoc.setColumns(10);
		
		comboTypeLocation = new JComboBox<String>();
		comboTypeLocation.setModel(new DefaultComboBoxModel<String>(new String[] {"Journalier", "Mensuel"}));
		comboTypeLocation.setBounds(761, 234, 118, 20);
		panel_6.add(comboTypeLocation);
		
		JPanel panel_5_1 = new JPanel();
		panel_5_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.add(panel_5_1, BorderLayout.NORTH);
		panel_5_1.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JLabel lblNewLabel_11 = new JLabel("LISTE");
		lblNewLabel_11.setFont(new Font("Arial", Font.BOLD, 15));
		panel_5_1.add(lblNewLabel_11);
		
		Component horizontalStrut = Box.createHorizontalStrut(50);
		panel_5_1.add(horizontalStrut);
		
		btnLibererBien = new JButton("Liberer Bien");
		btnLibererBien.setIcon(new ImageIcon(UIGestionnaire.class.getResource("/images/img-delete.png")));
		panel_5_1.add(btnLibererBien);
		
		btnActualiserLoc = new JButton("Actualiser");
		btnActualiserLoc.setIcon(new ImageIcon(UIGestionnaire.class.getResource("/images/img-list.png")));
		panel_5_1.add(btnActualiserLoc);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		panel_5_1.add(horizontalStrut_1);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(180);
		panel_5_1.add(horizontalStrut_2);
		
		Component horizontalStrut_1_1 = Box.createHorizontalStrut(100);
		panel_5_1.add(horizontalStrut_1_1);
		
		btnDeconnexionLoc = new JButton("Deconnexion");
		btnDeconnexionLoc.setIcon(new ImageIcon(UIGestionnaire.class.getResource("/images/img-deconnexion.png")));
		panel_5_1.add(btnDeconnexionLoc);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Bien Immobilier", new ImageIcon(
				UIGestionnaire.class.getResource("/images/img-bien.png")), panel_3, null);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_8 = new JPanel();
		panel_3.add(panel_8, BorderLayout.CENTER);
		panel_8.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 0, 889, 359);
		panel_8.add(scrollPane_1);
		
		//Initialisation de la table Bien
		dataBien = new Object[][] {};
		titleBIen = new String[] {
				"Id", "Adresse", "Nombre de Pieces", "Loyer", "Details", "Meuble", "Type Bien", "Status"
			};
		tableBien = new JTable(dataBien, dataBien);
		initTableBien();
		scrollPane_1.setViewportView(tableBien);
		
		JPanel panel_5_2 = new JPanel();
		panel_5_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.add(panel_5_2, BorderLayout.NORTH);
		panel_5_2.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JLabel lblNewLabel_11_1 = new JLabel("LISTE");
		lblNewLabel_11_1.setFont(new Font("Arial", Font.BOLD, 15));
		panel_5_2.add(lblNewLabel_11_1);
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(100);
		panel_5_2.add(horizontalStrut_3);
		
		btnActualiserBI = new JButton("Actualiser");
		btnActualiserBI.setIcon(new ImageIcon(UIGestionnaire.class.getResource("/images/img-list.png")));
		panel_5_2.add(btnActualiserBI);
		
		Component horizontalStrut_1_1_1 = Box.createHorizontalStrut(400);
		panel_5_2.add(horizontalStrut_1_1_1);
		
		btnDeconnexionBI = new JButton("Deconnexion");
		btnDeconnexionBI.setIcon(new ImageIcon(UIGestionnaire.class.getResource("/images/img-deconnexion.png")));
		panel_5_2.add(btnDeconnexionBI);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Payements", new ImageIcon(
				UIGestionnaire.class.getResource("/images/img-payement.png")), panel_4, null);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_10 = new JPanel();
		panel_4.add(panel_10, BorderLayout.CENTER);
		panel_10.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(0, 0, 594, 370);
		panel_10.add(scrollPane_2);
		
		//Initialisation de la table Payement
		dataPayement = new Object[][] {};
		titlePayement = new String[] {
				"Id", "Date Payement", "Montant", "Nom Locataire", "Prenom Locataire", "Id Bien"
			};
		tablePayement = new JTable(dataPayement, titlePayement);
		initTablePayement();
		scrollPane_2.setViewportView(tablePayement);
		
		JLabel lblNewLabel_12 = new JLabel("Id : ");
		lblNewLabel_12.setBounds(655, 48, 98, 14);
		panel_10.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("Date Payement : ");
		lblNewLabel_13.setBounds(655, 88, 109, 14);
		panel_10.add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("Nom Locataire : ");
		lblNewLabel_14.setBounds(655, 170, 109, 14);
		panel_10.add(lblNewLabel_14);
		
		JLabel lblNewLabel_15 = new JLabel("Prenom Locataire : ");
		lblNewLabel_15.setBounds(655, 207, 109, 14);
		panel_10.add(lblNewLabel_15);
		
		JLabel lblNewLabel_16 = new JLabel("Montant : ");
		lblNewLabel_16.setBounds(655, 128, 98, 14);
		panel_10.add(lblNewLabel_16);
		
		JLabel lblNewLabel_17 = new JLabel("Id Bien : ");
		lblNewLabel_17.setBounds(655, 245, 98, 14);
		panel_10.add(lblNewLabel_17);
		
		idPayement = new JTextField();
		idPayement.setEditable(false);
		idPayement.setBounds(773, 45, 106, 20);
		panel_10.add(idPayement);
		idPayement.setColumns(10);
		
		datePayement = new JTextField();
		datePayement.setBounds(774, 85, 105, 20);
		panel_10.add(datePayement);
		datePayement.setColumns(10);
		
		montantPayement = new JTextField();
		montantPayement.setBounds(774, 125, 105, 20);
		panel_10.add(montantPayement);
		montantPayement.setColumns(10);
		
		nomLocPayement = new JTextField();
		nomLocPayement.setBounds(774, 167, 105, 20);
		panel_10.add(nomLocPayement);
		nomLocPayement.setColumns(10);
		
		prenomLocPayement = new JTextField();
		prenomLocPayement.setBounds(773, 204, 105, 20);
		panel_10.add(prenomLocPayement);
		prenomLocPayement.setColumns(10);
		
		idBienPayement = new JTextField();
		idBienPayement.setBounds(773, 242, 105, 20);
		panel_10.add(idBienPayement);
		idBienPayement.setColumns(10);
		
		btnSauvegarderPayement = new JButton("Sauvegarder");
		btnSauvegarderPayement.setIcon(new ImageIcon(UIGestionnaire.class.getResource("/images/img-save.png")));
		btnSauvegarderPayement.setBounds(698, 302, 135, 23);
		panel_10.add(btnSauvegarderPayement);
		
		JPanel panel_5_3 = new JPanel();
		panel_5_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_4.add(panel_5_3, BorderLayout.NORTH);
		panel_5_3.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JLabel lblNewLabel_11_2 = new JLabel("LISTE");
		lblNewLabel_11_2.setFont(new Font("Arial", Font.BOLD, 15));
		panel_5_3.add(lblNewLabel_11_2);
		
		Component horizontalStrut_4 = Box.createHorizontalStrut(50);
		panel_5_3.add(horizontalStrut_4);
		
		btnSupprimerPayement = new JButton("Supprimer");
		btnSupprimerPayement.setIcon(new ImageIcon(UIGestionnaire.class.getResource("/images/img-delete.png")));
		panel_5_3.add(btnSupprimerPayement);
		
		btnActualiserPayement = new JButton("Actualiser");
		btnActualiserPayement.setIcon(new ImageIcon(UIGestionnaire.class.getResource("/images/img-list.png")));
		panel_5_3.add(btnActualiserPayement);
		
		Component horizontalStrut_1_3 = Box.createHorizontalStrut(20);
		panel_5_3.add(horizontalStrut_1_3);
		
		recherchePayement = new JTextField();
		recherchePayement.setColumns(10);
		panel_5_3.add(recherchePayement);
		
		btnRechercherPayement = new JButton("Rechercher");
		btnRechercherPayement.setIcon(new ImageIcon(UIGestionnaire.class.getResource("/images/img-research.png")));
		panel_5_3.add(btnRechercherPayement);
		
		Component horizontalStrut_2_2 = Box.createHorizontalStrut(20);
		panel_5_3.add(horizontalStrut_2_2);
		
		rdbtnUpdatePayement = new JRadioButton("Update");
		panel_5_3.add(rdbtnUpdatePayement);
		
		Component horizontalStrut_1_1_2 = Box.createHorizontalStrut(20);
		panel_5_3.add(horizontalStrut_1_1_2);
		
		btnDeconnexionPayement = new JButton("Deconnexion");
		btnDeconnexionPayement.setIcon(new ImageIcon(UIGestionnaire.class.getResource("/images/img-deconnexion.png")));
		panel_5_3.add(btnDeconnexionPayement);
		
		JPanel panel_5 = new JPanel();
		tabbedPane.addTab("Statisques", new ImageIcon(UIGestionnaire.class.getResource("/images/img-stat.png")), panel_5, null);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_12 = new JPanel();
		panel_5.add(panel_12, BorderLayout.CENTER);
		
		JPanel panel_13 = new JPanel();
		panel_5.add(panel_13, BorderLayout.SOUTH);
		
		
	}

	
	/*
	 * Mehode d'initailisation de la table Payement
	 * elle definit l'en tete et le corps de la table
	 */
	
	public void initTablePayement() {
		tablePayement.setModel(new DefaultTableModel(
			dataPayement,
			titlePayement
		) {
			private static final long serialVersionUID = 1L;
			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, Double.class, String.class, String.class, String.class
			};
			@SuppressWarnings({ "unchecked", "rawtypes" })
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
	}


	/*
	 * Methode d'initialisation de la table locatiare
	 * elle definit le corps et l'en tete de la table
	 */
	public void initTableLocataire() {
		tableLocataire.setModel(new DefaultTableModel(
			
			dataLocataire,
			titleLocataire
		) {
			private static final long serialVersionUID = 1L;
			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Integer.class
			};
			@SuppressWarnings({ "unchecked", "rawtypes" })
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
	}

	/*
	 * Initialisation de la table Bien Immobilier
	 * Elle definit l'en tete et le corps de la table
	 */
	public void initTableBien() {
		tableBien.setModel(new DefaultTableModel(
			dataBien,
			titleBIen
		) {
			private static final long serialVersionUID = 1L;
			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, Integer.class, Double.class, String.class, String.class, String.class, String.class
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
	
	//Methode rendant visible la fenetre
	public void run() {
		this.setVisible(true);
	}

	/*
	 * Les Getters sur les comoposants TextField et ComboBox
	 * de la fenetre. Ces getters retournent soit une chaine de caractere ou un entier
	 */
	public int getRecherchePayement() {
		return Integer.valueOf(recherchePayement.getText());
	}


	public int getIdLoc() {
		if (idLoc.getText().isEmpty()) {
			return 0;
		}
		return Integer.valueOf(idLoc.getText());
	}


	public String getNomLoc() {
		return nomLoc.getText();
	}


	public String getPrenomLoc() {
		return prenomLoc.getText();
	}


	public String getContactLoc() {
		return contactLoc.getText();
	}


	public String getEmailLoc() {
		return emailLoc.getText();
	}


	public String getDateNaissanceLoc() {
		return dateNaissanceLoc.getText();
	}


	public String getNumCINLoc() {
		return numCINLoc.getText();
	}


	public String getTypeLoc() {
		return comboTypeLocation.getSelectedItem().toString();
	}


	public int getIdBienLoc() {
		return Integer.valueOf(idBienLoc.getText());
	}


	public int getIdPayement() {
		if (idPayement.getText().isEmpty()) {
			return 0;
		}
		return Integer.valueOf(idPayement.getText());
	}


	public String getDatePayement() {
		return datePayement.getText();
	}


	public double getMontantPayement() {
		return Double.valueOf(montantPayement.getText());
	}


	public String getNomLocPayement() {
		return nomLocPayement.getText();
	}


	public String getPrenomLocPayement() {
		return prenomLocPayement.getText();
	}


	public int getIdBienPayement() {
		return Integer.valueOf(idBienPayement.getText());
	}


	public boolean checkUpdatePayement() {
		return rdbtnUpdatePayement.isSelected();
	}

	public String getSexeLoc() {
		return sexeLoc.getSelectedItem().toString();
	}
	
	//Methode permettant de vider tous les champs TextField de la fenetre
	public void clearTF() {
		
		recherchePayement.setText("");
		idLoc.setText("");
		nomLoc.setText("");
		prenomLoc.setText("");
		contactLoc.setText("");
		emailLoc.setText("");
		dateNaissanceLoc.setText("");
		numCINLoc.setText("");
		idBienLoc.setText("");
		idPayement.setText("");
		datePayement.setText("");
		montantPayement.setText("");
		nomLocPayement.setText("");
		prenomLocPayement.setText("");
		idBienPayement.setText("");
	}
	
	//Methode qui affiche les donnees d'un Payement sur la tablePayment de la fenetre
	public void showInTablePayement(Payement payement) {
		((DefaultTableModel) tablePayement.getModel()).addRow(new Object[] 
				{	payement.getId(), payement.getDatePayement(), payement.getMontant(), 
				payement.getNomLocataire(), payement.getPrenomLocataire(), payement.getIdBI()});
	}
	
	//Methode qui affiche les donnees d'un Locataire sur la tableLocataire de la fenetre
	public void showInTableLocataire(Locataire locataire) {
		((DefaultTableModel) tableLocataire.getModel()).addRow(new Object[] 
				{locataire.getId(), locataire.getNom(), locataire.getPrenom(), locataire.getContact(), 
						locataire.getEmail(), locataire.getDateNaissance(), locataire.getSexe(), 
						locataire.getNumCIN(), locataire.getTypeLocation(), locataire.getIdBI()});
	}
	
	//Methode qui affiche les donnees d'un Bien Immobilier sur la tableBien de la fenetre
	public void showInTableBienDispo(BienImmobilier bien) {
		((DefaultTableModel) tableBien.getModel()).addRow(new Object[] 
				{bien.getId(),	bien.getAdresse(),  bien.getNbrePiece(), bien.getLoyer(),
						bien.getDetails(), bien.getMeuble(), bien.getTypeBI(), bien.getStatus()});
	}
	
	/*
	 * Recupere les donnees d'une ligne dans la tablePayement
	 * pour remplir les champs TextField concernent
	 */
	public void selectLineInTablePayement() {
		
		DefaultTableModel model = (DefaultTableModel) tablePayement.getModel();
		int ligne = tablePayement.getSelectedRow();
		
		int id= (int) model.getValueAt(ligne, 0);
		String dtPayement= (String) model.getValueAt(ligne, 1);
		double montant= (double) model.getValueAt(ligne, 2);
		String nomLocataire= (String) model.getValueAt(ligne, 3);
		String prenomLocataire= (String) model.getValueAt(ligne, 4);
		int idBI= (int) model.getValueAt(ligne, 5);
		
		idPayement.setText(String.valueOf(id));
		datePayement.setText(dtPayement);
		montantPayement.setText(String.valueOf(montant));
		nomLocPayement.setText(nomLocataire);
		prenomLocPayement.setText(prenomLocataire);
		idBienPayement.setText(String.valueOf(idBI));
	}
	
	/*
	 * Recupere les donnees d'une ligne dans la tableLocataire 
	 * pour remplir les champs TextField concernent
	 */
	public void selectLineInTableLocataire() {
		DefaultTableModel model = (DefaultTableModel) tableLocataire.getModel();
		int ligne = tableLocataire.getSelectedRow();
		
		int id = (int) model.getValueAt(ligne, 0);
		String nom = (String) model.getValueAt(ligne, 1);
		String prenom = (String) model.getValueAt(ligne, 2);
		String contact= (String) model.getValueAt(ligne, 3);
		String email = (String) model.getValueAt(ligne, 4);
		String dateNaissance = (String) model.getValueAt(ligne, 5);
		String numCNI = (String) model.getValueAt(ligne, 7);
		int idBI = (int) model.getValueAt(ligne, 9);
		
		idLoc.setText(String.valueOf(id));
		nomLoc.setText(nom);
		prenomLoc.setText(prenom);
		contactLoc.setText(contact);
		emailLoc.setText(email);
		dateNaissanceLoc.setText(dateNaissance);
		numCINLoc.setText(numCNI);
		idBienLoc.setText(String.valueOf(idBI));	
		
		
	}
	
	/*
	 * Ajout des ecouteurs sur les boutons de la fenetre
	 */
	public void addSauvegarderLocListener(ActionListener actionListener) {
		btnSauvegarderLoc.addActionListener(actionListener);
		
	}

	public void addLibererBienListerner(ActionListener actionListener) {
		btnLibererBien.addActionListener(actionListener);
	}

	public void addActualiserLocListener(ActionListener actionListener) {
		btnActualiserLoc.addActionListener(actionListener);
		
	}
	
	public void addDeconnexionLocListener(ActionListener actionListener) {
		btnDeconnexionLoc.addActionListener(actionListener);
		
	}

	public void addActualiserBienDispoListener(ActionListener actionListener) {
		btnActualiserBI.addActionListener(actionListener);
		
	}

	public void addDeconnexionBIDispoListener(ActionListener actionListener) {
		btnDeconnexionBI.addActionListener(actionListener);
		
	}

	public void addSauvegarderPayementListener(ActionListener actionListener) {
		btnSauvegarderPayement.addActionListener(actionListener);
		
	}

	public void addSupprimerPayementListerner(ActionListener actionListener) {
		btnSupprimerPayement.addActionListener(actionListener);
		
	}

	public void addActualiserPayementListener(ActionListener actionListener) {
		btnActualiserPayement.addActionListener(actionListener);
		
	}

	public void addRechercherPayementListener(ActionListener actionListener) {
		btnRechercherPayement.addActionListener(actionListener);
		
	}

	public void addDeconnexionPayementListener(ActionListener actionListener) {
		btnDeconnexionPayement.addActionListener(actionListener);		
	}
	
	/*
	 * Ajout des ecouteurs sur le clic d'une ligne des tables Payement et Locataire
	 */
	public void addSelectLineTablePayementListener(MouseAdapter mouseAdapter) {
		tablePayement.addMouseListener(mouseAdapter);
		
	}
	
	public void addSelectLineTableLocataireListener(MouseAdapter adapter) {
		tableLocataire.addMouseListener(adapter);
		
	}

	
}