package Interface;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Components.Factory;
import v1.Defi;
import v1.Player;

public class VerifyPanel {
	private GUI myGui;
	private JFrame frame;
	
	public VerifyPanel(GUI myGui, JFrame frame) {
		this.myGui = myGui;
		this.frame = frame;
	}
	
	public void repaint(int index) {
		if(GUI.idSession != 0) {
			Player selected = myGui.getPlayer(GUI.idSession);
			if(selected.getClass().getSimpleName().equals("Admin")) {
				Container panel = frame.getContentPane();
				panel.removeAll();
				panel.revalidate();
				panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
				panel.add(Box.createRigidArea(new Dimension(500,40)));
			
				// TITRE //
				JPanel titrePanel = Factory.addPanel();
				JLabel titre = Factory.addLabel("Vérification des questions", 21, true);
				titrePanel.add(titre);
				panel.add(titrePanel);
				
				panel.add(Box.createRigidArea(new Dimension(500, 30)));
				
				// HEADER //
				JPanel headPanel = Factory.addPanel();
				JLabel headLabel = Factory.addLabel("Les questions à vérifier:", 16, true);
				headPanel.add(headLabel);
				panel.add(headPanel);
				
				panel.add(Box.createRigidArea(new Dimension(500, 20)));
				
				// QUESTIONS //
				ArrayList<Defi> liste = new ArrayList<>();
				for(Defi d: myGui.getListeDefis()) {
					if(!d.isReviewed()) {
						liste.add(d);	
					}
				}
				
				Defi choosen = null;
				JPanel mainPanel = Factory.addPanel();
				
				int size = liste.size();
				JPanel[] questionPanels = new JPanel[size];
				JLabel[] labelFields = new JLabel[size];
				JButton[] buttonFields = new JButton[size];
				for(int i = 0; i < 10; i++) {
					if((i+((index-1)*10)) == size){
						break;
					}
					
					choosen = liste.get((i+((index-1)*10)));
					
					questionPanels[((i+((index-1)*10)))] = Factory.addPanel();
					labelFields[(i+((index-1)*10))] = Factory.addLabel('"' + choosen.getQuestion().getTitre() + "\" par " + choosen.getExpediteur().getUsername(), 14, false);
					buttonFields[(i+((index-1)*10))] = Factory.addButton("Vérifier", 100, 25);
					
					final Defi defiSel = choosen;
					buttonFields[(i+((index-1)*10))].addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent arg0) {
							new Verify(myGui, frame).repaint(defiSel.getId());
						}
					});
					
					questionPanels[(i+((index-1)*10))].add(labelFields[(i+((index-1)*10))]);
					questionPanels[(i+((index-1)*10))].add(Box.createRigidArea(new Dimension(20, 20)));
					questionPanels[(i+((index-1)*10))].add(buttonFields[(i+((index-1)*10))]);
					
					panel.add(questionPanels[(i+((index-1)*10))]);
					panel.add(Box.createRigidArea(new Dimension(20, 5)));
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
				if(index > 1) {
					JButton precButton = new JButton("<-");
					precButton.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent arg0) {
							new VerifyPanel(myGui, frame).repaint(index-1);
						}
						
					});
					navPanel.add(precButton);
				}
				navPanel.add(Box.createRigidArea(new Dimension(20, 20)));
				JLabel numPage = Factory.addLabel("Page: " + index + "/" + nbPages, 15, true);
				navPanel.add(numPage);
				navPanel.add(Box.createRigidArea(new Dimension(20, 20)));
				if(index < nbPages) {
					JButton nextButton = new JButton("->");
					nextButton.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent arg0) {
							new VerifyPanel(myGui, frame).repaint(index+1);
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
						new Administration(myGui, frame).repaint();
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
