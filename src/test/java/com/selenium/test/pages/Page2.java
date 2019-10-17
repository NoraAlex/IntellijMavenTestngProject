package com.selenium.test.pages;

import com.selenium.test.webtestsbase.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

/**
 * This page is a page object example.
 */
public class Page2 extends BasePage {

    @FindBy(xpath = "//TEXTAREA")   //input text field
    private WebElement inputStringElement;

    @FindBy(xpath = "//*[text()='More awesome questions']")
    private  WebElement isPage2;

    @FindBy(xpath = "//*[text()='Další']") //next button
    private WebElement nextButtonElement;

    @FindBy(xpath = "//*[text()='Red']") //next button
    private WebElement redButton;

    @FindBy(xpath = "//*[text()='Zpět']") //back button
    private WebElement backButtonElement;

    public Page2(){
        super(true);
    }

    @Override
    protected void openPage() {
        //do nothing
    }

    @Override
    public boolean isPageOpened() {
        try {
            return isPage2.isDisplayed();
        } catch (NoSuchElementException e){
            return false;
        }
    }

    public Page2 doBack() { backButtonElement.click();
        return this;}

    public Page3 doNext() { nextButtonElement.click();
        return new Page3();}

    public void populateSeries() {
        List<String> Series = Arrays.asList("The Expanse", "Westworld", "American Gods", "IT Crowd", "Attack on Titan", "Altered Carbon");
        Random rand = new Random();
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 3; i++) {
            int randomIndex = rand.nextInt(Series.size());
            String randomElement = Series.get(randomIndex);
            inputStringElement.sendKeys(randomElement);
            if (i<2) {robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);} }

    }

    public void favColour() {
        redButton.click();
    }
}
