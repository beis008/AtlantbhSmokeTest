import static org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.Keys;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

class Testing {
	private static WebDriver driver;
	private static String baseUrl;
	JavascriptExecutor js = (JavascriptExecutor) driver;

	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\BEIZ-PC\\Desktop\\chrome driver\\chromedriver.exe");
		driver = new ChromeDriver();
		baseUrl = "https://shop.demoqa.com/";
		driver.manage().window().maximize();
	}

	@AfterEach
	void tearDown() throws Exception {
		driver.close();
	}

	@Test
	void openHomePage() throws InterruptedException {
		driver.get(baseUrl);
		Thread.sleep(1000);
		String currentUrl = driver.getCurrentUrl();
		assertEquals(currentUrl, baseUrl);
	}
	@Test
	void registerAccount() throws InterruptedException {
		driver.get(baseUrl);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400)","");
		WebElement myAccount = driver.findElement(By.xpath("//*[@id=\"noo-site\"]/header/div[1]/div/ul[2]/li[2]/a"));
		myAccount.click();
		js.executeScript("window.scrollBy(0,400)","");
		WebElement usernameField = driver.findElement(By.xpath("//*[@id=\"reg_username\"]"));
		usernameField.sendKeys("BeizTester");
		WebElement emailField = driver.findElement(By.xpath("//*[@id=\"reg_email\"]"));
		emailField.sendKeys("beiztesting@gmail.com");
		WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"reg_password\"]"));
		passwordField.sendKeys("Password123!");
		WebElement showPass = driver.findElement(By.xpath("//*[@id=\"customer_login\"]/div[2]/form/p[3]/span/span"));
		showPass.click();
		WebElement registerButton = driver.findElement(By.xpath("//*[@id=\"customer_login\"]/div[2]/form/p[4]/button"));
		registerButton.click();
		Thread.sleep(3000);
		String expectedUrl = "https://shop.demoqa.com/my-account/";
		String currentUrl = driver.getCurrentUrl();
		assertEquals(currentUrl, expectedUrl);
	}
	
	@Test
	void LogOut() throws InterruptedException {
		driver.get(baseUrl);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400)","");
		WebElement myAccount = driver.findElement(By.xpath("//*[@id=\"noo-site\"]/header/div[1]/div/ul[2]/li[2]/a"));
		myAccount.click();
		js.executeScript("window.scrollBy(0,400)","");
		WebElement usernameField = driver.findElement(By.xpath("//*[@id=\"username\"]"));
		usernameField.sendKeys("BeizTester");
		WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"password\"]"));
		passwordField.sendKeys("Password123!");
		WebElement showPass = driver.findElement(By.xpath("//*[@id=\"customer_login\"]/div[2]/form/p[3]/span/span"));
		showPass.click();
		WebElement rememberMe = driver.findElement(By.xpath("//*[@id=\"rememberme\"]"));
		rememberMe.click();
		WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"customer_login\"]/div[1]/form/p[3]/button"));
		loginButton.click();
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,200)","");
		WebElement logOut = driver.findElement(By.xpath("//*[@id=\"post-8\"]/div/div/div/p[1]/a"));
		logOut.click();
		Thread.sleep(3000);
		WebElement button = driver.findElement(By.xpath("//*[@id=\"customer_login\"]/div[1]/form/p[3]/button"));
		String ExpectedText = "Log in";
		String CurrentText = button.getText();
		assertEquals(CurrentText, ExpectedText);
	}
	
	@Test
	void Login() throws InterruptedException {
		driver.get(baseUrl);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400)","");
		WebElement myAccount = driver.findElement(By.xpath("//*[@id=\"noo-site\"]/header/div[1]/div/ul[2]/li[2]/a"));
		myAccount.click();
		js.executeScript("window.scrollBy(0,400)","");
		WebElement usernameField = driver.findElement(By.xpath("//*[@id=\"username\"]"));
		usernameField.sendKeys("BeizTester");
		WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"password\"]"));
		passwordField.sendKeys("Password123!");
		WebElement showPass = driver.findElement(By.xpath("//*[@id=\"customer_login\"]/div[2]/form/p[3]/span/span"));
		showPass.click();
		WebElement rememberMe = driver.findElement(By.xpath("//*[@id=\"rememberme\"]"));
		rememberMe.click();
		WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"customer_login\"]/div[1]/form/p[3]/button"));
		loginButton.click();
		Thread.sleep(3000);
		WebElement dashboard = driver.findElement(By.xpath("//*[@id=\"post-8\"]/div/div/nav/ul/li[1]/a"));
		String expectedText = "Dashboard";
		String currentText = dashboard.getText();
		assertEquals(currentText, expectedText);
		
	}
	
	  @Test
		void goHome() throws InterruptedException {
			driver.get("https://shop.demoqa.com/my-account/");
			Thread.sleep(1000);
			WebElement Logo = driver.findElement(By.xpath("//*[@id=\"noo-site\"]/header/div[2]/div/div/div/div/a/img"));
			Logo.click();
			String currentUrl = driver.getCurrentUrl();
			assertEquals(currentUrl, baseUrl);
		}
	  @Test
		void womenTrends() throws InterruptedException {
			driver.get(baseUrl);
			Thread.sleep(1000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,1300)","");
			WebElement trendsButton = driver.findElement(By.xpath("//*[@id=\"noo-site\"]/div[2]/div[3]/div/div[1]/div/div/div/div/a/span"));
			trendsButton.click();
			String currentUrl = driver.getCurrentUrl();
			String expectedUrl = "https://shop.demoqa.com/womens-trends/";
			assertEquals(currentUrl, expectedUrl);
		}
	  
	  @Test
		void menTrends() throws InterruptedException {
			driver.get(baseUrl);
			Thread.sleep(1000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,2000)","");
			WebElement trendsButton = driver.findElement(By.xpath("//*[@id=\"noo-site\"]/div[2]/div[4]/div/div[2]/div/div/div/div/a/span"));
			trendsButton.click();
			String currentUrl = driver.getCurrentUrl();
			String expectedUrl = "https://shop.demoqa.com/real-mens-fashion/";
			assertEquals(currentUrl, expectedUrl);
		}
	  @Test
		void search() throws InterruptedException {
			driver.get(baseUrl);
			Thread.sleep(1000);
			WebElement searchButton = driver.findElement(By.xpath("//*[@id=\"noo-site\"]/header/div[2]/div/a"));
			searchButton.click();
			WebElement searchField = driver.findElement(By.xpath("//*[@id=\"noo-site\"]/header/div[3]/div[2]/form/input[1]"));
			searchField.sendKeys("white");
			searchField.sendKeys(Keys.RETURN);
			Thread.sleep(3000);
			WebElement searchResult = driver.findElement(By.xpath("//*[@id=\"noo-site\"]/div[2]/div[1]/div/p"));
			String expectedResult = "Showing all 7 results";
			String currentResult = searchResult.getText();
			assertEquals(currentResult, expectedResult);
		}
	  @Test
		void addToCart() throws InterruptedException {
			driver.get(baseUrl);
			Thread.sleep(1000);
			WebElement searchButton = driver.findElement(By.xpath("//*[@id=\"noo-site\"]/header/div[2]/div/a"));
			searchButton.click();
			WebElement searchField = driver.findElement(By.xpath("//*[@id=\"noo-site\"]/header/div[3]/div[2]/form/input[1]"));
			searchField.sendKeys("white");
			searchField.sendKeys(Keys.RETURN);
			Thread.sleep(3000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,500)","");
			WebElement dress = driver.findElement(By.xpath("//*[@id=\"noo-site\"]/div[2]/div[2]/div/div/div[2]/div/div[1]/div[2]/div[1]/div/div[1]/a/img"));
			dress.click();
			Thread.sleep(2000);
			js.executeScript("window.scrollBy(0,600)","");
			Select colorOpts = new Select(driver.findElement(By.xpath("//*[@id=\"pa_color\"]")));
			colorOpts.selectByVisibleText("White");
			Select sizeOpts = new Select(driver.findElement(By.xpath("//*[@id=\"pa_size\"]")));
			sizeOpts.selectByVisibleText("Small");
			WebElement increase = driver.findElement(By.xpath("//*[@id=\"product-1467\"]/div[1]/div[2]/form/div/div[2]/div/div/button[2]/i"));
			increase.click();
			WebElement addToCart = driver.findElement(By.xpath("//*[@id=\"product-1467\"]/div[1]/div[2]/form/div/div[2]/button"));
			addToCart.click();
			Thread.sleep(3000);
			WebElement confirm = driver.findElement(By.xpath("//*[@id=\"nav-menu-item-cart\"]/a/span/span[2]"));
			String currentValue = confirm.getText();
			String expectedValue = "Cart(2)";
			assertEquals(currentValue, expectedValue);
		}
	  @Test
		void filters() throws InterruptedException {
			driver.get(baseUrl);
			Thread.sleep(1000);
			WebElement searchButton = driver.findElement(By.xpath("//*[@id=\"noo-site\"]/header/div[2]/div/a"));
			searchButton.click();
			WebElement searchField = driver.findElement(By.xpath("//*[@id=\"noo-site\"]/header/div[3]/div[2]/form/input[1]"));
			searchField.sendKeys("shirt");
			searchField.sendKeys(Keys.RETURN);
			Thread.sleep(3000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,500)","");
			Select colorOpts = new Select(driver.findElement(By.xpath("//*[@id=\"noo-site\"]/div[2]/div[1]/div/div[2]/form[1]/select")));
			colorOpts.selectByVisibleText("Black");
			Thread.sleep(3000);
			driver.navigate().back();
			Select sizeOpts = new Select(driver.findElement(By.xpath("//*[@id=\"noo-site\"]/div[2]/div[1]/div/div[2]/form[2]/select")));
			sizeOpts.selectByVisibleText("Medium");
			Thread.sleep(3000);
			driver.navigate().back();
			Select filterStyle = new Select(driver.findElement(By.xpath("//*[@id=\"noo-site\"]/div[2]/div[1]/div/div[2]/form[3]/select")));
			filterStyle.selectByVisibleText("List");
			Thread.sleep(3000);
			driver.navigate().back();
			filterStyle.selectByVisibleText("Grid");
			Select relevanceOpts = new Select(driver.findElement(By.xpath("//*[@id=\"noo-site\"]/div[2]/div[1]/div/form/select")));
			relevanceOpts.selectByVisibleText("Sort by popularity");
			Thread.sleep(1500);
			WebElement shirt = driver.findElement(By.xpath("//*[@id=\"noo-site\"]/div[2]/div[2]/div/div/div[3]/div/div[1]/div[2]/div[1]/div/div[1]/a/img"));
			shirt.click();
			Thread.sleep(3000);
			js.executeScript("window.scrollBy(0,600)","");
			Select shirtColor = new Select(driver.findElement(By.xpath("//*[@id=\"pa_color\"]")));
			shirtColor.selectByVisibleText("Black");
			Select shirtSize = new Select(driver.findElement(By.xpath("//*[@id=\"pa_size\"]")));
			shirtSize.selectByVisibleText("34");
			WebElement addToCart = driver.findElement(By.xpath("//*[@id=\"product-1485\"]/div[1]/div[2]/form/div/div[2]/button"));
			addToCart.click();
			Thread.sleep(3000);
			WebElement cart = driver.findElement(By.xpath("//*[@id=\"nav-menu-item-cart\"]/a/span/i"));
			cart.click();
			Thread.sleep(3000);
			WebElement confirm = driver.findElement(By.xpath("//*[@id=\"post-6\"]/div/div/form/table/tbody/tr[1]/td[2]/a"));
			String currentText = confirm.getText();
			String expectedText = "BLACK LUX GRAPHIC T-SHIRT - BLACK";
			assertEquals(currentText, expectedText);
		}
	  @Test
		void checkout() throws InterruptedException {
			driver.get(baseUrl);
			Thread.sleep(1000);
			WebElement searchButton = driver.findElement(By.xpath("//*[@id=\"noo-site\"]/header/div[2]/div/a"));
			searchButton.click();
			WebElement searchField = driver.findElement(By.xpath("//*[@id=\"noo-site\"]/header/div[3]/div[2]/form/input[1]"));
			searchField.sendKeys("shirt");
			searchField.sendKeys(Keys.RETURN);
			Thread.sleep(3000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,500)","");
			WebElement shirt = driver.findElement(By.xpath("//*[@id=\"noo-site\"]/div[2]/div[2]/div/div/div[3]/div/div[1]/div[2]/div[1]/div/div[1]/a/img"));
			shirt.click();
			Thread.sleep(3000);
			js.executeScript("window.scrollBy(0,600)","");
			Select shirtColor = new Select(driver.findElement(By.xpath("//*[@id=\"pa_color\"]")));
			shirtColor.selectByVisibleText("Black");
			Select shirtSize = new Select(driver.findElement(By.xpath("//*[@id=\"pa_size\"]")));
			shirtSize.selectByVisibleText("34");
			WebElement addToCart = driver.findElement(By.xpath("//*[@id=\"product-1485\"]/div[1]/div[2]/form/div/div[2]/button"));
			addToCart.click();
			Thread.sleep(3000);
			WebElement cart = driver.findElement(By.xpath("//*[@id=\"nav-menu-item-cart\"]/a/span/i"));
			cart.click();
			Thread.sleep(3000);
			js.executeScript("window.scrollBy(0,600)","");
			WebElement checkout = driver.findElement(By.xpath("//*[@id=\"post-6\"]/div/div/div[2]/div[2]/div/a"));
			checkout.click();
			Thread.sleep(3000);
			js.executeScript("window.scrollBy(0,700)","");
			WebElement name = driver.findElement(By.xpath("//*[@id=\"billing_first_name\"]"));
			name.sendKeys("Beis");
			WebElement surname = driver.findElement(By.xpath("//*[@id=\"billing_last_name\"]"));
			surname.sendKeys("Ibrahimagic");
			WebElement company = driver.findElement(By.xpath("//*[@id=\"billing_company\"]"));
			company.sendKeys("AtlantBH");
			Select country = new Select(driver.findElement(By.xpath("//*[@id=\"select2-billing_country-container\"]")));
			country.selectByVisibleText("Bosnia and Herzegovina");
			WebElement address = driver.findElement(By.xpath("//*[@id=\"billing_address_1\"]"));
			address.sendKeys("Mostarska 4");
			WebElement apartment = driver.findElement(By.xpath("//*[@id=\"billing_address_2\"]"));
			apartment.sendKeys("Bedjo");
			WebElement postalCode = driver.findElement(By.xpath("//*[@id=\"billing_postcode\"]"));
			postalCode.sendKeys("71000");
			WebElement city = driver.findElement(By.xpath("//*[@id=\"billing_city\"]"));
			city.sendKeys("Sarajevo");
			WebElement canton = driver.findElement(By.xpath("//*[@id=\"billing_state\"]"));
			canton.sendKeys("Sarajevo");
			js.executeScript("window.scrollBy(0,600)","");
			WebElement telephone = driver.findElement(By.xpath("//*[@id=\"billing_phone\"]"));
			telephone.sendKeys("+387 61 591 686");
			WebElement email = driver.findElement(By.xpath("//*[@id=\"billing_email\"]"));
			email.sendKeys("beiztesting@gmail.com");
			WebElement orderInfo = driver.findElement(By.xpath("//*[@id=\"order_comments\"]"));
			orderInfo.sendKeys("Ring on the door, not the gate.");
			WebElement agreement = driver.findElement(By.xpath("//*[@id=\"terms\"]"));
			agreement.click();
			WebElement order = driver.findElement(By.xpath("//*[@id=\"place_order\"]"));
			order.click();
			Thread.sleep(3000);
			WebElement confirm = driver.findElement(By.cssSelector("#post-7 > div > div > div > p.woocommerce-thankyou-order-received"));
			String currentText = confirm.getText();
			String expectedText = "Thank you. Your order has been received.";
			assertEquals(currentText, expectedText);
		}
}
