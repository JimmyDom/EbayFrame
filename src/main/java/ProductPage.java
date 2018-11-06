import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {
    private WebDriver driver;
    private By countProduct = By.xpath("//div[@class=\"srp-ipp__control--legacy\"]//span");
    private By titleProduct = By.xpath("//a[@class=\"s-item__link\"]//h3[@class=\"s-item__title\"]");

    public By getCountProduct() {
        return countProduct;
    }

    public By getTitleProduct() {
        return titleProduct;
    }

    public ProductPage(WebDriver driver){
        this.driver = driver;
    }

}
