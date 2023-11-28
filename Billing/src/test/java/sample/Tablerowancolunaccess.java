package sample;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tablerowancolunaccess {
    public static void main(String[] args) {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");

        // Initialize the WebDriver
        WebDriver driver = new ChromeDriver();

        // Navigate to the web page containing the table
        driver.get("your_website_url_here");

        // Find the table element by its role attribute
        WebElement tableElement = driver.findElement(By.cssSelector("table[role='grid']"));

        // Find the third row (index 2) in the table
        WebElement row = tableElement.findElements(By.tagName("tr")).get(2); // Index 2 for the third row

        // Find the third column (index 2) within the row
        WebElement cell = row.findElements(By.tagName("td")).get(2); // Index 2 for the third column

        // Get the text content of the cell
        String cellText = cell.getText();
        System.out.println("Content of the third row and third column: " + cellText);

        // Close the WebDriver
        driver.quit();
    }
}
