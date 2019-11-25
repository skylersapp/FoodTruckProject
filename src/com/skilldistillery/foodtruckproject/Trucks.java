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
	private Trucks t = new Trucks(truckName, foodType, truckRating, truckID);

	// CONSTRUCTORS

	public Trucks(String truckName, String foodType, int truckRating, int truckID) {
		this.truckName = truckName;
		this.foodType = foodType;
		this.truckRating = truckRating;
		this.truckID = truckID;
	}

	// METHODS

	public Trucks() {
	}

	public String getTruckName() {
		return truckName;
	}

	public void setTruckName(String truckName) {
		this.truckName = truckName;
	}

	public int getTruckRating() {
		return truckRating;
	}

	public String getFoodType() {
		return foodType;
	}

	public void setFoodType(String foodType) {
		this.foodType = foodType;
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

			System.out.print("Truck " + (i + 1) + ": ");
			truckName = sc.next().toUpperCase();
			if (!truckName.equals("QUIT")) {
				t.setTruckID(i + 1);
				t.setTruckName(truckName);

				System.out.print("Food Type " + (i + 1) + ": ");
				foodType = sc.next();
				t.setFoodType(foodType);

				System.out.print("Rating " + (i + 1) + ": ");
				truckRating = sc.nextInt();
				t.setTruckRating(truckRating);

				t = truckList[i];
			} else {
				break;
			}
		}

	}

	public void userMenu() {
//		int userSelect = 1;
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
					continue;
				} else if (userSelect == 2) {
					averageRating();
					continue;
				} else if (userSelect == 3) {
					highestRated();
					continue;
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
				System.out.println(t.toString());
			}
		}
	}

	public void averageRating() {
		double averageRating = 0.0;
		for (int i = 0; i < truckList.length; i++) {
			if (truckList[i] != null) {
				averageRating = ((t.getTruckRating() + averageRating) / i);
			}
			System.out.println("Average Rating: " + averageRating);
		}
	}

	public void highestRated() {
		for (int i = 0; i < truckList.length; i++) {
			if (truckList[i] != null) {
				if (t.getTruckRating() == 5) {
					System.out.println(t.getTruckName());
					break;
				} else if (t.getTruckRating() >= 4) {
					System.out.println(t.getTruckName());
					break;
				} else if (t.getTruckRating() >= 3) {
					System.out.println(t.getTruckName());
					break;
				} else if (t.getTruckRating() >= 2) {
					System.out.println(t.getTruckName());
					break;
				} else {
					System.out.println(t.getTruckName());
					break;
				}

			}
		}
	}

	@Override
	public String toString() {
		return ("Truck ID: T" + t.getTruckID() + ", Truck Name: " + t.getTruckName() + ", Truck Rating: "
				+ t.getTruckRating() + "\n");
	}

}
