import java.util.LinkedList;
import java.util.Queue;

// Here undirected graph is implemented with AdjacencyList
public class BreadthFirstSearch {
	LinkedList<Integer>[] adj;
	int vertices;
	int edges;

	public BreadthFirstSearch(int nodes) {
		this.vertices = nodes;
		this.edges = 0;
		this.adj = new LinkedList[nodes];
		for (int i = 0; i < vertices; i++) {
			adj[i] = new LinkedList<>();
		}
	}

	public static void main(String[] args) {
		BreadthFirstSearch bfs = new BreadthFirstSearch(5);
		bfs.addEdge(0, 1);
		bfs.addEdge(1, 2);
		bfs.addEdge(2, 3);
		bfs.addEdge(3, 0);
		bfs.addEdge(2, 4);
		bfs.traverse(0);
	}

	private void traverse(int i) {
		boolean[] visited = new boolean[vertices];
		Queue<Integer> queue = new LinkedList<>();
		visited[i] = true;
		queue.offer(i);
		while (!queue.isEmpty()) {
			int j = queue.poll();
			System.out.print(j + " ");
			for (int value : adj[j]) {
				if (!visited[value]) {
					visited[value] = true;
					queue.offer(value);
				}
			}
		}
	}

	private void addEdge(int i, int j) {
		this.adj[i].add(j);
		this.adj[j].add(i);
		this.edges++;
	}

}
