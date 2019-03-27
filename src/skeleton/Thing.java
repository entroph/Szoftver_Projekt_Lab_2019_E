package skeleton;

import static skeleton.Application.*;

public class Thing implements Steppable{

	protected Field field;

	public void step() {
		
	}

	public boolean interactWith(Animal a) {
		return false;
	}

	public void setField(Field f) {
		this.field = f;
	}

	public Field getField() {
		return this.field;
	}

	@Override
	public String toString() {
		return "Thing";
	}
}
