package skeleton;

import static skeleton.Application.*;

public class JumpingPanda extends Panda{

	public void Jump() {
		tabs++;
		logger(toString() + ".Jump");
		tabs--;

		this.GetField().DecreaseHitpoints(5);
	}
}
