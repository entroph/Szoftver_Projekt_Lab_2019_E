package skeleton;

import java.util.ArrayList;

import static skeleton.Application.*;


public class Field {

	ArrayList<Field> neighbors;
	Animal animal;
	Thing thing;

	public Field(){
		neighbors = new ArrayList<Field>();
		animal =  null;
		thing = null;
	}

	public ArrayList<Field> getNeighbors()
	{
		tabs++;
		logger(toString() + ".GetNeighbors");
		tabs--;
		return neighbors;
	}

	public void SetNeighbor(Field neighborField) {
		tabs++;
		logger(toString() + ".SetNeighbor");
		tabs--;
		neighbors.add(neighborField);
		//neighborField.SetNeighbor(this); //Nem tudom ez miert nem mukodik, majd gondolkodjon rajta valaki
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
		/*if(yesno("Van a mezőn tárgy?")){
			return thing;
		}else{
			return null;
		}*/
		return thing;

	}

	public void setThing(Thing t){
		this.thing = t;
	}
	
	public void Delete() {
		
	}
	
	public Animal getAnimal() {
		tabs++;
		logger(toString() + ".getAnimal");
		tabs--;
		/*if(yesno("Van a mezőn állat?")){
			return animal;
		}else{
			return null;
		}*/
		return animal;
	}

	public void setAnimal(Animal a){
		this.animal = a;
	}
	public void DecreaseHitpoints(int amount) {
		tabs++;
		logger(toString()+".DecreaseHitpoints (Happens nothing)");
		tabs--;
	}

	@Override
	public String toString() {
		return "Field";
	}
	
}
