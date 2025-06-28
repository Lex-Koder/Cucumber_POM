package com.example.definitions;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Assert;


//import com.example.actions.ForgotPasswordActions;
import com.example.actions.HomePageActions;
import com.example.actions.LoginPageActions;
import com.example.database.Database;
import com.example.utils.HelperClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
 

public class LoginPageDefinitions {
	LoginPageActions objLogin = new LoginPageActions();
    HomePageActions objHomePage = new HomePageActions();
    Database db = new Database();
    
    @Given("User is on HRMLogin page")
    public void loginTest() {
         
       // HelperClass.openPage(url);
  
    }
  
    @When("User enters username as {string} and password as {string}")
    public void goToHomePage(String userName, String passWord) throws SQLException {
  
        // login to application
        String firstName = db.GetNames();
    	userName = firstName;
        objLogin.login(userName, passWord);
  
        // go the next page
         
    }
     
    @Then("User should be able to login sucessfully and new page open")
    public void verifyLogin() {
  
        // Verify home page
        Assert.assertTrue(objHomePage.getHomePageText().contains("Employee Information"));
  
    }
     
    @Then("User should be able to see error message {string}")
    public void verifyErrorMessage(String expectedErrorMessage) {
  
        // Verify home page
        Assert.assertEquals(objLogin.getErrorMessage(),expectedErrorMessage);
  
    }
     
    @Then("User should be able to see a message {string} below Username")
    public void verifyMissingUsernameMessage(String message) {
         
        Assert.assertEquals(objLogin.getMissingUsernameText(),message);
    }

}
