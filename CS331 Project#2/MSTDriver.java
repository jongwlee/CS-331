import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;


public class MSTDriver {
	public static ArrayList<Edge>[] adjacency_list;
	public static double[][] adjacency_matrix;
	public static int vertex;
	public static int edge;
	public static FileReader file;
	Random random = new Random();
	

	public static void main(String[] args) throws IOException{
		file = new FileReader("random.txt");
		readFile();

			Scanner scanner = new Scanner(System.in);
			MSTDriver driver = new MSTDriver();
			MSTDriver.readFile();
			
			driver.kruskal_dense();
			driver.kruskal_sparse();
			driver.prim_dense();
			driver.prim_sparse();
			
			
	}
		//Testing for sparse graph for Prim's
		public void prim_sparse() throws IOException{
			Graph graph = new Graph();
			graph.createSparseGraph();
			int vertex = graph.getVertex();
			int edge = graph.getEdge();
			adjacency_list = graph.getAdjacencyList();
			adjacency_matrix = graph.getAdjacencyMatrix();
			
			System.out.println("-----------Testing Prim's Sparse-----------");
			Prims prim = new Prims(adjacency_list, adjacency_matrix, vertex, edge);
			
			//The time to create Prim's List
			long start_time = System.nanoTime();
			prim.prim_list();
			long end_time = System.nanoTime();
			long result_time = end_time - start_time;
			System.out.println("The time to create a list using Prim's Algorithm is: " + result_time);
			
			//The time to create Prim's matrix
			start_time = System.nanoTime();
			prim.prim_matrix();
			end_time = System.nanoTime();
			result_time = end_time - start_time;
			System.out.println("The time to create a matrix using Prim's Algorithm is: " + result_time + "\n");
		}
		
		
		//Testing for dense graph for Prim's
		public void prim_dense(){
			Graph graph = new Graph();
			graph.createDenseGraph();
			int vertex = graph.getVertex();
			int edge = graph.getEdge();
			adjacency_list = graph.getAdjacencyList();
			adjacency_matrix = graph.getAdjacencyMatrix();
			
			System.out.println("-----------Testing Prim's Dense-----------");
			Prims prim = new Prims(adjacency_list, adjacency_matrix, vertex, edge);
			
			//The time to create Prim's List
			long start_time = System.nanoTime();
			prim.prim_list();
			long end_time = System.nanoTime();
			long result_time = end_time - start_time;
			System.out.println("The time to create a list using Prim's Algorithm is: " + result_time);
			
			//The time to create Prim's matrix
			start_time = System.nanoTime();
			prim.prim_matrix();
			end_time = System.nanoTime();
			result_time = end_time - start_time;
			System.out.println("The time to create a list using Prim's Algorithm is: " + result_time + "\n");
		}
		
		
		//Testing for sparse graph for Prim's
		public void kruskal_sparse() throws IOException{
			Graph graph = new Graph();
			graph.createSparseGraph();
			int vertex = graph.getVertex();
			int edge = graph.getEdge();
			adjacency_list = graph.getAdjacencyList();
			adjacency_matrix = graph.getAdjacencyMatrix();
			
			System.out.println("-----------Testing Kruskal's Sparse-----------");
			Kruskals kruskal = new Kruskals(adjacency_list, adjacency_matrix, vertex, edge);
			
			//The time to create Kruskal's List
			kruskal.create_list();
			long start_time = System.nanoTime();
			kruskal.kruskal();
			long end_time = System.nanoTime();
			long result_time = end_time - start_time;
			System.out.println("The time to create a list using Kruskal's Algorithm is: " + result_time);
			
			//The time to create Kruskal's matrix
			kruskal.create_matrix();
			start_time = System.nanoTime();
			kruskal.kruskal();
			end_time = System.nanoTime();
			result_time = end_time - start_time;
			System.out.println("The time to create a matrix using Kruskal's Algorithm is: " + result_time + "\n");
		}
		
		
		//Testing for sparse graph for Prim's
			public void kruskal_dense(){
				Graph graph = new Graph();
				graph.createDenseGraph();
				int vertex = graph.getVertex();
				int edge = graph.getEdge();
				adjacency_list = graph.getAdjacencyList();
				adjacency_matrix = graph.getAdjacencyMatrix();
				
				System.out.println("-----------Testing Kruskal's Dense-----------");
				Kruskals kruskal = new Kruskals(adjacency_list, adjacency_matrix, vertex, edge);
				
				//The time to create Kruskal's List
				kruskal.create_list();
				long start_time = System.nanoTime();
				kruskal.kruskal();
				long end_time = System.nanoTime();
				long result_time = end_time - start_time;
				System.out.println("The time to create a list using Kruskal's Algorithm is: " + result_time);
				
				//The time to create Kruskal's matrix
				kruskal.create_matrix();
				start_time = System.nanoTime();
				kruskal.kruskal();
				end_time = System.nanoTime();
				result_time = end_time - start_time;
				System.out.println("The time to create a list using Kruskal's Algorithm is: " + result_time + "\n");
			}
		
//		kruskal.useAdjMatrix();
//		beginTime=System.nanoTime();
//		kruskal.kruskal();
//		endTime=System.nanoTime();
//		//kruskal.printMST();
//		diff = endTime - beginTime;
//		System.out.println( "Time in Nano: " + diff + "\n");

	
		//Test to create a text file
//		public void writeFile(){
//			try 
//			{
//				PrintWriter out = new PrintWriter(new File("testing.txt"));
//				Random random = new Random();
//				
//				out.println("300");
//				out.println("1000");
//				
//				for(int i = 0; i < 300; i++){
//					out.println(random.nextInt(300) + " " + random.nextInt(300) + " " + random.nextDouble(30));
//				}
//				out.close();
//			} 
//			catch (FileNotFoundException e) 
//			{
//				e.printStackTrace();
//			}
//			
//		}
	
		public static void readFile() throws NumberFormatException, IOException{
			BufferedReader br = new BufferedReader(file);
			StringTokenizer token;
			
			vertex = Integer.parseInt(br.readLine());
			edge = Integer.parseInt(br.readLine());
			
			adjacency_list = new ArrayList[vertex + 1];
			adjacency_matrix = new double[vertex + 1][vertex + 1];
			for(int i = 1; i <= vertex; i++){ 
				adjacency_list[i] = new ArrayList<Edge>();
			}
			
			for(int i = 1; i <= edge ;i++){
				token = new StringTokenizer(br.readLine(), " ");
				int vert = Integer.parseInt(token.nextToken());
				int e = Integer.parseInt(token.nextToken());
				double weight = Double.parseDouble( token.nextToken() );
				vert += 1;
				e += 1;
				if(adjacency_matrix[vert][e] ==0 || adjacency_matrix[vert][e] > weight){
					adjacency_list[vert].add(new Edge(vert, e, weight));
					adjacency_list[e].add(new Edge(e, vert, weight));	
					adjacency_matrix[vert][e] = weight;
					adjacency_matrix[e][vert] = weight;
				}
				
			}
			
		}
}