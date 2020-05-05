package v1_tests;

import v1.Player;

/**
 * La classe PlayerTest permet de tester le méthodees créés dans la classe Player
 * @author Guillaume
 */
public class PlayerTest {
	static Player player = new Player();
	static Player player2 = new Player();	
	
	/**
	 * Permet de tester la fonction equals()
	 * @return true si les deux joueurs sont biens différents, false sinon.
	 */
	static public boolean equalsTest() {
		return player.equals(player2) == false;
	}
	
	public static void main(String[] args) {
		System.out.println("Test toString:\n" + player + "\n");
		System.out.println("Test equals: " + equalsTest());

	}

}
