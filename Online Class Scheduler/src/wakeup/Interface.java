package wakeup;

import java.text.SimpleDateFormat;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.ParseException;
import javax.swing.JComponent;
import javax.swing.SpinnerModel;
import java.util.Date;
import java.awt.event.MouseListener;
import java.net.URISyntaxException;
import java.io.IOException;
import java.net.URI;
import java.awt.Desktop;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.Cursor;
import java.awt.Color;
import javax.swing.Action;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import java.awt.LayoutManager;
import java.awt.Component;
import javax.swing.JPanel;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

// 
// Decompiled by Procyon v0.5.36
// 

public class Interface extends JFrame implements ActionListener
{
    public static boolean isCanceled;
    private static Run program;
    private static JCheckBox justLogin;
    public static boolean jlog;
    private static boolean isStart;
    private static boolean now;
    public static JCheckBox startNow;
    private static JLabel convertLink;
    public static JRadioButton b1;
    public static JRadioButton b2;
    public static JSpinner stopClock;
    private static SpinnerDateModel stopTime;
    public static JSpinner startClock;
    private static SpinnerDateModel startTime;
    private static JLabel usernameLabel;
    private static JTextField usernameInput;
    private static JLabel passwordLabel;
    private static JPasswordField passwordInput;
    private static JLabel collabLink1;
    private static JTextField collabInput1;
    private static JLabel collabLink2;
    private static JTextField collabInput2;
    private static JLabel thankLabel;
    private static JTextField thankInput;
    private static JLabel beforeLabel;
    private static JLabel numThanksLabel;
    private static JTextField numThanksInput;
    private static JLabel leaversLabel;
    private static JTextField leaversInput;
    private static JLabel startLabel;
    private static JLabel stopLabel;
    static JButton start;
    public static String notUsername;
    public static boolean editable;
    private static JButton save;
    static File file;
    
    static {
        Interface.isCanceled = false;
        Interface.jlog = false;
        Interface.isStart = true;
        Interface.now = false;
        Interface.notUsername = "1475571";
        Interface.editable = false;
    }
    
