package Interface;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import v1.Defi;
import v1.Player;

public class Administration {
	private GUI myGui;
	private JFrame frame;
	
	public Administration(GUI myGui, JFrame frame) {
		this.myGui = myGui;
		this.frame = frame;
	}
	
	public void repaint() {
		if(GUI.idSession != 0) {
			Player selected = myGui.getPlayer(GUI.idSession);
			if(selected.getClass().getSimpleName().equals("Admin")) {
				Container panel = frame.getContentPane();
				panel.removeAll();
				panel.revalidate();
				panel.add(Box.createRigidArea(new Dimension(500,40)));
				panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
			
				// TITRE //
				JPanel titrePanel = new JPanel();
				titrePanel.setLayout(new BoxLayout(titrePanel, BoxLayout.LINE_AXIS));
				
				JLabel titre = new JLabel("Menu administration");
				titre.setFont(new Font("Arial", Font.BOLD, 21));
				titrePanel.add(titre);
				panel.add(titrePanel);
				
				panel.add(Box.createRigidArea(new Dimension(500, 70)));
				
				// BOUTON : GERER LES UTILISATEURS //
				JPanel usersPanel = new JPanel();
				usersPanel.setLayout(new BoxLayout(usersPanel, BoxLayout.LINE_AXIS));
				
				JButton usersButton = new JButton("Gérer les utilisateurs");
				usersButton.setMaximumSize(new Dimension(200, 50));
				usersButton.setPreferredSize(new Dimension(200, 50));
				usersPanel.add(usersButton);
				panel.add(usersPanel);
				
				panel.add(Box.createRigidArea(new Dimension(500, 20)));
				
				// BOUTON : GERER LES QUESTIONS //
				JPanel questionsPanel = new JPanel();
				questionsPanel.setLayout(new BoxLayout(questionsPanel, BoxLayout.LINE_AXIS));
				
				JButton questionsButton = new JButton("Gérer les questions");
				questionsButton.setMaximumSize(new Dimension(200, 50));
				questionsButton.setPreferredSize(new Dimension(200, 50));
				questionsPanel.add(questionsButton);
				panel.add(questionsPanel);
				
				panel.add(Box.createRigidArea(new Dimension(500, 20)));
				
				// BOUTON : VERIFIER LES QUESTIONS //
				int nbDefi = 0;
				for(Defi d: myGui.getListeDefis()) {
					if(!d.isReviewed()) {
						nbDefi++;
					}
				}
				
				JPanel labelPanel = new JPanel();
				labelPanel.setLayout(new BoxLayout(labelPanel, BoxLayout.LINE_AXIS));
				
				JLabel label = new JLabel("Il y a " + nbDefi + " défi(s) en attente de vérification.");
				label.setFont(new Font("Arial", Font.PLAIN, 15));
				labelPanel.add(label);
				panel.add(labelPanel);
				
				panel.add(Box.createRigidArea(new Dimension(500, 10)));
				
				JPanel verifyPanel = new JPanel();
				verifyPanel.setLayout(new BoxLayout(verifyPanel, BoxLayout.LINE_AXIS));
				
				JButton verifyButton = new JButton("Vérifier les questions");
				verifyButton.setMaximumSize(new Dimension(200, 50));
				verifyButton.setPreferredSize(new Dimension(200, 50));
				verifyButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						new VerifyPanel(myGui, frame).repaint(1);
					}
					
				});
				verifyPanel.add(verifyButton);
				panel.add(verifyPanel);
				
				panel.add(Box.createRigidArea(new Dimension(500, 20)));
				
				// BOUTON : RETOUR //
				JPanel retourPanel = new JPanel();
				retourPanel.setLayout(new BoxLayout(retourPanel, BoxLayout.LINE_AXIS));
				
				JButton retourButton = new JButton("Retour");
				retourButton.addActionListener(new ActionListener() {
		
					@Override
					public void actionPerformed(ActionEvent arg0) {
						new Menu(myGui, frame).repaint();
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
