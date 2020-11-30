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

import pojo.Artiste;
import pojo.Organisateur;
import pojo.Personne;
import pojo.Place;
import pojo.Reservation;
import pojo.Commande;
import pojo.Spectacle;
import pojo.Configuration.TypePlaces;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.JList;

public class ListeCommandes extends JFrame {

	private JPanel contentPane;
	private Personne personne;
	private List<Commande> allCommandes = new ArrayList<Commande>();
	private Commande currentCommande;
	private JButton btnRetour;
	private ListeCommandes me;
	private JComboBox<Commande> CommandesCombobox;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblPlaceOr;
	private JLabel lblPlaceDiamant;
	private JButton btnNewButton;
	private JLabel lblNewLabel_2;

	public ListeCommandes(Personne personne) {
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
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(10, 99, 431, 235);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblNewLabel = new JLabel("3 Places Bronze ");
		lblNewLabel.setBounds(32, 58, 298, 27);
		panel.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Bienvenue chez dylan !");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_1.setBounds(81, 10, 350, 37);
		panel.add(lblNewLabel_1);
		
		lblPlaceOr = new JLabel("1 Place Or");
		lblPlaceOr.setBounds(32, 95, 298, 27);
		panel.add(lblPlaceOr);
		
		lblPlaceDiamant = new JLabel("10 Place Diamant");
		lblPlaceDiamant.setBounds(32, 132, 298, 27);
		panel.add(lblPlaceDiamant);
		
		btnNewButton = new JButton("Imprimer");
		btnNewButton.setBounds(294, 183, 99, 27);
		panel.add(btnNewButton);
		
		lblNewLabel_2 = new JLabel("Total 184.25 \u20AC");
		lblNewLabel_2.setBounds(32, 183, 99, 27);
		panel.add(lblNewLabel_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.DARK_GRAY);
		panel_2.setBounds(32, 176, 106, 3);
		panel.add(panel_2);
		
		JLabel lblNewLabel_3 = new JLabel("(pay\u00E9)");
		lblNewLabel_3.setBounds(102, 190, 45, 13);
		panel.add(lblNewLabel_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(UIManager.getColor("ToolBar.dockingForeground"));
		panel_1.setBounds(0, 0, 451, 43);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel labelTitre = new JLabel("Toutes les commandes");
		labelTitre.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitre.setBounds(10, 0, 429, 39);
		labelTitre.setFont(new Font("Tahoma", Font.PLAIN, 32));
		labelTitre.setForeground(UIManager.getColor("ToggleButton.highlight"));
		panel_1.add(labelTitre);
		createBtnRetour();
		createCommandeCombobox();
	}
	public void createCommandeCombobox() {
		CommandesCombobox = new JComboBox<Commande>();
		CommandesCombobox.setBounds(10, 63, 321, 21);
		CommandesCombobox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				me.setCurrentCommande();
			}
		});
		contentPane.add(CommandesCombobox);
		for (Commande Commande : allCommandes) {
			CommandesCombobox.addItem(Commande);
		}		
		currentCommande = (Commande) CommandesCombobox.getSelectedItem();
	}
	
	public void setCurrentCommande() {
		currentCommande = (Commande) CommandesCombobox.getSelectedItem();

	}
	public void createBtnRetour() {
		btnRetour = new JButton("Retour");
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

		Commande commande = new Commande();
		commande.setPersonne(personne);
		allCommandes = commande.findAll();

	}
}
