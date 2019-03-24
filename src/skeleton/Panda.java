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

	public void CollideWith(Animal a) {
		tabs++;
		logger(toString() + ".CollideWith");
		tabs--;
		a.Hit(this);
	}

	public void Hit(Orangutan o) {
		tabs++;
		logger(toString() + ".Hit");
		tabs--;

		//Needed to check, because if its already guided by another Orangutan, then it can't be caught by the Orangutan
		if(this.GetFollowing() != null)
			return;

		Panda follower = (Panda)o.GetFollower();
		o.SetFollower(this);
		this.SetFollowing(o);
		if(follower != null){
			this.SetFollower(follower);
			follower.SetFollowing(this);
		}
		o.Swap(this);
	}

	public void Hit(Panda p) {
		tabs++;
		logger(toString() + ".Hit (Nothing happens when a Panda tries to catch another Panda)");
		tabs--;
	}

	public void Leave(){
		tabs++;
		logger(toString() + ".Leave");
		tabs--;

		if(follower != null)
			follower.Follow(this);

		Map map = game.GetMap();
		map.DecreasePandas();
		game.IncreasePoints();
	}
	
	public void SetFollowing(Animal a) {
		tabs++;
		logger(toString() + ".SetFollowing");
		tabs--;
		this.following = a;
	}
	
	public Animal GetFollowing() {
		return following;
	}

	public void SetFollower(Animal a) {
		tabs++;
		logger(toString() + ".SetFollower (Here the Panda (which previously followed the Orangutan or a Panda) starts to hold the newly arrived Panda's hand)");
		tabs--;
		this.follower = a;
	}

	public Animal GetFollower() {
		return follower;
	}

	public Field GetField() {
		tabs++;
		logger(toString() + ".GetField");
		tabs--;
		return field;
	}

	public void Scare() {
		tabs++;
		logger(toString() + ".Scare");
		tabs--;
	}

	@Override
	public String toString() {
		return "Panda";
	}
}
