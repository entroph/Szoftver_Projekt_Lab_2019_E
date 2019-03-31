package skeleton;

import java.util.Scanner;

/**
 * Csempe típusok enumerációja
 */
enum FieldType{
	EMPTYFIELD,
	WEAKFIELD,
	EXIT
}

/**
 * Tárgyak
 */
enum ThingType{
	ARCADE,
	VENDINGMACHINE,
	FOTEL,
	CABINET
}

/**
 * Alkalmazás osztály, a console-on vezeti a felhasználót
 */
public class Application {
	public static String log = "";
	public static int tabs = -1;
	public static Game game;

    public static void main(String[] args) {
        game = new Game();
		menu();
	}

	private static void menu() {
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
							moveAnimalToField(new Orangutan(), FieldType.EMPTYFIELD, null, null);
							break;
						case 2:
							if(yesno("Kovetik ot pandak?")) {
                                moveAnimalToField(new Orangutan(), FieldType.WEAKFIELD, null, new Panda());
                            }else
								moveAnimalToField(new Orangutan(), FieldType.WEAKFIELD, null, null);
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
							moveAnimalToField(new Orangutan(), FieldType.EMPTYFIELD, orangutanOnField, null);
							break;
						case 8:
							if(yesno("Koveti az orangutant mar Panda?")) {
								Panda pandaOnField = new Panda();
								if(yesno("Kovet mar egy masik Orangutant a Panda, akit megprobalunk megfogni?")) {
									pandaOnField.setFollowing(new Orangutan());
                                }else {
									pandaOnField.setFollowing(null);
                                }
								moveAnimalToField(new Orangutan(), FieldType.EMPTYFIELD, pandaOnField, new Panda());
							}
							else {
                                moveAnimalToField(new Orangutan(), FieldType.EMPTYFIELD, null, null);
                            }
							break;
						case 9:
							if(yesno("Koveti az orangutant mar Panda?")) {
								if(yesno("A pandasor tavozasa utan marad meg Panda a palyan?")) {
									game.getMap().setNumberOfPandas(20);
                                }else {
									game.getMap().setNumberOfPandas(1);
                                }
								moveAnimalToField(new Orangutan(), FieldType.EXIT, null, new Panda());
							}else {
                                moveAnimalToField(new Orangutan(), FieldType.EXIT, null, null);
                            }
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
							moveAnimalToField(new Panda(), FieldType.EMPTYFIELD, null, null);
							break;
						case 2:
							if(yesno("Kovetik ot pandak?")) {
                                moveAnimalToField(new Panda(), FieldType.WEAKFIELD, null, new Panda());
                            }else
								moveAnimalToField(new Panda(), FieldType.WEAKFIELD, null, null);
							break;
						case 3:
							moveAnimalToField(new Orangutan(), FieldType.EMPTYFIELD, null, new Panda());
							break;
						case 4:
							moveAnimalToField(new Panda(), FieldType.EMPTYFIELD, null, new Panda());
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
							moveAnimalToField(new Panda(), FieldType.EMPTYFIELD, new Orangutan(), null);
							break;
						case 10:
							moveAnimalToField(new Panda(), FieldType.EMPTYFIELD, new Panda(), null);
							break;
						case 11:
							if(yesno("Koveti ot Panda?")){
								game.getMap().setNumberOfPandas(2);
								moveAnimalToField(new Panda(), FieldType.EXIT, null, new Panda());
							}
							else{
								game.getMap().setNumberOfPandas(1);
								moveAnimalToField(new Panda(), FieldType.EXIT, null, null);
							}
							break;
						case 12:
							ScaredPanda scaredpanda = new ScaredPanda();
							if(yesno("Koveti ot Panda?")){
								scaredpanda.setFollower(new Panda());
							}
							thingTriggersOnAnimal(scaredpanda, ThingType.ARCADE);
							break;
						case 13:
							thingTriggersOnAnimal(new JumpingPanda(), ThingType.VENDINGMACHINE);
							break;
						case 14:
							thingTriggersOnAnimal(new LazyPanda(), ThingType.FOTEL);
							break;
						case 15:
							thingTriggersOnAnimal(new LazyPanda(), ThingType.FOTEL);
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

	/**
	 * Igaz-Hamis kérdést kezelő fv.
	 * @param question
	 * @return
	 */
	public static boolean yesno(String question){
        System.out.println(question + "\r\n" + "I/N");
        Scanner sc = new Scanner(System.in);
        return sc.nextLine().toLowerCase().equals("i");
    }

    public static void logger(String method){
		log = log + new String(new char[tabs]).replace("\0", "\t");
		log += method + "\r\n";
	}


	/**
	 * Ellenőrzi a paraméterként megkapott mezőt és tartalmát, majd meghívja a Move-ját az adott állatnak.
	 * @param animal
	 * @param fieldtype
	 * @param animalOnField
	 * @param followerPanda
	 */
	public static void moveAnimalToField(Animal animal, FieldType fieldtype, Animal animalOnField, Panda followerPanda){
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

		if(followerPanda != null){
			animal.setFollower(followerPanda);
			followerPanda.setFollowing(animal);
		}

		animal.move(newField);
		System.out.println(log);
		log = "";
	}

	/**
	 * A paraméterként kapott állatot és tárgyat ütközteti.
	 * @param animal
	 * @param t
	 */
	public static void animalInteractsWithThing(Animal animal, Thing t){
		Field currentField = new Field();
		animal.setField(currentField);
		Field newField = new Field();
		newField.setThing(t);
		animal.move(newField);
		System.out.println(log);
		log = "";
	}

	/**
	 * Interakció a paraméterként kapott tárgytípusokkal.
	 * @param animal
	 * @param thingtype
	 */
	public static void thingTriggersOnAnimal(Animal animal, ThingType thingtype){
		Field animalField = new Field();
		animalField.setAnimal(animal);
		animal.setField(animalField);

    	if(thingtype == ThingType.ARCADE){
			Field thingField = new Field();
			thingField.setNeighbor(animalField);

    		Arcade arcade = new Arcade();
    		thingField.setThing(arcade);
			arcade.setField(thingField);
			arcade.jingle();
		}
    	else if(thingtype == ThingType.VENDINGMACHINE){
    		if(yesno("WeakField-en all a Panda?")){
    			WeakField wf = new WeakField();
				Field vmField = new Field();
    			if(yesno("Hitpoint 0?")) {
					wf.setHitpoints(1);
				}

    			wf.setAnimal(animal);
    			animal.setField(wf);
				vmField.setNeighbor(wf);
				VendingMachine vmachine = new VendingMachine();
				vmField.setThing(vmachine);
				vmachine.setField(vmField);
				vmachine.beep();
			}
    		else{
				Field thingField = new Field();
				thingField.setNeighbor(animalField);
				VendingMachine vmachine = new VendingMachine();
				thingField.setThing(vmachine);
				vmachine.setField(thingField);
				vmachine.beep();
			}

		}
    	else if(thingtype == ThingType.FOTEL){
			Field thingField = new Field();
			thingField.setNeighbor(animalField);

			Fotel fotel = new Fotel();
			thingField.setThing(fotel);
			fotel.setField(thingField);
			if (yesno("Sittingtime 0?")) {
				fotel.setPanda((LazyPanda) animal);
				fotel.setSitTime(1);
				fotel.setBusy(true);
				fotel.step();
			} else {
				fotel.step();
			}
		}
    	else if(thingtype == ThingType.CABINET){
			Field neighborCabinetField = new Field();
			Cabinet neighborCabinet = new Cabinet();
			neighborCabinet.setField(neighborCabinetField);
			neighborCabinetField.setThing(neighborCabinet);

			Cabinet cabinet = new Cabinet();
			cabinet.setNeighborCabinet(neighborCabinet);
			animalField.setThing(cabinet);
			cabinet.setField(animalField);
			cabinet.step();
		}

		System.out.println(log);
		log = "";
	}

}
