package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import pojo.*;

public class Dashboard extends JFrame {

	private JPanel contentPane;
	private static final long serialVersionUID = -9047883467236372662L;
	private JLayeredPane layeredPane;
	private JPanel HomePanel, ShowPanel, OrderPanel;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard frame = new Dashboard();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void SwitchPanels(@SuppressWarnings("exports") JPanel p) {
		layeredPane.removeAll();
		layeredPane.add(p);
		layeredPane.repaint();
		layeredPane.revalidate();
	}
	
	public Dashboard() {
		createView();
	}
	public Dashboard(Personne personne) {
		System.out.println(personne.getMotDePasse());
		createView();
	}

	public void createView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 580, 400);
		contentPane = new JPanel();
		contentPane.setVisible(true);
		contentPane.setVisible(!isVisible());
		contentPane.setBorder(null);
		contentPane.setLayout(null);
		setContentPane(contentPane);

		layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 580, 371);
		contentPane.add(layeredPane);

		OrderPanel =  new JPanel();
		OrderPanel.setOpaque(false);
		OrderPanel.setBounds(0, 0, 580, 371);
		OrderPanel.setLayout(null);
		layeredPane.add(OrderPanel);

		HomePanel = new JPanel();
		HomePanel.setOpaque(false);
		HomePanel.setBounds(0, 0, 580, 371);
		HomePanel.setLayout(null);
		layeredPane.add(HomePanel);

		JLabel title = new JLabel("Choisissez une option au dessus");
		title.setHorizontalTextPosition(SwingConstants.CENTER);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setForeground(Color.BLACK);
		title.setBounds((580 - 328) / 2, 120, 328, 49);
		HomePanel.add(title);

		ShowPanel = new JPanel();
		ShowPanel.setOpaque(false);
		ShowPanel.setBounds(0, 0, 580, 371);
		ShowPanel.setLayout(null);
		layeredPane.add(ShowPanel);

		JLabel lblNewLabel = new JLabel("Choisissez un spectacle");
		lblNewLabel.setBounds(207, 36, 194, 29);
		ShowPanel.add(lblNewLabel);

		CreateMenuBar();
	}
	

	
	private void CreateMenuBar() {

		JMenuBar menuBar = new JMenuBar();

		JMenu fileMenu = new JMenu("Spectacle");
		fileMenu.setMnemonic(KeyEvent.VK_F);

		JMenu editMenu = new JMenu("Espace personnel");
		editMenu.setMnemonic(KeyEvent.VK_F);

		JMenu exitMenu = new JMenu("Quitter");
		exitMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		exitMenu.setMnemonic(KeyEvent.VK_F);

		JMenuItem eMenuItem = new JMenuItem("Liste des spectacles");
		eMenuItem.setMnemonic(KeyEvent.VK_E);
		eMenuItem.addActionListener((event) -> {
			SwitchPanels(ShowPanel);
		});

		JMenuItem eEditItem = new JMenuItem("Mes commandes");
		eEditItem.setMnemonic(KeyEvent.VK_E);
		eEditItem.addActionListener((event) -> {
			SwitchPanels(OrderPanel);
		});

		fileMenu.add(eMenuItem);
		editMenu.add(eEditItem);
		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		menuBar.add(exitMenu);

		setJMenuBar(menuBar);
		SwitchPanels(HomePanel);
	}

}
