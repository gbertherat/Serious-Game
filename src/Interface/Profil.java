package Interface;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import v1.Player;

public class Profil {
	GUI myGui;
	JFrame frame;
	
	public Profil(GUI myGui, JFrame frame) {
		this.myGui = myGui;
		this.frame = frame;
	}
	
	public void repaint() {
		Container panel = frame.getContentPane();
		panel.removeAll();
		panel.revalidate();
		panel.add(Box.createRigidArea(new Dimension(500,30)));
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		
		Player selected = myGui.getPlayer(GUI.idSession);
		
		// TITRE //
		JPanel titrePanel = new JPanel();
		titrePanel.setLayout(new BoxLayout(titrePanel, BoxLayout.LINE_AXIS));
		JLabel titre = new JLabel("Serious-Game");
		titre.setFont(new Font("Arial", Font.BOLD, 21));
		titrePanel.add(titre);
		panel.add(titrePanel);
		
		panel.add(Box.createRigidArea(new Dimension(500,30)));
		
		// PROFIL DE //
		JPanel headPanel = new JPanel();
		headPanel.setLayout(new BoxLayout(headPanel, BoxLayout.LINE_AXIS));
		JLabel headLabel = new JLabel("Profil de: ");
		headLabel.setFont(new Font("Arial", Font.BOLD, 16));
		headPanel.add(headLabel);
		
		JLabel nameLabel = new JLabel(selected.getNom() + " " + selected.getPrenom());
		nameLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		headPanel.add(nameLabel);
		panel.add(headPanel);
		
		panel.add(headPanel);
		
		panel.add(Box.createRigidArea(new Dimension(500, 10)));
		
		// MAIL //
		JPanel mailPanel = new JPanel();
		mailPanel.setLayout(new BoxLayout(mailPanel, BoxLayout.LINE_AXIS));
		mailPanel.setMaximumSize(new Dimension(500, 30));
		mailPanel.add(Box.createRigidArea(new Dimension(20, 20)));
		
		JLabel mailLabel = new JLabel("Mail: ");
		mailLabel.setFont(new Font("Arial", Font.BOLD, 16));
		mailPanel.add(mailLabel);
		
		JLabel mail = new JLabel(selected.getMail());
		mail.setFont(new Font("Arial", Font.PLAIN, 16));
		mailPanel.add(mail);
		panel.add(mailPanel);
		
		panel.repaint();
		
		// USERNAME //
		JPanel usernamePanel = new JPanel();
		usernamePanel.setLayout(new BoxLayout(usernamePanel, BoxLayout.LINE_AXIS));
		usernamePanel.setMaximumSize(new Dimension(500, 30));
		usernamePanel.add(Box.createRigidArea(new Dimension(20, 20)));
		
		JLabel usernameLabel = new JLabel("Username: ");
		usernameLabel.setFont(new Font("Arial", Font.BOLD, 16));
		usernamePanel.add(usernameLabel);
		
		JLabel userLabel = new JLabel(selected.getUsername());
		userLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		usernamePanel.add(userLabel);
		panel.add(usernamePanel);
		
		// 
		
		// BOUTON : RETOUR //
		Menu newMenu = new Menu(myGui, frame);
		JPanel retourPanel = new JPanel();
		retourPanel.setLayout(new BoxLayout(retourPanel, BoxLayout.LINE_AXIS));
		
		JButton butRetour = new JButton("Retour");
		butRetour.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				newMenu.repaint();
			}
		});
		retourPanel.add(Box.createVerticalGlue());
		retourPanel.add(butRetour);
		retourPanel.add(Box.createHorizontalGlue());
		panel.add(retourPanel);
	}
}
