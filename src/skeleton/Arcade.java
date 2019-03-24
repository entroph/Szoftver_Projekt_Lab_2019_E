package skeleton;

import static skeleton.Application.*;
import java.util.ArrayList;

public class Arcade extends Thing{

	public void Step() {
		
	}
	
	public void Jingle() {
		tabs++;
		logger(toString() + ".Jingle");

		ArrayList<Field> neighs = this.GetField().getNeighbors();
		if(neighs != null){
			for(Field field : neighs) {
				Animal tempAnimal = field.getAnimal();
				if (tempAnimal != null)
					tempAnimal.Scare();
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
		return "Arcade";
	}
}
