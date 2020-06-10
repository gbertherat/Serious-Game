package Interface.User;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
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
import Interface.GUI;
import v1.Defi;
import v1.Player;
import v1.Question;

public class SendCustomQuestion {
	private GUI myGui;
	private JFrame frame;

	public SendCustomQuestion(GUI myGui, JFrame frame) {
		this.myGui = myGui;
		this.frame = frame;
	}
	
	public void repaint() {
		if(GUI.idSession != 0) {			
			Container panel = frame.getContentPane();
			panel.removeAll();
			panel.revalidate();
			panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
			panel.add(Box.createRigidArea(new Dimension(500,10)));
		
			Player selected = myGui.getPlayer(GUI.idSession);
			
			// TITRE //
			JPanel titrePanel = Factory.addPanel();
			JLabel titre = new JLabel("Envoyer un défi personnalisé");
			titre.setFont(new Font("Arial", Font.BOLD, 21));
			titrePanel.add(titre);
			panel.add(titrePanel);
				
			panel.add(Box.createRigidArea(new Dimension(500,10)));
			
			// TITRE DEFI /
			JPanel titreDefiPanel = Factory.addPanel();
			titreDefiPanel.setMaximumSize(new Dimension(500, 30));
			titreDefiPanel.add(Box.createRigidArea(new Dimension(20, 20)));
			
			JLabel titreDefiLabel = Factory.addLabel("Titre du défi:", 14, true);
			titreDefiPanel.add(titreDefiLabel);
			panel.add(titreDefiPanel);
			
			JPanel titreFieldPanel = Factory.addPanel();
			titreFieldPanel.setMaximumSize(new Dimension(500, 30));
			titreFieldPanel.add(Box.createRigidArea(new Dimension(20, 20)));
			
			JTextField titreField = Factory.addField(200, 30, true);
			titreFieldPanel.add(titreField);
			panel.add(titreFieldPanel);
			panel.add(Factory.addSpace(10));
			
			// CATEGORIE //
			JPanel categoriePanel = Factory.addPanel();
			categoriePanel.setMaximumSize(new Dimension(500, 30));
			categoriePanel.add(Box.createRigidArea(new Dimension(20, 20)));
			
			JLabel categorieLabel = Factory.addLabel("Catégorie:", 14, true);
			categoriePanel.add(categorieLabel);
			panel.add(categoriePanel);
			
			JPanel boxPanel = Factory.addPanel();
			boxPanel.setMaximumSize(new Dimension(500, 30));
			boxPanel.add(Box.createRigidArea(new Dimension(20, 10)));
			
			JComboBox<String> categorieBox = Factory.addBox(myGui.categories, 200, 20);
			boxPanel.add(categorieBox);
			panel.add(boxPanel);
			panel.add(Factory.addSpace(10));
			
			// CONTENU //
			JPanel contenuPanel = Factory.addPanel();
			contenuPanel.setMaximumSize(new Dimension(500, 30));
			contenuPanel.add(Box.createRigidArea(new Dimension(20, 20)));
			
			JLabel contenuLabel = Factory.addLabel("Contenu:", 14, true);
			contenuPanel.add(contenuLabel);
			panel.add(contenuPanel);
			
			JTextArea contenuField = Factory.addTextArea(460, 80, true);
			JScrollPane scrollPanel = Factory.addScroll(contenuField, 460, 80);
			panel.add(scrollPanel);
			
			panel.add(Factory.addSpace(10));
			
			// REPONSE //
			JPanel reponsePanel = Factory.addPanel();
			reponsePanel.setMaximumSize(new Dimension(500, 30));
			reponsePanel.add(Box.createRigidArea(new Dimension( 20, 20)));
			
			JLabel reponseLabel = Factory.addLabel("Réponse(s): (Séparez les réponses avec un ';')", 14, true);
			reponsePanel.add(reponseLabel);
			panel.add(reponsePanel);
			
			JTextArea reponseField = Factory.addTextArea(460, 80, true);
			JScrollPane reponseScroll = Factory.addScroll(reponseField, 460, 80);
			panel.add(reponseScroll);
			panel.add(Factory.addSpace(10));
			
			// DESTINATAIRE //	
			JPanel destinatairePanel = Factory.addPanel();
			destinatairePanel.setMaximumSize(new Dimension(500, 30));
			destinatairePanel.add(Box.createRigidArea(new Dimension(20, 20)));
			
			JLabel destinataireLabel = Factory.addLabel("Destinataire: ", 14, true);
			destinatairePanel.add(destinataireLabel);
			
			String[] joueurs = new String[myGui.getListeJoueurs().size()-1];
			int i = 0;
			for(Player p : myGui.getListeJoueurs()) {
				if(p != selected) {
					joueurs[i] = p.getUsername();
					i++;
				}
			}
			
			JComboBox<String> destinataireBox = Factory.addBox(joueurs, 200, 30);
			destinatairePanel.add(destinataireBox);
			panel.add(destinatairePanel);
			
			panel.add(Factory.addSpace(10));
			
			// MESSAGE //
			JPanel messagePanel = Factory.addPanel();
			
			JLabel messageLabel = Factory.addLabel("", 14, true);
			messageLabel.setForeground(Color.red);
			messagePanel.add(messageLabel);
			panel.add(messagePanel);
			
			panel.add(Factory.addSpace(10));
			
			// BOUTON : ENVOYER //
			JPanel sendPanel = Factory.addPanel();
			
			JButton sendButton = Factory.addButton("Envoyer!", 100, 75);
			sendButton.addActionListener(new ActionListener() {
	
				@Override
				public void actionPerformed(ActionEvent arg0) {
					String fieldTitre = titreField.getText();
					String fieldCategorie = categorieBox.getSelectedItem().toString();
					String fieldQuestion = contenuField.getText();
					String fieldReponse =  reponseField.getText();
					String fieldDestinataire = "";
					try {
						fieldDestinataire = destinataireBox.getSelectedItem().toString();
					} catch(NullPointerException e) {
						messageLabel.setText("Erreur: Destinataire invalide");
						return;
					}
					
					if(fieldTitre.length() < 3) {
						messageLabel.setText("Erreur : Titre invalide (< 3 caractères)");
						return;
					} else if(fieldTitre.length() > 20) {
						messageLabel.setText("Erreur : Titre invalide (> 20 caractères");
						return;
					} else if(fieldQuestion.length() < 20) {
						messageLabel.setText("Erreur : Question invalide (< 20 caractères)");
						return;
					} else if(fieldReponse.length() < 1) {
						messageLabel.setText("Erreur : Réponse invalide (< 1 caractère)");
						return;
					}
					
					boolean error = true;
					Question newQuestion = new Question(fieldTitre, fieldQuestion, fieldCategorie);
					
					newQuestion.setReponses(new ArrayList<String>());
					String[] allReponses = fieldReponse.split(";");
					for(String r : allReponses) {
						newQuestion.addReponse(r.toLowerCase());
					}
					
					for(Player p: myGui.getListeJoueurs()) {
						if(p.getUsername().equals(fieldDestinataire)) {
							error = false;
							panel.remove(sendPanel);
							Defi newDefi = new Defi(newQuestion, selected, p, 0);
							myGui.addDefi(newDefi);
							messageLabel.setText("Défi envoyé!");
							myGui.saveAll();
							ActionListener menu = new ActionListener() {
								@Override
								public void actionPerformed(ActionEvent arg0) {
									new Menu(myGui, frame).repaint();
								}
							};
							Timer timer = new Timer(1000, menu);
							timer.start();
							timer.setRepeats(false);
						}
					}
					
					if(error == true) {
						messageLabel.setText("Erreur lors de l'envoie");
					}
				}
				
			});
			sendButton.setMaximumSize(new Dimension(150,70));
			sendButton.setPreferredSize(new Dimension(120, 50));
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
					new SendQuestionPanel(myGui, frame).repaint();
				}
			});
			retourPanel.add(back);
			retourPanel.add(Box.createHorizontalGlue());
			panel.add(retourPanel);
			
			panel.repaint();
		}
	}
}
