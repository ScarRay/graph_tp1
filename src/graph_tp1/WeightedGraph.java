package graph_tp1;

public interface WeightedGraph <V,E> extends Graph {
		boolean addEdge (V fromVertex, V toVertex, E edge);
}
