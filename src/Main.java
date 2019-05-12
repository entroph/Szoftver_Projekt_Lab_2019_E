import javax.swing.*;

public class Main {
    public static Controller control = new Controller();
    public static View mainView = new View(control);
    public static void main(String[] args) {
        control.setView(mainView);
        JFrame mainFrame = new JFrame("Panda Pláza");
        mainFrame.setSize(1280, 720);
        mainFrame.setLocationRelativeTo(null);

        mainFrame.add(mainView);

        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
