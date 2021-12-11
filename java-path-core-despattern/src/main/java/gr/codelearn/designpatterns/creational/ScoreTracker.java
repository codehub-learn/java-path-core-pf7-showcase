package gr.codelearn.designpatterns.creational;

public class ScoreTracker {
	private static ScoreTracker instance = null;
	private int score = 0;

	private ScoreTracker(){}

	public static ScoreTracker getInstance(){
		if (instance == null){
			instance = new ScoreTracker();
		}
		return instance;
	}

	public void increaseScore(int number){
		score += number;
	}

	public int getScore(){
		return score;
	}


}
