package Tests;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import steps.StepDefinitions;

public class T_1_Compare_Cities  {
	
	
	public AppiumDriver driver ; 
	
	
	
	@BeforeMethod
	public void startApp() throws MalformedURLException, InterruptedException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		
		capabilities.setCapability("platformName","Android");
	    capabilities.setCapability("platformVersion","10");
	    capabilities.setCapability("deviceName","4d8acec0");
	    capabilities.setCapability("newCommandTimeout","0");
	    capabilities.setCapability("appPackage","com.pozitron.hepsiburada");
	    capabilities.setCapability("appActivity","com.hepsiburada.ui.startup.SplashActivity");
		
	    driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4724/wd/hub"), capabilities);
	    
	    //Wait hepsiFly ad
	    Thread.sleep(40000);
	    
	    
	    
	}
	
	
	String actualResult ;
	String expectedResult ;
	
	@Test(priority = 1)
	public void SelectCity() throws IOException, InterruptedException {
		
		StepDefinitions functions = new StepDefinitions();
		// Click Location button
		functions.ClickOnWithXpath(driver,"//android.view.ViewGroup[1]/android.widget.LinearLayout/android.view.ViewGroup[2]/androidx.cardview.widget.CardView[1]/android.view.ViewGroup");
		// Click il seçin section
		functions.ClickOnWithXpath(driver,"//android.widget.TextView[@content-desc=\"Ýl seçin\"]");
		// Select a city from list
		functions.ClickOnWithXpath(driver,"//android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.TextView");
		// Get City name
		expectedResult = functions.getTextwithXpath(driver,"//android.widget.TextView[@content-desc=\"Ýl seçin\"]");
		// Select district
		functions.ClickOnWithXpath(driver,"//android.widget.TextView[@content-desc=\"Ýlçe seçin\"]");
		// Select a district from list
		functions.ClickOnWithXpath(driver,"//android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.TextView");
		// Select mahalle
		functions.ClickOnWithXpath(driver,"//android.widget.TextView[@content-desc=\"Mahalle seçin\"]");
		// Select a mahalle from list
		functions.ClickOnWithXpath(driver,"//android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.TextView");
		// Click Save button
		functions.ClickOnWithId(driver,"com.pozitron.hepsiburada:id/button");
		// Location selected pop-up
		functions.isDisplayed(driver, "com.pozitron.hepsiburada:id/tvTitle");
		//Click kategoriler button
		functions.ClickOnWithXpath(driver,"//android.widget.FrameLayout[@content-desc=\"Kategoriler\"]/android.view.ViewGroup/android.widget.TextView");
		// Select first Kategori
		functions.ClickOnWithXpath(driver,"//androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/androidx.cardview.widget.CardView/android.widget.ImageView");
		// Compare Cities
		functions.checkItemText(driver, "com.pozitron.hepsiburada:id/textViewLocation", expectedResult);
			
	
	
	} 
	@Test(priority = 2)
	public void CheckMyFavouritesPage() throws IOException, InterruptedException {
		StepDefinitions functions = new StepDefinitions();
		//Click All Button
		functions.ClickOnWithId(driver, "com.pozitron.hepsiburada:id/dod_all");
		//Click first product in list 
		functions.ClickOnWithId(driver, "com.pozitron.hepsiburada:id/tv_product_list_item_name");
		// Click Image
		functions.ClickOnWithId(driver, "com.pozitron.hepsiburada:id/productImage");
		// Swipe image
		functions.scrollPage(driver, 740, 740, 349, 749);
		// Click back button
		functions.ClickOnWithId(driver, "com.pozitron.hepsiburada:id/leftIcon");
		// get expected result
		expectedResult = functions.getTextwithXpath(driver,"//android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup/android.widget.TextView[2]" );
		// Click add favorite button
		functions.ClickOnWithId(driver,"com.pozitron.hepsiburada:id/product_detail_favourites");
		// click email Section
		functions.ClickOnWithXpath(driver,"//android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText");
		// Enter Email
		functions.sendKeysWithXpath(driver,"//android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText", "testakintest@gmail.com");
	    // Click Giriþ yap button
		functions.ClickOnWithXpath(driver, "//android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.widget.Button");
		Thread.sleep(40000); // For pop-up
		// Click password section
		functions.ClickOnWithXpath(driver, "//android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.widget.EditText");
		//Enter Password
		functions.sendKeysWithXpath(driver, "//android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.widget.EditText", "testAkintest1");
		// Click Giriþ yap button
		functions.ClickOnWithXpath(driver, "//android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]/android.widget.Button");
		// Check Welcome Popup
		functions.isContains(driver,"android:id/message" , "Hoþ geldin");
		// Click Okay button in Welcome pop-up
		functions.ClickOnWithId(driver, "android:id/button1");
		// Click back button in product detail
		functions.scrollPage(driver, 1070, 1506, 471, 1465);
		// click account button
		functions.ClickOnWithId(driver, "com.pozitron.hepsiburada:id/iv_toolbar_user_account_menu");
		// Check Login
		functions.checkItemText(driver, "com.pozitron.hepsiburada:id/tvUserNameFull", "Test Akin");
		// Click My favourites button
		functions.ClickOnWithXpath(driver, "//android.view.ViewGroup[@content-desc=\"account_menu_4\"]");
		// Click item in like list
		functions.ClickOnWithXpath(driver, "//android.view.View[@content-desc=\"123\"]/android.view.View/android.view.View/android.view.View");
		// Get Actual Text
		actualResult = functions.getTextwithXpath(driver,"//android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup/android.widget.TextView[2]" );
		// COmpare Results
		functions.CompareTexts(driver, actualResult, expectedResult);
	
	}
	
	
	
}
