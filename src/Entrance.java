import java.util.ArrayList;

/**
 * Bejárat mezőt reprezentál.
 */
public class Entrance extends Field implements Steppable{

    public Entrance(String name){
        neighbors = new ArrayList<Field>();
        animal =  null;
        thing = null;
        this.name = name;
    }

    /**
     * A Field-re teszi a paraméterként kapott állatot.
     * @param a
     */
    public void accept(Animal a) {
        this.setAnimal(a);
        a.setField(this);
    }

    @Override
    public void step() {

    }
}