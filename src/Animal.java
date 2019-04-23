import com.sun.jdi.event.StepEvent;

public class Animal implements Steppable {
    /**
     * Az orángutánt vagy pandát követő állatot tárolja.
     */
    Animal follower;
    /**
     * Az a mező, amelyiken az állat áll.
     */
    Field field;

    String name;

    public Animal(String name, Field field){
        this.name = name;
        this.field = field;
        this.follower = null;
        Timer.getInstance().addSteppable(this);
    }

    /**
     * Az állat mozgatása a paraméterként kapott mezőre.
     * @param newField
     */
    public void move(Field newField) {
        Thing thingOnNewField = newField.getThing();
        Animal animalOnNewField = newField.getAnimal();
        if (animalOnNewField != null) { //if there is an animal on it, then collide with it
            this.collideWith(animalOnNewField);
        }
        else {
            if (thingOnNewField != null) {
                if (thingOnNewField.interactWith(this)) { //if returns true, animal can move to that field
                    if (follower != null) {
                        follower.follow(this);
                    }
                    this.field.remove(this);
                    newField.accept(this);
                }
            }
            else {
                if (follower != null)
                    follower.follow(this);
                else {
                    this.field.remove(this);
                }
                newField.accept(this);
            }
        }
    }

    /**
     * További függvényeket hív meg.
     */
    public void step() {

    }

    /**
     * Állat halála.
     */
    public void die() {
        release();
    }

    /**
     * A megfelelő panda bele fog ülni a fotelba, a többi állat nem reagál.
     * @param f
     */
    public boolean lazy(Fotel f) {
        return false;
    }

    /**
     * A fotelban ülő állat kiszáll, a többi állat nem reagál.
     * @param f
     */
    public void unLazy(Fotel f) {

    }

    /**
     * Az ugró panda ugrik, a többi állat nem reagál.
     */
    public void jump() {

    }

    /**
     * Az ijedős panda megijed, a többi állat nem reagál.
     */
    public void scare() {

    }

    /**
     * Két állat helyet cserél.
     * @param a
     */
    public void swap(Animal a) {
        //Field newField = a.getField();
        //this.field.remove(this);
        //newField.remove(a);
        //newField.accept(this);
        //this.field.accept(a);

        Field temp1 = a.getField();
        Field temp2 = this.getField();
        temp1.remove(a);
        temp2.remove(this);
        temp1.accept(this);
        temp2.accept(a);
    }

    /**
     * Az aktuális mejő elkérése.
     * @return aktuális mező.
     */
    public Field getField() {
        return field;
    }

    public void setField(Field f) {
        field = f;
    }

    /**
     * Sorban álló állat követi a paraméterként kapottat.
     * @param a előtte álló állat.
     */
    public void follow(Animal a) {
        Field newField = a.getField();
        this.field.remove(this);
        newField.accept(this);
        newField.setAnimal(this);
    }

    public void leave() {

    }

    /**
     * Ütközik a paraméterként kapott állattal.
     * @param a ütközés alanya.
     */
    public void collideWith(Animal a) {

    }

    /**
     * Orángutánnal ütközés, virtuális.
     * @param o
     */
    public void hit(Orangutan o) {

    }

    /**
     * Pandával ütközés.
     * @param p
     */
    public void hit(Panda p) {

    }

    public void release() {
            Panda follower = (Panda) this.getFollower();
            while(follower != null){
                follower.setFollowing(null);
                follower = (Panda) follower.getFollower();
            }

    }

    /**
     * Követő beállítása.
     * @param a
     */
    public void setFollower(Animal a) {

    }

    /**
     * Követő visszaadása.
     * @return
     */
    public Animal getFollower() {
        return follower;
    }

    public String getName(){
        return this.name;
    }

    @Override
    public String toString() {
        return "Animal";
    }
}