package skeleton;

import java.util.ArrayList;
import static skeleton.Application.*;

public class Map {

	private ArrayList<Field> fields;
	private int numberOfPandas;
	
	public void GameOver() {
		tabs++;
		logger(toString() + ".GameOver");
		tabs--;
	}
	
	public int PandasLeft() {
		tabs++;
		logger(toString() + ".PandasLeft");
		tabs--;
		return numberOfPandas;
	}
	
	public void DecreasePandas() {
		tabs++;
		logger(toString() + ".DecreasePandas");
		tabs--;
		numberOfPandas--;
	}

	public void SetNumberOfPandas(int amount){
		this.numberOfPandas = amount;
	}

	@Override
	public String toString() {
		return "Map";
	}
}
