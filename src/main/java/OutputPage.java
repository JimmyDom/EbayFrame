import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OutputPage {
    private WebDriver driver;
    private By textOutput = By.xpath("//span[@class=\"ds3pHTxt\"]");

    public OutputPage(WebDriver driver){
        this.driver = driver;
    }

    public String textOutputSite(){
        return driver.findElement(textOutput).getText();
    }

}
