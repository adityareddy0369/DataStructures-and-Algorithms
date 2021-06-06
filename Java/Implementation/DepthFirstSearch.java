import java.util.LinkedList;
import java.util.Stack;

// Here undirected graph is implemented with AdjacencyList
public class DepthFirstSearch {
	LinkedList<Integer>[] adj;
	int vertices;
	int edges;

	public DepthFirstSearch(int nodes) {
		this.vertices = nodes;
		this.edges = 0;
		this.adj = new LinkedList[nodes];
		for (int i = 0; i < vertices; i++) {
			adj[i] = new LinkedList<>();
		}
	}

	public static void main(String[] args) {
		DepthFirstSearch bfs = new DepthFirstSearch(5);
		bfs.addEdge(0, 1);
		bfs.addEdge(1, 2);
		bfs.addEdge(2, 3);
		bfs.addEdge(3, 0);
		bfs.addEdge(2, 4);
		bfs.traverse(0);
	}

	private void traverse(int i) {
		boolean[] visited = new boolean[vertices];
		Stack<Integer> stack = new Stack();
		stack.push(i);
		while (!stack.isEmpty()) {
			int j = stack.pop();
			if (!visited[j]) {
				visited[j] = true;
				System.out.print(j + " ");
				for (int value : adj[j]) {
					if (!visited[value]) {
						stack.push(value);
					}
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
