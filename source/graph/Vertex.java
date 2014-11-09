
public class Vertex implements Comparable<Vertex> {
	private String name;
	private double minDistance = Double.POSITIVE_INFINITY;
	public Vertex previous;

	public Vertex(String name, Graph myGraph) {
		this.name = name;
		myGraph.getListVertex().add(this);
	}
	
	public void setMinDistance(double minDistance){
		this.minDistance = minDistance;
	}
	
	public String getName(){
		return name;
	}
	
	public double getMinDistance(){
		return minDistance;
	}

	@Override
	public int compareTo(Vertex vertex) {
		return Double.compare(this.minDistance, vertex.minDistance);
	}
}