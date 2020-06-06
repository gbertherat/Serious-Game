package v1;

import java.util.ArrayList;

/**
 * La classe Question permet la création de questions
 * @author Guillaume
 */
public class Question implements java.io.Serializable{
	/**
	 * Version serial
	 */
	private static final long serialVersionUID = -6111312377771338140L;
	
	// VARS //
	private static int count = 0;
	private int id;
	private String titre;
	private String contenu;
	private String categorie;
	private ArrayList<String> listeReponses;
	private int nbTentatives;
	private int nbJuste;
	
	/**
	 * Constructeur par défaut de la classe Question
	 */
	public Question() {
		count++;
		id = count;
		titre = "default";
		contenu = "default";
		listeReponses = new ArrayList<String>();
		categorie = "default";
		nbTentatives = 0;
		nbJuste = 0;
	}
	
	/**
	 * Constructeur de la classe Question
	 * @param contenu - Le contenu de la question
	 * @param categorie - La catégorie de la question
	 */
	public Question(String titre, String contenu, String categorie) {
		count++;
		this.id = count;
		this.titre = titre;
		this.contenu = contenu;
		this.listeReponses = new ArrayList<String>();
		this.categorie = categorie;
		this.nbTentatives = 0;
		this.nbJuste = 0;
	}
	
	public static int getCount() {
		return count;
	}

	public static void setCount(int count) {
		Question.count = count;
	}

	// ID //
	/**
	 * Permet de récupérer l'id d'une question
	 * @return (int) id - l'id de la question
	 */
	public int getID() {
		return this.id;
	}
	
	/**
	 * Permet de définir l'id d'une question
	 * @param (int) id - l'id à définir
	 */
	public void setID(int id) {
		this.id = id;
	}

	// TITRE //
	
	/**
	 * Permet de récupérer le titre d'une question
	 * @return titre - Le titre de la question
	 */
	public String getTitre() {
		return titre;
	}

	/**
	 * Permet de définir le titre d'une question
	 * @param titre - Le titre à définir
	 */
	public void setTitre(String titre) {
		this.titre = titre;
	}

	// CONTENU //
	/**
	 * Permet de récupérer le contenu d'une question
	 * @return (String) contenu - le contenu de la question
	 */
	public String getContenu() {
		return this.contenu;
	}
	
	/**
	 * Permet de définir le contenu d'une question
	 * @param (String) contenu - le contenu à définir
	 */
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	
	// LISTE DE REPONSES //
	/**
	 * Permet de récupérer la liste des réponses d'une question
	 * @return (ArrayList<String>) listeReponses - La liste des réponses d'une question
	 */
	public ArrayList<String> getReponses() {
		return this.listeReponses;
	}
	
	/**
	 * Permet de définir la liste des réponses d'une question
	 * @param (ArrayList<String>) liste - La liste à définir
	 */
	public void setReponses(ArrayList<String> liste) {
		this.listeReponses = liste;
	}
	
	/**
	 * Permet d'ajouter une réponse à la liste de réponses d'une question
	 * @param (String) reponse - La réponse à ajouter
	 */
	public void addReponse(String reponse) {
		this.listeReponses.add(reponse);
	}
	
	/**
	 * Permet de retirer une réponse de la liste de réponses d'une question
	 * @param (String) reponse - La réponse à retirer
	 */
	public void DelReponse(String reponse) {
		this.listeReponses.remove(reponse);
	}
	
	// CATEGORIE //
	/**
	 * Permet de récupérer la catégorie d'une question
	 * @return (String) categorie - La catégorie de la question
	 */
	public String getCategorie() {
		return this.categorie;
	}

	/**
	 * Permet de définir la catégorie d'une question
	 * @param (String) categorie - La catégorie à définir
	 */
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	
	// NOMBRE TENTATIVES //
	/**
	 * Permet de récupérer le nombre de tentatives d'une question
	 * @return (int) nbTentatives - Le nombre de tentatives de la question
	 */
	public int getTentatives() {
		return this.nbTentatives;
	}
	
	/**
	 * Permet de définir le nombre de tentatives d'une question
	 * @param (int) nbTentatives - Le nombre de tentatives à définir
	 */
	public void setTentatives(int nbTentatives) {
		this.nbTentatives = nbTentatives;
	}
	
	// NOMBRE JUSTE //
	/**
	 * Permet de récupérer le nombre de bonne réponse d'une question
	 * @return (int) nbJuste - Le nombre de bonne réponse d'une question
	 */
	public int getNbJuste() {
		return this.nbJuste;
	}
	
	/**
	 * Permet de définir le nombre de bonne réponse d'une question
	 * @param (int) nbJuste - Le nombre à définir
	 */
	public void setNbJuste(int nbJuste) {
		this.nbJuste = nbJuste;
	}
	
	// TOSTRING //
	/**
	 * Permet d'afficher la valeur des attributs d'un objet Question
	 */
	public String toString() {
		StringBuffer toReturn = new StringBuffer("ID: " + id +
				"\nTitre: " + titre +
				"\nContenu: " + contenu +
				"\nCategorie: " + categorie +
				"\nListe réponses: " + listeReponses +
				"\nNombre de tentatives: " + nbTentatives +
				"\nNombre de réussites: " + nbJuste);
		return toReturn.toString();
	}
	
	// EQUALS //
	/**
	 * Permet de comparer deux objets Question
	 * @param question - L'object avec lequel comparer
	 * @return true si les deux objets sont identiques, false sinon
	 */
	public boolean equals(Question question) {
		return (this.id == question.id) && 
				(this.contenu.equals(question.contenu)) && 
				(this.categorie.equals(question.categorie)) && 
				(this.listeReponses.equals(question.listeReponses)) && 
				(this.nbTentatives == question.nbTentatives) && 
				(this.nbJuste == question.nbJuste); 
	}
}
