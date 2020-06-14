package ru.andreev;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Settings {
        private Browser browser;
        private WebDriver driver;
        private List<String> browsersSettings =
               new ArrayList<>(Arrays.asList("start-maximized","--disable-notifications","--disable-popup-blocking"));

    public  Settings(Browser browser) {
        this.browser = browser;
        if(browser==Browser.CHROME){
            ChromeDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments(browsersSettings);
             this.driver = new ChromeDriver(options);
        }

        if(browser==Browser.FIREFOX){
            FirefoxDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments(browsersSettings);
            this.driver = new FirefoxDriver(options);
        }
    }


    public WebDriver getDriver() {
        return driver;
    }
}
