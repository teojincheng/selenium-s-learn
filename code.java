package newpackage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class MyClass {
	
	
	public static boolean canAddItemToCart(WebDriver webDriver,WebDriverWait webDriverWait){
		// declaration and instantiation of objects/variables
    	//System.setProperty("webdriver.gecko.driver","/Users/User/Downloads/geckodriver-v0.24.0-win64/geckodriver.exe");
		//WebDriver driver = new FirefoxDriver();
		//WebDriverWait wait=new WebDriverWait(driver, 20);
		//comment the above 2 lines and uncomment below 2 lines to use Chrome
		//System.setProperty("webdriver.chrome.driver","G:\\chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
    	
        String baseUrl = "http://mtoys-167102.appspot.com/"; 
        String cartNum = "";

        // launch Fire fox and direct it to the Base URL
        webDriver.get(baseUrl);

        webDriver.findElement(By.linkText("Login")).click();
        webDriver.findElement(By.cssSelector("input[type='submit']")).click();
       WebElement toyElement = webDriver.findElement(By.xpath("//a[@href='itemDetail.php?id=19']"));
       JavascriptExecutor jsExecutor = (JavascriptExecutor) webDriver;  
       jsExecutor.executeScript("arguments[0].click();", toyElement);
       
       WebElement addCartElement;
       addCartElement = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/div[1]/div[2]/form/input[4]")));
       addCartElement.click();
       //jsExecutor.executeScript("arguments[0].click();", addElement);
        WebElement cartElement = webDriver.findElement(By.id("cartNum"));
      
        cartNum = cartElement.getText();
        
        //close Fire fox
        webDriver.close();
        
        if(cartNum.contentEquals("1")){
        	return true;
        }
        return false;
       
	}
	
	public static boolean itemCanBeDeleted(){
		return false;
	}

	 public static void main(String[] args) {
		 System.setProperty("webdriver.gecko.driver","/Users/User/Downloads/geckodriver-v0.24.0-win64/geckodriver.exe");
		 WebDriver driver = new FirefoxDriver();
			WebDriverWait wait=new WebDriverWait(driver, 20);
		 
		boolean itemIsAddedToCart = canAddItemToCart(driver,wait);
		
		if(itemIsAddedToCart){
			System.out.println("Item can be added to cart");
		}
		 /*
	        // declaration and instantiation of objects/variables
	    	System.setProperty("webdriver.gecko.driver","/Users/User/Downloads/geckodriver-v0.24.0-win64/geckodriver.exe");
			WebDriver driver = new FirefoxDriver();
			WebDriverWait wait=new WebDriverWait(driver, 20);
			//comment the above 2 lines and uncomment below 2 lines to use Chrome
			//System.setProperty("webdriver.chrome.driver","G:\\chromedriver.exe");
			//WebDriver driver = new ChromeDriver();
	    	
	        String baseUrl = "http://mtoys-167102.appspot.com/"; 
	        String cartNum = "";

	        // launch Fire fox and direct it to the Base URL
	        driver.get(baseUrl);

	        driver.findElement(By.linkText("Login")).click();
	        driver.findElement(By.cssSelector("input[type='submit']")).click();
	       WebElement toyElement = driver.findElement(By.xpath("//a[@href='itemDetail.php?id=19']"));
	       JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;  
	       jsExecutor.executeScript("arguments[0].click();", toyElement);
	       
	       WebElement addCartElement;
	       addCartElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/div[1]/div[2]/form/input[4]")));
	       addCartElement.click();
	       //jsExecutor.executeScript("arguments[0].click();", addElement);
	        WebElement cartElement = driver.findElement(By.id("cartNum"));
	      
            cartNum = cartElement.getText();
	        
	        if(cartNum.contentEquals("1")){
	        	System.out.println("Test passed");
	        }else{
	        	System.out.println("test failed");
	        }
	        //close Fire fox
	        driver.close();
	       */
	    }
}
