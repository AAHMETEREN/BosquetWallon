package views;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import pojo.Client;
import pojo.Organisateur;
import pojo.Personne;
import pojo.Reservation;
import pojo.Spectacle;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class ReservationOrganisateur extends JFrame {

	private JPanel contentPane;
	private Personne personne;
	private List<Reservation> mesReservations = new ArrayList<Reservation>();
	private Reservation currentReservation;
	private JButton btnRetour;
	private ReservationOrganisateur me;
	private JComboBox<Reservation> reservationsCombobox;
	JLabel titreLabel;
	private JLabel nbrPlaceParPersonneLabel;
	private JLabel dateDebutLabel;
	private JLabel idReservationLabel;
	private JLabel soldeLabel;
	private JLabel acompteLabel;
	private JLabel prixLabel;
	private JLabel statusLabel;
	private JLabel dateFinLabel;
	private JLabel lblNewLabel;
	private JLabel nombreDePlaceParPersonne;
	private JLabel acompte;
	private JLabel solde;
	private JLabel prix;
	private JLabel status;
	private JPanel panel_2;
	/**
	 * Create the frame.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Personne personne = new Client(1, "test", "test", "test", "test", "test",5);
					ReservationOrganisateur frame = new ReservationOrganisateur(personne);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ReservationOrganisateur(Personne personne) {
		this.personne = personne;
		init();
		me = this;
		System.out.println(personne.getId());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 465, 595);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);


		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(10, 99, 431, 449);
		contentPane.add(panel);
		panel.setLayout(null);
		
		titreLabel = new JLabel("Titre du spectacle");
		titreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titreLabel.setFont(new Font("Tahoma", Font.PLAIN, 33));
		titreLabel.setBounds(32, 0, 356, 47);
		panel.add(titreLabel);
		
		dateDebutLabel = new JLabel("New label");
		dateDebutLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		dateDebutLabel.setBounds(235, 67, 186, 32);
		panel.add(dateDebutLabel);
		
		idReservationLabel = new JLabel("15");
		idReservationLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		idReservationLabel.setFont(new Font("Tahoma", Font.BOLD, 23));
		idReservationLabel.setBounds(311, 0, 110, 44);
		panel.add(idReservationLabel);
		
		dateFinLabel = new JLabel("New label");
		dateFinLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		dateFinLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		dateFinLabel.setBounds(10, 69, 188, 28);
		panel.add(dateFinLabel);
		
		lblNewLabel = new JLabel("-");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 46));
		lblNewLabel.setBounds(208, 65, 43, 34);
		panel.add(lblNewLabel);
		
		panel_2 = new JPanel();
		panel_2.setBounds(10, 166, 411, 273);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		prix = new JLabel("Prix  :");
		prix.setBounds(44, 152, 164, 13);
		panel_2.add(prix);
		prix.setFont(new Font("Dialog", Font.PLAIN, 17));
		prix.setHorizontalAlignment(SwingConstants.LEFT);
		
		solde = new JLabel("Solde :");
		solde.setBounds(48, 114, 164, 13);
		panel_2.add(solde);
		solde.setFont(new Font("Dialog", Font.PLAIN, 16));
		solde.setHorizontalAlignment(SwingConstants.LEFT);
		
		acompte = new JLabel("Acompte :");
		acompte.setBounds(44, 79, 164, 13);
		panel_2.add(acompte);
		acompte.setFont(new Font("Dialog", Font.PLAIN, 17));
		acompte.setHorizontalAlignment(SwingConstants.LEFT);
		
		nombreDePlaceParPersonne = new JLabel("Max place/personne:");
		nombreDePlaceParPersonne.setBounds(44, 30, 173, 25);
		panel_2.add(nombreDePlaceParPersonne);
		nombreDePlaceParPersonne.setFont(new Font("Dialog", Font.PLAIN, 17));
		
		status = new JLabel("Status :");
		status.setBounds(44, 187, 164, 13);
		panel_2.add(status);
		status.setFont(new Font("Dialog", Font.PLAIN, 17));
		status.setHorizontalAlignment(SwingConstants.LEFT);
		
		statusLabel = new JLabel("New label");
		statusLabel.setBounds(212, 175, 132, 28);
		panel_2.add(statusLabel);
		statusLabel.setFont(new Font("Dialog", Font.PLAIN, 17));
		
		prixLabel = new JLabel("New label");
		prixLabel.setBounds(212, 144, 173, 21);
		panel_2.add(prixLabel);
		prixLabel.setFont(new Font("Dialog", Font.PLAIN, 17));
		
		soldeLabel = new JLabel("New label");
		soldeLabel.setBounds(212, 106, 94, 28);
		panel_2.add(soldeLabel);
		soldeLabel.setFont(new Font("Dialog", Font.PLAIN, 17));
		
		acompteLabel = new JLabel("New label");
		acompteLabel.setBounds(212, 68, 108, 28);
		panel_2.add(acompteLabel);
		acompteLabel.setFont(new Font("Dialog", Font.PLAIN, 17));
		
		nbrPlaceParPersonneLabel = new JLabel("New label");
		nbrPlaceParPersonneLabel.setBounds(212, 30, 136, 28);
		panel_2.add(nbrPlaceParPersonneLabel);
		nbrPlaceParPersonneLabel.setFont(new Font("Dialog", Font.PLAIN, 17));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(UIManager.getColor("ToolBar.dockingForeground"));
		panel_1.setBounds(0, 0, 451, 43);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel labelTitre = new JLabel("Mes r\u00E9servations");
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
		for (Reservation reservation : mesReservations) {
			reservationsCombobox.addItem(reservation);
		}		
		currentReservation = (Reservation) reservationsCombobox.getSelectedItem();
	}
	
	public void setCurrentReservation() {
		currentReservation = (Reservation) reservationsCombobox.getSelectedItem();
		titreLabel.setText(currentReservation.getPlanning().getSpectacle().getTitre());
		nbrPlaceParPersonneLabel.setText(Integer.toString(currentReservation.getPlanning().getSpectacle().getNombrePlaceParClient()));
		dateDebutLabel.setText(currentReservation.getPlanning().getdateDebutReservation().toString() + " - 12:00");
		dateFinLabel.setText(currentReservation.getPlanning().getDateFinReservation().toString() + " - 12:00");
		idReservationLabel.setText("N° "+Integer.toString(currentReservation.getId()));
		soldeLabel.setText(Float.toString(currentReservation.getSolde()));
		acompteLabel.setText(Float.toString(currentReservation.getAcompte()));
		prixLabel.setText(Float.toString(currentReservation.getPrix()));
		statusLabel.setText(currentReservation.getStatus());
	}
	public void createBtnRetour() {
		btnRetour = new JButton("Quitter");
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
		Reservation reservation = new Reservation();
		reservation.setOrganisateur(personne);
		mesReservations = reservation.findAll();
	}
}
