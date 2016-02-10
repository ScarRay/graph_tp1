package graph_tp1;

import java.awt.Color;
import java.util.HashSet;
import java.util.Set;

public class Main {

	public static <E, V> void main(String[] args) {
		// TODO Auto-generated method stub
		DirectedListGraph dg = new DirectedListGraph();
		UndirectedListGraph ug = new UndirectedListGraph();
		WeightedListGraph wg = new WeightedListGraph();
		
		Word w = new Word("kek");
		ColoredWord wc = new ColoredWord("coloredKek",Color.RED);
		
		int a = 11;
		Word d = new Word ("d");
		Word c = new Word ("c");
		Word b = new Word ("b");
		Word e = new Word ("e");
		Word f = new Word ("f");
		
		dg.addEdge(a, b);
		dg.addEdge(c, a);
		dg.addEdge(b, e);
		dg.addEdge(b, c);
		dg.addEdge(d, b);
		dg.addEdge(c, d);
		dg.addEdge(c, f);
		
		ug.addEdge(a, b);
		ug.addEdge(c, a);
		ug.addEdge(b, e);
		ug.addEdge(b, c);
		ug.addEdge(d, b);
		ug.addEdge(c, d);
		ug.addEdge(c, f);
		ug.addEdge(f, a);
		ug.addEdge(f, b);
		ug.addEdge(e, f);
		//ug.addEdge(wc, a);
		
		Set<ColoredWord> setW = new HashSet<ColoredWord>();
		setW.add(wc);
		ug.addVertices(setW);
		
		System.out.println(dg.printGraph());
		System.out.println(dg.listToString(dg.execute(dg,a)));
		
		System.out.println("\n------------------\n");
		
		System.out.println(ug.printGraph());
		System.out.println(ug.listToString(ug.execute(ug,a)));
		
		System.out.println("\n------------------\n");
		
		wg.addEdge(a, b);
		wg.addEdge(c, b);
		wg.addEdge(wc, e);
		wg.addEdge(a, d);
		
		System.out.println(wg.printGraph());
	}
}
