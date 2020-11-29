package views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
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
import pojo.Configuration;
import pojo.Configuration.TypePlaces;
import pojo.Organisateur;
import pojo.Personne;
import pojo.PlanningSalle;
import pojo.Representation;
import pojo.Reservation;
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

	Spectacle spectacle = new Spectacle();
	List<Artiste> allArtistes = new ArrayList<Artiste>();
	List<Artiste> selectedArtistes = new ArrayList<Artiste>();
	List<Representation> allRepresentation = new ArrayList<Representation>();
	private JPanel contentPane;
	private Personne personne;
	private JTextField titreField;
	private JPanel panel;
	private JLabel labelBronze, labelOr, labelArgent, labelDiamant;
	private JLabel labelArtiste;
	private JTextPane descriptionField;
	private TypePlaces place = TypePlaces.DEBOUT;
	private int maxParPersonne;
	private JSpinField representationHeureMax, representationHeureMin, fieldBronze, fieldBase, fieldArgent, fieldOr,
			fieldDiamant, maxParPersonneField;
	private JCalendar calendar;
	private JLabel labelHeureMin;
	private JLabel labelArtiste_2;
	private JButton addRepresentationBtn;
	private JLabel lblNewLabel;
	private JComboBox<Artiste> comboBoxArtiste;
	private JButton addArtisteBtn;

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

		maxParPersonneField = new JSpinField();
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

		fieldBronze = new JSpinField();
		fieldBronze.setBounds(397, 339, 96, 19);
		panel.add(fieldBronze);

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

		fieldArgent = new JSpinField();
		fieldArgent.setBounds(397, 361, 96, 19);
		panel.add(fieldArgent);

		fieldOr = new JSpinField();
		fieldOr.setBounds(397, 385, 96, 19);
		panel.add(fieldOr);

		labelDiamant = new JLabel("Diamant");
		labelDiamant.setBounds(338, 404, 160, 13);
		labelDiamant.setForeground(Color.WHITE);

		panel.add(labelDiamant);

		fieldDiamant = new JSpinField();

		fieldDiamant.setBounds(397, 410, 96, 19);
		panel.add(fieldDiamant);
		fieldBase = new JSpinField();
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
				Artiste artiste = (Artiste) comboBoxArtiste.getSelectedItem();
				selectedArtistes.add(artiste);
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
			create();
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

		calendar.addPropertyChangeListener(new PropertyChangeListener() {
			@SuppressWarnings("deprecation")
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				calendarValue.setText(calendar.getDate().toLocaleString());
			}
		});

		setRepresentationButton();
	}

	public void create() {
		boolean isSpectacleCreated = creerSpectacle();
		if (isSpectacleCreated) {
			PlanningSalle planningSalle = creerPlanningSalle();
			creerReservation(planningSalle);
			createRepresentation();
			createConfiguration();
			createArtistes();
		}

	}

	private void createArtistes() {
		for (Artiste artiste : selectedArtistes) {
			artiste.setOrganisateur(personne);
			artiste.setSpectacle(spectacle);

			artiste.create();
		}
	}

	private void createConfiguration() {
		String description = descriptionField.getText();
		pojo.Configuration configuration = new pojo.Configuration(0, description, place, spectacle);
		boolean isConfigurationCreated = configuration.create();
		if (isConfigurationCreated) {
			createCategories(configuration);
		}
	}

	private void createCategories(Configuration configuration) {
		List<Categorie> categories = setCategoriesList(configuration);
		for (Categorie categorie : categories) {
			categorie.create();
		}
	}

	private void createRepresentation() {
		for (Representation representation : allRepresentation) {
			representation.create();
		}
	}

	private PlanningSalle creerPlanningSalle() {
		Date date = getDate();
		PlanningSalle planningSalle = new PlanningSalle(date, spectacle);
		planningSalle.create();
		return planningSalle;
	}

	private void creerReservation(PlanningSalle planningSalle) {
		Reservation reservation = new Reservation(0, 0, 0, planningSalle, this.personne);
		reservation.setPrix(getDate());
		reservation.create();
	}

	private boolean creerSpectacle() {
		String titre = titreField.getText();

		spectacle.setTitre(titre);
		spectacle.setNombrePlaceParClient(maxParPersonne);
		spectacle.create();
		return true;
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
				allRepresentation.add(new Representation(0, date, heureDebut, heureFin, spectacle));
			}
		});
		panel.add(addRepresentationBtn);
	}

	private Date getDate() {
		java.util.Date utilStartDate = calendar.getDate();
		return new java.sql.Date(utilStartDate.getTime());
	}

	private List<Categorie> setCategoriesList(Configuration configuration) {
		maxParPersonne = (Integer) maxParPersonneField.getValue();
		if (place == TypePlaces.DEBOUT) {
			return createCategorieDebout(configuration);
		} else if (place == TypePlaces.ASSIS_CONCERT) {
			return createCategorieConcert(configuration);
		} else {
			return createCategorieCirque(configuration);
		}

	}

	private List<Categorie> createCategorieDebout(Configuration configuration) {
		int nombrePlaceDispo = 8000;
		int prixBase = (Integer) fieldBase.getValue();
		List<Categorie> categories = new ArrayList<Categorie>();
		categories.add(new Categorie(Categorie.TypesCategorie.BASE, prixBase, place, configuration));
		return categories;
	}

	private List<Categorie> createCategorieConcert(Configuration configuration) {
		int nombrePlaceDispo = 5000;
		int prixBronze = (Integer) fieldBronze.getValue();
		int prixArgent = (Integer) fieldArgent.getValue();
		int prixOr = (Integer) fieldOr.getValue();

		List<Categorie> categories = new ArrayList<Categorie>();
		categories.add(new Categorie(Categorie.TypesCategorie.BRONZE, prixBronze, place, configuration));
		categories.add(new Categorie(Categorie.TypesCategorie.ARGENT, prixArgent, place, configuration));
		categories.add(new Categorie(Categorie.TypesCategorie.OR, prixOr, place, configuration));

		return categories;
	}

	private List<Categorie> createCategorieCirque(Configuration configuration) {
		int nombrePlaceDispo = 6000;
		int prixBronze = (Integer) fieldBronze.getValue();
		int prixArgent = (Integer) fieldArgent.getValue();
		int prixOr = (Integer) fieldOr.getValue();
		int prixDiamant = (Integer) fieldDiamant.getValue();

		List<Categorie> categories = new ArrayList<Categorie>();
		categories.add(new Categorie(Categorie.TypesCategorie.BRONZE, prixBronze, place, configuration));
		categories.add(new Categorie(Categorie.TypesCategorie.ARGENT, prixArgent, place, configuration));
		categories.add(new Categorie(Categorie.TypesCategorie.OR, prixOr, place, configuration));
		categories.add(new Categorie(Categorie.TypesCategorie.DIAMANT, prixDiamant, place, configuration));
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
