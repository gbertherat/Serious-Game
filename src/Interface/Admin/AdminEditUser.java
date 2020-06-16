package Interface.Admin;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

import Components.Factory;
import Interface.GUI;
import v1.Defi;
import v1.Player;

/**
 * Fenêtre administrateur pour modifier un utilisateur
 * @author Guillaume
 */
public class AdminEditUser {
	// VARS //
	private GUI myGui;
	private JFrame frame;
	private static int nbPress = 0;
	
	/**
	 * Constructeur de la classe AdminEditUser
	 * @param myGui - GUI à utiliser
	 * @param frame - Frame à utiliser
	 */
	public AdminEditUser(GUI myGui, JFrame frame) {
		this.myGui = myGui;
		this.frame = frame;
	}
	
	/**
	 * Permet l'affichage de la fenêtre
	 * @param id - L'id de l'utilisateur à modifier
	 */
	public void repaint(int id) {
		if(GUI.idSession != 0) {
			Player selected = myGui.getPlayer(GUI.idSession);
			if(selected.isAdmin()) { // Si le joueur est un administrateur
				// On récupère le panel principal
				Container panel = frame.getContentPane();
				panel.removeAll();
				panel.revalidate();
				panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
				panel.add(Box.createRigidArea(new Dimension(1024,20)));
				
				Player player = myGui.getPlayer(id);
			
				// TITRE //
				JPanel titrePanel = Factory.addPanel();
				
				JLabel titre = Factory.addLabel("Modifier un utilisateur", 21, true);
				titrePanel.add(titre);
				panel.add(titrePanel);
				
				panel.add(Box.createRigidArea(new Dimension(500, 20)));	

				// USER ID //
				JPanel idPanel = Factory.addPanel();
				idPanel.setMaximumSize(new Dimension(300, 30));
				
				JLabel idHeader = Factory.addLabel("ID: ", 16, true);
				idPanel.add(idHeader);
				JLabel idLabel = Factory.addLabel(String.valueOf(player.getID()), 16, false);
				idPanel.add(idLabel);
				panel.add(idPanel);
				
				// USER NOM //
				JPanel nomPanel = Factory.addPanel();
				nomPanel.setMaximumSize(new Dimension(300, 40));
				
				JLabel nomHeader = Factory.addLabel("Nom: ", 16, true);
				nomPanel.add(nomHeader);
				nomPanel.add(Box.createRigidArea(new Dimension(44, 10)));
				JTextField nomInput = Factory.addField(200, 30, true);
				nomInput.setText(player.getNom());
				nomPanel.add(nomInput);
				panel.add(nomPanel);
				panel.add(Factory.addSpace(5));
				
				// USER PRENOM //
				JPanel prenomPanel = Factory.addPanel();
				prenomPanel.setMaximumSize(new Dimension(300, 40));
				
				JLabel prenomHeader = Factory.addLabel("Prénom: ", 16, true);
				prenomPanel.add(prenomHeader);
				prenomPanel.add(Box.createRigidArea(new Dimension(20, 10)));
				JTextField prenomInput = Factory.addField(200, 30, true);
				prenomInput.setText(player.getPrenom());
				prenomPanel.add(prenomInput);
				panel.add(prenomPanel);
				panel.add(Factory.addSpace(5));
				
				// USER AGE //
				JPanel agePanel = Factory.addPanel();
				agePanel.setMaximumSize(new Dimension(300, 40));
				
				JLabel ageHeader = Factory.addLabel("Age: ", 16, true);
				agePanel.add(ageHeader);
				agePanel.add(Box.createRigidArea(new Dimension(50, 10)));
				JTextField ageInput = Factory.addField(200, 30, true);
				ageInput.setText(String.valueOf(player.getAge()));
				agePanel.add(ageInput);
				panel.add(agePanel);
				panel.add(Factory.addSpace(5));
				
				// USER MAIL //
				JPanel mailPanel = Factory.addPanel();
				mailPanel.setMaximumSize(new Dimension(300, 40));
				
				JLabel mailHeader = Factory.addLabel("Mail: ", 16, true);
				mailPanel.add(mailHeader);
				mailPanel.add(Box.createRigidArea(new Dimension(50, 10)));
				JTextField mailInput = Factory.addField(200, 30, true);
				mailInput.setText(String.valueOf(player.getMail()));
				mailPanel.add(mailInput);
				panel.add(mailPanel);
				panel.add(Factory.addSpace(5));
				
				// USER USERNAME //
				JPanel usernamePanel = Factory.addPanel();
				usernamePanel.setMaximumSize(new Dimension(300, 40));
				
				JLabel usernameHeader = Factory.addLabel("Username: ", 16, true);
				usernamePanel.add(usernameHeader);
				usernamePanel.add(Box.createRigidArea(new Dimension(2, 10)));
				JTextField usernameInput = Factory.addField(200, 30, true);
				usernameInput.setText(String.valueOf(player.getUsername()));
				usernamePanel.add(usernameInput);
				panel.add(usernamePanel);
				panel.add(Factory.addSpace(5));
				
				// USER SCORE //
				JPanel scorePanel = Factory.addPanel();
				scorePanel.setMaximumSize(new Dimension(300, 40));
				
				JLabel scoreHeader = Factory.addLabel("Score: ", 16, true);
				scorePanel.add(scoreHeader);
				scorePanel.add(Box.createRigidArea(new Dimension(35, 10)));
				JTextField scoreInput = Factory.addField(200, 30, true);
				scoreInput.setText(String.valueOf(player.getScore()));
				scorePanel.add(scoreInput);
				panel.add(scorePanel);
				panel.add(Factory.addSpace(5));
				
				// USER VIE //
				JPanel viePanel = Factory.addPanel();
				viePanel.setMaximumSize(new Dimension(300, 40));
				
				JLabel vieHeader = Factory.addLabel("Vie: ", 16, true);
				viePanel.add(vieHeader);
				viePanel.add(Box.createRigidArea(new Dimension(56, 10)));
				JTextField vieInput = Factory.addField(200, 30, true);
				vieInput.setText(String.valueOf(player.getVie()));
				viePanel.add(vieInput);
				panel.add(viePanel);
				panel.add(Factory.addSpace(10));
				
				// ADMINISTRATEUR //
				JPanel adminPanel = Factory.addPanel();
				adminPanel.setMaximumSize(new Dimension(300, 40));
				
				JLabel adminLabel = Factory.addLabel("Administrateur: ", 16, true);
				adminPanel.add(adminLabel);
				JCheckBox checkBox = Factory.addCheck();
				if(player.isAdmin()) {
					checkBox.setSelected(true);
				}
				adminPanel.add(checkBox);
				
				panel.add(adminPanel);
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
				JButton deleteButton = Factory.addButton("Supprimer", 130, 40);
				deleteButton.setForeground(Color.red);
				
				/**
				 * Permet la modification d'un objet Player
				 */
				validButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						nbPress = 0;
						
						if(player.isAdmin() && selected.getID() != 1) {
							messageLabel.setText("Vous ne pouvez pas modifier le compte d'un administrateur");
							return;
						}
						
						// On récupère les données entrées
						String nom = nomInput.getText();
						String prenom = prenomInput.getText();
						int age = 0;
						try {
							age = Integer.parseInt(ageInput.getText());
						} catch (NumberFormatException i) {
							messageLabel.setText("Erreur: Age invalide");
						}
						String mail = mailInput.getText();
						String username = usernameInput.getText();
						int score = 0;
						try{
							score = Integer.parseInt(scoreInput.getText());
						} catch (NumberFormatException f) {
							messageLabel.setText("Erreur: Score invalide");
							return;
						}
						
						int vie = 0;
						try {
							vie = Integer.parseInt(vieInput.getText());
						} catch (NumberFormatException g) {
							messageLabel.setText("Erreur: Vie invalide");
							return;
						}
						
						// On vérifie ces données
						if(nom.isEmpty()) {
							messageLabel.setText("Erreur: Nom invalide");
							return;
						} else if(prenom.isEmpty()) {
							messageLabel.setText("Erreur: Prénom invalide");
							return;
						} else if(age < 0) {
							messageLabel.setText("Erreur: Age invalide");
							return;
						} else if(mail.isEmpty()) {
							messageLabel.setText("Erreur: Mail invalide");
							return;
						} else if(username.isEmpty()) {
							messageLabel.setText("Erreur: Username invalide");
							return;
						}
						
						buttonsPanel.remove(validButton);
						buttonsPanel.remove(deleteButton);
						
						// On modifie les attributs de l'objet Player par les données entrées
						player.setNom(nom);
						player.setPrenom(prenom);
						player.setAge(age);
						player.setMail(mail);
						player.setUsername(username);
						player.setScore(score);
						player.setVie(vie);
						if(checkBox.isSelected()) {
							player.setAdmin(true);
						} else {
							player.setAdmin(false);
						}
						messageLabel.setText("Modifications sauvegardées");
						myGui.saveAll(); // On sauvegarde
						ActionListener panel = new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent arg0) {
								new AdminUsersPanel(myGui, frame).repaint(1);
							}
						};
						Timer timer = new Timer(2000, panel);
						timer.start();
						timer.setRepeats(false);
					}
				});
				
				// BOUTON : SUPPRIMER
				/**
				 * Permet la suppression d'un objet Player
				 */
				deleteButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						nbPress++;
						if((player.isAdmin() && selected.getID() != 1) || selected.equals(player)) {
							nbPress = 0;
							messageLabel.setText("Vous ne pouvez pas supprimer un administrateur");
							return;
						}
						if(nbPress == 1) {
							messageLabel.setText("Confirmez la suppression de l'utilisateur?");
						} else if(nbPress >= 2) {
							nbPress = 0;
							buttonsPanel.remove(validButton);
							buttonsPanel.remove(deleteButton);
							@SuppressWarnings("unchecked")
							ArrayList<Defi> defis = (ArrayList<Defi>) myGui.getListeDefis().clone();
							for(Defi d : myGui.getListeDefis()) {
								if(d.getDestinataire() == player) {
									defis.remove(d);
								}
							}
							myGui.setListeDefis(defis);
							myGui.delJoueur(player);
							messageLabel.setText("Utilisateur supprimé");
							myGui.saveAll();
							ActionListener panel = new ActionListener() {
								@Override
								public void actionPerformed(ActionEvent arg0) {
									new AdminUsersPanel(myGui, frame).repaint(1);
								}
							};
							Timer timer = new Timer(2000, panel);
							timer.start();
							timer.setRepeats(false);
						}
					}
				});
				
				buttonsPanel.add(validButton);
				buttonsPanel.add(Box.createRigidArea(new Dimension(20, 20)));
				buttonsPanel.add(deleteButton);
				
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
						new AdminUsersPanel(myGui, frame).repaint(1);
					}
				});
				retourPanel.add(back);
				retourPanel.add(Box.createHorizontalGlue());
				panel.add(retourPanel);
				
				panel.repaint();
			}
		}
	}
}
