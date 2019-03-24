package skeleton;

import static skeleton.Application.*;

public class Exit extends Field {

	public void Accept(Animal a) {
		tabs++;
		logger(toString() + ".Accept");
		tabs--;
		a.setField(this);
		a.Leave();
	}

	@Override
	public String toString() {
		return "Exit";
	}
}
