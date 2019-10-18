package co.testinium.selenium.demo;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class n11TestCommands {

WebDriver driver;
WebElement next;
	
	public void invokeBrowser() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\petek\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		getCommands();
	}
	
	public void getCommands() throws InterruptedException {
		driver.get("https://www.n11.com/");
		String actualValue=driver.getTitle();
		String expectedValue="n11.com - Alýþveriþin Uðurlu Adresi";
		if(actualValue.equalsIgnoreCase(expectedValue)) {
			System.out.println("Test Succesfull...");
		}else {
			System.out.println("Failure...");
			System.out.println("Actual Title is :"+actualValue);
		}
		

		driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div[2]/div[2]/div[2]/div/div/a[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("email")).sendKeys("narnia_000_1994@hotmail.com");
		driver.findElement(By.name("password")).sendKeys("n11test");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"loginButton\"]")).click();
		
	/*	//TODO:Login iþlemi kontrol edilir.
		String loginText=driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div[2]/div[2]/div[2]/div[1]/a[2]/text()")).getText();
		if(loginText=="deneme test") {
			System.out.println("Login Olundu.");
		}
		*/
		driver.findElement(By.id("searchData")).sendKeys("bilgisayar");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div[2]/div[1]/a/span")).click();
		Thread.sleep(2000);
		//TODO:Elementi listeden al

		driver.navigate().to("https://www.n11.com/arama?q=bilgisayar&amp;pg=2&pg=2");
		Thread.sleep(2000);
		//selectRandomProduct();
		String oldPrice = driver.findElement(By.xpath("//*[@id=\"p-334702254\"]/div[2]/a[2]/ins")).getText();
		driver.findElement(By.xpath("//*[@id=\"p-334702254\"]/div[1]/a/img")).click();
		driver.findElement(By.linkText("Sepete Ekle")).click();
		driver.findElement(By.className("myBasket")).click();
		String newPrice = driver.findElement(By.xpath("//*[@id=\"newCheckout\"]/div/div[1]/div[2]/div[1]/section[2]/table[2]/tbody/tr/td[3]/div[2]/div/span")).getText();
		System.out.println(oldPrice+"-"+newPrice);
		driver.findElement(By.xpath("//*[@id=\"newCheckout\"]/div/div[1]/div[2]/div[1]/section[2]/table[2]/tbody/tr/td[3]/div[1]/div/span[1]")).click();
		String value=driver.findElement(By.xpath("//*[@id=\"quantity_126613841034\"]")).getAttribute("value");
		int newValue=Integer.parseInt(value);
		if(newValue==2) {
			System.out.println("Sepette iki adet ürün bulunmakta");
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"newCheckout\"]/div/div[1]/div[2]/div[1]/section[2]/table[2]/tbody/tr/td[1]/div[3]/div[2]/span[1]")).click();
		
		String text = driver.findElement(By.className("cartEmptyText")).findElement(By.tagName("h2")).getText();
		System.out.println(text);
		if(text.equals("Sepetiniz Boþ")) {
			System.out.println("Sepet Boþ");
		}
		/*
		String value=driver.findElement(By.xpath("//*[@id=\"quantity_126613841034\"]")).getAttribute("value");
		
		int newValue=Integer.parseInt(value);
		newValue++;
		value =String.valueOf(newValue);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('quantity_126613841034').setAttribute('value', value)");
		driver.findElement(By.xpath("//*[@id=\"quantity_126613841034\"]"));
		*/
		

		
	}
	/*public void selectRandomProduct(){

	    // Find and click on a random product
	    java.util.List<WebElement> allProducts = driver.findElements(By.className("productName"));
	    Random rand = new Random();
	    int randomProduct = rand.nextInt(allProducts.size());
	    allProducts.get(randomProduct).click();
	}*/
	
	public void closeTheBrowser() {
		driver.quit();
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		n11TestCommands Object=new n11TestCommands();
		Object.invokeBrowser();
		System.out.println("Main fonksiyonu çalýþtý..");
		
		Thread.sleep(10000);
		Object.closeTheBrowser();

	}

}
