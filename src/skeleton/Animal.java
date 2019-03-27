package skeleton;

import static skeleton.Application.*;

public class Animal {

    Animal follower;
    Field field;

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

    public void step() {

    }

    public void die() {
        tabs++;
        logger(toString() + ".die");
        release();
        tabs--;
    }

    public boolean lazy(Fotel f) {
        tabs++;
        logger(toString() + ".lazy");
        tabs--;
        return false;
    }

    public void unLazy(Fotel f) {

    }

    public void jump() {

    }

    public void scare() {

    }

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

    public Field getField() {
        return field;
    }

    public void setField(Field f) {
        field = f;
    }

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

    public void collideWith(Animal a) {

    }

    public void hit(Orangutan o) {

    }

    public void hit(Panda p) {

    }

    public void release() {
        tabs++;
        logger(toString() + ".release");
        tabs--;
    }

    public void setFollower(Animal a) {

    }

    public Animal getFollower() {
        return follower;
    }

    @Override
    public String toString() {
        return "Animal";
    }
}
