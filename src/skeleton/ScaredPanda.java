package skeleton;

import static skeleton.Application.*;

/**
 * Ijedős panda osztálya, reagál a Scare függvényre
 */
public class ScaredPanda extends Panda{

	/**
	 * Nulláza a mögötte sorban állók following-ját.
	 */
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

	/**
	 * ToString override.
	 * @return
	 */
	@Override
	public String toString(){
		return "ScaredPanda";
	}
}
