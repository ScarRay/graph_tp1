package graph_tp1;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractWeightedListGraph<E, V> extends AbstractListGraph implements WeightedGraph {

	private final Map<Tuple,E> edges = new HashMap<Tuple,E>();
	
	private class Tuple<V> {
		private V source;
		private V end;
		
		private Tuple(V source, V end) {
			setSource(source);
			setEnd(end);
		}
		
		private V getSource() {
			return this.source;
		}
		private V getEnd() {
			return this.end;
		}
		private void setSource(V source) {
			this.source = source;
		}
		private void setEnd(V end) {
			this.end = end;
		}
	}

	
	protected String getDotType() {
		return "wegraph";
	}
}
