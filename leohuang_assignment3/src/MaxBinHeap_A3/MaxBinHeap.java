package MaxBinHeap_A3;

public class MaxBinHeap implements Heap_Interface {
  private double[] array; //load this array
  private int size = 0;boolean a = true; boolean b = true;
  private static final int arraySize = 10000; //Everything in the array will initially 
                                              //be null. This is ok! Just build out 
                                              //from array[1]

  public MaxBinHeap() {
    this.array = new double[arraySize];
    array[0] = Double.NaN;  //0th will be unused for simplicity 
                            //of child/parent computations...
                            //the book/animation page both do this.
  }
    
  //Please do not remove or modify this method! Used to test your entire Heap.
  @Override
  public double[] getHeap() { 
    return this.array;
  }
  public void insert(double element) {
	  size++;
	  array[size] = element;
	  
	  
	  if (size == 1) {
		  return;
	  }
	  int top = (size)/2; int cur = size;
	  while (a) {
		  sw(top, cur);
		  cur = top;
		  top = cur/2;
		  if (cur == 1) {
			  a = false;
		  }
		 
	  }
	  a = true;
  }
  public void delMax() {
	  array[1] = array[size];
	  array[size] = Double.NaN;
	  size--;
	  if (size == 0) {
		  return;
	  }
	  int low=0; int cur =1;
	  while (b) {
		  if (2*cur +1> size) {
			  low = 2*cur;
		  }else if (array[2*cur] > array[2*cur+1] ) {
			  low = 2*cur;
		  } else {
			  low = 2*cur+1;
		  }
		  sw(cur, low);
		  cur = low;
		  if (2*cur > size) {
			  b = false;
			  
		  }
	  }
	  b = true;
  }
  public double getMax() {
	  if (size == 0) {
		  return Double.NaN;
	  }
	  return array[1];
  }
  public void clear() {
	  this.array = new double[arraySize];
	  array[0] = Double.NaN;
	  size =0;
  }
  public int size() {
	  return size;
  }
  public void build(double [] elements) {
	  clear();
	  
	  for (int i = 0; i<elements.length;i++) {
		  insert(elements[i]);
		  
	  }
  }
  public double[] sort(double[] elements) {
	  build(elements);
	  double[] temp = new double[elements.length];
	  for(int i=elements.length-1; i >-1; i--) {
		  temp[i] = getMax();
		  delMax();
	  }
	  return temp;
  }
  public void sw(int top, int cur) {
	  if (array[top]<array[cur]) {
		  double temp = array[top];
		  array[top] = array[cur];
		  array[cur] = temp;
	  }
	  
  }
  // add your method implementstions
}