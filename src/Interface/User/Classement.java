package Interface.User;

import Interface.GUI;
import v1.Player;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import Components.Factory;

public class Classement {
	private GUI myGui;
	private JFrame frame;
	
	public Classement(GUI myGui, JFrame frame) {
		this.myGui = myGui;
		this.frame = frame;
	}
	
	public void repaint(int type, int index) {
		if(GUI.idSession != 0) {
			Container panel = frame.getContentPane();
			panel.removeAll();
			panel.revalidate();
			panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
			panel.add(Box.createRigidArea(new Dimension(500,30)));
		
			// TITRE //
			JPanel titrePanel = Factory.addPanel();
			JLabel titre = Factory.addLabel("Classement", 21, true);
			titrePanel.add(titre);
			panel.add(titrePanel);
			
			panel.add(Box.createRigidArea(new Dimension(500, 30)));
			
			// TYPE CLASSEMENT //
			JPanel typePanel = Factory.addPanel();
			ButtonGroup group = new ButtonGroup();
			JRadioButton score = new JRadioButton("Score");
			score.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					new Classement(myGui, frame).repaint(1, 1);
				}
			});
			JRadioButton vie = new JRadioButton("Vie");
			vie.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					new Classement(myGui, frame).repaint(2, 1);
				}
			});
			
			if(type == 1) {
				score.setSelected(true);
			} else {
				vie.setSelected(true);
			}
			
			group.add(score);
			group.add(vie);
			
			typePanel.add(score);
			typePanel.add(vie);
			panel.add(typePanel);
			panel.add(Factory.addSpace(10));
			
			// AFFICHAGE //
			Player choosen = null;
			ArrayList<Player> liste = myGui.getListeJoueurs();
			Collections.sort(liste, new Comparator<Player>() {
				@Override
				public int compare(Player arg0, Player arg1) {
					if(type == 1) {
						return Integer.valueOf(arg1.getScore()).compareTo(arg0.getScore());
					} else {
						return Integer.valueOf(arg1.getVie()).compareTo(arg0.getVie());
					}
				}
			});
			
			JPanel classementPanel = Factory.addPanel();
			classementPanel.setMaximumSize(new Dimension(500, 40));
			JLabel positionHeader = Factory.addLabel("Rang", 15, true);
			positionHeader.setMaximumSize(new Dimension(100, 30));
			JLabel usernameHeader = Factory.addLabel("Username", 15, true);
			usernameHeader.setMaximumSize(new Dimension(250, 30));
			JLabel typeHeader = Factory.addLabel("", 15, true);
			typeHeader.setMaximumSize(new Dimension(150, 30));
			if(type == 1) {
				typeHeader.setText("Score");
			} else {
				typeHeader.setText("Vie");
			}
			classementPanel.add(positionHeader);
			classementPanel.add(usernameHeader);
			classementPanel.add(typeHeader);
			panel.add(classementPanel);
			panel.add(Factory.addSpace(10));
			
			int size = liste.size();
			JPanel[] userPanels = new JPanel[size];
			JLabel[] positionFields = new JLabel[size];
			JLabel[] usernameFields = new JLabel[size];
			JLabel[] valueFields = new JLabel[size];
			for(int i = 0; i < 10; i++) {
				if((i+((index-1)*10)) == size){
					break;
				}
				
				choosen = liste.get((i+((index-1)*10)));
				
				userPanels[((i+((index-1)*10)))] = Factory.addPanel();
				userPanels[((i+((index-1)*10)))].setMaximumSize(new Dimension(500, 40));
				
				positionFields[(i+((index-1)*10))] = Factory.addLabel(String.valueOf((i+((index-1)*10))+1), 16, true);
				positionFields[(i+((index-1)*10))].setMaximumSize(new Dimension(100, 30));
				
				usernameFields[(i+((index-1)*10))] = Factory.addLabel(choosen.getUsername(), 16, false);
				usernameFields[(i+((index-1)*10))].setMaximumSize(new Dimension(250, 30));
				
				valueFields[(i+((index-1)*10))] = Factory.addLabel("", 16, false);
				valueFields[(i+((index-1)*10))].setMaximumSize(new Dimension(130, 40));
				if(type == 1) {
					valueFields[(i+((index-1)*10))].setText(String.valueOf(choosen.getScore()));
				} else {
					valueFields[(i+((index-1)*10))].setText(String.valueOf(choosen.getVie()));
				}
				
				userPanels[(i+((index-1)*10))].add(positionFields[(i+((index-1)*10))]);
				userPanels[(i+((index-1)*10))].add(usernameFields[(i+((index-1)*10))]);
				userPanels[(i+((index-1)*10))].add(valueFields[(i+((index-1)*10))]);
				userPanels[(i+((index-1)*10))].add(Box.createRigidArea(new Dimension(20, 20)));
				
				panel.add(userPanels[(i+((index-1)*10))]);
				panel.add(Box.createRigidArea(new Dimension(20, 5)));
			}
			
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
						new Classement(myGui, frame).repaint(type, index-1);
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
						new Classement(myGui, frame).repaint(type, index+1);
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
