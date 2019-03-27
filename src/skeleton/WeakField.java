package skeleton;

import static skeleton.Application.*;

public class WeakField extends Field {

	private int hitpoints = 20;

	public void accept(Animal a) {
		tabs++;
		logger(toString() + ".accept");
		animal = a;
		a.setField(this);
		decreaseHitpoints(1);
		if(yesno("0 a hitpointok száma?")){
			a.die();
			delete();
		}
		tabs--;
	}

	public void delete() {
		tabs++;
		logger(toString() + ".delete");
		Panda follower = (Panda) animal.getFollower();
		while(follower != null){
			//It's enough to set the following to null, because in that case if the Step makes the panda to move
			//only the [following] attribute is checked. If the orangutan catches the panda the follower attribute is
			//overwritten and in that case, only the following is checked again. If the following attribute is not null
			//when the Orangutan tries to catch the Panda, then probably the panda is already guided by another orangutan.
			follower.setFollowing(null);
			follower = (Panda) follower.getFollower();
		}
		tabs--;
	}

	public void decreaseHitpoints(int amount) {
		tabs++;
		logger(toString() + ".decreaseHitpoints()");
		hitpoints--;
		if(hitpoints <= 0){
			animal.die();
			delete();
		}
		tabs--;
	}

	public void setHitpoints(int amount) {
		this.hitpoints = amount;
	}

	@Override
	public String toString() {
		return "weakField";
	}
}
