package Interface.Admin;

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
import Interface.GUI;
import Interface.User.Menu;
import v1.Defi;
import v1.Player;

/**
 * Fenêtre administrateur principale
 * @author Guillaume
 */
public class AdminPanel {
	private GUI myGui;
	private JFrame frame;
	
	/**
	 * Constructeur de la classe AdminPanel
	 * @param myGui - GUI à utiliser
	 * @param frame - Frame à utiliser
	 */
	public AdminPanel(GUI myGui, JFrame frame) {
		this.myGui = myGui;
		this.frame = frame;
	}
	
	/**
	 * Permet l'affichage de la fenêtre
	 */
	public void repaint() {
		if(GUI.idSession != 0) {
			Player selected = myGui.getPlayer(GUI.idSession);
			if(selected.isAdmin()) { // Si l'utilisateur est un administrateur
				// On récupère le panel principal
				Container panel = frame.getContentPane();
				panel.removeAll();
				panel.revalidate();
				panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
				panel.add(Box.createRigidArea(new Dimension(500, 110)));
			
				// TITRE //
				JPanel titrePanel = Factory.addPanel();
				JLabel titre = Factory.addLabel("Menu administration", 21, true);
				titrePanel.add(titre);
				panel.add(titrePanel);
				
				panel.add(Box.createRigidArea(new Dimension(500, 30)));
				
				// BOUTON : GERER LES UTILISATEURS //
				JPanel usersPanel = Factory.addPanel();
				JButton usersButton = Factory.addButton("Gérer les utilisateurs", 200, 50);
				usersButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						new AdminUsersPanel(myGui, frame).repaint(1);
					}
				});
				usersPanel.add(usersButton);
				panel.add(usersPanel);
				
				panel.add(Box.createRigidArea(new Dimension(500, 20)));
				
				// BOUTON : GERER LES QUESTIONS //
				JPanel questionsPanel = Factory.addPanel();
				JButton questionsButton = Factory.addButton("Gérer les questions", 200, 50);
				questionsButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						new AdminQuestionPanel(myGui, frame).repaint(1);	
					}
				});
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
				
				JPanel labelPanel = Factory.addPanel();
				JLabel label = Factory.addLabel("Il y a " + nbDefi + " défi(s) en attente de vérification.", 15, false);
				labelPanel.add(label);
				panel.add(labelPanel);
				
				panel.add(Box.createRigidArea(new Dimension(500, 10)));
				
				JPanel verifyPanel = Factory.addPanel();
				verifyPanel.setLayout(new BoxLayout(verifyPanel, BoxLayout.LINE_AXIS));
				
				JButton verifyButton = Factory.addButton("Vérifier les questions", 200, 50);
				verifyButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						new AdminVerifyPanel(myGui, frame).repaint(1);
					}	
				});
				verifyPanel.add(verifyButton);
				panel.add(verifyPanel);
				
				panel.add(Box.createRigidArea(new Dimension(500,90)));
				
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
}
