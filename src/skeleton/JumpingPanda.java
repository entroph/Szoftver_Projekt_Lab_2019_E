package skeleton;

import static skeleton.Application.*;

/**
 * Az ijedtében ugráló panda osztálya
 */
public class JumpingPanda extends Panda {

    /**
     * Ugrik egyet a panda, és csökkenti a Field-jének Hitpoint-ját.
     */
    public void Jump() {
        tabs++;
        logger(toString() + ".jump");
        tabs--;

        this.getField().decreaseHitpoints(5);
    }
}
