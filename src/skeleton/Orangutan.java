package skeleton;

import static skeleton.Application.*;

public class Orangutan extends Animal{

	//In the finished application, there will be no need for this function here
	//now this is only here, because we need to log "orangutan collidewith" or "panda collidewith"
	public void CollideWith(Animal a) {
		tabs++;
		logger(toString() + ".CollideWith");
		tabs--;
		a.Hit(this);
	}

	public void Hit(Orangutan o) {
		tabs++;
		logger(toString() + ".Hit (this is the other Orangutan)");
		tabs--;
	}

	public void Hit(Panda p) {
		tabs++;
		logger(toString() + ".Hit (Nothing happens when the Panda tries to catch the Orangutan)");
		tabs--;
	}

	public Animal GetFollower() {
		tabs++;
		logger(toString() + ".GetFollower");
		tabs--;
		return follower;
	}

	public void SetFollower(Animal a) {
		tabs++;
		logger(toString() + ".SetFollower");
		tabs--;
		this.follower = a;
	}

	public Field GetField() {
		tabs++;
		logger(toString() + ".GetField");
		tabs--;
		return field;
	}

	public void Leave(){
		tabs++;
		logger(toString() + ".Leave");
		tabs--;

		if(follower != null)
			follower.Follow(this);

		Entrance ent = game.GetEntrance();
		ent.Accept(this);
	}

	@Override
	public String toString() {
		return "Orangutan";
	}
}
