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

public class ListeSpectacles extends JFrame {

	private JPanel contentPane;
	private Personne personne;
	private List<Reservation> allSpectacles = new ArrayList<Reservation>();
	private Reservation currentSpectacle;
	private Spectacle spectacle = new Spectacle();
	private JButton btnRetour;
	private ListeSpectacles me;
	private JComboBox<Reservation> reservationsCombobox;
	JLabel titreLabel;
	private JLabel dateDebutLabel;
	private JLabel idReservationLabel;
	private JLabel dateFinLabel;
	private JLabel lblNewLabel;
	private JTextArea descriptionLabel;
	private JButton btnSelectSpectacle;
	/**
	 * Create the frame.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Personne personne = new Organisateur(1, "test", "test", "test", "test", "test", "test");
					ListeSpectacles frame = new ListeSpectacles(personne);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ListeSpectacles(Personne personne) {
		this.personne = personne;
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
		
		titreLabel = new JLabel("Titre du spectacle");
		titreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titreLabel.setFont(new Font("Tahoma", Font.BOLD, 33));
		titreLabel.setBounds(32, 0, 356, 47);
		panel.add(titreLabel);
		
		dateDebutLabel = new JLabel("New label");
		dateDebutLabel.setFont(new Font("Dialog", Font.PLAIN, 17));
		dateDebutLabel.setBounds(235, 171, 186, 32);
		panel.add(dateDebutLabel);
		
		idReservationLabel = new JLabel("15");
		idReservationLabel.setToolTipText("Num\u00E9ro du spectacle");
		idReservationLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		idReservationLabel.setFont(new Font("Tahoma", Font.BOLD, 23));
		idReservationLabel.setBounds(311, 0, 110, 44);
		panel.add(idReservationLabel);
		
		dateFinLabel = new JLabel("New label");
		dateFinLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		dateFinLabel.setFont(new Font("Dialog", Font.PLAIN, 17));
		dateFinLabel.setBounds(10, 173, 188, 28);
		panel.add(dateFinLabel);
		
		lblNewLabel = new JLabel("-");
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 22));
		lblNewLabel.setBounds(208, 169, 43, 34);
		panel.add(lblNewLabel);
		
		descriptionLabel = new JTextArea();
		descriptionLabel.setEditable(false);
		descriptionLabel.setLineWrap(true);
		descriptionLabel.setToolTipText("");
		descriptionLabel.setWrapStyleWord(true);
		descriptionLabel.setText("test test test test test test test test test test test test test test test test test test test test test test test test ");
		descriptionLabel.setBackground(Color.LIGHT_GRAY);
		descriptionLabel.setBounds(21, 60, 400, 114);
		panel.add(descriptionLabel);
		
		btnSelectSpectacle = new JButton("Continuer");
		btnSelectSpectacle.setBackground(Color.DARK_GRAY);
		btnSelectSpectacle.setForeground(Color.WHITE);
		btnSelectSpectacle.setBounds(154, 204, 119, 21);
		btnSelectSpectacle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				choixRepresentations page = new choixRepresentations(currentSpectacle,personne);
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
		
		JLabel labelTitre = new JLabel("Tous les spectacles");
		labelTitre.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitre.setBounds(10, 0, 429, 39);
		labelTitre.setFont(new Font("Tahoma", Font.PLAIN, 32));
		labelTitre.setForeground(UIManager.getColor("ToggleButton.highlight"));
		panel_1.add(labelTitre);
		createBtnRetour();
		createReservationCombobox();
	}
	public void createReservationCombobox() {
		reservationsCombobox = new JComboBox<Reservation>();
		reservationsCombobox.setBounds(10, 63, 321, 21);
		reservationsCombobox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				me.setCurrentReservation();
			}
		});
		contentPane.add(reservationsCombobox);
		for (Reservation reservation : allSpectacles) {
			reservationsCombobox.addItem(reservation);
		}		
		currentSpectacle = (Reservation) reservationsCombobox.getSelectedItem();
	}
	
	public void setCurrentReservation() {
		currentSpectacle = (Reservation) reservationsCombobox.getSelectedItem();
		titreLabel.setText(currentSpectacle.getPlanning().getSpectacle().getTitre());
		dateDebutLabel.setText(currentSpectacle.getPlanning().getdateDebutReservation().toString() + " - 12:00");
		dateFinLabel.setText(currentSpectacle.getPlanning().getDateFinReservation().toString() + " - 12:00");
		idReservationLabel.setText("N° "+Integer.toString(currentSpectacle.getId()));
		descriptionLabel.setText(currentSpectacle.getPlanning().getSpectacle().getConfiguration().getDescription());
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
		Spectacle spectacle = new Spectacle();
	
		allSpectacles = spectacle.findAll();
		System.out.println("GETTING ID OF RESERVATION" );

		for (Reservation res : allSpectacles) {
			System.out.println("GETTING ID OF RESERVATION" + res.getPlanning().getSpectacle().getTitre());
		}
	}
}
