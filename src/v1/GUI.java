package v1;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * La classe GUI permet la création de l'interface utilisateur, elle contient aussi le main()
 * @author Guillaume
 */
public class GUI{
	static JFrame frame = new JFrame();
	private static int idSession = 0;
	private static String[] licenceList = {"Informatique", "Mathématique"};
	private static ArrayList<Player> listeJoueurs = new ArrayList<>();
	
	/**
	 * Permet à l'utilisateur de se connecter
	 * @param frame - La frame principal
	 */
	private static void connect(JFrame frame) {
		if(idSession == 0) {
			Container panel = frame.getContentPane();
			panel.removeAll();
			panel.revalidate();
			panel.add(Box.createRigidArea(new Dimension(500,30)));
			panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
			
			JPanel pageConnexion = new JPanel();
			pageConnexion.setLayout(new BoxLayout(pageConnexion, BoxLayout.LINE_AXIS));
			JLabel connexion = new JLabel("Page de connexion");
			connexion.setFont(new Font("Arial", Font.BOLD, 21));
			pageConnexion.add(connexion);
			panel.add(pageConnexion);
			
			panel.add(Box.createRigidArea(new Dimension(500,100)));
			
			JPanel inputUsername = new JPanel();
			inputUsername.setLayout(new BoxLayout(inputUsername, BoxLayout.LINE_AXIS));
			
			// USERNAME 
			JLabel tagUsername = new JLabel("Username: ");
			tagUsername.setFont(new Font("Arial", Font.PLAIN, 16));
			tagUsername.setAlignmentX(Component.LEFT_ALIGNMENT);
			inputUsername.add(tagUsername);
			
			inputUsername.add(Box.createRigidArea(new Dimension(43,10)));
			
			JTextField inUsername = new JTextField();
			inUsername.setMaximumSize(new Dimension(200,30));
			inUsername.setMinimumSize(new Dimension(200,30));
			inUsername.setPreferredSize(new Dimension(200,30));
			inUsername.setAlignmentX(Component.LEFT_ALIGNMENT);
			inputUsername.add(inUsername);
			panel.add(inputUsername);
			
			panel.add(Box.createRigidArea(new Dimension(500,20)));
			
			// PASSWORD
			JPanel inputPassword = new JPanel();
			inputPassword.setLayout(new BoxLayout(inputPassword, BoxLayout.LINE_AXIS));
			
			JLabel tagPassword = new JLabel("Mot de passe: ");
			tagPassword.setFont(new Font("Arial", Font.PLAIN, 16));
			tagPassword.setAlignmentX(Component.LEFT_ALIGNMENT);
			inputPassword.add(tagPassword);
			
			inputPassword.add(Box.createRigidArea(new Dimension(20,10)));
			
			JTextField inPassword = new JTextField();
			inPassword.setMaximumSize(new Dimension(200,30));
			inPassword.setMinimumSize(new Dimension(200,30));
			inPassword.setPreferredSize(new Dimension(200,30));
			inPassword.setAlignmentX(Component.LEFT_ALIGNMENT);
			inputPassword.add(inPassword);
			panel.add(inputPassword);
			
			panel.add(Box.createRigidArea(new Dimension(500,30)));
			
			// BOUTON CONFIRMER
			JPanel confirmPanel = new JPanel();
			confirmPanel.setLayout(new BoxLayout(confirmPanel, BoxLayout.LINE_AXIS));
			
			JButton confirm = new JButton("Confirmer");
			confirm.setMaximumSize(new Dimension(100,50));
			confirm.setPreferredSize(new Dimension(100,50));
			confirm.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					Player selected = null;
					String username = inUsername.getText();
					for(Player p : listeJoueurs) {
						if(p.getUsername() == username) {
							selected = p;
							break;
						}
					}
					
					if(selected != null) {
						String password = inPassword.getText();
						if(selected.getPassword() == password) {
							idSession = selected.getID();
						}
					}
					
				}
			});
			confirmPanel.add(confirm);
			panel.add(confirmPanel);
			
			panel.add(Box.createVerticalGlue());
			
			// BOUTON RETOUR
			JPanel backPanel = new JPanel();
			backPanel.setLayout(new BoxLayout(backPanel, BoxLayout.LINE_AXIS));
			
			JButton back = new JButton("Retour");
			back.setMaximumSize(new Dimension(100,50));
			back.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					panel.removeAll();
					panel.revalidate();
					main(null);
				}
			});
			backPanel.add(back);
			backPanel.add(Box.createHorizontalGlue());
			panel.add(backPanel);
			
			panel.repaint();
		}
	}
	
	private static void inscription(JFrame frame) {
		if(idSession == 0) {
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
			
			panel.add(Box.createRigidArea(new Dimension(500,10)));
			
			// NOM
			JPanel nomPanel = new JPanel();
			nomPanel.setLayout(new BoxLayout(nomPanel, BoxLayout.LINE_AXIS));
			
			JLabel nomLabel = new JLabel("Nom: ");
			nomLabel.setFont(new Font("Arial", Font.PLAIN, 16));
			nomPanel.add(nomLabel);
			nomPanel.add(Box.createRigidArea(new Dimension(30,30)));
			
			JTextField nomInput = new JTextField();
			nomInput.setMaximumSize(new Dimension(200, 30));
			nomPanel.add(nomInput);
			panel.add(nomPanel);
			
			panel.add(Box.createRigidArea(new Dimension(500, 10)));
			
			// PRENOM
			JPanel prenomPanel = new JPanel();
			prenomPanel.setLayout(new BoxLayout(prenomPanel, BoxLayout.LINE_AXIS));
			
			JLabel prenomLabel = new JLabel("Prenom: ");
			prenomLabel.setFont(new Font("Arial", Font.PLAIN, 16));
			prenomPanel.add(prenomLabel);
			prenomPanel.add(Box.createRigidArea(new Dimension(10,30)));
			
			JTextField prenomInput = new JTextField();
			prenomInput.setMaximumSize(new Dimension(200, 30));
			prenomPanel.add(prenomInput);
			panel.add(prenomPanel);
			
			panel.add(Box.createRigidArea(new Dimension(500, 15)));
			
			// AGE
			JPanel ageLabelPanel = new JPanel();
			ageLabelPanel.setLayout(new BoxLayout(ageLabelPanel, BoxLayout.LINE_AXIS));
			
			JLabel ageLabel = new JLabel("Age:");
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
			panel.add(Box.createRigidArea(new Dimension(10,10)));
			
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
			
			// USERNAME
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
			
			// BOUTON : CONFIRMER
			JPanel confirmPanel = new JPanel();
			confirmPanel.setLayout(new BoxLayout(confirmPanel, BoxLayout.LINE_AXIS));
			
			JButton confirm = new JButton("Confirmer");
			confirm.setMaximumSize(new Dimension(100,50));
			confirmPanel.add(confirm);
			
			panel.add(confirmPanel);
			
			panel.add(Box.createVerticalGlue());
			// BOUTON : RETOUR
			JPanel backPanel = new JPanel();
			backPanel.setLayout(new BoxLayout(backPanel, BoxLayout.LINE_AXIS));
			
			JButton back = new JButton("Retour");
			back.setMaximumSize(new Dimension(100,30));
			back.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					panel.removeAll();
					panel.revalidate();
					main(null);
				}
			});
			backPanel.add(back);
			backPanel.add(Box.createHorizontalGlue());
			panel.add(backPanel);
			
			panel.repaint();
		}
	}
	
	
	// MAIN //
	public static void main(String[] args) {
		frame.setTitle("Serious-Game by Bertherat Guillaume");
		frame.setSize(500, 500);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		JPanel main = new JPanel();
		main.setLayout(new BoxLayout(main, BoxLayout.PAGE_AXIS));
		
		main.add(Box.createRigidArea(new Dimension(500,30)));
		
		// TITRE //
		JPanel titrePanel = new JPanel();
		titrePanel.setLayout(new BoxLayout(titrePanel, BoxLayout.LINE_AXIS));
		JLabel titre = new JLabel("Serious-Game");
		titre.setFont(new Font("Arial", Font.BOLD, 21));
		titrePanel.add(titre);
		main.add(titrePanel);
		
		
		// AUTEUR //
		JPanel authorPanel = new JPanel();
		authorPanel.setLayout(new BoxLayout(authorPanel, BoxLayout.LINE_AXIS));
		JLabel author = new JLabel("by Bertherat Guillaume");
		author.setFont(new Font("Arial", Font.PLAIN, 19));
		authorPanel.add(author);
		main.add(authorPanel);
		
		main.add(Box.createRigidArea(new Dimension(500,60)));
		
		
		// BOUTON SE CONNECTER
		JPanel buttonPanel1 = new JPanel();
		buttonPanel1.setLayout(new BoxLayout(buttonPanel1, BoxLayout.LINE_AXIS));
		JButton seConnecter = new JButton("Se connecter");
		seConnecter.setMaximumSize(new Dimension(150,50));
		seConnecter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				connect(frame);
			}
		});
		buttonPanel1.add(seConnecter);
		main.add(buttonPanel1);
		
		
		main.add(Box.createRigidArea(new Dimension(500,40)));
		
		
		// BOUTON S'INSCRIRE
		JPanel buttonPanel2 = new JPanel();
		buttonPanel2.setLayout(new BoxLayout(buttonPanel2, BoxLayout.LINE_AXIS));
		JButton sInscrire = new JButton("S'inscrire");
		sInscrire.setMaximumSize(new Dimension(150,50));
		sInscrire.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				inscription(frame);
			}
		});
		buttonPanel2.add(sInscrire);
		main.add(buttonPanel2);
		
		main.add(Box.createRigidArea(new Dimension(500,40)));
		
		// BOUTON QUITTER
		JPanel buttonPanel3 = new JPanel();
		buttonPanel3.setLayout(new BoxLayout(buttonPanel3, BoxLayout.LINE_AXIS));
		JButton quitter = new JButton("Quitter");
		quitter.setMaximumSize(new Dimension(150,50));
		quitter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));		
			}
		});
		buttonPanel3.add(quitter);
		main.add(buttonPanel3);
		
		frame.getContentPane().add(main);
		frame.setVisible(true);
		
	}
}
