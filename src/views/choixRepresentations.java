package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import pojo.Categorie;
import pojo.Personne;
import pojo.Representation;
import pojo.Reservation;
import pojo.Spectacle;
import pojo.Configuration.TypePlaces;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JSpinner;

public class choixRepresentations extends JFrame {

	private JPanel contentPane;
	private Personne personne;
	private List<Representation> allRepresentation = new ArrayList<Representation>();
	private Representation currentRepresentation;
	private Reservation currentSpectacle;
	private Spectacle spectacle = new Spectacle();
	private JButton btnRetour;
	private choixRepresentations me;
	private JComboBox<Representation> representationCombobox;
	private JButton btnSelectSpectacle;
	private JPanel panel;
	private JSpinner spinnerBronze, spinnerArgent, spinnerOr, spinnerDiamant;
	private JLabel lblDiamant, lblBronze, lblArgent, lblOr;

	public choixRepresentations(Reservation reservation, Personne personne) {
		this.currentSpectacle = reservation;
		this.personne = personne;
		init();
		me = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 460, 383);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(10, 99, 431, 235);
		contentPane.add(panel);
		panel.setLayout(null);

		btnSelectSpectacle = new JButton("Confirmer");
		btnSelectSpectacle.setBackground(Color.DARK_GRAY);
		btnSelectSpectacle.setForeground(Color.WHITE);
		btnSelectSpectacle.setBounds(154, 204, 119, 21);
		btnSelectSpectacle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				confirmer();
			}
		});
		panel.add(btnSelectSpectacle);

		lblBronze = new JLabel("Bronze");
		lblBronze.setFont(new Font("Tahoma", Font.PLAIN, 16));

		lblArgent = new JLabel("Argent");
		lblArgent.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblOr = new JLabel("Or");
		lblOr.setFont(new Font("Tahoma", Font.PLAIN, 16));

		lblDiamant = new JLabel("Diamant");
		lblDiamant.setFont(new Font("Tahoma", Font.PLAIN, 16));

		spinnerBronze = new JSpinner();

		spinnerArgent = new JSpinner();
		spinnerOr = new JSpinner();
		spinnerDiamant = new JSpinner();

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(UIManager.getColor("ToolBar.dockingForeground"));
		panel_1.setBounds(0, 0, 451, 43);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel labelTitre = new JLabel("Choix de la repr\u00E9sentation");
		labelTitre.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitre.setBounds(10, 0, 429, 39);
		labelTitre.setFont(new Font("Tahoma", Font.PLAIN, 32));
		labelTitre.setForeground(UIManager.getColor("ToggleButton.highlight"));
		panel_1.add(labelTitre);
		lblBronze.setBounds(42, 27, 87, 27);
		lblArgent.setBounds(42, 64, 87, 27);
		spinnerArgent.setBounds(154, 64, 80, 27);
		spinnerOr.setBounds(154, 101, 80, 27);
		spinnerBronze.setBounds(154, 27, 80, 27);
		lblDiamant.setBounds(42, 138, 87, 27);
		spinnerDiamant.setBounds(154, 138, 80, 27);
		lblOr.setBounds(42, 101, 87, 27);
		panel.add(lblBronze);
		panel.add(spinnerBronze);
		panel.add(lblArgent);
		panel.add(spinnerArgent);
		panel.add(spinnerOr);
		panel.add(lblDiamant);
		panel.add(lblOr);
		panel.add(spinnerDiamant);
		createBtnRetour();
		createReservationCombobox();
		createCategories();

	}

	public boolean isPlaceNbrLowerThanMax() {
		int maxPlace = currentRepresentation.getSpectacle().getNombrePlaceParClient();
		int nbrOfBronzePlaces = (int) spinnerBronze.getValue();
		int nbrOfArgentPlaces = (int) spinnerArgent.getValue();
		int nbrOfOrPlaces = (int) spinnerOr.getValue();
		int nbrOfDiamantPlaces = (int) spinnerDiamant.getValue();
		int sommePlaces = nbrOfBronzePlaces + nbrOfArgentPlaces + nbrOfOrPlaces + nbrOfDiamantPlaces;

		if (sommePlaces == 0) {
			JOptionPane.showMessageDialog(null, "Veuillez choisir au moin 1 place !");
			return false;
		} else if (sommePlaces <= maxPlace) {
			return true;
		} else {
			JOptionPane.showMessageDialog(null, "Nombre de places maximum autorisé : " + maxPlace + " places"
					+ " | Vous avez choisi : " + sommePlaces + " places");
			return false;

		}

	}
	public boolean isEnoughtPlaces() {
		int maxPlace = currentRepresentation.getSpectacle().getNombrePlaceParClient();

		
		return false;
	}
	public void confirmer() {
		if (isPlaceNbrLowerThanMax() && isEnoughtPlaces()) {
			
		}
	}

	public void createCategories() {
		resetCategories();
		List<Categorie> categories = new ArrayList<Categorie>();
		categories = currentRepresentation.getSpectacle().getConfiguration().getCategories();
		TypePlaces typeConguration = TypePlaces
				.valueOf(currentRepresentation.getSpectacle().getConfiguration().getType());

		resetCategories();
		switch (typeConguration) {
		case DEBOUT:
			createCategoriesDebout();
			break;
		case ASSIS_CONCERT:
			createCategoriesAssisConcert();
			break;
		case ASSIS_CIRQUE:
			createCategoriesAssisCirque();
			break;
		}
	}

	public void resetCategories() {
		lblOr.setVisible(false);
		lblBronze.setVisible(false);
		lblArgent.setVisible(false);
		spinnerArgent.setVisible(false);
		spinnerOr.setVisible(false);
		spinnerBronze.setVisible(false);
		lblDiamant.setVisible(false);
		spinnerDiamant.setVisible(false);
	}

	public void createCategoriesDebout() {
		lblBronze.setVisible(true);
		spinnerBronze.setVisible(true);
	}

	public void createCategoriesAssisConcert() {
		createCategoriesDebout();
		lblArgent.setVisible(true);
		spinnerArgent.setVisible(true);
		spinnerOr.setVisible(true);
		lblOr.setVisible(true);
	}

	public void createCategoriesAssisCirque() {
		createCategoriesDebout();
		createCategoriesAssisConcert();
		lblDiamant.setVisible(true);
		spinnerDiamant.setVisible(true);
	}

	public void createReservationCombobox() {
		representationCombobox = new JComboBox<Representation>();
		representationCombobox.setBounds(10, 63, 321, 21);
		representationCombobox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				me.setCurrentRepresentation();
			}
		});
		contentPane.add(representationCombobox);
		for (Representation representation : allRepresentation) {
			representationCombobox.addItem(representation);
		}
		currentRepresentation = (Representation) representationCombobox.getSelectedItem();
	}

	public void setCurrentRepresentation() {
		currentRepresentation = (Representation) representationCombobox.getSelectedItem();

	}

	public void createBtnRetour() {
		btnRetour = new JButton("Quitter");
		btnRetour.setForeground(Color.WHITE);
		btnRetour.setBackground(Color.DARK_GRAY);
		btnRetour.setBounds(353, 60, 88, 26);
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				me.dispose();
			}
		});
		contentPane.add(btnRetour);
	}

	public void init() {
		Representation representation = new Representation();
		representation.setSpectacle(this.currentSpectacle.getPlanning().getSpectacle());
		allRepresentation = representation.findAll();
		System.out.println("GETTING ID OF RESERVATION");

		for (Representation res : allRepresentation) {
			System.out.println("GETTING ID OF REPRESENTATION" + res.getId());
		}
	}
}
