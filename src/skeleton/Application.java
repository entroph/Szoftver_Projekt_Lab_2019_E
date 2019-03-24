package skeleton;

import java.util.Scanner;

enum FieldType{
	EMPTYFIELD,
	WEAKFIELD,
	EXIT
}

enum ThingType{
	ARCADE,
	VENDINGMACHINE,
	FOTEL,
	CABINET
}

public class Application {
	public static String log = "";
	public static int tabs = -1;
	public static Game game;

    public static void main(String[] args) {
        game = new Game();
        Menu();
	}

	private static void Menu(){
		Scanner s = new Scanner(System.in);

		while(true) {
			System.out.println("1. Orangutan" + "\r\n" + "2. Panda" + "\r\n" + "0. Exit");
			int input = Integer.parseInt(s.nextLine());
			if(input == 1) {
				while(input != 0){
				System.out.println("-----------------------");
				System.out.println("1. Move to an empty field" + "\r\n" +
								   "2. Move to a weakfield" + "\r\n" +
								   "3. Interact with Cabinet" + "\r\n" +
								   "4. Interact with Arcade" + "\r\n" +
								   "5. Interact with Vending Machine" + "\r\n" +
								   "6. Interact with Fotel" + "\r\n" +
								   "7. Collide with orangutan" + "\r\n" +
								   "8. Collide with panda" + "\r\n" +
								   "9. Move to exit" + "\r\n" +
						           "10. Cabinet teleports Orangutan" + "\r\n" +
								   "0. Back");

				input = Integer.parseInt(s.nextLine());
					switch(input){
						case 1:
							moveAnimalToField(new Orangutan(), FieldType.EMPTYFIELD, null, false);
							break;
						case 2:
							if(yesno("Kovetik ot pandak?"))
								moveAnimalToField(new Orangutan(), FieldType.WEAKFIELD, null, true);
							else
								moveAnimalToField(new Orangutan(), FieldType.WEAKFIELD, null, false);
							break;
						case 3:
							Cabinet cabinet = new Cabinet();
							animalInteractsWithThing(new Orangutan(), cabinet);
							break;
						case 4:
							Arcade arcade = new Arcade();
							animalInteractsWithThing(new Orangutan(), arcade);
							break;
						case 5:
							VendingMachine vmachine = new VendingMachine();
							animalInteractsWithThing(new Orangutan(), vmachine);
							break;
						case 6:
							Fotel fotel = new Fotel();
							animalInteractsWithThing(new Orangutan(), fotel);
							break;
						case 7:
							Orangutan orangutanOnField = new Orangutan();
							moveAnimalToField(new Orangutan(), FieldType.EMPTYFIELD, orangutanOnField, false);
							break;
						case 8:
							if(yesno("Koveti az orangutant mar Panda?")) {
								Panda pandaOnField = new Panda();
								if(yesno("Kovet mar egy masik Orangutant a Panda, akit megprobalunk megfogni?"))
									pandaOnField.SetFollowing(new Orangutan());
								else
									pandaOnField.SetFollowing(null);
								moveAnimalToField(new Orangutan(), FieldType.EMPTYFIELD, pandaOnField, true);
							}
							else
								moveAnimalToField(new Orangutan(), FieldType.EMPTYFIELD, null, false);
							break;
						case 9:
							if(yesno("Koveti az orangutant mar Panda?")) {
								Panda pandaOnField = new Panda();

								if(yesno("A pandasor tavozasa utan marad meg Panda a palyan?"))
									game.GetMap().SetNumberOfPandas(20);
								else
									game.GetMap().SetNumberOfPandas(1);

								moveAnimalToField(new Orangutan(), FieldType.EXIT, null, true);
							}
							else
								moveAnimalToField(new Orangutan(), FieldType.EXIT, null, false);
							break;
						case 10:
							thingTriggersOnAnimal(new Orangutan(), ThingType.CABINET);
							break;
						default:
							break;
					}
				}
			}else if(input == 2){
				while(input != 0){
					System.out.println("1. Move to an empty field" + "\r\n" +
							"2. Move to a weakfield" + "\r\n" +
							"3. Follow orangutan" + "\r\n" +
							"4. Follow panda" + "\r\n" +
							"5. Interact with Cabinet" + "\r\n" +
							"6. Interact with Arcade" + "\r\n" +
							"7. Interact with Vending Machine" + "\r\n" +
							"8. Interact with Fotel" + "\r\n" +
							"9. Collide with orangutan" + "\r\n" +
							"10. Collide with panda" + "\r\n" +
							"11. Move to exit" + "\r\n" +
							"12. Arcade jingles" + "\r\n" +
							"13. Vending machine beeps" + "\r\n" +
							"14. Fotel steps" + "\r\n" +
							"15. Fotel empties" + "\r\n" +
							"16. Cabinet teleports Panda" + "\r\n" +
							"0. Back");

					input = Integer.parseInt(s.nextLine());
					switch(input){
						case 1:
							//PandaStepsOnEmptyField();
							moveAnimalToField(new Panda(), FieldType.EMPTYFIELD, null, false);
							break;
						case 2:
							if(yesno("Kovetik ot pandak?"))
								moveAnimalToField(new Panda(), FieldType.WEAKFIELD, null, true);
							else
								moveAnimalToField(new Panda(), FieldType.WEAKFIELD, null, false);
							break;
						case 3:
							moveAnimalToField(new Orangutan(), FieldType.EMPTYFIELD, null, true);
							break;
						case 4:
							moveAnimalToField(new Panda(), FieldType.EMPTYFIELD, null, true);
							break;
						case 5:
							animalInteractsWithThing(new Panda(), new Cabinet());
							break;
						case 6:
							animalInteractsWithThing(new Panda(), new Arcade());
							break;
						case 7:
							animalInteractsWithThing(new Panda(), new VendingMachine());
							break;
						case 8:
							animalInteractsWithThing(new Panda(), new Fotel());
							break;
						case 9:
							moveAnimalToField(new Panda(), FieldType.EMPTYFIELD, new Orangutan(), false);
							break;
						case 10:
							moveAnimalToField(new Panda(), FieldType.EMPTYFIELD, new Panda(), false);
							break;
						case 11:
							if(yesno("Koveti ot Panda?")){
								game.GetMap().SetNumberOfPandas(2);
								moveAnimalToField(new Panda(), FieldType.EXIT, null, true);
							}
							else{
								game.GetMap().SetNumberOfPandas(1);
								moveAnimalToField(new Panda(), FieldType.EXIT, null, false);
							}
							break;
						case 12:
							ScaredPanda scaredpanda = new ScaredPanda();
							if(yesno("Koveti ot Panda?")){
								scaredpanda.SetFollower(new Panda());
							}
							thingTriggersOnAnimal(scaredpanda, ThingType.ARCADE);
							break;
						case 13:
							JumpingPanda jumpingPanda = new JumpingPanda();
							thingTriggersOnAnimal(jumpingPanda, ThingType.VENDINGMACHINE);
							break;
						case 14:
							//TODO: Fotel steps
							break;
						case 15:
							//TODO: Fotel empties
							break;
						case 16:
							thingTriggersOnAnimal(new Panda(), ThingType.CABINET);
							break;
						default:
							break;
					}
				}
			}else if(input == 0){
				System.exit(0);
			}
		}
	}
	public static boolean yesno(String question){
        System.out.println(question + "\r\n" + "I/N");
        Scanner sc = new Scanner(System.in);
        return sc.nextLine().toLowerCase().equals("i");
    }

