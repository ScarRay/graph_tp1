package graph_tp1;
import java.util.Set;

public interface Graph <V> {
	boolean addEdge (V fromVertex , V toVertex) ;
	boolean addVertex(V vertex);
	Set<V> getChildren(V vertex);
	Set<V> addVertices(Set<? extends V> vertices);
}