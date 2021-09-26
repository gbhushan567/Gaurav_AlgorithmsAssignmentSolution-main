package com.greatlearning.services;

/**
 * This class will implement the 5 operations available to user:
 * 1. Display the companies stock prices in ascending order
 * 2. Display the companies stock prices in descending order
 * 3. Display the total no of companies for which stock prices rose today
 * 4. Display the total no of companies for which stock prices declined today
 * 5. Search a specific stock price
 *
 */
public class StockPricesOperations {

	private int[] stockPrices;
	private boolean[] priceRisen;
	
	/*
	 * We will store the array values into this object with the help of the constructor.
	 * The constructor would also sort out the array and then we can use the sorted array for further operations.
	 * 
	 */
	public StockPricesOperations(int[] stockPrices0, boolean[] priceRisen0) {
		stockPrices = stockPrices0;
		priceRisen = priceRisen0;
		MergeSort.sort(stockPrices);
	}
	
	/*
	 * Operation 1: Display the companies stock prices in ascending order
	 * The array is already sorted; so the values are printed as it is.
	 * No param required as all required values are already supplied through constructor.
	 */
	public void displayStockPricesAscendingOrder() {
		System.out.println("Stock prices in ascending order are : ");
		for (int i : this.stockPrices)
			System.out.print(i + " ");
		
		System.out.println();
	}
	
	/*
	 * Operation 2: Display the companies stock prices in descending order
	 * The array is sorted in ascending order, so the values are printed in reverse order.
	 * No param required as all required values are already supplied through constructor.
	 */
	public void displayStockPricesDescendingOrder() {
		System.out.println("Stock prices in descending order are : ");
		for (int i = this.stockPrices.length - 1; i > -1; i--)
			System.out.print(this.stockPrices[i] + " ");
		
		System.out.println();
	}
	
	/*
	 * Operation 3: Display the total no of companies for which stock prices rose today
	 * Counter program to find number of 'true' in priceRisen array.
	 * No param required as all required values are already supplied through constructor.
	 */
	public void numOfStockPriceIncrease() {
		int counter = 0;
		for (boolean isRisen : this.priceRisen) {
			if (isRisen)
				counter++;
		}
		
		System.out.println("Total no of companies whose stock price rose today : " + counter);
	}
	
	/*
	 * Operation 4: Display the total no of companies for which stock prices declined today
	 * Counter program to find number of 'false' in priceRisen array.
	 * No param required as all required values are already supplied through constructor.
	 */
	public void numOfStockPriceDecrease() {
		int counter = 0;
		for (boolean isRisen : this.priceRisen) {
			if (!isRisen)
				counter++;
		}
		
		System.out.println("Total no of companies whose stock price declined today : " + counter);
	}
	
	/*
	 * Operation 5: Search a specific stock price
	 * param - targetPrice = Stock price value to be searched in array
	 */
	public void searchStockPrice(int targetPrice) {
		int index = BinarySearch.search(stockPrices, targetPrice);
		
		if (index == -1)
			System.out.println("Value not found");
		else
			System.out.println("Stock of value " + targetPrice + " is present");
	}
	
}
