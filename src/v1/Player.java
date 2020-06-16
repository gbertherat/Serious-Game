package v1;

/**
 * La classe Player permet la cr�ation de profil joueur.
 * @author Guillaume
 */
public class Player implements java.io.Serializable{
	/**
	 * Version serial
	 */
	private static final long serialVersionUID = 8093318821280100491L;
	
	// Vars //
	private static int count = 0;
	private int id;
	private String nom;
	private String prenom;
	private int age;
	private String mail;
	private String licence;
	private String username;
	private String password;
	private Bulletin myBulletin;
	private int vie;
	private int score;
	private int defis;
	private int defisReussis;
	private boolean admin;
	
	/**
	 * Constructeur par defaut de la classe Player
	 */
	public Player(){
		count++;
		id = count;
		nom = "default";
		prenom = "default";
		age = 0;
		mail = null;
		licence = "default";
		username = null;
		password = null;
		myBulletin = null;
		vie = 0;
		score = 0;
		defis = 0;
		defisReussis = 0;
		admin = false;
	}
	
	/**
	 * Constructeur de la classe Player
	 * @param nom - Le nom du joueur
	 * @param prenom - Le pr�nom du joueur
	 * @param age - L'�ge du joueur
	 * @param mail - Le mail du joueur
	 * @param licence - La licence du joueur
	 * @param username - L'username du joueur
	 * @param password - Le password du joueur
	 */
	public Player(String nom, String prenom, int age, String mail, String licence, String username, String password) {
		count++;
		this.id = count;
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.mail = mail;
		this.licence = licence;
		this.username = username;
		this.password = password;
		this.myBulletin = null;
		this.vie = 0;
		this.score = 0;
		this.defis = 0;
		this.defisReussis = 0;
		this.admin = false;
	}
	
	public static int getCount() {
		return count;
	}

	public static void setCount(int count) {
		Player.count = count;
	}

	// ID //
	/**
	 * Permet de r�cup�rer l'ID d'un joueur
	 * @return id l'ID du joueur.
	 */
	public int getID() {
		return this.id;
	}
	
	/**
	 * Permet de d�finir l'ID d'un joueur
	 * @param id - L'ID � d�finir
	 */
	public void setID(int id) {
		this.id = id;
	}
	
	// NOM //
	/**
	 * Permet de r�cup�rer le nom d'un joueur
	 * @return nom - le nom du joueur.
	 */
	public String getNom() {
		return this.nom;
	}
	
	/**
	 * Permet de d�finir le nom d'un joueur;
	 * @param nom - Le nom � d�finir
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	// PRENOM //
	/**
	 * Permet de r�cup�rer le pr�nom d'un joueur;
	 * @return prenom - Le pr�nom du joueur
	 */
	public String getPrenom() {
		return this.prenom;
	}
	
	/**
	 * Permet de d�finir le pr�nom d'un joueur;
	 * @param prenom - Le pr�nom � d�finir
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	// AGE //
	/**
	 * Permet de r�cup�rer l'�ge d'un joueur
	 * @return age - L'�ge du joueur
	 */
	public int getAge() {
		return this.age;
	}
	
	/**
	 * Permet de d�finir l'�ge d'un joueur
	 * @param age - L'�ge � d�finir
	 */
	public void setAge(int age) {
		this.age = age;
	}
	
	// MAIL //
	/**
	 * Permet de r�cup�rer le mail d'un joueur
	 * @return mail - Le mail du joueur
	 */
	public String getMail() {
		return this.mail;
	}
	
	/**
	 * Permet de d�finir le mail d'un joueur
	 * @param mail - le mail � d�finir
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	// LICENCE //
	/**
	 * Permet de r�cup�rer la licence d'un joueur
	 * @return licence - La licence du joueur
	 */
	public String getLicence() {
		return this.licence;
	}
	
	/**
	 * Permet de d�finir la licence d'un joueur
	 * @param licence - La licence � d�finir
	 */
	public void setLicence(String licence) {
		this.licence = licence;
	}
	
