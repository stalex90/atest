import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URI;

public class BaseTest {
    protected RemoteWebDriver driver;
    private static final ThreadLocal<Logger> LOGGER = new ThreadLocal<>();
    private String methodName = "";
    private String className = "";

    @BeforeClass(alwaysRun = true)
    public void setUpMainClass() {
        className = this.getClass().getName();
        LOGGER.set(LogManager.getLogger(className));
    }

    @Parameters({"browser"})
    @BeforeMethod
    void setUpMethodMain(String browser, Method method){
        methodName = method.getName();
        LOGGER.set(LogManager.getLogger(className + " " + methodName+ " " + browser));
        String runType = "local";
        switch (runType) {
            case ("local"):
                if(browser.equals("chrome")) {
                    System.setProperty("webdriver.chrome.driver", "C:\\!work\\chromedriver.exe");
                    driver= new ChromeDriver();
                    driver.manage().window().maximize();
                    WebDriverRunner.setWebDriver(driver);
                }
                else if(browser.equals("firefox")) {
                    System.setProperty("webdriver.gecko.driver", "C:\\!work\\geckodriver.exe");
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                    WebDriverRunner.setWebDriver(driver);
                }else if(browser.equals("ie")) {
                    System.setProperty("webdriver.ie.driver", "C:\\!work\\IEDriverServer.exe");
                    driver =new InternetExplorerDriver();
                    driver.manage().window().maximize();
                    WebDriverRunner.setWebDriver(driver);
                }
                break;
            case ("selenoid"):
                DesiredCapabilities caps = new DesiredCapabilities();
                caps.setBrowserName(browser);
                caps.setCapability("enableVNC", true);
                try {
                    driver = new RemoteWebDriver(URI.create("http://localhost:4444/wd/hub").toURL(), caps);
                    driver.manage().window().setSize(new Dimension(1920, 1080));
                    WebDriverRunner.setWebDriver(driver);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                break;
        }
        LOGGER.get().info("BeforeParentMethod");
    }

    @AfterMethod
    void finishMethod(){
        Selenide.close();
        LOGGER.get().info("AfterParentMethod");

    }

    public static Logger getLogger() {
        return LOGGER.get();
    }

}
