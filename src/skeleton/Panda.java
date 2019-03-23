package skeleton;

import static skeleton.Application.*;

public class Panda extends Animal{

	Animal following;

	public Panda(Field cf)
	{
		setField(cf);
	}
	
	public void Move(Field nf) {
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
	}
	
	public void Leave() {
		
	}
	
	public void SetFollowing(Animal a) {
		
	}
	
	public Animal GetFollowing() {
		return following;
	}

	@Override
	public String toString() {
		return "Panda";
	}
}
