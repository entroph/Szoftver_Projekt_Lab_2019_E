package skeleton;

import static skeleton.Application.*;

/**
 * Bejárat mezőt reprezentál.
 */
public class Entrance extends Field{

	/**
	 * A Field-re teszi a paraméterként kapott állatot.
	 * @param a
	 */
    public void accept(Animal a) {
		tabs++;
        logger(toString() + ".accept");
		tabs--;
		this.setAnimal(a);
		a.setField(this);
	}

	/**
	 * ToString override.
	 * @return
	 */
	@Override
	public String toString() {
		return "Entrance";
	}
}
