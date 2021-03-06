/**
 * Az összetörhető mező osztálya.
 */
public class WeakField extends Field {

    //Életpontjai
    private int hitpoints = 20;

    public WeakField(String name){
        super(name);
    }

    /**
     * Paraméterként kapott állatot elfogadja a mezőn.
     * @param a
     */
    public void accept(Animal a) {
        animal = a;
        a.setField(this);
        decreaseHitpoints(1);
    }

    /**
     * Törli az állatot ami alatt elfogyott a Hitpoint-ja, és felszabadítja a mögötte lévő sort.
     */
    public void delete() {
        Panda follower = (Panda) animal.getFollower();
        while(follower != null){
            //It's enough to set the following to null, because in that case if the Step makes the panda to move
            //only the [following] attribute is checked. If the orangutan catches the panda the follower attribute is
            //overwritten and in that case, only the following is checked again. If the following attribute is not null
            //when the Orangutan tries to catch the Panda, then probably the panda is already guided by another orangutan.
            follower.setFollowing(null);
            follower = (Panda) follower.getFollower();
        }
        remove(getAnimal());
        for (Field n: neighbors) {
            n.getNeighbors().remove(this);
        }
        neighbors = null;
    }

    /**
     * Csökkenti a mező életpontjait.
     * @param amount
     */
    public void decreaseHitpoints(int amount) {
        hitpoints -= amount;
        if(hitpoints <= 0){
            animal.die();
            delete();
        }
    }

    /**
     * Beállítja a paraméterként kapott értékre a mező életpontjait.
     * @param amount
     */
    public void setHitpoints(int amount) {
        this.hitpoints = amount;
    }

    /**
     * ToString override.
     * @return
     */
    @Override
    public String toString() {
        String animalName = "";
        if(animal == null || animal.getName().isEmpty())
            animalName = "-";
        else
            animalName = animal.getName();
        if(hitpoints == 0)
            return "Nincs ilyen mezo!";
        else
            return name + " " + animalName + " " + hitpoints;
    }
}