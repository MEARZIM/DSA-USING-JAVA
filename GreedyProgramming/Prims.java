package GreedyProgramming;

import java.util.Arrays;

public class Prims {
	private static final int V = 5; // Number of vertices

	// Utility function to find the vertex with minimum key value
	private int minKey(int[] key, boolean[] mstSet) {
		int min = Integer.MAX_VALUE, minIndex = -1;

		for (int v = 0; v < V; v++) {
			if (!mstSet[v] && key[v] < min) {
				min = key[v];
				minIndex = v;
			}
		}

		return minIndex;
	}

	// Function to print the constructed MST stored in parent[]
	private void printMST(int[] parent, int[][] graph) {
		System.out.println("Edge   Weight");
		for (int i = 1; i < V; i++) {
			System.out.println(parent[i] + " - " + i + "    " + graph[i][parent[i]]);
		}
	}

	// Function to construct and print MST for a graph represented using adjacency
	// matrix representation
	public void primMST(int[][] graph) {
		int[] parent = new int[V]; // Array to store constructed MST
		int[] key = new int[V]; // Key values used to pick minimum weight edge in cut
		boolean[] mstSet = new boolean[V]; // To represent set of vertices included in MST

		// Initialize all keys as INFINITE
		Arrays.fill(key, Integer.MAX_VALUE);

		// Always include first vertex in MST
		key[0] = 0;
		parent[0] = -1; // First node is always root of MST

		// The MST will have V vertices
		for (int count = 0; count < V - 1; count++) {
			// Pick the minimum key vertex from the set of vertices not yet included in MST
			int u = minKey(key, mstSet);

			// Add the picked vertex to the MST Set
			mstSet[u] = true;

			// Update key and parent arrays of the adjacent vertices of the picked vertex
			for (int v = 0; v < V; v++) {
				// Update key[v] if graph[u][v] is smaller than key[v] and v is not yet included
				// in MST
				if (graph[u][v] != 0 && !mstSet[v] && graph[u][v] < key[v]) {
					parent[v] = u;
					key[v] = graph[u][v];
				}
			}
		}

		// Print the constructed MST
		printMST(parent, graph);
	}

	public static void main(String[] args) {
		/*
		 * Let us create the following graph 2 3 (0)--(1)--(2) | / \ | 6| 8/ \5 |7 | / \
		 * | (3)-------(4) 9
		 */
		int[][] graph = new int[][] { { 0, 2, 0, 6, 0 }, { 2, 0, 3, 8, 5 }, { 0, 3, 0, 0, 7 }, { 6, 8, 0, 0, 9 },
				{ 0, 5, 7, 9, 0 } };

		Prims t = new Prims();
		t.primMST(graph);
	}
}
