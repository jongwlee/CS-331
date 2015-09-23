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


public class InsertionSort {

	//Insertion Sort
	public void insertionSort(int[] array){
		for(int i = 1; i < array.length; i++){
			int temp = array[i];
			int j;
			
			for(j = i - 1; j >= 0 && temp < array[j]; j--){
				array[j + 1] = array[j];
			}
			array[j + 1] = temp;
		}
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
		InsertionSort is = new InsertionSort();
		StopWatch timer = new StopWatch();
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter the size: ");
		int size = scanner.nextInt();
		int[] array = new int[size];
		int temp = size;
		
//		makeWorstCase(array, temp);
		makeAverageCase(array);
		
		//Timer
		timer.start();
		is.insertionSort(array);
		timer.stop();
			
	    System.out.println("The time for insertion sort is: " + timer.getElapsedTime());


	}
	
}

