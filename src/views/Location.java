package views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.lang.module.Configuration;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import pojo.Artiste;
import pojo.Categorie;
import pojo.Organisateur;
import pojo.Personne;
import pojo.PlanningSalle;
import pojo.Representation;
import pojo.Spectacle;

import com.toedter.calendar.JCalendar;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextPane;
import com.toedter.components.JSpinField;

public class Location extends JFrame {
	public enum TypePlaces {
		DEBOUT("Debout (8000 places)"), ASSIS_CONCERT("Assis version concert (5000 places)"),
		ASSIS_CIRQUE("Assis version cirque (6000 places)");

		private final String display;

		private TypePlaces(String label) {
			this.display = label;
		}

		@Override
		public String toString() {
			return display;
		}
	}

	private List<Artiste> artistes = new ArrayList<Artiste>();
	private JPanel contentPane;
	private Personne personne;
	private JTextField maxParPersonneField, titreField, fieldBronze, fieldBase, fieldArgent, fieldOr, fieldDiamant;
	private JPanel panel;
	private JLabel labelBronze, labelOr, labelArgent, labelDiamant;
	private JLabel labelArtiste;
	JTextPane descriptionField;
	TypePlaces place = TypePlaces.DEBOUT;
	int maxParPersonne;

	JCalendar calendar;
	private JLabel labelHeureMin;
	private JLabel labelArtiste_2;
	private JButton btnNewButton;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Personne personne = new Organisateur(0, "test", "test", "test", "test", "test");

