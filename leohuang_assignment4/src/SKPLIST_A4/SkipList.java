package SKPLIST_A4;

import java.util.Arrays;
import java.util.Random;

public class SkipList implements SkipList_Interface {
	  private SkipList_Node root;
	  private final Random rand;
	  private double probability;
	  private final int MAXHEIGHT = 30; // the most links that a data cell may contain
	  private int size = 0;private int maxHt = 0;private int ht = 0;
	  public SkipList(int maxHeight) {
	    ht = maxHeight;
		root = new SkipList_Node(Double.NaN, maxHeight);
	    rand = new Random();
	    probability = 0.5;
	  }

	  @Override
	  public void setSeed(long seed) { rand.setSeed(seed); }
	  
	  @Override
	  public void setProbability(double probability) { 
	     this.probability = probability; 
	  }
	  
	  private boolean flip() {
	    // use this where you "roll the dice"
	    // call it repeatedly until you determine the level
	    // for a new node
	    return rand.nextDouble() < probability;
	  }
	  
	  @Override
	  public SkipList_Node getRoot() { return root; }

	  @Override
	  public String toString() {
	    StringBuilder sb = new StringBuilder();
	    
	    int levels;
	    for(levels = 0; levels < root.getNext().length && root.getNext(levels) != null; levels ++);
	    
	    StringBuilder[] sbs = new StringBuilder[levels];
	    
	    for(int i = 0; i < sbs.length; i ++) {
	      sbs[i] = new StringBuilder();
	      sbs[i].append("level ").append(i).append(":");
	    }
	    
	    SkipList_Node cur = root;
	    
	    while (cur.getNext(0) != null) {
	      cur = cur.getNext(0);
	      for(int i = levels - 1; i >= cur.getNext().length; i --) {
	        sbs[i].append("\t");
	      }
	      for(int i = cur.getNext().length - 1; i >= 0; i --) {
	        if (cur.getNext(i) == null) {
	          levels --;
	        }
	        sbs[i].append("\t").append(cur.getValue());
	      }
	    }
	    
	    for(int i = sbs.length - 1; i >= 0; i --) {
	      sb.append(sbs[i]).append("\n");
	    }
	    
	    return sb.toString();
	  }
  //---------------------------------------------------------
  // student code follows
  // implement the methods of the interface
  //---------------------------------------------------------
  public boolean insert(double value) {
	  
	  if (contains(value)) {
		  return false;
	  }
	  
	  int a = ran();
	  if (a > ht) {
		  a = ht;
	  }
	 
	  if (maxHt < a-1) {
		  maxHt = a-1;
	  }
	  SkipList_Node temp = root;
	  SkipList_Node new1 = new SkipList_Node(value, a);
	  for(int i = a-1; i >=0; i--) {
		  if (temp.getNext(i) == null) {
			  temp.setNext(i, new1);
			  new1.setNext(i, null);
			  continue;
		  }
		  
		  while(value > temp.getNext(i).getValue()) {
			  temp = temp.getNext(i);
			  if (temp.getNext(i) == null) {
				  break;
			  }
		  }
		  SkipList_Node temp2 = temp.getNext(i);
		  temp.setNext(i, new1); new1.setNext(i, temp2);
	  }
	  size++; return true; 
  }
  
  public boolean remove(double value) {
	  if (!contains(value)) {
		  return false;
	  }
	  SkipList_Node temp = root;
	  for(int i = maxHt; i >=0; i--) {
		  if (temp.getNext(i) != null) {
		
			  while(value > temp.getNext(i).getValue()) {
				  temp = temp.getNext(i);
				  if (temp.getNext(i) == null) {
					  break;
				  }
			  }
			  if (temp.getNext(i)==null) {
				  continue;
			  } else if (temp.getNext(i).getValue() == value){
				  SkipList_Node abc = temp.getNext(i).getNext(i);
				  temp.setNext(i, abc);
				  
			  }
		  }
		  
	  }
	  reset();
	  size--;return true;
  }
  
  public boolean contains(double value) {
	  SkipList_Node temp = root;
	  for(int i = maxHt; i >=0; i--) {
		  if (temp.getNext(i) != null) {
		
			  while(value >= temp.getNext(i).getValue()) {
				  temp = temp.getNext(i);
				  if (temp.getNext(i) == null) {
					  break;
				  }
			  }
		  }
		  
	  }
	  if (temp.getValue() == value) {
		  return true;
	  } else {
		  return false;
	  }
  }
  
  public double findMin() {
	  return root.getNext(0).getValue();
  }
  
  public double findMax() {
	  SkipList_Node temp = root;
	  for(int i = maxHt; i >=0; i--) {
		  while(temp.getNext(i) != null) {
			  temp = temp.getNext(i);
		  }
	  }
	  return temp.getValue();
  }
 
  public boolean empty() {
	  if (size == 0) {
		  return true;
	  } else {
		  return false;
	  }
  }
  
  public void clear() {
	  size = 0;
	  root = new SkipList_Node(Double.NaN, ht);
  }
  
  public int size() {
	  return size;
  }
  
  public int level() {
	  if (size == 0) {
		  return -1;
	  }
	  return maxHt;
  }
  
  public int max() {
	  return ht;
  }
  public int ran() {
	  int i = 1;
	  while (flip()) {
		  i++;
	  }
	  return i;
  }
  public void reset() {
	  int a = ht - 1;
	  while(root.getNext(a) == null) {
		  a--;
		  if (a < 0) {
			  break;
		  }
	  }
	  
	  maxHt = a;
  }
}