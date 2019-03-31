package skeleton;

import static skeleton.Application.*;

public class Animal {
    /**
     * Az orángutánt vagy pandát követő állatot tárolja.
     */
    Animal follower;
    /**
     * Az a mező, amelyiken az állat áll.
     */
    Field field;

    /**
     * Az állat mozgatása a paraméterként kapott mezőre.
     * @param newField
     */
    public void move(Field newField) {
        tabs++;
        logger(toString() + ".move");
        Thing thingOnNewField = newField.getThing();
        Animal animalOnNewField = newField.getAnimal();
        if (animalOnNewField != null) { //if there is an animal on it, then collide with it
            this.collideWith(animalOnNewField);
        } else {
            if (thingOnNewField != null) {
                if (thingOnNewField.interactWith(this)) { //if returns true, animal can move to that field
                    if (follower != null) {
                        follower.follow(this);
                    }
                    this.field.remove(this);
                    newField.accept(this);
                }
            } else {
                if (follower != null)
                    follower.follow(this);
                this.field.remove(this);
                newField.accept(this);
            }
        }
        tabs--;
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
        tabs++;
        logger(toString() + ".die");
        release();
        tabs--;
    }

    /**
     * A megfelelő panda bele fog ülni a fotelba, a többi állat nem reagál.
     * @param f
     */
    public boolean lazy(Fotel f) {
        tabs++;
        logger(toString() + ".lazy");
        tabs--;
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
        tabs++;
        logger(toString() + ".swap");
        Field newField = a.getField();
        this.field.remove(this);
        newField.remove(a);
        newField.accept(this);
        this.field.accept(a);
        tabs--;
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
        tabs++;
        logger(toString() + ".follow");
        Field newField = a.getField();
        newField.accept(this);
        this.field.remove(this);
        tabs--;
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
        tabs++;
        logger(toString() + ".release");
        tabs--;
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

    @Override
    public String toString() {
        return "Animal";
    }
}
