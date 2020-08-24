package DiGraph_A5;

public class BinaryHeapForDiPair {
	private DiPair[] array; 
	private int size;
	private static final int arraySize = 1000000; 

	public BinaryHeapForDiPair() {
		this.array = new DiPair[arraySize];
		size = 0;
		array[0] = new DiPair(null, -1); 
	}
	public DiPair[] getHeap() { 
		return this.array;
	}

	public void insert(DiPair pair) {
		//no negative priority, or weight basically
		if (pair.getPriority() < 0) {
			return;
		}
		size++;
		int s = size; 
		array[s] = pair;
		while (pair.getPriority() < array[s/2].getPriority()) {
			DiPair temp = array[s];
			array[s] = array[s/2];
			array[s/2] = temp;
			s = s/2;
			if (s == 1) {
				break;
			}
		} 
		
	}
	

	public void delMin() {
		if (size == 0) {
			return;
		}
		if (size == 1) {
			array[1] = null;
			size--;
			return;
		}
		DiPair temp = array[size];
		array[size] = null;
		array[1] = temp;
		int i = 1;
		while (array[2*i] != null || array[i*2+1] != null) {
			// check if there is no right child
			if (array[i*2+1] == null) {
				//compare this with its left child
				if (array[2*i].getPriority() < temp.getPriority()) {
					array[i] = array[2*i];
					array[2*i] = temp;
					i = 2*i;
				}
				break;
			// check if this is the least among its left child and right child
			} else if (temp.getPriority() < array[2*i].getPriority() &&temp.getPriority() < array[2*i+1].getPriority()) {
				break;
			} else {
				//reaching this block means there are left child and right child and it needs to switch
				// left child is the smallest
				if (array[2*i].getPriority() < array[2*i+1].getPriority()) {
					array[i] = array[2*i];
					array[2*i] = temp;
					i = 2*i;
				} else {
					// right child is the smallest
					array[i] = array[2*i+1];
					array[2*i+1] = temp;
					i = 2*i+1;
				}
			}
		}
		size--;
	}


	public DiPair getMin() {
		if (size == 0) {
			return array[0];
		}else { 
			return array[1];
		}
	}

	public int size() {
		return size;
	}

}