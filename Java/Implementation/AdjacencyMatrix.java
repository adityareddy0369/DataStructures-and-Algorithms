// Undirected graph
public class AdjacencyMatrix {
	int v; // number of vertices in a graph
	int e; // number of edges in a graph
	int[][] adjMatrix;
	
	public AdjacencyMatrix(int nodes) {
		v = nodes;
		e = 0;
		adjMatrix = new int[nodes][nodes];
	}
	
	public static void main(String[] args) {
		AdjacencyMatrix am = new AdjacencyMatrix(4);
		am.addEdge(0,1);
		am.addEdge(1,2);
		am.addEdge(2,3);
		am.addEdge(3,0);
		System.out.println(am);
	}

	public void addEdge(int r, int c) {
		adjMatrix[r][c] = 1;
		adjMatrix[c][r] = 1;
		e++;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(v + "Vertices, " + e + " Edges" + "\n");
		for (int i = 0; i < v; i++) {
			sb.append(i + ":");
			for(int value : adjMatrix[i]) {
				sb.append(value + " ");
			}
			sb.append("\n");
		}
		return sb.toString();
		
	}
	
}
