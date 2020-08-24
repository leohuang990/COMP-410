package DiGraph_A5;

import java.util.*;

public class Vert {
	private long id;
	private String label;
	private boolean known;
	private long dv;
	private Vert pv;
	private Map<String, Edge> out = new HashMap<String, Edge>();
	
	public Vert(long idNum, String label){
		this.id = idNum;
		this.label = label;
	}
	
	public long getID() {
		return id;
	}
	public String getLabel() {
		return label;
	}
	
	public void setID(long i) {
		id = i;
	}
	public void setLabel(String l) {
		label = l;
	}
	
	public boolean containOut(String dLabel){
		return out.containsKey(dLabel);
	}
	public Edge getOut(String dLabel){
		return out.get(dLabel);
	}
	public void addOut(String dLabel, Edge e){
		out.put(dLabel, e);
	}
	public void removeOut(String dLabel){
		out.remove(dLabel);
	}
	public Collection<Edge> iterate(){
		return out.values();
	}
	
	
	
	// property of Dijkstra 
	public boolean getKnown() {
		return known;
	}
	public long getDv() {
		return dv;
	}
	public Vert getPv() {
		return pv;
	}
	
	public void setKnown(boolean k) {
		known = k;
	}
	public void setDv(long dv) {
		this.dv = dv;
	}
	public void setPv(Vert pv) {
		this.pv = pv;
	}

	
	
	
	
}
