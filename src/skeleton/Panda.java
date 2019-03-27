package skeleton;

import static skeleton.Application.*;

public class Panda extends Animal{

	Animal following;

	public Panda(){}

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

	public void collideWith(Animal a) {
		tabs++;
		logger(toString() + ".collideWith");
		tabs--;
		a.hit(this);
	}

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

	public void hit(Panda p) {
		tabs++;
		logger(toString() + ".hit (Nothing happens when a Panda tries to catch another Panda)");
		tabs--;
	}

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

	public void setFollowing(Animal a) {
		tabs++;
		logger(toString() + ".setFollowing");
		tabs--;
		this.following = a;
	}

	public Animal getFollowing() {
		return following;
	}

	public void setFollower(Animal a) {
		tabs++;
		logger(toString() + ".setFollower (Here the Panda (which previously followed the Orangutan or a Panda) starts to hold the newly arrived Panda's hand)");
		tabs--;
		this.follower = a;
	}

	public Animal getFollower() {
		return follower;
	}

	public Field getField() {
		tabs++;
		logger(toString() + ".getField");
		tabs--;
		return field;
	}

	public void scare() {
		tabs++;
		logger(toString() + ".scare");
		tabs--;
	}

	@Override
	public String toString() {
		return "Panda";
	}
}
