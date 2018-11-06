import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage {
    private WebDriver driver;
    private By userId = By.id("userid");
    private By pass = By.id("pass");
    private By loginToSystem = By.id("sgnBt");

    public SignInPage(WebDriver driver){
        this.driver = driver;
    }

    public MainPage enterToSystem(String login, String password){
        driver.findElement(userId).sendKeys(login);
        driver.findElement(pass).sendKeys(password);
        driver.findElement(loginToSystem).click();
        return new MainPage(driver);
    }

}
