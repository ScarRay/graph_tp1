package graph_tp1;

import java.util.Map;
import java.util.Set;

public class UndirectedListGraph extends AbstractListGraph implements Graph{

	@Override
	protected String getDotType() {
		return "undigraph";
	}
	
}
