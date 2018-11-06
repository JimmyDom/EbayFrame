import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private WebDriver driver;
    private By buttonEnter = By.cssSelector("#gh-ug > a:nth-child(1)");
    private By searchLine = By.id("gh-ac");
    private By buttonFind = By.id("gh-btn");
    private By exitUserAccount = By.cssSelector("#gh-uo > a:nth-child(1)");

    public MainPage(WebDriver driver){

        this.driver = driver;
    }

    public MainPage openMainPage(String siteAddress){
        driver.get(siteAddress);
        return new MainPage(driver);
    }

    public SignInPage signIn(){
        driver.findElement(buttonEnter).click();
        return new SignInPage(driver);
    }

    public ProductPage searchProduct(String productName){
        driver.findElement(searchLine).sendKeys(productName);
        driver.findElement(buttonFind).click();
        return new ProductPage(driver);
    }

    public OutputPage outputAccount(){
        Actions actions = new Actions(driver);
        WebElement lineHelloAccount = driver.findElement(By.id("gh-ug"));
        actions.moveToElement(lineHelloAccount).build().perform();

        (new WebDriverWait(driver, 10)).until(ExpectedConditions.
                visibilityOfElementLocated(exitUserAccount));
        driver.findElement(exitUserAccount).click();
        return new OutputPage(driver);
    }

}
