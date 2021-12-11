package gr.codelearn.designpatterns.creational;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
	private static final Logger logger = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {
		ScoreTracker scoreTracker = ScoreTracker.getInstance();

		logger.info("{}", scoreTracker.getScore());
		scoreTracker.increaseScore(10);
		logger.info("{}", scoreTracker.getScore());

		scoreTracker = ScoreTracker.getInstance();
		logger.info("{}", scoreTracker.getScore());
	}
}
