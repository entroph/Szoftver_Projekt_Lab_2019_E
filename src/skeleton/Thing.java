/**
 * A pályán lévő tárgyak ősosztálya.
 */
public class Thing implements Steppable{

    //A mező amelyiken van.
    protected Field field;

    //Virtuális, a leszármazottak implementáják.
    public void step() {

    }

    /**
     * Interakcióba lép a paraméterként kapott állattal.
     * @param a
     * @return
     */
    public boolean interactWith(Animal a) {
        return false;
    }

    /**
     * A paraméterként kapott mezőre teszi a tárgyat.
     * @param f
     */
    public void setField(Field f) {
        this.field = f;
    }

    /**
     * Visszatér a tárgy mezőjével.
     * @return
     */
    public Field getField() {
        return this.field;
    }

    /**
     * ToString override.
     * @return
     */
    @Override
    public String toString() {
        return "Thing";
    }
}