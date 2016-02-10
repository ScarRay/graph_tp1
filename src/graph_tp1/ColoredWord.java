package graph_tp1;

import java.awt.Color;

public class ColoredWord extends Word {
	private Color color;
	
	public ColoredWord(String w,Color c) {
		super(w);
		setValue(c);
	}

	public Color getColor() {
		return color;
	}

	public void setValue(Color color) {
		this.color = color;
	}
	
	public String toString() {
		return this.getValue() +",color="+this.getColor().toString();
	}
}
