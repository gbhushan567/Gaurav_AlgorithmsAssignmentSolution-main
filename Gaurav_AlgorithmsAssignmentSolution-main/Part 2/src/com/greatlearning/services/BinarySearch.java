package com.greatlearning.services;

/*
 * Implementation of Binary search
 */

public class BinarySearch {

	/*
	 * Searching function
	 * params :
	 * 	arr - array to be searched
	 * 	num - number that s being searched
	 * 
	 * returns index of target number or else -1 if num not present in array;
	 */
	public static int search(int[] arr, int num) {
		return binarySearch(arr, 0, arr.length-1, num);
	}
	
	/*
	 * Utility function that will be used within the class
	 * Implementating binary search
	 */
	public static int binarySearch(int[] arr, int start, int end, int num) {
		if (start < end) {
			int mid = (start + end) / 2;
			
			if (arr[mid] == num)
				return mid;
			else if (arr[mid] > num)
				return binarySearch(arr, start, mid-1, num); //if arr[mid] is larger then search left half of the array
			else
				return binarySearch(arr, mid+1, end, num);	//if arr[mid] is smaller then search right half of the array
		}
		
		return -1; //in case start > end ie num was not found
	}
}
