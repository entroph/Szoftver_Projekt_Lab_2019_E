package skeleton;

import static skeleton.Application.*;

public class Cabinet extends Thing{

	private Cabinet neighborCabinet;

    public void step() {
		tabs++;
        logger(toString() + ".step");

        Field cabinetField = this.getField();
		Animal animalOnCabinet = cabinetField.getAnimal();

        Field neighborCabinetField = neighborCabinet.getField();
		Animal animalOnNeighborCabinet = neighborCabinetField.getAnimal();
		if(animalOnNeighborCabinet == null){
            neighborCabinet.teleport(animalOnCabinet);
		}
		tabs--;
	}

    public void teleport(Animal a) {
		tabs++;
        logger(toString() + ".teleport");
		tabs--;
        Field animalField = a.getField();
        this.field.accept(a);
        animalField.remove(a);
	}

    public boolean interactWith(Animal a) {
		tabs++;
        logger(toString() + ".interactWith");
		tabs--;
		return true;
	}

    public void setNeighborCabinet(Cabinet nbcabinet) {
		tabs++;
        logger(toString() + ".setNeighborCabinet");
		tabs--;
		this.neighborCabinet = nbcabinet;
	}

	@Override
	public String toString() {
		return "Cabinet";
	}
}
