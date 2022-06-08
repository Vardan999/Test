package com.company.swaglabs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import static com.company.swaglabs.utils.CustomWebElement.click;
import static com.company.swaglabs.utils.CustomWebElement.isDisplayed;

public class HomePageClass extends BasePage {
    private WebDriver driver;
    @FindBy(css = "img[class='inventory_item_img']")
    private List<WebElement> imageItems;
    @FindBy(className = "inventory_item_name")
    private List<WebElement> itemsNames;
    @FindBy(className = "product_sort_container")
    private WebElement filtrButton;
    @FindBy(css = "[value='za']")
    private WebElement zToa;
    @FindBy(css = "[value='az']")
    private WebElement aToz;
    @FindBy(className = "inventory_item_price")
    private List<WebElement> itemsPrices;
    @FindBy(css = "[value='lohi']")
    private WebElement lowToHigh;
    @FindBy(css = "[value='hilo']")
    private WebElement highToLow;
    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement addToCart;
    @FindBy(className = "inventory_item_desc")
    private List<WebElement> itemsDescriptions;
    @FindBy(id = ("remove-sauce-labs-backpack"))
    private WebElement remove;
    private BasePage basePage;


    public HomePageClass(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
        basePage = new BasePage(this.driver);
    }

    public void allItemsVisibilityOf() {
        isDisplayed(basePage.getHeader().getAllItems());
    }


    public boolean isImageItemDisplayed(int index) {
        return isDisplayed(imageItems.get(index));
    }

    public int imageItemsCount() {
        return imageItems.size();
    }

    public int itemNamesSize() {
        return itemsNames.size();
    }

    public boolean itemNamesIsDisplayed(int index) {
        return isDisplayed(itemsNames.get(index));
    }

    public String itemNamesText(int index) {
        return itemsNames.get(index).getText();
    }

    public WebElement getFiltrButton() {
        return filtrButton;
    }

    public void clickToZtoA() {
        click(zToa);
    }

    public void clickToAtoZ() {
        click(aToz);
    }

    public int itemPricesSize() {
        return itemsPrices.size();
    }

    public String itemsPricesText(int index) {
        return itemsPrices.get(index).getText();
    }

    public void clickToLowToHigh() {
        click(lowToHigh);
    }

    public void clickToHighToLow() {
        click(highToLow);
    }

    public void clickToAddToCart() {
        click(addToCart);
    }

    public String itemsDescriptionsText(int index) {
        return itemsDescriptions.get(index).getText();
    }

    public void addToCardVisibility() {
        isDisplayed(addToCart);
    }

    public void RemoveVisibilityOf() {
        isDisplayed(remove);
    }

    public void clickToRemove() {
        click(remove);
    }

    public boolean compareImageItems() {
        Random random = new Random();
        int size = imageItems.size();
        int randomIndex1 = random.nextInt(size);
        int randomIndex2 = random.nextInt(size);

        Screenshot screenshot1 = new AShot().coordsProvider(new WebDriverCoordsProvider()).takeScreenshot(driver, imageItems.get(randomIndex1));
        Screenshot screenshot2 = new AShot().coordsProvider(new WebDriverCoordsProvider()).takeScreenshot(driver, imageItems.get(randomIndex2));

        BufferedImage randomImageItem1 = screenshot1.getImage();
        BufferedImage randomImageItem2 = screenshot2.getImage();

        ImageDiffer imgDiff = new ImageDiffer();
        isDisplayed(imageItems.get(randomIndex1));
        isDisplayed(imageItems.get(randomIndex2));
        ImageDiff diff = imgDiff.makeDiff(randomImageItem1, randomImageItem2).withDiffSizeTrigger(20);
        BufferedImage diffImage = diff.getDiffImage();
        try {
            ImageIO.write(diffImage, "PNG", new File("C:\\Users\\user\\Pictures\\diff.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return diff.hasDiff();

    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        super.isLoaded();
    }

//    public static void main(String[] args) throws IOException {
//
//        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
//        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get("http://demo.guru99.com/test/guru99home/");
//
//        // Find the element and take a screenshot
//
//        WebElement logoElement = driver.findElement(By.xpath("//*[@id=\"site-name\"]/a[1]/img"));
//        Screenshot logoElementScreenshot = new AShot().takeScreenshot(driver, logoElement);
//
//        // read the image to compare
//
//        BufferedImage expectedImage = ImageIO.read(new File("C:\\Users\\user\\Pictures\\Guru99logo.png"));
//
//        BufferedImage actualImage = logoElementScreenshot.getImage();
//        ImageIO.write(actualImage, "png", new File("C:\\Users\\user\\Pictures\\Guru99logo_actual.png"));
//
//        // Create ImageDiffer object and call method makeDiff()
//
//        ImageDiffer imgDiff = new ImageDiffer();
//        ImageDiff diff = imgDiff.makeDiff(actualImage, expectedImage);
//
//        if (diff.hasDiff()) {
//            System.out.println("Images are different");
//        } else {
//            System.out.println("Images are same");
//        }
//        driver.quit();
//    }
}

