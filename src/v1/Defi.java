package v1;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * La classe Defi permet la création de défis.
 * @author Guillaume
 */
public class Defi implements java.io.Serializable{
	/**
	 * Version serial
	 */
	private static final long serialVersionUID = 7168126960424290878L;
	
	// VARS //
	private static int count = 0;
	private int id;
	private Question question;
	private Player expediteur;
	private Player destinataire;
	private int points;
	private LocalDateTime date;
	private LocalDateTime dateExpiration;
	private boolean reviewed;
	private boolean accepte;
	private boolean termine;
	
	/**
	 * Constructeur par défaut de la classe Defi
	 */
	public Defi() {
		count++;
		id = count;
		question = null;
		expediteur = null;
		destinataire = null;
		points = 0;
		date = LocalDateTime.now();
		dateExpiration = date.plus(2, ChronoUnit.DAYS);
		reviewed = false;
		accepte = false;
		termine = false;
	}
	
	/**
	 * Constructeur de la classe Defi
	 * @param question - La question du défi
	 * @param expediteur - L'expéditeur du défi
	 * @param destinataire - Le destinataire du défi
	 */
	public Defi(Question question, Player expediteur, Player destinataire, int points) {
		count++;
		this.id = count;
		this.question = question;
		this.expediteur = expediteur;
		this.destinataire = destinataire;
		this.points = points;
		this.date = LocalDateTime.now();
		this.dateExpiration = date.plus(2, ChronoUnit.DAYS);
		this.reviewed = false;
		this.accepte = false;
		this.termine = false;
	}

	public static int getCount() {
		return count;
	}

	public static void setCount(int count) {
		Defi.count = count;
	}

	// ID //
	/**
	 * Permet de récupérer l'ID d'un défi
	 * @return (int) id - L'ID du défi
	 */
	public int getId() {
		return id;
	}

	/**
	 * Permet de définir l'ID d'un défi
	 * @param (int) id - L'ID à définir
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	// QUESTION //
	/**
	 * Permet de récupérer la question d'un défi
	 * @return (Question) question - La question du défi
	 */
	public Question getQuestion() {
		return question;
	}

	/**
	 * Permet de définir la question d'un défi
	 * @param (Question) question - La question à définir
	 */
	public void setQuestion(Question question) {
		this.question = question;
	}

	// EXPEDITEUR //
	/**
	 * Permet de récupérer l'expediteur d'un défi
	 * @return (Player) expediteur - L'expediteur du défi
	 */
	public Player getExpediteur() {
		return expediteur;
	}

	/**
	 * Permet de définir l'expediteur d'un défi
	 * @param (Player) expediteur - L'expediteur à définir
	 */
	public void setExpediteur(Player expediteur) {
		this.expediteur = expediteur;
	}

	// DESTINATAIRE //
	/**
	 * Permet de récupérer le destinataire d'un défi
	 * @return (Player) destinataire - Le destinataire du défi
	 */
	public Player getDestinataire() {
		return destinataire;
	}

	/**
	 * Permet de définir le destinataire d'un défi
	 * @param (Player) destinataire - Le destinataire à définir
	 */
	public void setDestinataire(Player destinataire) {
		this.destinataire = destinataire;
	}

	// DATE //
	/**
	 * Permet de récupérer la date d'envoi d'un défi
	 * @return (LocalDate) date - La date d'envoi du défi
	 */
	public LocalDateTime getDate() {
		return date;
	}

	/**
	 * Permet de définir la date d'envoi d'un défi
	 * @param (LocalDate) date - La date à définir
	 */
	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	// DATE EXPIRATION //
	/**
	 * Permet de récupérer la date d'expiration d'un défi
	 * @return (LocalDate) dateExpiration - La date d'expiration du défi
	 */
	public LocalDateTime getDateExpiration() {
		return dateExpiration;
	}

	/**
	 * Permet de définir la date d'expiration d'un défi
	 * @param (LocalDate) dateExpiration - La date à définir
	 */
	public void setDateExpiration(LocalDateTime dateExpiration) {
		this.dateExpiration = dateExpiration;
	}
	
	// REVIEWED //
	/**
	 * Permet de récupérer le booléen admin reviewed
	 * @return (boolean) reviewed - Le booléen admin reviewed
	 */
	public boolean isReviewed() {
		return reviewed;
	}
	
	/**
	 * Permet de définir le booléen admin reviewed
	 * @param reviewed - Le booléen à définir
	 */
	public void setReviewed(boolean reviewed) {
		this.reviewed = reviewed;
	}
	
	
	// ACCEPTE //
	/**
	 * Permet de récupérer le booléen accepte d'un défi
	 * @return (boolean) accepte - Le booléen accepte du défi
	 */
	public boolean isAccepte() {
		return accepte;
	}

	/**
	 * Permet de définir le booléen accepte
	 * @param (boolean) accepte - Le booléen à définir
	 */
	public void setAccepte(boolean accepte) {
		this.accepte = accepte;
	}

	// TERMINE //
	/**
	 * Permet de récupérer le booléen termine d'un défi
	 * @return (boolean) termine - Le booléen termine du défi
	 */
	public boolean isTermine() {
		return termine;
	}

	/**
	 * Permet de définir le booléen termine d'un défi
	 * @param (boolean) termine - Le booléen à définir
	 */
	public void setTermine(boolean termine) {
		this.termine = termine;
	}

	// POINTS //
	/**
	 * Permet de récupérer le nombre de points d'un défi
	 * @return (int) points - Le nombre de points du défi
	 */
	public int getPoints() {
		return points;
	}

	/**
	 * Permet de définir le nombre de points d'un défi
	 * @param (int) points - Le nombre de points à définir
	 */
	public void setPoints(int points) {
		this.points = points;
	}
	
	// TOSTRING //
	/**
	 * Permet d'afficher la valeur des attributs d'un objet Defi
	 */
	public String toString() {
		return "ID: " + id +
				"\nQuestion: " + question +
				"\nExpediteur: " + expediteur +
				"\nDestinataire: " + destinataire +
				"\nPoints: " + points +
				"\nDate d'envoi: " + date +
				"\nDate d'expiration: " + dateExpiration +
				"\nReviewed? " + reviewed +
				"\nAccepté? " + accepte +
				"\nTerminé? " + termine;
	}
	
	// EQUALS //
	/**
	 * Permet de comparer deux objets defi
	 * @param defi - L'objet avec lequel comparer
	 * @return true si les deux objets sont identiques, false sinon
	 */
	public boolean equals(Defi defi) {
		return (this.id == defi.id) && (this.question.equals(defi.question)) && (this.expediteur.equals(defi.expediteur)) && (this.destinataire.equals(defi.expediteur)) && (this.points == defi.points) && (this.date.equals(defi.date)) && (this.dateExpiration.equals(defi.dateExpiration)) && (this.accepte == defi.accepte) && (this.termine = defi.termine); 
	}
}
