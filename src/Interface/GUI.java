package Interface;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

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
		frame.setTitle("Serious-Game by Bertherat Guillaume");
		frame.setSize(1024, 576);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
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
		for(Player p : listeJoueurs) {
			if(p.getID() == id) {
				return p;
			}
		}
		return null;
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
	
	public Defi getDefi(int id) {
		for(Defi d : listeDefis) {
			if(d.getId() == id) {
				return d;
			}
		}
		return null;
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

	// MAIN //
	public static void main(String[] args) {	
		JFrame frame = new JFrame();
		GUI myGui = new GUI(frame);
		myGui.addJoueur(new Player("Mister", "Guest", 19, "mail@test.com", "Informatique", "Guest", "123"));
		myGui.addJoueur(new Admin("Bertherat", "Guillaume", 19, "bertherat.guillaume@gmail.com", "Informatique", "Motzen", "123"));
		for(int i = 0; i < 21; i++) {
			myGui.addDefi(new Defi(new Question(String.valueOf(i), "Test", "Java"), myGui.getPlayer(1), myGui.getPlayer(2), 3));
			myGui.getListeDefis().get(i).getQuestion().addReponse(String.valueOf(i));
			myGui.getListeDefis().get(i).setReviewed(true);
		}
		
		new Start(myGui, frame).repaint();
	}
}
