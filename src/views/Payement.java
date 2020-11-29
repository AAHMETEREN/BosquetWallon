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

import pojo.Categorie;
import pojo.Categorie.TypesCategorie;
import pojo.Commande;
import pojo.Commande.livraison;
import pojo.Commande.payement;
import pojo.Personne;
import pojo.Representation;
import pojo.Reservation;
import pojo.Spectacle;
import pojo.Configuration.TypePlaces;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JSpinner;
import com.toedter.components.JSpinField;
import javax.swing.JRadioButton;

public class Payement extends JFrame {

	private JPanel contentPane;
	private Personne personne;
	private Reservation currentSpectacle;
	private Payement me;
	private Commande commande;
	private JPanel panel;
	private ButtonGroup modeDeLivraison = new ButtonGroup();
	private ButtonGroup modeDePaiement = new ButtonGroup();
	private JRadioButton rdbtnLivraisonSurPlace, rdbtnLivraisonTimbre, rdbtnLivraisonEnvoieSecu, rdbtnPaiementVisa,
			rdbtnPaiementPaypal, rdbtnPaiementSEPA;
	private JLabel lblPrix;
	private JLabel lblPrixValue;
	private JLabel lblNewLabel_1;
	private boolean isClicked = false;

	public Payement(Reservation reservation, Personne personne, Commande commande) {
		this.currentSpectacle = reservation;
		this.personne = personne;
		this.commande = commande;
		
		commande.setPersonne(personne);
		me = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 460, 383);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(10, 58, 431, 276);
		contentPane.add(panel);
		panel.setLayout(null);

		JButton btnAcheter = new JButton("Acheter");
		btnAcheter.setBackground(Color.DARK_GRAY);
		btnAcheter.setForeground(Color.WHITE);
		btnAcheter.setBounds(142, 201, 138, 40);
		btnAcheter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				payer();
			}
		});
		panel.add(btnAcheter);

		rdbtnLivraisonSurPlace = new JRadioButton("Sur place");
		rdbtnLivraisonSurPlace.setBackground(Color.LIGHT_GRAY);
		rdbtnLivraisonSurPlace.setBounds(24, 54, 121, 21);
		panel.add(rdbtnLivraisonSurPlace);

		rdbtnLivraisonTimbre = new JRadioButton("Envoir avec imbre prior");
		rdbtnLivraisonTimbre.setBackground(Color.LIGHT_GRAY);
		rdbtnLivraisonTimbre.setBounds(24, 86, 179, 21);
		panel.add(rdbtnLivraisonTimbre);

		rdbtnLivraisonEnvoieSecu = new JRadioButton("Envoie s\u00E9curis\u00E9 ( + \u20AC10 ) ");
		rdbtnLivraisonEnvoieSecu.setBackground(Color.LIGHT_GRAY);
		rdbtnLivraisonEnvoieSecu.setBounds(24, 117, 179, 21);
		rdbtnLivraisonEnvoieSecu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				me.isClicked = !isClicked;
				if(isClicked) {
					float prix = commande.getCout();
					prix+= 10;
					lblPrixValue.setText(Float.toString(prix));
				}else {
					float prix = commande.getCout();
					lblPrixValue.setText(Float.toString(prix));
				}
				
			}
		});
		panel.add(rdbtnLivraisonEnvoieSecu);

		rdbtnPaiementVisa = new JRadioButton("Visa");
		rdbtnPaiementVisa.setBackground(Color.LIGHT_GRAY);
		rdbtnPaiementVisa.setBounds(266, 54, 103, 21);
		panel.add(rdbtnPaiementVisa);

		rdbtnPaiementPaypal = new JRadioButton("Paypal");
		rdbtnPaiementPaypal.setBackground(Color.LIGHT_GRAY);
		rdbtnPaiementPaypal.setBounds(266, 86, 103, 21);
		panel.add(rdbtnPaiementPaypal);

		rdbtnPaiementSEPA = new JRadioButton("Virement SEPA");
		rdbtnPaiementSEPA.setToolTipText(" \u00E0 effectuer dans les 7 jours calendrier, sinon les tickets");
		rdbtnPaiementSEPA.setBackground(Color.LIGHT_GRAY);
		rdbtnPaiementSEPA.setBounds(266, 117, 155, 21);
		panel.add(rdbtnPaiementSEPA);

		JLabel lblNewLabel = new JLabel("Mode de livraison");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(24, 30, 187, 18);
		panel.add(lblNewLabel);

		JLabel lblModeDePaiment = new JLabel("Mode de paiment");
		lblModeDePaiment.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblModeDePaiment.setBounds(266, 30, 155, 18);
		panel.add(lblModeDePaiment);
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(UIManager.getColor("ToolBar.dockingForeground"));
		panel_1.setBounds(0, 0, 451, 43);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel labelTitre = new JLabel("Paiement");
		labelTitre.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitre.setBounds(10, 0, 429, 39);
		labelTitre.setFont(new Font("Tahoma", Font.PLAIN, 32));
		labelTitre.setForeground(UIManager.getColor("ToggleButton.highlight"));
		panel_1.add(labelTitre);

		modeDeLivraison.add(rdbtnLivraisonTimbre);
		modeDeLivraison.add(rdbtnLivraisonSurPlace);
		modeDeLivraison.add(rdbtnLivraisonEnvoieSecu);
		modeDePaiement.add(rdbtnPaiementSEPA);
		modeDePaiement.add(rdbtnPaiementPaypal);
		modeDePaiement.add(rdbtnPaiementVisa);
		
		lblPrix = new JLabel("Prix : ");
		lblPrix.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPrix.setBounds(166, 162, 45, 21);
		panel.add(lblPrix);
		
		lblPrixValue = new JLabel("");
		lblPrixValue.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrixValue.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPrixValue.setBounds(208, 163, 90, 21);
		panel.add(lblPrixValue);
		lblPrixValue.setText(Float.toString(commande.getCout()));
		
		lblNewLabel_1 = new JLabel("( +5 \u20AC de frais de dossier )");
		lblNewLabel_1.setBounds(142, 181, 155, 13);
		panel.add(lblNewLabel_1);
		
	}

	public void payer() {
		this.commande.augmenterCout(5);
		lblPrixValue.setText(Float.toString(commande.getCout()));
		if (rdbtnLivraisonTimbre.isSelected()) {
			this.commande.setModeDeLivraison(livraison.TIMBRE_PRIOR);
		} else if (rdbtnLivraisonSurPlace.isSelected()) {
			this.commande.setModeDeLivraison(livraison.SUR_PLACE);
		} else {
			this.commande.setModeDeLivraison(livraison.ENVOIE_SECURISEE);
		}

		if (rdbtnPaiementSEPA.isSelected()) {
			this.commande.setModeDePayement(payement.SEPA);
		} else if (rdbtnPaiementPaypal.isSelected()) {
			this.commande.setModeDePayement(payement.PAYPAL);
		} else {
			this.commande.setModeDePayement(payement.VISA);
		}
		
		
		boolean isCommandeCreated = this.commande.create();
		if(isCommandeCreated) {
			JOptionPane.showMessageDialog(null, "Payement effectué !");
		}else {
			this.commande.augmenterCout(-5);
			JOptionPane.showMessageDialog(null, "Erreur lors du payement !");
		}
	}
}
