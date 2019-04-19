/**
 * Az orángután osztálya, a játékos irányítása alatt.
 */
public class Orangutan extends Animal{

    //In the finished application, there will be no need for this function here
    //now this is only here, because we need to log "orangutan collidewith" or "panda collidewith"
    public void collideWith(Animal a) {
        a.hit(this);
    }

    /**
     * Ütközik a paraméterként kapott orángutánnal, de semmi érdemi történést nem vált ki.
     * @param o
     */
    public void hit(Orangutan o) {

    }

    /**
     * A paraméterként kapott pandával ütközik.
     * @param p
     */
    public void hit(Panda p) {

    }

    /**
     * Lekéri az őt követő állatot.
     * @return
     */
    public Animal getFollower() {
        return follower;
    }

    /**
     * Beállítja a paraméterként kapott állatot követőnek (csak panda lehet)
     * @param a
     */
    public void setFollower(Animal a) {
        this.follower = a;
    }

    /**
     * Visszaadja a mezőt amelyiken áll.
     * @return
     */
    public Field getField() {
        return field;
    }

    /**
     * Pálya elhagyása a kijáraton.
     */
    public void leave() {
        if(follower != null)
            follower.follow(this);

        Entrance ent = Game.getInstance().getEntrance();
        ent.accept(this);
    }

    /**
     * ToString override.
     * @return
     */
    @Override
    public String toString() {
        return "Orangutan";
    }
}
