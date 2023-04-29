package steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class searchProducts {
	
	WebDriver driver;
	
	@Given("i am on the google homepage")
	public void i_am_on_the_google_homepage() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);    
		
	}

	@When("i enter the {string} in the search bar")
	public void i_enter_the_in_the_search_bar(String product_name) {
		
		WebElement searchBar = driver.findElement(By.className("gLFyf"));
		searchBar.sendKeys(product_name);
		
	}

	@When("i click on the search bar")
	public void i_click_on_the_search_bar() {
		WebElement searchButton = driver.findElement(By.name("btnK"));
		searchButton.submit();
	  
		
	}

	@Then("i can see the result sucessfully")
	public void i_can_see_the_result_sucessfully() {
	    WebElement searchResult = driver.findElement(By.id("result-stats"));
	    String resultText = searchResult.getText();
		System.out.println("=======================");
		System.out.println(resultText);
		System.out.println("=======================");
		Assert.assertTrue(searchResult.isDisplayed());
		
		System.out.println("==Making changes for Git Hub=====================");
		
	}


	
	
}
