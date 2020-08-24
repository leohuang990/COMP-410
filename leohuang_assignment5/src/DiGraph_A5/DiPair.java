package DiGraph_A5;

public class DiPair {
	private String v;
	private int p;

	public DiPair(String Value, int Priority) {
	    v = Value;
	    p = Priority;
	}

	public String getValue() { 
		return v; 
	}
	public int getPriority() { 
		return p; 
	}
}
