package com;

import java.util.Scanner;

public class CarLotMain {

	public static void main(String[] args) {
		CarLot lot = new CarLot();
		
		

		Scanner input = new Scanner(System.in);
		String prompt = "[0] Exit \n[1] Add a car to inventory \n[2] Sell a car from inventory \n[3] Save To Disk \n[4] Load From Disk \n[5] List inventory by order of acquisition"
				+ "\n[6] List Inventory From Best MPG to Worst MPG \n[7] Display car with best MPG \n[8] Display car with the highest mileage \n[9] Display overall MPG for the entire inventory"
				+ "\n[10] Display profit for all sold cars \n"
				+ "Enter a number from 0 to 10:";

		int option = 0;

		do {
			System.out.println(prompt);
			option = input.nextInt();

			switch (option) {

			case 0: {
				System.out.println("Exiting... Thanks for visiting our carlot! Please come again!");
				System.exit(0);
			}
			case 1: {
				
				System.out.println("Enter Car ID: ");
				String id = input.next();
				System.out.println("Enter Cars Mileage: ");
				int mileage = input.nextInt();
				System.out.println("Enter the Miles Per Gallon: ");
				int mpg = input.nextInt();
				System.out.println("Enter the cost:");
				double cost = input.nextDouble();
				System.out.println("Enter price: ");
				double price = input.nextInt();
				System.out.println("Adding a car to inventory!");
			
				lot.addCar(id, mileage, mpg, cost, price);
				break;
			}
			case 2: {
				System.out.println("Sell a car from inventory");
				System.out.println("Enter id of the car to sell:");
				String idSold = input.next();
				System.out.println("Enter the price sold");
				double priceSold = input.nextDouble();
				lot.sellCar(idSold, priceSold);
				break;
			}
			
			case 3: {
				System.out.println("Save To Disk");
				lot.saveToDisk();
				break;
			}
			case 4: {
				System.out.println("Load From Disk");
				 lot.loadFromDisk();
				break;
			}
			case 5: {
				System.out.println("List inventory by order of acquisition");
				 for (Car c : lot.getCarsInOrderOfEntry())
                     System.out.println(c + "\n");
				break;
			}
			case 6: {
				System.out.println("List Inventory From Best MPG to Worst MPG");
				for (Car c : lot.getCarsSortedByMPG())
                    System.out.println(c + "\n");
				break;
			}
			case 7: {
				System.out.println("Display car with best MPG");
				System.out.println(lot.getCarWithBestMPG() + "\n");
				break;
			}
			case 8: {
				System.out.println("Display car with highest mileage");
				System.out.println(lot.getCarWithHighestMileage() + "\n");
				break;
			}
			case 9:{
				System.out.println("Display overall MPG for the entire inventory");
				System.out.println("Average MPG: " + lot.getAverageMpg() + "\n");
				break;
			}
			case 10:{
				System.out.println("Display profit for all sold cars");
				System.out.println("Total Profit: " + lot.getTotalProfit() + "\n");
				break;
			}

			}
			System.out.println("Type 11 to reach the main menu and choose your next option.");
			option = input.nextInt();
		} while (option >= 0 && option <= 11);
		input.close();
	}

}