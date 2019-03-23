package skeleton;

import static skeleton.Application.*;

public class Thing implements Steppable{

	private Field field;
	
	public void Step() {
		
	}
	
	public boolean InteractWith(Animal a) {
		tabs++;
		logger(toString() + ".InteractWith");
		tabs--;
		return yesno("Lehet-e interakcióba lépni ezzel a tárggyal?");
	}

	@Override
	public String toString() {
		return "Thing";
	}
}
