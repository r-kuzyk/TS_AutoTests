package viewcart;

import annotations.TestName;
import entities.ItemEntity;
import entities.UserEntity;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.BaseTest;
import utils.EntitiesFactory;
import utils.FileIO;

public class ViewCart_UpdateSheetsTest extends BaseTest {

    @Test
    @TestName(name="Sheets Update test")
    public void viewCart_UpdatedSheetsTest() throws Exception {

        //init test entities
        ItemEntity item = EntitiesFactory.getItem( FileIO.getDataFile("Default_Sheets.json") );
        ItemEntity updateditem = EntitiesFactory.getItem( FileIO.getDataFile("Updated_Sheets.json") );

        //init pages
        HomePage home = HomePage.Instance;
        SheetsetPage prodPage = SheetsetPage.Instance;
        ViewCartPage cartPage = ViewCartPage.Instance;

        //open home page and add Sheets to cart
        home.open();
        home.header.clickShopMenuItem()
                .clickOnShopOurSheetsButton()
                .selectSheetsetSize(item.getSize())
                .clickAddToCart();

        home.header.clickOnViewCartButton().clickOnEditProduct(item.getTitle());

        prodPage
                .selectSheetsetSize(updateditem.getSize())
                .clickUpdateCart();

        Assert.assertTrue(cartPage.itemDisplayedOnViewCartPage(updateditem), "Updated item was not displayed");

    }
}
