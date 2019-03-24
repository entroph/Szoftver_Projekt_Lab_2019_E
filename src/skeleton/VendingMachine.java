package skeleton;

import java.util.ArrayList;

import static skeleton.Application.*;

public class VendingMachine extends Thing{

	public void Step() {
		
	}
	
	public void Beep() {
		tabs++;
		logger(toString() + ".Beep");

		ArrayList<Field> neighs = this.GetField().getNeighbors();
		if(neighs != null){
			for(Field field : neighs) {
				Animal tempAnimal = field.getAnimal();
				if (tempAnimal != null)
					tempAnimal.Jump();
			}
		}
		tabs--;
	}
	
	public boolean InteractWith(Animal a) {
		tabs++;
		logger(toString() + ".InteractWith");
		tabs--;
		return false;
	}

	@Override
	public String toString() {
		return "VendingMachine";
	}
}
