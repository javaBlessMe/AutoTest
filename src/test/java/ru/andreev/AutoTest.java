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
        Settings settings = new Settings(Browser.CHROME);//Выбираем браузер для тестирования
        driver = settings.getDriver();
        driver.get("https://www.auto.ru");
    }
    @AfterEach()
    public void closePage(){
        driver.quit();
    }

    @Test
    public void passengerCarTest() {


                boolean testResult = new PassengerCar(driver) //Создаем объект класса легковой а/м
                .selectNewCars() //Выбираем новые автомобили
                .selectVolkswagenCars() //выбираем марку
                .getResult(5) //ждем результатов в течение 5 секунд
                .checkResult("Caravelle",10); //Задаем модель машины и минимальное кол-во
                                                            // объявлений, которые есть по этой модели

                assertTrue(testResult); //если объявлений больше, то тест пройден

    }
}
