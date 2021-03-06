package pages;

import framework.PageFactory;
import framework.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class ProgramsPage extends PageFactory {
    private final By listofPatient = By.xpath("//*[contains(@class,'patient-name')]");
    private final By homeButton = By.className("back-btn");
//    private final By newProgramEnrollment = By.xpath("//*[contains(@class,'section-title')]");
    private final By newProgramEnrollment = By.partialLinkText("New Program Enrollment");
    private final By formField = By.xpath("//*[contains(@class,'ng-pristine')]");
    private final By dateField = By.xpath("//*[contains(@type,'date')]");
    private final By enroll = By.xpath("//*[contains(@type,'submit')]");
    private final By HIVprogramDashboardButton = By.id("dashboard-link");


    public void clickOnLastPatient() {
        Wait.explicitWait(ExpectedConditions.presenceOfElementLocated(listofPatient));
        List<WebElement> list = driver.findElements(listofPatient);
//        list.get(list.size()-1).click();
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", list.get(list.size() - 1));
    }


    public void clickNewProgramEnrollment() {
        Wait.explicitWait(ExpectedConditions.elementToBeClickable(newProgramEnrollment));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(newProgramEnrollment));
    }


    public void fillNewEnrollmentForm() {
        Wait.explicitWait(ExpectedConditions.presenceOfElementLocated(formField));
        driver.findElements(formField).get(1).sendKeys("HIV Program");

        String strDateDOB = "12/09/2020";
        WebElement select = driver.findElement(dateField);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].type = arguments[1]", select, "text");
        js.executeScript("arguments[0].value = arguments[1]", select, strDateDOB);

        driver.findElements(formField).get(2).sendKeys(String.valueOf(1 + new Random().nextInt(10)));
    }

    public void clickOnEnroll() {
        Wait.explicitWait(ExpectedConditions.presenceOfElementLocated(enroll));
        driver.findElement(enroll).click();
    }

    public void clickOnProgramDashboardButton() {
        Wait.explicitWait(ExpectedConditions.presenceOfElementLocated(HIVprogramDashboardButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(HIVprogramDashboardButton));
    }

    public void goToHomePage() {
        Wait.explicitWait(ExpectedConditions.presenceOfElementLocated(homeButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(homeButton));

    }
}
