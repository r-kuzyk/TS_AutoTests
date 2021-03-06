package smoke;

import annotations.TestName;
import entities.ItemEntity;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.MattressesPage;
import pages.ShopPage;
import utils.BaseTest;
import utils.EntitiesFactory;
import utils.FileIO;

/**
 * @author Taras
 * @since 7/25/2017.
 */
public class Smoke_CountOfMattressesInCart_Test extends BaseTest {

    @Test
    @TestName(name = "Check count of mattresses in cart and the cart flag in header")
    public void countOfMattressesInCart_Test() throws Exception {

        // creating of two system entities
        ItemEntity biggerMattress = EntitiesFactory.getItem(FileIO.getDataFile("Default_Mattress.json"));
        ItemEntity smallerMattress = EntitiesFactory.getItem(FileIO.getDataFile("Updated_Mattress.json"));

        int countOfGoodsFromCartIcon;
        int countOfGoodsInCart;

        //open pages
        HomePage homePage = HomePage.Instance;
        homePage.open();;
        ShopPage shopPage = homePage.header.clickShopMenuItem();
        MattressesPage mattressesPage = shopPage.clickOnShopOurMattressButton();

        //adding two the identical "bigger" mattresses to the cart
        mattressesPage.selectMattressSize(biggerMattress.getSize()).selectMattressFeel(biggerMattress.getType()).clickAddToCart();
        mattressesPage.selectMattressSize(biggerMattress.getSize()).selectMattressFeel(biggerMattress.getType()).clickAddToCart();

        //checking if "bigger" mattresses were counted
        countOfGoodsFromCartIcon = mattressesPage.header.getCountOfGoodsFromCartIcon();
        countOfGoodsInCart = mattressesPage.header.getCountOfGoodsInCart();
        Assert.assertTrue(countOfGoodsInCart == countOfGoodsFromCartIcon, "First time. Count of added to cart items equal to count from cart icon");

        //adding another item (model of smaller mattresses) to the cart
        mattressesPage.open();
        mattressesPage.selectMattressSize(smallerMattress.getSize()).selectMattressFeel(smallerMattress.getType()).clickAddToCart();
        mattressesPage.selectMattressSize(smallerMattress.getSize()).selectMattressFeel(smallerMattress.getType()).clickAddToCart();
        mattressesPage.selectMattressSize(smallerMattress.getSize()).selectMattressFeel(smallerMattress.getType()).clickAddToCart();

        countOfGoodsFromCartIcon = mattressesPage.header.getCountOfGoodsFromCartIcon();
        countOfGoodsInCart = mattressesPage.header.getCountOfGoodsInCart();

        //checking if all mattress were added and counted
        Assert.assertTrue(countOfGoodsInCart == countOfGoodsFromCartIcon, "Second time. Count of added to cart items equal to count from cart icon");
    }

}
