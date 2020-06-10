package Interface.User;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;

import Components.Factory;
import Interface.GUI;
import v1.Defi;
import v1.Mail;
import v1.Player;
import v1.Question;

public class SendQuestion {
	private GUI myGui;
	private JFrame frame;
	private static int nbPress = 0;
	private Player destinataire = null;
	
	public SendQuestion(GUI myGui, JFrame frame) {
		this.myGui = myGui;
		this.frame = frame;
	}
	
	public void repaint(int id) {
		if(GUI.idSession != 0) {
			Container panel = frame.getContentPane();
			panel.removeAll();
			panel.revalidate();
			panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
			panel.add(Box.createRigidArea(new Dimension(1024,20)));
		
			Player selected = myGui.getPlayer(GUI.idSession);
			Question question = myGui.getQuestion(id);
			
			// TITRE //
			JPanel titrePanel = Factory.addPanel();
			
			JLabel titre = Factory.addLabel("Envoyer une question", 21, true);
			titrePanel.add(titre);
			panel.add(titrePanel);
			
			panel.add(Box.createRigidArea(new Dimension(500, 20)));
			
			// TITRE QUESTION //
			JPanel titreQuestionPanel = Factory.addPanel();
			titreQuestionPanel.setMaximumSize(new Dimension(460, 20));
			titreQuestionPanel.add(Box.createRigidArea(new Dimension(10, 20)));
			
			JLabel titreQuestion = Factory.addLabel("Titre: ", 14, true);
			titreQuestionPanel.add(titreQuestion);
			panel.add(titreQuestionPanel);
			panel.add(Box.createRigidArea(new Dimension(500,5)));
			
			JPanel fieldTitrePanel = Factory.addPanel();
			fieldTitrePanel.setMaximumSize(new Dimension(460, 30));
			fieldTitrePanel.add(Box.createRigidArea(new Dimension(10, 20)));
			
			JTextField fieldTitre = Factory.addField(120, 30, false);
			fieldTitre.setText(question.getTitre());
			fieldTitrePanel.add(fieldTitre);
			panel.add(fieldTitrePanel);
			
			panel.add(Box.createRigidArea(new Dimension(500, 10)));
			
			// CATEGORIE //
			JPanel categoriePanel = Factory.addPanel();
			categoriePanel.setMaximumSize(new Dimension(460, 30));
			categoriePanel.add(Box.createRigidArea(new Dimension(10, 20)));
			
			JLabel categorieLabel = Factory.addLabel("Catégorie:", 14, true);
			categorieLabel.setMaximumSize(new Dimension(290, 30));
			categoriePanel.add(categorieLabel);
			panel.add(categoriePanel);
			
			JPanel boxPanel = Factory.addPanel();
			boxPanel.setMaximumSize(new Dimension(460, 30));
			boxPanel.add(Box.createRigidArea(new Dimension(10, 10)));
			
			JLabel categorie = Factory.addLabel(question.getCategorie(), 16, false);
			boxPanel.add(categorie);
		
			panel.add(boxPanel);
			
			panel.add(Box.createRigidArea(new Dimension(500, 10)));
			
			// CONTENU //
			JPanel contenuPanel = Factory.addPanel();
			contenuPanel.setMaximumSize(new Dimension(460, 30));
			contenuPanel.add(Box.createRigidArea(new Dimension(10, 10)));
			
			JLabel contenuLabel = Factory.addLabel("Question:", 14, true);
			contenuPanel.add(contenuLabel);
			panel.add(contenuPanel);
			
			JTextArea contenuField = Factory.addTextArea(440, 80, false);
			contenuField.setText(question.getContenu());
			JScrollPane scrollPanel = Factory.addScroll(contenuField, 440, 80);
			panel.add(scrollPanel);
			
			panel.add(Box.createRigidArea(new Dimension(500, 10)));
			
			// DESTINATAIRE //
			JPanel toPanel = Factory.addPanel();
			toPanel.setMaximumSize(new Dimension(460, 30));
			toPanel.add(Box.createRigidArea(new Dimension(10, 20)));
			
			JLabel toLabel = Factory.addLabel("Destinataire: ", 14, true);
			toPanel.add(toLabel);
			panel.add(toPanel);
			
			String[] joueurs = new String[myGui.getListeJoueurs().size()-1];
			int i = 0;
			for(Player p : myGui.getListeJoueurs()) {
				if(p != selected) {
					joueurs[i] = p.getUsername();
					i++;
				}
			}
			
			JComboBox<String> destinataireBox = Factory.addBox(joueurs, 200, 30);
			toPanel.add(destinataireBox);
			panel.add(toPanel);
			
			panel.add(Box.createRigidArea(new Dimension(500, 10)));
			
			// MESSAGE //
			JPanel messagePanel = Factory.addPanel();
			JLabel messageLabel = Factory.addLabel("", 16, true);
			messagePanel.add(messageLabel);
			panel.add(messagePanel);
			
			panel.add(Factory.addSpace(10));
			
			// BOUTON : ENVOYER //
			JPanel sendPanel = Factory.addPanel();
			JButton sendButton = Factory.addButton("Envoyer!", 150, 40);
			sendButton.addActionListener(new ActionListener() {	
				@Override
				public void actionPerformed(ActionEvent e) {
					nbPress++;
					if(nbPress == 1) {
						messageLabel.setText("Confirmer l'envoi de la question?");
					} else {
						nbPress = 0;
						sendPanel.remove(sendButton);
						messageLabel.setText("Question envoyée! Veuillez patienter");
						
						for(Player p : myGui.getListeJoueurs()) {
							if(p.getUsername().equals(destinataireBox.getSelectedItem().toString())){
								destinataire = p;
								break;
							}
						}
						
						int points = 5;
						if(selected.getVie() > destinataire.getVie()+10) {
							points = 7;
						} else if(selected.getVie()+10 < destinataire.getVie()) {
							points = 3;
						}
						Defi newDefi = new Defi(question, selected, destinataire, points);
						newDefi.setReviewed(true);
						myGui.addDefi(newDefi);
						myGui.saveAll();
						
						ActionListener panel = new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent arg0) {
								Mail.sendMail(destinataire.getMail(), 
										"Vous avez reçu un défi!", 
										"Le joueur " + selected.getUsername() + " viens de vous envoyer un défi! Venez vite y répondre!\n"
												+ "Serious-Game by Bertherat Guillaume");
								messageLabel.setText("Question envoyée!");
								new Menu(myGui, frame).repaint();
							}
						};
						Timer timer = new Timer(2000, panel);
						timer.start();
						timer.setRepeats(false);
					}
				}
			});
			sendPanel.add(sendButton);
			panel.add(sendPanel);
			
			// BOUTON : RETOUR //
			panel.add(Box.createVerticalGlue());
			JPanel retourPanel = Factory.addPanel();
			JButton back = Factory.addButton("Retour", 100, 40);
			back.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					panel.removeAll();
					panel.revalidate();
					panel.repaint();
					new QuestionPanel(myGui, frame).repaint(1);
				}
			});
			retourPanel.add(back);
			retourPanel.add(Box.createHorizontalGlue());
			panel.add(retourPanel);
			
			panel.repaint();
		}
	}
}
