package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import pojo.Personne;
import pojo.Spectacle;

public class ReservationOrganisateur extends JFrame {

	private JPanel contentPane;
	private Personne personne;
	private List<Spectacle> mesSpectacles = new ArrayList<Spectacle>();
	private Spectacle spectacle = new Spectacle();


	/**
	 * Create the frame.
	 */
	public ReservationOrganisateur(Personne personne) {
		this.personne = personne;
		this.spectacle.setOrganisateur(personne);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		getAllOrganisateurSpectacle();
	}
	
	public void getAllOrganisateurSpectacle() {
		//mesSpectacles = spectacle.getAllSpectacles();
	}

}
