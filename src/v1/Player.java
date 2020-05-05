package v1;

/**
 * La classe Player permet la cr�ation de profil de joueur.
 * @author Guillaume
 */
public class Player {
	// Vars //
	static int count = 0;
	int id;
	String nom;
	String prenom;
	int age;
	String mail;
	String username;
	String password;
	int vie;
	int score;
	
	/**
	 * Constructeur par defaut de la classe Player
	 */
	public Player(){
		count++;
		id = count;
		nom = "default";
		prenom = "default";
		age = -1;
		mail = "default";
		username = "default";
		password = null;
		vie = 0;
		score = 0;
	}
	
	/**
	 * Constructeur de la classe Player 
	 * @param nom - Le nom du joueur
	 * @param prenom - Le pr�nom du joueur
	 * @param age - L'age du joueur
	 * @param mail - Le mail du joueur
	 */
	public Player(String nom, String prenom, int age, String mail, String username, String password) {
		count++;
		this.id = count;
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.mail = mail;
		this.username = username;
		this.password = password;
		this.vie = 0;
		this.score = 0;
	}
	
	// ID //
	/**
	 * Permet de r�cup�rer l'ID d'un joueur
	 * @return (int) id l'ID du joueur.
	 */
	public int getID() {
		return this.id;
	}
	
	/**
	 * Permet de d�finir l'ID d'un joueur
	 * @param (int) id - L'ID � d�finir
	 */
	public void setID(int id) {
		this.id = id;
	}
	
	// NOM //
	/**
	 * Permet de r�cup�rer le nom d'un joueur
	 * @return (String) nom - le nom du joueur.
	 */
	public String getNom() {
		return this.nom;
	}
	
	/**
	 * Permet de d�finir le nom d'un joueur;
	 * @param (String) nom - Le nom � d�finir
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	// PRENOM //
	/**
	 * Permet de r�cup�rer le pr�nom d'un joueur;
	 * @return (String) prenom - Le pr�nom du joueur
	 */
	public String getPrenom() {
		return this.prenom;
	}
	
	/**
	 * Permet de d�finir le pr�nom d'un joueur;
	 * @param (String) prenom - Le pr�nom � d�finir
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	// AGE //
	/**
	 * Permet de r�cup�rer l'�ge d'un joueur
	 * @return (int) age - L'�ge du joueur
	 */
	public int getAge() {
		return this.age;
	}
	
	/**
	 * Permet de d�finir l'�ge d'un joueur
	 * @param (int) age - L'�ge � d�finir
	 */
	public void setAge(int age) {
		this.age = age;
	}
	
	// MAIL //
	/**
	 * Permet de r�cup�rer le mail d'un joueur
	 * @return (String) mail - Le mail du joueur
	 */
	public String getMail() {
		return this.mail;
	}
	
	/**
	 * Permet de d�finir le mail d'un joueur
	 * @param (String) mail - le mail � d�finir
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	// USERNAME //
	/**
	 * Permet de r�cup�rer le username d'un joueur
	 * @return (String) username - Le username du joueur
	 */
	public String getUsername() {
		return this.username;
	}
	
	/**
	 * Permet de d�finir le username d'un joueur
	 * @param (String) username - Le username � d�finir
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	// PASSWORD //
	/**
	 * Permet de r�cup�rer le password d'un joueur
	 * @return (String) password - Le password du joueur
	 */
	public String getPassword() {
		return this.password;
	}
	
	/**
	 * Permet de d�finir le password d'un joueur
	 * @param (String) password - Le password � d�finir
	 */
	public void setPassword(String password) {
		this.password = password;
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
	 * @param (int) vie - La vie � d�finir
	 */
	public void setVie(int vie) {
		this.vie = vie;
	}
	
	// SCORE //
	/**
	 * Permet de r�cup�rer le score d'un joueur
	 * @return (int) score - Le score du joueur
	 */
	public int getScore() {
		return this.score;
	}
	
	/**
	 * Permet de d�finir le score d'un joueur
	 * @param (int) score - Le score � d�finir
	 */
	public void setScore(int score) {
		this.score = score;
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
				"\nUsername: " + username +
				"\nPassword: " + password;
	}
	
	// EQUALS //
	/**
	 * Permet de comparer deux joueurs.
	 * @param (Player) player - Le joueur avec qui comparer
	 * @return true si les joueurs sont identiques, false sinon.
	 */
	public boolean equals(Player player) {
		return (this.id == player.id) && (this.nom.equals(player.nom)) && (this.prenom.equals(player.prenom)) && (this.age == player.age) && (this.mail.equals(player.mail)) && (this.username.equals(player.username)) && (this.password.equals(player.password)); 
	}

}
