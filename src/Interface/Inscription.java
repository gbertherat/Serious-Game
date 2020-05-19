package Interface;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
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
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

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
		panel.add(Box.createRigidArea(new Dimension(500,10)));
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		
		JPanel pageInscription = new JPanel();
		pageInscription.setLayout(new BoxLayout(pageInscription, BoxLayout.LINE_AXIS));
		JLabel inscription = new JLabel("Page d'inscription");
		inscription.setFont(new Font("Arial", Font.BOLD, 21));
		pageInscription.add(inscription);
		panel.add(pageInscription);
		
		panel.add(Box.createRigidArea(new Dimension(500,30)));
		
		// NOM
		JPanel nomPanel = new JPanel();
		nomPanel.setLayout(new BoxLayout(nomPanel, BoxLayout.LINE_AXIS));
		
		JLabel nomLabel = new JLabel("Nom: ");
		nomLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		nomPanel.add(nomLabel);
		nomPanel.add(Box.createRigidArea(new Dimension(30,30)));
		
		JTextField nomInput = new JTextField();
		nomInput.setMaximumSize(new Dimension(200, 20));
		nomPanel.add(nomInput);
		panel.add(nomPanel);
		
		// PRENOM
		JPanel prenomPanel = new JPanel();
		prenomPanel.setLayout(new BoxLayout(prenomPanel, BoxLayout.LINE_AXIS));
		
		JLabel prenomLabel = new JLabel("Prenom: ");
		prenomLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		prenomPanel.add(prenomLabel);
		prenomPanel.add(Box.createRigidArea(new Dimension(10,30)));
		
		JTextField prenomInput = new JTextField();
		prenomInput.setMaximumSize(new Dimension(200, 20));
		prenomPanel.add(prenomInput);
		panel.add(prenomPanel);
		
		panel.add(Box.createRigidArea(new Dimension(500, 15)));
		
		// AGE
		JPanel ageLabelPanel = new JPanel();
		ageLabelPanel.setLayout(new BoxLayout(ageLabelPanel, BoxLayout.LINE_AXIS));
		
		JLabel ageLabel = new JLabel("Age: 20");
		ageLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		ageLabelPanel.add(ageLabel);
		panel.add(ageLabelPanel);
		
		JPanel agePanel = new JPanel();
		agePanel.setLayout(new BoxLayout(agePanel, BoxLayout.LINE_AXIS));
		
		JSlider ageInput = new JSlider(JSlider.HORIZONTAL, 16, 30, 20);
		ageInput.setMajorTickSpacing(1);
		ageInput.setMinorTickSpacing(1);
		ageInput.setPaintTicks(true);
		ageInput.setPaintLabels(true);
		ageInput.setMaximumSize(new Dimension(300,50));
		ageInput.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent arg0) {
				ageLabel.setText("Age: " + String.valueOf(ageInput.getValue()));
			}
		});
		agePanel.add(ageInput);
		panel.add(agePanel);
		
		panel.add(Box.createRigidArea(new Dimension(500, 10)));
		
		// MAIL
		JPanel mailPanel = new JPanel();
		mailPanel.setLayout(new BoxLayout(mailPanel, BoxLayout.LINE_AXIS));
	
		JLabel mailLabel = new JLabel("Mail: ");
		mailLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		mailPanel.add(mailLabel);
		mailPanel.add(Box.createRigidArea(new Dimension(40,10)));
		
		JTextField inMail = new JTextField();
		inMail.setMaximumSize(new Dimension(200, 30));
		mailPanel.add(inMail);
		panel.add(mailPanel);
		
		panel.add(Box.createRigidArea(new Dimension(500, 10)));
		
		// LICENCE
		JPanel licenceLabelPanel = new JPanel();
		licenceLabelPanel.setLayout(new BoxLayout(licenceLabelPanel, BoxLayout.LINE_AXIS));
		
		JLabel licenceLabel = new JLabel("Licence:");
		licenceLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		licenceLabelPanel.add(licenceLabel);
		panel.add(licenceLabelPanel);
		
		JPanel licencePanel = new JPanel();
		licencePanel.setLayout(new BoxLayout(licencePanel, BoxLayout.LINE_AXIS));
		
		JComboBox<String> licenceBox = new JComboBox<String>(licenceList);
		licenceBox.setSelectedIndex(0);
		licenceBox.setMaximumSize(new Dimension(200,20));
		licenceBox.add(licencePanel);
		panel.add(licenceBox);
		
		panel.add(Box.createRigidArea(new Dimension(500, 10)));
		
		// USERNAME
		JPanel usernamePanel = new JPanel();
		usernamePanel.setLayout(new BoxLayout(usernamePanel, BoxLayout.LINE_AXIS));
		
		JLabel usernameLabel = new JLabel("Username: ");
		usernameLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		usernamePanel.add(usernameLabel);
		
		JTextField inUsername = new JTextField();
		inUsername.setMaximumSize(new Dimension(200,30));
		usernamePanel.add(inUsername);
		panel.add(usernamePanel);
		
		panel.add(Box.createRigidArea(new Dimension(500, 5)));
		
		// PASSWORD
		JPanel passwordPanel = new JPanel();
		passwordPanel.setLayout(new BoxLayout(passwordPanel, BoxLayout.LINE_AXIS));
		
		JLabel passwordLabel = new JLabel("Password: ");
		passwordLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		passwordPanel.add(passwordLabel);
		passwordPanel.add(Box.createRigidArea(new Dimension(2,5)));
		
		JTextField inPassword = new JTextField();
		inPassword.setMaximumSize(new Dimension(200,30));
		passwordPanel.add(inPassword);
		panel.add(passwordPanel);
		
		panel.add(Box.createRigidArea(new Dimension(500,10)));
		
		// NOTES //
		JPanel noteLabelPanel = new JPanel();
		noteLabelPanel.setLayout(new BoxLayout(noteLabelPanel, BoxLayout.LINE_AXIS));
		JLabel noteLabel = new JLabel("Entrez vos moyennes:");
		noteLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		noteLabelPanel.add(noteLabel);
		panel.add(noteLabelPanel);
		
		JPanel notePanel = new JPanel();
		notePanel.setLayout(new BoxLayout(notePanel, BoxLayout.LINE_AXIS));
		
		int numberOfFields = 15;
		JTextField[] fields = new JTextField[numberOfFields];
		for(int i = 0; i < fields.length; i++) {
			fields[i] = new JTextField();
			fields[i].setMaximumSize(new Dimension(25,20));
			notePanel.add(fields[i]);
		}
		
		panel.add(notePanel);
		
		panel.add(Box.createRigidArea(new Dimension(500,10)));
		
		// ERROR
		JPanel errorPanel = new JPanel();
		errorPanel.setLayout(new BoxLayout(errorPanel, BoxLayout.LINE_AXIS));
		
		JLabel errorLabel = new JLabel();
		errorLabel.setLayout(new BoxLayout(errorLabel, BoxLayout.LINE_AXIS));
		errorLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		errorLabel.setForeground(Color.red);
		errorPanel.add(errorLabel);
		panel.add(errorPanel);
		
		// BOUTON : CONFIRMER
		JPanel confirmPanel = new JPanel();
		confirmPanel.setLayout(new BoxLayout(confirmPanel, BoxLayout.LINE_AXIS));
		
		JButton confirm = new JButton("Confirmer");
		confirm.setMaximumSize(new Dimension(100,50));
		confirm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String nom = nomInput.getText();
				String prenom = prenomInput.getText();
				int age = ageInput.getValue();
				String mail = inMail.getText();
				String licence = licenceBox.getSelectedItem().toString();
				String username = inUsername.getText();
				String password = inPassword.getText();
				Bulletin newBulletin;
				int score = 0;
				
				if(nom.length() < 3) {
					errorLabel.setText("Erreur: Nom invalide (< 3 caractères)");
					return;
				} else if(prenom.length() < 3) {
					errorLabel.setText("Erreur: Prénom invalide (< 3 caractères)");
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
								errorLabel.setText("Erreur: Entrez des moyennes valides");
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
		JPanel backPanel = new JPanel();
		backPanel.setLayout(new BoxLayout(backPanel, BoxLayout.LINE_AXIS));
		
		JButton back = new JButton("Retour");
		back.setMaximumSize(new Dimension(100,30));
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				panel.revalidate();
				myGui.repaint();
			}
		});
		backPanel.add(back);
		backPanel.add(Box.createHorizontalGlue());
		panel.add(backPanel);
		
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
