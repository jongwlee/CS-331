// 
// Name: Lee, Jong 
// Project: #1 
// Due: 10/31/14 
// Course: CS 331
// 
// Description: 
// We are to implement the different types of search (Sequential (linear) and Binary) and sorts
// (Selection, Insertion, Merge, & Quick Sort). Project 1 requires us to test the complexities of
// the different algorithms and compare with one another.
//


import java.util.Random;
import java.util.Scanner;


public class QuickSort {

	//QuickSort
	public void quickSort(int[] array, int low, int high){
		int i = low;
		int j = high;
		
		int pivot = array[low + (high - low) / 2];
		
		while(i <= j){
			while(array[i] < pivot){
				i++;
			}
			
			while(array[j] > pivot){
				j--;
			}
			
			if(i <= j){
				swap(array, i, j);
				i++;
				j--;
			}	
		}
		
		if(low < j){
			quickSort(array, low, j);
		}
		
		if(i < high){
			quickSort(array, i, high);
		}
		
	}
	
	//Test for worst case, making pivot the highest or lowest number
	public void wquickSort(int[] array, int low, int high){
		int i = low;
		int j = high;
		
		int pivot = high;
		
		while(i <= j){
			while(array[i] < pivot){
				i++;
			}
			
			while(array[j] > pivot){
				j--;
			}
			
			if(i <= j){
				swap(array, i, j);
				i++;
				j--;
			}	
		}
		
		if(low < j){
			quickSort(array, low, j);
		}
		
		if(i < high){
			quickSort(array, i, high);
		}
		
	}
	
	public void swap(int[] array, int i, int j){
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	//Make worst case by making elements in descending order
	public static void makeWorstCase(int[] array, int temp){
		for(int i = 0; i < array.length; i++){
			array[i] = temp--;
			System.out.println(i + " : " + array[i]);
		}
	}
	
	//Make average case by randoming elements in the array
	public static void makeAverageCase(int[]array){
		Random rand = new Random();
		for(int i = 0; i < array.length; i++){
			array[i] = rand.nextInt(array.length);
			System.out.println(i + " : " + array[i]);
		}
	}
	
	public static void main(String[] args){
		QuickSort qs = new QuickSort();
		StopWatch timer = new StopWatch();
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter the size: ");
		int size = scanner.nextInt();
		int[] array = new int[size];
		int temp = size;
		
		makeWorstCase(array, temp);
//		makeAverageCase(array);
		
		timer.start();
		qs.quickSort(array, 0, array.length - 1);
		timer.stop();
			
	    System.out.println("The time for quick sort is: " + timer.getElapsedTime());


	}
	
}
