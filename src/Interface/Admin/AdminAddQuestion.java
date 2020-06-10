package Interface.Admin;

import java.awt.Color;
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
import v1.Player;
import v1.Question;

public class AdminAddQuestion {
	private GUI myGui;
	private JFrame frame;
	
	public AdminAddQuestion(GUI myGui, JFrame frame) {
		this.myGui = myGui;
		this.frame = frame;
	}
	
	public void repaint() {
		if(GUI.idSession != 0) {
			Player selected = myGui.getPlayer(GUI.idSession);
			if(selected.isAdmin()) {
				Container panel = frame.getContentPane();
				panel.removeAll();
				panel.revalidate();
				panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
				panel.add(Box.createRigidArea(new Dimension(1024,20)));
			
				// TITRE //
				JPanel titrePanel = Factory.addPanel();
				JLabel titre = Factory.addLabel("Ajouter une question", 21, true);
				titrePanel.add(titre);
				panel.add(titrePanel);
				
				panel.add(Box.createRigidArea(new Dimension(500, 20)));	
				
				// TITRE QUESTION //
				JPanel titlePanel = Factory.addPanel();
				titlePanel.setMaximumSize(new Dimension(400, 30));
				JLabel titleHeader = Factory.addLabel("Titre:", 16, true);
				titlePanel.add(titleHeader);
				panel.add(titlePanel);
				
				JPanel titleFieldPanel = Factory.addPanel();
				titleFieldPanel.setMaximumSize(new Dimension(400, 30));
				JTextField titleField = Factory.addField(200, 30, true);
				titleFieldPanel.add(titleField);
				panel.add(titleFieldPanel);
				
				panel.add(Factory.addSpace(5));
				
				// CATEGORIE QUESTION //
				JPanel categoriePanel = Factory.addPanel();
				categoriePanel.setMaximumSize(new Dimension(400, 30));
				JLabel categorieHeader = Factory.addLabel("Catégorie:", 16, true);
				categoriePanel.add(categorieHeader);
				panel.add(categoriePanel);
				
				JPanel categorieBoxPanel = Factory.addPanel();
				categorieBoxPanel.setMaximumSize(new Dimension(400, 30));
				JComboBox<String> categorieBox = Factory.addBox(myGui.categories, 200, 30);
				categorieBoxPanel.add(categorieBox);
				panel.add(categorieBoxPanel);
				
				panel.add(Factory.addSpace(5));
				
				// CONTENU QUESTION //
				JPanel contenuPanel = Factory.addPanel();
				contenuPanel.setMaximumSize(new Dimension(400, 30));
				JLabel contenuHeader = Factory.addLabel("Question:", 16, true);
				contenuPanel.add(contenuHeader);
				panel.add(contenuPanel);
				
				JPanel contenuFieldPanel = Factory.addPanel();
				contenuFieldPanel.setMaximumSize(new Dimension(400, 80));
				JTextArea contenuField = Factory.addTextArea(400, 80, true);
				JScrollPane contenuScroll = Factory.addScroll(contenuField, 400, 80);
				contenuFieldPanel.add(contenuScroll);
				panel.add(contenuFieldPanel);
				
				panel.add(Factory.addSpace(5));
				
				// CONTENU REPONSE //
				JPanel reponsePanel = Factory.addPanel();
				reponsePanel.setMaximumSize(new Dimension(400, 30));
				JLabel reponseHeader = Factory.addLabel("Réponse(s) (Séparez les réponses avec un ';'):", 16, true);
				reponsePanel.add(reponseHeader);
				panel.add(reponsePanel);
				
				JPanel reponseFieldPanel = Factory.addPanel();
				reponseFieldPanel.setMaximumSize(new Dimension(400, 80));
				JTextArea reponseField = Factory.addTextArea(400, 80, true);
				JScrollPane reponseScroll = Factory.addScroll(reponseField, 400, 80);
				reponseFieldPanel.add(reponseScroll);
				panel.add(reponseFieldPanel);
				
				panel.add(Factory.addSpace(10));
				
				// MESSAGE //
				JPanel messagePanel = Factory.addPanel();
				JLabel messageLabel = Factory.addLabel("", 16, true);
				messageLabel.setForeground(Color.RED);
				messagePanel.add(messageLabel);
				panel.add(messagePanel);
				
				panel.add(Factory.addSpace(10));
				
				// BOUTON : VALIDER //
				JPanel validPanel = Factory.addPanel();
				JButton validButton = Factory.addButton("Valider", 150, 40);
				validButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						String titre = titleField.getText();
						String categorie = categorieBox.getSelectedItem().toString();
						String contenu = contenuField.getText();
						
						if(titre.isEmpty()) {
							messageLabel.setText("Erreur: Titre invalide");
							return;
						} else if(contenu.isEmpty()){
							messageLabel.setText("Erreur: Question invalide");
							return;
						}
						String[] reponses = reponseField.getText().split(";");
						if(reponses.length < 1 || reponseField.getText().isEmpty()) {
							messageLabel.setText("Erreur: Réponse(s) invalide");
							return;
						}
						
						panel.remove(validPanel);
						
						Question newQuestion = new Question(titre, contenu, categorie);
						for(String s : reponses) {
							newQuestion.addReponse(s.toLowerCase());
						}
						myGui.addQuestion(newQuestion);
						messageLabel.setText("Question ajoutée");
						myGui.saveAll();
						ActionListener panel = new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent arg0) {
								new AdminQuestionPanel(myGui, frame).repaint(1);
							}
						};
						Timer timer = new Timer(2000, panel);
						timer.start();
						timer.setRepeats(false);
					}
				});
				validPanel.add(validButton);
				panel.add(validPanel);
				
				// BOUTON : RETOUR //
				panel.add(Box.createVerticalGlue());
				JPanel retourPanel = Factory.addPanel();
				JButton back = Factory.addButton("Retour", 100, 40);
				back.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						panel.removeAll();
						panel.revalidate();
						panel.repaint();
						new AdminQuestionPanel(myGui, frame).repaint(1);
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
