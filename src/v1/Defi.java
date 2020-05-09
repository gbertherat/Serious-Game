package v1;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * La classe Defi permet la cr�ation de d�fis.
 * @author Guillaume
 */
public class Defi {
	// VARS //
	private static int count = 0;
	private int id;
	private Question question;
	private Player expediteur;
	private Player destinataire;
	private int points;
	private LocalDate date;
	private LocalDate dateExpiration;
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
		points = 0;
		date = LocalDate.now();
		dateExpiration = date.plus(2, ChronoUnit.DAYS);
		accepte = false;
		termine = false;
	}
	
	/**
	 * Constructeur de la classe Defi
	 * @param question - La question du d�fi
	 * @param expediteur - L'exp�diteur du d�fi
	 * @param destinataire - Le destinataire du d�fi
	 */
	public Defi(Question question, Player expediteur, Player destinataire, int points) {
		count++;
		this.id = count;
		this.question = question;
		this.expediteur = expediteur;
		this.destinataire = destinataire;
		this.points = points;
		this.date = LocalDate.now();
		this.accepte = false;
		this.termine = false;
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
	 * @param (int) id - L'ID � d�finir
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
	 * @param (Question) question - La question � d�finir
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
	 * @param (Player) expediteur - L'expediteur � d�finir
	 */
	public void setExpediteur(Player expediteur) {
		this.expediteur = expediteur;
	}

	// DESTINATAIRE //
	/**
	 * Permet de r�cup�rer le destinataire d'un d�fi
	 * @return (Player) destinataire - Le destinataire du d�fi
	 */
	public Player getDestinataire() {
		return destinataire;
	}

	/**
	 * Permet de d�finir le destinataire d'un d�fi
	 * @param (Player) destinataire - Le destinataire � d�finir
	 */
	public void setDestinataire(Player destinataire) {
		this.destinataire = destinataire;
	}

	// DATE //
	/**
	 * Permet de r�cup�rer la date d'envoi d'un d�fi
	 * @return (LocalDate) date - La date d'envoi du d�fi
	 */
	public LocalDate getDate() {
		return date;
	}

	/**
	 * Permet de d�finir la date d'envoi d'un d�fi
	 * @param (LocalDate) date - La date � d�finir
	 */
	public void setDate(LocalDate date) {
		this.date = date;
	}

	// DATE EXPIRATION //
	/**
	 * Permet de r�cup�rer la date d'expiration d'un d�fi
	 * @return (LocalDate) dateExpiration - La date d'expiration du d�fi
	 */
	public LocalDate getDateExpiration() {
		return dateExpiration;
	}

	/**
	 * Permet de d�finir la date d'expiration d'un d�fi
	 * @param (LocalDate) dateExpiration - La date � d�finir
	 */
	public void setDateExpiration(LocalDate dateExpiration) {
		this.dateExpiration = dateExpiration;
	}
	
	
	// ACCEPTE //
	/**
	 * Permet de r�cup�rer le bool�en accepte d'un d�fi
	 * @return (boolean) accepte - Le bool�en accepte du d�fi
	 */
	public boolean isAccepte() {
		return accepte;
	}

	/**
	 * Permet de d�finir le bool�en accepte
	 * @param (boolean) accepte - Le bool�en � d�finir
	 */
	public void setAccepte(boolean accepte) {
		this.accepte = accepte;
	}

	// TERMINE //
	/**
	 * Permet de r�cup�rer le bool�en termine d'un d�fi
	 * @return (boolean) termine - Le bool�en termine du d�fi
	 */
	public boolean isTermine() {
		return termine;
	}

	/**
	 * Permet de d�finir le bool�en termine d'un d�fi
	 * @param (boolean) termine - Le bool�en � d�finir
	 */
	public void setTermine(boolean termine) {
		this.termine = termine;
	}

	// POINTS //
	/**
	 * Permet de r�cup�rer le nombre de points d'un d�fi
	 * @return (int) points - Le nombre de points du d�fi
	 */
	public int getPoints() {
		return points;
	}

	/**
	 * Permet de d�finir le nombre de points d'un d�fi
	 * @param (int) points - Le nombre de points � d�finir
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
				"\nAccept�? " + accepte +
				"\nTermin�? " + termine;
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