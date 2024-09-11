// src/main/java/page/KkrPage.java
package page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Kkrpageclass {

    private WebDriver driver;

    // Locators
    private By nameField = By.xpath("//*[@name=\"name\"]");
    private By phoneField = By.xpath("//*[@name=\"mobile\"]");
    private By emailField = By.xpath("//*[@name=\"email\"]");
    private By maleGender = By.xpath("//*[@id=\"male\"]");
    private By femaleGender = By.xpath("//*[@id=\"female\"]");
    private By placeField = By.xpath("//*[@id=\"myform\"]/div/div[3]/div[2]/input");
    private By dateField = By.xpath("//*[@id=\"date\"]");
    private By timeField = By.xpath("//*[@id=\"selectTime\"]");
    private By ageField = By.xpath("//*[@id=\"age\"]");
    private By oldPatientType = By.xpath("//*[@id=\"patientOld\"]");
    private By newPatientType = By.xpath("//*[@id=\"patientNew\"]");
    private By mernNoField = By.xpath("//*[@id=\"mrn\"]/input");
    private By submitButton = By.xpath("//*[@id=\"myform\"]/div/div[8]/input");
    private By successMessage = By.xpath("//div[@id='successMessage']");
    private By errorMessage = By.xpath("//div[@id='errorMessage']");

    public Kkrpageclass(WebDriver driver) {
        this.driver = driver;
    }

    public void enterName(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    public void clearName() {
        driver.findElement(nameField).clear();
    }

    public void enterPhone(String phone) {
        driver.findElement(phoneField).sendKeys(phone);
    }

    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void selectGender(String gender) {
        if ("male".equalsIgnoreCase(gender)) {
            driver.findElement(maleGender).click();
        } else if ("female".equalsIgnoreCase(gender)) {
            driver.findElement(femaleGender).click();
        }
    }

    public void enterPlace(String place) {
        driver.findElement(placeField).sendKeys(place);
    }

    public void selectDate(String date) throws InterruptedException {
        driver.findElement(dateField).click();
        Thread.sleep(2000); // Wait for the date picker to open
        driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']//a[text()='" + date + "']")).click();
    }

    public void selectTime(String time) {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement timeElement = wait.until(ExpectedConditions.visibilityOfElementLocated(timeField));
        
        Select specialityele = new Select(timeElement);
        
        
        specialityele.selectByVisibleText(time);
    }

    public void enterAge(String age) {
        driver.findElement(ageField).sendKeys(age);
         
    }

    public void selectPatientType(String type) {
        if ("old".equalsIgnoreCase(type)) {
            driver.findElement(oldPatientType).click();
        } else if ("new".equalsIgnoreCase(type)) {
            driver.findElement(newPatientType).click();
        }
    }

    public void clickSubmit() {
        driver.findElement(submitButton).click();
    }

    public String getSuccessMessage() {
        return driver.findElement(successMessage).getText();
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }

    public boolean isMernNoDisplayed() {
        return driver.findElement(mernNoField).isDisplayed();
    }
}
