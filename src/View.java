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
    private JSpinner pdspinner;
    private JSpinner ogspinner;

    private JButton[][] grid;
    private int width = 15, length = 16;

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
                        for (Field nb : fld.getNeighbors()) {
                            g2.draw(new Line2D.Float(fld.getX() + 32, fld.getY() + 32, nb.getX() + 32, nb.getY() + 32));
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
                if(fields != null) {
                    cardLayout.show(cardLayoutContainer, "gamePanel");
                    startGame(gamePanel);
                }
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
        JLabel pdlabel = new JLabel();
        pdlabel.setText("Pandák száma:");
        pdlabel.setBounds(440,260, 100,30);
        SpinnerModel pdmodel = new SpinnerNumberModel(1, 1, 5, 1);
        pdspinner = new JSpinner(pdmodel);
        pdspinner.setBounds(530,260,50,30);

        JLabel oglabel = new JLabel();
        oglabel.setText("Orángutánok száma:");
        oglabel.setBounds(670,260,130,30);
        SpinnerModel ogmodel = new SpinnerNumberModel(1,1,2,1);
        ogspinner = new JSpinner(ogmodel);
        ogspinner.setBounds(790,260,50,30);

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
        mainMenu.add(pdlabel, BorderLayout.CENTER);
        mainMenu.add(pdspinner, BorderLayout.CENTER);
        mainMenu.add(oglabel, BorderLayout.CENTER);
        mainMenu.add(ogspinner, BorderLayout.CENTER);
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

    /**
     *
     * @param gamePanel
     */
    private void startGame(JPanel gamePanel){
        try{
            Random r = new Random();

            Game.getInstance().getEntrance().setAnimal(new Orangutan(Game.getInstance().getEntrance()));
            int numberofpandas = (Integer)pdspinner.getValue();
            int fieldcount = fields.size();
            int random;
            int i = 0;
            int ptype;
            Game.getInstance().getMap().setNumberOfPandas(numberofpandas);
            while(i < numberofpandas) {
                random = r.nextInt(fieldcount);
                if (fields.get(random).getAnimal() == null) {
                    if (fields.get(random).getThing() == null) {
                        ptype = r.nextInt(4);
                        if(ptype == 0){
                            fields.get(random).setAnimal(new Panda(fields.get(random)));
                        }else if(ptype == 1){
                            fields.get(random).setAnimal(new LazyPanda(fields.get(random)));
                        }else if(ptype == 2){
                            fields.get(random).setAnimal(new ScaredPanda(fields.get(random)));
                        }else{
                            fields.get(random).setAnimal(new JumpingPanda(fields.get(random)));
                        }
                        i++;
                    }
                }
            }
            boolean succ = false;
            if((Integer)ogspinner.getValue() == 2){
                while(!succ){
                    random = r.nextInt(fieldcount);
                    if (fields.get(random).getAnimal() == null) {
                        if (fields.get(random).getThing() == null) {
                            fields.get(random).setAnimal(new Orangutan(fields.get(random)));
                            succ = true;
                        }
                    }
                }
            }


            backGround = ImageIO.read(new File("img\\background.png"));

            int fieldSize = fields.size();

            int counter = 0;

            int offset = width*length/fields.size();
            for(int y=0; y<length; y++){
                for(int x=0; x<width; x++){
                    JButton button = new JButton();

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
                                    ogField = null;
                                }
                            }
                        });
                        counter++;
                    }
                    grid[x][y]= button;
                    gamePanel.add(grid[x][y]);
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
            f.setBackground(Color.GREEN);
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
                if(nfield.getThing() != null){
                    if(nfield.getThing().interactWith(new Animal())) {
                        nfield.setOpaque(true);
                        nfield.setBackground(Color.GREEN);
                        nfield.repaint();
                    }else{
                        nfield.setOpaque(true);
                        nfield.setBackground(Color.RED);
                        nfield.repaint();
                    }
                }else{
                    nfield.setOpaque(true);
                    nfield.setBackground(Color.GREEN);
                    nfield.repaint();
                }
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
