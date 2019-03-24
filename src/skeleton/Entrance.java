package skeleton;

import static skeleton.Application.*;

public class Entrance extends Field{

	public void Accept(Animal a) {
		tabs++;
		logger(toString() + ".Accept");
		tabs--;
		this.setAnimal(a);
		a.setField(this);
	}

	@Override
	public String toString() {
		return "Entrance";
	}
}
