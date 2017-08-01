import annotations.TestName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;
import pages.MagazinePage;
import utils.BaseTest;

import java.util.*;

/**
 * Created by Roman_Kuzyk on 21-Jul-17.
 */
public class NeeTest extends BaseTest {

    @Test
    @TestName(name = "First One")
    public void MagazineMenu() throws Exception {


        HomePage home = HomePage.Instance;
        MagazinePage magazine = MagazinePage.Instance;

        home.open();

        magazine.header.clickMagazineItem();

        List<WebElement> linkElements = MagazinePage.findElements(By.tagName("a"));

        String[] linkTexts;
        linkTexts = new String[linkElements.size()];
        int i = 0;

        //extract the link texts of each link element
        for (WebElement e : linkElements) {
            linkTexts[i] = e.getText();
            i++;
        }

        //test each link
        for (String t : linkTexts) {

            MagazinePage.findElement(By.linkText(t));

            boolean test;
            test = magazine.isPageLoaded();
            Assert.assertTrue(test);

        }

    }
}