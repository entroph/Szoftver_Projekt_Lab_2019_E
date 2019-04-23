import java.util.ArrayList;

/**
 * A steppable interface-t megvalósító osztályokat gyűjti össze.
 */
public class Timer {

    private static Timer ourInstance = new Timer();

    public static Timer getInstance() {
        return ourInstance;
    }

    private Timer(){ }

    //Az összes steppable listája.
    private static ArrayList<Steppable> steppable;

    /**
     * Meghívja a Step-et.
     */
    public void tick() {
        if (steppable != null){
            for (Steppable s:steppable) {
                s.step();
            }
        }
    }

    /**
     * Steppable hozzáadása a listához.
     * @param s
     */
    public void addSteppable(Steppable s) {
        steppable.add(s);
    }

    /**
     * Paraméterként kapott steppable eltávolítása a listából.
     * @param s
     */
    public void removeSteppable(Steppable s) {
        steppable.remove(s);
    }

}