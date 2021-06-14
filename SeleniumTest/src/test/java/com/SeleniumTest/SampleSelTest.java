package com.SeleniumTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.Keys;


public class SampleSelTest {
    WebDriver driver;

        @Test (priority = 0)
        public void Success() {

            System.setProperty("webdriver.chrome.driver",
                    "webdrivers/chromedriver91.exe");
            driver = new ChromeDriver();

            driver.get("http://kitm.epizy.com/filmai.php?");


            driver.findElement(By.name("id")).sendKeys("901");
            driver.findElement(By.name("pavadinimas")).sendKeys("aaaa");
        driver.findElement(By.name("zanras")).sendKeys("aaaa");
        driver.findElement(By.name("aktoriai")).sendKeys("aaaa");
        driver.findElement(By.name("rezisierius")).sendKeys("aaaa");
            driver.findElement(By.name("trukme")).sendKeys("1234");
            driver.findElement(By.name("trukme")).sendKeys(Keys.ENTER);
            Assert.assertEquals("Duomenys įrašyti sėkmingai", "Duomenys įrašyti sėkmingai");
    }
    @Test (priority = 1)
    public void Failure() {


        driver.findElement(By.name("id")).sendKeys("901");
        driver.findElement(By.name("pavadinimas")).sendKeys("aaaa");
        driver.findElement(By.name("zanras")).sendKeys("aaaa");
        driver.findElement(By.name("aktoriai")).sendKeys("aaaa");
        driver.findElement(By.name("rezisierius")).sendKeys("a");
        driver.findElement(By.name("trukme")).sendKeys("1234");
        driver.findElement(By.name("trukme")).sendKeys(Keys.ENTER);
        Assert.assertEquals("Duomenų įvedimo klaida", "Duomenys įrašyti sėkmingai");
    }
    @Test (priority = 2)
    public void Delete() {

    driver.findElement(By.name("id")).sendKeys("901");
        WebElement delete = driver.findElement(By.name("delete"));
        delete.click();


        Assert.assertEquals("Įrašas ištrintas sėkmingai", "Įrašas ištrintas sėkmingai");
    }
    @Test (priority = 3)
    public void EditSuccess() {

        driver.findElement(By.name("id")).sendKeys("901");
        driver.findElement(By.name("pavadinimas")).sendKeys("aaaabb");
        driver.findElement(By.name("zanras")).sendKeys("aaaab");
        driver.findElement(By.name("aktoriai")).sendKeys("aaaabbbb");
        driver.findElement(By.name("rezisierius")).sendKeys("bbbb");
        driver.findElement(By.name("trukme")).sendKeys("1234");

        driver.findElement(By.name("update")).sendKeys(Keys.ENTER);
        Assert.assertEquals("Įrašas paredaguotas sėkmingai", "Įrašas paredaguotas sėkmingai");
    }
    @Test (priority = 4)
    public void EditFailure() {

        driver.findElement(By.name("id")).sendKeys("901");
        driver.findElement(By.name("pavadinimas")).sendKeys("aaaabb");
        driver.findElement(By.name("zanras")).sendKeys("1");
        driver.findElement(By.name("aktoriai")).sendKeys("aaaabbbb");
        driver.findElement(By.name("rezisierius")).sendKeys("bbbb");
        driver.findElement(By.name("trukme")).sendKeys("1234");

        driver.findElement(By.name("update")).sendKeys(Keys.ENTER);
        Assert.assertEquals("Blogai įvesti duomenys redaguojant įrašą", "Įrašas paredaguotas sėkmingai");
    }
}
