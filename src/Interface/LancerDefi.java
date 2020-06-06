package Interface;

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

import Components.Factory;

public class LancerDefi {
	private GUI myGui;
	private JFrame frame;
	
	public LancerDefi(GUI myGui, JFrame frame) {
		this.myGui = myGui;
		this.frame = frame;
	}
	
	public void repaint() {
		if(GUI.idSession != 0) {
			Container panel = frame.getContentPane();
			panel.removeAll();
			panel.revalidate();
			panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
			panel.add(Box.createRigidArea(new Dimension(500,150)));
		
			// TITRE //
			JPanel titrePanel = Factory.addPanel();
			JLabel titre = Factory.addLabel("Envoyer un défi", 21, true);
			titrePanel.add(titre);
			panel.add(titrePanel);
			
			panel.add(Box.createRigidArea(new Dimension(500, 30)));
			
			// QUESTION //
			JPanel questionPanel = Factory.addPanel();
			JLabel questionLabel = Factory.addLabel("Quel type de défi voulez-vous envoyez?", 16, true);
			questionPanel.add(questionLabel);
			panel.add(questionPanel);
			
			panel.add(Box.createRigidArea(new Dimension(500,30)));
			
			panel.repaint();
			
			// BOUTONS
			JPanel buttonPanel = Factory.addPanel();
			buttonPanel.setMaximumSize(new Dimension(500, 75));
			buttonPanel.add(Box.createRigidArea(new Dimension(40, 20)));
			
			// QUESTION EXISTANTE
			JButton existButton = Factory.addButton("Question existante", 200, 50);
			existButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					new AllQuestions(myGui, frame).repaint(1);
				}
			});
			buttonPanel.add(existButton);
			
			buttonPanel.add(Box.createRigidArea(new Dimension(20, 20)));
			
			// QUESTION PERSONNALISE
			JButton customButton = Factory.addButton("Question personnalisée", 200, 50);
			customButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					new CustomDefi(myGui, frame).repaint();
				}
			});
			buttonPanel.add(customButton);
			panel.add(buttonPanel);
			
			// BOUTON : RETOUR //
			panel.add(Box.createVerticalGlue());
			JPanel retourPanel = Factory.addPanel();
			JButton back = Factory.addButton("Retour", 100, 40);
			back.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					panel.removeAll();
					panel.revalidate();
					panel.repaint();
					new Menu(myGui, frame).repaint();
				}
			});
			retourPanel.add(back);
			retourPanel.add(Box.createHorizontalGlue());
			panel.add(retourPanel);
		
			panel.repaint();
		}
	}
}
