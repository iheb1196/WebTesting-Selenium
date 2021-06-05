import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static junit.framework.TestCase.assertEquals;

import java.util.List;

public class BasicTest extends TestHelper {
    @Test
    public void logoutTest() {
    	logoutForTest();
    }

   @Test
    public void titleExistsTest(){
        String expectedTitle = "MedTech Online Store";
        String actualTitle = driver.getTitle();

        assertEquals(expectedTitle, actualTitle);
    }


    @Test
    public void loginLogoutTest(){

        login("sabrine", "123456");
        
        logout();
    }
    @Test
     public void loginLogoutFalseTest(){

         loginLogoutFalseTest("sabrine", "12345");
         
     }
     

    @Test
    public void registerTrueTest() {
    	registerTest();
         }
    
    @Test
    public void registerFalseTest() {
    	registerFalse();
  	   
    	
    }
    @Test
    public void deleteAccount() {
       deleteAccount("Pourya","123456");
    }
    
    @Test
    public void addProductTest() {
    	addProduct();
    	
    }
    
    @Test
    public void addProductFalseTest() {
    	addProductFalse();
    }
    //Always when we edit an item the type is always Book this is why this test case fails
    @Test
    public void editProductTest() {
     editProduct();    
    	
    }
    
    @Test 
    public void deleteProductTest() {
       deleteProduct();
    }
                             /*******End user functionality*************/
    @Test
    public void addToCartTest() {
    	addToCart();
        
        
        
    }
    @Test
    public void IncreaseQtyProductTest() {
    	increaseQtyProduct();
        
    }
    
    @Test
    public void deleteItemTest() {
    	deleteItem();
    
    }
    @Test
    public void deleteAllCartTest() {
    	deleteAllCart();
        
    	
    }
    //this test had failed the search box doesnot work correctly
   @Test
    public void searchProductTest() {
    	searchProduct();
    	
    } 
    
    @Test
    public void searchByCategoryTest() {
    	searchByCategory();
    	
    	
    }
	@Test
	public void purchaseTest() {
		purchase();
	}
	@Test
	public void purchaseFalseTest() {
		purchaseFalse();
	}
    @Test
    public void decreaseQtyProductTest() {
    	decreaseQtyProduct();
        
    }
    

}
