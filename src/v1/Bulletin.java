package v1;

import java.util.ArrayList;

/**
 * Permet la cr�ation d'objet Bulletin
 * @author Guillaume
 */
public class Bulletin implements java.io.Serializable{
	/**
	 * Version serial
	 */
	private static final long serialVersionUID = 8311730116008434511L;
	
	// VARS //
	private static int count = 0;
	private int id;
	private ArrayList<Integer> listeNotes;
	
	/**
	 * Constructeur par d�faut de la classe Bulletin
	 */
	public Bulletin() {
		count++;
		id = count;
		listeNotes = new ArrayList<Integer>();
	}
	
	// ID //
	/**
	 * Permet de r�cup�rer l'id d'un bulletin
	 * @return (int) id - l'id du bulletin
	 */
	public int getID() {
		return this.id;
	}
	
	/**
	 * Permet de d�finir l'id d'un bulletin
	 * @param id - l'id � d�finir
	 */
	public void setID(int id) {
		this.id = id;
	}
	
	
	// LISTE NOTES //
	/**
	 * Permet de r�cup�rer la liste des notes d'un bulletin
	 * @return listeNotes - La liste des notes du bulletin
	 */
	public ArrayList<Integer> getListeNotes() {
		return this.listeNotes;
	}
	
	/**
	 * Permet de d�finir la liste des notes d'un bulletin
	 * @param listeNotes - La liste des notes � d�finir
	 */
	public void setListeNote(ArrayList<Integer> listeNotes) {
		this.listeNotes = listeNotes;
	}
	
	/**
	 * Permet d'ajoute une note � la liste des notes d'un bulletin
	 * @param note - La note � ajouter
	 */
	public void addNote(int note) {
		this.listeNotes.add(note);
	}
	
	/**
	 * Permet de retirer une note de la liste des notes d'un bulletin
	 * @param index - L'index de la note � retirer
	 */
	public void delNote(int index) {
		this.listeNotes.remove(index);
	}
	
	/**
	 * Permet d'afficher la valeur des attributs d'un objet Bulletin
	 */
	public String toString() {
		StringBuffer toReturn = new StringBuffer("ID: " + id +
				"\nListe de notes: " + listeNotes);
		return toReturn.toString();
	}
	
	/**
	 * Permet de comparer deux objets Bulletin
	 * @param bulletin - L'object avec lequel comparer
	 * @return true si les deux objets sont identiques, false sinon.
	 */
	public boolean equals(Bulletin bulletin) {
		return (this.id == bulletin.id) && (listeNotes.equals(listeNotes));
	}
	
}
