package skeleton;

import java.util.ArrayList;

import static skeleton.Application.*;

public class VendingMachine extends Thing{

	public void step() {
		
	}

	public void beep() {
		tabs++;
		logger(toString() + ".beep");

		ArrayList<Field> neighs = this.getField().getNeighbors();
		if(neighs != null){
			for(Field field : neighs) {
				Animal tempAnimal = field.getAnimal();
				if (tempAnimal != null)
					tempAnimal.jump();
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
		return "VendingMachine";
	}
}
