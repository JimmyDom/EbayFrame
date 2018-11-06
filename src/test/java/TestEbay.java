import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class TestEbay {
    private WebDriver driver;
    private MainPage mainPage;
    private SignInPage signInPage;
    private Logic logic;
    private OutputPage outputPage;

    @Before
    public void setUp(){
        DriverLoader driverLoader = new DriverLoader();
        driverLoader.DriverLoader();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--kiosk");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        mainPage = new MainPage(driver);
        signInPage = new SignInPage(driver);
        logic = new Logic(driver);
        outputPage = new OutputPage(driver);
    }

    @Test
    public void testSamsung(){
        try {
            mainPage.openMainPage("https://www.ebay.com/");
        } catch (Exception e){
            System.out.println("Fail in step open site: " + e);
        }
        try {
            mainPage.signIn();
        } catch (Exception e) {
            System.out.println("Fail in step sign in: " + e);
        }
        try {
            signInPage.enterToSystem("fernnac_54", "1234567890-=S");
        } catch (Exception e){
            System.out.println("Fail in step check number: \" + eFail in step enter to system: " + e);
        }
        try {
            mainPage.searchProduct("samsung");
        } catch (Exception e){
            System.out.println("Fail in step search product: " + e);
        }
        try {
            logic.enterCheckNumber();
        } catch (Exception e){
            System.out.println("Fail in step check number: " + e);
        }
        Assert.assertTrue(logic.getNumbersProduct() == logic.getCatalog().size());

        for(WebElement catalog : logic.getCatalog()){
            Assert.assertTrue(catalog.getText().toLowerCase().contains("samsung"));
            System.out.println(catalog.getText());
        }
        try {
            mainPage.outputAccount();
        } catch (Exception e){
            System.out.println("Fail in step output account: " + e);
        }
        Assert.assertTrue(outputPage.textOutputSite().contains("До скорой встречи"));
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
