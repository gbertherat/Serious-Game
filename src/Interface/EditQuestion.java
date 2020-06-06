package Interface;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
import v1.Defi;
import v1.Player;
import v1.Question;

public class EditQuestion {
	private GUI myGui;
	private JFrame frame;
	private Player selected;
	private static int nbPress = 0;
	
	public EditQuestion(GUI myGui, JFrame frame) {
		this.myGui = myGui;
		this.frame = frame;
	}
	
	public void repaint(int id) {
		if(GUI.idSession != 0) {
			selected = myGui.getPlayer(GUI.idSession);
			if(selected.isAdmin()) {
				Container panel = frame.getContentPane();
				panel.removeAll();
				panel.revalidate();
				panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
				panel.add(Box.createRigidArea(new Dimension(1024,20)));
				
				Question question = myGui.getQuestion(id);
			
				// TITRE //
				JPanel titrePanel = Factory.addPanel();
				
				JLabel titre = Factory.addLabel("Modifier une question", 21, true);
				titrePanel.add(titre);
				panel.add(titrePanel);
				
				panel.add(Box.createRigidArea(new Dimension(500, 20)));	
				
				// QUESTION ID //
				JPanel idPanel = Factory.addPanel();
				idPanel.setMaximumSize(new Dimension(500, 40));
				JLabel idHeader = Factory.addLabel("ID: ", 16, true);
				idPanel.add(idHeader);
				JLabel idLabel = Factory.addLabel(String.valueOf(question.getID()), 16, false);
				idPanel.add(idLabel);
				panel.add(idPanel);
				
				panel.add(Factory.addSpace(5));
				
				// QUESTION TITRE //
				JPanel titlePanel = Factory.addPanel();
				titlePanel.setMaximumSize(new Dimension(500, 40));
				JLabel titleHeader = Factory.addLabel("Titre: ", 16, true);
				titlePanel.add(titleHeader);
				titlePanel.add(Box.createRigidArea(new Dimension(53, 10)));
				JTextField titleField = Factory.addField(200, 30, true);
				titleField.setText(question.getTitre());
				titlePanel.add(titleField);
				panel.add(titlePanel);
				
				panel.add(Factory.addSpace(5));
				
				// QUESTION CATEGORIE //
				JPanel categoriePanel = Factory.addPanel();
				categoriePanel.setMaximumSize(new Dimension(500, 40));
				JLabel categorieHeader = Factory.addLabel("Catégorie: ", 16, true);
				categoriePanel.add(categorieHeader);
				categoriePanel.add(Box.createRigidArea(new Dimension(13, 10)));
				JComboBox<String> categorieBox = Factory.addBox(myGui.categories, 200, 30);
				categorieBox.setSelectedItem(question.getCategorie());
				categoriePanel.add(categorieBox);
				panel.add(categoriePanel);
				
				panel.add(Factory.addSpace(5));
				
				// QUESTION CONTENU //
				JPanel contentPanel = Factory.addPanel();
				contentPanel.setMaximumSize(new Dimension(500, 40));
				JLabel contentHeader = Factory.addLabel("Question: ", 16, true);
				contentPanel.add(contentHeader);
				contentPanel.add(Box.createRigidArea(new Dimension(19, 10)));
				JTextArea contentField = Factory.addTextArea(400, 150, true);
				contentField.setText(question.getContenu());
				JScrollPane contentScroll = Factory.addScroll(contentField, 400, 120);
				contentPanel.add(contentScroll);
				panel.add(contentPanel);
				
				panel.add(Factory.addSpace(5));
				
				// QUESTION REPONSE //
				String reponses = "";
				for(String r : question.getReponses()) {
					reponses += r + ";";
				}
				
				JPanel reponsePanel = Factory.addPanel();
				reponsePanel.setMaximumSize(new Dimension(500, 40));
				JLabel reponseHeader = Factory.addLabel("Réponse(s): ", 16, true);
				reponsePanel.add(reponseHeader);
				JTextArea reponseField = Factory.addTextArea(400, 150, true);
				reponseField.setText(reponses);
				JScrollPane reponseScroll = Factory.addScroll(reponseField, 400, 120);
				reponsePanel.add(reponseScroll);
				panel.add(reponsePanel);
				
				panel.add(Factory.addSpace(5));		
				
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
				
				validButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						nbPress = 0;
						String inputTitre = titleField.getText();
						String fieldCategorie = categorieBox.getSelectedItem().toString();
						String fieldQuestion = contentField.getText();
						String fieldReponse = reponseField.getText();
						
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
						buttonsPanel.remove(deleteButton);
						
						question.setTitre(inputTitre);
						question.setCategorie(fieldCategorie);
						question.setContenu(fieldQuestion);
						messageLabel.setText("Modifications enregistrées");
						
						question.setReponses(new ArrayList<String>());
						String[] allReponses = fieldReponse.split(";");
						for(String r : allReponses) {
							question.addReponse(r.toLowerCase());
						}
						myGui.saveAll();
						ActionListener panel = new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent arg0) {
								new QuestionsPanel(myGui, frame).repaint(1);
							}
						};
						Timer timer = new Timer(2000, panel);
						timer.start();
						timer.setRepeats(false);
					}
				});
				
				// BOUTON : SUPPRIMER
				deleteButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						nbPress++;
						if(nbPress == 1) {
							messageLabel.setText("Confirmez la suppression de la question?");
						} else if(nbPress >= 2) {
							nbPress = 0;
							buttonsPanel.remove(validButton);
							buttonsPanel.remove(deleteButton);
							
							@SuppressWarnings("unchecked")
							ArrayList<Defi> defis = (ArrayList<Defi>) myGui.getListeDefis().clone();
							for(Defi d : myGui.getListeDefis()) {
								if(d.getQuestion() == question) {
									defis.remove(d);
								}
							}
							myGui.setListeDefis(defis);
							myGui.delQuestion(question);
							messageLabel.setText("Question supprimée");
							myGui.saveAll();
							ActionListener panel = new ActionListener() {
								@Override
								public void actionPerformed(ActionEvent arg0) {
									new QuestionsPanel(myGui, frame).repaint(1);
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
						new QuestionsPanel(myGui, frame).repaint(1);
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
