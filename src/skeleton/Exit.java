package skeleton;

import static skeleton.Application.*;

public class Exit extends Field {

    public void accept(Animal a) {
		tabs++;
        logger(toString() + ".accept");
		tabs--;
		a.setField(this);
        a.leave();
	}

	@Override
	public String toString() {
		return "Exit";
	}
}
