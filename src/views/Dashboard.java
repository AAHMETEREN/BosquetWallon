package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import pojo.Personne;
import pojo.Client;
import pojo.Organisateur;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;

public class Dashboard extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Personne personne = new Organisateur("test", "test", "test", "test", "test");
					Dashboard frame = new Dashboard(personne);
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
	public Dashboard(Personne personne) {
		Dashboard me = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 708, 431);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel(){
			public void paintComponent(Graphics g) {
				Image img = Toolkit.getDefaultToolkit().getImage(Main.class.getResource("/images/main.jpg"));
				g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
			}
		};
		panel.setBounds(0, 10, 684, 384);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Utilisateur : " + personne.getNomUtilisateur().toUpperCase());
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(474, 10, 181, 13);
		panel.add(lblNewLabel);

		if (personne instanceof Client) {
			JButton btnListeSpectacle = new JButton("Voir les spectacles");
			btnListeSpectacle.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnListeSpectacle.setForeground(Color.WHITE);
			btnListeSpectacle.setBackground(Color.RED);
			btnListeSpectacle.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnListeSpectacle.setBounds(58, 74, 220, 57);
			panel.add(btnListeSpectacle);
		} else if (personne instanceof Organisateur) {
			JButton btnLocation = new JButton("Louer une salle");
			btnLocation.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnLocation.setForeground(Color.WHITE);
			btnLocation.setBackground(Color.RED);
			btnLocation.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Location page = new Location(personne);
					page.setVisible(true);
					me.dispose();
				}
			});
			btnLocation.setBounds(58, 74, 220, 57);
			panel.add(btnLocation);
		}

		JButton btnRetour = new JButton("Deconnexion");
		btnRetour.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main page = new Main();
				page.setVisible(true);
				me.dispose();
			}
		});
		btnRetour.setForeground(Color.WHITE);
		btnRetour.setBackground(Color.DARK_GRAY);
		btnRetour.setBounds(525, 57, 138, 30);
		panel.add(btnRetour);
		
		JLabel lblType = new JLabel("Type : "+ personne.getClass().getName().substring(5) );
		lblType.setHorizontalAlignment(SwingConstants.RIGHT);
		lblType.setForeground(Color.WHITE);
		lblType.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblType.setBounds(484, 22, 171, 30);
		panel.add(lblType);
		
		JButton btnReservation = new JButton("Mes reservations");
		btnReservation.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnReservation.setBackground(Color.RED);
		btnReservation.setForeground(Color.WHITE);
		btnReservation.setBounds(58, 167, 222, 57);
		panel.add(btnReservation);
	}
}
