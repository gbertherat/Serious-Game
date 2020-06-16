package Interface.User;

import Interface.GUI;
import v1.Password;
import v1.Player;

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
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.Timer;

import Components.Factory;

/**
 * Fenêtre utilisateur pour modifier son profil
 * @author Guillaume
 */
public class EditProfile {
	// VARS //
	private GUI myGui;
	private JFrame frame;
	
	/**
	 * Constructeur de la classe EditProfile
	 * @param myGui - GUI à utiliser
	 * @param frame - Frame à utiliser
	 */
	public EditProfile(GUI myGui, JFrame frame) {
		this.myGui = myGui;
		this.frame = frame;
	}
	
	/**
	 * Vérifie le format d'une entrée e-mail
	 * @param email - L'entrée à vérifier
	 * @return true s'il s'agît bien d'un format e-mail, false sinon.
	 */
	static boolean isValid(String email) {
		String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		return email.matches(regex);
	}
	
	/**
	 * Permet l'affichage de la fenêtre
	 * @param id - L'id du joueur à modifier
	 */
	public void repaint(int id) {
		if(GUI.idSession != 0 && id == GUI.idSession) {
			// On récupère le panel principal
			Container panel = frame.getContentPane();
			panel.removeAll();
			panel.revalidate();
			panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
			panel.add(Box.createRigidArea(new Dimension(1024,20)));
			
			Player player = myGui.getPlayer(id);
			
			// TITRE //
			JPanel titrePanel = Factory.addPanel();
			
			JLabel titre = Factory.addLabel("Modifier votre profil", 21, true);
			titrePanel.add(titre);
			panel.add(titrePanel);
			
			panel.add(Box.createRigidArea(new Dimension(500, 20)));	
			
			// NOM //
			JPanel nomPanel = Factory.addPanel();
			nomPanel.setMaximumSize(new Dimension(350, 40));
			
			JLabel nomHeader = Factory.addLabel("Nom: ", 16, true);
			nomPanel.add(nomHeader);
			nomPanel.add(Box.createRigidArea(new Dimension(44, 10)));
			JTextField nomInput = Factory.addField(200, 30, true);
			nomInput.setText(player.getNom());
			nomPanel.add(nomInput);
			panel.add(nomPanel);
			panel.add(Factory.addSpace(5));
			
			// PRENOM //
			JPanel prenomPanel = Factory.addPanel();
			prenomPanel.setMaximumSize(new Dimension(350, 40));
			
			JLabel prenomHeader = Factory.addLabel("Prénom: ", 16, true);
			prenomPanel.add(prenomHeader);
			prenomPanel.add(Box.createRigidArea(new Dimension(20, 10)));
			JTextField prenomInput = Factory.addField(200, 30, true);
			prenomInput.setText(player.getPrenom());
			prenomPanel.add(prenomInput);
			panel.add(prenomPanel);
			panel.add(Factory.addSpace(5));
			
			// AGE //
			JPanel agePanel = Factory.addPanel();
			agePanel.setMaximumSize(new Dimension(350, 40));
			
			JLabel ageHeader = Factory.addLabel("Age: ", 16, true);
			agePanel.add(ageHeader);
			agePanel.add(Box.createRigidArea(new Dimension(50, 10)));
			JSpinner ageInput = Factory.addSpiner(200, 25, 16, 30, 20);
			ageInput.setValue(Integer.valueOf(player.getAge()));
			agePanel.add(ageInput);
			panel.add(agePanel);
			panel.add(Factory.addSpace(5));
			
			// MAIL //
			JPanel mailPanel = Factory.addPanel();
			mailPanel.setMaximumSize(new Dimension(350, 40));
			
			JLabel mailHeader = Factory.addLabel("Mail: ", 16, true);
			mailPanel.add(mailHeader);
			mailPanel.add(Box.createRigidArea(new Dimension(50, 10)));
			JTextField mailInput = Factory.addField(250, 30, true);
			mailInput.setText(String.valueOf(player.getMail()));
			mailPanel.add(mailInput);
			panel.add(mailPanel);
			panel.add(Factory.addSpace(5));
			
			// USERNAME //
			JPanel usernamePanel = Factory.addPanel();
			usernamePanel.setMaximumSize(new Dimension(350, 40));
			
			JLabel usernameHeader = Factory.addLabel("Username: ", 16, true);
			usernamePanel.add(usernameHeader);
			usernamePanel.add(Box.createRigidArea(new Dimension(2, 10)));
			JTextField usernameInput = Factory.addField(200, 30, true);
			usernameInput.setText(String.valueOf(player.getUsername()));
			usernamePanel.add(usernameInput);
			panel.add(usernamePanel);
			panel.add(Factory.addSpace(5));
			
			// NOUVEAU PASSWORD //
			JPanel passwordPanel = Factory.addPanel();
			passwordPanel.setMaximumSize(new Dimension(350, 40));
			
			JLabel passwordHeader = Factory.addLabel("Nouveau password: ", 14, true);
			passwordPanel.add(passwordHeader);
			passwordPanel.add(Box.createRigidArea(new Dimension(7, 30)));
			JPasswordField passwordField = Factory.addPassField(200, 30);
			passwordPanel.add(passwordField);
			panel.add(passwordPanel);
			panel.add(Factory.addSpace(5));
			
			// CONFIRM PASSWORD //
			JPanel confirmPanel = Factory.addPanel();
			confirmPanel.setMaximumSize(new Dimension(350, 40));
			
			JLabel confirmHeader = Factory.addLabel("Confirmer password: ", 14, true);
			confirmPanel.add(confirmHeader);
			JPasswordField confirmField = Factory.addPassField(200, 30);
			confirmPanel.add(confirmField);
			panel.add(confirmPanel);
			panel.add(Factory.addSpace(20));
			
			// MOT DE PASSE ACTUEL //
			JPanel mdpPanel = Factory.addPanel();
			
			JLabel mdpHeader = Factory.addLabel("Entrez votre mot de passe actuel: ", 14, true);
			mdpPanel.add(mdpHeader);
			panel.add(mdpPanel);
			panel.add(Factory.addSpace(10));
			
			JPanel confirmFieldPanel = Factory.addPanel();
			JPasswordField mdpField = Factory.addPassField(200, 30);
			confirmFieldPanel.add(mdpField);
			panel.add(confirmFieldPanel);
			panel.add(Factory.addSpace(10));
			
			// MESSAGE //
			JPanel messagePanel = Factory.addPanel();
			JLabel messageLabel = Factory.addLabel("", 15, true);
			messageLabel.setForeground(Color.red);
			messagePanel.add(messageLabel);
			panel.add(messagePanel);
			panel.add(Factory.addSpace(10));
			
			// BOUTON : VALIDER
			JPanel buttonsPanel = Factory.addPanel();
			JButton validButton = Factory.addButton("Valider", 130, 40);
			
			/**
			 * Permet de valider les modifications du profil
			 */
			validButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// On récupère les données entrées
					String nom = nomInput.getText();
					String prenom = prenomInput.getText();
					int age = (int) ageInput.getValue();
					String mail = mailInput.getText();
					String username = usernameInput.getText();
					String newPassword1 = String.valueOf(passwordField.getPassword());
					String newPassword2 = String.valueOf(confirmField.getPassword());
					String currentPassword = String.valueOf(mdpField.getPassword());
					
					// On vérifie ces données
					if(nom.length() < 3) {
						messageLabel.setText("Erreur: Nom invalide (< 3 caractères)");
						return;
					} else if(prenom.length() < 3) {
						messageLabel.setText("Erreur: Prénom invalide (< 3 caractères)");
						return;
					} else if(mail.length() < 3) {
						messageLabel.setText("Erreur: Mail invalide (< 3 caractères)");
						return;
					} else if(!isValid(mail)) {
						messageLabel.setText("Erreur: Mail invalide (Format incorrecte)");
						return;
					} else if(username.length() < 3) {
						messageLabel.setText("Erreur: Username invalide (< 3 caractères)");
						return;
					} else if(!newPassword1.isEmpty()) {
						if(newPassword1.length() < 3) {
							messageLabel.setText("Erreur: Password invalide (< 3 caractères) ");
							return;
						} else if(!newPassword1.equals(newPassword2)) {
							messageLabel.setText("Erreur: Les deux mot de passes ne correspondent pas");
							return;
						}
					}
					if(!Password.encryptPassword(currentPassword).equals(player.getPassword())) {
						messageLabel.setText("Erreur: Votre mot de passe est incorrecte");
						return;
					}
					
					buttonsPanel.remove(validButton);
					
					// On modifie les attributs de l'objet Player par les données entrées
					player.setNom(nom);
					player.setPrenom(prenom);
					player.setAge(age);
					player.setMail(mail);
					player.setUsername(username);
					player.setPassword(Password.encryptPassword(newPassword1));

					messageLabel.setText("Modifications sauvegardées");
					myGui.saveAll(); // On sauvegarde
					ActionListener panel = new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent arg0) {
							new Profil(myGui, frame).repaint(id);
						}
					};
					Timer timer = new Timer(2000, panel);
					timer.start();
					timer.setRepeats(false);
				}
			});
			
			buttonsPanel.add(validButton);	
			panel.add(buttonsPanel);
			
			// BOUTON : RETOUR //
			panel.add(Box.createVerticalGlue());
			JPanel retourPanel = Factory.addPanel();
			JButton back = Factory.addButton("Retour", 100, 40);
			back.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					panel.removeAll();
					panel.revalidate();
					panel.repaint();
					new Profil(myGui, frame).repaint(id);
				}
			});
			retourPanel.add(back);
			retourPanel.add(Box.createHorizontalGlue());
			panel.add(retourPanel);
		
			panel.repaint();
		}
	}
}
