/**
 * Az ijedtében ugráló panda osztálya
 */
public class JumpingPanda extends Panda {

    public JumpingPanda(String name, Field field){
        super(name, field);
    }

    /**
     * Ugrik egyet a panda, és csökkenti a Field-jének Hitpoint-ját.
     */
    public void jump() {
        this.getField().decreaseHitpoints(5);
    }
}
