package Interface;

import java.awt.Color;
import java.awt.Component;
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
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import v1.Player;

/**
 * Permet à un joueur de se connecter
 * @author Guillaume
 */
public class Connexion {
	protected GUI myGui;
	protected JFrame frame;
	
	public Connexion(GUI myGui, JFrame frame) {
		this.myGui = myGui;
		this.frame = frame;
	}
	
	public void repaint() {
		Container panel = frame.getContentPane();
		panel.removeAll();
		panel.revalidate();
		panel.add(Box.createRigidArea(new Dimension(500,30)));
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		
		JPanel pageConnexion = new JPanel();
		pageConnexion.setLayout(new BoxLayout(pageConnexion, BoxLayout.LINE_AXIS));
		JLabel connexion = new JLabel("Page de connexion");
		connexion.setFont(new Font("Arial", Font.BOLD, 21));
		pageConnexion.add(connexion);
		panel.add(pageConnexion);
		
		panel.add(Box.createRigidArea(new Dimension(500,100)));
		
		JPanel inputUsername = new JPanel();
		inputUsername.setLayout(new BoxLayout(inputUsername, BoxLayout.LINE_AXIS));
		
		// USERNAME 
		JLabel tagUsername = new JLabel("Username: ");
		tagUsername.setFont(new Font("Arial", Font.PLAIN, 16));
		tagUsername.setAlignmentX(Component.LEFT_ALIGNMENT);
		inputUsername.add(tagUsername);
		
		inputUsername.add(Box.createRigidArea(new Dimension(43,10)));
		
		JTextField inUsername = new JTextField();
		inUsername.setMaximumSize(new Dimension(200,30));
		inUsername.setMinimumSize(new Dimension(200,30));
		inUsername.setPreferredSize(new Dimension(200,30));
		inUsername.setAlignmentX(Component.LEFT_ALIGNMENT);
		inputUsername.add(inUsername);
		panel.add(inputUsername);
		
		panel.add(Box.createRigidArea(new Dimension(500,20)));
		
		// PASSWORD
		JPanel inputPassword = new JPanel();
		inputPassword.setLayout(new BoxLayout(inputPassword, BoxLayout.LINE_AXIS));
		
		JLabel tagPassword = new JLabel("Mot de passe: ");
		tagPassword.setFont(new Font("Arial", Font.PLAIN, 16));
		tagPassword.setAlignmentX(Component.LEFT_ALIGNMENT);
		inputPassword.add(tagPassword);
		
		inputPassword.add(Box.createRigidArea(new Dimension(20,10)));
		
		JPasswordField inPassword = new JPasswordField();
		inPassword.setMaximumSize(new Dimension(200,30));
		inPassword.setMinimumSize(new Dimension(200,30));
		inPassword.setPreferredSize(new Dimension(200,30));
		inPassword.setAlignmentX(Component.LEFT_ALIGNMENT);
		inputPassword.add(inPassword);
		panel.add(inputPassword);
		
		panel.add(Box.createRigidArea(new Dimension(500,10)));
		
		// MESSAGE //
		JPanel messagePanel = new JPanel();
		messagePanel.setLayout(new BoxLayout(messagePanel, BoxLayout.LINE_AXIS));
		
		JLabel message = new JLabel("");
		message.setFont(new Font("Arial", Font.PLAIN, 15));
		message.setForeground(Color.red);
		messagePanel.add(message);
		panel.add(messagePanel);
		
		panel.add(Box.createRigidArea(new Dimension(500, 10)));
		
		// BOUTON CONFIRMER
		JPanel confirmPanel = new JPanel();
		confirmPanel.setLayout(new BoxLayout(confirmPanel, BoxLayout.LINE_AXIS));
		
		JButton confirm = new JButton("Confirmer");
		confirm.setMaximumSize(new Dimension(100,50));
		confirm.setPreferredSize(new Dimension(100,50));
		confirm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Player selected = null;
				String username = inUsername.getText();
				for(Player p : myGui.getListeJoueurs()) {
					if(p.getUsername().equals(username)) {
						selected = p;
						break;
					}
				}
				
				if(selected != null) {
					String password = inPassword.getText();
					if(selected.getPassword().equals(password)) {
						GUI.idSession = selected.getID();
						new Menu(myGui, frame).repaint();
					} else {
						message.setText("Identifiants invalides");
					}
				} else {
					message.setText("Identifiants invalides");
				}
				
			}
		});
		confirmPanel.add(confirm);
		panel.add(confirmPanel);
		
		panel.add(Box.createVerticalGlue());
		
		// BOUTON RETOUR
		JPanel backPanel = new JPanel();
		backPanel.setLayout(new BoxLayout(backPanel, BoxLayout.LINE_AXIS));
		
		JButton back = new JButton("Retour");
		back.setMaximumSize(new Dimension(100,50));
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				panel.revalidate();
				myGui.repaint();
			}
		});
		backPanel.add(back);
		backPanel.add(Box.createHorizontalGlue());
		panel.add(backPanel);
		
		panel.repaint();
	}
}
