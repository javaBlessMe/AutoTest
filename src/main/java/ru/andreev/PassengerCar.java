package ru.andreev;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Map;

public class PassengerCar {
private WebDriver driver;
private String result;

//Задаем вебэлементы
@FindBy(css="div.IndexSelector__sections > span > label:nth-child(2) > button > span > span")
private WebElement newCars;

@FindBy(css="div.IndexMarks__super-marks > a:nth-child(10) > img")
private WebElement volkswagenCars;

@FindBy(id = "popularMMM")
private WebElement resultTable;

//Конструктор
    public PassengerCar(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
//Выбираем новые автомобили
    public PassengerCar selectNewCars(){
        newCars.click();
        return this;
    }
    //Выбираем марку Фольксваген
    public PassengerCar selectVolkswagenCars(){
        volkswagenCars.click();
        return this;
    }

    //Получаем данные и записываем их в таблицу
    public PassengerCar getResult(int waitingTime){
        WebDriverWait wait = new WebDriverWait(driver, waitingTime);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("popularMMM")));
        result = resultTable.getText();
        return this;
    }

    //Проверяем, что объявлений по продаже нужной модели больше определенного (число задает пользователь)
    public  boolean checkResult(String carModel, int quantity){
        int factCarQuantity;
        String[] model = result.split("\n");
        Map<String,String> modelAndQuantity = new HashMap<>();

        for (int i = 1; i < model.length ; i+=2) {

            modelAndQuantity.put(model[i-1],model[i]);

        }


        try {
            factCarQuantity = Integer.parseInt(modelAndQuantity.get(carModel));
        }
        catch (NumberFormatException e){
            return false;
        }

        return factCarQuantity>quantity;
    }

}
