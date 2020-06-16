package v1;

/**
 * La classe Player permet la création de profil joueur.
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
	 * @param prenom - Le prénom du joueur
	 * @param age - L'âge du joueur
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
	 * Permet de récupérer l'ID d'un joueur
	 * @return id l'ID du joueur.
	 */
	public int getID() {
		return this.id;
	}
	
	/**
	 * Permet de définir l'ID d'un joueur
	 * @param id - L'ID à définir
	 */
	public void setID(int id) {
		this.id = id;
	}
	
	// NOM //
	/**
	 * Permet de récupérer le nom d'un joueur
	 * @return nom - le nom du joueur.
	 */
	public String getNom() {
		return this.nom;
	}
	
	/**
	 * Permet de définir le nom d'un joueur;
	 * @param nom - Le nom à définir
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	// PRENOM //
	/**
	 * Permet de récupérer le prénom d'un joueur;
	 * @return prenom - Le prénom du joueur
	 */
	public String getPrenom() {
		return this.prenom;
	}
	
	/**
	 * Permet de définir le prénom d'un joueur;
	 * @param prenom - Le prénom à définir
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	// AGE //
	/**
	 * Permet de récupérer l'âge d'un joueur
	 * @return age - L'âge du joueur
	 */
	public int getAge() {
		return this.age;
	}
	
	/**
	 * Permet de définir l'âge d'un joueur
	 * @param age - L'âge à définir
	 */
	public void setAge(int age) {
		this.age = age;
	}
	
	// MAIL //
	/**
	 * Permet de récupérer le mail d'un joueur
	 * @return mail - Le mail du joueur
	 */
	public String getMail() {
		return this.mail;
	}
	
	/**
	 * Permet de définir le mail d'un joueur
	 * @param mail - le mail à définir
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	// LICENCE //
	/**
	 * Permet de récupérer la licence d'un joueur
	 * @return licence - La licence du joueur
	 */
	public String getLicence() {
		return this.licence;
	}
	
	/**
	 * Permet de définir la licence d'un joueur
	 * @param licence - La licence à définir
	 */
	public void setLicence(String licence) {
		this.licence = licence;
	}
	
	// USERNAME //
	/**
	 * Permet de récupérer le username d'un joueur
	 * @return username - Le username du joueur
	 */
	public String getUsername() {
		return this.username;
	}
	
	/**
	 * Permet de définir le username d'un joueur
	 * @param username - Le username à définir
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	// PASSWORD //
	/**
	 * Permet de récupérer le password d'un joueur
	 * @return password - Le password du joueur
	 */
	public String getPassword() {
		return this.password;
	}
	
	/**
	 * Permet de définir le password d'un joueur
	 * @param password - Le password à définir
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	// BULLETIN //
	/**
	 * Permet de récuperer l'objet Bulletin d'un joueur
	 * @return myBulletin
	 */
	public Bulletin getBulletin() {
		return this.myBulletin;
	}
	
	/**
	 * Permet de définir l'objet Bulletin d'un joueur
	 * @param bulletin - L'objet à définir
	 */
	public void setBulletin(Bulletin bulletin) {
		this.myBulletin = bulletin;
	}
	
	// VIE //
	/**
	 * Permet de récupérer la vie d'un joueur.
	 * @return (int) vie - La vie du joueur
	 */
	public int getVie() {
		return this.vie;
	}
	
	/**
	 * Permet de définir la vie d'un joueur
	 * @param vie - La vie à définir
	 */
	public void setVie(int vie) {
		this.vie = vie;
	}
	
	// SCORE //
	/**
	 * Permet de récupérer le score d'un joueur
	 * @return score - Le score du joueur
	 */
	public int getScore() {
		return this.score;
	}
	
	/**
	 * Permet de définir le score d'un joueur
	 * @param score - Le score à définir
	 */
	public void setScore(int score) {
		this.score = score;
	}
	
	// DEFIS //
	/**
	 * Permet de récupérer le nombre de défi réçu
	 * @return le nombre de défi
	 */
	public int getDefis() {
		return defis;
	}

	/**
	 * Permet de définir le nombre de défi reçu
	 * @param defis - le nombre de défi à définir
	 */
	public void setDefis(int defis) {
		this.defis = defis;
	}

	// DEFIS REUSSIS //
	/**
	 * Permet de récuperer le nombre de défis réussis
	 * @return le nombre de défis réussis
	 */
	public int getDefisReussis() {
		return defisReussis;
	}

	/**
	 * Permet de définir le nombre de défis réussis
	 * @param defisReussis - Le nombre de défis
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
	 * Permet de définir si un utilisateur est un administrateur
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
				"\nDefis réussis: " + defisReussis;
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
