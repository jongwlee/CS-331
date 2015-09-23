
public class Edge{
	int source;
	int destination;
	double weight;
	
	public Edge(int source, int destination, double weight){
		this.source = source;
		this.destination = destination;
		this.weight = weight;
	}
	
	public int getSource() {
		return source;
	}

	public int getDestination() {
		return destination;
	}


	public double getWeight() {
		return weight;
	}
	
	public int getAdjacent(int index){
		if(this.source == index){
			return this.destination;
		}
		
		else{
			return this.source;
		}
	}
	
	public int compareTo(Edge edge){
		if(this.weight == edge.weight){
			return 0;
		}
		
		else if(this.weight < edge.weight){
			return -1;
		}
		
		else{
			return 1;
		}
		
	}
	
}
