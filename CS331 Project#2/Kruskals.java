import java.util.ArrayList;
import java.util.PriorityQueue;


public class Kruskals{
	private ArrayList<Edge>[] adjacency_list;
	private ArrayList<Edge> minimum_span;
	private PriorityQueue<Edge> queue;
	private double[][] adjacency_matrix;
	private boolean[] visited;
	private int[] distance;
	private int[] previous;
	private int vertex;
	private int edge;
	private double cost = 0;
	
	
	
	public Kruskals(ArrayList<Edge>[] adjacency_list, double[][] adjacency_matrix, int vertex, int edge){
		this.adjacency_list = adjacency_list;
		this.adjacency_matrix = adjacency_matrix;
		this.vertex = vertex;
		this.edge = edge;
		
	}
	
	
	public void create_matrix(){
		queue = new PriorityQueue<Edge>();
		for(int i = 1; i <= vertex; i++){
			for(int j = 1; j <= vertex; j++){
				if(adjacency_matrix[i][j] != 0){
					queue.add(new Edge(i, j, adjacency_matrix[i][j]));
				}
			}
		}
		
	}
	
	
	public void create_list(){
		queue = new PriorityQueue<Edge>();
		
		for(int i = 1 ; i <= vertex; i++){
			for(int j = 0 ; j < adjacency_list[i].size(); j++){
				if(adjacency_list[i].get(j).weight != 0 ){
					queue.add(adjacency_list[i].get(j));
				}
			}
		}
	}
	
	
	public void combine(int number1, int number2) {
		previous[check(number1)] = check(number2);
	}
	
	
	public int check(int number) {
		if (previous[number] == number) {
			return number;
		}

		return previous[number] = check(previous[number]);
	}
	
	
	//Build using Kruskal's algorithm
	public void kruskal(){
		cost = 0;
		previous = new int[vertex + 1];
		
		for(int i = 1; i <= vertex; i++){
			previous[i] = i;
		}
		
		minimum_span = new ArrayList<Edge>();
		
		while(!queue.isEmpty() && minimum_span.size() != (vertex - 1)){
			
			Edge e = queue.poll();
			if(check(e.source) != check(e.destination)){
				minimum_span.add(e);
				cost += e.weight;
				combine(e.source, e.destination);
			}
			
		}
		
		System.out.println("The minimum cost is: " + cost);
	}
	
	
	public void print_minimum_span(){
		for(int i = 0; i < minimum_span.size(); i++){
			Edge e = minimum_span.get(i);
			System.out.println("From: " + e.source + " To: " + e.destination + " Weight: " + e.weight);
		}
		System.out.println("The cost is: " + cost);	
	}
}