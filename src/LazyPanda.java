/**
 * A lusta panda osztálya, le tud ülni fotelba.
 */
public class LazyPanda extends Panda{

    //Ül-e fotelban.
    private boolean sitting;

    public LazyPanda(Field field) {
        super(field);
    }

    /**
     * Konstruktor, meghívja az őst.
     * @param cf
     */
    /*public LazyPanda(Field cf) {
        super(cf);
    }*/

    /**
     * Beül a paraméterként kapott fotelba.
     * @param f
     */
    public boolean lazy(Fotel f) {
        following.setFollower(null);
        setFollowing(null);
        this.getField().setAnimal(null);
        setSitting(true);
        setField(f.getField());
        f.setPanda(this);
        f.getField().setAnimal(this);
        //move(f.getField());
        release();
        return true;
    }

    /**
     * Kiszáll a paraméterként kapott fotelből.
     * @param f
     */
    public void unLazy(Fotel f) {
        setSitting(false);
    }

    /**
     * u.a. mint az ősé.
     */
    public void move(Field f) {
        if(!sitting) {
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
    }

    public void setSitting(boolean value) {
        sitting = value;
    }

    @Override
    public String toString(){
        return "lazypanda";
    }
}
