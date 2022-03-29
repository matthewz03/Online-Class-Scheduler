package wakeup;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import java.awt.datatransfer.Clipboard;
import java.awt.Robot;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.Transferable;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.text.ParseException;
import java.io.IOException;
import java.awt.AWTException;


public class Wakeup
{
    public static void main(final String[] args) throws InterruptedException, AWTException, IOException, ParseException {
        new Interface();
    }
    
    public static void thank(final String s) throws AWTException {
        final StringSelection stringSelection = new StringSelection(s);
        final Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, stringSelection);
        final Robot robot = new Robot();
        robot.keyPress(17);
        robot.keyPress(86);
        robot.keyRelease(86);
        robot.keyRelease(17);
    }
    
    public static void mouseClick(final int x, final int y) throws AWTException {
        final Robot bot = new Robot();
        bot.mouseMove(x, y);
        bot.mousePress(1024);
        bot.mouseRelease(1024);
    }
    
    public static int howManyHanks(String s) {
        int count = 0;
        while (s.indexOf("hank") > -1) {
            ++count;
            s = s.substring(s.indexOf("hank") + 4);
        }
        return count;
    }
    
    public static String convert(final WebElement chatmessage) {
        final String str = chatmessage.getText();
        return str;
    }
    
    public static void wait(final int x) throws InterruptedException {
        TimeUnit.SECONDS.sleep(x);
    }
    
    public static int attendeesToInt(final String att) {
        if (isInt(att.substring(0, 1)) && isInt(att.substring(1, 2))) {
            return Integer.parseInt(att.substring(0, 2));
        }
        return Integer.parseInt(att.substring(0, 1));
    }
    
    public static boolean isInt(final String str) {
        for (int i = 0; i < str.length(); ++i) {
            final char c = str.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }
}