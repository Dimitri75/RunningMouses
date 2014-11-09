import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Graph {
	private ArrayList<Vertex> listVertex = null;
	private ArrayList<Edge> listEdge = null;

	public Graph() {
		listVertex = new ArrayList<>();
		listEdge = new ArrayList<>();
	}

	public Graph(ArrayList<Vertex> listVertex, ArrayList<Edge> listEdge) {
		this.listVertex = listVertex;
		this.listEdge = listEdge;
	}

	public ArrayList<Vertex> getListVertex() {
		return listVertex;
	}

	public ArrayList<Edge> getListEdge() {
		return listEdge;
	}

	public List<Vertex> dijkstra(Vertex start, Vertex destination) {
		// ReinitVertex
		for (Vertex vertex : listVertex) {
			vertex.setMinDistance(Double.POSITIVE_INFINITY);
		}

		// ComputePaths
		start.setMinDistance(0.);
		PriorityQueue<Vertex> vertexQueue = new PriorityQueue<Vertex>();
		vertexQueue.add(start);

		while (!vertexQueue.isEmpty()) {
			Vertex current = vertexQueue.poll();

			for (Edge e : getListEdge()) {
				if (e.getSource().compareTo(current) == 0) {
					Vertex v = e.getTarget();
					double weight = e.getWeight();
					double distanceThroughCurrent = current.getMinDistance()
							+ weight;
					if (distanceThroughCurrent < v.getMinDistance()) {
						vertexQueue.remove(v);
						v.setMinDistance(distanceThroughCurrent);
						v.setPrevious(current);
						vertexQueue.add(v);
					}
				}
			}
		}

		// GetShortestPath
		List<Vertex> path = new ArrayList<Vertex>();
		for (Vertex vertex = destination; vertex != null; vertex = vertex.getPrevious())
			path.add(vertex);
		Collections.reverse(path);

		return path;
	}
}