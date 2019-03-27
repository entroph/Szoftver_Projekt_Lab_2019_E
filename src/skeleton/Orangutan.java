package skeleton;

import static skeleton.Application.*;

public class Orangutan extends Animal{

	//In the finished application, there will be no need for this function here
	//now this is only here, because we need to log "orangutan collidewith" or "panda collidewith"
	public void collideWith(Animal a) {
		tabs++;
		logger(toString() + ".collideWith");
		tabs--;
		a.hit(this);
	}

	public void hit(Orangutan o) {
		tabs++;
		logger(toString() + ".hit (this is the other Orangutan)");
		tabs--;
	}

	public void hit(Panda p) {
		tabs++;
		logger(toString() + ".hit (Nothing happens when the Panda tries to catch the Orangutan)");
		tabs--;
	}

	public Animal getFollower() {
		tabs++;
		logger(toString() + ".getFollower");
		tabs--;
		return follower;
	}

	public void setFollower(Animal a) {
		tabs++;
		logger(toString() + ".setFollower");
		tabs--;
		this.follower = a;
	}

	public Field getField() {
		tabs++;
		logger(toString() + ".getField");
		tabs--;
		return field;
	}

	public void leave() {
		tabs++;
		logger(toString() + ".leave");
		tabs--;

		if(follower != null)
			follower.follow(this);

		Entrance ent = game.getEntrance();
		ent.accept(this);
	}

	@Override
	public String toString() {
		return "Orangutan";
	}
}
