package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import dao.ClientDAO;
import dao.DAO;
import pojo.Client;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.awt.Label;
import java.awt.Font;
import java.awt.TextField;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Main extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		var me = this;
		DAO<Client> clientDAO = new ClientDAO(database.SqliteConnection.getInstance());// on fait connection
		for (int i = 1; i < 2; i++) {
			Client eleve = clientDAO.find(i);
			System.out.println("Eleve N°" + eleve.getNom() + " " + eleve.getPrenom());
		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 708, 431);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel() {
			public void paintComponent(Graphics g) {
				Image img = Toolkit.getDefaultToolkit().getImage(Main.class.getResource("/images/vertical-ticket.png"));
				g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
			}
		};
		panel.setBackground(Color.RED);
		panel.setBounds(0, 2, 221, 390);
		contentPane.add(panel);
		panel.setLayout(null);

		JButton registerBtn = new JButton("Inscription");

		registerBtn.setBounds(54, 324, 113, 33);
		panel.add(registerBtn);
		registerBtn.setForeground(Color.WHITE);
		registerBtn.setBackground(Color.DARK_GRAY);
		registerBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisterPage page = new RegisterPage();
				page.setVisible(true);
				me.dispose();
			}
		});

		JPanel panel_1 = new JPanel() {
			public void paintComponent(Graphics g) {
				Image img = Toolkit.getDefaultToolkit().getImage(Main.class.getResource("/images/main-background.jpg"));
				g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
			}
		};
		panel_1.setBounds(218, 2, 476, 390);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JButton loginBtn = new JButton("Connexion");
		loginBtn.setBounds(281, 316, 157, 34);
		loginBtn.setForeground(Color.WHITE);
		loginBtn.setBackground(Color.RED);
		panel_1.add(loginBtn);

		TextField textField = new TextField();
		textField.setBounds(65, 273, 373, 34);
		textField.setForeground(Color.BLACK);
		textField.setFont(new Font("Dialog", Font.PLAIN, 21));
		textField.setBackground(Color.LIGHT_GRAY);
		panel_1.add(textField);

		TextField textField_1 = new TextField();
		textField_1.setBounds(65, 205, 373, 34);
		textField_1.setForeground(Color.BLACK);
		textField_1.setFont(new Font("Dialog", Font.PLAIN, 21));
		textField_1.setBackground(Color.LIGHT_GRAY);
		panel_1.add(textField_1);

		JLabel lblNewLabel = new JLabel("Mot de passe");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(65, 254, 129, 13);
		lblNewLabel.setForeground(Color.WHITE);
		panel_1.add(lblNewLabel);

		JLabel lblNomDutilisateur = new JLabel("Nom d'utilisateur");
		lblNomDutilisateur.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNomDutilisateur.setBounds(65, 187, 142, 13);
		lblNomDutilisateur.setForeground(Color.WHITE);
		panel_1.add(lblNomDutilisateur);

		JLabel lblNewLabel_1 = new JLabel("Bienvenue au ");
		lblNewLabel_1.setBounds(93, 43, 346, 56);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Impact", Font.BOLD, 44));
		panel_1.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Bosquet Wallon !");
		lblNewLabel_1_1.setBounds(65, 104, 401, 56);
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Impact", Font.BOLD, 44));
		panel_1.add(lblNewLabel_1_1);
	}
}
