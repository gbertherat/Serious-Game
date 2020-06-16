package Interface;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
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

import Components.Factory;
import Interface.User.Menu;
import v1.Password;
import v1.Player;

/**
 * Permet à un joueur de se connecter
 * @author Guillaume
 */
public class Connexion {
	private GUI myGui;
	private JFrame frame;
	
	/**
	 * Constructeur de la classe Connexion
	 * @param myGui - Le GUI utilisé
	 * @param frame - La JFrame utilisé
	 */
	public Connexion(GUI myGui, JFrame frame) {
		this.myGui = myGui;
		this.frame = frame;
	}
	
	/**
	 * Méthode de repaint() pour afficher la fenêtre JSwing
	 */
	public void repaint() {
		// On récupère le panel principal
		Container panel = frame.getContentPane();
		panel.removeAll();
		panel.revalidate();
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		panel.add(Factory.addSpace(150));
		
		// TITRE //
		JPanel pageConnexion = Factory.addPanel();
		JLabel connexion = Factory.addLabel("Page de connexion", 21, true);
		pageConnexion.add(connexion);
		panel.add(pageConnexion);
		
		panel.add(Factory.addSpace(30));
		
		// USERNAME 
		JPanel inputUsername = Factory.addPanel();
		JLabel tagUsername = Factory.addLabel("Username:", 16, true);
		inputUsername.add(tagUsername);
		inputUsername.add(Box.createRigidArea(new Dimension(28,40)));
		
		JTextField inUsername = Factory.addField(250, 30, true);
		inputUsername.add(inUsername);
		panel.add(inputUsername);
		
		// PASSWORD
		JPanel inputPassword = Factory.addPanel();
		JLabel tagPassword = Factory.addLabel("Mot de passe:", 16, true);
		inputPassword.add(tagPassword);
		inputPassword.add(Box.createRigidArea(new Dimension(7,40)));
		
		JPasswordField inPassword = Factory.addPassField(250, 30);
		inputPassword.add(inPassword);
		panel.add(inputPassword);
		
		panel.add(Factory.addSpace(10));
		
		// MESSAGE //
		JPanel messagePanel = Factory.addPanel();
		JLabel message = Factory.addLabel("", 16, true);
		message.setForeground(Color.red);
		messagePanel.add(message);
		panel.add(messagePanel);
		
		panel.add(Factory.addSpace(10));
		
		// BOUTON : CONFIRMER
		JPanel confirmPanel = Factory.addPanel();
		JButton confirm = Factory.addButton("Confirmer", 150, 50);
		confirm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Player selected = null;
				String username = inUsername.getText();
				// On vérifie que l'utilisateur entré existe dans la liste des joueurs
				for(Player p : myGui.getListeJoueurs()) {
					if(p.getUsername().equals(username)) {
						selected = p;
						break;
					}
				}
				
				// Si l'utilisateur a été trouvé
				if(selected != null) {
					String password = Password.encryptPassword(String.valueOf(inPassword.getPassword()));
					if(selected.getPassword().equals(password)) { // On vérifie que les mots de passes correspondent
						GUI.idSession = selected.getID(); // Si c'est le cas, on change l'id de Session
						new Menu(myGui, frame).repaint(); // Et on affiche le menu
					} else {
						message.setText("Identifiants invalides"); // Sinon on affiche un message d'erreur
						return;
					}
				} else {
					message.setText("Identifiants invalides");
					return;
				}
				
			}
		});
		confirmPanel.add(confirm);
		panel.add(confirmPanel);
		
		panel.add(Box.createVerticalGlue());
		
		// BOUTON : RETOUR
		panel.add(Box.createVerticalGlue());
		JPanel retourPanel = Factory.addPanel();
		JButton back = Factory.addButton("Retour", 100, 40);
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				panel.revalidate();
				panel.repaint();
				new MainMenu(myGui, frame).repaint();
			}
		});
		retourPanel.add(back);
		retourPanel.add(Box.createHorizontalGlue());
		panel.add(retourPanel);
		
		panel.repaint();
	}
}
