package Interface;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.Timer;

import Components.Factory;
import v1.Bulletin;
import v1.Player;

/**
 * Permet l'inscription de joueurs
 * @author Guillaume
 */
public class Inscription {
	protected GUI myGui;
	protected JFrame frame;
	protected static String[] licenceList = {"Informatique", "Mathématique"};
	
	/**
	 * Constructeur de la classe Inscription
	 * @param myGui - GUI à utiliser
	 * @param frame - Frame à utiliser
	 */
	public Inscription(GUI myGui, JFrame frame) {
		this.myGui = myGui;
		this.frame = frame;
	}
	
	/**
	 * Permet l'affichage de la page inscription
	 */
	public void repaint() {
		Container panel = frame.getContentPane();
		panel.removeAll();
		panel.revalidate();
		panel.add(Box.createRigidArea(new Dimension(720,10)));
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		
		// TITRE //
		JPanel pageInscription = Factory.addPanel();
		JLabel inscription = Factory.addLabel("Page d'inscription", 21, true);
		pageInscription.add(inscription);
		panel.add(pageInscription);
		
		panel.add(Factory.addSpace(40));
		
		// NOM
		JPanel nomPanel = Factory.addPanel();
		JLabel nomLabel = Factory.addLabel("Nom: ", 15, true);
		nomPanel.add(nomLabel);
		nomPanel.add(Box.createRigidArea(new Dimension(35, 35)));
		
		JTextField nomInput = Factory.addField(250, 25, true);
		nomPanel.add(nomInput);
		panel.add(nomPanel);
		
		// PRENOM
		JPanel prenomPanel = Factory.addPanel();
		JLabel prenomLabel = Factory.addLabel("Prénom: ", 15, true);
		prenomPanel.add(prenomLabel);
		prenomPanel.add(Box.createRigidArea(new Dimension(14, 35)));
		
		JTextField prenomInput = Factory.addField(250, 25, true);
		prenomPanel.add(prenomInput);
		panel.add(prenomPanel);
		
		// AGE
		JPanel agePanel = Factory.addPanel();
		JLabel ageLabel = Factory.addLabel("Age: ", 15, true);
		agePanel.add(ageLabel);
		agePanel.add(Box.createRigidArea(new Dimension(43, 35)));
		
		JSpinner ageInput = Factory.addSpiner(250, 25, 16, 30, 20);
		agePanel.add(ageInput);
		panel.add(agePanel);
		
		// MAIL
		JPanel mailPanel = Factory.addPanel();
		JLabel mailLabel = Factory.addLabel("Mail: ", 15, true);
		mailPanel.add(mailLabel);
		mailPanel.add(Box.createRigidArea(new Dimension(40,35)));
		
		JTextField inMail = Factory.addField(250, 25, true);
		mailPanel.add(inMail);
		panel.add(mailPanel);
		
		// LICENCE
		JPanel licencePanel = Factory.addPanel();
		JLabel licenceLabel = Factory.addLabel("Licence: ", 15, true);
		licencePanel.add(licenceLabel);
		licencePanel.add(Box.createRigidArea(new Dimension(15, 35)));
		
		JComboBox<String> licenceBox = Factory.addBox(licenceList, 250, 25);
		licencePanel.add(licenceBox);
		panel.add(licencePanel);

		panel.add(Factory.addSpace(20));
		
		// USERNAME
		JPanel usernamePanel = Factory.addPanel();
		JLabel usernameLabel = Factory.addLabel("Username: ", 15, true);
		usernamePanel.add(usernameLabel);
		usernamePanel.add(Box.createRigidArea(new Dimension(1, 35)));
		
		JTextField inUsername = Factory.addField(250, 25, true);
		usernamePanel.add(inUsername);
		panel.add(usernamePanel);
		
		
		// PASSWORD
		JPanel passwordPanel = Factory.addPanel();
		JLabel passwordLabel = Factory.addLabel("Password: ", 15, true);
		passwordPanel.add(passwordLabel);
		passwordPanel.add(Box.createRigidArea(new Dimension(5, 35)));
		
		JPasswordField inPassword = Factory.addPassField(250, 25);
		passwordPanel.add(inPassword);
		panel.add(passwordPanel);
		
		panel.add(Factory.addSpace(20));
		
		// NOTES //
		JPanel noteLabelPanel = Factory.addPanel();
		JLabel noteLabel = Factory.addLabel("Entrez vos moyennes (sur 20):", 15, true);
		noteLabelPanel.add(noteLabel);
		panel.add(noteLabelPanel);
		panel.add(Factory.addSpace(10));
		
		JPanel notePanel = new JPanel();
		notePanel.setLayout(new BoxLayout(notePanel, BoxLayout.LINE_AXIS));
		
		int numberOfFields = 15;
		JTextField[] fields = new JTextField[numberOfFields];
		for(int i = 0; i < fields.length; i++) {
			fields[i] = Factory.addField(30, 30, true);
			notePanel.add(fields[i]);
			notePanel.add(Box.createRigidArea(new Dimension(10, 10)));
		}
		
		panel.add(notePanel);
		
		panel.add(Box.createRigidArea(new Dimension(720,10)));
		
		// ERROR
		JPanel errorPanel = Factory.addPanel();
		JLabel errorLabel = Factory.addLabel("", 15, true);
		errorLabel.setForeground(Color.red);
		errorPanel.add(errorLabel);
		panel.add(errorPanel);
		
		panel.add(Box.createRigidArea(new Dimension(720,10)));
		
		// BOUTON : CONFIRMER
		JPanel confirmPanel = Factory.addPanel();
		JButton confirm = Factory.addButton("Confirmer", 100, 50);
		confirm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String nom = nomInput.getText();
				String prenom = prenomInput.getText();
				int age = (int) ageInput.getValue();
				String mail = inMail.getText();
				String licence = licenceBox.getSelectedItem().toString();
				String username = inUsername.getText();
				String password = String.valueOf(inPassword.getPassword());
				Bulletin newBulletin;
				int score = 0;
				
				if(nom.length() < 3) {
					errorLabel.setText("Erreur: Nom invalide (< 3 caractères)");
					return;
				} else if(nom.length() > 20) {
					errorLabel.setText("Erreur: Nom invalide (> 20 caractères)");
					return;
				} else if(prenom.length() < 3) {
					errorLabel.setText("Erreur: Prénom invalide (< 3 caractères)");
					return;
				} else if(prenom.length() > 20) {
					errorLabel.setText("Erreur: Prénom invalide (> 20 caractères");
					return;
				} else if(mail.length() < 3) {
					errorLabel.setText("Erreur: Mail invalide (< 3 caractères)");
					return;
				} else if(!isValid(mail)) {
					errorLabel.setText("Erreur: Mail invalide (Format incorrecte)"); 
					return;
				} else if(username.length() < 3) {
					errorLabel.setText("Erreur: Username invalide (< 3 caractères)");
					return;
				} else if(username.length() > 20) {
					errorLabel.setText("Erreur: Username invalide (> 20 caractères)");
					return;
				} else if(password.length() < 3) {
					errorLabel.setText("Erreur: Password invalide (< 3 caractères) ");
					return;
				} else {
					for(Player p : myGui.getListeJoueurs()) {
						if(p.getUsername().equals(username)) {
							errorLabel.setText("Erreur: Username déjà pris");
							return;
						} 
						if(p.getMail().equals(mail)) {
							errorLabel.setText("Erreur: Mail déjà pris");
							return;
						}
					}
	
					int note = -1;
					ArrayList<Integer> notes = new ArrayList<>();
					newBulletin = new Bulletin();
					
					for(int i = 0; i < numberOfFields; i++) {
						if(!fields[i].getText().isEmpty()) {
							try {
								note = Integer.parseInt(fields[i].getText());
							} catch (NumberFormatException e) {
								errorLabel.setText("Erreur: Entrez des moyennes valides");
								return;
							}
							
							if(note <= 20 && note >= 0) {
								score = score + note;
								notes.add(note);
							} else {
								errorLabel.setText("Erreur: Entrez des moyennes valides (Entre 0 et 20)");
								return;
							}
						}	
					}
					if(score == 0) {
						errorLabel.setText("Erreur: Entrez des moyennes");
						return;
					}
					newBulletin.setListeNote(notes);
				}
				confirmPanel.remove(confirm);
				errorLabel.setText("Utilisateur créé!");
				Player newPlayer = new Player(nom, prenom, age, mail, licence, username, password);
				newPlayer.setBulletin(newBulletin);
				newPlayer.setVie(score);
				myGui.addJoueur(newPlayer);
				
				ActionListener connexion = new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						new Connexion(myGui, frame).repaint();
					}
				};
				Timer timer = new Timer(1000, connexion);
				timer.start();
				timer.setRepeats(false);
			}	
		});
		confirmPanel.add(confirm);
		panel.add(confirmPanel);

		// BOUTON : RETOUR
		panel.add(Box.createVerticalGlue());
		JPanel retourPanel = Factory.addPanel();
		JButton back = Factory.addButton("Retour", 100, 40);
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				panel.revalidate();
				panel.repaint();
				new Start(myGui, frame).repaint();
			}
		});
		retourPanel.add(back);
		retourPanel.add(Box.createHorizontalGlue());
		panel.add(retourPanel);
		
		panel.repaint();
	}
	
	/**
	 * Vérifie le format d'une entrée e-mail
	 * @param email - L'entrée à vérifier
	 * @return true s'il s'agît bien d'un format e-mail, false sinon.
	 */
	static boolean isValid(String email) {
		String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		return email.matches(regex);
	}
}
