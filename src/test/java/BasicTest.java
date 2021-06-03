import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static junit.framework.TestCase.assertEquals;

import java.util.List;

public class BasicTest extends TestHelper {


    private String username = "";
    private String password = "";

   /* @Test
    public void titleExistsTest(){
        String expectedTitle = "MedTech Online Store";
        String actualTitle = driver.getTitle();

        assertEquals(expectedTitle, actualTitle);
    }*/


    /*
    
    Fill in loginLogoutTest() and login mehtod in TestHelper, so that the test passes correctly.

     */
   /*  @Test
    public void loginLogoutTest(){

        login("sabrine", "123456");
        
        
        

        
        // WebElement adminHeader = driver.findEl
        

        // ...

        logout();
    }
     @Test
     public void loginLogoutFailedTest(){

         login("sabr", "123456");
         
         
         

         
         // WebElement adminHeader = driver.findEl
         

         // ...

         //logout();
     }

    /*

     Write a test case, where you make sure, that one can’t log in with a false password

     */
    // @Test
  /*  public void loginFalsePassword() {

    }
   /* @Test
    
    public void registerTrueTest() {
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
    
   /* @Test
    public void registerFalseTest() {
    	driver.findElement(By.linkText("Register")).click();

        driver.findElement(By.id("user_name")).sendKeys("");
        driver.findElement(By.id("user_password")).sendKeys("");
        driver.findElement(By.id("user_password_confirmation")).sendKeys("") ; 
        WebElement createUser=driver.findElement(By.xpath("//input[@value='Create User']"));
        createUser.click();
        WebElement error =driver.findElement(By.id("error_explanation"));
        String msg = error.getText();
        assertEquals("2 errors prohibited this user from being saved:",msg);
    	
    }*/
    /*@Test
    public void deleteAccount() {
    	
    	login("pourya","123456");
    	driver.get(baseUrlAdmin);
    	driver.findElement(By.linkText("Delete")).click();
    	
    	WebElement error = driver.findElement(By.id("notice"));
    	String msg = error.getText();
    	assertEquals("User was successfully deleted.",msg);
    }*/
    
   /* @Test
    public void addProduct() {
    	login("iheb","123456");
    	driver.findElement(By.linkText("New product")).click();
    	driver.findElement(By.id("product_title")).sendKeys("T-Shi");
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
        driver.findElement(By.linkText("T-Shi")).click();
        String expectedUrl1="https://mysterious-garden-48544.herokuapp.com/products/14";
        String actualUrl1=driver.getCurrentUrl();
        assertEquals(expectedUrl1,actualUrl1);
    }*/
    //Always when we edit an item the type is always Book this is why this test case fails
    /*@Test
    public void editProduct() {
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
        assertEquals(j,"Other");
    	
    }*/
    
    /*@Test 
    public void deleteProduct() {
    	login("iheb","123456");
    	By deleteProductButtonXpath = By.xpath("//*[@id=\"T-Shirt B45593\"]/td[4]/a");
        WebElement deleteProduct = driver.findElement(deleteProductButtonXpath);   
        deleteProduct.click();
        WebElement msg=driver.findElement(By.id("notice"));
        String sucess=msg.getText();
        assertEquals("Product was successfully destroyed.",sucess);
    	
    }*/
    //End user functionality 
   /* @Test
    public void addToCartTest() {
    	driver.get("https://mysterious-garden-48544.herokuapp.com/");
    	//purchase dddd item below you'll find the path to add cart of this item
    	By addToCartButtonXpath = By.xpath("//*[@id=\"dddd_entry\"]/div[2]/form/input[1]");
        WebElement addToCart = driver.findElement(addToCartButtonXpath);   
        addToCart.click();
      
        By productNameInCartPath = By.xpath("//*[@id=\"current_item\"]/td[2]");
        WebElement productNameInCart = driver.findElement(productNameInCartPath);
        String name=productNameInCart.getText();
      
        assertEquals(name,"dddd");
        
        
        
    }*/
   /* @Test
    public void IncreaseQtyProductTest() {
    	driver.get("https://mysterious-garden-48544.herokuapp.com/");
    	By addToCartButtonXpath = By.xpath("//*[@id=\"Ref110 T-Shirt_entry\"]/div[2]/form/input[1]");
        WebElement addToCart = driver.findElement(addToCartButtonXpath);   
        addToCart.click();
        By increaseQtyButtonXpath = By.xpath("//*[@id="current_item"]/td[5]/a");
        WebElement increaseQty = driver.findElement(increaseQtyButtonXpath);   
        increaseQty.click();
      
        By qtyButtonXpath=By.xpath("//*[@id=\"current_item\"]/td[1]");
        WebElement qty=driver.findElement(qtyButtonXpath);
        
        String quantity=qty.getText();
        String expectedQty="2x";
        assertEquals(expectedQty,quantity);
        
    }*/
    
   /* @Test
    public void deleteItemTest() {
    	driver.get("https://mysterious-garden-48544.herokuapp.com/");
    	By addToCartButtonXpath = By.xpath("//*[@id=\"Ref110 T-Shirt_entry\"]/div[2]/form/input[1]");
        WebElement addToCart = driver.findElement(addToCartButtonXpath);   
        addToCart.click();
        driver.findElement(By.linkText("X")).click();
        WebElement lala =driver.findElement(By.id("notice"));
        String msg=lala.getText();
        assertEquals("Item successfully deleted from cart.",msg);
    }*/
    @Test
    public void deleteAllCartTest() {
    	driver.get("https://mysterious-garden-48544.herokuapp.com/");
    	By addToCartButtonXpath = By.xpath("//*[@id=\"Ref110 T-Shirt_entry\"]/div[2]/form/input[1]");
        WebElement addToCart = driver.findElement(addToCartButtonXpath);   
        addToCart.click();
        By emptyCartButtonXpath = By.xpath("//*[@id=\"cart\"]/form[1]/input[2]");
        WebElement emptyCart = driver.findElement(emptyCartButtonXpath);   
        emptyCart.click();
        WebElement lala =driver.findElement(By.id("notice"));
        String msg=lala.getText();
        assertEquals("Cart successfully deleted.",msg);
        
    	
    }
    

}
