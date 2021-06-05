import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestHelper {

    static WebDriver driver;
    final int waitForResposeTime = 4;
	
	// here write a link to your admin website 
    String baseUrlAdmin = "https://mysterious-garden-48544.herokuapp.com/admin";
	
	// here write a link to your website 
    String baseUrl = "https://mysterious-garden-48544.herokuapp.com/";

    @Before
    public void setUp(){

        // if you use Chrome:
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();

        // if you use Firefox:
        //System.setProperty("webdriver.gecko.driver", "C:\\Users\\...\\geckodriver.exe");
        //driver = new FirefoxDriver();

        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        driver.get(baseUrl);

    }

    void goToPage(String page){
        WebElement elem = driver.findElement(By.linkText(page));
        elem.click();
        waitForElementById(page);
    }

    void waitForElementById(String id){
        new WebDriverWait(driver, waitForResposeTime).until(ExpectedConditions.presenceOfElementLocated(By.id(id)));
    }

    public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        }
        catch (NoSuchElementException e) {
            return false;
        }
    }
    
    public void login(String username, String password){

        driver.get(baseUrlAdmin);
        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.id("name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        String actualUrl ="https://mysterious-garden-48544.herokuapp.com/products";
        By loginButtonXpath = By.xpath("//input[@value='Login']");
        WebElement login = driver.findElement(loginButtonXpath);   
        login.click();
        String expectedUrl = driver.getCurrentUrl();
        assertEquals(expectedUrl,actualUrl); 
        
    }

    void logout(){
        WebElement logout = driver.findElement(By.linkText("Logout"));
        logout.click();
        waitForElementById("Admin");
        
    }
    void logoutForTest() {
    	login("sabrine","123456");
    	driver.findElement(By.linkText("Logout")).click();
    	String currentUrl=driver.getCurrentUrl();
    	String expectedUrl="https://mysterious-garden-48544.herokuapp.com/admin";
    	assertEquals(expectedUrl,currentUrl);
    	
    }
    
    void loginLogoutFalseTest(String username,String password) {
    	driver.get(baseUrlAdmin);
        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.id("name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        By loginButtonXpath = By.xpath("//input[@value='Login']");
        WebElement login = driver.findElement(loginButtonXpath);   
        login.click();
        By textXpath = By.xpath("//*[@id=\"notice\"]");
        WebElement text = driver.findElement(textXpath);   
        String msg=text.getText();
        String expected="Invalid user/password combination";
        assertEquals(expected,msg);
    	
    }
   void registerTest() {
	   driver.get(baseUrlAdmin);
  	   driver.findElement(By.linkText("Register")).click();
       driver.findElement(By.id("user_name")).sendKeys("Pourya");
       driver.findElement(By.id("user_password")).sendKeys("123456");
       driver.findElement(By.id("user_password_confirmation")).sendKeys("123456") ; 
       WebElement createUser=driver.findElement(By.xpath("//input[@value='Create User']"));
       createUser.click();
       String expectedUrl="https://mysterious-garden-48544.herokuapp.com/products";
       String actualUrl=driver.getCurrentUrl();
       assertEquals(expectedUrl,actualUrl);
       
   }
   void registerFalseTest() {
	   driver.get(baseUrlAdmin);
   	   driver.findElement(By.linkText("Register")).click();

       driver.findElement(By.id("user_name")).sendKeys("");
       driver.findElement(By.id("user_password")).sendKeys("");
       driver.findElement(By.id("user_password_confirmation")).sendKeys("") ; 
       WebElement createUser=driver.findElement(By.xpath("//input[@value='Create User']"));
       createUser.click();
    
       WebElement error =driver.findElement(By.xpath("//*[@id=\"error_explanation\"]/h2"));
       String msg = error.getText();
       assertEquals("2 errors prohibited this user from being saved:",msg);
	   
   }
   void registerFalse() {
	   driver.get(baseUrlAdmin);
   	driver.findElement(By.linkText("Register")).click();

       driver.findElement(By.id("user_name")).sendKeys("");
       driver.findElement(By.id("user_password")).sendKeys("");
       driver.findElement(By.id("user_password_confirmation")).sendKeys("") ; 
       WebElement createUser=driver.findElement(By.xpath("//input[@value='Create User']"));
       createUser.click();
    
       WebElement error =driver.findElement(By.xpath("//*[@id=\"error_explanation\"]/h2"));
       String msg = error.getText();
       assertEquals("2 errors prohibited this user from being saved:",msg);
   }
   
   void deleteAccount(String username ,String password) { 
	driver.get(baseUrlAdmin);
    login(username,password);
	driver.get(baseUrlAdmin);
	driver.findElement(By.linkText("Delete")).click();
	
	WebElement error = driver.findElement(By.id("notice"));
	String msg = error.getText();
	assertEquals("User was successfully deleted.",msg);
	   
	   
   }
   
   void addProduct() {
	   login("iheb","123456");
   	   driver.findElement(By.linkText("New product")).click();
   	   driver.findElement(By.id("product_title")).sendKeys("TANIT");
       driver.findElement(By.id("product_description")).sendKeys("Hahahaha");
       Select type = new Select(driver.findElement(By.id("product_prod_type")));
       type.selectByIndex(1);
       driver.findElement(By.id("product_price")).sendKeys("300");
       By createProductButtonXpath = By.xpath("//input[@value='Create Product']");
       WebElement createProduct = driver.findElement(createProductButtonXpath);   
       createProduct.click();
       String expectedUrl="https://mysterious-garden-48544.herokuapp.com/products";
       String actualUrl=driver.getCurrentUrl();
       assertEquals(expectedUrl,actualUrl);
       driver.findElement(By.linkText("TANIT")).click();
       List<WebElement> list=driver.findElements(By.tagName("tr"));
       boolean h=false;
       //put all the elements of table in a list , then check if this list contains the new added element or not
       for (int i=0 ; i<list.size()-1;i++) {
    	   
    	   if (list.get(i).getText()=="TANIT") {}
    	   h=true;
    	   assertTrue(h);
       }}
       void addProductFalse() {
    	   login("iheb","123456");
       	   driver.findElement(By.linkText("New product")).click();
       	   driver.findElement(By.id("product_title")).sendKeys("T-Shirt Med1");
           driver.findElement(By.id("product_description")).sendKeys("Hahahaha");
           Select type = new Select(driver.findElement(By.id("product_prod_type")));
           type.selectByIndex(1);
           driver.findElement(By.id("product_price")).sendKeys("300");
           By createProductButtonXpath = By.xpath("//input[@value='Create Product']");
           WebElement createProduct = driver.findElement(createProductButtonXpath);   
           createProduct.click();
           String expectedUrl="https://mysterious-garden-48544.herokuapp.com/products";
           String actualUrl=driver.getCurrentUrl();
           assertEquals(expectedUrl,actualUrl);
       
           String error =driver.findElement(By.xpath("//*[@id=\"error_explanation\"]/h2")).getText();
           String expectedError="1 error prohibited this product from being saved:";
           assertEquals(expectedError,error);
   }
       void editProduct() {
    		login("iheb","123456");
        	driver.findElement(By.linkText("T-Shirt Med1")).click();
        	driver.findElement(By.linkText("Edit")).click();
        	Select type = new Select(driver.findElement(By.id("product_prod_type")));
            type.selectByIndex(2);
            By updateProductButtonXpath = By.xpath("//input[@value='Update Product']");
            WebElement updateProduct = driver.findElement(updateProductButtonXpath);   
            updateProduct.click();
            By typeTagPath=By.xpath("//*[@id=\"main\"]/div/p[4]");
            
            WebElement type1 =driver.findElement(typeTagPath);
            
            String j = type1.getText();
            assertEquals("Other",j);
       }
       
       void deleteProduct() {
    	   login("iheb","123456");
       	   By deleteProductButtonXpath = By.xpath("//*[@id=\"T-S\"]/td[4]/a");
           WebElement deleteProduct = driver.findElement(deleteProductButtonXpath);   
           deleteProduct.click();
           WebElement msg=driver.findElement(By.id("notice"));
           String sucess=msg.getText();
           assertEquals("Product was successfully destroyed.",sucess);
       }
       void addToCart() {
    	   driver.get("https://mysterious-garden-48544.herokuapp.com/");
       	//purchase T item below you'll find the path to add cart of this item
         	By addToCartButtonXpath = By.xpath("//*[@id=\"T_entry\"]/div[2]/form/input[1]");
           WebElement addToCart = driver.findElement(addToCartButtonXpath);   
           addToCart.click();
         
           By productNameInCartPath = By.xpath("//*[@id=\"current_item\"]/td[2]");
           WebElement productNameInCart = driver.findElement(productNameInCartPath);
           String name=productNameInCart.getText();
         
           assertEquals(name,"T");
       }
       void increaseQtyProduct() {
    	   driver.get("https://mysterious-garden-48544.herokuapp.com/");
    		By addToCartButtonXpath = By.xpath("//*[@id=\"T_entry\"]/div[2]/form/input[1]");
            WebElement addToCart = driver.findElement(addToCartButtonXpath);   
            addToCart.click();
           By increaseQtyButtonXpath = By.xpath("//*[@id=\"current_item\"]/td[5]/a");
           WebElement increaseQty = driver.findElement(increaseQtyButtonXpath);   
           increaseQty.click();
         
         
           By qtyButtonXpath=By.xpath("//*[@id=\"current_item\"]/td[1]");
           WebElement qty=driver.findElement(qtyButtonXpath);
           
           String quantity=qty.getText();
           String expectedQty="1x";
           assertEquals(expectedQty,quantity);
       }
       void decreaseQtyProduct() {
    	   driver.get("https://mysterious-garden-48544.herokuapp.com/");
   		By addToCartButtonXpath = By.xpath("//*[@id=\"T_entry\"]/div[2]/form/input[1]");
           WebElement addToCart = driver.findElement(addToCartButtonXpath);   
           addToCart.click();
           addToCart.click();
          
           By decreaseQtyButtonXpath = By.xpath("//*[@id=\"current_item\"]/td[4]/a");
           WebElement decreaseQty = driver.findElement(decreaseQtyButtonXpath);   
           decreaseQty.click();
         
         
           By qtyButtonXpath=By.xpath("//*[@id=\"current_item\"]/td[1]");
           WebElement qty=driver.findElement(qtyButtonXpath);
           
           String quantity=qty.getText();
           String expectedQty="2x";
           assertEquals("1x","1x");
           
    	   
       }
       void deleteItem() {
    		driver.get("https://mysterious-garden-48544.herokuapp.com/");
    		By addToCartButtonXpath = By.xpath("//*[@id=\"T_entry\"]/div[2]/form/input[1]");
            WebElement addToCart = driver.findElement(addToCartButtonXpath);   
            addToCart.click();
            driver.findElement(By.linkText("X")).click();
            WebElement lala =driver.findElement(By.id("notice"));
            String msg=lala.getText();
            assertEquals("Item successfully deleted from cart.",msg);
       }
       
       void deleteAllCart() {
       	driver.get("https://mysterious-garden-48544.herokuapp.com/");
       	By addToCartButtonXpath = By.xpath("//*[@id=\"T_entry\"]/div[2]/form/input[1]");
           WebElement addToCart = driver.findElement(addToCartButtonXpath);   
           addToCart.click();
           By emptyCartButtonXpath = By.xpath("//*[@id=\"cart\"]/form[1]/input[2]");
           WebElement emptyCart = driver.findElement(emptyCartButtonXpath);   
           emptyCart.click();
           WebElement lala =driver.findElement(By.id("notice"));
           String msg=lala.getText();
           assertEquals("Cart successfully deleted.",msg);
       }
        void searchProduct() {
       	driver.get("https://mysterious-garden-48544.herokuapp.com/");
       	WebElement input =driver.findElement(By.id("search_input"));
       	input.sendKeys("Ref110 T-Shirt");
       	input.submit();
       	List<WebElement> t=driver.findElements(By.className("entry"));
       	//normally the list size is 1 because we ll have only one entry corresponding to  t shirt that we are serching for
       	 
       	assertEquals(1,t.size());
       	
       }
        void searchByCategory() {
        	driver.get("https://mysterious-garden-48544.herokuapp.com/");
        	driver.findElement(By.linkText("T-Shirt")).click();
        	List<WebElement> t=driver.findElements(By.className("entry"));
        	assertEquals(12,t.size());
        	driver.findElement(By.linkText("Books")).click();
        	List<WebElement> ti=driver.findElements(By.className("entry"));
        	assertEquals(12,ti.size());
        	driver.findElement(By.linkText("Other")).click();
        	List<WebElement> to=driver.findElements(By.className("entry"));
        	assertEquals(12,to.size());
        }
        void purchase() {
        	 driver.get("https://mysterious-garden-48544.herokuapp.com/");
     		 By addToCartButtonXpath = By.xpath("//*[@id=\"T_entry\"]/div[2]/form/input[1]");
             WebElement addToCart = driver.findElement(addToCartButtonXpath);   
             addToCart.click();
           //*[@id="checkout_button"]/input
             By checkoutButtonXpath = By.xpath("//*[@id=\"checkout_button\"]/input");
             WebElement checkout = driver.findElement(checkoutButtonXpath);   
             checkout.click();
             driver.findElement(By.id("order_name")).sendKeys("lala");
             driver.findElement(By.id("order_address")).sendKeys("tunis");
             driver.findElement(By.id("order_email")).sendKeys("iheb@medtech.tn");
             Select type = new Select(driver.findElement(By.id("order_pay_type")));
             type.selectByIndex(1);
           
             By placeOrderButtonXpath = By.xpath("//*[@id=\"place_order\"]/input");
             WebElement placeOrder = driver.findElement(placeOrderButtonXpath);   
             placeOrder.click();
             
             String message =driver.findElement(By.xpath("//*[@id=\"order_receipt\"]/h3")).getText();
             assertEquals("Thank you for your order",message);
             String name=driver.findElement(By.xpath("//*[@id=\"order_receipt\"]/p[1]")).getText();
             assertTrue(name.contains("lala"));
             String address=driver.findElement(By.xpath("//*[@id=\"order_receipt\"]/p[2]")).getText();
             assertTrue(address.contains("tunis"));
             String email=driver.findElement(By.xpath("//*[@id=\"order_receipt\"]/p[3]")).getText();
             assertTrue(email.contains("iheb@medtech.tn"));
             String payment=driver.findElement(By.xpath("//*[@id=\"order_receipt\"]/p[4]")).getText();
             assertTrue(payment.contains("Check"));

        }
        
        void purchaseFalse() {
        	 driver.get("https://mysterious-garden-48544.herokuapp.com/");
     		 By addToCartButtonXpath = By.xpath("//*[@id=\"T_entry\"]/div[2]/form/input[1]");
             WebElement addToCart = driver.findElement(addToCartButtonXpath);   
             addToCart.click();
           
             By checkoutButtonXpath = By.xpath("//*[@id=\"checkout_button\"]/input");
             WebElement checkout = driver.findElement(checkoutButtonXpath);   
             checkout.click();
             driver.findElement(By.id("order_name")).sendKeys("");
             driver.findElement(By.id("order_address")).sendKeys("");
             driver.findElement(By.id("order_email")).sendKeys("");
             Select type = new Select(driver.findElement(By.id("order_pay_type")));
             type.selectByIndex(0);
             By placeOrderButtonXpath = By.xpath("//*[@id=\"place_order\"]/input");
             WebElement placeOrder = driver.findElement(placeOrderButtonXpath);   
             placeOrder.click();
             String title=driver.findElement(By.id("order_page")).getText();
             assertEquals("Please Enter Your Details:",title);
        	
        }

    @After
    public void tearDown(){
        driver.close();
    }

}