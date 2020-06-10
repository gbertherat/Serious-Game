package Interface.User;

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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;

import Components.Factory;
import Interface.GUI;
import v1.Defi;
import v1.Player;
import v1.Question;

public class RepondreDefi {
	private GUI myGui;
	private JFrame frame;
	private int time;
	private static Timer temps = null;
	private static int nbPress = 0;
	
	public RepondreDefi(GUI myGui, JFrame frame) {
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
			
			Defi defiSel = myGui.getDefi(id);
			defiSel.setAccepte(true);
			Question question = defiSel.getQuestion();
			Player selected = myGui.getPlayer(GUI.idSession);
		
			// TITRE //
			JPanel titrePanel = Factory.addPanel();
			
			JLabel titre = Factory.addLabel("Défi accepté", 21, true);
			titrePanel.add(titre);
			panel.add(titrePanel);
			
			panel.add(Box.createRigidArea(new Dimension(500, 10)));
			
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
			JPanel doublePanel = Factory.addPanel();
			doublePanel.setMaximumSize(new Dimension(460, 30));
			doublePanel.add(Box.createRigidArea(new Dimension(10, 20)));
			
			JLabel categorieLabel = Factory.addLabel("Catégorie:", 14, true);
			categorieLabel.setMaximumSize(new Dimension(290, 30));
			doublePanel.add(categorieLabel);
			
			JLabel pointsLabel = Factory.addLabel("Points: " + String.valueOf(defiSel.getPoints()), 15, true);
			doublePanel.add(pointsLabel);
			panel.add(doublePanel);
			
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
			
			// REPONSE //
			JPanel reponsePanel = Factory.addPanel();
			reponsePanel.setMaximumSize(new Dimension(460, 30));
			reponsePanel.add(Box.createRigidArea(new Dimension( 10, 20)));
			
			JLabel reponseLabel = Factory.addLabel("Réponse:", 14, true);
			reponsePanel.add(reponseLabel);
			panel.add(reponsePanel);
			
			JTextArea reponseField = Factory.addTextArea(440, 80, true);
			JScrollPane reponseScroll = Factory.addScroll(reponseField, 440, 80);
			panel.add(reponseScroll);
			
			panel.add(Box.createRigidArea(new Dimension(500, 10)));
			
			// EXPEDITEUR & TEMPS //
			JPanel byPanel = Factory.addPanel();
			byPanel.setMaximumSize(new Dimension(460, 30));
			byPanel.add(Box.createRigidArea(new Dimension(10, 20)));
			
			JLabel byLabel = Factory.addLabel("Expéditeur:", 14, true);
			byLabel.setMaximumSize(new Dimension(230, 30));
			byPanel.add(byLabel);
			panel.add(byPanel);
			
			JLabel tempsHeader = Factory.addLabel("Temps:", 15, true);
			tempsHeader.setMaximumSize(new Dimension(230, 30));
			byPanel.add(tempsHeader);
			
			JPanel boxesPanel = Factory.addPanel();
			boxesPanel.setMaximumSize(new Dimension(460, 30));
			boxesPanel.add(Box.createRigidArea(new Dimension(10, 20)));
			
			JLabel expediteurLabel = Factory.addLabel(defiSel.getExpediteur().getUsername(), 15, false);
			expediteurLabel.setMaximumSize(new Dimension(230, 30));
			boxesPanel.add(expediteurLabel);
			
			JLabel tempsLabel = Factory.addLabel(String.valueOf(60-time), 15, true);
			tempsLabel.setMaximumSize(new Dimension(230, 30));
			tempsLabel.setForeground(Color.red);
			boxesPanel.add(tempsLabel);
			
			panel.add(boxesPanel);
			
			panel.add(Box.createRigidArea(new Dimension(500, 10)));
			
			// BOUTONS : VALIDER & SUPPRIMER //
			JPanel buttonsPanel = Factory.addPanel();
			buttonsPanel.setMaximumSize(new Dimension(460, 50));
			buttonsPanel.add(Box.createRigidArea(new Dimension(10, 10)));
			
			JLabel messageLabel = Factory.addLabel("", 12, true);
			messageLabel.setForeground(Color.red);	
			
			JButton validButton = Factory.addButton("Valider!", 90, 30);
			JButton delButton = Factory.addButton("Abandonner", 110, 30);
			delButton.setForeground(Color.red);
			
			ActionListener TempsDefi = new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					if(time < 59) {
						time++;
						tempsLabel.setText(String.valueOf(60-time));
					} else {
						temps.stop();
						tempsLabel.setText("0");
						buttonsPanel.remove(validButton);
						buttonsPanel.remove(delButton);
						selected.setVie(selected.getVie()-defiSel.getPoints());
						selected.setScore(selected.getScore()-defiSel.getPoints()*10);
						defiSel.setTermine(true);
						messageLabel.setText("Temps dépassé! Vous avez perdu");
						myGui.saveAll();
						ActionListener panel = new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent arg0) {
								new Menu(myGui, frame).repaint();
							}
						};
						Timer timer = new Timer(2000, panel);
						timer.start();
						timer.setRepeats(false);
					}
				}
			};
			time = 0;
			temps = new Timer(1000, TempsDefi);
			temps.start();
			
			validButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					nbPress = 0;
					String fieldReponse =  reponseField.getText().toLowerCase();
					
					ActionListener panel = new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent arg0) {
							new Menu(myGui, frame).repaint();
						}
					};
					
					if(!fieldReponse.isEmpty()) {
						temps.stop();
						buttonsPanel.remove(validButton);
						buttonsPanel.remove(delButton);
						defiSel.setTermine(true);
						Timer timer = new Timer(2000, panel);
						timer.start();
						timer.setRepeats(false);
						if(question.getReponses().contains(fieldReponse)) {
							messageLabel.setText("Bonne réponse!");
							
							defiSel.getExpediteur().setVie(defiSel.getExpediteur().getVie()-defiSel.getPoints());
							selected.setVie(selected.getVie()+defiSel.getPoints());
							
							selected.setScore(selected.getScore()+defiSel.getPoints()*10);
							selected.setDefisReussis(selected.getDefisReussis()+1);
						} else {
							messageLabel.setText("Mauvaise réponse");
							defiSel.getExpediteur().setVie(defiSel.getExpediteur().getVie()+(10-defiSel.getPoints()));
							selected.setVie(selected.getVie()-(10-defiSel.getPoints()));
							
							selected.setScore(selected.getScore()-defiSel.getPoints()*10);
						}
						myGui.saveAll();
					}
				}
			});
			
			delButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					nbPress++;
					if(nbPress == 1) {
						messageLabel.setText("Confirmez l'abandon du défi?");
					} else if(nbPress >= 2) {
						temps.stop();
						buttonsPanel.remove(validButton);
						buttonsPanel.remove(delButton);
						nbPress = 0;
						
						defiSel.getExpediteur().setVie(defiSel.getExpediteur().getVie()+(10-defiSel.getPoints()));
						selected.setVie(selected.getVie()-(10-defiSel.getPoints()));
						
						selected.setScore(selected.getScore()-defiSel.getPoints()*10);
						defiSel.setTermine(true);
						messageLabel.setText("Vous avez abandonné.");
						myGui.saveAll();
						ActionListener panel = new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent arg0) {
								new Menu(myGui, frame).repaint();
							}
						};
						Timer timer = new Timer(2000, panel);
						timer.start();
						timer.setRepeats(false);
					}
				}
			});
			buttonsPanel.add(validButton);
			buttonsPanel.add(Box.createRigidArea(new Dimension(10, 10)));
			buttonsPanel.add(delButton);
			buttonsPanel.add(Box.createRigidArea(new Dimension(5, 10)));
			buttonsPanel.add(messageLabel);
			panel.add(buttonsPanel);
			
			panel.repaint();
		}
	}
}
