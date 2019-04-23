import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
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
    public static Game game;
    private static String WorkingDirectory = System.getProperty("user.dir");

    public static void main(String[] args) {
        game = Game.getInstance();
        //INNENTŐL
        if(args.length > 0){
            try{
                if(args[0].matches("testcase_([1-9]|1[0-9]|2[0-9]|3[0-2])_in.txt") && args[1].matches("testcase_([1-9]|1[0-9]|2[0-9]|3[0-2])_out.txt")){
                    File inputTest = new File("testcases\\"+args[0]);
                    File outputTest = new File("testcases\\"+args[1]);
                    Scanner scanner = new Scanner(inputTest);
                    System.out.println("\nInput test-case: "+ args[0]+"\n");
                    while(scanner.hasNextLine()){
                        System.out.println(scanner.nextLine());
                    }
                    System.out.println("\nDesired output: "+args[1]+"\n");
                    scanner = new Scanner(outputTest);
                    while(scanner.hasNextLine()){
                        System.out.println(scanner.nextLine());
                    }
                    System.out.println("\nActual output:\n");
                    HandleInputs(args[0], args[1]);
                    return;
                }
            }
            catch (Exception ex){
                ex.printStackTrace();
            }
        } //IDÁIG CSAK A TESTER PROGRAM MIATT VAN, FUTTATÁSKOR EZ NEM JELENIK MEG!
        else
            menu();
    }

    private static void HandleInputs(String inputTest, String outputTest){
        try{
            File inputFile = new File("testcases\\" + inputTest);
            Scanner scanner = new Scanner(inputFile);
            while (scanner.hasNextLine()){
                ExecuteCommand(scanner.nextLine());
            }
        }
        catch (FileNotFoundException ex){
            ex.printStackTrace();
        }

    }

    private static void ExecuteCommand(String command){
        String[] tokens = command.split(" "); //tokens[0] a parancs, a maradék az argumentumok

        switch(tokens[0]){
            case "loadmap":
                if(!tokens[1].isEmpty()){
                    //load map
                    try {
                        game.setMap(new Map(tokens[1]+".txt"));
                    }
                    catch (FileNotFoundException ex){
                        System.out.println("\nHiba: a palya faljla nem talalhato!\n");
                    }
                }
                break;
            case "loadcase":
                if(!tokens[1].isEmpty()){
                    //load testcase
                }
                break;
            case "addorangutan":
                if(!tokens[1].isEmpty() && !tokens[2].isEmpty()){
                    //add an orangutan with token[1] name and token[2] field
                    for(Field field : game.getMap().getFields()){
                        if(field.getName().equals(tokens[2])){
                            if(field.getAnimal() == null && field.getThing() == null){
                                Orangutan orangutan = new Orangutan(tokens[1], field);
                                orangutan.setField(field);
                                field.setAnimal(orangutan);
                                break;
                            }
                        }
                    }
                }
                break;
            case "addpanda":
                if(!tokens[1].isEmpty() && !tokens[2].isEmpty()){
                    //add a panda with token[1] name and token[2] field
                    for(Field field : game.getMap().getFields()){
                        if(field.getName().equals(tokens[2])){
                            if(field.getAnimal() == null && field.getThing() == null){
                                Panda panda = new Panda(tokens[1], field);
                                panda.setField(field);
                                field.setAnimal(panda);
                                break;
                            }
                        }
                    }
                }
                break;
            case "addfotel":
                if(!tokens[1].isEmpty() && !tokens[2].isEmpty()){
                    //add a fotel with token[1] name and token[2] field
                    for(Field field : game.getMap().getFields()){
                        if(field.getName().equals(tokens[2])){
                            if(field.getAnimal() == null && field.getThing() == null){
                                Fotel fotel = new Fotel(tokens[1], field);
                                fotel.setField(field);
                                field.setThing(fotel);
                                break;
                            }
                        }
                    }
                }
                break;
            case "addarcade":
                if(!tokens[1].isEmpty() && !tokens[2].isEmpty()){
                    //add an arcade with token[1] name and token[2] field
                    for(Field field : game.getMap().getFields()){
                        if(field.getName().equals(tokens[2])){
                            if(field.getAnimal() == null && field.getThing() == null){
                                Arcade arcade = new Arcade(tokens[1], field);
                                arcade.setField(field);
                                field.setThing(arcade);
                                break;
                            }
                        }
                    }
                }
                break;
            case "addvm":
                if(!tokens[1].isEmpty() && !tokens[2].isEmpty()){
                    //add a vending machine with token[1] name and token[2] field
                    for(Field field : game.getMap().getFields()){
                        if(field.getName().equals(tokens[2])){
                            if(field.getAnimal() == null && field.getThing() == null){
                                VendingMachine vendingMachine = new VendingMachine(tokens[1], field);
                                vendingMachine.setField(field);
                                field.setThing(vendingMachine);
                                break;
                            }
                        }
                    }
                }
                break;
            case "setfollower":
                if(!tokens[1].isEmpty() && !tokens[2].isEmpty()){
                    //set follower of token[1] animal to token[2] animal
                    Animal animal1 = null;
                    Panda animal2 = null;
                    for(Field field : game.getMap().getFields()){
                        if(field.getAnimal() != null && field.getAnimal().getName().equals(tokens[1])){ //o1
                            animal1 = field.getAnimal();
                        }
                        else if(field.getAnimal() != null && field.getAnimal().getName().equals(tokens[2])) { //p1
                            animal2 = (Panda)field.getAnimal();
                        }
                    }
                    if(animal1 != null && animal2 != null){
                        animal1.setFollower(animal2);
                        animal2.setFollowing(animal1);
                    }
                }
                break;
            case "move":
                if(!tokens[1].isEmpty() && !tokens[2].isEmpty()){
                    Animal animal = null;
                    Field desiredField = null;
                    for(Field field : game.getMap().getFields()){
                        if(field.getAnimal() != null && field.getAnimal().getName().equals(tokens[1])){
                            animal = field.getAnimal();
                        }
                        if(field.getName().equals(tokens[2]))
                            desiredField = field;
                    }
                    if(animal != null && desiredField != null) {
                        animal.move(desiredField);
                    }
                }
                break;
            case "sethitpoints":
                if(!tokens[1].isEmpty() && !tokens[2].isEmpty()){
                    //set hitpoints of token[1] field to token[2] amount
                    Field desiredField = null;
                    for(Field field : game.getMap().getFields()){
                        if(field.getName().equals(tokens[1])){
                            field.setHitpoints(Integer.parseInt(tokens[2]));
                            break;
                        }
                    }
                }
                break;
            case "step":
                //step the steppables
                Timer.getInstance().tick();
                break;
            case "checkfield":
                //check token[1] field
                if(!tokens[1].isEmpty()){
                    for(Field field : game.getMap().getFields()){
                        if(field.getName().equals(tokens[1])){
                            System.out.println(field.toString());
                            break;
                        }
                    }
                }
                break;
            case "checkweakfield":
                //check token[1] weakfield, szerintem ez fölösleges parancs
                if(!tokens[1].isEmpty()){
                    for(Field field : game.getMap().getFields()){
                        if(field.getName().equals(tokens[1])){
                            System.out.println(field.toString());
                            break;
                        }
                    }
                }
                break;
            case "checkanimal":
                //check token[1] animal
                if(!tokens[1].isEmpty()){
                    for(Field field : game.getMap().getFields()){
                        if(field.getAnimal() != null && field.getAnimal().getName().equals(tokens[1])){
                            System.out.println(field.getAnimal().toString());
                            break;
                        }
                    }
                }
                break;
            case "checkfotel":
                //check token[1] fotel
                if(!tokens[1].isEmpty()){
                    for(Field field : game.getMap().getFields()){
                        if(field.getThing() != null && field.getThing().getName().equals(tokens[1])){
                            System.out.println(field.getAnimal().toString());
                            break;
                        }
                    }
                }
                break;
        }
    }

    private static void menu() {
        Scanner s = new Scanner(System.in);

        while (true) {
            System.out.println("1. Orángután üres mezőre lép\n" +
                    "2. Orángután gyenge mezőre lép\n" +
                    "3. Orángután gyenge mezőre lép, és az eltörik\n" +
                    "4. Orángután gyenge mezőre lép, az eltörik, és követi őt panda\n" +
                    "5. Orángután orángutánnak ütközik\n" +
                    "6. Orángután orángutánnak ütközik, és követi már panda\n" +
                    "7. Orángután pandának ütközik, és nem követi panda\n" +
                    "8. Orángután pandának ütközik, és követi panda\n" +
                    "9. Orángután szekrénybe lép\n" +
                    "10. Orángután szekrénybe lép, és követi őt panda\n" +
                    "11. Orángután kimegy a kijáraton\n" +
                    "12. Orángután kimegy a kijáraton, és követi őt panda\n" +
                    "13. Panda üres mezőre lép\n" +
                    "14. Panda üres mezőre követ orángutánt\n" +
                    "15. Panda gyenge mezőre lép\n" +
                    "16. Panda gyenge mezőre lép, és az eltörik\n" +
                    "17. Panda gyenge mezőre követ orángutánt\n" +
                    "18. Panda gyenge mezőre követ orángutánt, és az eltörik\n" +
                    "19. Panda játékgépet tartalmazó mezőre próbál lépni\n" +
                    "20. Panda csoki automatát tartalmazó mezőre próbál lépni\n" +
                    "21. Lusta panda fotelbe ül\n" +
                    "22. Lusta panda feláll a fotelból\n" +
                    "23. Panda szekrénybe lép\n" +
                    "24. Panda szekrénybe követ orángutánt\n" +
                    "25. Félős panda megijed a játék automatától\n" +
                    "26. Ugrós panda üres mezőn ugrik a csoki automatától\n" +
                    "27. Ugrós panda gyenge mezőn ugrik a csoki automatától\n" +
                    "28. Ugrós panda gyenge mezőn ugrik a csoki automatától, és az eltörik\n" +
                    "29. Ugrós panda gyenge mezőn ugrik a csoki automatától, és az eltörik, és a pandát követi más panda\n" +
                    "30. Panda kijáratra követ orángutánt\n" +
                    "31. Panda pandával ütközik\n" +
                    "32. Panda orángutánnal ütközik\n" +
                    "0. Kilépés");
            int input = Integer.parseInt(s.nextLine());
            if (input == 0)
                break;
            else if (input > 0 && input < 33) {
                HandleInputs("testcase_" + input + "_in.txt", "testcase_" + input + "_out.txt");
            }
        }
    }
}
