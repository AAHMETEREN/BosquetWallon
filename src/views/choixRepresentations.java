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
import pojo.Categorie.TypesCategorie;
import pojo.Commande;
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
import com.toedter.components.JSpinField;

public class choixRepresentations extends JFrame {

	private JPanel contentPane;
	private Personne personne;
	private List<Representation> allRepresentation = new ArrayList<Representation>();
	private Representation currentRepresentation;
	private Reservation currentSpectacle;
	private JButton btnRetour;
	private choixRepresentations me;
	private JComboBox<Representation> representationCombobox;
	private JButton btnSelectSpectacle;
	private JPanel panel;
	private JSpinner spinnerBronze, spinnerArgent, spinnerOr, spinnerDiamant;
	private JLabel lblDiamant, lblBronze, lblArgent, lblOr;
	private JLabel lblBase;
	private JSpinField spinnerBase;
	private JLabel lblNewLabel;

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
		btnSelectSpectacle.setBounds(342, 198, 79, 27);
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
		lblBase = new JLabel("Normale");
		lblBase.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBase.setBounds(39, 198, 103, 27);
		panel.add(lblBase);

		spinnerBase = new JSpinField();
		spinnerBase.setBounds(151, 200, 80, 25);
		panel.add(spinnerBase);
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
		lblBronze.setBounds(39, 52, 87, 27);
		lblArgent.setBounds(39, 89, 87, 27);
		spinnerArgent.setBounds(151, 89, 80, 27);
		spinnerOr.setBounds(151, 126, 80, 27);
		spinnerBronze.setBounds(151, 52, 80, 27);
		lblDiamant.setBounds(39, 163, 87, 27);
		spinnerDiamant.setBounds(151, 163, 80, 27);
		lblOr.setBounds(39, 126, 87, 27);
		panel.add(lblBronze);
		panel.add(spinnerBronze);
		panel.add(lblArgent);
		panel.add(spinnerArgent);
		panel.add(spinnerOr);
		panel.add(lblDiamant);
		panel.add(lblOr);
		panel.add(spinnerDiamant);
		
		lblNewLabel = new JLabel("Types de places ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblNewLabel.setBounds(39, 10, 259, 33);
		panel.add(lblNewLabel);

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
		int nbrOfBasePlaces = (int) spinnerBase.getValue();
		int sommePlaces = nbrOfBronzePlaces + nbrOfArgentPlaces + nbrOfOrPlaces + nbrOfDiamantPlaces + nbrOfBasePlaces;

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
		int nbrOfBronzePlaces = (int) spinnerBronze.getValue();
		int nbrOfArgentPlaces = (int) spinnerArgent.getValue();
		int nbrOfOrPlaces = (int) spinnerOr.getValue();
		int nbrOfDiamantPlaces = (int) spinnerDiamant.getValue();
		int nbrOfBasePlaces = (int) spinnerBase.getValue();

		List<Categorie> categories = currentRepresentation.getSpectacle().getConfiguration().getCategories();

		boolean isEnoughtPlaces = true;
		for (Categorie categorie : categories) {
			TypesCategorie type = TypesCategorie.valueOf(categorie.getType());
			switch (type) {
			case DIAMANT:
				if (nbrOfDiamantPlaces > categorie.getNbrPlaceDispo()) {
					isEnoughtPlaces = false;
					JOptionPane.showMessageDialog(null, "Il ne reste plus que " + categorie.getNbrPlaceDispo()
							+ " places pour la catégorie diamant");
				}
				break;
			case OR:
				if (nbrOfOrPlaces > categorie.getNbrPlaceDispo()) {
					isEnoughtPlaces = false;
					JOptionPane.showMessageDialog(null,
							"Il ne reste plus que " + categorie.getNbrPlaceDispo() + " places pour la catégorie or");
				}
				break;
			case ARGENT:
				if (nbrOfArgentPlaces > categorie.getNbrPlaceDispo()) {
					isEnoughtPlaces = false;
					JOptionPane.showMessageDialog(null, "Il ne reste plus que " + categorie.getNbrPlaceDispo()
							+ " places pour la catégorie argent");
				}
				break;
			case BRONZE:
				if (nbrOfBronzePlaces > categorie.getNbrPlaceDispo()) {
					isEnoughtPlaces = false;
					JOptionPane.showMessageDialog(null, "Il ne reste plus que " + categorie.getNbrPlaceDispo()
							+ " places pour la catégorie bronze");
				}
				break;
			case BASE:
				if (nbrOfBasePlaces > categorie.getNbrPlaceDispo()) {
					isEnoughtPlaces = false;
					JOptionPane.showMessageDialog(null,
							"Il ne reste plus que " + categorie.getNbrPlaceDispo() + " places");
				}
				break;
			}

		}
		return isEnoughtPlaces;
	}

	public float getCout() {

		int nbrOfBronzePlaces = (int) spinnerBronze.getValue();
		int nbrOfArgentPlaces = (int) spinnerArgent.getValue();
		int nbrOfOrPlaces = (int) spinnerOr.getValue();
		int nbrOfDiamantPlaces = (int) spinnerDiamant.getValue();
		int nbrOfBasePlaces = (int) spinnerBase.getValue();
		float cout = 0;
		List<Categorie> categories = currentRepresentation.getSpectacle().getConfiguration().getCategories();

		for (Categorie categorie : categories) {
			TypesCategorie type = TypesCategorie.valueOf(categorie.getType());
			switch (type) {
			case DIAMANT:
				cout += nbrOfDiamantPlaces * categorie.getPrix();
				break;
			case OR:
				cout += nbrOfOrPlaces * categorie.getPrix();

				break;
			case ARGENT:
				cout += nbrOfArgentPlaces * categorie.getPrix();

				break;
			case BRONZE:

				cout += nbrOfBronzePlaces * categorie.getPrix();

				break;
			case BASE:
				cout += nbrOfBasePlaces * categorie.getPrix();

				break;
			}

		}
		return cout;
	}

	public void confirmer() {
		if (isPlaceNbrLowerThanMax() && isEnoughtPlaces()) {
			Commande commande = new Commande();
			commande.setCout(getCout());
			 Payement page = new Payement(currentSpectacle,personne,commande);
			 page.setVisible(true);
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
		spinnerBase.setVisible(false);
		lblBase.setVisible(false);
	}

	public void createCategoriesDebout() {
		spinnerBase.setVisible(true);
		lblBase.setVisible(true);
	}

	public void createCategoriesAssisConcert() {
		lblBronze.setVisible(true);
		spinnerBronze.setVisible(true);
		lblArgent.setVisible(true);
		spinnerArgent.setVisible(true);
		spinnerOr.setVisible(true);
		lblOr.setVisible(true);
	}

	public void createCategoriesAssisCirque() {
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
	}
}
