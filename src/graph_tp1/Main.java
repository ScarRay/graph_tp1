package graph_tp1;

import java.awt.Color;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DirectedListGraph dg = new DirectedListGraph();
		UndirectedListGraph ug = new UndirectedListGraph();
		Word w = new Word("kek");
		ColoredWord wc = new ColoredWord("coloredKek",Color.RED);
		
		V a = new V ('a');
		V d = new V ('d');
		V c = new V ('c');
		V b = new V ('b');
		V e = new V ('e');
		V f = new V ('f');
		
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
		
		
		
		System.out.println(dg.printGraph());
		System.out.println(dg.listToString(dg.execute(dg,a)));
		
		System.out.println("\n------------------\n");
		
		System.out.println(ug.printGraph());
		System.out.println(ug.listToString(ug.execute(ug,b)));
	}
}
