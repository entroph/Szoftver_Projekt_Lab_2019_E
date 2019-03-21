package skeleton;

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
		System.out.println("Game ended");
	}
	
	public void IncreasePoints() {
		points++;
		System.out.println("Points increased");
	}
	
	public Map GetMap() {
		System.out.println("GetMap()");
		return map;
	}
	
	public Entrance GetEntrance() {
		System.out.println("GetEntrance()");
		return entrance;
	}
}