    public static void logger(String method){
		log = log + new String(new char[tabs]).replace("\0", "\t");
		log += method + "\r\n";
	}

	//Mate

	public static void moveAnimalToField(Animal animal, FieldType fieldtype, Animal animalOnField, boolean hasFollowerPanda){
		Field currentField = new Field();
		animal.setField(currentField);
		Field newField;

		if(fieldtype == FieldType.WEAKFIELD)
			newField = new WeakField();
		else if(fieldtype == FieldType.EXIT)
			newField = new Exit();
		else
			newField = new Field();

		if(animalOnField != null){
			animalOnField.setField(newField);
			newField.setAnimal(animalOnField);
		}

		if(hasFollowerPanda){
			Panda followerPanda = new Panda();
			animal.SetFollower(followerPanda);
			followerPanda.SetFollowing(animal);
		}

		animal.Move(newField);
		System.out.println(log);
		log = "";
	}

	public static void animalInteractsWithThing(Animal animal, Thing t){
		Field currentField = new Field();
		animal.setField(currentField);
		Field newField = new Field();
		newField.setThing(t);
		animal.Move(newField);
		System.out.println(log);
		log = "";
	}

	public static void thingTriggersOnAnimal(Animal animal, ThingType thingtype){
		Field animalField = new Field();
		animalField.setAnimal(animal);
		animal.setField(animalField);

    	if(thingtype == ThingType.ARCADE){
			Field thingField = new Field();
			thingField.SetNeighbor(animalField);

    		Arcade arcade = new Arcade();
    		thingField.setThing(arcade);
    		arcade.SetField(thingField);
    		arcade.Jingle();
		}
    	else if(thingtype == ThingType.VENDINGMACHINE){
    		if(yesno("WeakField-en all a Panda?")){
    			WeakField weakThingField = new WeakField();

    			if(yesno("Hitpoint 0?"))
    				weakThingField.SetHitpoints(0);

				weakThingField.SetNeighbor(animalField);
				VendingMachine vmachine = new VendingMachine();
				weakThingField.setThing(vmachine);
				vmachine.SetField(weakThingField);
				vmachine.Beep();
			}
    		else{
				Field thingField = new Field();
				thingField.SetNeighbor(animalField);
				VendingMachine vmachine = new VendingMachine();
				thingField.setThing(vmachine);
				vmachine.SetField(thingField);
				vmachine.Beep();
			}

		}
    	else if(thingtype == ThingType.FOTEL){
			Field thingField = new Field();
			thingField.SetNeighbor(animalField);

			Fotel fotel = new Fotel();
			thingField.setThing(fotel);
			fotel.SetField(thingField);
			fotel.Step();
		}
    	else if(thingtype == ThingType.CABINET){
			Field neighborCabinetField = new Field();
			Cabinet neighborCabinet = new Cabinet();
			neighborCabinet.SetField(neighborCabinetField);
			neighborCabinetField.setThing(neighborCabinet);

			Cabinet cabinet = new Cabinet();
			cabinet.SetNeighborCabinet(neighborCabinet);
			animalField.setThing(cabinet);
			cabinet.SetField(animalField);
			cabinet.Step();
		}

		System.out.println(log);
		log = "";
	}

}
