import java.util.Random;

/**
 * A panda osztály megvalósítása.
 */
public class Panda extends Animal{
    //A sorban előtte menő állat.
    Animal following;

    /**
     * Konstruktor.
     */
    public Panda(Field field){
        super(field);
        following = null;
    }


    public void step(){
        if(following == null) {
            Random r = new Random();
            if(this.getField() != null) {
                int nb = r.nextInt(this.getField().getNeighbors().size() - 1);
                move(this.getField().getNeighbors().get(nb));
            }
        }
    }

	public void move(Field f) {
            Thing thingOnNewField = f.getThing();
            Animal animalOnNewField = f.getAnimal();
            if (animalOnNewField != null) { //if there is an animal on it, then collide with it
                if (thingOnNewField == null) {
                    this.collideWith(animalOnNewField);
                }
            } else {
                if (thingOnNewField == null) {
                    this.field.remove(this);
                    f.accept(this);
                }
            }
	}

    /**
     * Ütközik a paraméterként kapott állattal.
     * @param a ütközés alanya.
     */
    public void collideWith(Animal a) {
        a.hit(this);
    }

    /**
     * Eltalál egy orángutánt, és ha még nem követ senkit, helyet cserélnek és beáll a sorába.
     * @param o
     */
    public void hit(Orangutan o) {
        //Needed to check, because if its already guided by another Orangutan, then it can't be caught by the Orangutan
        if (this.getFollowing() != null)
            return;

        Panda follower = (Panda) o.getFollower();
        o.setFollower(this);
        this.setFollowing(o);
        if(follower != null){
            this.setFollower(follower);
            follower.setFollowing(this);
        }
        o.swap(this);
    }

    /**
     * Eltalál egy pandát, semmi nem történik.
     * @param p
     */
    public void hit(Panda p) {
    }

    /**
     * Megöli a pandát, és az elötte állónak a followerjét nullra állítja és releasel.
     *
     */
    public void die(){
        if(following != null){
            following.setFollower(null);
        }
        release();
    }

    /**
     * Kijárat mezőn áll, meghívja az őt eltávolító függvényeket.
     */
    public void leave() {
            if (follower != null) {
                follower.follow(this);
            }else{
                this.getField().setAnimal(null);
            }
            this.setField(null);
            Map map = Game.getInstance().getMap();
            map.decreasePandas();
            Game.getInstance().increasePoints();
    }

    /**
     * Beállítja a paraméterként kapott állatot követettjének.
     * @param a
     */
    public void setFollowing(Animal a) {
        this.following = a;
    }

    /**
     * Visszatér a követettjével.
     * @return
     */
    public Animal getFollowing() {
        return following;
    }

    /**
     * Beállítja az őt követő állatot.
     * @param a
     */
    public void setFollower(Animal a) {
        this.follower = a;
    }

    /**
     * Visszatér a követőjével.
     * @return
     */
    public Animal getFollower() {
        return follower;
    }

    /**
     * Visszatér azzal a mezővel amelyiken áll.
     * @return
     */
    public Field getField() {
        return field;
    }

    /**
     * Ha megijed, elengedi a mögötte állók kezét, törli a follower-t.
     */
    public void scare() {
    }

    /**
     * ToString override.
     * @return
     */
    @Override
    public String toString(){
        return "panda";
    }
}