package com.selenium.test.pages;

import com.selenium.test.webtestsbase.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

/**
 * This page is a page object example.
 */
public class Page3 extends BasePage {

    @FindBy(xpath = "//*[text()='This is the end']")
    private  WebElement isPage3;

    @FindBy(xpath = "//*[text()='Yes']") //yes button
    private WebElement yesButton;

    @FindBy(xpath = "//*[text()='Odeslat']")
    private WebElement submit;

    public Page3(){
        super(true); }

//    public Page3(boolean openPageByUrl) {
//        super(openPageByUrl); }

    @Override
    protected void openPage() {
        //do nothing
    }

    @Override
    public boolean isPageOpened() {
        try {
            return isPage3.isDisplayed();
        } catch (NoSuchElementException e){
            return false;
        }
    }

    public Page3 doSubmit() { submit.click();
    return this;}

    public void clickYes(){yesButton.click();}
}
