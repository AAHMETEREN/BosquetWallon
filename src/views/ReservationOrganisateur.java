package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import pojo.Personne;
import pojo.Reservation;
import pojo.Spectacle;

public class ReservationOrganisateur extends JFrame {

	private JPanel contentPane;
	private Personne personne;
	private List<Reservation> mesReservations = new ArrayList<Reservation>();
	private Spectacle spectacle = new Spectacle();

	/**
	 * Create the frame.
	 */
	public ReservationOrganisateur(Personne personne) {
		System.out.println(personne.getId());
		this.personne = personne;
		init();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}
	
	public void init() {
		Reservation reservation = new Reservation();
		reservation.setOrganisateur(personne);
		mesReservations = reservation.findAll();
		System.out.println("GETTING ID OF RESERVATION" );

		for (Reservation res : mesReservations) {
			System.out.println("GETTING ID OF RESERVATION" + res.getId());
		}
	}

}
