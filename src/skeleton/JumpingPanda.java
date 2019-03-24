package skeleton;

import static skeleton.Application.*;

public class JumpingPanda extends Panda{

	public void Jump() {
		tabs++;
		logger(toString() + ".Jump");
		tabs--;

		this.GetField().DecreaseHitpoints(5); //TODO: Itt az a gond, hogy a GetField egy Field-et ad vissza, függetlenül, hogy az
													   //eredendően WeakField vagy Field.
	}
}
