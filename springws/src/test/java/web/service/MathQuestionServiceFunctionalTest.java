package web.service;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MathQuestionServiceFunctionalTest {

	private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", 
	            "E:\\New folder\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        driver.get("http://localhost:8080/"); // URL of the web application
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testSuccessfulLogin() {
        login("ahsan", "ahsan_pass", "2000-01-01");

        assertTrue(driver.getCurrentUrl().endsWith("/q1"));
    }

    @Test
    public void testFailedLogin() {
    	login("ahsanIncorrect", "ahsan_pass", "2000-01-01");

        WebElement message = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div")));
        System.out.println(driver.getCurrentUrl());
        assertTrue(driver.getCurrentUrl().endsWith("/login"));
    }

    @Test
    public void testCorrectAnswerForQ1() {
    	login("ahsan", "ahsan_pass", "2000-01-01");
        answerQuestion1("5", "3", "8");

        assertTrue(driver.getCurrentUrl().endsWith("/q2"));
    }

    @Test
    public void testIncorrectAnswerForQ1() {
    	login("ahsan", "ahsan_pass", "2000-01-01");
        answerQuestion1("5", "3", "7");

        WebElement message = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div")));
        assertEquals("Wrong answer, try again.", message.getText());
    }

    @Test
    public void testCorrectAnswerForQ2() {
    	login("ahsan", "ahsan_pass", "2000-01-01");
        answerQuestion1("5", "3", "8");
        answerQuestion2("10", "4", "6");

        assertTrue(driver.getCurrentUrl().endsWith("/q3"));
    }

    @Test
    public void testIncorrectAnswerForQ2() {
    	login("ahsan", "ahsan_pass", "2000-01-01");
        answerQuestion1("5", "3", "8");
        answerQuestion2("10", "4", "7");

        WebElement message = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div")));
        assertEquals("Wrong answer, try again.", message.getText());
    }


    private void login(String username, String password, String dob) {
        // Find and click on the link that leads to the login page
        WebElement loginLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/a")));
        loginLink.click();

        // Now wait for the login page to load and locate the form fields
        WebElement usernameField = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("username")));
        WebElement passwordField = driver.findElement(By.id("passwd"));
        WebElement dobField = driver.findElement(By.id("dob"));
        WebElement submitButton = driver.findElement(By.cssSelector("input[type='submit']"));

        // Fill in the form fields and submit the form
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        dobField.sendKeys(dob);
        submitButton.click();
    }

    private void answerQuestion1(String number1, String number2, String result) {
        WebElement number1Field = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("number1")));
        WebElement number2Field = driver.findElement(By.id("number2"));
        WebElement resultField = driver.findElement(By.id("result"));
        WebElement submitButton = driver.findElement(By.cssSelector("input[type='submit']"));

        number1Field.sendKeys(number1);
        number2Field.sendKeys(number2);
        resultField.sendKeys(result);
        submitButton.click();
    }

    private void answerQuestion2(String number1, String number2, String result) {
        WebElement number1Field = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("number1")));
        WebElement number2Field = driver.findElement(By.id("number2"));
        WebElement resultField = driver.findElement(By.id("result"));
        WebElement submitButton = driver.findElement(By.cssSelector("input[type='submit']"));

        number1Field.sendKeys(number1);
        number2Field.sendKeys(number2);
        resultField.sendKeys(result);
        submitButton.click();
    }

    private void answerQuestion3(String number1, String number2, String result) {
        WebElement number1Field = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("number1")));
        WebElement number2Field = driver.findElement(By.id("number2"));
        WebElement resultField = driver.findElement(By.id("result"));
        WebElement submitButton = driver.findElement(By.cssSelector("input[type='submit']"));

        number1Field.sendKeys(number1);
        number2Field.sendKeys(number2);
        resultField.sendKeys(result);
        submitButton.click();
    }
    
    
}
