package v1;

/**
 * La classe Player permet la création de profil de joueur.
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
	 * @param prenom - Le prénom du joueur
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
	 * Permet de récupérer l'ID d'un joueur
	 * @return (int) id l'ID du joueur.
	 */
	public int getID() {
		return this.id;
	}
	
	/**
	 * Permet de définir l'ID d'un joueur
	 * @param (int) id - L'ID à définir
	 */
	public void setID(int id) {
		this.id = id;
	}
	
	// NOM //
	/**
	 * Permet de récupérer le nom d'un joueur
	 * @return (String) nom - le nom du joueur.
	 */
	public String getNom() {
		return this.nom;
	}
	
	/**
	 * Permet de définir le nom d'un joueur;
	 * @param (String) nom - Le nom à définir
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	// PRENOM //
	/**
	 * Permet de récupérer le prénom d'un joueur;
	 * @return (String) prenom - Le prénom du joueur
	 */
	public String getPrenom() {
		return this.prenom;
	}
	
	/**
	 * Permet de définir le prénom d'un joueur;
	 * @param (String) prenom - Le prénom à définir
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	// AGE //
	/**
	 * Permet de récupérer l'âge d'un joueur
	 * @return (int) age - L'âge du joueur
	 */
	public int getAge() {
		return this.age;
	}
	
	/**
	 * Permet de définir l'âge d'un joueur
	 * @param (int) age - L'âge à définir
	 */
	public void setAge(int age) {
		this.age = age;
	}
	
	// MAIL //
	/**
	 * Permet de récupérer le mail d'un joueur
	 * @return (String) mail - Le mail du joueur
	 */
	public String getMail() {
		return this.mail;
	}
	
	/**
	 * Permet de définir le mail d'un joueur
	 * @param (String) mail - le mail à définir
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	// USERNAME //
	/**
	 * Permet de récupérer le username d'un joueur
	 * @return (String) username - Le username du joueur
	 */
	public String getUsername() {
		return this.username;
	}
	
	/**
	 * Permet de définir le username d'un joueur
	 * @param (String) username - Le username à définir
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	// PASSWORD //
	/**
	 * Permet de récupérer le password d'un joueur
	 * @return (String) password - Le password du joueur
	 */
	public String getPassword() {
		return this.password;
	}
	
	/**
	 * Permet de définir le password d'un joueur
	 * @param (String) password - Le password à définir
	 */
	public void setPassword(String password) {
		this.password = password;
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
	 * @param (int) vie - La vie à définir
	 */
	public void setVie(int vie) {
		this.vie = vie;
	}
	
	// SCORE //
	/**
	 * Permet de récupérer le score d'un joueur
	 * @return (int) score - Le score du joueur
	 */
	public int getScore() {
		return this.score;
	}
	
	/**
	 * Permet de définir le score d'un joueur
	 * @param (int) score - Le score à définir
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
