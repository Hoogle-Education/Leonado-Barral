package pgdp.ds;

import java.util.Arrays;

public class SparseGraph implements Graph {

	private SimpleSet[] adjacencyList;

	public SparseGraph(int nodes) {
		adjacencyList = new SimpleSet[nodes + 1];
		Arrays.fill(adjacencyList, new SimpleSet());
	}

	@Override
	public int getNumberOfNodes() {
		return adjacencyList.length - 1;
	}

	@Override
	public void addEdge(int from, int to) {
		adjacencyList[from].add(to);
	}

	@Override
	public boolean isAdj(int from, int to) {
		return adjacencyList[from].contains(to);
	}

	@Override
	public int[] getAdj(int id) {
		if(adjacencyList[id] == null)
			return new int[] {};

		return adjacencyList[id].toArray();
	}

}
