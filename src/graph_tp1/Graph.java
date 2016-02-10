package graph_tp1;
import java.util.Set;

public interface Graph {
	boolean addEdge (V fromVertex , V toVertex) ;
	boolean addVertex(V vertex);
	Set<V> getChildren(V vertex);
	Set<V> addVertices(Set<V> vertices);
}