package skeleton;

import java.util.ArrayList;

import static skeleton.Application.*;


public class Field {

	ArrayList<Field> neighbors;
	Animal animal;
	Thing thing;
	
	public ArrayList<Field> getNeighbors(){
		return neighbors;
	}
	
	public void Accept(Animal a) {
		tabs++;
		logger(toString() + ".Accept");
		tabs--;
		animal = a;
		a.setField(this);
	}
	
	public void Remove(Animal a) {
		tabs++;
		logger(toString() + ".Remove");
		tabs--;
		animal = null;
	}
	
	public Thing getThing() {
		tabs++;
		logger(toString() + ".getThing");
		tabs--;
		if(yesno("Van a mezőn tárgy?")){
			return thing;
		}else{
			return null;
		}

	}
	
	public void Delete() {
		
	}
	
	public Animal getAnimal() {
		tabs++;
		logger(toString() + ".getAnimal");
		tabs--;
		if(yesno("Van a mezőn állat?")){
			return animal;
		}else{
			return null;
		}
	}
	
	public void decreaseHitpoints(int amount) {
		
	}

	@Override
	public String toString() {
		return "Field";
	}
	
}
