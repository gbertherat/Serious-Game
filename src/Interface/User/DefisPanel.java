package Interface.User;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Components.Factory;
import Interface.GUI;
import v1.Defi;
import v1.Player;

/**
 * La classe AccepterDefi correspond à la fenêtre affichant tous les défis disponibles et de pouvoir en accepter un.
 * @author Guillaume
 */
public class DefisPanel {
	GUI myGui;
	JFrame frame;
	
	/**
	 * Constructeur de la classe AccepterDefi
	 * @param myGui - Le GUI
	 * @param frame - La frame du GUI
	 */
	public DefisPanel(GUI myGui, JFrame frame) {
		this.myGui = myGui;
		this.frame = frame;
	}
	
	/**
	 * Permet d'afficher la fenêtre pour accepter un défi
	 * @param index - Le numéro de la page
	 */
	public void repaint(int index) {
		if(GUI.idSession != 0) {
			// On récupère le panel principal
			Container panel = frame.getContentPane();
			panel.removeAll();
			panel.revalidate();
			panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
			panel.add(Box.createRigidArea(new Dimension(500,20)));
		
			Player selected = myGui.getPlayer(GUI.idSession);
			
			// TITRE //
			JPanel titrePanel = Factory.addPanel();
			JLabel titre = Factory.addLabel("Accepter un défi", 21, true);
			titrePanel.add(titre);
			panel.add(titrePanel);
				
			panel.add(Box.createRigidArea(new Dimension(500,10)));
			
			// LISTE DES DEFIS DISPONIBLE //
			ArrayList<Defi> liste = new ArrayList<>();
			for(Defi p : myGui.getListeDefis()) { // On récupère tous les défis disponibles
				if(p.isReviewed() && !p.isAccepte() && !p.isTermine() && p.getDestinataire() == selected) {
					liste.add(p); // On ajoute le défi à la liste des défis disponibles s'il n'a pas déjà été accepté et terminé
				}
			}
			
			Defi choosen = null;
			JPanel mainPanel = Factory.addPanel();
			int size = liste.size();
			JPanel[] questionPanels = new JPanel[size];
			JLabel[] labelFields = new JLabel[size];
			JButton[] buttonFields = new JButton[size];
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM à HH:mm"); // Formattage du LocalDateTime
			for(int i = 0; i < 10; i++) { // On affiche 10 défis par page
				if((i+((index-1)*10)) == size){
					break;
				}
				
				choosen = liste.get((i+((index-1)*10)));
				String formattedString = choosen.getDateExpiration().format(formatter);
				
				questionPanels[((i+((index-1)*10)))] = Factory.addPanel();
				labelFields[(i+((index-1)*10))] = Factory.addLabel('"' + choosen.getQuestion().getTitre() + "\" par " + choosen.getExpediteur().getUsername() + " | Expire le: " + formattedString, 13, false);
				buttonFields[(i+((index-1)*10))] = Factory.addButton("Accepter", 100, 30);
				
				final Defi defiSel = choosen;
				buttonFields[(i+((index-1)*10))].addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						new RepondreDefi(myGui, frame).repaint(defiSel.getId());
					}
				});
				
				questionPanels[(i+((index-1)*10))].add(labelFields[(i+((index-1)*10))]);
				questionPanels[(i+((index-1)*10))].add(Box.createRigidArea(new Dimension(20, 20)));
				questionPanels[(i+((index-1)*10))].add(buttonFields[(i+((index-1)*10))]);
				
				panel.add(questionPanels[(i+((index-1)*10))]);
				panel.add(Box.createRigidArea(new Dimension(20, 10)));
			}
			panel.add(mainPanel);
			
			// BOUTONS : NAVIGATION //
			int nbPages = 1;
			if(size > 10) {
				nbPages = (int) Math.floor(size/10);
			}
			if(nbPages*10 < size) {
				nbPages++;
			}
			
			JPanel navPanel = Factory.addPanel();
			// BOUTON : PAGE PRECEDENTE //
			if(index > 1) {
				JButton precButton = new JButton("<-");
				precButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						new DefisPanel(myGui, frame).repaint(index-1);
					}
				});
				navPanel.add(precButton);
			}
			navPanel.add(Box.createRigidArea(new Dimension(20, 20)));
			
			// NUMERO DE LA PAGE ACTUELLE //
			JLabel numPage = new JLabel("Page: " + index + "/" + nbPages);
			navPanel.add(numPage);
			navPanel.add(Box.createRigidArea(new Dimension(20, 20)));
			
			// BOUTON : PAGE SUIVANTE //
			if(index < nbPages) {
				JButton nextButton = new JButton("->");
				nextButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						new DefisPanel(myGui, frame).repaint(index+1);
					}
					
				});
				navPanel.add(nextButton);
			}
			panel.add(Box.createVerticalGlue());
			panel.add(navPanel);
			
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
