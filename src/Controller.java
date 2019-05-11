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
}
