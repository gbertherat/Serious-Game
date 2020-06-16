package v1;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * Classe permettant la cr�ation d'object Defi.
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
	 * Constructeur par d�faut de la classe Defi
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
	 * @param question - La question du d�fi
	 * @param expediteur - L'exp�diteur du d�fi
	 * @param destinataire - Le destinataire du d�fi
	 * @param points - Les points du d�fi
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

	// COUNT //
	/**
	 * Permet de r�cup�rer le count 
	 * @return le count
	 */
	public static int getCount() {
		return count;
	}
	
	/**
	 * Permet de d�finir le count
	 * @param count - Le count � d�finir 
	 */
	public static void setCount(int count) {
		Defi.count = count;
	}

	// ID //
	/**
	 * Permet de r�cup�rer l'ID d'un d�fi
	 * @return (int) id - L'ID du d�fi
	 */
	public int getId() {
		return id;
	}

	/**
	 * Permet de d�finir l'ID d'un d�fi
	 * @param id - L'ID � d�finir
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	// QUESTION //
	/**
	 * Permet de r�cup�rer la question d'un d�fi
	 * @return (Question) question - La question du d�fi
	 */
	public Question getQuestion() {
		return question;
	}

	/**
	 * Permet de d�finir la question d'un d�fi
	 * @param question - La question � d�finir
	 */
	public void setQuestion(Question question) {
		this.question = question;
	}

	// EXPEDITEUR //
	/**
	 * Permet de r�cup�rer l'expediteur d'un d�fi
	 * @return (Player) expediteur - L'expediteur du d�fi
	 */
	public Player getExpediteur() {
		return expediteur;
	}

	/**
	 * Permet de d�finir l'expediteur d'un d�fi
	 * @param expediteur - L'expediteur � d�finir
	 */
	public void setExpediteur(Player expediteur) {
		this.expediteur = expediteur;
	}

	// DESTINATAIRE //
	/**
	 * Permet de r�cup�rer le destinataire d'un d�fi
	 * @return destinataire - Le destinataire du d�fi
	 */
	public Player getDestinataire() {
		return destinataire;
	}

	/**
	 * Permet de d�finir le destinataire d'un d�fi
	 * @param destinataire - Le destinataire � d�finir
	 */
	public void setDestinataire(Player destinataire) {
		this.destinataire = destinataire;
	}

	// DATE //
	/**
	 * Permet de r�cup�rer la date d'envoi d'un d�fi
	 * @return date - La date d'envoi du d�fi
	 */
	public LocalDateTime getDate() {
		return date;
	}

	/**
	 * Permet de d�finir la date d'envoi d'un d�fi
	 * @param date - La date � d�finir
	 */
	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	// DATE EXPIRATION //
	/**
	 * Permet de r�cup�rer la date d'expiration d'un d�fi
	 * @return dateExpiration - La date d'expiration du d�fi
	 */
	public LocalDateTime getDateExpiration() {
		return dateExpiration;
	}

	/**
	 * Permet de d�finir la date d'expiration d'un d�fi
	 * @param dateExpiration - La date � d�finir
	 */
	public void setDateExpiration(LocalDateTime dateExpiration) {
		this.dateExpiration = dateExpiration;
	}
	
	// REVIEWED //
	/**
	 * Permet de r�cup�rer le bool�en admin reviewed
	 * @return reviewed - Le bool�en admin reviewed
	 */
	public boolean isReviewed() {
		return reviewed;
	}
	
	/**
	 * Permet de d�finir le bool�en admin reviewed
	 * @param reviewed - Le bool�en � d�finir
	 */
	public void setReviewed(boolean reviewed) {
		this.reviewed = reviewed;
	}
	
	
	// ACCEPTE //
	/**
	 * Permet de r�cup�rer le bool�en accepte d'un d�fi
	 * @return accepte - Le bool�en accepte du d�fi
	 */
	public boolean isAccepte() {
		return accepte;
	}

	/**
	 * Permet de d�finir le bool�en accepte
	 * @param accepte - Le bool�en � d�finir
	 */
	public void setAccepte(boolean accepte) {
		this.accepte = accepte;
	}

	// TERMINE //
	/**
	 * Permet de r�cup�rer le bool�en termine d'un d�fi
	 * @return termine - Le bool�en termine du d�fi
	 */
	public boolean isTermine() {
		return termine;
	}

	/**
	 * Permet de d�finir le bool�en termine d'un d�fi
	 * @param termine - Le bool�en � d�finir
	 */
	public void setTermine(boolean termine) {
		this.termine = termine;
	}

	// POINTS //
	/**
	 * Permet de r�cup�rer le nombre de points d'un d�fi
	 * @return points - Le nombre de points du d�fi
	 */
	public int getPoints() {
		return points;
	}

	/**
	 * Permet de d�finir le nombre de points d'un d�fi
	 * @param points - Le nombre de points � d�finir
	 */
	public void setPoints(int points) {
		this.points = points;
	}
	
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
				"\nAccept�? " + accepte +
				"\nTermin�? " + termine;
	}
	
	/**
	 * Permet de comparer deux objets defi
	 * @param defi - L'objet avec lequel comparer
	 * @return true si les deux objets sont identiques, false sinon
	 */
	public boolean equals(Defi defi) {
		return (this.id == defi.id) && (this.question.equals(defi.question)) && (this.expediteur.equals(defi.expediteur)) && (this.destinataire.equals(defi.expediteur)) && (this.points == defi.points) && (this.date.equals(defi.date)) && (this.dateExpiration.equals(defi.dateExpiration)) && (this.accepte == defi.accepte) && (this.termine = defi.termine); 
	}
}
