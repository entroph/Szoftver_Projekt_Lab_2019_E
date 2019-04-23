public class Game {

    //Az adott pálya
    private Map map;
    //A játékos pontjai
    private int points;
    //A bejárat a pályán.
    private Entrance entrance;

    private static Game ourInstance = new Game();

    public static Game getInstance() {
        return ourInstance;
    }


    /**
     * Konstruktor, létrehozza a pályát, és nullázza a pontokat.
     */
    private Game() {
        //map = new Map();
        points = 0;
        entrance = new Entrance();
        startGame();
    }

    /**
     * Játék indítása.
     */
    public void startGame() {
    }

    /**
     * Játék vége.
     */
    public void endGame() {

    }

    /**
     * Pontok növelése
     */
    public void increasePoints() {
        points++;
        if (map.pandasLeft() <= 0) {
            map.gameOver();
            endGame();
        }
    }

    /**
     * Aktuális pálya elkérése.
     * @return
     */
    public Map getMap() {
        return map;
    }

    /**
     * Aktuális pálya beállítása
     */
    public void setMap(Map map){
        this.map = map;
    }

    /**
     * Bejárat elkérése.
     * @return
     */
    public Entrance getEntrance() {
        return entrance;
    }

    /**
     * ToString override.
     * @return
     */
    @Override
    public String toString() {
        return "Game";
    }
}
