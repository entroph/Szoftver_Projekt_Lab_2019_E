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
        logger(toString() + ".getNeighbors");
		tabs--;
		return neighbors;
	}

    public void setNeighbor(Field neighborField) {
		tabs++;
        logger(toString() + ".setNeighbor");
		tabs--;
		neighbors.add(neighborField);
		//neighborField.SetNeighbor(this); //Nem tudom ez miert nem mukodik, majd gondolkodjon rajta valaki
	}

    public void accept(Animal a) {
		tabs++;
        logger(toString() + ".accept");
		tabs--;
		animal = a;
		a.setField(this);
	}

    public void remove(Animal a) {
		tabs++;
        logger(toString() + ".remove");
		tabs--;
		animal = null;
	}
	
	public Thing getThing() {
		tabs++;
		logger(toString() + ".getThing");
		tabs--;
		return thing;

	}

	public void setThing(Thing t){
		this.thing = t;
	}

    public void delete() {
		
	}
	
	public Animal getAnimal() {
		tabs++;
		logger(toString() + ".getAnimal");
		tabs--;
		return animal;
	}

	public void setAnimal(Animal a){
		this.animal = a;
	}

    public void decreaseHitpoints(int amount) {
		tabs++;
        logger(toString() + ".decreaseHitpoints (Happens nothing)");
		tabs--;
	}

	@Override
	public String toString() {
		return "Field";
	}
	
}
