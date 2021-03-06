import java.util.ArrayList;

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

    String name;

    /**
     * Konstruktor, beállítja a szomszédokat, és az objektumait.
     */
    public Field(){
        neighbors = new ArrayList<Field>();
        animal =  null;
        thing = null;
        name = null;
    }

    public Field(String name){
        neighbors = new ArrayList<Field>();
        animal =  null;
        thing = null;
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    /**
     * Szomszédok elkérése.
     * @return
     */
    public ArrayList<Field> getNeighbors()
    {
        return neighbors;
    }

    /**
     * Szomszédlista beállítása.
     * @param neighborField
     */
    public void setNeighbor(Field neighborField) {
        neighbors.add(neighborField);
        //neighborField.SetNeighbor(this); //Nem tudom ez miert nem mukodik, majd gondolkodjon rajta valaki
    }

    /**
     * Mezőre tevése a paraméterként kapott állatnak.
     * @param a
     */
    public void accept(Animal a) {
        animal = a;
        a.setField(this);
    }

    /**
     * Paraméterként kapott állat eltávolítása a mezőről.
     * @param a
     */
    public void remove(Animal a) {
        animal = null;
    }

    /**
     * Mezőn lévő tárgy elkérése.
     * @return
     */
    public Thing getThing() {
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
    }

    /**
     * ToString override.
     * @return
     */
    @Override
    public String toString() {
        String animalName = "";
        if(animal == null || animal.getName().isEmpty())
            animalName = "-";
        else
            animalName = animal.getName();

        return name + " " + animalName;
    }

    public void setHitpoints(int amount) {}
}