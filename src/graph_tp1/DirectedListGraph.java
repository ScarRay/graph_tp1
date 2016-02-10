package graph_tp1;

import java.util.Set;

public class DirectedListGraph extends AbstractListGraph implements Graph {

	@Override
	protected String getDotType() {
		return "digraph";
	}
}
