package graph_tp1;


public class Word {
	private String word;

	public Word (String v) {
		setValue(v);
	}
		
	public String getValue () {
		return this.word;
	}
	
	public void setValue (String c) {
		this.word = c;
	}
	
	public String toString() {
		return this.word;
	}
}
