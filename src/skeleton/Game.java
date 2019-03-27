package skeleton;

import static skeleton.Application.*;

public class Game {

	private Map map;
	private int points;
	private Entrance entrance;
	
	public Game() {
		System.out.println("Game created");
		map = new Map();
		points = 0;
		entrance = new Entrance();
		startGame();
	}

	public void startGame() {
		System.out.println("Game started");
	}

	public void endGame() {
		tabs++;
		logger(toString() + ".endGame (Here is the end, but for the convenience of the testing, the application does not exits.)");
		tabs--;
	}

	public void increasePoints() {
		tabs++;
		logger(toString() + ".increasePoints");
		tabs--;
		points++;
		if (map.pandasLeft() <= 0) {
			map.gameOver();
			endGame();
		}
	}

	public Map getMap() {
		tabs++;
		logger(toString() + ".getMap");
		tabs--;
		return map;
	}

	public Entrance getEntrance() {
		tabs++;
		logger(toString() + ".getEntrance");
		tabs--;
		return entrance;
	}

	@Override
	public String toString() {
		return "Game";
	}
}
