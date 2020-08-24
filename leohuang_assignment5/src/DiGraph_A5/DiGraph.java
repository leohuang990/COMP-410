package DiGraph_A5;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class DiGraph implements DiGraphInterface {

	private long numV = 0;
	private long numE = 0;
	private Map<String, Long> mapEID;
	private Map<String, Long> mapVID;
	private Map<String, Edge> mapEdge;
	private Map<String, Vert> mapVert;
	
	
	private Map<String, Set<String>> mapSource;
	// this refers to a set of vertexes that can go to certain vertex
  public DiGraph ( ) { // default constructor
    // explicitly include this
    // we need to have the default constructor
    // if you then write others, this one will still be there
	  mapEID = new HashMap<String, Long>();
	  mapVID = new HashMap<String, Long>();
	  mapEdge = new HashMap<String, Edge>();
	  mapVert = new HashMap<String, Vert>();
	  mapSource = new HashMap<String,Set<String>>();
	 
	  }
  public boolean addNode(long idV, String label) {
	  if(idV<0||label == null||mapVert.containsKey(label)||mapVID.containsValue(idV)) {
		  return false;
	  }
	  Vert temp = new Vert(idV, label);
	 
	  mapVert.put(label, temp);
	  mapVID.put(label, idV);
	  mapSource.put(label, new HashSet<String>());
	  numV++;
	  return true;
  }
  public boolean addEdge(long idE, String source, String destination, long weight, String edgeLabel) {
	  if (idE < 0 || source == null || destination == null || mapEID.containsValue(idE)|| !(mapVert.containsKey(source) && mapVert.containsKey(destination))
			  || mapVert.get(source).containOut(destination)){
			return false;
	  } 
	  Edge temp = new Edge(idE, source, destination, weight, edgeLabel);
	  mapEdge.put(edgeLabel, temp);
		
	  mapEID.put(edgeLabel, idE);
	  mapSource.get(destination).add(source);
	  mapVert.get(source).addOut(destination, temp);
	  numE++;
	  return true;
  }
  // overload
  public boolean addEdge(long idE, String source, String destination, String edgeLabel) {
	  return addEdge(idE, source, destination, 1,edgeLabel);
  }
  public boolean delNode(String label) {
	  if (!mapVert.containsKey(label)) {
		return false;
	  }
	  for (String s: mapSource.get(label)) {
		mapVert.get(s).removeOut(label);
	  }
	  for (Edge edge: mapVert.get(label).iterate()) {
		mapSource.get(mapVert.get(edge.getDestination()).getLabel()).remove(label);
	  }
	  mapSource.remove(label);
	  mapVID.remove(mapVert.get(label).getID());
	  mapVert.remove(label);
	  numV--;
	  return true;
  }
  public boolean delEdge(String source, String destination) {
	  if (!mapVert.containsKey(source)) {
		  return false;
	  }
	  if (!(mapVert.containsKey(source) && mapVert.containsKey(destination)) ||!mapVert.get(source).containOut(destination)) {
		  return false;
	  }
	  mapEID.remove(mapVert.get(source).getOut(destination).getEdgeLabel());
	  mapEdge.remove(mapVert.get(source).getOut(destination).getEdgeLabel());
	  mapVert.get(source).removeOut(destination);
	  mapSource.get(destination).remove(source);
	  numE--;
	  return true;
  }
  public long numNodes() {
	  return numV;
  }
  public long numEdges() {
	  return numE;
  }
  public ShortestPathInfo[] shortestPath(String label) {
	  if (!mapVert.containsKey(label)) {
		  return null;
	  }

	  int length = (int) numV;
	  ShortestPathInfo[] array = new ShortestPathInfo[length];
	  BinaryHeapForDiPair heap = new BinaryHeapForDiPair();

	  for(Vert ing: mapVert.values()) {
		ing.setKnown(false);
		ing.setDv(-1);
	  }
	  mapVert.get(label).setDv(0);
	  mapVert.get(label).setPv(null);
	
	  heap.insert(new DiPair(label,0));
	  int i = 0;
	  while(heap.size() > 0) {
		  String t = heap.getMin().getValue();
		  Vert v = mapVert.get(t);
		  heap.delMin();
		  if (v.getKnown()) {
			 // skip vertex that has been visited
			 continue;
		  } else {
			v.setKnown(true);
			array[i] = new ShortestPathInfo(t, v.getDv());
			i++;
			for(Edge e: v.iterate()) {
				long newWeight = e.getWeight() + v.getDv();
				Vert destination = mapVert.get(e.getDestination());
				// check if necessary to update
				if(destination.getDv() < 0 || newWeight < destination.getDv()) {
					destination.setPv(v);
					destination.setDv(newWeight);
					heap.insert(new DiPair(destination.getLabel(), (int) newWeight));
				}
			}
		  }
	  }
		// put all unreachable vertexes at the end of the array
	  for (Vert ve: mapVert.values()) {
		  if (!ve.getKnown()) {
			  array[i] = new ShortestPathInfo(ve.getLabel(), (long)-1);
			  i++;
		  }
	  }
	  return array;
  }
}