package v1_tests;

import v1.Question;

public class QuestionTest {
	static Question question = new Question();
	static Question question2 = new Question();
	
	static public boolean equalsTest() {
		return question.equals(question2) == false;
	}

	public static void main(String[] args) {
		System.out.println("Test toString():\n" + question + "\n");
		System.out.println("Test equals(): " + equalsTest());

	}

}
