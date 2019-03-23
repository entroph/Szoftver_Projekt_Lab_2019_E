package skeleton;

import static skeleton.Application.*;

public class WeakField extends Field {

	private int hitpoints = 20;
	
	public void Accept(Animal a) {
		tabs++;
		logger(toString()+".Accept");
		DecreaseHitpoints(1);
		if(yesno("0 a hitpointok száma?")){
			a.GetField().Remove(a);
			a.Die();
			Delete();
		}else{
			animal = a;
			a.setField(this);
		}
		tabs--;
	}
	
	public void Delete() {
		
	}
	
	public void DecreaseHitpoints(int amount) {
		tabs++;
		logger(toString()+".DecreaseHitpoints()");
		hitpoints--;
		tabs--;
	}

	@Override
	public String toString() {
		return "weakField";
	}
}
