package skeleton;

import java.util.ArrayList;

import static skeleton.Application.*;

public class Fotel extends Thing{

	//Ennyi ideig ül a fotelben a panda
	private int sitTime;
	//Ül-e a fotelban panda
	private boolean busy;
	//A fotelban ülő panda
	private LazyPanda sittingPanda;

	/**
	 * Konstruktor, beállítja a default értékeket.
	 */
	public Fotel(){
		sitTime = 0;
		busy = false;
		sittingPanda = null;
	}


	/**
	 * Meghívja a szomszédokra a Lazy fv-t, ha van lusta az megpróbál leülni.
	 */
    public void step() {
		tabs++;
        logger(toString() + ".step");
		if(!busy) {
            ArrayList<Field> neighs = this.getField().getNeighbors();
			if (neighs != null) {
				for (Field field : neighs) {
					Animal tempAnimal = field.getAnimal();
					if (tempAnimal != null) {
                        if (tempAnimal.lazy(this)) {
							break;
						}
						//Only one panda can sit into a Fotel, so the first one sits down in it
						// and the Fotel has no effect on the rest of them even if there are more pandas
					}
				}
			}
		}else{
			sitTime--;
			if(sitTime == 0){
                empty();
			}
		}
		tabs--;
	}

	/**
	 * Fotelből kiszáll a panda.
	 */
    public void empty() {
        sittingPanda.unLazy(this);
        setBusy(false);
        setSitTime(5);
	}

	/**
	 * Beállítja a fotelben ülő pandát.
	 * @param p
	 */
    public void setPanda(LazyPanda p) {
		sittingPanda = p;
	}

    public void setSitTime(int amount) {
        sitTime = amount;
    }

    public void setBusy(boolean busy) {
        this.busy = busy;
    }

	/**
	 * A fotel a paraméterként kapott állattal interakcióba lép, az állat beleül.
	 * @param a
	 * @return
	 */
    public boolean interactWith(Animal a) {
		tabs++;
        logger(toString() + ".interactWith");
		tabs--;
		return false;
	}

	/**
	 * ToString override.
	 * @return
	 */
	@Override
	public String toString() {
		return "Fotel";
	}
}
