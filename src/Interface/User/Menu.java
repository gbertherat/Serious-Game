package Interface.User;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Components.Factory;
import Interface.GUI;
import Interface.MainMenu;
import Interface.Admin.AdminPanel;
import v1.Defi;
import v1.Player;

/**
 * Fenêtre utilisateur principal
 * @author Guillaume
 */
public class Menu {
	// VARS //
	private GUI myGui;
	private JFrame frame;
	
	/**
	 * Constructeur de la classe Menu
	 * @param myGui - GUI à utiliser
	 * @param frame - Frame à utiliser
	 */
	public Menu(GUI myGui, JFrame frame) {
		this.myGui = myGui;
		this.frame = frame;
	}
	
	/**
	 * Permet l'affichage de la fenêtre
	 */
	public void repaint() {
		if(GUI.idSession != 0) {
			Player selected = myGui.getPlayer(GUI.idSession);
			
			// On récupère le panel principal
			Container panel = frame.getContentPane();
			panel.removeAll();
			panel.revalidate();
			panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
			panel.add(Factory.addSpace(50));
			
			// On vérifie que l'utilisateur n'a pas dépassé la date limite de réponse à un défi
			for(Defi d : myGui.getListeDefis()) {
				if(d.getDestinataire() == selected && d.isReviewed() && !d.isAccepte() && !d.isTermine()) {
					if(d.getDate().isBefore(LocalDateTime.now())) {
						d.setTermine(true); // Si la date est dépassé, il perds des points de vie et son score diminue
						selected.setVie(selected.getVie()-d.getPoints());
						selected.setScore(selected.getScore()-d.getPoints()*10);
					}
				}
			}
			
			// TITRE //
			JPanel titrePanel = Factory.addPanel();
			JLabel titre = Factory.addLabel("Serious-Game", 21, true);
			titrePanel.add(titre);
			panel.add(titrePanel);
			
			panel.add(Factory.addSpace(20));
			
			// USERNAME //
			JPanel userPanel = Factory.addPanel();
			JLabel user = Factory.addLabel("Utilisateur: " + selected.getUsername(), 16, false);
			userPanel.add(user);
			panel.add(userPanel);
			
			// BOUTON : PROFIL //
			JPanel profilPanel = Factory.addPanel();
			JButton profilButton = Factory.addButton("Mon profil", 150, 30);
			profilButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					new Profil(myGui, frame).repaint(GUI.idSession);
				}
			});
			profilPanel.add(profilButton);
			panel.add(profilPanel);

			// BOUTON : ADMIN PANEL //
			if(selected.isAdmin()) {
				JPanel adminPanel = Factory.addPanel();
				JButton adminButton = Factory.addButton("Administration", 150, 30);
				adminButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						new AdminPanel(myGui, frame).repaint();
					}
					
				});
				adminPanel.add(adminButton);
				panel.add(adminPanel);
			}
			
			panel.add(Factory.addSpace(30));
			
			// NOMBRE DE DEFI //
			JPanel nbDefiPanel = Factory.addPanel();
			
			int nbrDefi = 0;
			LocalDateTime dateFin = null;
			for(Defi d : myGui.getListeDefis()) {
				if(d.getDestinataire().getID() == GUI.idSession && d.isReviewed() && !d.isAccepte() && !d.isTermine()) {
					nbrDefi++;
					if(dateFin == null) {
						dateFin = d.getDateExpiration();
					} else if(d.getDateExpiration().isBefore(dateFin)) {
						dateFin = d.getDateExpiration();
					}
				}
			}
			
			JLabel nbDefi = Factory.addLabel("Vous avez " + nbrDefi + " défi(s) en attente.", 16, false);
			nbDefiPanel.add(nbDefi);
			panel.add(nbDefiPanel);
			
			// DATE EXPIRATION //
			if(dateFin != null) {
				JPanel datePanel = Factory.addPanel();
				
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy à HH:mm");
				String formattedString = dateFin.format(formatter);
				
				JLabel dateExp = Factory.addLabel("Attention: Un défi se termine le " + formattedString, 15, true);
				datePanel.add(dateExp);
				panel.add(datePanel);
			}
			
			// BOUTONS : LANCER UN DEFI && ACCEPTER DEFI //
			JPanel buttonsPanel = Factory.addPanel();
			JButton lancerDefi = Factory.addButton("Envoyer un défi", 150, 50);
			lancerDefi.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					(new SendQuestionPanel(myGui, frame)).repaint();
				}
			});
			buttonsPanel.add(lancerDefi);
			
			JButton accDefi = Factory.addButton("Accepter un défi", 150, 50);
			accDefi.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					new DefisPanel(myGui, frame).repaint(1);
				}
			});
			buttonsPanel.add(accDefi);
			panel.add(buttonsPanel);
			
			panel.add(Factory.addSpace(30));
			
			// BOUTON : CLASSEMENT //
			JPanel classementPanel = Factory.addPanel();
			JButton classementButton = Factory.addButton("Classement", 150, 50);
			classementButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					new Classement(myGui, frame).repaint(1, 1);
				}
			});
			classementPanel.add(classementButton);
			panel.add(classementPanel);
			
			panel.add(Factory.addSpace(30));
			
			// BOUTON : SE DECONNECTER //
			JPanel decoPanel = Factory.addPanel();
			
			JButton decoButton = Factory.addButton("Se déconnecter", 150, 50);
			decoButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					GUI.idSession = 0;
					panel.removeAll();
					panel.revalidate();
					new MainMenu(myGui, frame).repaint();
				}
			});
			decoPanel.add(decoButton);
			panel.add(decoPanel);
			
			panel.add(Factory.addSpace(30));
			
			// BOUTON : QUITER //
			JPanel quitPanel = Factory.addPanel();
			JButton quitButton = Factory.addButton("Quitter", 150, 50);
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
