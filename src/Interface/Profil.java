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
		panel.add(Box.createRigidArea(new Dimension(500,30)));
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		
		Player selected = myGui.getPlayer(GUI.idSession);
		
		// TITRE //
		JPanel titrePanel = new JPanel();
		titrePanel.setLayout(new BoxLayout(titrePanel, BoxLayout.LINE_AXIS));
		JLabel titre = new JLabel("Serious-Game");
		titre.setFont(new Font("Arial", Font.BOLD, 21));
		titrePanel.add(titre);
		panel.add(titrePanel);
		
		panel.add(Box.createRigidArea(new Dimension(500,30)));
		
		// PROFIL DE //
		JPanel headPanel = new JPanel();
		headPanel.setLayout(new BoxLayout(headPanel, BoxLayout.LINE_AXIS));
		JLabel headLabel = new JLabel("Profil de: ");
		headLabel.setFont(new Font("Arial", Font.BOLD, 16));
		headPanel.add(headLabel);
		
		JLabel nameLabel = new JLabel(selected.getNom() + " " + selected.getPrenom());
		nameLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		headPanel.add(nameLabel);
		panel.add(headPanel);
		
		panel.add(Box.createRigidArea(new Dimension(500, 10)));
		
		// USERNAME //
		JPanel usernamePanel = new JPanel();
		usernamePanel.setLayout(new BoxLayout(usernamePanel, BoxLayout.LINE_AXIS));
		usernamePanel.setMaximumSize(new Dimension(500, 30));
		usernamePanel.add(Box.createRigidArea(new Dimension(20, 20)));
		
		JLabel usernameLabel = new JLabel("Username: ");
		usernameLabel.setFont(new Font("Arial", Font.BOLD, 16));
		usernamePanel.add(usernameLabel);
		
		JLabel userLabel = new JLabel(selected.getUsername());
		userLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		usernamePanel.add(userLabel);
		panel.add(usernamePanel);
		
		// MAIL //
		JPanel mailPanel = new JPanel();
		mailPanel.setLayout(new BoxLayout(mailPanel, BoxLayout.LINE_AXIS));
		mailPanel.setMaximumSize(new Dimension(500, 30));
		mailPanel.add(Box.createRigidArea(new Dimension(20, 20)));
		
		JLabel mailLabel = new JLabel("Mail: ");
		mailLabel.setFont(new Font("Arial", Font.BOLD, 16));
		mailPanel.add(mailLabel);
		
		JLabel mail = new JLabel(selected.getMail());
		mail.setFont(new Font("Arial", Font.PLAIN, 16));
		mailPanel.add(mail);
		panel.add(mailPanel);
		
		panel.add(Box.createRigidArea(new Dimension(500, 20)));
		
		// NOMBRE DEFI //
		int defi = 0;
		int defiAcc = 0;
		int defiReussi = 0;
		for(Defi d : myGui.getListeDefis()) {
			if(d.getDestinataire().getID() == GUI.idSession && d.isReviewed()){
				defi++;
				if(d.isAccepte()) {
					defiAcc++;
				}
				if(d.isTermine()) {
					defiReussi++;
				}
			}
		}
		
		// NB DEFI RECU //
		JPanel nbDefiPanel1 = new JPanel();
		nbDefiPanel1.setLayout(new BoxLayout(nbDefiPanel1, BoxLayout.LINE_AXIS));
		nbDefiPanel1.setMaximumSize(new Dimension(500, 30));
		nbDefiPanel1.add(Box.createRigidArea(new Dimension(20, 20)));
		
		JLabel DefiRecu = new JLabel("Nombre de défis reçus: ");
		DefiRecu.setFont(new Font("Arial", Font.BOLD, 16));
		nbDefiPanel1.add(DefiRecu);
		
		JLabel nbDefiRecu = new JLabel(String.valueOf(defi));
		nbDefiRecu.setFont(new Font("Arial", Font.PLAIN, 16));
		nbDefiPanel1.add(nbDefiRecu);
		panel.add(nbDefiPanel1);
		
		// NB DEFI ACCEPTE //
		JPanel nbDefiPanel2 = new JPanel();
		nbDefiPanel2.setLayout(new BoxLayout(nbDefiPanel2, BoxLayout.LINE_AXIS));
		nbDefiPanel2.setMaximumSize(new Dimension(500, 30));
		nbDefiPanel2.add(Box.createRigidArea(new Dimension(20, 20)));
		
		JLabel DefiAcc = new JLabel("Nombre de défis acceptés: ");
		DefiAcc.setFont(new Font("Arial", Font.BOLD, 16));
		nbDefiPanel2.add(DefiAcc);
		
		JLabel nbDefiAcc = new JLabel(String.valueOf(defiAcc));
		nbDefiAcc.setFont(new Font("Arial", Font.PLAIN, 16));
		nbDefiPanel2.add(nbDefiAcc);
		panel.add(nbDefiPanel2);
		
		// NB DEFI REUSSI //
		JPanel nbDefiPanel3 = new JPanel();
		nbDefiPanel3.setLayout(new BoxLayout(nbDefiPanel3, BoxLayout.LINE_AXIS));
		nbDefiPanel3.setMaximumSize(new Dimension(500, 30));
		nbDefiPanel3.add(Box.createRigidArea(new Dimension(20, 20)));
		
		JLabel DefiReussi = new JLabel("Nombre de défis réussis: ");
		DefiReussi.setFont(new Font("Arial", Font.BOLD, 16));
		nbDefiPanel3.add(DefiReussi);
		
		JLabel nbDefiReussi = new JLabel(String.valueOf(defiReussi));
		nbDefiReussi.setFont(new Font("Arial", Font.PLAIN, 16));
		nbDefiPanel3.add(nbDefiReussi);
		panel.add(nbDefiPanel3);
		
		panel.add(Box.createRigidArea(new Dimension(500, 20)));
		
		// SCORE //
		JPanel scorePanel = new JPanel();
		scorePanel.setLayout(new BoxLayout(scorePanel, BoxLayout.LINE_AXIS));
		scorePanel.setMaximumSize(new Dimension(500, 30));
		scorePanel.add(Box.createRigidArea(new Dimension(20, 20)));
		
		JLabel scoreLabel = new JLabel("Score: ");
		scoreLabel.setFont(new Font("Arial", Font.BOLD, 16));
		scorePanel.add(scoreLabel);
		
		JLabel score = new JLabel(String.valueOf(defiReussi*10));
		score.setFont(new Font("Arial", Font.PLAIN, 16));
		scorePanel.add(score);
		panel.add(scorePanel);
		
		// VIE //
		JPanel viePanel = new JPanel();
		viePanel.setLayout(new BoxLayout(viePanel, BoxLayout.LINE_AXIS));
		viePanel.setMaximumSize(new Dimension(500, 30));
		viePanel.add(Box.createRigidArea(new Dimension(20, 20)));
		
		JLabel vieLabel = new JLabel("Vie: ");
		vieLabel.setFont(new Font("Arial", Font.BOLD, 16));
		viePanel.add(vieLabel);
		
		JLabel vie = new JLabel(String.valueOf(selected.getVie()));
		vie.setFont(new Font("Arial", Font.PLAIN, 16));
		viePanel.add(vie);
		panel.add(viePanel);
		
		// BOUTON : RETOUR //
		Menu newMenu = new Menu(myGui, frame);
		JPanel retourPanel = new JPanel();
		retourPanel.setLayout(new BoxLayout(retourPanel, BoxLayout.LINE_AXIS));
		
		JButton butRetour = new JButton("Retour");
		butRetour.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				newMenu.repaint();
			}
		});
		retourPanel.add(Box.createVerticalGlue());
		retourPanel.add(butRetour);
		retourPanel.add(Box.createHorizontalGlue());
		panel.add(retourPanel);
		
		panel.repaint();
	}
}
