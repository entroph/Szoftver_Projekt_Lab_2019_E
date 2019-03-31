package skeleton;

import java.util.ArrayList;
import static skeleton.Application.*;

/**
 * A pálya osztálya, tárolja a mezőket és a pandák számát.
 */
public class Map {

	//A pálya mezői egy listában.
	private ArrayList<Field> fields;
	//A még pályán lévő pandák.
	private int numberOfPandas;

	/**
	 * Játék vége, tovább hívja a Game EndGame függvényét.
	 */
    public void gameOver() {
		tabs++;
        logger(toString() + ".gameOver");
		tabs--;
	}

	/**
	 * Visszakéri a pályán lévő pandák számát.
	 * @return
	 */
    public int pandasLeft() {
		tabs++;
        logger(toString() + ".pandasLeft");
		tabs--;
		return numberOfPandas;
	}

	/**
	 * Csökkenti a pandák számát.
	 */
    public void decreasePandas() {
		tabs++;
        logger(toString() + ".decreasePandas");
		tabs--;
		numberOfPandas--;
	}

	/**
	 * Beállítja a paraméterként kapott mennyiségre a pandák számát.
	 * @param amount
	 */
    public void setNumberOfPandas(int amount) {
		this.numberOfPandas = amount;
	}

	/**
	 * ToString override.
	 * @return
	 */
	@Override
	public String toString() {
		return "Map";
	}
}
