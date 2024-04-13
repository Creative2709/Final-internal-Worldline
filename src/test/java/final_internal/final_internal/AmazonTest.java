package final_internal.final_internal;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import junit.framework.Assert;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

public class AmazonTest {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // Set the path to the ChromeDriver executable
   	 System.setProperty("webdriver.chrome.driver", "D:\\WORLDLINE\\Testing\\chromedriver_win32\\chromedriver.exe");

        // Create a new instance of the ChromeDriver
        driver = new ChromeDriver();

        // Maximize the browser window
        driver.manage().window().maximize();

        // Set implicit wait time
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testECommerceActivities() throws InterruptedException {
//        performActivity("open_browser");
//        performActivity("register_and_signup");
        performActivity("login");
//        performActivity("add_to_cart");
        performActivity("checkout");
        performActivity("logout");
    }

    @AfterMethod
    public void tearDown() {
        // Close the browser
        //driver.quit();
    }

    // Method to execute keywords
    @SuppressWarnings("deprecation")
	private void performActivity(String keyword) throws InterruptedException {
   	 

        switch (keyword) {
            case "open_browser":
                driver.get("https://www.amazon.in/ap/register?_encoding=UTF8&openid.assoc_handle=inflex&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&openid.ns.pape=http%3A%2F%2Fspecs.openid.net%2Fextensions%2Fpape%2F1.0&openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2Fgp%2Fyourstore%2Fhome%3Fie%3DUTF8%26ref_%3Dnav_newcust");               
                break;
            case "register_and_signup":
                // Implement registration and signup logic
            	driver.findElement(By.id("ap_customer_name")).sendKeys("Swapnil Jadhav");
            	driver.findElement(By.id("ap_phone_number")).sendKeys("9112699066");
            	driver.findElement(By.id("ap_password")).sendKeys("Swap@123");
            	Thread.sleep(4000);
            	driver.findElement(By.id("continue")).click();
            	
                break;
            case "login":
                // Implement login logic
            	driver.get("https://www.amazon.in/ap/signin/ref=ap_register_mobile_claim_conflict_warned_back_to_signin?openid.pape.max_auth_age=900&openid.return_to=https%3A%2F%2Fwww.amazon.in%2Fgp%2Fyourstore%2Fhome%3Fie%3DUTF8%26ref_%3Dnav_newcust&prevRID=QQTADGD1J6BR1PHKMNC2&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.ns.pape=http%3A%2F%2Fspecs.openid.net%2Fextensions%2Fpape%2F1.0&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&pageId=inflex&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
            	driver.findElement(By.name("email")).sendKeys("jadhavswapnil2709@gmail.com");
            	driver.findElement(By.id("continue")).click();
            	
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            	    // Enter password and click "Sign In"
            	driver.findElement(By.name("password")).sendKeys("Sw@pn!l_2709");
            	    driver.findElement(By.id("signInSubmit")).click();       	    
            	Thread.sleep(10000);
            	
            	break;
            case "add_to_cart":
                // Implement adding product to cart logic
            	driver.get("https://www.amazon.in/ref=nav_logo");
            	driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys("keyboard");
            	driver.findElement(By.id("nav-search-submit-button")).click();
            	
            	driver.findElement(By.xpath("//*[@id='search']/div[1]/div[1]/div/span[1]/div[1]/div[3]/div/div/div/div/span/div/div/div/div[2]/div/div/div[1]/h2/a/span")).click();
            	
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                String currentWindowHandle = driver.getWindowHandle();
                for (String windowHandle : driver.getWindowHandles()) {
                    if (!windowHandle.equals(currentWindowHandle)) {
                        driver.switchTo().window(windowHandle);
                        break;
                    }
                }
                driver.findElement(By.id("add-to-cart-button")).click();
                driver.findElement(By.id("attach-close_sideSheet-link")).click();
            	break;
            case "checkout":
            	driver.findElement(By.xpath("//*[@id=\"nav-cart-text-container\"]/span[2]")).click();
            	driver.findElement(By.name("proceedToRetailCheckout")).click();
            	driver.findElement(By.xpath("//*[@id=\"orderSummaryPrimaryActionBtn\"]/span/input")).click();
            	
            	break;
            case "logout":
            	driver.findElement(By.xpath("//*[@id=\"footer\"]/div[3]/a[2]")).click();
            	WebElement logout = driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]/span/span"));
            	Actions actions = new Actions(driver);
            	actions.moveToElement(logout).perform();
            	
            	driver.findElement(By.xpath("//*[@id=\"nav-item-signout\"]/span")).click();
            	
            	
            	break;
            default:
                System.out.println("Unknown keyword: " + keyword);
        }
    }
}

