package Interface;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.time.LocalDate;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import v1.Defi;
import v1.Player;

public class Menu {
	private GUI myGui;
	private JFrame frame;
	
	public Menu(GUI myGui, JFrame frame) {
		this.myGui = myGui;
		this.frame = frame;
	}
	
	void repaint() {
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
			JLabel titre = new JLabel("Serious-Game");
			titre.setFont(new Font("Arial", Font.BOLD, 21));
			titrePanel.add(titre);
			panel.add(titrePanel);
			
			panel.add(Box.createRigidArea(new Dimension(500,20)));
			
			// USERNAME //
			JPanel userPanel = new JPanel();
			userPanel.setLayout(new BoxLayout(userPanel, BoxLayout.LINE_AXIS));
			JLabel user = new JLabel("Utilisateur: " + selected.getNom() + " " + selected.getPrenom());
			user.setFont(new Font("Arial", Font.PLAIN, 16));
			userPanel.add(user);
			panel.add(userPanel);
			
			panel.add(Box.createRigidArea(new Dimension (500,5)));
			
			// BOUTON : PROFIL //
			Profil myProfil = new Profil(myGui, frame);
			
			JPanel profilPanel = new JPanel();
			profilPanel.setLayout(new BoxLayout(profilPanel, BoxLayout.LINE_AXIS));
			JButton profilButton = new JButton("Mon profil");
			profilButton.setMaximumSize(new Dimension(150, 25));
			profilButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					myProfil.repaint();
				}
			});
			profilPanel.add(profilButton);
			panel.add(profilPanel);
			
			panel.add(Box.createRigidArea(new Dimension (500,5)));
			
			// BOUTON : ADMIN PANEL //
			if(selected.getClass().getSimpleName().equals("Admin")) {
				JPanel adminPanel = new JPanel();
				adminPanel.setLayout(new BoxLayout(adminPanel, BoxLayout.LINE_AXIS));
				
				JButton adminButton = new JButton("Administration");
				adminButton.setMaximumSize(new Dimension(150, 25));
				adminButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						new Administration(myGui, frame).repaint();
					}
					
				});
				adminPanel.add(adminButton);
				panel.add(adminPanel);
				panel.add(Box.createRigidArea(new Dimension (500,5)));
			}
			
			panel.add(Box.createRigidArea(new Dimension (500,20)));
			
			// BOUTONS : LANCER UN DEFI && ACCEPTER DEFI //
			JPanel buttonsPanel = new JPanel();
			buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.LINE_AXIS));
			
			JButton lancerDefi = new JButton("Lancer un défi");
			lancerDefi.setMaximumSize(new Dimension(150,50));
			lancerDefi.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					(new LancerDefi(myGui, frame)).repaint();
				}
			});
			buttonsPanel.add(lancerDefi);
			buttonsPanel.add(Box.createRigidArea(new Dimension(10, 20)));
			
			JButton accDefi = new JButton("Accepter un défi");
			accDefi.setMaximumSize(new Dimension(150,50));
			buttonsPanel.add(accDefi);
			
			panel.add(buttonsPanel);
			panel.add(Box.createRigidArea(new Dimension(500,10)));
			
			// NOMBRE DE DEFI //
			JPanel nbDefiPanel = new JPanel();
			nbDefiPanel.setLayout(new BoxLayout(nbDefiPanel, BoxLayout.LINE_AXIS));
			
			int nbrDefi = 0;
			LocalDate dateFin = null;
			for(Defi d : myGui.getListeDefis()) {
				if(d.getDestinataire().getID() == GUI.idSession && !d.isAccepte() && d.isReviewed()) {
					nbrDefi++;
					if(dateFin != null && d.getDateExpiration().isBefore(dateFin)) {
						dateFin = d.getDateExpiration();
					}
				}
			}
			
			JLabel nbDefi = new JLabel("Vous avez " + nbrDefi + " défi(s) en attente.");
			nbDefi.setFont(new Font("Arial", Font.PLAIN, 16));
			nbDefiPanel.add(nbDefi);
			panel.add(nbDefiPanel);
			
			// DATE EXPIRATION //
			if(dateFin != null) {
				JPanel datePanel = new JPanel();
				datePanel.setLayout(new BoxLayout(datePanel, BoxLayout.LINE_AXIS));
				
				JLabel dateExp = new JLabel("Attention: Un défi se termine le " + dateFin.toString() + " !");
				dateExp.setFont(new Font("Arial", Font.BOLD, 15));
				datePanel.add(dateExp);
				panel.add(datePanel);
			}
			
			panel.add(Box.createRigidArea(new Dimension(500, 10)));
			
			// BOUTON : SE DECONNECTER //
			JPanel decoPanel = new JPanel();
			decoPanel.setLayout(new BoxLayout(decoPanel, BoxLayout.LINE_AXIS));
			
			JButton decoButton = new JButton("Se déconnecter");
			decoButton.setMaximumSize(new Dimension(150,50));
			decoButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					GUI.idSession = 0;
					panel.removeAll();
					panel.revalidate();
					myGui.repaint();
				}
				
			});
			decoPanel.add(decoButton);
			panel.add(decoPanel);
			
			panel.add(Box.createRigidArea(new Dimension(500,20)));
			
			// BOUTON : QUITER //
			JPanel quitPanel = new JPanel();
			quitPanel.setLayout(new BoxLayout(quitPanel, BoxLayout.LINE_AXIS));
			
			JButton quitButton = new JButton("Quitter");
			quitButton.setMaximumSize(new Dimension(150,50));
			quitButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));		
				}
			});
			quitPanel.add(quitButton);
			panel.add(quitPanel);
			
			panel.repaint();
		}
	}
	
}
