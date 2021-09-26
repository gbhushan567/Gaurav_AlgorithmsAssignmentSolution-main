package com.greatlearning.main;

import java.util.Scanner;
import com.greatlearning.services.StockPricesOperations;

/**
 * Driver class with the main function. It will handle all the user interactions
 * It will take all the inputs from the user about stock prices and their trends.
 * 
 * Time Complexity:
 * Sorting : Mergesort - O(nlogn)
 * Number of stocks rise/declined - O(n)
 * Searching Specific stock price : Binary search - O(logn)
 * 
 * Overall time complexity = O(nlogn)
 * 
 * Space Complexity: O(n)
 * 
 */

public class Driver {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Welcome to Stockers' user portal for Stocks informations.");
		System.out.println("Enter the number of companies: ");
		
		int numOfCompanies = input.nextInt();
		int[] stocksArray = new int[numOfCompanies];
		boolean[] priceRisen = new boolean[numOfCompanies];
		
		for (int i = 1; i <= numOfCompanies; i++) {
			System.out.println("Enter current stock price of company " + i + ": ");
			stocksArray[i-1] = input.nextInt();
			
			System.out.println("Whether the companies stock price rose today compared to yesterday? ");
			priceRisen[i-1] = (input.next().equalsIgnoreCase("true"))?true:false;		//Check status true or not
		}
		
		StockPricesOperations ops = new StockPricesOperations(stocksArray, priceRisen);
		
		int choice = -1;
		while (choice != 0) {
			System.out.println("\n-----------------------------------------------\r\n"
					+ "Enter the operation that you want to perform\r\n"
					+ "1. Display the companies stock prices in ascending order\r\n"
					+ "2. Display the companies stock prices in descending order\r\n"
					+ "3. Display the total no of companies for which stock prices rose today\r\n"
					+ "4. Display the total no of companies for which stock prices declined today\r\n"
					+ "5. Search a specific stock price\r\n"
					+ "6. press 0 to exit\r\n"
					+ "-----------------------------------------------");
			
			choice = input.nextInt();
			
			switch (choice) {
			case 1:
				ops.displayStockPricesAscendingOrder();
				break;
				
			case 2:
				ops.displayStockPricesDescendingOrder();
				break;
				
			case 3:
				ops.numOfStockPriceIncrease();
				break;
				
			case 4:
				ops.numOfStockPriceDecrease();
				break;
				
			case 5:
				System.out.println("Enter the Stock value to be searched : ");
				int searchPrice = input.nextInt();
				ops.searchStockPrice(searchPrice);
				break;
				
			case 0:		//exit condition;
				System.out.println("Exited successfully!");
				break;
			
			default:
				System.out.println("Please enter valid option!");
				break;
			}
		}
		
		input.close();
	}

}
