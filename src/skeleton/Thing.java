package skeleton;

import static skeleton.Application.*;

public class Thing implements Steppable{

	protected Field field;
	
	public void Step() {
		
	}
	
	public boolean InteractWith(Animal a) {
		return false;
		//return yesno("Lehet-e interakcióba lépni ezzel a tárggyal?");
	}

	public void SetField(Field f){
		this.field = f;
	}

	public Field GetField(){
		return this.field;
	}

	@Override
	public String toString() {
		return "Thing";
	}
}
