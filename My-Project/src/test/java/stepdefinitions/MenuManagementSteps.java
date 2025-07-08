package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MenuManagementSteps {
@Given("I have a menu item with name {string} and price {int}")
public void I_have_a_menu_item_with_name_and_price(String newMenuItemName, Integer price) {
	RestaurantMenuItem NewMenuItem;
	NewMenuItem = new RestaurantMenuItem("");
	
}

@When("I add that menu item")
public void I_add_that_menu_item() {
	
}

@Then("Menu Item with name {string} should be added")
public void Menu_Item_with_name(String string) {
	
}
}
