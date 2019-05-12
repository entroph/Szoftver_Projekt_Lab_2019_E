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
    public void move() {

    }

    public void setSitting(boolean value) {
        sitting = value;
    }

    @Override
    public String toString(){
        return "lazypanda";
    }
}
