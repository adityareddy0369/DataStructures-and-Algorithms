import java.util.LinkedList;

public class AdjacencyList {
	private LinkedList<Integer>[] adj;
	private int vertices;
	private int edges;

	public AdjacencyList(int nodes) {
		this.vertices = nodes;
		this.edges = 0;
		this.adj = new LinkedList[nodes];
		for (int i = 0; i < vertices; i++) {
			this.adj[i] = new LinkedList<>();
		}
	}

	public static void main(String[] args) {
		AdjacencyList adjList = new AdjacencyList(4);
		adjList.addEdge(0, 1);
		adjList.addEdge(1, 2);
		adjList.addEdge(2, 3);
		adjList.addEdge(3, 0);
		System.out.println(adjList);

	}

	private void addEdge(int i, int j) {
		this.adj[i].add(j);
		this.adj[j].add(i);
		this.edges++;

	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Vertices: " + vertices + " Edges: " + edges + "\n");
		for(int i = 0; i < vertices; i++) {
			sb.append(i + ":");
			for (int value : adj[i]) {
				sb.append(value + " ");
			}
			sb.append("\n");
		}
		return sb.toString();

	}

}
