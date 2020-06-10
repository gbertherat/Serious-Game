package Interface;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Components.Factory;

public class MainMenu {
	private GUI myGui;
	private JFrame frame;
	
	public MainMenu(GUI myGui, JFrame frame) {
		this.myGui = myGui;
		this.frame = frame;
	}
	
	public void repaint() {
		JPanel main = new JPanel();
		main.setLayout(new BoxLayout(main, BoxLayout.PAGE_AXIS));
		main.setMaximumSize(frame.getSize());
		main.add(Box.createRigidArea(new Dimension(720,30)));
		
		// TITRE //
		JPanel titrePanel = Factory.addPanel();
		JLabel titre = Factory.addLabel("Serious-Game", 21, true);
		
		titrePanel.add(titre);
		main.add(titrePanel);
		
		
		// AUTEUR //
		JPanel authorPanel = Factory.addPanel();
		JLabel author = Factory.addLabel("by Bertherat Guillaume",  19, false);
		authorPanel.add(author);
		main.add(authorPanel);
		
		main.add(Box.createRigidArea(new Dimension(720,60)));
		
		
		// BOUTON: SE CONNECTER
		JPanel connectPanel = Factory.addPanel();
		JButton seConnecter = Factory.addButton("Se connecter", 150, 50);
		seConnecter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(GUI.idSession == 0) {
					new Connexion(myGui, frame).repaint();
				}
			}
		});
		connectPanel.add(seConnecter);
		main.add(connectPanel);
		
		main.add(Box.createRigidArea(new Dimension(720,40)));
		
		// BOUTON S'INSCRIRE
		Inscription pageInscription = new Inscription(myGui, frame);
		
		JPanel signInPanel = Factory.addPanel();
		JButton sInscrire = Factory.addButton("S'inscrire", 150, 50);
		sInscrire.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(GUI.idSession == 0) {
					pageInscription.repaint();
				}
			}
		});
		signInPanel.add(sInscrire);
		main.add(signInPanel);
		
		main.add(Box.createRigidArea(new Dimension(720,40)));
		
		// BOUTON QUITTER
		JPanel quitPanel = Factory.addPanel();
		JButton quitter = Factory.addButton("Quitter", 150, 50);
		quitter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));		
			}
		});
		quitPanel.add(quitter);
		main.add(quitPanel);
		
		frame.getContentPane().add(main);
		frame.setVisible(true);
	}
}