    public Interface() throws IOException, ParseException, NullPointerException {
        final JFrame frame = new JFrame("Wakeup");
        final JPanel panel = new JPanel();
        frame.setDefaultCloseOperation(3);
        frame.setSize(800, 500);
        frame.setResizable(false);
        frame.add(panel);
        panel.setLayout(null);
        frame.setLocationRelativeTo(null);
        (Interface.usernameLabel = new JLabel("Username:")).setBounds(30, 20, 100, 25);
        (Interface.usernameInput = new JTextField(100)).setBounds(110, 20, 150, 25);
        Interface.usernameInput.setText(Interface.notUsername);
        Interface.usernameInput.setEditable(Interface.editable);
        panel.add(Interface.usernameLabel);
        panel.add(Interface.usernameInput);
        (Interface.passwordLabel = new JLabel("Password:")).setBounds(30, 60, 100, 25);
        (Interface.passwordInput = new JPasswordField(100)).setBounds(110, 60, 150, 25);
        panel.add(Interface.passwordLabel);
        panel.add(Interface.passwordInput);
        (Interface.collabLink1 = new JLabel("Collaborate Link 1:")).setBounds(10, 115, 250, 25);
        (Interface.collabInput1 = new JTextField(100)).setBounds(10, 140, 250, 25);
        panel.add(Interface.collabLink1);
        panel.add(Interface.collabInput1);
        (Interface.collabLink2 = new JLabel("Collaborate Link 2:")).setBounds(10, 180, 275, 25);
        (Interface.collabInput2 = new JTextField(100)).setBounds(10, 205, 250, 25);
        panel.add(Interface.collabLink2);
        panel.add(Interface.collabInput2);
        final JLabel rbuttonLabel = new JLabel("Select Link to Use:");
        rbuttonLabel.setBounds(270, 115, 275, 25);
        panel.add(rbuttonLabel);
        (Interface.b1 = new JRadioButton()).setBounds(270, 140, 25, 25);
        panel.add(Interface.b1);
        (Interface.b2 = new JRadioButton()).setBounds(270, 205, 25, 25);
        panel.add(Interface.b2);
        final ButtonGroup group = new ButtonGroup();
        group.add(Interface.b1);
        group.add(Interface.b2);
        (Interface.thankLabel = new JLabel("Thank you message:")).setBounds(10, 250, 275, 25);
        (Interface.thankInput = new JTextField(100)).setBounds(10, 275, 250, 25);
        panel.add(Interface.thankLabel);
        panel.add(Interface.thankInput);
        (Interface.startNow = new JCheckBox(new AbstractAction("Start Now") {
            @Override
            public void actionPerformed(final ActionEvent e) {
                if (Interface.now) {
                    Interface.access$1(false);
                }
                else {
                    Interface.access$1(true);
                }
            }
        })).setBounds(450, 150, 100, 25);
        panel.add(Interface.startNow);
        (Interface.justLogin = new JCheckBox(new AbstractAction("Just Login") {
            @Override
            public void actionPerformed(final ActionEvent e) {
                if (Interface.jlog) {
                    Interface.jlog = false;
                }
                else {
                    Interface.jlog = true;
                }
            }
        })).setBounds(450, 175, 100, 25);
        panel.add(Interface.justLogin);
        (Interface.startLabel = new JLabel("Start time:")).setBounds(450, 20, 70, 25);
        panel.add(Interface.startLabel);
        final Color customred = new Color(207, 78, 113);
        (Interface.convertLink = new JLabel("Click for 24 hour time converter")).setForeground(customred);
        Interface.convertLink.setCursor(new Cursor(12));
        Interface.convertLink.setBounds(450, 95, 300, 25);
        panel.add(Interface.convertLink);
        Interface.convertLink.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(final MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI("https://www.timecalculator.net/12-hour-to-24-hour-converter"));
                }
                catch (IOException | URISyntaxException ex2) {
                    ex2.printStackTrace();
                }
            }
            
            @Override
            public void mouseExited(final MouseEvent e) {
                Interface.convertLink.setText("Click for 24 hour time converter");
            }
            
            @Override
            public void mouseEntered(final MouseEvent e) {
                Interface.convertLink.setText("<html><a href=''>Click for 24 hour time converter</a></html>");
            }
        });
        final Date date = new Date();
        Interface.startTime = new SpinnerDateModel(date, null, null, 11);
        Interface.startClock = new JSpinner(Interface.startTime);
        final JSpinner.DateEditor de = new JSpinner.DateEditor(Interface.startClock, "HH:mm:ss");
        Interface.startClock.setEditor(de);
        Interface.startClock.setBounds(520, 20, 80, 25);
        panel.add(Interface.startClock);
        (Interface.stopLabel = new JLabel("Emergency stop:")).setBounds(450, 60, 100, 25);
        panel.add(Interface.stopLabel);
        final Date date2 = new Date();
        Interface.stopTime = new SpinnerDateModel(date2, null, null, 11);
        Interface.stopClock = new JSpinner(Interface.stopTime);
        final JSpinner.DateEditor de2 = new JSpinner.DateEditor(Interface.stopClock, "HH:mm:ss");
        Interface.stopClock.setEditor(de2);
        Interface.stopClock.setBounds(550, 60, 80, 25);
        panel.add(Interface.stopClock);
        (Interface.beforeLabel = new JLabel("Before Leaving:")).setBounds(450, 230, 300, 25);
        panel.add(Interface.beforeLabel);
        (Interface.numThanksLabel = new JLabel("# of Thank Yous in chat:")).setBounds(450, 250, 250, 25);
        (Interface.numThanksInput = new JTextField(100)).setBounds(600, 250, 30, 25);
        panel.add(Interface.numThanksLabel);
        panel.add(Interface.numThanksInput);
        (Interface.leaversLabel = new JLabel("# of students that leave:")).setBounds(450, 275, 250, 25);
        (Interface.leaversInput = new JTextField(100)).setBounds(600, 275, 30, 25);
        panel.add(Interface.leaversLabel);
        panel.add(Interface.leaversInput);
        try {
            Interface.file = new File(makeInfo());
            if (Interface.file.createNewFile()) {
                System.out.println("info.txt created");
            }
        }
        catch (IOException | URISyntaxException ex2) {
            ex2.printStackTrace();
        }
        String temp = getUser();
        temp = getPass();
        temp = getCollab1();
        temp = getCollab2();
        temp = getThank();
        setTime();
        int anotherTemp = getNumLeavers();
        anotherTemp = getNumThanks();
        (Interface.start = new JButton(new AbstractAction("Start Program") {
            @Override
            public void actionPerformed(final ActionEvent e) {
                try {
                    clear(makeInfo());
                    System.out.println("File cleared");
                }
                catch (IOException | URISyntaxException ex3) {
                    System.out.println("Error clearing file");
                    ex3.printStackTrace();
                }
                try {
                    filePrinter(makeInfo());
                    System.out.println("Data saved");
                }
                catch (IOException | URISyntaxException ex4) {
                    System.out.println("Error printing to file");
                    ex4.printStackTrace();
                }
                if (Interface.isStart) {
                    Interface.isCanceled = false;
                    Interface.access$7(new Run());
                    Interface.program.execute();
                    Interface.start.setBackground(new Color(59, 196, 126));
                    Interface.start.setForeground(new Color(38, 41, 39));
                    Interface.start.setText("Stop Program");
                    Interface.access$9(false);
                }
                else {
                    Interface.isCanceled = true;
                    System.out.println("Program Stopped");
                    Interface.start.setBackground(new JButton().getBackground());
                    Interface.start.setForeground(new JButton().getForeground());
                    Interface.start.setText("Start Program");
                    Interface.access$9(true);
                }
            }
        })).setBounds(400, 350, 120, 30);
        panel.add(Interface.start);
        (Interface.save = new JButton(new AbstractAction("Save Info") {
            @Override
            public void actionPerformed(final ActionEvent e) {
                try {
                    clear(makeInfo());
                    System.out.println("File cleared");
                }
                catch (IOException | URISyntaxException ex3) {
                    System.out.println("Error clearing file");
                    ex3.printStackTrace();
                }
                try {
                    filePrinter(makeInfo());
                    System.out.println("Data saved");
                }
                catch (IOException | URISyntaxException ex4) {
                    System.out.println("Error printing to file");
                    ex4.printStackTrace();
                }
            }
        })).setBounds(280, 350, 120, 30);
        panel.add(Interface.save);
        frame.setVisible(true);
    }
    
    public static boolean getNow() {
        return Interface.now;
    }
    
    private static void filePrinter(final String s) throws IOException {
        final FileWriter w = new FileWriter(s);
        w.write("Username: " + Interface.usernameInput.getText() + "\r\n");
        w.write("Password: " + Interface.passwordInput.getText() + "\r\n");
        w.write("Link 1: " + Interface.collabInput1.getText() + "\r\n");
        w.write("Link 2: " + Interface.collabInput2.getText() + "\r\n");
        w.write("Thank you message: " + Interface.thankInput.getText() + "\r\n");
        w.write("Start time: " + getTime(Interface.startClock) + "\r\n");
        w.write("End time: " + getTime(Interface.stopClock) + "\r\n");
        w.write("# of students that leave: " + Interface.leaversInput.getText() + "\r\n");
        w.write("# of thanks before leaving: " + Interface.numThanksInput.getText() + "\r\n");
        w.close();
        Interface.passwordInput.setText(Interface.passwordInput.getText());
        Interface.collabInput1.setText(Interface.collabInput1.getText());
        Interface.collabInput2.setText(Interface.collabInput2.getText());
        Interface.thankInput.setText(Interface.thankInput.getText());
    }
    
    public static void setTime() throws IOException, ParseException {
        final BufferedReader reader = new BufferedReader(new FileReader(Interface.file));
        reader.readLine();
        reader.readLine();
        reader.readLine();
        reader.readLine();
        reader.readLine();
        String string = reader.readLine();
        if (string != null && string.indexOf(":") != -1) {
            string = string.substring(string.indexOf(":") + 2);
            System.out.println(string);
            Interface.startClock.setValue(stringToDate(string));
        }
        string = reader.readLine();
        if (string != null && string.indexOf(":") != -1) {
            string = string.substring(string.indexOf(":") + 2);
            System.out.println(string);
            Interface.stopClock.setValue(stringToDate(string));
        }
        reader.close();
    }
    
    public static Date stringToDate(final String s) throws ParseException {
        final Date date = new SimpleDateFormat("HH:mm:ss").parse(s);
        return date;
    }
    
    public static String getTime(final JSpinner t) {
        final Object x = t.getValue();
        if (x instanceof Date) {
            final Date date = (Date)x;
            final SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
            final String string = format.format(date);
            return string;
        }
        return "invalid time format";
    }
    
    private static void clear(final String s) throws IOException {
        final FileWriter w = new FileWriter(s, false);
        w.close();
    }
    
    private static String makeInfo() throws URISyntaxException {
        String s = Wakeup.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath();
        if (s.indexOf("jar") != -1) {
            s = s.substring(0, s.length() - 11);
        }
        return String.valueOf(s) + "\\info.txt";
    }
    
    public static String makeChrome() throws URISyntaxException {
        String s = Wakeup.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath();
        if (s.indexOf("jar") != -1) {
            s = s.substring(0, s.length() - 11);
        }
        return String.valueOf(s) + "\\chromedriver.exe";
    }
    
    public static String getUser() throws IOException {
        final BufferedReader reader = new BufferedReader(new FileReader(Interface.file));
        String string = reader.readLine();
        if (string != null && string.indexOf(":") != -1) {
            string = string.substring(string.indexOf(":") + 2);
            System.out.println(string);
            if (Interface.editable) {
                Interface.usernameInput.setText(string);
            }
            reader.close();
            return string;
        }
        reader.close();
        return null;
    }
    
    public static String getPass() throws IOException {
        final BufferedReader reader = new BufferedReader(new FileReader(Interface.file));
        reader.readLine();
        String string = reader.readLine();
        if (string != null && string.indexOf(":") != -1) {
            string = string.substring(string.indexOf(":") + 2);
            System.out.println(string);
            Interface.passwordInput.setText(string);
            reader.close();
            return string;
        }
        reader.close();
        return null;
    }
    
    public static String getCollab1() throws IOException {
        final BufferedReader reader = new BufferedReader(new FileReader(Interface.file));
        reader.readLine();
        reader.readLine();
        String string = reader.readLine();
        if (string != null && string.indexOf(":") != -1) {
            string = string.substring(string.indexOf(":") + 2);
            System.out.println(string);
            Interface.collabInput1.setText(string);
            reader.close();
            return string;
        }
        reader.close();
        return null;
    }
    
    public static String getCollab2() throws IOException {
        final BufferedReader reader = new BufferedReader(new FileReader(Interface.file));
        reader.readLine();
        reader.readLine();
        reader.readLine();
        String string = reader.readLine();
        if (string != null && string.indexOf(":") != -1) {
            string = string.substring(string.indexOf(":") + 2);
            System.out.println(string);
            Interface.collabInput2.setText(string);
            reader.close();
            return string;
        }
        reader.close();
        return null;
    }
    
    public static String getThank() throws IOException {
        final BufferedReader reader = new BufferedReader(new FileReader(Interface.file));
        reader.readLine();
        reader.readLine();
        reader.readLine();
        reader.readLine();
        String string = reader.readLine();
        if (string != null && string.indexOf(":") != -1) {
            string = string.substring(string.indexOf(":") + 2);
            System.out.println(string);
            Interface.thankInput.setText(string);
            reader.close();
            return string;
        }
        reader.close();
        return null;
    }
    
    public static int getNumLeavers() throws IOException {
        final BufferedReader reader = new BufferedReader(new FileReader(Interface.file));
        reader.readLine();
        reader.readLine();
        reader.readLine();
        reader.readLine();
        reader.readLine();
        reader.readLine();
        reader.readLine();
        String string = reader.readLine();
        if (string != null && string.indexOf(":") != -1) {
            string = string.substring(string.indexOf(":") + 2);
            if (string.length() > 0 && Wakeup.isInt(string)) {
                System.out.println(string);
                Interface.leaversInput.setText(string);
                reader.close();
                return Integer.parseInt(string);
            }
        }
        else {
            reader.close();
        }
        return -1;
    }
    
    public static int getNumThanks() throws IOException {
        final BufferedReader reader = new BufferedReader(new FileReader(Interface.file));
        reader.readLine();
        reader.readLine();
        reader.readLine();
        reader.readLine();
        reader.readLine();
        reader.readLine();
        reader.readLine();
        reader.readLine();
        String string = reader.readLine();
        if (string != null && string.indexOf(":") != -1) {
            string = string.substring(string.indexOf(":") + 2);
            if (string.length() > 0 && Wakeup.isInt(string)) {
                System.out.println(string);
                Interface.numThanksInput.setText(string);
                reader.close();
                return Integer.parseInt(string);
            }
        }
        else {
            reader.close();
        }
        return -1;
    }
    
    @Override
    public void actionPerformed(final ActionEvent e) {
    }
    
    static /* synthetic */ void access$1(final boolean now) {
        Interface.now = now;
    }
    
    static /* synthetic */ void access$7(final Run program) {
        Interface.program = program;
    }
    
    static /* synthetic */ void access$9(final boolean isStart) {
        Interface.isStart = isStart;
    }
}
