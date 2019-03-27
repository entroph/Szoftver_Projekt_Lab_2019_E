package skeleton;

import static skeleton.Application.*;

public class ScaredPanda extends Panda{

	public void scare() {
		tabs++;
		logger(toString() + ".scare");
		tabs--;

		Panda follower = (Panda) this.getFollower();
		while(follower != null){
			follower.setFollowing(null);
			follower = (Panda) follower.getFollower();
		}
	}

	@Override
	public String toString(){
		return "ScaredPanda";
	}
}
