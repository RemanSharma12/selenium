package swaglabs;


import net.jodah.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class swagslab {
    static WebDriver driver;
    public static void setup(){
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }

    public static void closeBrowser() throws InterruptedException{
        Thread.sleep(5000);
        driver.close();
        driver.quit();
    }
    public static void verification(String locator,String expected){
        String actual=driver.findElement(By.xpath(locator)).getText();
        Assert.isTrue(actual.equals(expected),"doesn't match");
    }
    public static void login(){

        driver.findElement(By.name("user-name")).sendKeys("standard_user");
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.name("login-button")).click();
    }
    public static void addToCart(){
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.className("shopping_cart_container")).click();
    }

    public static void checkout(){
        driver.findElement(By.name("checkout")).click();
        driver.findElement(By.name("firstName")).sendKeys("sham");
        driver.findElement(By.name("lastName")).sendKeys("sharma");
        driver.findElement(By.name("postalCode")).sendKeys("12345");
        driver.findElement(By.name("continue")).click();

    }
    public static void complete(){
        driver.findElement(By.xpath("//button[@name='finish']")).sendKeys("finish");
       // driver.findElement(By.name("finish")).click();

    }
    public static void main(String[] args) throws InterruptedException{
        setup();
        login();
        verification("//span[@class='title']","PRODUCTS");
        addToCart();
        checkout();
        complete();
        closeBrowser();

    }
}
