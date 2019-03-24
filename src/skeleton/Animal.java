package skeleton;

import static skeleton.Application.*;

public class Animal {
	
	Animal follower;
	Field field;
	
	public void Move(Field newField) {
		tabs++;
		logger(toString() + ".Move");
		Thing thingOnNewField = newField.getThing();
		Animal animalOnNewField = newField.getAnimal();
		if(animalOnNewField != null){ //if there is an animal on it, then collide with it
			this.CollideWith(animalOnNewField);
		}
		else {
			if (thingOnNewField != null) {
				if (thingOnNewField.InteractWith(this)) { //if returns true, animal can move to that field
					if(follower != null) {
						follower.Follow(this);
					}
					this.field.Remove(this);
					newField.Accept(this);
				}
			}
			else{
				if(follower != null)
					follower.Follow(this);
				this.field.Remove(this);
				newField.Accept(this);
			}
		}
		tabs--;
	}
	
	public void Step() {
		
	}
	
	public void Die() {
		Release();
		tabs++;
		logger(toString()+".Die");
		tabs--;
	}
	
	public void Lazy(Fotel f) {
		
	}
	
	public void UnLazy(Fotel f) {
		
	}
	
	public void Jump() {
		
	}
	
	public void Scare() {
		
	}
	
	public void Swap(Animal a) {
		tabs++;
		logger(toString()+".Swap");
		tabs--;
		Field newField = a.GetField();
		this.field.Remove(this);
		newField.Remove(a);
		newField.Accept(this);
		this.field.Accept(a);
	}
	
	public Field GetField() {
		return field;
	}

	public void setField(Field f){field = f;}
	
	public void Follow(Animal a) {
		tabs++;
		logger(toString() + ".Follow");
		tabs--;
		Field newField = a.GetField();
		newField.Accept(this);
		this.field.Remove(this);
	}
	
	public void Leave() {

	}
	
	public void CollideWith(Animal a) {

	}
	
	public void Hit(Orangutan o) {
		
	}
	
	public void Hit(Panda p) {
		
	}

	public void Release(){

	}
	
	public void SetFollower(Animal a) {
		
	}
	
	public Animal GetFollower() {
		return follower;
	}
}