	// USERNAME //
	/**
	 * Permet de r�cup�rer le username d'un joueur
	 * @return username - Le username du joueur
	 */
	public String getUsername() {
		return this.username;
	}
	
	/**
	 * Permet de d�finir le username d'un joueur
	 * @param username - Le username � d�finir
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	// PASSWORD //
	/**
	 * Permet de r�cup�rer le password d'un joueur
	 * @return password - Le password du joueur
	 */
	public String getPassword() {
		return this.password;
	}
	
	/**
	 * Permet de d�finir le password d'un joueur
	 * @param password - Le password � d�finir
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	// BULLETIN //
	/**
	 * Permet de r�cuperer l'objet Bulletin d'un joueur
	 * @return myBulletin
	 */
	public Bulletin getBulletin() {
		return this.myBulletin;
	}
	
	/**
	 * Permet de d�finir l'objet Bulletin d'un joueur
	 * @param bulletin - L'objet � d�finir
	 */
	public void setBulletin(Bulletin bulletin) {
		this.myBulletin = bulletin;
	}
	
	// VIE //
	/**
	 * Permet de r�cup�rer la vie d'un joueur.
	 * @return (int) vie - La vie du joueur
	 */
	public int getVie() {
		return this.vie;
	}
	
	/**
	 * Permet de d�finir la vie d'un joueur
	 * @param vie - La vie � d�finir
	 */
	public void setVie(int vie) {
		this.vie = vie;
	}
	
	// SCORE //
	/**
	 * Permet de r�cup�rer le score d'un joueur
	 * @return score - Le score du joueur
	 */
	public int getScore() {
		return this.score;
	}
	
	/**
	 * Permet de d�finir le score d'un joueur
	 * @param score - Le score � d�finir
	 */
	public void setScore(int score) {
		this.score = score;
	}
	
	// DEFIS //
	/**
	 * Permet de r�cup�rer le nombre de d�fi r��u
	 * @return le nombre de d�fi
	 */
	public int getDefis() {
		return defis;
	}

	/**
	 * Permet de d�finir le nombre de d�fi re�u
	 * @param defis - le nombre de d�fi � d�finir
	 */
	public void setDefis(int defis) {
		this.defis = defis;
	}

	// DEFIS REUSSIS //
	/**
	 * Permet de r�cuperer le nombre de d�fis r�ussis
	 * @return le nombre de d�fis r�ussis
	 */
	public int getDefisReussis() {
		return defisReussis;
	}

	/**
	 * Permet de d�finir le nombre de d�fis r�ussis
	 * @param defisReussis - Le nombre de d�fis
	 */
	public void setDefisReussis(int defisReussis) {
		this.defisReussis = defisReussis;
	}

	// ADMIN //
	/**
	 * Permet de savoir si un utilisateur est un administrateur
	 * @return true si l'utilisateur est un administrateur, false sinon
	 */
	public boolean isAdmin() {
		return admin;
	}

	/**
	 * Permet de d�finir si un utilisateur est un administrateur
	 * @param admin (true / false)
	 */
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	// TOSTRING //
	/**
	 * Permet d'afficher les attributs d'un joueur dans la console
	 */
	public String toString() {
		return "ID: " + id +
				"\nNom: " + nom +
				"\nPrenom: " + prenom +
				"\nAge: " + age +
				"\nMail: " + mail +
				"\nLicence: " + licence +
				"\nUsername: " + username +
				"\nPassword: " + password +
				"\nVie: " + vie +
				"\nScore: " + score +
				"\nBulletin: " + myBulletin +
				"\nDefis: " + defis +
				"\nDefis r�ussis: " + defisReussis;
	}
	
	// EQUALS //
	/**
	 * Permet de comparer deux objets Player
	 * @param player - Le player avec qui comparer
	 * @return true s'ils sont identiques, false sinon
	 */
	public boolean equals(Player player) {
		return (this.id == player.id) && (this.nom.equals(player.nom)) && (this.prenom.equals(player.prenom)) && (this.age == player.age) && (this.mail.equals(player.mail)) && (this.username.equals(player.username)) && (this.password.equals(player.password)); 
	}

}
