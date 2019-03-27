package skeleton;

import static skeleton.Application.*;
import java.util.ArrayList;

public class Arcade extends Thing{

    public void step() {
		
	}

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

    public boolean interactWith(Animal a) {
		tabs++;
        logger(toString() + ".interactWith");
		tabs--;
		return false;
	}

	@Override
	public String toString() {
		return "Arcade";
	}
}
