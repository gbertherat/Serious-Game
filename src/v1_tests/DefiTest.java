package v1_tests;

import v1.Defi;

public class DefiTest {
	static Defi defi = new Defi();
	static Defi defi2 = new Defi();
	
	static boolean equalsTest() {
		return defi.equals(defi2) == false;
	}
	
	public static void main(String[] args) {
		System.out.println("Test toString():\n" + defi + "\n");
		System.out.println("Test equals(): " + equalsTest());

	}

}
