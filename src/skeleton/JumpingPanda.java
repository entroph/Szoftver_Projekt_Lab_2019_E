package skeleton;

import static skeleton.Application.*;

public class JumpingPanda extends Panda {

    public void Jump() {
        tabs++;
        logger(toString() + ".jump");
        tabs--;

        this.getField().decreaseHitpoints(5);
    }
}
