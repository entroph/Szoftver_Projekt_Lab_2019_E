package skeleton;

import static skeleton.Application.*;

/**
 * Kijárat mező osztálya.
 */
public class Exit extends Field {

	/**
	 * A Field-re teszi a paraméterként kapott állatot, majd eltünteti azt.
	 * @param a
	 */
    public void accept(Animal a) {
		tabs++;
        logger(toString() + ".accept");
		tabs--;
		a.setField(this);
        a.leave();
	}

	/**
	 * ToString override.
	 * @return
	 */
	@Override
	public String toString() {
		return "Exit";
	}
}
