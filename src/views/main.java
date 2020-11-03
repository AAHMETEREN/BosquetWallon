package views;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.awt.Label;
import java.awt.Font;
import java.awt.TextField;
import javax.swing.JLabel;

public class main extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main frame = new main();
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
	public main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 708, 431);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.RED);
		panel.setBounds(10, -20, 193, 420);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton registerBtn = new JButton("Inscription");
		registerBtn.setBounds(22, 338, 161, 45);
		panel.add(registerBtn);
		registerBtn.setForeground(Color.WHITE);
		registerBtn.setBackground(Color.DARK_GRAY);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(0, 20, 193, 400);
		panel.add(lblNewLabel_2);
		registerBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		JButton loginBtn = new JButton("Connexion");
		loginBtn.setForeground(Color.WHITE);
		loginBtn.setBackground(Color.RED);
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		loginBtn.setBounds(528, 331, 109, 45);
		contentPane.add(loginBtn);
		
		TextField textField = new TextField();
		textField.setBounds(227, 204, 410, 45);
		contentPane.add(textField);
		
		TextField textField_1 = new TextField();
		textField_1.setBounds(227, 280, 410, 45);
		contentPane.add(textField_1);
		
		JLabel lblNewLabel = new JLabel("Mot de passe");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(227, 255, 79, 19);
		contentPane.add(lblNewLabel);
		
		JLabel lblNomDutilisateur = new JLabel("Nom d'utilisateur");
		lblNomDutilisateur.setForeground(Color.WHITE);
		lblNomDutilisateur.setBounds(227, 179, 124, 19);
		contentPane.add(lblNomDutilisateur);
		
		JLabel lblNewLabel_1 = new JLabel("Bienvenue au ");
		lblNewLabel_1.setFont(new Font("Lucida Handwriting", Font.BOLD, 40));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(227, 2, 410, 104);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Bosquet Wallon !");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Lucida Handwriting", Font.BOLD, 40));
		lblNewLabel_1_1.setBounds(227, 72, 410, 104);
		contentPane.add(lblNewLabel_1_1);
	}
}
