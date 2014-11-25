package graph;

public class Vertex implements Comparable<Vertex> {
	private int x, y;
	private double minDistance = Double.POSITIVE_INFINITY;
	private Vertex previous;

	public Vertex(int x, int y, Graph myGraph) {
		this.x = x;
		this.y = y;
		myGraph.getListVertex().add(this);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setMinDistance(double minDistance) {
		this.minDistance = minDistance;
	}

	public double getMinDistance() {
		return minDistance;
	}

	public void setPrevious(Vertex previous) {
		this.previous = previous;
	}

	public Vertex getPrevious() {
		return previous;
	}

	@Override
	public int compareTo(Vertex vertex) {
		return Double.compare(minDistance, vertex.minDistance);
	}

	public String getName() {
		return new String("(" + x + " ," + y + ")");
	}
}