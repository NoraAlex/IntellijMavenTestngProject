package com.selenium.test.pages;

import com.selenium.test.webtestsbase.BasePage;
import com.selenium.test.webtestsbase.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

/**
 * This page is a page object example.
 */
public class Page1 extends BasePage {

    private static final String PAGE_URL = "https://docs.google.com/forms/d/e/1FAIpQLScNx9xK2LM-G3Z3fJXOQapiSK1IAoNXc_67MyS-soTfhDXotA/viewform";

    @FindBy(xpath = "//*[text()='Další']") //next button
    private WebElement nextButtonElement;

    @FindBy(xpath = "//*[@type='text']")   //input text field
    private WebElement inputStringMonth;

    @FindBys(@FindBy(xpath = "//*[text()='Check this']"))  //list of checkboxes to tick
    private List<WebElement> CheckThis;

    @FindBy(xpath = "//*[@type='date']")  //date field
    private WebElement inputStringdate;

    @FindBy(xpath = "//*[@id=\"mG61Hd\"]/div/div[2]/div[2]/div[3]/div/div[1]/div/div/div")  //element with text to reverse
    private  WebElement forRev;

    @FindBy(xpath = "//*[@id='i.err.1806505028']")  //mandatory question error field
    private WebElement error;

    public Page1() {
        super(true);
    }

    @Override
    protected void openPage() {
        getDriver().get(PAGE_URL);
    }

    @Override
    public boolean isPageOpened() {
        return inputStringMonth.isDisplayed();
    }

    public Page2 doNext() { nextButtonElement.click();
        return new Page2();}

    public boolean checkMandatoryField() {
        return  error.isDisplayed(); }

    //Clicks the checkboxes with Check this
    public void clickCheckboxes() {for (int i=0; i<CheckThis.size(); i++) {CheckThis.get(i).click();}}

    public void setDate(String ddmm, String yyyy) {
        Robot robot = null;
        try {robot = new Robot();} catch (AWTException e) {e.printStackTrace();}
        inputStringdate.sendKeys(ddmm);
        robot.keyPress(KeyEvent.VK_RIGHT);
        robot.keyRelease(KeyEvent.VK_RIGHT);
        inputStringdate.sendKeys(yyyy); }

    public void inputStringMonth(String text) {
        inputStringMonth.sendKeys(text); }

    public String getQ3TextRev(){
        String forRevP1 = forRev.getText();
        StringBuilder forreverse = new StringBuilder();
        forreverse.append(forRevP1);
        StringBuilder reversesb = forreverse.reverse();
        return reversesb.toString();}

    public void clearInputString(){
        inputStringMonth.clear(); }

    public String getinputStringText(){
        return inputStringMonth.getAttribute("value"); }
}
