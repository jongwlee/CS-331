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
import java.util.Random;
import java.util.Scanner;


public class BinarySearch {
	
	//Recursive binary search
	public int binarySearch(int[] array, int key, int low, int high){
		if(low > high){
			return -1;
		}
		else{
			int mid = (low + high) / 2;
			if(key == array[mid]){
				return mid;
			}
			else if(array[mid] > key){
				return binarySearch(array, key, low, mid-1);
			}
			
			else{
				return binarySearch(array, key, mid+1, high);
			}
		}
	}
	
	
	public static void main(String[] args){
		BinarySearch bs = new BinarySearch();
		StopWatch timer = new StopWatch();
		
		//Ask user to input the size
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter the size: ");
		int size = scanner.nextInt();
		
		int temp = size;
		Random rand = new Random();
		
		int[] array = new int[size];
		
		//Putting random values
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
		bs.binarySearch(array, 23, 0, size - 1);
		long endTime = System.nanoTime();
		   	
		long calculatedTime = endTime - startTime;
		System.out.println("The time is: " + calculatedTime);
		   
	}
	
}
