/**
 * Szekrény osztály, Thing leszármazott. Állatot teleportál.
 */
public class Cabinet extends Thing{

    public Cabinet(String name, Field field){
        super(name, field);
    }

    /**
     * Szomszédos szekrény.
     */
    private Cabinet neighborCabinet;

    /**
     * Továbbadja a belemenő állatokat.
     */
    public void step() {
        Field cabinetField = this.getField();
        Animal animalOnCabinet = cabinetField.getAnimal();

        Field neighborCabinetField = neighborCabinet.getField();
        Animal animalOnNeighborCabinet = neighborCabinetField.getAnimal();
        if(animalOnNeighborCabinet == null){
            neighborCabinet.teleport(animalOnCabinet);
        }
    }

    /**
     * Mint egy Move, csak a szekrény által összekötött mezők között.
     * @param a
     */
    public void teleport(Animal a) {
        Field animalField = a.getField();
        if(a.getFollower() != null) {
            a.getFollower().follow(a);
        }else{
            animalField.remove(a);
        }
        this.field.accept(a);
    }

    /**
     * A szekrény a paraméterként kapott állattal interakcióba lép, átteleportálja.
     * @param a
     * @return
     */
    public boolean interactWith(Animal a) {
        return true;
    }

    /**
     * Beállítja a szomszédos szekrényt.
     * @param nbcabinet
     */
    public void setNeighborCabinet(Cabinet nbcabinet) {
        this.neighborCabinet = nbcabinet;
    }

    @Override
    public String toString() {
        return "Cabinet";
    }
}

