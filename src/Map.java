import java.util.ArrayList;

/**
 * A pálya osztálya, tárolja a mezőket és a pandák számát.
 */
public class Map {

    //A pálya mezői egy listában.
    private ArrayList<Field> fields;
    //A még pályán lévő pandák.
    private int numberOfPandas;

    /**
     * Játék vége, tovább hívja a Game EndGame függvényét.
     */
    public void gameOver() {

    }

    /**
     * Visszakéri a pályán lévő pandák számát.
     * @return
     */
    public int pandasLeft() {
        return numberOfPandas;
    }

    /**
     * Csökkenti a pandák számát.
     */
    public void decreasePandas() {
        numberOfPandas--;
    }

    /**
     * Beállítja a paraméterként kapott mennyiségre a pandák számát.
     * @param amount
     */
    public void setNumberOfPandas(int amount) {
        this.numberOfPandas = amount;
    }

    /**
     * ToString override.
     * @return
     */
    @Override
    public String toString() {
        return "Map";
    }
}

