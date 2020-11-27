package views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
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
	Spectacle spectacle = new Spectacle();
	List<Artiste> allArtistes;
	private JPanel contentPane;
	private Personne personne;
	private JTextField maxParPersonneField, titreField, fieldBronze, fieldBase, fieldArgent, fieldOr, fieldDiamant;
	private JPanel panel;
	private JLabel labelBronze, labelOr, labelArgent, labelDiamant;
	private JLabel labelArtiste;
	private JTextPane descriptionField;
	private TypePlaces place = TypePlaces.DEBOUT;
	private int maxParPersonne;
	private JSpinField representationHeureMax, representationHeureMin;
	private JCalendar calendar;
	private JLabel labelHeureMin;
	private JLabel labelArtiste_2;
	private JButton addRepresentationBtn;
	private JLabel lblNewLabel;
	private JComboBox<Artiste> comboBoxArtiste ;
	private JButton addArtisteBtn;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Personne personne = new Organisateur(0, "test", "test", "test", "test", "test", "tt3es");
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

		this.personne = personne;
		Location me = this;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 562, 698);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel = new JPanel();
		panel.setBackground(Color.RED);
		panel.setForeground(Color.WHITE);
		panel.setBounds(0, 0, 548, 661);
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
		btnRetour.setBounds(450, 10, 88, 26);
		panel.add(btnRetour);

		JLabel title = new JLabel("Choix de la date :");
		title.setForeground(Color.WHITE);
		title.setFont(new Font("Tahoma", Font.PLAIN, 14));
		title.setBounds(60, 50, 273, 27);
		panel.add(title);

		titreField = new JTextField();
		titreField.setBounds(113, 8, 327, 32);
		panel.add(titreField);
		titreField.setColumns(10);

		JLabel labelTitre = new JLabel("Titre");
		labelTitre.setForeground(Color.WHITE);
		labelTitre.setBounds(42, 17, 45, 13);
		panel.add(labelTitre);

		maxParPersonneField = new JTextField();
		maxParPersonneField.setColumns(10);
		maxParPersonneField.setBounds(31, 270, 224, 32);
		panel.add(maxParPersonneField);

		JLabel labelLimite = new JLabel("Limite de place");
		labelLimite.setForeground(Color.WHITE);
		labelLimite.setBounds(31, 254, 160, 13);
		panel.add(labelLimite);

		JComboBox comboBox = new JComboBox();

		comboBox.setModel(new DefaultComboBoxModel(TypePlaces.values()));

		comboBox.setBounds(308, 272, 224, 26);
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
		labelConfiguration.setBounds(318, 254, 160, 13);
		panel.add(labelConfiguration);

		JLabel labelPrix = new JLabel("Prix");
		labelPrix.setForeground(Color.WHITE);
		labelPrix.setBounds(345, 312, 160, 13);
		panel.add(labelPrix);

		fieldBronze = new JTextField();
		fieldBronze.setBounds(397, 339, 96, 19);
		panel.add(fieldBronze);
		fieldBronze.setColumns(10);

		labelBronze = new JLabel("Bronze");
		labelBronze.setBounds(338, 338, 160, 13);
		labelBronze.setForeground(Color.WHITE);

		panel.add(labelBronze);

		labelArgent = new JLabel("Argent");
		labelArgent.setBounds(338, 361, 160, 13);
		labelArgent.setForeground(Color.WHITE);

		panel.add(labelArgent);

		labelOr = new JLabel("Or");
		labelOr.setBounds(338, 381, 160, 13);
		labelOr.setForeground(Color.WHITE);

		panel.add(labelOr);

		fieldArgent = new JTextField();
		fieldArgent.setColumns(10);
		fieldArgent.setBounds(397, 361, 96, 19);
		panel.add(fieldArgent);

		fieldOr = new JTextField();
		fieldOr.setColumns(10);
		fieldOr.setBounds(397, 385, 96, 19);
		panel.add(fieldOr);

		labelDiamant = new JLabel("Diamant");
		labelDiamant.setBounds(338, 404, 160, 13);
		labelDiamant.setForeground(Color.WHITE);

		panel.add(labelDiamant);

		fieldDiamant = new JTextField();
		fieldDiamant.setColumns(10);

		fieldDiamant.setBounds(397, 410, 96, 19);
		panel.add(fieldDiamant);
		fieldBase = new JTextField();
		fieldBase.setColumns(10);
		fieldBase.setBounds(397, 313, 96, 19);
		panel.add(fieldBase);
		createCalendar();
		resetChampPrix();
		creerChampPrixDebout();
		getAllArtistes();
	}

	private void getAllArtistes() {
		allArtistes = personne.findAllArtiste();
		addArtisteBtn = new JButton("Ajouter ");
		addArtisteBtn.setForeground(Color.WHITE);
		addArtisteBtn.setBackground(Color.DARK_GRAY);
		addArtisteBtn.setBounds(266, 335, 82, 26);
		addArtisteBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("454541");
				Artiste test = (Artiste) comboBoxArtiste.getSelectedItem();
				System.out.println(test);
				
				spectacle.addArtiste(test);
				comboBoxArtiste.removeItem(comboBoxArtiste.getSelectedItem());
			}
		});
		panel.add(addArtisteBtn);
		setListeArtiste(allArtistes);
	}

	private void setListeArtiste(List<Artiste> artistes) {
		comboBoxArtiste = null;
		comboBoxArtiste = new JComboBox<Artiste>();
		for (Artiste artiste : artistes) {
			comboBoxArtiste.addItem(artiste);
		}
		comboBoxArtiste.setBounds(31, 329, 224, 27);
		panel.add(comboBoxArtiste);
		
	}

	private void createCalendar() {
		calendar = new JCalendar();
		calendar.setLocale(Locale.FRENCH);
		calendar.setBounds(50, 73, 390, 159);
		panel.add(calendar);

		JLabel calendarValue = new JLabel("New label");
		calendarValue.setFont(new Font("Tahoma", Font.PLAIN, 10));
		calendarValue.setForeground(Color.WHITE);
		calendarValue.setBounds(247, 42, 160, 46);
		panel.add(calendarValue);
		calendarValue.setText(calendar.getDate().toString());

		labelArtiste = new JLabel("Choix d'artiste");
		labelArtiste.setForeground(Color.WHITE);
		labelArtiste.setBounds(31, 312, 160, 13);
		panel.add(labelArtiste);

		JButton confirmButton = new JButton("Creer");
		confirmButton.setForeground(Color.WHITE);
		confirmButton.setBackground(Color.DARK_GRAY);
		confirmButton.setBounds(373, 439, 122, 34);
		confirmButton.addActionListener(e -> {
			creerSpectacle();
		});
		panel.add(confirmButton);

		descriptionField = new JTextPane();
		descriptionField.setBounds(30, 390, 197, 56);
		panel.add(descriptionField);

		JLabel labelDescription = new JLabel("Description");
		labelDescription.setForeground(Color.WHITE);
		labelDescription.setBounds(31, 376, 152, 13);
		panel.add(labelDescription);

		representationHeureMin = new JSpinField();
		representationHeureMin.setBounds(35, 576, 64, 19);
		representationHeureMin.setMaximum(24);
		representationHeureMin.setMinimum(1);
		panel.add(representationHeureMin);

		representationHeureMax = new JSpinField();
		representationHeureMax.setBounds(123, 576, 64, 19);
		panel.add(representationHeureMax);
		representationHeureMax.setValue(13);
		representationHeureMin.setValue(12);

		labelHeureMin = new JLabel("D\u00E9but ");
		labelHeureMin.setForeground(Color.WHITE);
		labelHeureMin.setBounds(31, 561, 160, 13);
		panel.add(labelHeureMin);

		labelArtiste_2 = new JLabel("Fin");
		labelArtiste_2.setForeground(Color.WHITE);
		labelArtiste_2.setBounds(123, 561, 160, 13);
		panel.add(labelArtiste_2);

		lblNewLabel = new JLabel("Representations");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(31, 534, 152, 13);
		panel.add(lblNewLabel);

		// TODO : add id to models
		calendar.addPropertyChangeListener(new PropertyChangeListener() {
			@SuppressWarnings("deprecation")
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				calendarValue.setText(calendar.getDate().toLocaleString());
			}
		});
		
		setRepresentationButton();
	}

	private void setRepresentationButton() {
		addRepresentationBtn = new JButton("Ajouter ");
		addRepresentationBtn.setForeground(Color.WHITE);
		addRepresentationBtn.setBackground(Color.DARK_GRAY);
		addRepresentationBtn.setBounds(201, 575, 82, 26);
		addRepresentationBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int heureDebut = (Integer) representationHeureMin.getValue();
				int heureFin = (Integer) representationHeureMax.getValue();
				java.util.Date utilStartDate = calendar.getDate();
				java.sql.Date date = new java.sql.Date(utilStartDate.getTime());
				Representation representation = new Representation(0, date, heureDebut, heureFin);

				spectacle.addRepresentation(representation);
			}
		});
		panel.add(addRepresentationBtn);
	}
	private void creerSpectacle() {
		String titre = titreField.getText();
		String description = descriptionField.getText();

		java.util.Date utilStartDate = calendar.getDate();
		java.sql.Date date = new java.sql.Date(utilStartDate.getTime());
		List<Categorie> categories = createCategories();
		PlanningSalle planning = new PlanningSalle(0, date);
		pojo.Configuration configuration = new pojo.Configuration(0, categories, description, titre);
		spectacle.setTitre(titre);
		spectacle.setConfiguration(configuration);
		spectacle.setPlanningSalle(planning);
		spectacle.setNombrePlaceParClient(maxParPersonne);
		spectacle.setOrganisateur( personne);
		spectacle.createSpectacle();

	}

	private List<Categorie> createCategories() {
		maxParPersonne = Integer.parseInt(maxParPersonneField.getText());
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
		fieldBase.setVisible(true);
	}

	private void creerChampPrixConcert() {
		fieldBronze.setVisible(true);
		fieldArgent.setVisible(true);
		fieldOr.setVisible(true);
		labelBronze.setVisible(true);
		labelOr.setVisible(true);
		labelArgent.setVisible(true);
	}

	private void creerChampPrixCirque() {
		fieldDiamant.setVisible(true);
		labelDiamant.setVisible(true);
	}
}
