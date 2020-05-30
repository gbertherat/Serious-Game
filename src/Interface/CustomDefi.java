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

public class CustomDefi {
	private GUI myGui;
	private JFrame frame;

	public CustomDefi(GUI myGui, JFrame frame) {
		this.myGui = myGui;
		this.frame = frame;
	}
	
	public void repaint() {
		if(GUI.idSession != 0) {			
			Container panel = frame.getContentPane();
			panel.removeAll();
			panel.revalidate();
			panel.add(Box.createRigidArea(new Dimension(500,10)));
			panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		
			Player selected = myGui.getPlayer(GUI.idSession);
			
			// TITRE //
			JPanel titrePanel = new JPanel();
			titrePanel.setLayout(new BoxLayout(titrePanel, BoxLayout.LINE_AXIS));
			JLabel titre = new JLabel("Envoyer un défi personnalisé");
			titre.setFont(new Font("Arial", Font.BOLD, 21));
			titrePanel.add(titre);
			panel.add(titrePanel);
				
			panel.add(Box.createRigidArea(new Dimension(500,10)));
			
			// TITRE DEFI /
			JPanel titreDefiPanel = new JPanel();
			titreDefiPanel.setLayout(new BoxLayout(titreDefiPanel, BoxLayout.LINE_AXIS));
			titreDefiPanel.setMaximumSize(new Dimension(500, 30));
			titreDefiPanel.add(Box.createRigidArea(new Dimension(20, 20)));
			
			JLabel titreDefiLabel = new JLabel("Titre du défi:");
			titreDefiLabel.setFont(new Font("Arial", Font.BOLD, 14));
			titreDefiPanel.add(titreDefiLabel);
			panel.add(titreDefiPanel);
			
			JPanel titreFieldPanel = new JPanel();
			titreFieldPanel.setLayout(new BoxLayout(titreFieldPanel, BoxLayout.LINE_AXIS));
			titreFieldPanel.setMaximumSize(new Dimension(500, 30));
			titreFieldPanel.add(Box.createRigidArea(new Dimension(20, 20)));
			
			JTextField titreField = new JTextField();
			titreField.setMaximumSize(new Dimension(200, 20));
			titreFieldPanel.add(titreField);
			panel.add(titreFieldPanel);
			
			// CATEGORIE //
			JPanel categoriePanel = new JPanel();
			categoriePanel.setLayout(new BoxLayout(categoriePanel, BoxLayout.LINE_AXIS));
			categoriePanel.setMaximumSize(new Dimension(500, 30));
			categoriePanel.add(Box.createRigidArea(new Dimension(20, 20)));
			
			JLabel categorieLabel = new JLabel("Catégorie:");
			categorieLabel.setFont(new Font("Arial", Font.BOLD, 14));
			categoriePanel.add(categorieLabel);
			panel.add(categoriePanel);
			
			JPanel boxPanel = new JPanel();
			boxPanel.setLayout(new BoxLayout(boxPanel, BoxLayout.LINE_AXIS));
			boxPanel.setMaximumSize(new Dimension(500, 30));
			boxPanel.add(Box.createRigidArea(new Dimension(20, 10)));
			
			JComboBox<String> categorieBox = new JComboBox<String>(myGui.categories);
			categorieBox.setSelectedIndex(0);
			categorieBox.setMaximumSize(new Dimension(200,20));
			boxPanel.add(categorieBox);
			panel.add(boxPanel);
			
			// CONTENU //
			JPanel contenuPanel = new JPanel();
			contenuPanel.setLayout(new BoxLayout(contenuPanel, BoxLayout.LINE_AXIS));
			contenuPanel.setMaximumSize(new Dimension(500, 30));
			contenuPanel.add(Box.createRigidArea(new Dimension(20, 20)));
			
			JLabel contenuLabel = new JLabel("Contenu:");
			contenuLabel.setFont(new Font("Arial", Font.BOLD, 14));
			contenuPanel.add(contenuLabel);
			panel.add(contenuPanel);
			
			JTextArea contenuField = new JTextArea(5, 30);
			contenuField.setLineWrap(true);
			contenuField.setWrapStyleWord(true);
			JScrollPane scrollPanel = new JScrollPane(contenuField);
			scrollPanel.setMaximumSize(new Dimension(460,80));
			scrollPanel.setPreferredSize(new Dimension(460, 80));
			panel.add(scrollPanel);
			
			panel.add(Box.createRigidArea(new Dimension(500, 10)));
			
			// REPONSE //
			JPanel reponsePanel = new JPanel();
			reponsePanel.setLayout(new BoxLayout(reponsePanel, BoxLayout.LINE_AXIS));
			reponsePanel.setMaximumSize(new Dimension(500, 30));
			reponsePanel.add(Box.createRigidArea(new Dimension( 20, 20)));
			
			JLabel reponseLabel = new JLabel("Réponse(s): (Séparez les réponses avec un ';')");
			reponseLabel.setFont(new Font("Arial", Font.BOLD, 14));
			reponsePanel.add(reponseLabel);
			panel.add(reponsePanel);
			
			JTextArea reponseField = new JTextArea(5, 30);
			reponseField.setLineWrap(true);
			reponseField.setWrapStyleWord(true);
			JScrollPane reponseScroll = new JScrollPane(reponseField);
			reponseScroll.setMaximumSize(new Dimension(460, 80));
			reponseScroll.setPreferredSize(new Dimension(460 ,80));
			panel.add(reponseScroll);
			
			// DESTINATAIRE //	
			JPanel destinatairePanel = new JPanel();
			destinatairePanel.setLayout(new BoxLayout(destinatairePanel, BoxLayout.LINE_AXIS));
			destinatairePanel.setMaximumSize(new Dimension(500, 30));
			destinatairePanel.add(Box.createRigidArea(new Dimension(20, 20)));
			
			JLabel destinataireLabel = new JLabel("Destinataire: ");
			destinataireLabel.setFont(new Font("Arial", Font.BOLD, 14));
			destinatairePanel.add(destinataireLabel);
			
			String[] joueurs = new String[myGui.getListeJoueurs().size()];
			for(int i = 0; i < myGui.getListeJoueurs().size(); i++) {
				joueurs[i] = myGui.getListeJoueurs().get(i).getNom() + " " + myGui.getListeJoueurs().get(i).getPrenom();
			}
			
			JComboBox<String> destinataireBox = new JComboBox<String>(joueurs);
			destinataireBox.setSelectedIndex(0);
			destinataireBox.setMaximumSize(new Dimension(200,20));
			destinatairePanel.add(destinataireBox);
			panel.add(destinatairePanel);
			
			panel.add(Box.createRigidArea(new Dimension(500, 10)));
			
			// MESSAGE //
			JPanel messagePanel = new JPanel();
			messagePanel.setLayout(new BoxLayout(messagePanel, BoxLayout.LINE_AXIS));
			
			JLabel messageLabel = new JLabel("");
			messageLabel.setFont(new Font("Arial", Font.BOLD, 14));
			messageLabel.setForeground(Color.red);
			messagePanel.add(messageLabel);
			panel.add(messagePanel);
			
			panel.add(Box.createRigidArea(new Dimension(500, 10)));
			
			// BOUTON : ENVOYER //
			JPanel sendPanel = new JPanel();
			sendPanel.setLayout(new BoxLayout(sendPanel, BoxLayout.LINE_AXIS));
			
			JButton sendButton = new JButton("Envoyer!");
			sendButton.addActionListener(new ActionListener() {
	
				@Override
				public void actionPerformed(ActionEvent arg0) {
					String fieldTitre = titreField.getText();
					String fieldCategorie = categorieBox.getSelectedItem().toString();
					String fieldQuestion = contenuField.getText();
					String fieldReponse =  reponseField.getText();
					String fieldDestinataire = destinataireBox.getSelectedItem().toString();
					//System.out.println(fieldTitre + "\n" + fieldCategorie + "\n" + fieldQuestion + "\n" + fieldReponse + "\n" + fieldDestinataire);
				
					if(fieldTitre.length() < 3) {
						messageLabel.setText("Erreur : Titre invalide (< 3 caractères)");
						return;
					} else if(fieldTitre.length() > 20) {
						messageLabel.setText("Erreur : Titre invalide (> 20 caractères");
						return;
					} else if(fieldQuestion.length() < 20) {
						messageLabel.setText("Erreur : Question invalide (< 20 caractères)");
						return;
					}
					
					boolean error = true;
					Question newQuestion = new Question(fieldTitre, fieldQuestion, fieldCategorie);
					newQuestion.addReponse(fieldReponse);
					for(Player p: myGui.getListeJoueurs()) {
						if((p.getNom() + " " + p.getPrenom()).equals(fieldDestinataire)) {
							error = false;
							Defi newDefi = new Defi(newQuestion, selected, p, 0);
							myGui.addDefi(newDefi);
							messageLabel.setText("Défi envoyé!");
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
			JPanel retourPanel = new JPanel();
			retourPanel.setLayout(new BoxLayout(retourPanel, BoxLayout.LINE_AXIS));
			
			JButton retourButton = new JButton("Retour");
			retourButton.addActionListener(new ActionListener() {
	
				@Override
				public void actionPerformed(ActionEvent arg0) {
					new LancerDefi(myGui, frame).repaint();
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
