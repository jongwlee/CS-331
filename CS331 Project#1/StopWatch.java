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


//Stop Watch to test the time
public class StopWatch {
	private long elapsedTime;
	private long startTime;
	private boolean isRunning;

	public StopWatch(){
		reset();
	}
	
	//Start the timer
	public void start(){
		if(isRunning){
			return;
		}
		
		isRunning = true;
		startTime = System.currentTimeMillis();
	}
	
	//Stop the timer
	public void stop(){
		if(!isRunning){
			return;
		}
		
		isRunning = false;
		long endTime = System.currentTimeMillis();
		elapsedTime = elapsedTime + endTime - startTime;
	}
	
	//Getting the final time
	public long getElapsedTime(){
		if(isRunning){
			long endTime = System.currentTimeMillis();
			return elapsedTime + endTime - startTime;
		}
		
		else{
			return elapsedTime;
		}
	}
	
	//Resetting the timer to 0
	public void reset(){
		elapsedTime = 0;
		isRunning = false;
}
}
