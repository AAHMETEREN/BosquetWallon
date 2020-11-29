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
import pojo.Representation;
import pojo.Reservation;
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

public class Paiment extends JFrame {

	private JPanel contentPane;
	private Personne personne;
	private List<Representation> allRepresentation = new ArrayList<Representation>();
	private Representation currentRepresentation;
	private Reservation currentSpectacle;
	private Spectacle spectacle = new Spectacle();
	private JButton btnRetour;
	private Paiment me;
	private JComboBox<Representation> representationCombobox;
	private JButton btnSelectSpectacle;


	public Paiment(Reservation reservation) {
		this.currentSpectacle = reservation;
		init();
		me = this;
		System.out.println(personne.getId());
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
		
		btnSelectSpectacle = new JButton("Continuer");
		btnSelectSpectacle.setBackground(Color.DARK_GRAY);
		btnSelectSpectacle.setForeground(Color.WHITE);
		btnSelectSpectacle.setBounds(154, 204, 119, 21);
		btnSelectSpectacle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Paiment page = new Paiment(currentSpectacle);
				page.setVisible(true);
				me.dispose();
			}
		});
		panel.add(btnSelectSpectacle);
		
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
		createBtnRetour();
		createReservationCombobox();
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
		currentSpectacle = (Reservation) representationCombobox.getSelectedItem();
	}
	
	public void setCurrentRepresentation() {
		currentRepresentation = (Representation) representationCombobox.getSelectedItem();
		
	}
	public void createBtnRetour() {
		btnRetour = new JButton("Retour");
		btnRetour.setForeground(Color.WHITE);
		btnRetour.setBackground(Color.DARK_GRAY);
		btnRetour.setBounds(353, 60, 88, 26);
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Dashboard page = new Dashboard(personne);
				page.setVisible(true);
				me.dispose();
			}
		});
		contentPane.add(btnRetour);
	}
	
	public void init() {
		Representation representation = new Representation();
		representation.setSpectacle(this.currentSpectacle.getPlanning().getSpectacle());
		allRepresentation = representation.findAll();
		System.out.println("GETTING ID OF RESERVATION" );

		for (Representation res : allRepresentation) {
			System.out.println("GETTING ID OF REPRESENTATION" + res.getId());
		}
	}
}
