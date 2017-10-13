
public class QuizTime {

	public static void main(String a[]) {
		
		QuizTime qt = new QuizTime();
		Quiz quiz =  qt.loadQuiz();
		
		quiz.giveQuiz();
		quiz.printResults();
	
	}
	
	
	public Quiz loadQuiz() {
		
		Quiz quiz = new Quiz();
		
		Question q = new Question("Question1", "Answer1");
		q.setComplexity(1);
		quiz.add(q);

		q = new Question("Question2", "Answer2");
		q.setComplexity(1);
		quiz.add(q);

		q = new Question("Question3", "Answer3");
		q.setComplexity(2);
		quiz.add(q);

		q = new Question("Question4", "Answer4");
		q.setComplexity(2);
		quiz.add(q);

		q = new Question("Question5", "Answer5");
		q.setComplexity(3);
		quiz.add(q);

		q = new Question("Question6", "Answer6");
		q.setComplexity(3);
		quiz.add(q);

		q = new Question("Question7", "Answer7");
		q.setComplexity(4);
		quiz.add(q);

		q = new Question("Question8", "Answer8");
		q.setComplexity(4);
		quiz.add(q);

		q = new Question("Question9", "Answer9");
		q.setComplexity(5);
		quiz.add(q);

		q = new Question("Question10", "Answer10");
		q.setComplexity(5);
		quiz.add(q);
		
		q = new Question("Question11", "Answer11");
		q.setComplexity(6);
		quiz.add(q);

		q = new Question("Question12", "Answer12");
		q.setComplexity(6);
		quiz.add(q);

		q = new Question("Question13", "Answer13");
		q.setComplexity(7);
		quiz.add(q);

		q = new Question("Question14", "Answer14");
		q.setComplexity(7);
		quiz.add(q);

		q = new Question("Question15", "Answer15");
		q.setComplexity(8);
		quiz.add(q);

		q = new Question("Question16", "Answer16");
		q.setComplexity(8);
		quiz.add(q);

		q = new Question("Question17", "Answer17");
		q.setComplexity(9);
		quiz.add(q);

		q = new Question("Question18", "Answer18");
		q.setComplexity(9);
		quiz.add(q);

		q = new Question("Question19", "Answer19");
		q.setComplexity(10);
		quiz.add(q);

		q = new Question("Question20", "Answer20");
		q.setComplexity(10);
		quiz.add(q);
		
		q = new Question("Question21", "Answer21");
		q.setComplexity(1);
		quiz.add(q);

		q = new Question("Question22", "Answer22");
		q.setComplexity(2);
		quiz.add(q);

		q = new Question("Question23", "Answer23");
		q.setComplexity(3);
		quiz.add(q);

		q = new Question("Question24", "Answer24");
		q.setComplexity(4);
		quiz.add(q);

		q = new Question("Question25", "Answer25");
		q.setComplexity(5);
		quiz.add(q);
		
		return quiz;
	}
}
