package v1;

import java.util.ArrayList;

public class Bulletin implements java.io.Serializable{
	/**
	 * Version serial
	 */
	private static final long serialVersionUID = 8311730116008434511L;
	
	private static int count = 0;
	private int id;
	private ArrayList<Integer> listeNotes;
	
	public Bulletin() {
		count++;
		id = count;
		listeNotes = new ArrayList<Integer>();
	}
	
	// ID //
	/**
	 * Permet de récupérer l'id d'un bulletin
	 * @return (int) id - l'id du bulletin
	 */
	public int getID() {
		return this.id;
	}
	
	/**
	 * Permet de définir l'id d'un bulletin
	 * @param (int) id - l'id à définir
	 */
	public void setID(int id) {
		this.id = id;
	}
	
	
	// LISTE NOTES //
	/**
	 * Permet de récupérer la liste des notes d'un bulletin
	 * @return (ArrayList<Integer>) listeNotes - La liste des notes du bulletin
	 */
	public ArrayList<Integer> getListeNotes() {
		return this.listeNotes;
	}
	
	/**
	 * Permet de définir la liste des notes d'un bulletin
	 * @param (ArrayList<Integer>) listeNotes - La liste des notes à définir
	 */
	public void setListeNote(ArrayList<Integer> listeNotes) {
		this.listeNotes = listeNotes;
	}
	
	/**
	 * Permet d'ajoute une note à la liste des notes d'un bulletin
	 * @param (int) note - La note à ajouter
	 */
	public void addNote(int note) {
		this.listeNotes.add(note);
	}
	
	/**
	 * Permet de retirer une note de la liste des notes d'un bulletin
	 * @param (int) index - L'index de la note à retirer
	 */
	public void delNote(int index) {
		this.listeNotes.remove(index);
	}
	
	// TOSTRING //
	/**
	 * Permet d'afficher la valeur des attributs d'un objet Bulletin
	 */
	public String toString() {
		StringBuffer toReturn = new StringBuffer("ID: " + id +
				"\nListe de notes: " + listeNotes);
		return toReturn.toString();
	}
	
	// EQUALS //
	/**
	 * Permet de comparer deux objets Bulletin
	 * @param bulletin - L'object avec lequel comparer
	 * @return true si les deux objets sont identiques, false sinon.
	 */
	public boolean equals(Bulletin bulletin) {
		return (this.id == bulletin.id) && (listeNotes.equals(listeNotes));
	}
	
}
