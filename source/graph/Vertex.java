public class Vertex implements Comparable<Vertex> {
	private String name;
	private double minDistance = Double.POSITIVE_INFINITY;
	private Vertex previous;

	public Vertex(String name, Graph myGraph) {
		this.name = name;
		myGraph.getListVertex().add(this);
	}
	
	public String getName(){
		return name;
	}
	
	public void setMinDistance(double minDistance){
		this.minDistance = minDistance;
	}
	
	public double getMinDistance(){
		return minDistance;
	}
	
	public void setPrevious(Vertex previous){
		this.previous = previous;
	}
	
	public Vertex getPrevious(){
		return previous;
	}

	@Override
	public int compareTo(Vertex vertex) {
		return Double.compare(minDistance, vertex.minDistance);
	}
}