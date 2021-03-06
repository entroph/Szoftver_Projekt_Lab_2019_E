import java.util.ArrayList;

/**
 * Kijárat mező osztálya.
 */
public class Exit extends Field implements Steppable{

    public Exit(String name){
        neighbors = new ArrayList<Field>();
        animal =  null;
        thing = null;
        this.name = name;
    }

    /**
     * A Field-re teszi a paraméterként kapott állatot, majd eltünteti azt.
     * @param a
     */
    public void accept(Animal a) {
        a.setField(this);
        a.leave();
    }

    @Override
    public void step() {

    }
}
