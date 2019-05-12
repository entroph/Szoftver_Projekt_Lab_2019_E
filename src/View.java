import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class View extends JPanel {
    private ArrayList<Field> fields;

    private Controller control;

    private CardLayout cardLayout;
    private Color menuBackGroundColor = Color.decode("#cbcbca");
    private Color buttonBackgroundColor = Color.decode("#41372e");
    private Color buttonFontColor = Color.decode("#a87b50");
    private JPanel gamePanel;
    private JPanel endGamePanel;
    private JLabel endGameText;
    private Field ogField;

    private JButton[][] grid; //gombok tömbje
    private int width = 15, length = 16; //12x15 gomb ebben az esetben

    private BufferedImage backGround;



    private JPanel cardLayoutContainer;

    public View(Controller cr){
        cardLayoutContainer = this;
        control = cr;
        cardLayout = new CardLayout();
        this.setLayout(cardLayout);

        grid=new JButton[width][length];
        menu();
    }

    private void menu(){
        gamePanel = new JPanel(new GridLayout(width,length)){
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);

                Graphics2D g2 = (Graphics2D) g;
                g2.setStroke(new BasicStroke(3));

                g2.drawImage(backGround, 0, 0, gamePanel);

                if(fields != null && fields.size() > 0){
                    for(Field fld : fields){
                        for(Field nb : fld.getNeighbors()){
                            g2.draw(new Line2D.Float(fld.getX()+32, fld.getY()+32, nb.getX()+32, nb.getY()+32));
                        }
                    }
                }
            }
        };

        JPanel mainMenu = new JPanel();
        mainMenu.setLayout(null);
        mainMenu.setBackground(menuBackGroundColor);

        JButton startBtn = new JButton("Indítás");
        startBtn.setFont(new Font("Arial", Font.PLAIN, 48));
        startBtn.setSize(400, 100);
        startBtn.setBackground(buttonBackgroundColor);
        startBtn.setForeground(buttonFontColor);
        startBtn.setLocation(440, 160);
        startBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardLayoutContainer, "gamePanel");
                startGame(gamePanel);
            }
        });

        JButton mapChooseBtn = new JButton("Pályaválasztás");
        mapChooseBtn.setFont(new Font("Arial", Font.PLAIN, 48));
        mapChooseBtn.setSize(400, 100);
        mapChooseBtn.setBackground(buttonBackgroundColor);
        mapChooseBtn.setForeground(buttonFontColor);
        mapChooseBtn.setLocation(440, 300);
        mapChooseBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    JFileChooser fileChooser = new JFileChooser();
                    fileChooser.setMultiSelectionEnabled(false);
                    int returner = fileChooser.showOpenDialog(cardLayoutContainer);
                    if (returner == JFileChooser.APPROVE_OPTION) {
                        String fileName = fileChooser.getSelectedFile().getName();
                        if(fileName.contains("testmap") && fileName.contains(".txt")){
                            control.game.setMap(new Map(fileName));
                            try{
                                fields = control.game.getMap().getFields();
                            }
                            catch (Exception ex){
                                ex.printStackTrace();
                            }
                        }
                    }
                }
                catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        });

        JButton exitBtn = new JButton("Kilépés");
        exitBtn.setFont(new Font("Arial", Font.PLAIN, 48));
        exitBtn.setSize(400, 100);
        exitBtn.setBackground(buttonBackgroundColor);
        exitBtn.setForeground(buttonFontColor);
        exitBtn.setLocation(440, 440);
        exitBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);

            }
        });
        mainMenu.add(startBtn, BorderLayout.CENTER);
        mainMenu.add(mapChooseBtn, BorderLayout.CENTER);
        mainMenu.add(exitBtn, BorderLayout.CENTER);

        endGamePanel = new JPanel();
        endGamePanel.setLayout(null);
        endGamePanel.setBackground(menuBackGroundColor);
        endGameText = new JLabel();
        endGameText.setForeground(buttonFontColor);
        endGameText.setFont(new Font("Arial", Font.PLAIN, 48));
        endGamePanel.add(endGameText);

        this.add(mainMenu, "mainMenu");
        this.add(gamePanel, "gamePanel");
        this.add(endGamePanel, "endGame");
    }

    public void endGame(){
        endGameText.setText("A játék vége, " + Game.getInstance().getPoints() + " pontot gyűjtöttél.");
                endGameText.setBounds(300, 100, 800, 400);
                cardLayout.show(cardLayoutContainer ,"endGame");
    }

    private void startGame(JPanel gamePanel){
        try{

            //IDEIGLENESEN
            control.game.setMap(new Map("testmap2.txt"));
            try{
                fields = control.game.getMap().getFields();
            }
            catch (Exception ex){
                ex.printStackTrace();
            }

            backGround = ImageIO.read(new File("img\\background.png"));

            //gamePanel.setLayout(); //set layout
            //grid=new JButton[width][length]; //allocate the size of grid

            int fieldSize = fields.size();

            int counter = 0;
            fields.get(11).setAnimal(new Orangutan(fields.get(11)));
            fields.get(2).setAnimal(new Panda(fields.get(2)));
            /*fields.get(4).setAnimal(new Panda(fields.get(4)));
            fields.get(9).setAnimal(new Panda(fields.get(9)));
            fields.get(10).setAnimal(new Panda(fields.get(10)));
            fields.get(23).setAnimal(new Panda(fields.get(23)));
            fields.get(38).setAnimal(new Panda(fields.get(38)));*/
            int offset = width*length/fields.size();
            for(int y=0; y<length; y++){
                for(int x=0; x<width; x++){
                    JButton button = new JButton(); //creates new button

                    button.setOpaque(false);
                    button.setContentAreaFilled(false);
                    button.setFocusPainted(false);
                    button.setBorderPainted(false);
                    button.setVisible(false);

                    if(((((y * length) + x) % offset) == 2) && (counter < fieldSize)){
                        button = fields.get(counter);
                        button.setOpaque(false);
                        button.setContentAreaFilled(false);
                        button.setFocusPainted(false);
                        button.setBorderPainted(false);
                        button.setVisible(true);

                        System.out.println(fields.get(counter).toString());
                        ImageIcon btnImg = new ImageIcon(fields.get(counter).toString());
                        button.setIcon(btnImg);
                        button.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                for (Field f : fields) {
                                    highlightNeighbors(f, false);
                                }
                                if (ogField == null) {
                                    if(((Field)e.getSource()).getAnimal() != null){
                                        if((((Field) e.getSource()).getAnimal().toString().equals("orangutan"))) {
                                            //TODO: Csak az orángutánra kattintva mutassa a lehetséges mezőket
                                            highlightNeighbors((Field) e.getSource(), true);
                                            ogField = (Field) e.getSource();
                                        }
                                    }
                                }else{
                                    for (Field f: ((Field)e.getSource()).getNeighbors()) {
                                        if(f == ogField){
                                            control.move(ogField, (Field)e.getSource());
                                            ogField = null;
                                            break;
                                        }
                                    }
                                }
                            }
                        });
                        counter++;
                    }
                    grid[x][y]= button;
                    gamePanel.add(grid[x][y]); //adds button to grid
                }
            }
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
    }

    public void highlightNeighbors(Field f, boolean onOff){
        if(onOff) {
            f.setOpaque(true);
            f.setBackground(Color.RED);
            f.repaint();
        }
        else {
            f.setOpaque(false);
            f.setContentAreaFilled(false);
            f.setBorderPainted(false);
            f.repaint();
        }

        for(Field nfield : f.getNeighbors()){
            if(onOff){
                nfield.setOpaque(true);
                nfield.setBackground(Color.RED);
                nfield.repaint();
            }
            else {
                nfield.setOpaque(false);
                nfield.setContentAreaFilled(false);
                nfield.setBorderPainted(false);
                nfield.repaint();
            }

        }
    }

    public void reDraw(){
        for (Field f:fields) {
            f.draw();
        }
    }
}
