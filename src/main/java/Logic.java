import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Logic {
    private WebDriver driver;
    private ProductPage productPage;
    private List <WebElement> catalog;
    private boolean result = false;
    private int numbersProduct = 0;

    public Logic(WebDriver driver){
        this.driver = driver;
    }
    public int getNumbersProduct(){
        return numbersProduct;
    }
    public boolean getResult(){
        return result;
    }
    public List<WebElement> getCatalog() {
        return catalog;
    }

    public void checkNumber(){
        productPage = new ProductPage(driver);
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.
                visibilityOfElementLocated(productPage.getCountProduct()));

        String numberSize  = driver.findElement(productPage.getCountProduct()).getText();
        catalog = driver.findElements(productPage.getTitleProduct());
        System.out.println("number " + numberSize);
        System.out.println("catalog " + catalog.size());
        numbersProduct = Integer.parseInt(numberSize);
    }

    public void enterCheckNumber(){
        try {
            checkNumber();
        } catch (Exception e){
            System.out.println("Error in step enter check number");
            driver.navigate().refresh();
            checkNumber();
        }
    }
}
