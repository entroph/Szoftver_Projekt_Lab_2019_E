import javax.swing.*;
/**
 * Alkalmazás osztály, a console-on vezeti a felhasználót
 */
public class Controller {
    public static Game game = Game.getInstance();
    public static Controller app = new Controller();
    public static View mainPanel;
    //private static String WorkingDirectory = System.getProperty("user.dir");

    public void setView(View a){
        mainPanel = a;
    }

    public void move(Field f1, Field f2){
        if(f1.getAnimal() != null) {
            f1.getAnimal().move(f2);
            mainPanel.reDraw();
        }
    }
}
