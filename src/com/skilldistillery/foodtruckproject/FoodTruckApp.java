package com.skilldistillery.foodtruckproject;

// User Story #1
// The user is prompted to input the name, food type, and rating for up to five food trucks. 
// For each set of input, a FoodTruck object is created, its fields set to the user's input, and it is added 
// to the array. The truck id is not input by the user, but instead assigned automatically in the FoodTruck 
// constructor from a static field that is incremented as each truck is created.
//
// User Story #2
// If the user inputs quit for the food truck name, input ends immediately and the program continues.
//
// User Story #3
// After input is complete, the user sees a menu from which they can choose to:
//
// List all existing food trucks.
// See the average rating of food trucks.
// Display the highest-rated food truck.
// Quit the program.
//
// User Story #4
// After choosing a menu item, the user sees the menu again and can choose another item until the choose to quit.

public class FoodTruckApp {
	
	// FIELDS
	
	// CONSTRUCTORS
	
	// METHODS

	public static void main(String[] args) {
		System.out.println(
				"\nPlease enter up to five Food Trucks by name, the type of food, and your numerical review of them (0-5). ");
		System.out.println("You can also quit entering trucks by typing \"QUIT\" for any truck name. ");
		Trucks trucks = new Trucks();
		trucks.userInput();
		trucks.userMenu();
		
	}

}
