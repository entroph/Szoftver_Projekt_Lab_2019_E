package skeleton;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Game game = new Game();
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
								   "2. Move to a weakfield, and weakfield hitpoints decreases" + "\r\n" +
								   "3. Move to a weakfield, and weakfield breaks" + "\r\n" +
								   "4. Interact with Cabinet" + "\r\n" +
								   "5. Interact with Arcade" + "\r\n" +
								   "6. Interact with Vending Machine" + "\r\n" +
								   "7. Interact with Fotel" + "\r\n" +
								   "8. Collide with orangutan" + "\r\n" +
								   "9. Collide with panda" + "\r\n" +
								   "10. Move to exit" + "\r\n" +
								   "0. Back");

				input = Integer.parseInt(s.nextLine());
					switch(input){
						case 1:
							//TODO: Move to an empty field
							break;
						case 2:
							//TODO: Move to a weakfield, and weakfield hitpoints decreases
							break;
						case 3:
							//TODO: Move to a weakfield, and weakfield breaks
							break;
						case 4:
							//TODO: Interact with Cabinet
							break;
						case 5:
							//TODO: Interact with Arcade
							break;
						case 6:
							//TODO: Interact with Vending Machine
							break;
						case 7:
							//TODO: Interact with Fotel
							break;
						case 8:
							//TODO: Collide with orangutan
							break;
						case 9:
							//TODO: Collide with panda
							break;
						case 10:
							//TODO: Move to exit
							break;
						default:
							break;
					}
				}
			}else if(input == 2){
				while(input != 0){
					System.out.println("1. Move to an empty field" + "\r\n" +
							"2. Move to a weakfield, and weakfield hitpoints decreases" + "\r\n" +
							"3. Move to a weakfield, and weakfield breaks" + "\r\n" +
							"4. Follow orangutan" + "\r\n" +
							"5. Follow panda" + "\r\n" +
							"6. Interact with Cabinet" + "\r\n" +
							"7. Interact with Arcade" + "\r\n" +
							"8. Interact with Vending Machine" + "\r\n" +
							"9. Interact with Fotel" + "\r\n" +
							"10. Collide with orangutan" + "\r\n" +
							"11. Collide with panda" + "\r\n" +
							"12. Move to exit" + "\r\n" +
							"13. Arcade jingles" + "\r\n" +
							"14. Vending machine beeps" + "\r\n" +
							"15. Fotel steps" + "\r\n" +
							"16. Fotel empties" + "\r\n" +
							"0. Back");

					input = Integer.parseInt(s.nextLine());
					switch(input){
						case 1:
							//TODO: Move to an empty field
							break;
						case 2:
							//TODO: Move to a weakfield, and weakfield hitpoints decreases
							break;
						case 3:
							//TODO: Move to a weakfield, and weakfield breaks
							break;
						case 4:
							//TODO: Follow orangutan
							break;
						case 5:
							//TODO: Follow panda
							break;
						case 6:
							//TODO: Interact with Cabinet
							break;
						case 7:
							//TODO: Interact with Arcade
							break;
						case 8:
							//TODO: Interact with Vending Machine
							break;
						case 9:
							//TODO: Interact with Fotel
							break;
						case 10:
							//TODO: Collide with orangutan
							break;
						case 11:
							//TODO: Collide with panda
							break;
						case 12:
							//TODO: Move to exit
							break;
						case 13:
							//TODO: Arcade jingles
							break;
						case 14:
							//TODO: Vending machine beeps
							break;
						case 15:
							//TODO: Fotel steps
							break;
						case 16:
							//TODO: Fotel empties
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
}
