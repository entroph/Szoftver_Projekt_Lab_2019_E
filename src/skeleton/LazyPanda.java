package skeleton;

import static skeleton.Application.*;

/**
 * A lusta panda osztálya, le tud ülni fotelba.
 */
public class LazyPanda extends Panda{

	//Ül-e fotelban.
	private boolean sitting;

	public LazyPanda(){}

	/**
	 * Konstruktor, meghívja az őst.
	 * @param cf
	 */
	public LazyPanda(Field cf) {
		super(cf);
	}

	/**
	 * Beül a paraméterként kapott fotelba.
	 * @param f
	 */
	public boolean lazy(Fotel f) {
		tabs++;
		logger(toString() + ".lazy");
		setSitting(true);
		setField(f.getField());
		release();
		tabs--;
		return true;
	}

	/**
	 * Kiszáll a paraméterként kapott fotelből.
	 * @param f
	 */
	public void unLazy(Fotel f) {
		tabs++;
		setSitting(false);
		logger(toString() + ".unLazy");
		tabs--;
	}

	/**
	 * u.a. mint az ősé.
	 */
	public void move() {

	}

	public void setSitting(boolean value) {
		sitting = value;
	}
}
