package graph;

public class Edge {
	private Vertex source;
	private Vertex target;
	private double weight;

	public Edge(Vertex source, Vertex target, double weight, Graph myGraph) {
		this.source = source;
		this.target = target;
		this.weight = weight;
		myGraph.getListEdge().add(this);
	}
	
	public Edge(Vertex source, Vertex target, EnumKey zoneType, Graph myGraph) {
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
		myGraph.getListEdge().add(this);
	}
	
	public Vertex getSource(){
		return source;
	}
	
	public Vertex getTarget(){
		return target;
	}
	
	public double getWeight(){
		return weight;
	}
}