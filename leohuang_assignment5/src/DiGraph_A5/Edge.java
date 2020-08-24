package DiGraph_A5;

public class Edge {
	private long id;private long weight;
	private String source;private String destination;
	private String edgeLabel;
	
	Edge(long idNum, String sLabel, String dLabel, long weight, String eLabel){
		this.id = idNum;
		this.source = sLabel;
		this.destination = dLabel;
		this.weight = weight;
		this.edgeLabel = eLabel;
	}
	
	public long getID() {
		return id;
	}
	public String getSource() {
		return source;}
	public String getDestination() {
		return destination;
	}
	public long getWeight() {
		return weight;
	}
	public String getEdgeLabel() {
		return edgeLabel;
	}
	
	public void setID(long i) {
		id = i;
	}
	public void setSource(String s) {
		source = s;
	}
	public void setDestination(String d) {
		destination = d;
	}
	public void setWeight(long w) {
		weight = w;
	}
	public void setEdgeLabel(String e) {
		edgeLabel = e;
	}
}
