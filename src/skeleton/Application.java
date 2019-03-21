package skeleton;

import java.util.Scanner;

public class Application {

	private static Game game;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		game = new Game();
		Menu();
	}

	public static void Menu() {
		Scanner s = new Scanner(System.in);
		
		while(true) {
			String input = s.nextLine();
			
			if(input.equals("0")) {
				System.out.println("Teszt");
				break;
			}
		}
	}
}
