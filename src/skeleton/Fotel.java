package skeleton;

import java.util.ArrayList;

import static skeleton.Application.*;

public class Fotel extends Thing{

	private int sitTime;
	private boolean busy;
	private LazyPanda sittingPanda;

	public Fotel(){
		sitTime = 0;
		busy = false;
		sittingPanda = null;
	}


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

    public void empty() {
        sittingPanda.unLazy(this);
        setBusy(false);
        setSitTime(5);
	}

    public void setPanda(LazyPanda p) {
		sittingPanda = p;
	}

    public void setSitTime(int amount) {
        sitTime = amount;
    }

    public void setBusy(boolean busy) {
        this.busy = busy;
    }

    public boolean interactWith(Animal a) {
		tabs++;
        logger(toString() + ".interactWith");
		tabs--;
		return false;
	}

	@Override
	public String toString() {
		return "Fotel";
	}
}
