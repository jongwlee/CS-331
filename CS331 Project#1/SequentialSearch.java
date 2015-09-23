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


public class SequentialSearch {
	
	//Sequential Search
	public int sequentialSearch(int[] array, int size, int target){
		for(int i = 0; i < size; i++){
			if(array[i] == target){
				return i;
			}
		}
		return -1;
	}
	
	//Make arrays in descending order
	public static void makeWorstCase(int[] array, int temp){
		for(int i = 0; i < array.length; i++){
			array[i] = temp--;
		}
	}
	
	
	public static void main(String[] args){
		SequentialSearch ss = new SequentialSearch();
		StopWatch timer = new StopWatch();
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter the size: ");
		int size = scanner.nextInt();
		int temp = size;
		Random rand = new Random();
		
		int[] array = new int[size];
		
		for(int i = 0; i < array.length; i++){
			array[i] = rand.nextInt(array.length);
			if(array[i] == 23){
				array[i] = rand.nextInt(array.length);
			}
			System.out.println(i + " : " + array[i]);
		}
		
		//Make last value the element we are looking for worst case
		array[size - 1] = 23;
		
		//Used to calculate time
		long startTime = System.nanoTime();
		ss.sequentialSearch(array, size, 23);
		long endTime = System.nanoTime();
		   	
		long calculatedTime = endTime - startTime;
		System.out.println("The time is: " + calculatedTime);
		   
	}
	
}
