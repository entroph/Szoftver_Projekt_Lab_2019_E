import java.util.ArrayList;

public class VendingMachine extends Thing{

    public VendingMachine(String name, Field field){
        super(name, field);
    }

    public void step() {
        beep();
    }

    /**
     * Sípol egyet, meghívja a szomszédos mezőkre, és ha van rajtuk állat, azokon a Jump-ot.
     */
    public void beep() {
        ArrayList<Field> neighs = this.getField().getNeighbors();
        if(neighs != null){
            for(Field field : neighs) {
                Animal tempAnimal = field.getAnimal();
                if (tempAnimal != null)
                    tempAnimal.jump();
            }
        }
    }

    /**
     * A Csokiautomata a paraméterként kapott állattal interakcióba lép, ugrik egyet a panda
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
        return "VendingMachine";
    }
}