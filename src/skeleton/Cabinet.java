package skeleton;

import static skeleton.Application.*;

public class Cabinet extends Thing{

	private Cabinet neighborCabinet;
	
	public void Step() {
		tabs++;
		logger(toString()+".Step");
		//tabs--;

		Field cabinetField = this.GetField();
		Animal animalOnCabinet = cabinetField.getAnimal();

		Field neighborCabinetField = neighborCabinet.GetField();
		Animal animalOnNeighborCabinet = neighborCabinetField.getAnimal();
		if(animalOnNeighborCabinet == null){
			neighborCabinet.Teleport(animalOnCabinet);
		}

	}
	
	public void Teleport(Animal a) {
		tabs++;
		logger(toString()+".Teleport");
		tabs--;
		Field animalField = a.GetField();
		this.field.Accept(a);
		animalField.Remove(a);
	}
	
	public boolean InteractWith(Animal a) {
		tabs++;
		logger(toString()+".InteractWith");
		tabs--;
		return true;
	}

	public void SetNeighborCabinet(Cabinet nbcabinet){
		tabs++;
		logger(toString()+".SetNeighborCabinet");
		tabs--;
		this.neighborCabinet = nbcabinet;
	}

	@Override
	public String toString() {
		return "Cabinet";
	}
}
