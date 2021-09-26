package com.greatlearning.services;

/*
 * Implementing mergesort to sort the array in ascending order.
 * 
 * public static void sort(int[] arr)  => It is the function we will call to sort the array.
 * 
 */

public class MergeSort {

	public static void merge(int[] arr, int left, int right, int mid) {
		int leftSize = mid - left + 1;
		int rightSize = right - mid;
		
		int[] leftArr = new int[leftSize];
		int[] rightArr = new int[rightSize];
		
		for (int i = 0; i < leftSize; i++) 
			leftArr[i] = arr[left + i];
		
		for (int i = 0; i < rightSize; i++)
			rightArr[i] = arr[mid + 1 + i];
		
		int i = 0, j = 0, k = left;
		while (i < leftSize && j < rightSize) {
			if (leftArr[i] < rightArr[j]) {
				arr[k] = leftArr[i];
				i++;
			}
			else {
				arr[k] = rightArr[j];
				j++;
			}
			k++;
		}
		
		while (i < leftSize) {
			arr[k] = leftArr[i];
			i++; k++;
		}
		
		while (j < rightSize) {
			arr[k] = rightArr[j];
			j++; k++;
		}
		
	}
	
	public static void mergesort(int[] arr, int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			
			mergesort(arr, left, mid);
			mergesort(arr, mid+1, right);
			
			merge(arr, left, right, mid);
		}
	}
	
	public static void sort(int[] arr) {
		mergesort(arr, 0, arr.length-1);
	}
}
