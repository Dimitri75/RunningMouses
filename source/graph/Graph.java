import java.util.ArrayList;

public class Graph {
	private ArrayList<Vertex> listVertex = null;
	private ArrayList<Edge> listEdge = null;
	
	public Graph(){
		listVertex = new ArrayList<>();
		listEdge = new ArrayList<>();
	}
	
	public Graph(ArrayList<Vertex> listVertex, ArrayList<Edge> listEdge){
		this.listVertex = listVertex;
		this.listEdge = listEdge;
	}
	
	class Vertex implements Comparable<Vertex> {
		public String name;
		public ArrayList<Edge> neighbors = null;

		public Vertex(String name) {
			this.name = name;
			listVertex.add(this);
		}
		
		@Override
		public int compareTo(Vertex o) {
			return 0;
		}
		
		public void setNeighbor(Vertex target, Zone zoneType){
			if (neighbors == null) neighbors = new ArrayList<>();
			Edge e = new Edge(this, target, zoneType);
			neighbors.add(e);
		}
	}

	class Edge {
		public Vertex source;
		public Vertex target;
		public double weight;

		public Edge(Vertex source, Vertex target) {
			this.source = source;
			this.target = target;
			weight = 1;
			listEdge.add(this);
		}

		public Edge(Vertex source, Vertex target, Zone zoneType) {
			this.source = source;
			this.target = target;

			switch (zoneType) {
			case NORMAL:
				this.weight = 1;
				break;
			case GRASS:
				this.weight = 2;
				break;
			default:
				this.weight = 1;
				break;
			}
			listEdge.add(this);
		}

		public Edge(Vertex source, Vertex target, double weight) {
			this.source = source;
			this.target = target;
			this.weight = weight;
			listEdge.add(this);
		}
	}

	public enum Zone {
		NORMAL, GRASS;
	}
}
