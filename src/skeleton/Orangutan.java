package skeleton;

import static skeleton.Application.*;

/**
 * Az orángután osztálya, a játékos irányítása alatt.
 */
public class Orangutan extends Animal{

	//In the finished application, there will be no need for this function here
	//now this is only here, because we need to log "orangutan collidewith" or "panda collidewith"
	public void collideWith(Animal a) {
		tabs++;
		logger(toString() + ".collideWith");
		tabs--;
		a.hit(this);
	}

	/**
	 * Ütközik a paraméterként kapott orángutánnal, de semmi érdemi történést nem vált ki.
	 * @param o
	 */
	public void hit(Orangutan o) {
		tabs++;
		logger(toString() + ".hit (this is the other Orangutan)");
		tabs--;
	}

	/**
	 * A paraméterként kapott pandával ütközik.
	 * @param p
	 */
	public void hit(Panda p) {
		tabs++;
		logger(toString() + ".hit (Nothing happens when the Panda tries to catch the Orangutan)");
		tabs--;
	}

	/**
	 * Lekéri az őt követő állatot.
	 * @return
	 */
	public Animal getFollower() {
		tabs++;
		logger(toString() + ".getFollower");
		tabs--;
		return follower;
	}

	/**
	 * Beállítja a paraméterként kapott állatot követőnek (csak panda lehet)
	 * @param a
	 */
	public void setFollower(Animal a) {
		tabs++;
		logger(toString() + ".setFollower");
		tabs--;
		this.follower = a;
	}

	/**
	 * Visszaadja a mezőt amelyiken áll.
	 * @return
	 */
	public Field getField() {
		tabs++;
		logger(toString() + ".getField");
		tabs--;
		return field;
	}

	/**
	 * Pálya elhagyása a kijáraton.
	 */
	public void leave() {
		tabs++;
		logger(toString() + ".leave");
		tabs--;

		if(follower != null)
			follower.follow(this);

		Entrance ent = game.getEntrance();
		ent.accept(this);
	}

	/**
	 * ToString override.
	 * @return
	 */
	@Override
	public String toString() {
		return "Orangutan";
	}
}
