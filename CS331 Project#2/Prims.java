import java.util.ArrayList;
import java.util.PriorityQueue;

public class Prims {
	private ArrayList<Edge>[] adjacency_list;
	private boolean[] visited;
	private PriorityQueue<Edge> queue;
	private double[][] adjacency_matrix;
	private ArrayList<Edge> minimum_span;
	private double[] distance;
	private int[] previous;
	private int vert;
	private int edge;
	private double cost = 0;
	
	
	public Prims(ArrayList<Edge>[] adjacency_list, double[][] adjacency_matrix, int vertex, int edge){
		this.adjacency_list = adjacency_list;
		this.adjacency_matrix = adjacency_matrix;
		this.vert = vertex;
		this.edge = edge;
	}
	
	
	//Make matrix using the Prim's algorithm
	//Complexity:  O(V^2)
	public void prim_matrix(){
		cost = 0;
		minimum_span = new ArrayList<Edge>();
		visited = new boolean[vert + 1];
		distance = new double[vert + 1];
		int[] parent = new int[vert + 1];
		int vertex = 1;
		
		for(int i = 1; i <= vert; i++){
			distance[i] = Integer.MAX_VALUE;
		}
		
		for(int i = 1; i < vert; i++){
			visited[vertex] = true;
			double minimum_distance = Double.MAX_VALUE;
			int minimum_vertex = -1;
			
			for(int j = 1; j <= vert; j++){
				if(!visited[j]){
					double dist = adjacency_matrix[vertex][j];
					if(dist > 0){
						if(dist < distance[j]){
						distance[j] = adjacency_matrix[vertex][j];
						parent[j] = vertex;
						}
 					}
					
					if(distance[j] < minimum_distance){
						minimum_distance = distance[j];
						minimum_vertex = j;
					}
				}
			}
			
			minimum_span.add(new Edge(parent[minimum_vertex], minimum_vertex, adjacency_matrix[parent[minimum_vertex]][minimum_vertex]));
			vertex = minimum_vertex;
			cost += distance[vertex];
			
		}
		System.out.println("The minimum cost is: " + cost);
		
	}
	
	//Make list using the Prim's algorithm
	//Complexity: O((|V| + |E|) log |V|) = O(|E| log |V|)
	public void prim_list(){
		cost = 0;
		minimum_span = new ArrayList<Edge>();
		visited = new boolean[vert + 1];
		queue = new PriorityQueue<Edge>();
		queue.add(new Edge(-1, 1, 0));
		
		while(!queue.isEmpty()){
			Edge e = queue.poll();
			
			if(!visited[e.destination]){
				visited[e.destination] = true;
				cost += e.weight;
				
				
				if(e.source != -1){
					minimum_span.add(e);
				}
				
				for(int i = 0; i < adjacency_list[e.destination].size(); i++){
					Edge newEdge = adjacency_list[e.destination].get(i);
					if(!visited[newEdge.destination] && newEdge.weight != 0){
						queue.add(newEdge);
					}
				}
			}
		}
		System.out.println("The minimum cost is: " + cost);
	}
	
	//Print the tree
	public void print_tree(){
		cost = 0;
		for(int i = 0; i < minimum_span.size(); i++){
			Edge e = minimum_span.get(i);
			if(e.source != -1){
				System.out.println("From: " + e.source + " To: " + e.destination + " Weight: " + e.weight);
				cost += e.weight;
			}
		}
		System.out.println("The cost is: " + cost);
	}
}