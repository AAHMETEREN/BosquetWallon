package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import pojo.Artiste;
import pojo.Client;
import pojo.Organisateur;

import javax.swing.JTabbedPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class LoginPage extends JFrame {

	private JPanel contentPane;

	public LoginPage() {
		LoginPage me = this;
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

		JButton btnNewButton = new JButton("Je suis un client");
		btnNewButton.setBounds(206, 52, 249, 65);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginForm page = new LoginForm(Client.role);
				page.setVisible(true);
				me.dispose();
			}
		});
		panel_1.setLayout(null);
		panel_1.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Je suis un organisateur");
		btnNewButton_1.setBounds(206, 138, 249, 65);
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.setBackground(Color.DARK_GRAY);
		panel_1.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginForm page = new LoginForm(Organisateur.role);
				page.setVisible(true);
				me.dispose();
			}
		});
		JButton btnNewButton_1_1 = new JButton("Je suis un artiste");
		btnNewButton_1_1.setBounds(206, 222, 249, 65);
		btnNewButton_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1_1.setBackground(Color.DARK_GRAY);
		panel_1.add(btnNewButton_1_1);
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginForm page = new LoginForm(Artiste.role);
				page.setVisible(true);
				me.dispose();
			}
		});
		JButton btnRetour = new JButton("Retour");
		btnRetour.setBounds(564, 10, 88, 27);
		btnRetour.setBackground(Color.DARK_GRAY);
		btnRetour.setForeground(Color.WHITE);
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main page = new Main();
				page.setVisible(true);
				me.dispose();
			}
		});
		panel_1.add(btnRetour);
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				me.dispose();
			}
		});


	}
}
