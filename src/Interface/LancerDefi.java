package Interface;

import java.awt.Component;
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

import v1.Player;

public class LancerDefi {
	private GUI myGui;
	private JFrame frame;
	
	public LancerDefi(GUI myGui, JFrame frame) {
		this.myGui = myGui;
		this.frame = frame;
	}
	
	public void repaint() {
		if(GUI.idSession != 0) {
			Player selected = myGui.getPlayer(GUI.idSession);
			
			Container panel = frame.getContentPane();
			panel.removeAll();
			panel.revalidate();
			panel.add(Box.createRigidArea(new Dimension(500,10)));
			panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		
			// TITRE //
			JPanel titrePanel = new JPanel();
			titrePanel.setLayout(new BoxLayout(titrePanel, BoxLayout.LINE_AXIS));
			JLabel titre = new JLabel("Envoyer un défi");
			titre.setFont(new Font("Arial", Font.BOLD, 21));
			titrePanel.add(titre);
			panel.add(titrePanel);
			
			panel.add(Box.createRigidArea(new Dimension(500, 100)));
			
			// QUESTION //
			JPanel questionPanel = new JPanel();
			questionPanel.setLayout(new BoxLayout(questionPanel, BoxLayout.LINE_AXIS));
			
			JLabel questionLabel = new JLabel("Quel type de défi voulez-vous envoyez?");
			questionLabel.setFont(new Font("Arial", Font.BOLD, 16));
			questionPanel.add(questionLabel);
			panel.add(questionPanel);
			
			panel.add(Box.createRigidArea(new Dimension(500,30)));
			
			panel.repaint();
			
			// BOUTONS
			JPanel buttonPanel = new JPanel();
			buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.LINE_AXIS));
			buttonPanel.setMaximumSize(new Dimension(500, 75));
			buttonPanel.add(Box.createRigidArea(new Dimension(40, 20)));
			
			// QUESTION EXISTANTE
			JButton existButton = new JButton("Question existante");
			existButton.setMaximumSize(new Dimension(200, 50));
			existButton.setPreferredSize(new Dimension(200, 50));
			buttonPanel.add(existButton);
			
			buttonPanel.add(Box.createRigidArea(new Dimension(20, 20)));
			
			// QUESTION PERSONNALISE
			JButton customButton = new JButton("Question personnalisée");
			customButton.setMaximumSize(new Dimension(200, 50));
			customButton.setPreferredSize(new Dimension(200, 50));
			customButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					new CustomDefi(myGui, frame).repaint();
				}
				
			});
			buttonPanel.add(customButton);
			panel.add(buttonPanel);
			
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
