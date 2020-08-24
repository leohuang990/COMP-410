package BST_A2;

public class BST implements BST_Interface {
  public BST_Node root;
  int size=0; int height = 0;boolean c=true; boolean c1=true;
  int con =0;BST_Node pre;BST_Node cur;
  boolean hasFound = false;
  public BST(){ size=0; root=null; }
  
  @Override
  //used for testing, please leave as is
  public BST_Node getRoot(){ return root; }

  //--------------------------------------------------
  //
  // of course, fill in the methods implementations
  // for the interface
  //
  //--------------------------------------------------
  public boolean insert(String s) {
	  if (s==null) {
		  return false;
	  }
	  if (contains(s)) {
		  return false;
	  }
	  if (size==0) {
		  root = new BST_Node(s);
		  size++;
		  return true;
	  }
	  BST_Node temp = root;
	  size++;
	  while (temp != null) {
		  if (temp.data.compareTo(s)>0) {
			  if (temp.left!=null) {
				  temp  = temp.left;
			  } else {
				  temp.left = new BST_Node(s);
				  
				  return true;
			  }
			  
		  } else {
			  if (temp.right!=null) {
				  temp = temp.right;
			  } else {
				  temp.right = new BST_Node(s);
				  return true;
			  }
		  }
		  
	  }
	  return true;
	  
  }
  public boolean remove(String s) {
	  if (!contains(s)) {
		  return false;
	  }
	  
	  search2(null, root, s);
	  search3();
	  size--;
	  return true;
  }
  public String findMin() {
	  if (root == null) {
		  return null;
	  }
	  BST_Node temp = root;
	  while (temp.left != null) {
		  temp = temp .left;
	  }
	  return temp.data;
  }
  public String findMax() {
	  if (root == null) {
		  return null;
	  }
	  BST_Node temp = root;
	  while (temp.right != null) {
		  temp = temp .right;
	  }
	  return temp.data;
  }
  public boolean empty() {
	  if (size()==0) {
		  return true;
	  } else {
		  return false;
	  }
  }
  public boolean contains(String s) {
	  if (s == null) {
		  return false;
	  }
	  search(root, s);
	  
	  if (con == 0) {
		  return false;
	  } else {
		  con = 0;
		  return true;
	  }
  }
  public int size() {
	  return size;
  }
  public int height() {
	  if (root == null) {
		  return -1;
	  } else {
		  if (c1) {
			  fill2(root,0);
			  c1=false;
			  return height -1;
		  } else {
			  return height -1;
		  }
	  }
  }
  public void fill(BST_Node r) {
	  if(r==null)return;
	  size++;
	  fill(r.left);
	  fill(r.right);
  }
  public void fill2(BST_Node r, int h) {
	  if (r==null) {
		  if (h>height) {
			  height = h;
		  }
	  } else {
		  fill2(r.left, h+1);
		  fill2(r.right, h+1);
	  }
	  
  }
  public void search(BST_Node node, String s) {
	  if (node == null) {
		  return;
	  }
	  if (node.data.contentEquals(s)) {
		  con = 1;
	  }
	  search(node.left, s);
	  search(node.right, s);
  }
  public void search2(BST_Node up, BST_Node node, String s) {
	  if (node.data.contentEquals(s)) {
		  pre = up;
		  cur = node;
		  return;
	  }
	  if (node.data.compareTo(s)<0) {
		  search2(node, node.right,s);
		  return;
	  } else {
		  search2(node, node.left, s);
		  return;
	  }
	  
	  
	  
	  
  }
  public void search3 () {
	  if (pre == null) {
		  if (cur.left == null) {
			  root = root.right;
		  } else {
			  if (cur.left.right == null) {
				  BST_Node ttt = root.right;
				  root = root.left;
				  root.right = ttt;
			  } else {
				  BST_Node ab = root.left;
				  BST_Node ac = root;
				  while (ab.right != null) {
				  	  ac = ab;
				  	  ab = ab.right;
				  }
				  ac.right = null;
				  BST_Node ttt = root.right;
				  BST_Node tt = root.left;
				  ab.left = tt;
				  ab.right = ttt;
			  }
			  
		  }
		  return;
	  }
	  if (cur.left == null) {
		  if (pre.right == cur) {
			  pre.right = cur.right;
		  } else {
			  pre.left = cur.right;
		  }
	  } else if (cur.left.right == null){
		  if (pre.right == cur) {
			  pre.right = cur.left;
			  cur.left.right = cur.right;
		  } else {
			  pre.left = cur.left;
			  cur.left.right = cur.right;
		  }
	  } else {
		  BST_Node ab = cur.left;
		  BST_Node ac = cur;
		  while (ab.right != null) {
		  	  ac = ab;
		  	  ab = ab.right;
		  }
		  ac.right = null;
		  if (pre.right == cur) {
			  pre.right = ab;
			  ab.left = cur.left;
			  ab.right = cur.right;
		  } else {
			  pre.left = ab;
			  ab.left = cur.left;
			  ab.right = cur.right;
			  
		  }
	  }
  }
}

