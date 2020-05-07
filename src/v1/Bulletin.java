package v1;

import java.util.ArrayList;

public class Bulletin {
	private static int count = 0;
	private int id;
	private int numSemestre;
	private ArrayList<Integer> listeNotes;
	
	public Bulletin() {
		count++;
		id = count;
		numSemestre = 1;
		listeNotes = new ArrayList<Integer>();
	}
	
	public Bulletin(int numSemestre) {
		count++;
		this.id = count;
		this.numSemestre = numSemestre;
		this.listeNotes = new ArrayList<Integer>();
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
	
	// NUMERO SEMESTRE //
	/**
	 * Permet de récupérer le numéro de semestre d'un bulletin
	 * @return (int) numSemestre - Le numéro de semestre du bulletin
	 */
	public int getNumSemestre() {
		return this.numSemestre;
	}
	
	/**
	 * Permet de définir le numéro de semestre d'un bulletin
	 * @param (int) numSemestre - Le numéro de semestre à définir
	 */
	public void setNumSemestre(int numSemestre) {
		this.numSemestre = numSemestre;
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
				"\nNuméro de semestre: " + numSemestre +
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
		return (this.id == bulletin.id) && (this.numSemestre == bulletin.numSemestre) && (listeNotes.equals(listeNotes));
	}
}
