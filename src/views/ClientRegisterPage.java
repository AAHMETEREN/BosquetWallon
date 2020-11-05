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

import javax.swing.JTabbedPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class ClientRegisterPage extends JFrame {

	private JPanel contentPane;
	private JTextField nomUtilisateur;
	private JTextField motDePasse;
	private JTextField prenom;
	private JTextField nom;
	private JTextField age;
	private JTextField adresse;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientRegisterPage frame = new ClientRegisterPage();
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
	public ClientRegisterPage() {
		DAO<Client> clientDAO = new ClientDAO(database.SqliteConnection.getInstance());// on fait connection
		ClientRegisterPage me = this;
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 436, 263);
		getContentPane().add(panel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 708, 431);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_1 = new JPanel() {
			public void paintComponent(Graphics g) {
				Image img = Toolkit.getDefaultToolkit().getImage(Main.class.getResource("/images/red-tickets.png"));
				g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
			}
		};
		panel_1.setBounds(22, 10, 662, 371);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		nomUtilisateur = new JTextField();
		nomUtilisateur.setBounds(126, 82, 185, 33);
		panel_1.add(nomUtilisateur);
		nomUtilisateur.setColumns(10);

		motDePasse = new JTextField();
		motDePasse.setColumns(10);
		motDePasse.setBounds(339, 82, 190, 33);
		panel_1.add(motDePasse);

		prenom = new JTextField();
		prenom.setColumns(10);
		prenom.setBounds(126, 152, 185, 33);
		panel_1.add(prenom);

		nom = new JTextField();
		nom.setColumns(10);
		nom.setBounds(339, 152, 190, 33);
		panel_1.add(nom);

		age = new JTextField();
		age.setColumns(10);
		age.setBounds(457, 217, 72, 33);
		panel_1.add(age);

		adresse = new JTextField();
		adresse.setColumns(10);
		adresse.setBounds(126, 217, 308, 33);
		panel_1.add(adresse);

		JLabel lblNewLabel = new JLabel("Nom d'utilisateur");
		lblNewLabel.setBounds(126, 59, 185, 13);
		panel_1.add(lblNewLabel);

		JLabel lblMotDePasse = new JLabel("Mot de passe");
		lblMotDePasse.setBounds(344, 59, 185, 13);
		panel_1.add(lblMotDePasse);

		JLabel lblPrenom = new JLabel("Prenom");
		lblPrenom.setBounds(126, 129, 185, 13);
		panel_1.add(lblPrenom);

		JLabel lblNom = new JLabel("Nom");
		lblNom.setBounds(344, 129, 185, 13);
		panel_1.add(lblNom);

		JLabel lblAdresse = new JLabel("Adresse");
		lblAdresse.setBounds(126, 194, 185, 13);
		panel_1.add(lblAdresse);

		JLabel lblAge = new JLabel("Age");
		lblAge.setBounds(457, 194, 59, 13);
		panel_1.add(lblAge);

		JButton btnNewButton = new JButton("S'inscrire");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.DARK_GRAY);

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String test = nomUtilisateur.getText();
				System.out.println(test);
				nomUtilisateur.getText();
				Client client = new Client(
						motDePasse.getText(), 
						nomUtilisateur.getText(), 
						adresse.getText(),
						prenom.getText(), 
						nom.getText(), 
						Integer.parseInt(age.getText())
					);

				clientDAO.create(client);
			}
		});
		btnNewButton.setBounds(399, 287, 130, 33);
		panel_1.add(btnNewButton);
	}
}
