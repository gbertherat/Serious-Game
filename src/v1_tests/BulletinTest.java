package v1_tests;

import v1.Bulletin;

public class BulletinTest {
	static Bulletin bulletin = new Bulletin();
	static Bulletin bulletin2 = new Bulletin();
	
	static public boolean equalsTest() {
		return bulletin.equals(bulletin2) == false;
	}

	public static void main(String[] args) {
		System.out.println("Test toString():\n" + bulletin + "\n");
		System.out.println("Test equals(): " + equalsTest());
	}

}
