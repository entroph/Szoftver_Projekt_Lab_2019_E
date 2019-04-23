import java.util.ArrayList;

/**
 * A steppable interface-t megvalósító osztályokat gyűjti össze.
 */
public class Timer {

    //Az összes steppable listája.
    private static ArrayList<Steppable> steppable;

    /**
     * Meghívja a Step-et.
     */
    public void tick() {

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