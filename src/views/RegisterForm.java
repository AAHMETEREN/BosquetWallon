package views;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import pojo.Artiste;
import pojo.Client;
import pojo.Organisateur;
import pojo.Personne;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
public class RegisterForm extends JFrame {
	private JPanel contentPane;
	private JTextField nomUtilisateur;
	private JTextField motDePasse;
	private JTextField prenom;
	private JTextField nom;
	private JTextField age;
	private JTextField adresse;
	private JTextField nomDeScene;
	private JTextField nomEntreprise;

	public RegisterForm(String role) {
		RegisterForm me = this;
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
		nomDeScene = new JTextField();
		nomEntreprise = new JTextField();
		if(role ==  Client.role) {
			JLabel lblAge = new JLabel("Age");
			lblAge.setBounds(457, 194, 59, 13);
			panel_1.add(lblAge);
			age.setColumns(10);
			age.setBounds(457, 217, 72, 33);
			panel_1.add(age);
		}else if(role == Organisateur.role) {
			nomEntreprise.setColumns(10);
			nomEntreprise.setBounds(126, 279, 308, 33);
			panel_1.add(nomEntreprise);
			JLabel lblNomEntreprise = new JLabel("Nom d'entreprise");
			lblNomEntreprise.setBounds(126, 260, 185, 13);
			panel_1.add(lblNomEntreprise);
		}else if(role == Artiste.role) {
			
			nomDeScene.setColumns(10);
			nomDeScene.setBounds(126, 279, 308, 33);
			panel_1.add(nomDeScene);
			
			JLabel lblNomDeScene = new JLabel("Nom de scene");
			lblNomDeScene.setBounds(126, 260, 185, 13);
			panel_1.add(lblNomDeScene);
		}

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
		
		
		JButton btnNewButton = new JButton("S'inscrire");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.DARK_GRAY);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Personne personne = new Personne();
					if(role == Client.role) {
						personne =  new Client(
								0,
								motDePasse.getText(), 
								nomUtilisateur.getText(), 
								adresse.getText(),
								prenom.getText(), 
								nom.getText(),
								Integer.parseInt(age.getText())
							);
						
					}
					else if(role == Organisateur.role) {
						personne =  new Organisateur(
								0,
								motDePasse.getText(), 
								nomUtilisateur.getText(), 
								adresse.getText(),
								prenom.getText(), 
								nom.getText(),
								nomEntreprise.getText()
							);
					}
					else if(role == Artiste.role) {
						personne =  new Artiste(
								0,
								motDePasse.getText(), 
								nomUtilisateur.getText(), 
								adresse.getText(),
								prenom.getText(), 
								nom.getText(),
								nomDeScene.getText()
							);
					}
					
					Personne isAlreadyCreatedUser = personne.find();
					System.out.println(isAlreadyCreatedUser);
					if(isAlreadyCreatedUser == null) {
						Boolean isNewUserCreated = personne.register();

						if(isNewUserCreated) {
							Dashboard dashboard = new Dashboard(personne);
							dashboard.setVisible(true);
							me.dispose();
						}else {
							JOptionPane.showMessageDialog(null, "Erreur lors de la création du compte.");
						}
					}else {
						JOptionPane.showMessageDialog(null, "Utilisateur  deja existant.");
					}
					
				
				}
			
		});
		btnNewButton.setBounds(126, 328, 130, 33);
		panel_1.add(btnNewButton);
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.setBounds(564, 10, 88, 27);
		btnRetour.setBackground(Color.DARK_GRAY);
		btnRetour.setForeground(Color.WHITE);
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisterPage page = new RegisterPage();
				page.setVisible(true);
				me.dispose();
			}
		});
		panel_1.add(btnRetour);
		
		
	
	}
}
