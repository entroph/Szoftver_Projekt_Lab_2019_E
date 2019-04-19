import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * A pálya osztálya, tárolja a mezőket és a pandák számát.
 */
public class Map {

    //A pálya mezői egy listában.
    private ArrayList<Field> fields;
    //A még pályán lévő pandák.
    private int numberOfPandas;


    public Map(String mapname) throws FileNotFoundException {
        fields = new ArrayList<Field>();
        File f = new File(mapname);
        Scanner sc = new Scanner(f);
        String split[];
        while(sc.hasNextLine()){
            String data = sc.nextLine();
            if(data.equals("map")){
                split = sc.nextLine().split(",");
                for (int i = 0; i < Integer.parseInt(split[0]); i++) {
                    fields.add(new Field());
                }
                for (int i = 0; i < Integer.parseInt(split[1]); i++) {
                    fields.add(new WeakField());
                }
                split = sc.nextLine().split(",");
                if(!split[0].equals("") && !split[1].equals("")){
                    fields.set(Integer.parseInt(split[0])-1, new Entrance());
                    fields.set(Integer.parseInt(split[1])-1, new Exit());
                }
            }

            if(data.equals("neighbors")){
                while(sc.hasNextLine() && !(data = sc.nextLine()).equals("")){
                    split = data.split(",");
                    for (int i = 1; i < split.length; i++) {
                        fields.get(Integer.parseInt(split[0])-1).setNeighbor(fields.get(Integer.parseInt(split[i])-1));
                    }
                }
            }

            if(data.equals("arcade")){
                while(sc.hasNextLine() && !(data = sc.nextLine()).equals("")){
                    split = data.split(",");
                    fields.get(Integer.parseInt(split[0])-1).setThing(new Arcade());
                    fields.get(Integer.parseInt(split[0])-1).getThing().setField(fields.get(Integer.parseInt(split[0])-1));
                }
            }

            if(data.equals("vendingmachine")){
                while(sc.hasNextLine() && !(data = sc.nextLine()).equals("")){
                    split = data.split(",");
                    fields.get(Integer.parseInt(split[0])-1).setThing(new VendingMachine());
                    fields.get(Integer.parseInt(split[0])-1).getThing().setField(fields.get(Integer.parseInt(split[0])-1));
                }
            }

            if(data.equals("fotel")){
                while(sc.hasNextLine() && !(data = sc.nextLine()).equals("")){
                    split = data.split(",");
                    fields.get(Integer.parseInt(split[0])-1).setThing(new Fotel());
                    fields.get(Integer.parseInt(split[0])-1).getThing().setField(fields.get(Integer.parseInt(split[0])-1));
                }
            }

            if(data.equals("cabinet")){
                while(sc.hasNextLine() && !(data = sc.nextLine()).equals("")){
                    split = data.split(",");
                    Cabinet a = new Cabinet();
                    Cabinet b = new Cabinet();
                    a.setNeighborCabinet(b);
                    b.setNeighborCabinet(a);
                    fields.get(Integer.parseInt(split[0])-1).setThing(a);
                    fields.get(Integer.parseInt(split[0])-1).getThing().setField(fields.get(Integer.parseInt(split[0])-1));
                    fields.get(Integer.parseInt(split[1])-1).setThing(b);
                    fields.get(Integer.parseInt(split[1])-1).getThing().setField(fields.get(Integer.parseInt(split[1])-1));
                }
            }
        }
    }
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

