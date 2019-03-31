package skeleton;

import static skeleton.Application.*;
import java.util.ArrayList;

public class Arcade extends Thing{

    public void step() {
		
	}

	/**
	 * Lekéri a szomszédait, amin ha áll állat, meghívja rá az őt megijesztő függvényt.
	 */
    public void jingle() {
		tabs++;
        logger(toString() + ".jingle");

        ArrayList<Field> neighs = this.getField().getNeighbors();
		if(neighs != null){
			for(Field field : neighs) {
				Animal tempAnimal = field.getAnimal();
				if (tempAnimal != null)
                    tempAnimal.scare();
			}
		}
		tabs--;
	}

	/**
	 * Megnézi, hogy a paraméterként kapott állat tud-e interakcióba lépni.
	 * @param a
	 * @return
	 */
    public boolean interactWith(Animal a) {
		tabs++;
        logger(toString() + ".interactWith");
		tabs--;
		return false;
	}

	/**
	 * ToString override.
	 * @return
	 */
	@Override
	public String toString() {
		return "Arcade";
	}
}
