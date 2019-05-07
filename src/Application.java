import javax.swing.*;
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

        //Display
        View mainPanel = new View(game);

        JFrame mainFrame = new JFrame("Panda Pláza");
        mainFrame.setSize(1280, 720);
        mainFrame.setLocationRelativeTo(null);

        mainFrame.add(mainPanel);

        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
