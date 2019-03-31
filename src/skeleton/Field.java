package skeleton;

import java.util.ArrayList;

import static skeleton.Application.*;


/**
 * Mező osztály.
 */
public class Field {

	//Szomszédos mezők listája.
	ArrayList<Field> neighbors;
	//A mezőn lévő állat.
	Animal animal;
	//A mezőn lévő tárgy.
	Thing thing;

	/**
	 * Konstruktor, beállítja a szomszédokat, és az objektumait.
	 */
	public Field(){
		neighbors = new ArrayList<Field>();
		animal =  null;
		thing = null;
	}

	/**
	 * Szomszédok elkérése.
	 * @return
	 */
	public ArrayList<Field> getNeighbors()
	{
		tabs++;
        logger(toString() + ".getNeighbors");
		tabs--;
		return neighbors;
	}

	/**
	 * Szomszédlista beállítása.
	 * @param neighborField
	 */
    public void setNeighbor(Field neighborField) {
		tabs++;
        logger(toString() + ".setNeighbor");
		tabs--;
		neighbors.add(neighborField);
		//neighborField.SetNeighbor(this); //Nem tudom ez miert nem mukodik, majd gondolkodjon rajta valaki
	}

	/**
	 * Mezőre tevése a paraméterként kapott állatnak.
	 * @param a
	 */
    public void accept(Animal a) {
		tabs++;
        logger(toString() + ".accept");
		tabs--;
		animal = a;
		a.setField(this);
	}

	/**
	 * Paraméterként kapott állat eltávolítása a mezőről.
	 * @param a
	 */
    public void remove(Animal a) {
		tabs++;
        logger(toString() + ".remove");
		tabs--;
		animal = null;
	}

	/**
	 * Mezőn lévő tárgy elkérése.
	 * @return
	 */
	public Thing getThing() {
		tabs++;
		logger(toString() + ".getThing");
		tabs--;
		return thing;

	}

	/**
	 * Tárgy beállítása a mezőn.
	 * @param t
	 */
	public void setThing(Thing t){
		this.thing = t;
	}

	/**
	 * Mező törlése (ha összetörik).
	 */
    public void delete() {
		
	}

	/**
	 * Mezőn lévő állat elkérése.
	 * @return
	 */
	public Animal getAnimal() {
		tabs++;
		logger(toString() + ".getAnimal");
		tabs--;
		return animal;
	}

	/**
	 * Mező állatának beállítása.
	 * @param a
	 */
	public void setAnimal(Animal a){
		this.animal = a;
	}

	/**
	 * Hitpoint (élet) csökkentése.
	 * @param amount
	 */
    public void decreaseHitpoints(int amount) {
		tabs++;
        logger(toString() + ".decreaseHitpoints (Happens nothing)");
		tabs--;
	}

	/**
	 * ToString override.
	 * @return
	 */
	@Override
	public String toString() {
		return "Field";
	}
	
}
