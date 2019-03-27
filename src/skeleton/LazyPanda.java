package skeleton;

import static skeleton.Application.*;

public class LazyPanda extends Panda{

	private boolean sitting;

	public LazyPanda(){}

	public LazyPanda(Field cf) {
		super(cf);
	}

	public boolean lazy(Fotel f) {
		tabs++;
		logger(toString() + ".lazy");
		setSitting(true);
		setField(f.getField());
		release();
		tabs--;
		return true;
	}

	public void unLazy(Fotel f) {
		tabs++;
		setSitting(false);
		logger(toString() + ".unLazy");
		tabs--;
	}

	public void move() {

	}

	public void setSitting(boolean value) {
		sitting = value;
	}
}
