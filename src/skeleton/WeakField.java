package skeleton;

import static skeleton.Application.*;

public class WeakField extends Field {

	private int hitpoints = 20;
	
	public void Accept(Animal a) {
		tabs++;
		logger(toString()+".Accept");
		animal = a;
		a.setField(this);
		DecreaseHitpoints(1);
		if(yesno("0 a hitpointok száma?")){
			a.Die();
			Delete();
		}
		tabs--;
	}
	
	public void Delete() {
		tabs++;
		logger(toString()+".Delete");
		Panda follower = (Panda)animal.GetFollower();
		while(follower != null){
			//It's enough to set the following to null, because in that case if the Step makes the panda to move
			//only the [following] attribute is checked. If the orangutan catches the panda the follower attribute is
			//overwritten and in that case, only the following is checked again. If the following attribute is not null
			//when the Orangutan tries to catch the Panda, then probably the panda is already guided by another orangutan.
			follower.SetFollowing(null);
			follower = (Panda)follower.GetFollower();
		}
		tabs--;
	}
	
	public void DecreaseHitpoints(int amount) {
		tabs++;
		logger(toString()+".DecreaseHitpoints()");
		hitpoints--;
		tabs--;
	}

	public void SetHitpoints(int amount){
		this.hitpoints = amount;
	}

	@Override
	public String toString() {
		return "weakField";
	}
}
