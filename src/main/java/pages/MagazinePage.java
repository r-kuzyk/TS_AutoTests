package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by Roman_Kuzyk on 21-Jul-17.
 */
 public class MagazinePage extends BasePage {

    private static MagazinePage instance;
    public static MagazinePage Instance = (instance != null) ? instance : new MagazinePage();

    public MagazinePage() {
        pageURL = "/magazine/";
    }

    public PageHeader header = PageHeader.Instance;


}
