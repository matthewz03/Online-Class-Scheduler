package wakeup;

import javax.swing.JButton;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JSpinner;
import java.util.List;
//import org.jsoup.nodes.Document;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.jsoup.Jsoup;
import org.openqa.selenium.Keys;
import org.openqa.selenium.By;
import java.util.HashMap;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.concurrent.TimeUnit;
import java.awt.Robot;
import org.openqa.selenium.chrome.ChromeDriver;
import javax.swing.SwingWorker;

// 
// Decompiled by Procyon v0.5.36
// 

public class Run extends SwingWorker<Integer, Integer>
{
    public static boolean isSchool;
    
    static {
        Run.isSchool = false;
    }
    
    @Override
    protected Integer doInBackground() throws Exception {
        final int fatten = 5;
        if (!Interface.getNow()) {
            timer(Interface.startClock);
        }
        final String MY_USERNAME = Interface.getUser();
        final String MY_PASSWORD = Interface.getPass();
        final int GONERS = Interface.getNumLeavers();
        final int NUMTHANKS = Interface.getNumThanks();
        final String COLLAB1 = Interface.getCollab1();
        final String COLLAB2 = Interface.getCollab2();
        final String THANKMESSAGE = Interface.getThank();
        System.out.println("Program started... ");
        System.setProperty("webdriver.chrome.driver", Interface.makeChrome());
        final WebDriver driver = new ChromeDriver();
        final Robot keyboard = new Robot();
        System.out.println("driver created");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(40L, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30L, TimeUnit.SECONDS);
        driver.get("https://lms.fcps.edu/");
        final ChromeOptions options = new ChromeOptions();
        final HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_setting_values.media_stream_mic", 1);
        chromePrefs.put("profile.default_content_setting_values.media_stream_camera", 1);
        chromePrefs.put("profile.default_content_setting_values.notifications", 0);
        options.setExperimentalOption("prefs", chromePrefs);
        options.addArguments("--no-sandbox");
        driver.findElement(By.xpath("//input[@id='userNameInput']")).clear();
        driver.findElement(By.xpath("//input[@id='userNameInput']")).sendKeys(MY_USERNAME);
        driver.findElement(By.xpath("//input[@id='passwordInput']")).clear();
        driver.findElement(By.xpath("//input[@id='passwordInput']")).sendKeys(String.valueOf(MY_PASSWORD) + (Object)Keys.ENTER);
        System.out.println("Logged into Schoology");
        if (Interface.jlog && !Interface.b1.isSelected() && !Interface.b2.isSelected()) {
            resetButton();
            return null;
        }
        if (Interface.b1.isSelected()) {
            driver.get(COLLAB1);
        }
        else if (Interface.b2.isSelected()) {
            driver.get(COLLAB2);
        }
        else {
            driver.quit();
        }
        TimeUnit.SECONDS.sleep(3 + fatten);
        if (Interface.isCanceled) {
            driver.quit();
            resetButton();
            return null;
        }
        if (Run.isSchool) {
            Wakeup.mouseClick(720, 360);
            TimeUnit.SECONDS.sleep(1L);
            Wakeup.mouseClick(1050, 310);
        }
        else {
            Wakeup.mouseClick(950, 365);
            TimeUnit.SECONDS.sleep(1L);
            Wakeup.mouseClick(1320, 315);
        }
        TimeUnit.SECONDS.sleep(4L);
        if (Interface.jlog) {
            resetButton();
            return null;
        }
        final Set<String> handles = driver.getWindowHandles();
        final String currentHandle = driver.getWindowHandle();
        for (final String handle : handles) {
            if (!handle.equals(currentHandle)) {
                driver.switchTo().window(handle);
            }
        }
        final String url = driver.getCurrentUrl();
//        final Document page = Jsoup.connect(url).get();
//        System.out.println("Logged into " + page.title());
        TimeUnit.SECONDS.sleep(15 + 2 * fatten);
        for (Boolean isPresent = driver.findElements(By.className("close")).size() > 0; !isPresent; isPresent = (driver.findElements(By.className("close")).size() > 0)) {
            TimeUnit.SECONDS.sleep(1L);
        }
        keyboard.keyPress(27);
        for (Boolean isPresent = false; !isPresent; isPresent = (driver.findElements(By.className("close")).size() > 0)) {
            TimeUnit.SECONDS.sleep(1L);
        }
        keyboard.keyPress(27);
        for (Boolean isPresent = false; !isPresent; isPresent = (driver.findElements(By.className("close")).size() > 0)) {
            TimeUnit.SECONDS.sleep(1L);
        }
        for (Boolean isPresent = false; !isPresent; isPresent = (driver.findElements(By.className("close")).size() > 0)) {
            TimeUnit.SECONDS.sleep(1L);
        }
        if (Interface.isCanceled) {
            resetButton();
            driver.quit();
            return null;
        }
        TimeUnit.SECONDS.sleep(10 + 2 * fatten);
        if (Run.isSchool) {
            Wakeup.mouseClick(1337, 145);
        }
        else {
            Wakeup.mouseClick(1890, 145);
        }
        TimeUnit.SECONDS.sleep(5L);
        driver.findElement(By.id("side-panel-open")).click();
        driver.findElement(By.id("panel-control-participants")).click();
        String attendees = driver.findElement(By.id("participants-header")).getText();
        System.out.println(attendees);
        System.out.println();
        System.out.println();
        int a = 0;
        int max = 0;
        int hank = 0;
        boolean enoughHanks = false;
        driver.findElement(By.id("panel-control-activity")).click();
        driver.findElement(By.className("menu-list__inner-wrap")).click();
        List<WebElement> chat = driver.findElements(By.id("chat-channel-history"));
        while (max - a < GONERS || !enoughHanks) {
            hank = 0;
            a = Wakeup.attendeesToInt(attendees);
            if (a > max) {
                max = a;
            }
            driver.findElement(By.id("panel-control-participants")).click();
            attendees = driver.findElement(By.id("participants-header")).getText();
            TimeUnit.SECONDS.sleep(4L);
            driver.findElement(By.id("panel-control-activity")).click();
            TimeUnit.SECONDS.sleep(2L);
            driver.findElement(By.id("panel-back-button")).click();
            TimeUnit.SECONDS.sleep(2L);
            driver.findElement(By.className("menu-list__inner-wrap")).click();
            TimeUnit.SECONDS.sleep(2L);
            chat = driver.findElements(By.id("chat-channel-history"));
            hank = Wakeup.howManyHanks(Wakeup.convert(chat.get(0)));
            if (hank >= NUMTHANKS) {
                enoughHanks = true;
            }
            if (timeToStop(Interface.stopClock)) {
                break;
            }
            if (Interface.isCanceled) {
                resetButton();
                driver.quit();
                return null;
            }
        }
        TimeUnit.SECONDS.sleep(2L);
        if (Run.isSchool) {
            Wakeup.mouseClick(1170, 610);
            Wakeup.thank(THANKMESSAGE);
            TimeUnit.SECONDS.sleep(1L);
            Wakeup.mouseClick(1320, 645);
        }
        else {
            Wakeup.mouseClick(1560, 915);
            Wakeup.thank(THANKMESSAGE);
            TimeUnit.SECONDS.sleep(1L);
            Wakeup.mouseClick(1870, 950);
        }
        TimeUnit.SECONDS.sleep(1L);
        System.out.println();
        System.out.println("Chat History:");
        System.out.println(Wakeup.convert(chat.get(0)));
        driver.quit();
        resetButton();
        System.out.println();
        System.out.println("Thank yous: " + hank);
        System.out.println("Successfully left the session");
        return null;
    }
    
