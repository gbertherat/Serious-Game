package v1;

/**
 * La classe Admin permet la création de profil administrateur.
 * @author Guillaume
 */
public class Admin extends Player{
	/**
	 * Constructeur par défaut de la classe Admin
	 */
	public Admin() {
		super();
	}
	
	/**
	 * Constructeur de la classe Admin
	 * @param nom - Le nom de l'administrateur
	 * @param prenom - Le prenom de l'administrateur
	 * @param age - L'age de l'administrateur
	 * @param mail - Le mail de l'administrateur
	 * @param username - Le username de l'administrateur
	 * @param password - Le password de l'administrateur
	 */
	public Admin(String nom, String prenom, int age, String mail, String licence, String username, String password) {
		super(nom, prenom, age, mail, licence, username, password);
	}
	
	/**
	 * Méthode toString de la classe Admin
	 * @return la valeur des attributs d'un objet Admin
	 */
	public String toString() {
		return super.toString() 
				+ "\nAdministrateur";
	}
}
