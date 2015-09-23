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


public class MergeSort {
	
	//Initializes array and makes a sub array
	public void mergeSort(int[] array){
		int[] temp = new int[array.length];
		mergeSort(array, temp, 0, array.length - 1);
	}
	
	private static void mergeSort(int[] array, int[] temp, int left, int right){
		if(left < right){
			int mid = (left + right) / 2;
			mergeSort(array, temp, left, mid);
			mergeSort(array, temp, mid + 1, right);
			merge(array, temp, left, mid + 1, right);
		}
	}
	
	private static void merge(int[] array, int[] temp, int left, int right, int endRight){
		int endLeft = right - 1;
		int n = left;
		int number = endRight - left + 1;
		
		while(left <= endLeft && right <= endRight){
			if(array[left] == array[right]){
				temp[n++] = array[left++];
			}
			else{
				temp[n++] = array[right++];
			}
		}
		
		while(left <= endLeft){
			temp[n++] = array[left++];
		}
		
		while(right <= endRight){
			temp[n++] = array[right++];
		}
		
		for(int i = 0; i < number; i++, endRight--){
			array[endRight] = temp[endRight];
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
		MergeSort ms = new MergeSort();
		StopWatch timer = new StopWatch();
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter the size: ");
		int size = scanner.nextInt();
		int[] array = new int[size];
		int temp = size;
		
//		makeWorstCase(array, temp);
		makeAverageCase(array);
		
		timer.start();
		ms.mergeSort(array);
		timer.stop();
			
	    System.out.println("The time for merge sort is: " + timer.getElapsedTime());


	}
	
}
