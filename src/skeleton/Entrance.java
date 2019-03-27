package skeleton;

import static skeleton.Application.*;

public class Entrance extends Field{

    public void accept(Animal a) {
		tabs++;
        logger(toString() + ".accept");
		tabs--;
		this.setAnimal(a);
		a.setField(this);
	}

	@Override
	public String toString() {
		return "Entrance";
	}
}
