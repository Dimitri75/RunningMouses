public class Main {
	public static void main(String[] args) {
		// Exemple du Graph Wikipedia
		// http://fr.wikipedia.org/wiki/Algorithme_de_Dijkstra
		Graph myGraph = new Graph();

		Vertex a = new Vertex("A", myGraph);
		Vertex b = new Vertex("B", myGraph);
		Vertex c = new Vertex("C", myGraph);
		Vertex d = new Vertex("D", myGraph);
		Vertex e = new Vertex("E", myGraph);
		Vertex f = new Vertex("F", myGraph);
		Vertex g = new Vertex("G", myGraph);
		Vertex h = new Vertex("H", myGraph);
		Vertex i = new Vertex("I", myGraph);
		Vertex j = new Vertex("J", myGraph);

		new Edge(a, b, 85, myGraph);
		new Edge(a, c, 217, myGraph);
		new Edge(a, e, 173, myGraph);
		new Edge(b, f, 80, myGraph);
		new Edge(c, g, 186, myGraph);
		new Edge(c, h, 103, myGraph);
		new Edge(d, h, 183, myGraph);
		new Edge(e, j, 502, myGraph);
		new Edge(f, i, 250, myGraph);
		new Edge(h, j, 167, myGraph);
		new Edge(i, j, 84, myGraph);

		for (Vertex v : myGraph.dijkstra(a, j)) {
			System.out.println(v.getName());
		}
	}
}