					Location frame = new Location(personne);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Location(Personne personne) {
		artistes.add(new Artiste(0, "test", "test", "test", "test", "test", "test"));
		artistes.add(new Artiste(0, "test2", "test2", "test2", "test2", "test2", "test2"));
		artistes.add(new Artiste(0, "test3", "test3", "test3", "test3", "test3", "test3"));
		artistes.add(new Artiste(0, "test4", "test4", "test4", "test4", "test4", "test4"));

		this.personne = personne;
		Location me = this;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 740, 460);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel = new JPanel() {
			public void paintComponent(Graphics g) {
				Image img = Toolkit.getDefaultToolkit().getImage(Main.class.getResource("/images/main.jpg"));
				g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
			}
		};
		panel.setForeground(Color.WHITE);
		panel.setBounds(0, 0, 726, 423);
		contentPane.add(panel);
		panel.setLayout(null);
		JButton btnRetour = new JButton("Retour");
		btnRetour.setBackground(Color.DARK_GRAY);
		btnRetour.setForeground(Color.WHITE);
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Dashboard page = new Dashboard(personne);
				page.setVisible(true);
				me.dispose();
			}
		});
		btnRetour.setBounds(596, 10, 88, 26);
		panel.add(btnRetour);

		JLabel title = new JLabel("Choix de la date :");
		title.setForeground(Color.WHITE);
		title.setFont(new Font("Tahoma", Font.PLAIN, 14));
		title.setBounds(35, 36, 273, 27);
		panel.add(title);

		titreField = new JTextField();
		titreField.setBounds(384, 59, 284, 32);
		panel.add(titreField);
		titreField.setColumns(10);

		JLabel labelTitre = new JLabel("Titre");
		labelTitre.setForeground(Color.WHITE);
		labelTitre.setBounds(384, 45, 45, 13);
		panel.add(labelTitre);

		maxParPersonneField = new JTextField();
		maxParPersonneField.setColumns(10);
		maxParPersonneField.setBounds(384, 112, 284, 32);
		panel.add(maxParPersonneField);

		JLabel labelLimite = new JLabel("Limite de place");
		labelLimite.setForeground(Color.WHITE);
		labelLimite.setBounds(384, 96, 160, 13);
		panel.add(labelLimite);

		JComboBox comboBox = new JComboBox();

		comboBox.setModel(new DefaultComboBoxModel(TypePlaces.values()));

		comboBox.setBounds(384, 220, 284, 26);
		panel.add(comboBox);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				place = (TypePlaces) comboBox.getSelectedItem();
				resetChampPrix();
				if (place == TypePlaces.DEBOUT) {
					creerChampPrixDebout();
				} else if (place == TypePlaces.ASSIS_CIRQUE) {
					creerChampPrixConcert();
					creerChampPrixCirque();
				} else {
					creerChampPrixConcert();
				}
			}
		});
		JLabel labelConfiguration = new JLabel("Configuration");
		labelConfiguration.setForeground(Color.WHITE);
		labelConfiguration.setBounds(384, 202, 160, 13);
		panel.add(labelConfiguration);

		JLabel labelPrix = new JLabel("Prix");
		labelPrix.setForeground(Color.WHITE);
		labelPrix.setBounds(387, 256, 160, 13);
		panel.add(labelPrix);

		fieldBronze = new JTextField();
		fieldBronze.setBounds(575, 279, 96, 19);
		panel.add(fieldBronze);
		fieldBronze.setColumns(10);

		labelBronze = new JLabel("Bronze");
		labelBronze.setBounds(387, 282, 160, 13);
		labelBronze.setForeground(Color.WHITE);

		panel.add(labelBronze);

		labelArgent = new JLabel("Argent");
		labelArgent.setBounds(387, 305, 160, 13);
		labelArgent.setForeground(Color.WHITE);

		panel.add(labelArgent);

		labelOr = new JLabel("Or");
		labelOr.setBounds(387, 325, 160, 13);
		labelOr.setForeground(Color.WHITE);

		panel.add(labelOr);

		fieldArgent = new JTextField();
		fieldArgent.setColumns(10);
		fieldArgent.setBounds(575, 302, 96, 19);
		panel.add(fieldArgent);

		fieldOr = new JTextField();
		fieldOr.setColumns(10);
		fieldOr.setBounds(575, 325, 96, 19);
		panel.add(fieldOr);

		labelDiamant = new JLabel("Diamant");
		labelDiamant.setBounds(387, 348, 160, 13);
		labelDiamant.setForeground(Color.WHITE);

		panel.add(labelDiamant);

		fieldDiamant = new JTextField();
		fieldDiamant.setColumns(10);

		fieldDiamant.setBounds(575, 350, 96, 19);
		panel.add(fieldDiamant);
		fieldBase = new JTextField();
		fieldBase.setColumns(10);
		fieldBase.setBounds(575, 253, 96, 19);
		panel.add(fieldBase);
		createCalendar();
		resetChampPrix();
		creerChampPrixDebout();
	}

	private void createCalendar() {
		calendar = new JCalendar();
		calendar.setLocale(Locale.FRENCH);
		calendar.setBounds(46, 59, 273, 158);
		panel.add(calendar);

		JLabel calendarValue = new JLabel("New label");
		calendarValue.setFont(new Font("Tahoma", Font.PLAIN, 10));
		calendarValue.setForeground(Color.WHITE);
		calendarValue.setBounds(148, 28, 160, 46);
		panel.add(calendarValue);
		calendarValue.setText(calendar.getDate().toString());

		labelArtiste = new JLabel("Choix d'artiste");
		labelArtiste.setForeground(Color.WHITE);
		labelArtiste.setBounds(384, 154, 160, 13);
		panel.add(labelArtiste);

		JComboBox comboBoxArtiste = new JComboBox<Artiste>();
		comboBoxArtiste.setBounds(384, 171, 284, 27);
		panel.add(comboBoxArtiste);

		JButton confirmButton = new JButton("Creer");
		confirmButton.setForeground(Color.WHITE);
		confirmButton.setBackground(Color.DARK_GRAY);
		confirmButton.setBounds(551, 379, 122, 34);
		confirmButton.addActionListener(e -> {
			creerSpectacle();
		});
		panel.add(confirmButton);

		descriptionField = new JTextPane();
		descriptionField.setBounds(46, 242, 273, 56);
		panel.add(descriptionField);

		JLabel labelDescription = new JLabel("Description");
		labelDescription.setForeground(Color.WHITE);
		labelDescription.setBounds(46, 227, 152, 13);
		panel.add(labelDescription);
		
		JSpinField representationHeureMin = new JSpinField();
		representationHeureMin.setBounds(46, 342, 64, 19);
		representationHeureMin.setMaximum(24);
		representationHeureMin.setMinimum(1);
		representationHeureMin.addPropertyChangeListener(new PropertyChangeListener() {
			@SuppressWarnings("deprecation")
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				System.out.println(representationHeureMin.getValue());
			}
		});
		panel.add(representationHeureMin);
		
		JSpinField representationHeureMax = new JSpinField();
		representationHeureMax.setBounds(134, 342, 64, 19);
		panel.add(representationHeureMax);
		representationHeureMax.setValue(13);
		representationHeureMin.setValue(12);

		
		labelHeureMin = new JLabel("D\u00E9but ");
		labelHeureMin.setForeground(Color.WHITE);
		labelHeureMin.setBounds(46, 325, 160, 13);
		panel.add(labelHeureMin);
		
		labelArtiste_2 = new JLabel("Fin");
		labelArtiste_2.setForeground(Color.WHITE);
		labelArtiste_2.setBounds(134, 325, 160, 13);
		panel.add(labelArtiste_2);
		
		btnNewButton = new JButton("Ajouter ");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.setBounds(220, 339, 96, 26);
		panel.add(btnNewButton);
		
		lblNewLabel = new JLabel("Representations");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(46, 305, 152, 13);
		panel.add(lblNewLabel);
		
		
		
		for (Artiste item : artistes) {
			comboBoxArtiste.addItem(item.getNomUtilisateur());
		}
		// TODO : add id to models
		calendar.addPropertyChangeListener(new PropertyChangeListener() {
			@SuppressWarnings("deprecation")
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				calendarValue.setText(calendar.getDate().toLocaleString());
			}
		});
	}

	private void creerSpectacle() {
		String titre = titreField.getText();
		String description = descriptionField.getText();

		java.util.Date utilStartDate = calendar.getDate();
		java.sql.Date date = new java.sql.Date(utilStartDate.getTime());

		List<Categorie> categories = createCategories();
		PlanningSalle planning = new PlanningSalle(0, date);
		List<Representation> representations = new ArrayList<Representation>();
		representations.add(
				)
		
		pojo.Configuration configuration = new pojo.Configuration(0, categories, description, titre);
		Spectacle spectacle = new Spectacle(0, titre, maxParPersonne, (Organisateur) personne, configuration, planning, artistes,
				representations
		);

	}

	private List<Categorie> createCategories() {
		maxParPersonne = Integer.parseInt(maxParPersonneField.getText());
		System.out.println(place);
		System.out.println(TypePlaces.DEBOUT);

		if (place == TypePlaces.DEBOUT) {
			return createCategorieDebout();
		} else if (place == TypePlaces.ASSIS_CONCERT) {
			return createCategorieConcert();
		} else {
			return createCategorieCirque();
		}
	}

	private List<Categorie> createCategorieDebout() {
		int nombrePlaceDispo = 8000;
		int prixBase = Integer.parseInt(fieldBase.getText());
		List<Categorie> categories = new ArrayList<Categorie>();
		categories.add(new Categorie(0, Categorie.TypesCategorie.BASE, prixBase, nombrePlaceDispo, maxParPersonne));
		return categories;
	}

	private List<Categorie> createCategorieConcert() {
		int nombrePlaceDispo = 5000;
		int prixBronze = Integer.parseInt(fieldBronze.getText());
		int prixArgent = Integer.parseInt(fieldArgent.getText());
		int prixOr = Integer.parseInt(fieldOr.getText());

		List<Categorie> categories = new ArrayList<Categorie>();
		categories.add(new Categorie(0, Categorie.TypesCategorie.BRONZE, prixBronze, nombrePlaceDispo, maxParPersonne));
		categories.add(new Categorie(0, Categorie.TypesCategorie.ARGENT, prixArgent, nombrePlaceDispo, maxParPersonne));
		categories.add(new Categorie(0, Categorie.TypesCategorie.OR, prixOr, nombrePlaceDispo, maxParPersonne));

		return categories;
	}

	private List<Categorie> createCategorieCirque() {
		int nombrePlaceDispo = 6000;
		int prixBronze = Integer.parseInt(fieldBronze.getText());
		int prixArgent = Integer.parseInt(fieldArgent.getText());
		int prixOr = Integer.parseInt(fieldOr.getText());
		int prixDiamant = Integer.parseInt(fieldDiamant.getText());

		List<Categorie> categories = new ArrayList<Categorie>();
		categories.add(new Categorie(0, Categorie.TypesCategorie.BRONZE, prixBronze, nombrePlaceDispo, maxParPersonne));
		categories.add(new Categorie(0, Categorie.TypesCategorie.ARGENT, prixArgent, nombrePlaceDispo, maxParPersonne));
		categories.add(new Categorie(0, Categorie.TypesCategorie.OR, prixOr, nombrePlaceDispo, maxParPersonne));
		categories
				.add(new Categorie(0, Categorie.TypesCategorie.DIAMANT, prixDiamant, nombrePlaceDispo, maxParPersonne));
		return categories;
	}

	private void resetChampPrix() {
		if (fieldBase != null)
			fieldBase.setVisible(false);
		if (fieldBronze != null)
			fieldBronze.setVisible(false);
		if (fieldOr != null)
			fieldOr.setVisible(false);
		if (fieldArgent != null)
			fieldArgent.setVisible(false);
		if (fieldDiamant != null)
			fieldDiamant.setVisible(false);
		if (labelBronze != null)
			labelBronze.setVisible(false);
		if (labelOr != null)
			labelOr.setVisible(false);
		if (labelArgent != null)
			labelArgent.setVisible(false);
		if (labelDiamant != null)
			labelDiamant.setVisible(false);
	}

	private void creerChampPrixDebout() {
		System.out.println("DEBOUT");
		fieldBase.setVisible(true);
	}

	private void creerChampPrixConcert() {
		System.out.println("CIRQUE");
		fieldBronze.setVisible(true);
		fieldArgent.setVisible(true);
		fieldOr.setVisible(true);
		labelBronze.setVisible(true);
		labelOr.setVisible(true);
		labelArgent.setVisible(true);
	}

	private void creerChampPrixCirque() {
		System.out.println("CONCERT");
		fieldDiamant.setVisible(true);
		labelDiamant.setVisible(true);
	}
}
