package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import pojo.Organisateur;
import pojo.Personne;

public class Location extends JFrame {

	private JPanel contentPane;
	private Personne personne;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Personne personne = new Organisateur("test", "test", "test", "test", "test");
					Location frame = new Location(personne);
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
	public Location(Personne personne) {
		this.personne = personne;
		Location me = this;
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
		panel.setBounds(0, 0, 436, 273);
		contentPane.add(panel);
		panel.setLayout(null);
		JButton btnRetour = new JButton("Retour");
		btnRetour.setBackground(Color.DARK_GRAY);
		btnRetour.setForeground(Color.WHITE);
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Dashboard page = new Dashboard(personne);
				page.setVisible(true);
				me.dispose();
			}
		});
		btnRetour.setBounds(338, 10, 88, 26);
		panel.add(btnRetour);
		
	}

}
