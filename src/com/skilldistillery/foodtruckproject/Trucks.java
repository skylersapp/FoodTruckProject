package com.skilldistillery.foodtruckproject;

import java.util.Scanner;

public class Trucks {

	// FIELDS

	Scanner sc = new Scanner(System.in);
	private Trucks[] truckList = new Trucks[5];
	private int truckID;
	private String truckName;
	private String foodType;
	private int truckRating;

	// CONSTRUCTORS

	public Trucks() {
	}

	public Trucks(String truckName, String foodType, int truckRating, int truckID) {
		this.truckName = truckName;
		this.foodType = foodType;
		this.truckRating = truckRating;
		this.truckID = truckID;
	}

	// METHODS

	public String getTruckName() {
		return truckName;
	}

	public void setTruckName(String truckName) {
		this.truckName = truckName;
	}

	public String getFoodType() {
		return foodType;
	}

	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}

	public int getTruckRating() {
		return truckRating;
	}

	public void setTruckRating(int truckRating) {
		this.truckRating = truckRating;
	}

	public int getTruckID() {
		return truckID;
	}

	public void setTruckID(int truckID) {
		this.truckID = truckID;
	}

	public void userInput() {
		for (int i = 0; i < truckList.length; i++) {
			Trucks t = new Trucks(truckName, foodType, truckRating, truckID);
			int nonZero = (i + 1);
			System.out.print("Truck " + nonZero + ": ");

			truckName = sc.next().toUpperCase();
			if (!truckName.equals("QUIT")) {
				t.setTruckID(nonZero);
				t.setTruckName(truckName);

				System.out.print("Food Type " + (i + 1) + ": ");
				foodType = sc.next().toUpperCase();
				t.setFoodType(foodType);

				System.out.print("Rating " + (i + 1) + ": ");
				truckRating = sc.nextInt();
				t.setTruckRating(truckRating);

				truckList[i] = t;
			} else {
				break;
			}
		}

	}

	public void userMenu() {
		boolean keepGoing = true;

		while (keepGoing == true) {
			System.out.println("\n-----| MENU |-----\n");
			System.out.println("1) List all existing food trucks.\n" + "2) See the average rating of food trucks.\n"
					+ "3) Display the highest-rated food truck.\n" + "4) Quit the program.");
			System.out.print("\t>: ");
			int userSelect = sc.nextInt();
			do {
				if (userSelect == 1) {
					listTrucks();
					break;
				} else if (userSelect == 2) {
					averageRating();
					break;
				} else if (userSelect == 3) {
					highestRated();
					break;
				} else if (userSelect == 4) {
					System.out.println("Thank you for for your time!\nHave a great day!");
					keepGoing = false;
					break;
				} else {
					System.out.println("INVALID SELECTION\n Please make another selection (1-4).");
					System.out.print("\t>: ");
					userSelect = sc.nextInt();
				}
			} while (userSelect != 4);
		}
	}

	public void listTrucks() {
		for (int i = 0; i < truckList.length; i++) {
			if (truckList[i] != null) {
				System.out.println(truckList[i].toString());
			} else {
				break;
			}
		}
	}

	public void averageRating() {
		double averageRating = 0.0;
		int counter = 0;

		for (int i = 0; i < truckList.length; i++) {
			if (truckList[i] == null) {
				break;
			}
			counter++;
			averageRating = ((truckList[i].getTruckRating() + averageRating));
		}
		averageRating = averageRating / counter;
		System.out.println("Average Rating: " + averageRating);
	}

	public void highestRated() {
		int largestNum = Integer.MIN_VALUE;
		String highestTruck = "";

		for (Trucks trucks : truckList) {

			if (trucks != null) {
				if (trucks.getTruckRating() > largestNum) {
					largestNum = trucks.getTruckRating();
					highestTruck = trucks.toString();
					
				}
			} else {
				continue;
			}
		}
		System.out.println(highestTruck);

	}

	@Override
	public String toString() {
		Trucks t = new Trucks(truckName, foodType, truckRating, truckID);
		return ("Truck ID: T" + t.getTruckID() + ", Truck Name: " + t.getTruckName() + ", Truck Food Type: "
				+ t.getFoodType() + ", Truck Rating: " + t.getTruckRating() + "\n");
	}

}
