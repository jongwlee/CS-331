import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;


public class Graph {
	
	private int vertex = 1000;
	private int edge;
	private ArrayList<Edge>[] adjacency_list;
	private double[][] adjacency_matrix;
	
	//Creates a Dense Graph
	public void createDenseGraph(){
		edge = 0;
		adjacency_list = new ArrayList[vertex+1];
		adjacency_matrix = new double[vertex+1][vertex+1];
		
		for(int i = 1; i <= vertex; i++){ 
			adjacency_list[i] = new ArrayList<Edge>();
		}
		
		
		Random random = new Random();
		
		for(int i = 1; i <= vertex; i++){
			for(int j = i + 1; j <= vertex; j++){
				double weight = 1 + random.nextInt(1000);
				adjacency_list[i].add(new Edge(i, j, weight));
				adjacency_list[j].add(new Edge(j, i, weight));
				adjacency_matrix[i][j] = weight;
				adjacency_matrix[j][i] = weight;
				edge += 1;
			}
		}
		
		System.out.println("Created Dense graph \n");
	}
	
	//Creates a Sparse Graph
	public void createSparseGraph() throws IOException{
		
		int bound = (vertex * (vertex-1)) / 4;
		
		edge = 0;
		adjacency_list = new ArrayList[vertex + 1];
		adjacency_matrix = new double[vertex + 1][vertex + 1];
		boolean[] visited = new boolean[vertex + 1];
		
		for(int i = 1; i <= vertex; i++){ 
			adjacency_list[i] = new ArrayList<Edge>();
		}
		
		Random first_random = new Random();
		
		for(int i = 1; i < vertex; i++){
			double weight = 1 + first_random.nextInt(1000);
			adjacency_list[i].add(new Edge(i , i + 1, weight));
			adjacency_list[i + 1].add(new Edge(i + 1 , i, weight));
			
			adjacency_matrix[i][i + 1] = weight;
			adjacency_matrix[i + 1][i] = weight;
			
			edge += 1;
		}
		
		Random second_random = new Random();
		while(edge < bound){
			double w = 1 + second_random.nextInt(1000);
			int source = 1 + second_random.nextInt(vertex);
			int destination = 1 + second_random.nextInt(vertex);
			
			if(source != destination && adjacency_matrix[source][destination] == 0){
				adjacency_list[source].add(new Edge(source, destination, w));
				adjacency_list[destination].add(new Edge(destination, source, w));
				
				adjacency_matrix[source][destination] = w;
				adjacency_matrix[destination][source] = w;
				edge += 1;
			}
			
		}
		
		System.out.println("Created Sparse Graph \n");
	}
	
	public void printAdjList(){
		for(int i = 1; i < adjacency_list.length; i++){
			for(int j = 0; j < adjacency_list[i].size(); j++){
				Edge e = adjacency_list[i].get(j);
				System.out.println("Source: " + e.source + " Destination: " + e.destination + " Weight: " + e.weight);
			}
		}
		
	}
	
	public void printAdjMatrix(){
		for(int i = 1; i < adjacency_matrix.length; i++){
			for(int j = 1; j < adjacency_matrix[i].length; j++){
				if(adjacency_matrix[i][j] != 0 ){
					System.out.println("Source: " + i + " Destination: " + j + " Weight: " + adjacency_matrix[i][j] );
				}
			}
		}
		
	}
	
	public void setVertex(int vertex){
		this.vertex = vertex;
	}
	
	public ArrayList<Edge>[] getAdjacencyList(){
		return adjacency_list;
	}
	
	public double[][] getAdjacencyMatrix(){
		return adjacency_matrix;
	}
	
	public int getVertex(){
		return vertex;
	}
	
	public int getEdge(){
		return edge;
	}
	
	
}