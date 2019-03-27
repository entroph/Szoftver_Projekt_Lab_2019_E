package skeleton;

import java.util.ArrayList;
import static skeleton.Application.*;

public class Map {

	private ArrayList<Field> fields;
	private int numberOfPandas;

    public void gameOver() {
		tabs++;
        logger(toString() + ".gameOver");
		tabs--;
	}

    public int pandasLeft() {
		tabs++;
        logger(toString() + ".pandasLeft");
		tabs--;
		return numberOfPandas;
	}

    public void decreasePandas() {
		tabs++;
        logger(toString() + ".decreasePandas");
		tabs--;
		numberOfPandas--;
	}

    public void setNumberOfPandas(int amount) {
		this.numberOfPandas = amount;
	}

	@Override
	public String toString() {
		return "Map";
	}
}
