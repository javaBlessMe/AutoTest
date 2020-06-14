package ru.andreev;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AutoTest {
    private WebDriver driver;

    @BeforeEach
    public void setUpAndOpen(){
        Settings settings = new Settings(Browser.CHROME);
        driver = settings.getDriver();
        driver.get("https://www.auto.ru");
    }
    @AfterEach()
    public void closePage(){
        driver.quit();
    }

    @Test
    public void passengerCarTest() {


                boolean testResult = new PassengerCar(driver)
                .selectNewCars()
                .selectVolkswagenCars()
                .getResult(5)
                .checkResult("Caravelle",10);

                assertTrue(testResult);

    }
}
