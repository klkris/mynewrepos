import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Quiz {
	List<Question> questions;
	List<Boolean> results;
	
	public Quiz() {
		questions = new ArrayList<Question>();
		results = new ArrayList<Boolean>();
	}
	
	public void add(Question q) {
		questions.add(q);
	}
	
	public void giveQuiz() {
		giveQuiz(1, 10);
	}
	
	public void giveQuiz(int minComplexityLevel, int maxComplexityLevel) {
		Scanner scan = new Scanner(System.in);
		int complexityLevel;
		for (Iterator<Question> iterator = questions.iterator(); iterator.hasNext();) {
			Question question = (Question) iterator.next();
			
			complexityLevel = question.getComplexity();
			if(minComplexityLevel <= complexityLevel && complexityLevel <= maxComplexityLevel) {
				System.out.println(question.getQuestion());
				
				
				String answer = scan.nextLine();
				results.add(question.answerCorrect(answer));
			}
		}
		scan.close();	
	}
	
	public void printResults() {
		for (Iterator<Boolean> iterator = results.iterator(); iterator.hasNext();) {
			Boolean result = (Boolean) iterator.next();
			
			System.out.println(result);
			
		}
	}

}
