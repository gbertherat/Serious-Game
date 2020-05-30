package Interface;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
				panel.add(Box.createRigidArea(new Dimension(500,40)));
				panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
			
				// TITRE //
				JPanel titrePanel = new JPanel();
				titrePanel.setLayout(new BoxLayout(titrePanel, BoxLayout.LINE_AXIS));
				
				JLabel titre = new JLabel("Vérification des questions");
				titre.setFont(new Font("Arial", Font.BOLD, 21));
				titrePanel.add(titre);
				panel.add(titrePanel);
				
				panel.add(Box.createRigidArea(new Dimension(500, 30)));
				
				// HEADER //
				JPanel headPanel = new JPanel();
				headPanel.setLayout(new BoxLayout(headPanel, BoxLayout.LINE_AXIS));
				
				JLabel headLabel = new JLabel("Les questions à vérifier:");
				headLabel.setFont(new Font("Arial", Font.BOLD, 16));
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
				
				JPanel mainPanel = new JPanel();
				mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.LINE_AXIS));
				

				int size = liste.size();
				JPanel[] questionPanels = new JPanel[size];
				JLabel[] labelFields = new JLabel[size];
				JButton[] buttonFields = new JButton[size];
				for(int i = 0; i < 7; i++) {
					if((i+((index-1)*7)) == size){
						break;
					}
					
					choosen = liste.get((i+((index-1)*7)));
					
					questionPanels[((i+((index-1)*7)))] = new JPanel();
					questionPanels[((i+((index-1)*7)))].setLayout(new BoxLayout(questionPanels[(i+((index-1)*7))], BoxLayout.LINE_AXIS));
					labelFields[(i+((index-1)*7))] = new JLabel('"' + choosen.getQuestion().getTitre() + "\" par " + choosen.getExpediteur().getUsername());
					buttonFields[(i+((index-1)*7))] = new JButton("Vérifier");
					
					final int j = i;
					buttonFields[(i+((index-1)*7))].addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent arg0) {
							new Verify(myGui, frame).repaint((j+((index-1)*7)));
						}
					});
					
					questionPanels[(i+((index-1)*7))].add(labelFields[(i+((index-1)*7))]);
					questionPanels[(i+((index-1)*7))].add(Box.createRigidArea(new Dimension(20, 20)));
					questionPanels[(i+((index-1)*7))].add(buttonFields[(i+((index-1)*7))]);
					
					panel.add(questionPanels[(i+((index-1)*7))]);
					panel.add(Box.createRigidArea(new Dimension(20, 10)));
				}
				panel.add(mainPanel);
				
				// BOUTONS : NAVIGATION //
				int nbPages = 1;
				if(size > 7) {
					nbPages = (int) Math.floor(size/7);
				}
				if(nbPages*7 < size) {
					nbPages++;
				}
				
				JPanel navPanel = new JPanel();
				navPanel.setLayout(new BoxLayout(navPanel, BoxLayout.LINE_AXIS));
				
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
				JLabel numPage = new JLabel("Page: " + index + "/" + nbPages);
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
				
				panel.add(Box.createRigidArea(new Dimension(500, 30)));
				
				// BOUTON : RETOUR //
				JPanel retourPanel = new JPanel();
				retourPanel.setLayout(new BoxLayout(retourPanel, BoxLayout.LINE_AXIS));
				
				JButton retourButton = new JButton("Retour");
				retourButton.addActionListener(new ActionListener() {
		
					@Override
					public void actionPerformed(ActionEvent arg0) {
						new Administration(myGui, frame).repaint();
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