    public static void timer(final JSpinner j) throws InterruptedException {
        final Date now = new Date();
        final SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        final int cTime = convertToSecs(formatter.format(now));
        final int sTime = convertToSec(j);
        int waitTime;
        if (cTime > sTime) {
            waitTime = 86400 - cTime + sTime;
        }
        else {
            waitTime = sTime - cTime;
        }
        TimeUnit.SECONDS.sleep(waitTime);
    }
    
    public static boolean timeToStop(final JSpinner j) {
        final Date now = new Date();
        final SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        final int cTime = convertToSecs(formatter.format(now));
        final int sTime = convertToSec(j);
        return sTime < cTime;
    }
    
    public static void resetButton() {
        Interface.start.setBackground(new JButton().getBackground());
        Interface.start.setForeground(new JButton().getForeground());
        Interface.start.setText("Start Program");
    }
    
    public static int convertToSecs(String s) {
        String temp = s;
        int count = 0;
        temp = s.substring(0, s.indexOf(":"));
        s = s.substring(s.indexOf(":") + 1);
        count += Wakeup.attendeesToInt(temp) * 3600;
        temp = s.substring(0, s.indexOf(":"));
        s = s.substring(s.indexOf(":") + 1);
        count += Wakeup.attendeesToInt(temp) * 60;
        temp = s;
        count += Wakeup.attendeesToInt(temp);
        return count;
    }
    
    public static int convertToSec(final JSpinner j) {
        String temp;
        String s = temp = Interface.getTime(j);
        int count = 0;
        temp = s.substring(0, s.indexOf(":"));
        s = s.substring(s.indexOf(":") + 1);
        count += Wakeup.attendeesToInt(temp) * 3600;
        temp = s.substring(0, s.indexOf(":"));
        s = s.substring(s.indexOf(":") + 1);
        count += Wakeup.attendeesToInt(temp) * 60;
        temp = s;
        count += Wakeup.attendeesToInt(temp);
        return count;
    }
}
