package Interface;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

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
	public static int idSession = 0;
	
	public GUI(JFrame frame) {
		this.listeJoueurs = new ArrayList<>();
		this.listeDefis = new ArrayList<>();
		this.listeQuestions = new ArrayList<>();
		this.frame = frame;
		
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
	
	/**
	 * Permet de récupérer un joueur grâce à son ID
	 * @param id - L'id du joueur
	 * @return Le joueur s'il existe, null sinon
	 */
	public Player getPlayer(int id) {
		for(Player p : listeJoueurs) {
			if(p.getID() == id) {
				return p;
			}
		}
		return null;
	}
	
	/**
	 * Permet d'ajouter un joueur à la liste des joueurs
	 * @param player - Le jouer à ajouter
	 */
	public void addJoueur(Player player) {
		this.listeJoueurs.add(player);
	}
	
	/**
	 * Permet de supprimer un joueur de la liste des joueurs
	 * @param player - Le joueur à supprimer
	 */
	public void delJoueur(Player player) {
		this.listeJoueurs.remove(player);
	}
	
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
	
	/**
	 * Permet d'ajouter une question à la liste des questions
	 * @param question - La question à ajouter
	 */
	public void addQuestion(Question question) {
		listeQuestions.add(question);
	}
	
	/**
	 * Permet de supprimer une question de la liste des questions
	 * @param question - La question à supprimer
	 */
	public void delQuestion(Question question) {
		listeQuestions.remove(question);
	}
	
	public Question getQuestion(int id) {
		for(Question q : listeQuestions) {
			if(q.getID() == id) {
				return q;
			}
		}
		return null;
	}
	
	public void saveAll() {
		try {
			new File("ser/data.ser").delete();
			FileOutputStream saveFile = new FileOutputStream("ser/data.ser");
			ObjectOutputStream out = new ObjectOutputStream(saveFile);
			
			out.writeObject(this.getListeJoueurs());
			out.writeObject(this.getListeQuestions());
			out.writeObject(this.getListeDefis());
			
			out.close();
			saveFile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public void loadAll() {
		try {		
			FileInputStream saveFile = new FileInputStream("ser/data.ser");		
			ObjectInputStream in = new ObjectInputStream(saveFile);
			
			Object joueurs = new ArrayList<>();
			ArrayList<Question> questions = new ArrayList<>();
			ArrayList<Defi> defis = new ArrayList<>();
			
			joueurs = (ArrayList<Player>) in.readObject();
			questions = (ArrayList<Question>) in.readObject();
			defis = (ArrayList<Defi>) in.readObject();
			
			this.setListeJoueurs((ArrayList<Player>) joueurs);
			this.setListeQuestions(questions);
			this.setListeDefis(defis);
			
			if(this.getListeJoueurs().size() > 0) {
				Player.setCount(this.getListeJoueurs().get(this.getListeJoueurs().size()-1).getID());
			}
			
			if(this.getListeQuestions().size() > 0) {
				Question.setCount(this.getListeQuestions().get(this.getListeQuestions().size()-1).getID());
			}
			
			if(this.getListeDefis().size() > 0) {
				Defi.setCount(this.getListeDefis().get(this.getListeDefis().size()-1).getId());
			}	
			
			in.close();
			saveFile.close();
		} catch (IOException | ClassNotFoundException e) {
			new File("ser/data.ser");
		}
	}

	// MAIN //
	public static void main(String[] args){
		JFrame frame = new JFrame();
		frame.setTitle("Serious-Game by Bertherat Guillaume");
		frame.setSize(1024, 576);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		GUI myGui = new GUI(frame);
		
		/*
		Player addMe = new Player();
		addMe.setUsername("Motzen");
		addMe.setPassword("40bd001563085fc35165329ea1ff5c5ecbdbbeef");
		addMe.setAdmin(true);
		myGui.addJoueur(addMe);
		myGui.saveAll();
		*/
		
		myGui.loadAll();
		new MainMenu(myGui, frame).repaint();
	}
	
}
