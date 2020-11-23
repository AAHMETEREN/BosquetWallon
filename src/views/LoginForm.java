package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import pojo.Client;
import pojo.Organisateur;
import pojo.Personne;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginForm extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JTextField password;

	public LoginForm(String role) {
		LoginForm me = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 708, 431);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel() {
			public void paintComponent(Graphics g) {
				Image img = Toolkit.getDefaultToolkit().getImage(Main.class.getResource("/images/red-tickets.png"));
				g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
			}
		};
		panel.setBounds(5, 5, 684, 384);
		contentPane.add(panel);
		panel.setLayout(null);

		username = new JTextField();
		username.setBounds(178, 100, 325, 35);
		panel.add(username);
		username.setColumns(10);

		JLabel lblNewLabel = new JLabel("Nom d'utilisateur");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(178, 77, 139, 13);
		panel.add(lblNewLabel);

		JLabel lblMotDePasse = new JLabel("Mot de passe");
		lblMotDePasse.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMotDePasse.setBounds(178, 145, 139, 13);
		panel.add(lblMotDePasse);

		password = new JTextField();
		password.setColumns(10);
		password.setBounds(178, 168, 325, 35);
		panel.add(password);

		JButton btnNewButton = new JButton("Connexion");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Personne personne = new Personne();
				personne.setNomUtilisateur(username.getText());
				personne.setMotDePasse(password.getText());
				personne.setRole(role);
				boolean isAuthenticated = personne.login();
				if (isAuthenticated) {
					Dashboard dashboard = new Dashboard(personne);
					dashboard.setVisible(true);
					me.dispose();
				} else {
					JOptionPane.showMessageDialog(null, "Mot de passe/Nom d'utilisateur incorrecte !");
				}

			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.setBounds(381, 221, 119, 35);
		panel.add(btnNewButton);

		JButton btnRetour = new JButton("Retour");
		btnRetour.setBackground(Color.DARK_GRAY);
		btnRetour.setForeground(Color.WHITE);
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginPage page = new LoginPage();
				page.setVisible(true);
				me.dispose();
			}
		});
		btnRetour.setBounds(586, 10, 88, 26);
		panel.add(btnRetour);
	}
}
