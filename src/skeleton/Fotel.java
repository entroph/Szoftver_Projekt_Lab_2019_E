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
		//tabs--;

		ArrayList<Field> neighs = this.GetField().getNeighbors();
		if(neighs != null){
			for(Field field : neighs) {
				Animal tempAnimal = field.getAnimal();
				if (tempAnimal != null) {
					if(tempAnimal.Lazy(this)){
						break;
					}
					//Only one panda can sit into a Fotel, so the first one sits down in it
					// and the Fotel has no effect on the rest of them even if there are more pandas

					//TODO: Itt a gond az, hogy a tempAnimal az Animal típus és biztonságosan nem is lehet castolni LazyPandává
					//erre kell valami megoldás, mert most Animal-okon hívogatjuk a Lazy-t, de az első megtalált Animalnál
					//meg is áll, függetlenül attól, hogy az Orangutan-e vagy ScaredPanda, vagy ha szerencsés a rendszer,
					//akkor pont LazyPanda. A Lazy függvénynek boolean visszatérés kell, hogy sikerült-e és csak is a LazyPanda
					//térhet vissza true-val.
				}
			}
		}
	}
	
	public void Empty() {
		
	}
	
	public void SetPanda(LazyPanda p) {
		
	}
	
	public void RemovePanda(LazyPanda p) {
		
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
