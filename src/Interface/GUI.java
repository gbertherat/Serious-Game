package Interface;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import v1.Admin;
import v1.Defi;
import v1.Player;
import v1.Question;

/**
 * La classe GUI permet la création de l'interface utilisateur, elle contient aussi le main()
 * @author Guillaume
 */
public class GUI{
	protected JFrame frame;
	protected ArrayList<Player> listeJoueurs;
	protected ArrayList<Defi> listeDefis;
	protected ArrayList<Question> listeQuestions;
	public String[] categories = {"C", "Python", "Java", "Réseaux", "Autre"};
	protected static int idSession = 0;
	
	public GUI(JFrame frame) {
		this.listeJoueurs = new ArrayList<>();
		this.listeDefis = new ArrayList<>();
		this.listeQuestions = new ArrayList<>();
		this.frame = frame;
	}
	
	// LISTE JOUEURS //
	/**
	 * Permet de récupérer la liste des joueurs
	 * @return la liste des joueurs
	 */
	public ArrayList<Player> getListeJoueurs() {
		return listeJoueurs;
	}

	/**
	 * Permet de définir la liste des joueurs
	 * @param listeJoueurs - la liste à définir
	 */
	public void setListeJoueurs(ArrayList<Player> listeJoueurs) {
		this.listeJoueurs = listeJoueurs;
	}
	
	public Player getPlayer(int id) {
		Player toReturn = null;
		for(Player p : listeJoueurs) {
			if(p.getID() == id) {
				return p;
			}
		}
		return toReturn;
	}
	
	public void addJoueur(Player player) {
		this.listeJoueurs.add(player);
	}
	
	public void delJoueur(Player player) {
		this.listeJoueurs.remove(player);
	}
	
	// LISTE JOUEURS //
	/**
	 * Permet de récupérer la liste des joueurs
	 * @return la liste des joueurs
	 */
	public ArrayList<Defi> getListeDefis() {
		return listeDefis;
	}

	/**
	 * Permet de définir la liste des joueurs
	 * @param listeJoueurs - la liste à définir
	 */
	public void setListeDefis(ArrayList<Defi> listeDefis) {
		this.listeDefis = listeDefis;
	}
	
	/**
	 * Permet d'ajouter un défi à la liste des défis
	 * @param defi - Le défi à ajouter
	 */
	public void addDefi(Defi defi) {
		this.listeDefis.add(defi);
	}
	
	/**
	 * Permet de supprimer un défi de la liste des défis
	 * @param defi - Le défi à supprimer
	 */
	public void delDefi(Defi defi) {
		this.listeDefis.remove(defi);
	}
	
	/**
	 * Permet de récupérer la liste des questions
	 * @return listeQuestions - La liste des questions
	 */
	public ArrayList<Question> getListeQuestions() {
		return listeQuestions;
	}

	/**
	 * Permet de définir la liste des questions
	 * @param listeQuestions - La liste à définir
	 */
	public void setListeQuestions(ArrayList<Question> listeQuestions) {
		this.listeQuestions = listeQuestions;
	}
	
	public void addQuestion(Question question) {
		listeQuestions.add(question);
	}
	
	public void delQuestion(Question question) {
		listeQuestions.remove(question);
	}

	/**
	 * Permet l'affichage du menu principale
	 */
	public void repaint() {
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
		
		
		// BOUTON: SE CONNECTER
		Connexion pageConnexion = new Connexion(this, frame);
		
		JPanel buttonPanel1 = new JPanel();
		buttonPanel1.setLayout(new BoxLayout(buttonPanel1, BoxLayout.LINE_AXIS));
		JButton seConnecter = new JButton("Se connecter");
		seConnecter.setMaximumSize(new Dimension(150,50));
		seConnecter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(idSession == 0) {
					pageConnexion.repaint();
				}
			}
		});
		buttonPanel1.add(seConnecter);
		main.add(buttonPanel1);
		
		main.add(Box.createRigidArea(new Dimension(500,40)));
		
		// BOUTON S'INSCRIRE
		Inscription pageInscription = new Inscription(this, frame);
		
		JPanel buttonPanel2 = new JPanel();
		buttonPanel2.setLayout(new BoxLayout(buttonPanel2, BoxLayout.LINE_AXIS));
		JButton sInscrire = new JButton("S'inscrire");
		sInscrire.setMaximumSize(new Dimension(150,50));
		sInscrire.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(idSession == 0) {
					pageInscription.repaint();
				}
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

	// MAIN //
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		GUI myGui = new GUI(frame);
		myGui.addJoueur(new Player("Mister", "Guest", 19, "mail@test.com", "Informatique", "Guest", "123"));
		myGui.addJoueur(new Admin("Bertherat", "Guillaume", 19, "bertherat.guillaume@gmail.com", "Informatique", "Motzen", "123"));
		for(int i = 0; i < 21; i++) {
			myGui.addDefi(new Defi(new Question(String.valueOf(i), "Test", "Java"), myGui.getPlayer(1), myGui.getPlayer(2), 10));
			myGui.getListeDefis().get(i).getQuestion().addReponse("Test: " + String.valueOf(i));
		}
		
		myGui.repaint();
	}
}
