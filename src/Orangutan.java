/**
 * Az orángután osztálya, a játékos irányítása alatt.
 */
public class Orangutan extends Animal{

    int waitTime = 0;

    public int getWaitTime(){
        return waitTime;
    }

    public void setWaitTime(){
        waitTime = 3;
    }

    public Orangutan(String name, Field field){
        super(name, field);
    }

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
        if(o.getWaitTime() == 0 && o.getFollower() == null && this.getFollower() != null){
            swap(o);
            o.setFollower(this.getFollower());
            this.setFollower(null);
        }

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
        Entrance ent = Game.getInstance().getEntrance();
        ent.accept(this);
    }

    /**
     * ToString override.
     * @return
     */
    @Override
    public String toString() {
        String followerName = "";
        if(follower == null || follower.getName().isEmpty())
            followerName = "-";
        else
            followerName = follower.getName();

        return name + " " + field.getName() + " " + followerName;
    }
}
