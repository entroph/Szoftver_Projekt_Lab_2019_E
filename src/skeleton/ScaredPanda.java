package skeleton;

import static skeleton.Application.*;

public class ScaredPanda extends Panda{

	public void Scare() {
		tabs++;
		logger(toString() + ".Scare");
		tabs--;

		Panda follower = (Panda)this.GetFollower();
		while(follower != null){
			follower.SetFollowing(null);
			follower = (Panda)follower.GetFollower();
		}
	}

	@Override
	public String toString(){
		return "ScaredPanda";
	}
}
