package skeleton;

import static skeleton.Application.*;

/**
 * A panda osztály megvalósítása.
 */
public class Panda extends Animal{
	//A sorban előtte menő állat.
	Animal following;

	/**
	 * Konstruktor.
	 */
	public Panda(){}

	/**
	 * Konstruktor, rárakja a Field-re.
	 * @param cf Field.
	 */
	public Panda(Field cf)
	{
		setField(cf);
	}

	//Ebben az esetben fölösleges különbséget tenni Panda és Orangutan között,
	//csak is azért van nekik külön move függvényük, mert a Panda majd Step-re lép

	/*public void Move(Field nf) {
		tabs++;
		logger(toString() + ".Move");
		Thing a = new Thing();
		if((a = nf.getThing()) != null){
			if(a.InteractWith(this)){
				if(nf.getAnimal() == null){
					Field cf = GetField();
					nf.Accept(this);
					cf.Remove(this);
				}
			}
		}else{
			if(nf.getAnimal() == null){
				Field cf = GetField();
				nf.Accept(this);
				cf.Remove(this);
			}
		}
		tabs--;
	}*/

	/**
	 * Ütközik a paraméterként kapott állattal.
	 * @param a ütközés alanya.
	 */
	public void collideWith(Animal a) {
		tabs++;
		logger(toString() + ".collideWith");
		tabs--;
		a.hit(this);
	}

	/**
	 * Eltalál egy orángutánt, és ha még nem követ senkit, helyet cserélnek és beáll a sorába.
	 * @param o
	 */
	public void hit(Orangutan o) {
		tabs++;
		logger(toString() + ".hit");
		tabs--;

		//Needed to check, because if its already guided by another Orangutan, then it can't be caught by the Orangutan
		if (this.getFollowing() != null)
			return;

		Panda follower = (Panda) o.getFollower();
		o.setFollower(this);
		this.setFollowing(o);
		if(follower != null){
			this.setFollower(follower);
			follower.setFollowing(this);
		}
		o.swap(this);
	}

	/**
	 * Eltalál egy pandát, semmi nem történik.
	 * @param p
	 */
	public void hit(Panda p) {
		tabs++;
		logger(toString() + ".hit (Nothing happens when a Panda tries to catch another Panda)");
		tabs--;
	}

	/**
	 * Kijárat mezőn áll, meghívja az őt eltávolító függvényeket.
	 */
	public void leave() {
		tabs++;
		logger(toString() + ".leave");
		tabs--;

		if(follower != null)
			follower.follow(this);

		Map map = game.getMap();
		map.decreasePandas();
		game.increasePoints();
	}

	/**
	 * Beállítja a paraméterként kapott állatot követettjének.
	 * @param a
	 */
	public void setFollowing(Animal a) {
		tabs++;
		logger(toString() + ".setFollowing");
		tabs--;
		this.following = a;
	}

	/**
	 * Visszatér a követettjével.
	 * @return
	 */
	public Animal getFollowing() {
		return following;
	}

	/**
	 * Beállítja az őt követő állatot.
	 * @param a
	 */
	public void setFollower(Animal a) {
		tabs++;
		logger(toString() + ".setFollower (Here the Panda (which previously followed the Orangutan or a Panda) starts to hold the newly arrived Panda's hand)");
		tabs--;
		this.follower = a;
	}

	/**
	 * Visszatér a követőjével.
	 * @return
	 */
	public Animal getFollower() {
		return follower;
	}

	/**
	 * Visszatér azzal a mezővel amelyiken áll.
	 * @return
	 */
	public Field getField() {
		tabs++;
		logger(toString() + ".getField");
		tabs--;
		return field;
	}

	/**
	 * Ha megijed, elengedi a mögötte állók kezét, törli a follower-t.
	 */
	public void scare() {
		tabs++;
		logger(toString() + ".scare");
		tabs--;
	}

	/**
	 * ToString override.
	 * @return
	 */
	@Override
	public String toString() {
		return "Panda";
	}
}
