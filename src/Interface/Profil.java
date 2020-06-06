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
import v1.Defi;
import v1.Player;

public class Profil {
	GUI myGui;
	JFrame frame;
	
	public Profil(GUI myGui, JFrame frame) {
		this.myGui = myGui;
		this.frame = frame;
	}
	
	public void repaint() {
		Container panel = frame.getContentPane();
		panel.removeAll();
		panel.revalidate();
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		panel.add(Factory.addSpace(50));
		
		Player selected = myGui.getPlayer(GUI.idSession);
		
		// TITRE //
		JPanel titrePanel = Factory.addPanel();
		JLabel titre = Factory.addLabel("Serious-Game", 21, true);
		titrePanel.add(titre);
		panel.add(titrePanel);
		
		panel.add(Factory.addSpace(20));
		
		// PROFIL DE //
		JPanel headPanel = Factory.addPanel();
		JLabel headLabel = Factory.addLabel("Profil de: ", 18, true);
		headPanel.add(headLabel);
		
		JLabel nameLabel = Factory.addLabel(selected.getUsername(), 18, false);
		headPanel.add(nameLabel);
		panel.add(headPanel);
		panel.add(Factory.addSpace(20));
		
		// MAIL //
		JPanel mailPanel = Factory.addPanel();
		mailPanel.setMaximumSize(new Dimension(500, 30));
		JLabel mailLabel = Factory.addLabel("Mail: ", 18, true);
		mailPanel.add(mailLabel);
		JLabel mail = Factory.addLabel(selected.getMail(), 18, false);
		mailPanel.add(mail);
		panel.add(mailPanel);
		panel.add(Factory.addSpace(10));
		
		// NOMBRE DEFI //
		int defi = 0;
		int defiAcc = 0;
		for(Defi d : myGui.getListeDefis()) {
			if(d.getDestinataire().getID() == GUI.idSession && d.isReviewed()){
				defi++;
				if(d.isAccepte()) {
					defiAcc++;
				}
			}
		}
		
		// NB DEFI RECU //
		JPanel nbDefiPanel1 = Factory.addPanel();
		nbDefiPanel1.setMaximumSize(new Dimension(500, 30));
		JLabel DefiRecu = Factory.addLabel("Nombre de défis reçus: ", 18, true);
		nbDefiPanel1.add(DefiRecu);
		
		JLabel nbDefiRecu = Factory.addLabel(String.valueOf(defi), 18, false);
		nbDefiPanel1.add(nbDefiRecu);
		panel.add(nbDefiPanel1);
		
		panel.add(Factory.addSpace(10));
		
		// NB DEFI ACCEPTE //
		JPanel nbDefiPanel2 = Factory.addPanel();
		nbDefiPanel2.setMaximumSize(new Dimension(500, 30));
		
		JLabel DefiAcc = Factory.addLabel("Nombre de défis acceptés: ", 18, true);
		nbDefiPanel2.add(DefiAcc);
		
		JLabel nbDefiAcc = Factory.addLabel(String.valueOf(defiAcc), 18, false);
		nbDefiPanel2.add(nbDefiAcc);
		panel.add(nbDefiPanel2);
		
		panel.add(Factory.addSpace(10));
		
		// NB DEFI REUSSI //
		JPanel nbDefiPanel3 = Factory.addPanel();
		nbDefiPanel3.setMaximumSize(new Dimension(500, 30));
		JLabel DefiReussi = Factory.addLabel("Nombre de défis réussis: ", 18, true);
		nbDefiPanel3.add(DefiReussi);
		
		JLabel nbDefiReussi = Factory.addLabel(String.valueOf(selected.getDefisReussis()), 18, false);
		nbDefiPanel3.add(nbDefiReussi);
		panel.add(nbDefiPanel3);

		panel.add(Factory.addSpace(30));
		
		// SCORE //
		JPanel scorePanel = Factory.addPanel();
		scorePanel.setMaximumSize(new Dimension(400, 30));
		JLabel scoreLabel = Factory.addLabel("Score: ", 18, true);
		scorePanel.add(scoreLabel);
		
		JLabel score = Factory.addLabel(String.valueOf(selected.getScore()), 18, false);
		scorePanel.add(score);
		panel.add(scorePanel);
		
		panel.add(Factory.addSpace(10));
		
		// VIE //
		JPanel viePanel = Factory.addPanel();
		viePanel.setMaximumSize(new Dimension(400, 30));
		JLabel vieLabel = Factory.addLabel("Vie: ", 18, true);
		viePanel.add(vieLabel);
		
		JLabel vie = Factory.addLabel(String.valueOf(selected.getVie()), 18, false);
		viePanel.add(vie);
		panel.add(viePanel);
		
		panel.add(Factory.addSpace(10));
		
		// BOUTON : RETOUR
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
