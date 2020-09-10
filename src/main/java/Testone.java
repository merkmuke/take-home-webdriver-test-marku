import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Testone {

    public static void main(String args[]) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost:7080/login");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.className("radius")).submit();
        driver.close();

        //test2
        // Wrong pwd & username
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost:7080/login");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("username")).sendKeys("tomsmith1");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword");
        driver.findElement(By.className("radius")).submit();
        driver.close();

        //Test3
        //Checked element is present in this div
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost:7080/checkboxes");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement IChecked = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]"));
        IChecked.click();
        //Unchecked element
        WebElement IUnchecked = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]"));
        IUnchecked.click();
        //Conditions
        if (IUnchecked.isSelected()) {
            System.out.println("Checkbox is Toggled On");
        } else {
            System.out.println("Checkbox is Toggled Off");
        }
        if (IChecked.isSelected()) {
            System.out.println("Checkbox ix Toggled On");
        } else {
            System.out.println("Checkbox is Toggled Off");
        }
        driver.close();

        //Test4 Drag and Drop
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost:7080/drag_and_drop ");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement From = driver.findElement(By.xpath("//*[@id=\"column-a\"]"));

        //Using Action class for drag and drop.
        Actions act = new Actions(driver);

        //Drag and Drop by Pixel.
        act.dragAndDropBy(From, 135, 40).build().perform();
        driver.close();

        //Test5 Dropdown
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost:7080/dropdown");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Select drpOption = new Select(driver.findElement(By.xpath("//*[@id=\"dropdown\"]")));
        drpOption.selectByVisibleText("Option 1");
        driver.close();

        //Test6 Dynamic content
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost:7080/dynamic_content");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);

        //get the list of all the links and images

        List<WebElement> linksList = driver.findElements(By.xpath("//*[@id=\"content\"]/div[3]/div[1]/img"));

        //linksList.addAll(driver.findElements(By.xpath("//*[@id=\"content\"]/div[3]/div[1]/img"));

        System.out.println("size of full links and images-->" + linksList.size());

        List<WebElement> activeLinks = new ArrayList<WebElement>();

        //iterate linksList : exclude all the links or images which don’t have an href attribute

        for (int i = 0; i < linksList.size(); i++) {

            System.out.println(linksList.get(i).getAttribute("large-2 columns"));

            if (linksList.get(i).getAttribute("large-2 columns") != null &&
                    (!linksList.get(i).getAttribute("large-2 columns").contains("large-10 columns"))) {

                activeLinks.add(linksList.get(i));
                driver.close();

                //Test 7 Dynamic Controls
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                driver.get("http://localhost:7080/dynamic_controls");
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                driver.findElement(By.xpath(("//*[@id=\"checkbox\"]")));

            }
        }
    }
}







