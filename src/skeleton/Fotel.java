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


	public void Step() {
		tabs++;
		logger(toString() + ".Step");
		if(!busy) {
			ArrayList<Field> neighs = this.GetField().getNeighbors();
			if (neighs != null) {
				for (Field field : neighs) {
					Animal tempAnimal = field.getAnimal();
					if (tempAnimal != null) {
						if (tempAnimal.Lazy(this)) {
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
				Empty();
			}
		}
		tabs--;
	}
	
	public void Empty() {
		sittingPanda.UnLazy(this);
		busy = false;
		sitTime = 5;
	}
	
	public void SetPanda(LazyPanda p) {
		sittingPanda = p;
	}

	public boolean InteractWith(Animal a) {
		tabs++;
		logger(toString() + ".InteractWith");
		tabs--;
		return false;
	}

	@Override
	public String toString() {
		return "Fotel";
	}
}
