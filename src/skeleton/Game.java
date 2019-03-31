package skeleton;

import static skeleton.Application.*;

/**
 * Játék osztály, kezeli a globális eventeket.
 */
public class Game {

	//Az adott pálya
	private Map map;
	//A játékos pontjai
	private int points;
	//A bejárat a pályán.
	private Entrance entrance;

	/**
	 * Konstruktor, létrehozza a pályát, és nullázza a pontokat.
	 */
	public Game() {
		System.out.println("Game created");
		map = new Map();
		points = 0;
		entrance = new Entrance();
		startGame();
	}

	/**
	 * Játék indítása.
	 */
	public void startGame() {
		System.out.println("Game started");
	}

	/**
	 * Játék vége.
	 */
	public void endGame() {
		tabs++;
		logger(toString() + ".endGame (Here is the end, but for the convenience of the testing, the application does not exits.)");
		tabs--;
	}

	/**
	 * Pontok növelése
	 */
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

	/**
	 * Aktuális pálya elkérése.
	 * @return
	 */
	public Map getMap() {
		tabs++;
		logger(toString() + ".getMap");
		tabs--;
		return map;
	}

	/**
	 * Bejárat elkérése.
	 * @return
	 */
	public Entrance getEntrance() {
		tabs++;
		logger(toString() + ".getEntrance");
		tabs--;
		return entrance;
	}

	/**
	 * ToString override.
	 * @return
	 */
	@Override
	public String toString() {
		return "Game";
	}
}
