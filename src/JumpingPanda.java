/**
 * Az ijedtében ugráló panda osztálya
 */
public class JumpingPanda extends Panda {

    public JumpingPanda(Field field){
        super(field);
    }

    /**
     * Ugrik egyet a panda, és csökkenti a Field-jének Hitpoint-ját.
     */
    public void jump() {
        this.getField().decreaseHitpoints(5);
    }

    @Override
    public String toString(){
        return "jumpingpanda";
    }
}
