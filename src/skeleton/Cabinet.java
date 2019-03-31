package skeleton;

import static skeleton.Application.*;

/**
 * Szekrény osztály, Thing leszármazott. Állatot teleportál.
 */
public class Cabinet extends Thing{

	/**
	 * Szomszédos szekrény.
	 */
	private Cabinet neighborCabinet;

	/**
	 * Továbbadja a belemenő állatokat.
	 */
    public void step() {
		tabs++;
        logger(toString() + ".step");

        Field cabinetField = this.getField();
		Animal animalOnCabinet = cabinetField.getAnimal();

        Field neighborCabinetField = neighborCabinet.getField();
		Animal animalOnNeighborCabinet = neighborCabinetField.getAnimal();
		if(animalOnNeighborCabinet == null){
            neighborCabinet.teleport(animalOnCabinet);
		}
		tabs--;
	}

	/**
	 * Mint egy Move, csak a szekrény által összekötött mezők között.
	 * @param a
	 */
    public void teleport(Animal a) {
		tabs++;
        logger(toString() + ".teleport");
		tabs--;
        Field animalField = a.getField();
        this.field.accept(a);
        animalField.remove(a);
	}

	/**
	 * A szekrény a paraméterként kapott állattal interakcióba lép, átteleportálja.
	 * @param a
	 * @return
	 */
    public boolean interactWith(Animal a) {
		tabs++;
        logger(toString() + ".interactWith");
		tabs--;
		return true;
	}

	/**
	 * Beállítja a szomszédos szekrényt.
	 * @param nbcabinet
	 */
    public void setNeighborCabinet(Cabinet nbcabinet) {
		tabs++;
        logger(toString() + ".setNeighborCabinet");
		tabs--;
		this.neighborCabinet = nbcabinet;
	}

	@Override
	public String toString() {
		return "Cabinet";
	}
}
