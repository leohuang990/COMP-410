package DiGraph_A5;

import java.util.PriorityQueue;

public class DiGraphPlayground {

  public static void main (String[] args) {
  
      // thorough testing is your responsibility
      //
      // you may wish to create methods like 
      //    -- print
      //    -- sort
      //    -- random fill
      //    -- etc.
      // in order to convince yourself your code is producing
      // the correct behavior
      exTest();
    }
  
    public static void exTest(){
    	DiGraph d = new DiGraph();
    	d.addNode(1, "f");
        d.addNode(3, "s");
        d.addNode(7, "t");
        d.addNode(0, "fo");
        d.addNode(4, "fi");
        d.addNode(6, "si");
        d.addEdge(0, "f", "s", 1, "abc");
        d.addEdge(1, "f", "si", 2, null);
        d.addEdge(2, "s", "t", 3, null);
        d.addEdge(3, "fo", "fi", 4, null);
        d.addEdge(4, "fi", "si", 5, null);

        d.shortestPath("s");

    }
    public static void test() {
    	PriorityQueue<Vert> queue = new PriorityQueue<Vert>();
    	queue.add(new Vert(3,"c"));
    	queue.add(new Vert(1,"a"));
    	queue.add(new Vert(2,"b"));
    	
    }
}