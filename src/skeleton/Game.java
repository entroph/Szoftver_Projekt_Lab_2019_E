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
		StartGame();
	}

	public void StartGame() {
		System.out.println("Game started");
	}
	
	public void EndGame() {
		tabs++;
		logger(toString() + ".EndGame (Here is the end, but for the convenience of the testing, the application does not exits.)");
		tabs--;
	}
	
	public void IncreasePoints() {
		tabs++;
		logger(toString() + ".IncreasePoints");
		tabs--;
		points++;
		if(map.PandasLeft() <= 0){
			map.GameOver();
			EndGame();
		}
	}
	
	public Map GetMap() {
		tabs++;
		logger(toString() + ".GetMap");
		tabs--;
		return map;
	}
	
	public Entrance GetEntrance() {
		tabs++;
		logger(toString() + ".GetEntrance");
		tabs--;
		return entrance;
	}

	@Override
	public String toString() {
		return "Game";
	}
}
