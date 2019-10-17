package com.selenium.test.junit.tests;

import com.selenium.test.junit.rules.ScreenShotOnFailRule;
import com.selenium.test.pages.*;
import com.selenium.test.webtestsbase.WebDriverFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.LocalDate;
import java.time.Month;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

/**
 *
 *
 *
 */
public class PageObjectTest {

    @Rule
    public ScreenShotOnFailRule screenShotOnFailRule = new ScreenShotOnFailRule();

    @Before
    public void beforeTest() {
        WebDriverFactory.startBrowser(true);
    }

    @Test
    public void testSearch() {
        LocalDate   currentDate = LocalDate.now(), /* pulls today's date and saves it in CurrentDate var */
                    futureDate = currentDate.plusDays(5); /* pulls the date 5 days from today and saves it in futureDate */

        Month   /* gets current month */
                month = currentDate.getMonth(),
                /* gets month from futureDate */
                futureMonth = futureDate.getMonth();

        String  /* converts the future day, month, year int values to string */
                fmonth = Integer.toString(futureMonth.getValue()),
                year = Integer.toString(futureDate.getYear()),
                day = Integer.toString(futureDate.getDayOfMonth()),
                /* converts the current month to string */
                monthval = month.toString(),
                /* creates a new string that appends the string values of day+month */
                ddmm = new StringBuilder().append(day).append(fmonth).toString();

        /* Opening the url as Page1 page object
        * Getting the reversed string for question 3 from page1 for later use
        * Ticking the checkboxes on page1
        * Setting the future date page1
        * If warning message for mandatory field webelement exists on page1 and isn't displayed
        *   Input current month
        *   Click "Next" button
        *   Get to Page2 page object
        *   Fill three random series from list
        *   Click red as favorite colour on page2
        *   Click "Back" button
        *   Clear answer field for question 3 on page1
        *   Fill the answer field with the reversed string on page1
        *   click Next button, click next button on the following page
        *   Get to Page3 page object
        *   choose the answer "Yes"
        *   Click Send
        *   * */

        Page1   page1 = new Page1();
        String  reversedtext=page1.getQ3TextRev() ;

        page1.clickCheckboxes();
        page1.setDate(ddmm, year);
        if (!page1.checkMandatoryField())
        {page1.inputStringMonth(monthval);

        Page2 page2=page1.doNext();
            page2.populateSeries();
            page2.favColour();
            page2.doBack();

        page1.clearInputString();
        page1.inputStringMonth(reversedtext);
        try {TimeUnit.SECONDS.sleep(3);}catch(InterruptedException e){e.printStackTrace();}

        Page3 page3=page1.doNext().doNext();
            page3.clickYes();
            page3.doSubmit();}
    }

    @After
    public void afterTest(){
         WebDriverFactory.finishBrowser();
    }
}
