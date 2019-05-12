import java.util.ArrayList;

public class Arcade extends Thing{

    public Arcade(String name, Field field){ super(name, field); }

    public void step() {
        jingle();
    }

    /**
     * Lekéri a szomszédait, amin ha áll állat, meghívja rá az őt megijesztő függvényt.
     */
    public void jingle() {
        ArrayList<Field> neighs = this.getField().getNeighbors();
        if(neighs != null){
            for(Field field : neighs) {
                Animal tempAnimal = field.getAnimal();
                if (tempAnimal != null)
                    tempAnimal.scare();
            }
        }
    }

    /**
     * Megnézi, hogy a paraméterként kapott állat tud-e interakcióba lépni.
     * @param a
     * @return
     */
    public boolean interactWith(Animal a) {
        return false;
    }

    /**
     * ToString override.
     * @return
     */
    @Override
    public String toString() {
        return "arcade";
    }
}

