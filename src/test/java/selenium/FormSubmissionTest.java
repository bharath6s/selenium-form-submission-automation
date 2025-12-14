package selenium;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FormSubmissionTest {
	
	public static void main(String[] args) {
		//Web driver Initialization
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://practice-automation.com/form-fields/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		// Text fields
        WebElement name = driver.findElement(By.id("name-input"));
        name.sendKeys("Lalith");
        WebElement pass = driver.findElement(By.xpath("//input[@type='password']"));
        pass.sendKeys("lalith@123");
        
       //checkbox
        driver.findElement(By.xpath("//label[text()='Water']")).click();
        driver.findElement(By.xpath("//label[text()='Milk']")).click();
        driver.findElement(By.xpath("//label[text()='Coffee']")).click();

        // Radio button
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement blueRadio = wait1.until(
                ExpectedConditions.presenceOfElementLocated(By.id("color2"))
        );

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({block:'center'});", blueRadio);

        wait1.until(ExpectedConditions.elementToBeClickable(blueRadio));
        blueRadio.click();


        //dropdown
        WebElement dropdown = driver.findElement(By.id("automation"));
        Select select = new Select(dropdown);
        select.selectByVisibleText("Yes");

        // Submit
       WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement submit = wait2.until(ExpectedConditions.presenceOfElementLocated(By.id("submit-btn")));
        
        JavascriptExecutor js2 = (JavascriptExecutor) driver;
        js2.executeScript("arguments[0].click();", submit);
        
        //alert
        Alert alert = driver.switchTo().alert();
        String alerttext = alert.getText();
        System.out.println("Alert message: " + alerttext);
        alert.accept();
        
   //     driver.quit();
		
	}

}
