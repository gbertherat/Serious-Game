package Interface;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Components.Factory;
import v1.Defi;
import v1.Player;
import v1.Question;

public class Verify {
	private GUI myGui;
	private JFrame frame;
	private static int nbPress = 0;
	
	public Verify(GUI myGui, JFrame frame) {
		this.myGui = myGui;
		this.frame = frame;
	}
	
	public void repaint(int id) {
		if(GUI.idSession != 0) {
			Player selected = myGui.getPlayer(GUI.idSession);
			if(selected.getClass().getSimpleName().equals("Admin")) {
				Container panel = frame.getContentPane();
				panel.removeAll();
				panel.revalidate();
				panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
				panel.add(Box.createRigidArea(new Dimension(1024,20)));
				
				Defi defiSel = myGui.getDefi(id);
				Question question = defiSel.getQuestion();
			
				// TITRE //
				JPanel titrePanel = Factory.addPanel();
				
				JLabel titre = Factory.addLabel("Vérification des questions", 21, true);
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
				
				JTextField fieldTitre = Factory.addField(120, 30, true);
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
				
				JLabel pointsLabel = Factory.addLabel("Points: 3", 15, true);
				doublePanel.add(pointsLabel);
				panel.add(doublePanel);
				
				JPanel boxPanel = Factory.addPanel();
				boxPanel.setMaximumSize(new Dimension(460, 30));
				boxPanel.add(Box.createRigidArea(new Dimension(10, 10)));
				
				JComboBox<String> categorieBox = Factory.addBox(myGui.categories, 200, 30);
				categorieBox.setSelectedItem(question.getCategorie());
				boxPanel.add(categorieBox);
				
				boxPanel.add(Box.createRigidArea(new Dimension(102, 20)));
				
				JSpinner pointsInput = Factory.addSpiner(40, 30, 1, 10, 3);
				pointsInput.addChangeListener(new ChangeListener() {
					@Override
					public void stateChanged(ChangeEvent arg0) {
						pointsLabel.setText("Points: " + String.valueOf(pointsInput.getValue()));
					}
				});
				boxPanel.add(pointsInput);
				panel.add(boxPanel);
				
				panel.add(Box.createRigidArea(new Dimension(500, 10)));
				
				// CONTENU //
				JPanel contenuPanel = Factory.addPanel();
				contenuPanel.setMaximumSize(new Dimension(460, 30));
				contenuPanel.add(Box.createRigidArea(new Dimension(10, 10)));
				
				JLabel contenuLabel = Factory.addLabel("Contenu:", 14, true);
				contenuPanel.add(contenuLabel);
				panel.add(contenuPanel);
				
				JTextArea contenuField = Factory.addTextArea(440, 80, true);
				JScrollPane scrollPanel = Factory.addScroll(contenuField, 440, 80);
				panel.add(scrollPanel);
				
				panel.add(Box.createRigidArea(new Dimension(500, 10)));
				
				// REPONSE //
				JPanel reponsePanel = Factory.addPanel();
				reponsePanel.setMaximumSize(new Dimension(460, 30));
				reponsePanel.add(Box.createRigidArea(new Dimension( 10, 20)));
				
				JLabel reponseLabel = Factory.addLabel("Réponse(s): (Séparez les réponses avec un ';')", 14, true);
				reponsePanel.add(reponseLabel);
				panel.add(reponsePanel);
				
				String reponses = "";
				for(String r : question.getReponses()) {
					reponses += r + ";";
				}
				
				JTextArea reponseField = Factory.addTextArea(440, 80, true);
				reponseField.setText(reponses);
				JScrollPane reponseScroll = Factory.addScroll(reponseField, 440, 80);
				panel.add(reponseScroll);
				
				panel.add(Box.createRigidArea(new Dimension(500, 10)));
				
				// EXPEDITEUR & DESTINATAIRE //
				JPanel byToPanel = Factory.addPanel();
				byToPanel.setMaximumSize(new Dimension(460, 30));
				byToPanel.add(Box.createRigidArea(new Dimension(10, 20)));
				
				JLabel byLabel = Factory.addLabel("Expéditeur:", 14, true);
				byLabel.setMaximumSize(new Dimension(230, 30));
				byToPanel.add(byLabel);
				
				JLabel toLabel = Factory.addLabel("Destinataire:", 14, true);
				toLabel.setMaximumSize(new Dimension(230, 30));
				byToPanel.add(toLabel);
				panel.add(byToPanel);
				
				JPanel boxesPanel = Factory.addPanel();
				boxesPanel.setMaximumSize(new Dimension(460, 30));
				boxesPanel.add(Box.createRigidArea(new Dimension(10, 20)));
				
				String[] joueurs = new String[myGui.getListeJoueurs().size()];
				for(int i = 0; i < myGui.getListeJoueurs().size(); i++) {
					joueurs[i] = myGui.getListeJoueurs().get(i).getUsername();
				}
				
				JComboBox<String> expediteurBox = Factory.addBox(joueurs, 200, 30);
				expediteurBox.setSelectedIndex(myGui.getListeJoueurs().indexOf(defiSel.getExpediteur()));
				boxesPanel.add(expediteurBox);
				
				boxesPanel.add(Box.createRigidArea(new Dimension(25, 30)));
				
				JComboBox<String> destinataireBox = Factory.addBox(joueurs, 200, 30);
				destinataireBox.setSelectedIndex(myGui.getListeJoueurs().indexOf(defiSel.getDestinataire()));
				boxesPanel.add(destinataireBox);
				
				panel.add(boxesPanel);
				
				panel.add(Box.createRigidArea(new Dimension(500, 10)));
				
				// BOUTONS : VALIDER & SUPPRIMER //
				JPanel buttonsPanel = Factory.addPanel();
				buttonsPanel.setMaximumSize(new Dimension(460, 50));
				buttonsPanel.add(Box.createRigidArea(new Dimension(10, 10)));
				
				JLabel messageLabel = Factory.addLabel("", 12, true);
				messageLabel.setForeground(Color.red);
				
				JButton validButton = Factory.addButton("Valider!", 90, 30);
				JButton delButton = Factory.addButton("Supprimer", 100, 30);
				
				validButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						nbPress = 0;
						String inputTitre = fieldTitre.getText();
						String fieldCategorie = categorieBox.getSelectedItem().toString();
						String fieldQuestion = contenuField.getText();
						String fieldReponse =  reponseField.getText();
						String fieldExpediteur = expediteurBox.getSelectedItem().toString();
						String fieldDestinataire = destinataireBox.getSelectedItem().toString();
						int fieldPoint = (int) pointsInput.getValue();
						
						if(inputTitre.length() < 3) {
							messageLabel.setText("Erreur : Titre invalide (< 3 caractères)");
							return;
						} else if(inputTitre.length() > 20) {
							messageLabel.setText("Erreur : Titre invalide (> 20 caractères");
							return;
						} else if(fieldQuestion.length() < 20) {
							messageLabel.setText("Erreur : Question invalide (< 20 caractères)");
							return;
						} else if(fieldReponse.length() < 1) {
							messageLabel.setText("Erreur : Réponse invalide (< 1 caractères)");
							return;
						}
						
						buttonsPanel.remove(validButton);
						buttonsPanel.remove(delButton);
						messageLabel.setText("Question validée");
						
						question.setTitre(inputTitre);
						question.setCategorie(fieldCategorie);
						question.setContenu(fieldQuestion);
						for(Player p : myGui.getListeJoueurs()) {
							if(p.getUsername().equals(fieldExpediteur)) {
								defiSel.setExpediteur(p);
								break;
							}
						}
						for(Player p : myGui.getListeJoueurs()) {
							if(p.getUsername().equals(fieldDestinataire)) {
								defiSel.setDestinataire(p);
								break;
							}
						}
						defiSel.setPoints(fieldPoint);
						defiSel.setDateExpiration(LocalDateTime.now().plus(2, ChronoUnit.DAYS));
						
						String[] allReponses = fieldReponse.split(";");
						for(String r : allReponses) {
							question.addReponse(r);
						}
						myGui.addQuestion(question);
						defiSel.setReviewed(true);
						System.out.println(myGui.getListeDefis());
						ActionListener panel = new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent arg0) {
								new VerifyPanel(myGui, frame).repaint(1);
							}
						};
						Timer timer = new Timer(2000, panel);
						timer.start();
						timer.setRepeats(false);
					}
				});
				
				delButton.setForeground(Color.red);
				delButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						nbPress++;
						if(nbPress == 1) {
							messageLabel.setText("Confirmez la suppression de la question?");
						} else if(nbPress >= 2) {
							buttonsPanel.remove(validButton);
							buttonsPanel.remove(delButton);
							nbPress = 0;
							myGui.delDefi(defiSel);
							messageLabel.setText("Question supprimée");
							
							ActionListener panel = new ActionListener() {
								@Override
								public void actionPerformed(ActionEvent arg0) {
									new VerifyPanel(myGui, frame).repaint(1);
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

				panel.add(Box.createRigidArea(new Dimension(500, 10)));
				
				// BOUTON : RETOUR //
				panel.add(Box.createVerticalGlue());
				JPanel retourPanel = Factory.addPanel();
				JButton back = Factory.addButton("Retour", 100, 40);
				back.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						panel.removeAll();
						panel.revalidate();
						panel.repaint();
						new VerifyPanel(myGui, frame).repaint(1);
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
