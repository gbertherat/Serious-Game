package v1_tests;

import v1.Admin;

public class AdminTest {
	static Admin admin = new Admin();
	static Admin admin2 = new Admin();
	
	static public boolean equalsTest() {
		return admin.equals(admin2) == false;
	}
	
	public static void main(String[] args) {
		System.out.println("Test toString():\n"+ admin + "\n");
		System.out.println("Test equals(): " + equalsTest());

	}

}
