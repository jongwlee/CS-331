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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class SelectionSort {

	//Selection Sort
	public void selectionSort(int[] array){
		for(int i = 0; i < array.length; i++){
			int minimumPosition = i;
			for(int j = i + 1; j < array.length; j++){
				if(array[j] < array[minimumPosition]){
					minimumPosition = j;
				}
			}
			swap(array,minimumPosition,i);
		}
	}	
	
	//Swap values
	private static void swap(int[] array, int i, int j){
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
		SelectionSort select = new SelectionSort();
		StopWatch timer = new StopWatch();
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter the size: ");
		int size = scanner.nextInt();
		int[] array = new int[size];
		int temp = size;
		
		makeWorstCase(array, temp);
//		makeAverageCase(array);
		
		timer.start();
		select.selectionSort(array);
		timer.stop();
			
	    System.out.println("The time for selection sort is: " + timer.getElapsedTime());


	}
}
