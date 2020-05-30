package Interface;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
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
				panel.add(Box.createRigidArea(new Dimension(500,20)));
				panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
				
				Defi defiSel = myGui.getListeDefis().get(id);
				Question question = defiSel.getQuestion();
			
				// TITRE //
				JPanel titrePanel = new JPanel();
				titrePanel.setLayout(new BoxLayout(titrePanel, BoxLayout.LINE_AXIS));
				
				JLabel titre = new JLabel("Vérification des questions");
				titre.setFont(new Font("Arial", Font.BOLD, 21));
				titrePanel.add(titre);
				panel.add(titrePanel);
				
				panel.add(Box.createRigidArea(new Dimension(500, 10)));
				
				// TITRE QUESTION //
				JPanel titreQuestionPanel = new JPanel();
				titreQuestionPanel.setLayout(new BoxLayout(titreQuestionPanel, BoxLayout.LINE_AXIS));
				titreQuestionPanel.setMaximumSize(new Dimension(460, 20));
				titreQuestionPanel.add(Box.createRigidArea(new Dimension(10, 20)));
				
				JLabel titreQuestion = new JLabel("Titre: ");
				titreQuestion.setFont(new Font("Arial", Font.BOLD, 14));
				titreQuestionPanel.add(titreQuestion);
				panel.add(titreQuestionPanel);
				panel.add(Box.createRigidArea(new Dimension(500,5)));
				
				JPanel fieldTitrePanel = new JPanel();
				fieldTitrePanel.setLayout(new BoxLayout(fieldTitrePanel, BoxLayout.LINE_AXIS));
				fieldTitrePanel.setMaximumSize(new Dimension(460, 30));
				fieldTitrePanel.add(Box.createRigidArea(new Dimension(10, 20)));
				
				JTextField fieldTitre = new JTextField();
				fieldTitre.setMaximumSize(new Dimension(120, 30));
				fieldTitre.setText(question.getTitre());
				fieldTitrePanel.add(fieldTitre);
				panel.add(fieldTitrePanel);
				
				panel.add(Box.createRigidArea(new Dimension(500, 10)));
				
				// CATEGORIE //
				JPanel categoriePanel = new JPanel();
				categoriePanel.setLayout(new BoxLayout(categoriePanel, BoxLayout.LINE_AXIS));
				categoriePanel.setMaximumSize(new Dimension(460, 30));
				categoriePanel.add(Box.createRigidArea(new Dimension(10, 20)));
				
				JLabel categorieLabel = new JLabel("Catégorie:");
				categorieLabel.setFont(new Font("Arial", Font.BOLD, 14));
				categoriePanel.add(categorieLabel);
				panel.add(categoriePanel);
				
				JPanel boxPanel = new JPanel();
				boxPanel.setLayout(new BoxLayout(boxPanel, BoxLayout.LINE_AXIS));
				boxPanel.setMaximumSize(new Dimension(460, 30));
				boxPanel.add(Box.createRigidArea(new Dimension(10, 10)));
				
				JComboBox<String> categorieBox = new JComboBox<String>(myGui.categories);
				categorieBox.setSelectedItem(question.getCategorie());
				categorieBox.setMaximumSize(new Dimension(200,20));
				boxPanel.add(categorieBox);
				panel.add(boxPanel);
				
				panel.add(Box.createRigidArea(new Dimension(500, 10)));
				
				// CONTENU //
				JPanel contenuPanel = new JPanel();
				contenuPanel.setLayout(new BoxLayout(contenuPanel, BoxLayout.LINE_AXIS));
				contenuPanel.setMaximumSize(new Dimension(460, 30));
				contenuPanel.add(Box.createRigidArea(new Dimension(10, 10)));
				
				JLabel contenuLabel = new JLabel("Contenu:");
				contenuLabel.setFont(new Font("Arial", Font.BOLD, 14));
				contenuPanel.add(contenuLabel);
				panel.add(contenuPanel);
				
				JTextArea contenuField = new JTextArea(5, 30);
				contenuField.setText(question.getContenu());
				contenuField.setLineWrap(true);
				contenuField.setWrapStyleWord(true);
				JScrollPane scrollPanel = new JScrollPane(contenuField);
				scrollPanel.setMaximumSize(new Dimension(440,80));
				scrollPanel.setPreferredSize(new Dimension(440, 80));
				panel.add(scrollPanel);
				
				panel.add(Box.createRigidArea(new Dimension(500, 10)));
				
				// REPONSE //
				JPanel reponsePanel = new JPanel();
				reponsePanel.setLayout(new BoxLayout(reponsePanel, BoxLayout.LINE_AXIS));
				reponsePanel.setMaximumSize(new Dimension(460, 30));
				reponsePanel.add(Box.createRigidArea(new Dimension( 10, 20)));
				
				JLabel reponseLabel = new JLabel("Réponse(s): (Séparez les réponses avec un ';')");
				reponseLabel.setFont(new Font("Arial", Font.BOLD, 14));
				reponsePanel.add(reponseLabel);
				panel.add(reponsePanel);
				
				String reponses = "";
				for(String r : question.getReponses()) {
					reponses += r + ";";
				}
				
				JTextArea reponseField = new JTextArea(5, 30);
				reponseField.setText(reponses);
				reponseField.setLineWrap(true);
				reponseField.setWrapStyleWord(true);
				JScrollPane reponseScroll = new JScrollPane(reponseField);
				reponseScroll.setMaximumSize(new Dimension(440, 80));
				reponseScroll.setPreferredSize(new Dimension(440 ,80));
				panel.add(reponseScroll);
				
				panel.add(Box.createRigidArea(new Dimension(500, 10)));
				
				// EXPEDITEUR & DESTINATAIRE //
				JPanel byToPanel = new JPanel();
				byToPanel.setLayout(new BoxLayout(byToPanel, BoxLayout.LINE_AXIS));
				byToPanel.setMaximumSize(new Dimension(460, 30));
				byToPanel.add(Box.createRigidArea(new Dimension(10, 20)));
				
				JLabel byLabel = new JLabel("Expéditeur:");
				byLabel.setFont(new Font("Arial", Font.BOLD, 14));
				byLabel.setMaximumSize(new Dimension(230, 30));
				byToPanel.add(byLabel);
				
				JLabel toLabel = new JLabel("Destinataire:");
				toLabel.setFont(new Font("Arial", Font.BOLD, 14));
				toLabel.setMaximumSize(new Dimension(230, 30));
				byToPanel.add(toLabel);
				panel.add(byToPanel);
				
				JPanel boxesPanel = new JPanel();
				boxesPanel.setLayout(new BoxLayout(boxesPanel, BoxLayout.LINE_AXIS));
				boxesPanel.setMaximumSize(new Dimension(460, 30));
				boxesPanel.add(Box.createRigidArea(new Dimension(10, 20)));
				
				
				String[] joueurs = new String[myGui.getListeJoueurs().size()];
				for(int i = 0; i < myGui.getListeJoueurs().size(); i++) {
					joueurs[i] = myGui.getListeJoueurs().get(i).getNom() + " " + myGui.getListeJoueurs().get(i).getPrenom();
				}
				
				JComboBox<String> expediteurBox = new JComboBox<String>(joueurs);
				expediteurBox.setSelectedIndex(myGui.getListeJoueurs().indexOf(defiSel.getExpediteur()));
				expediteurBox.setMaximumSize(new Dimension(200, 30));
				boxesPanel.add(expediteurBox);
				
				boxesPanel.add(Box.createRigidArea(new Dimension(25, 30)));
				
				JComboBox<String> destinataireBox = new JComboBox<String>(joueurs);
				destinataireBox.setSelectedIndex(myGui.getListeJoueurs().indexOf(defiSel.getDestinataire()));
				destinataireBox.setMaximumSize(new Dimension(220, 30));
				boxesPanel.add(destinataireBox);
				
				panel.add(boxesPanel);
				
				panel.add(Box.createRigidArea(new Dimension(500, 10)));
				
				// BOUTONS : VALIDER & SUPPRIMER //
				JPanel buttonsPanel = new JPanel();
				buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.LINE_AXIS));
				buttonsPanel.setMaximumSize(new Dimension(460, 50));
				buttonsPanel.add(Box.createRigidArea(new Dimension(10, 10)));
				
				JLabel messageLabel = new JLabel("");
				messageLabel.setFont(new Font("Arial", Font.BOLD, 12));
				messageLabel.setForeground(Color.red);
				
				JButton validButton = new JButton("Valider!");
				JButton delButton = new JButton("Supprimer");
				
				validButton.setMaximumSize(new Dimension(80, 30));
				validButton.setPreferredSize(new Dimension(80, 30));
				validButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						String inputTitre = fieldTitre.getText();
						String fieldCategorie = categorieBox.getSelectedItem().toString();
						String fieldQuestion = contenuField.getText();
						String fieldReponse =  reponseField.getText();
						String fieldDestinataire = destinataireBox.getSelectedItem().toString();
						//System.out.println(fieldTitre + "\n" + fieldCategorie + "\n" + fieldQuestion + "\n" + fieldReponse + "\n" + fieldDestinataire);
					
						if(inputTitre.length() < 3) {
							messageLabel.setText("Erreur : Titre invalide (< 3 caractères)");
							return;
						} else if(inputTitre.length() > 20) {
							messageLabel.setText("Erreur : Titre invalide (> 20 caractères");
							return;
						} else if(fieldQuestion.length() < 20) {
							messageLabel.setText("Erreur : Question invalide (< 20 caractères)");
							return;
						}
						
						buttonsPanel.remove(validButton);
						buttonsPanel.remove(delButton);
						messageLabel.setText("Question validée");
						myGui.getListeDefis().get(myGui.getListeDefis().indexOf(defiSel)).setReviewed(true);
						myGui.addQuestion(question);
						
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
				
				delButton.setMaximumSize(new Dimension(100, 30));
				delButton.setPreferredSize(new Dimension(100, 30));
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
				JPanel retourPanel = new JPanel();
				retourPanel.setLayout(new BoxLayout(retourPanel, BoxLayout.LINE_AXIS));
				
				JButton retourButton = new JButton("Retour");
				retourButton.addActionListener(new ActionListener() {
		
					@Override
					public void actionPerformed(ActionEvent arg0) {
						new VerifyPanel(myGui, frame).repaint(1);
					}
					
				});
				retourPanel.add(Box.createVerticalGlue());
				retourPanel.add(retourButton);
				retourPanel.add(Box.createHorizontalGlue());
				panel.add(retourPanel);
				
				panel.repaint();
			}
		}
	}
}
