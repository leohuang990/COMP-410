/**
 * COMP 410
 *See inline comment descriptions for methods not described in interface.
 *
*/
package LinkedList_A1;

public class LinkedListImpl implements LIST_Interface {
  Node headCell; //this will be the entry point to your linked list (the head)
  Node lastCell; 
  int size;// this is the Node at the end of the list... the starting place
  // if you wanted to traverse the list backwards
  
  public LinkedListImpl(){//this constructor is needed for testing purposes. Please don't modify!
    headCell = null; //Note that the root's data is not a true part of your data set!
    lastCell = null;
    size = 0;
  }
  
  //implement all methods in interface, and include the getRoot method we made for testing 
  // purposes. Feel free to implement private helper methods!

 // add the fields you need to add to make it work... like a 
  
  public Node getRoot(){ //leave this method as is, used by the grader to grab your linkedList easily.
    return headCell;
  }
  public Node getLast(){ //leave this method as is, used by the grader to grab your linkedList easily.
    return lastCell;
  }
  public boolean insert(double elt, int index) {
	  if (index<0||index>size()) {
		  return false;
	  } 
	  if (size()==0) {
		  headCell = new Node(elt);
		  lastCell = new Node(elt);
	  } else if (size()==1){
		  if (index == 0) {
			  headCell = new Node(elt);
			  headCell.next = lastCell;
			  lastCell.prev = headCell;
		  } else {
			  lastCell = new Node(elt);
			  headCell.next = lastCell;
			  lastCell.prev = headCell;
		  }
	  } else {
		  if (index == 0) {
			 Node temp = new Node(elt);
			 temp.next = headCell;
			 headCell.prev = temp;
			 headCell = temp;
		  } else if(index == size()) {
			  Node temp = new Node(elt);
			  temp.prev = lastCell;
			  lastCell.next = temp;
			  lastCell = temp;
		  } else {
			  Node temp = headCell;
			  for (int i = 0; i<index;i++) {
				  temp = temp.next;
			  }
			  Node a = new Node(elt);
			  a.next = temp;
			  a.prev = temp.prev;
			  temp.prev.next=a;
			  temp.prev=a;
		  }
	  }
	  size++;
	  return true;
  }
  public boolean insort(double elt) {
	  if (size == 0) {
		  return insert(elt,0);
	  } else if(size == 1){
		  if (elt > headCell.data) {
			  return insert(elt,1);
		  } else {
			  return insert(elt,0);
		  }
	  } else {
		  if (elt < headCell.data) {
			  
			  return insert(elt,0);
			  
		  } else {
			  Node temp = headCell.next;
			  int ind = 0;
			  for (int i = 1; i< size;i++) {
				  if (temp.prev.data<=elt&&temp.data>elt) {
					  ind = i;
					  break;
				  }
				  temp = temp.next;
			  }
			  
			  if (ind == 0) {
				  return insert(elt,size);
			  } else {
				  return insert(elt,ind);
			  }
		  }
	  }
  }
  public boolean remove(int index) {
	  Node temp = headCell;
	  if (index<0||index>=size()) {
		  return false;
	  } else {
		  for (int i=0; i < index; i++) {
			  temp = temp.next;
		  }
	  }
	  if (size == 1) {
		  headCell = null;
		  lastCell = null;
	  } else if(size == 2) {
		  if (index == 0) {
			  headCell = lastCell;
			  lastCell.next = null;
			  lastCell.prev = null;
		  } else {
			  lastCell = headCell;
			  lastCell.next = null;
			  lastCell.prev = null;
		  }
	  }else if (index == 0) {
		  Node t = headCell.next;
		  t.prev = null;
		  headCell.next = null;
		  headCell = t;
	  } else if(index == size()-1) {
		  Node t = lastCell.prev;
		  t.next = null;
		  lastCell.prev = null;
		  lastCell = t;
	  } else {
		  temp.prev.next = temp.next;
		  temp.next.prev = temp.prev;
		  temp.next = null;
		  temp.prev = null;
	  }
	  size--;
	  return true;
  }
  public double get(int index) {
	  Node temp = headCell;
	  if (index<0||index>=size()) {
		  return Double.NaN;
	  } else {
		  for (int i=0; i < index; i++) {
			  temp = temp.next;
		  }
	  }
	  return temp.data;
  }
  public int size() {
	  return size;
  }
  public boolean isEmpty() {
	  if (headCell == null) {
		  return true;
	  } else {
		  return false;
	  }
  }
  public void clear() {
	  headCell = null;
	  lastCell = null;
	  size = 0;
  }
 
}