import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Tester extends JFrame {

    private String workingDirectory = System.getProperty("user.dir");

    private JTextField tProtoPath;
    private JTextField tTestPath;
    private JTextField tTestOutPath;
    private JTextField tLogPath;

    private File pandaPlazaPath;
    private File testCaseInPath;
    private File testCaseOutPath;
    private File logFilePath;

    private int logSequenceNum = 0;

    public Tester(){
        super("Proto teszter");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(700, 600));

        InitializeComponents();
    }

    private void InitializeComponents(){
        GridLayout gridLayout = new GridLayout(2, 1);
        gridLayout.setVgap(10);

        JPanel containerPanel = new JPanel(gridLayout);

        JPanel mainPanel = new JPanel();

        JPanel topperPanel = new JPanel();
        topperPanel.setSize(700, 100);
        String topText = "The Tester is a program which was made for making the Proto testing" +
                " easier.\n\nWith this graphical interface, you can easily find the path of the PandaPlaza.jar," +
                "choose a test-case,\nchoose a desired output and optionally choose an existing log file, or just simply " +
                "choose a path \nwhere you want the logfile to be created.";
        JTextArea topLabel = new JTextArea(topText, 4, 0);
        topLabel.setEnabled(false);
        topLabel.setBackground(new Color(238, 238, 238));
        topLabel.setDisabledTextColor(Color.black);
        topperPanel.add(topLabel);
        mainPanel.add(topperPanel);

        JButton bProtoPath = new JButton("Open proto jar file  ");
        tProtoPath = new JTextField(40);
        mainPanel.add(bProtoPath);
        mainPanel.add(tProtoPath);

        JButton bTestPath = new JButton("Open test-case file");
        tTestPath = new JTextField(40);
        mainPanel.add(bTestPath);
        mainPanel.add(tTestPath);

        JButton bTestOutPath = new JButton("Open test-out file    ");
        tTestOutPath = new JTextField(40);
        mainPanel.add(bTestOutPath);
        mainPanel.add(tTestOutPath);

        JButton bLogPath = new JButton("Open path of logfile");
        tLogPath = new JTextField(40);
        mainPanel.add(bLogPath);
        mainPanel.add(tLogPath);

        JButton bRun = new JButton("Run test-case");
        mainPanel.add(bRun);

        containerPanel.add(mainPanel);

        final JTextArea tLogText = new JTextArea(50, 40);
        tLogText.setEditable(false);
        JScrollPane logPanel = new JScrollPane(tLogText);
        containerPanel.add(logPanel);
        this.add(containerPanel);

        bProtoPath.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               try{
                    JFileChooser fileChooser = new JFileChooser();
                    fileChooser.setMultiSelectionEnabled(false);
                    fileChooser.addChoosableFileFilter(new OpenFileFilter(".jar", "Proto.jar file"));
                    int returner = fileChooser.showOpenDialog(Tester.this);
                    if (returner == JFileChooser.APPROVE_OPTION) {
                        pandaPlazaPath = new File(fileChooser.getSelectedFile().getCanonicalPath());
                        if(!pandaPlazaPath.toString().contains("Proto.jar")){
                            JOptionPane.showMessageDialog(Tester.this, "Nem a Proto.jar-t választottad ki!");
                            pandaPlazaPath = null;
                            return;
                        }
                        tProtoPath.setText(pandaPlazaPath.getCanonicalPath());
                    }
                }
                catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        });

        bTestPath.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try{
                    JFileChooser fileChooser = new JFileChooser();
                    fileChooser.setMultiSelectionEnabled(false);
                    fileChooser.addChoosableFileFilter(new OpenFileFilter(".txt", "testcase_n_in.txt, ahol 0 < n < 33"));
                    int returner = fileChooser.showOpenDialog(Tester.this);
                    if (returner == JFileChooser.APPROVE_OPTION) {
                        testCaseInPath = new File(fileChooser.getSelectedFile().getCanonicalPath());
                        if(!testCaseInPath.toString().contains("testcase_") || !testCaseInPath.toString().contains("_in.txt")){
                            JOptionPane.showMessageDialog(Tester.this, "Nem egy bemeneti testcase-t választottál ki!");
                            testCaseInPath = null;
                            return;
                        }
                        tTestPath.setText(testCaseInPath.getCanonicalPath());
                    }
                }
                catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        });

        bTestOutPath.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try{
                    JFileChooser fileChooser = new JFileChooser();
                    fileChooser.setMultiSelectionEnabled(false);
                    fileChooser.addChoosableFileFilter(new OpenFileFilter(".txt", "testcase_n_out.txt, ahol 0 < n < 33"));
                    int returner = fileChooser.showOpenDialog(Tester.this);
                    if (returner == JFileChooser.APPROVE_OPTION) {
                        testCaseOutPath = new File(fileChooser.getSelectedFile().getCanonicalPath());
                        if(!testCaseOutPath.toString().contains("testcase_") || !testCaseOutPath.toString().contains("_out.txt")){
                            JOptionPane.showMessageDialog(Tester.this, "Nem egy kimeneti testcase-t választottál ki!");
                            testCaseOutPath = null;
                            return;
                        }
                        tTestOutPath.setText(testCaseOutPath.getCanonicalPath());
                    }
                }
                catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        });

        bLogPath.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try{
                    JFileChooser fileChooser = new JFileChooser();
                    fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                    fileChooser.setMultiSelectionEnabled(false);
                    int returner = fileChooser.showOpenDialog(Tester.this);
                    if (returner == JFileChooser.APPROVE_OPTION) {
                        logFilePath = new File(fileChooser.getSelectedFile().getCanonicalPath());
                        tLogPath.setText(logFilePath.getCanonicalPath());
                    }
                }
                catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        });

        bRun.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try{
                    String testCaseInNum = testCaseInPath.getName().split("_")[1];
                    String testCaseOutNum = testCaseOutPath.getName().split("_")[1];
                    if(!testCaseInNum.equals(testCaseOutNum)){
                        JOptionPane.showMessageDialog(Tester.this, "A bemeneti és elvárt kimeneti " +
                                "fájlok teszteset-sorszáma nem egyezik meg! (bemeneti: " + testCaseInNum + ") (kimeneti: " + testCaseOutNum + ")");
                        return;
                    }
                    if(pandaPlazaPath.toString().equals("")){
                        JOptionPane.showMessageDialog(Tester.this, "Nincs megadva Proto.jar!");
                        return;
                    }

                    if(testCaseInPath.toString().equals("") || testCaseOutPath.toString().equals("")){
                        JOptionPane.showMessageDialog(Tester.this, "Nincs megadva be- és/vagy kimeneti teszteset!");
                        return;
                    }

                    String str = execute("java -jar " + pandaPlazaPath.getName() + " " + testCaseInPath.getName() + " " + testCaseOutPath.getName());
                    String previousLog = tLogText.getText();
                    String logText = "************************************************\nLog number: "+logSequenceNum++ + "" + str+
                            "************************************************\n";
                    if(logFilePath != null){
                        try{
                            WriteToLogFile(logFilePath, previousLog + logText);
                        }
                        catch (IOException ex) {
                            logText += "\nNem lehetett irni a logfile-t!\n";
                        }
                    }

                    tLogText.setText(previousLog + logText);

                }
                catch (IOException ex){
                    ex.printStackTrace();
                }
            }
        });
    }

    private String execute( String command ) throws IOException {
        Process p = Runtime.getRuntime().exec( "cmd /c " + command );
        InputStream i = p.getInputStream();
        StringBuilder sb = new StringBuilder();
        for(  int c = 0 ; ( c =  i.read() ) > -1  ; ) {
            sb.append( ( char ) c );
        }
        i.close();
        return sb.toString();
    }

    private void WriteToLogFile(File logFile, String content) throws IOException{
        logFile = new File(logFile.getCanonicalPath() + "\\logfile.txt");
        FileWriter fileWriter = new FileWriter(logFile);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.println(content);
        printWriter.close();
    }

    public class OpenFileFilter extends FileFilter {

        String description = "";
        String fileExt = "";

        public OpenFileFilter(String extension) {
            fileExt = extension;
        }

        public OpenFileFilter(String extension, String typeDescription) {
            fileExt = extension;
            this.description = typeDescription;
        }

        @Override
        public boolean accept(File f) {
            if (f.isDirectory())
                return true;
            return (f.getName().toLowerCase().endsWith(fileExt));
        }

        @Override
        public String getDescription() {
            return description;
        }
    }
}