/**
 * COMP 410
 * Make your class and its methods public!
 * Your skiplist implementation will implement this interface.
 *
*/

package SKPLIST_A4;

/*
  Interface: The skiplist will provide this collection of operations:

  insert:
    in: a string (the element to be stored into the skiplist)
    return: boolean, return true if insert is successful, false otherwise
    effect: if the string is already in the skiplist, then there is no change to
              the skiplist state, and return false
            if the string is not already in the skiplist, then a new skiplist node
              is created, the string put into it as data, the new node is linked
              into the skiplist at the proper place; size is incremented by 1,
              and return a true
  remove:
    in: a string (the element to be taken out of the skiplist)
    return: boolean, return true if the remove is successful, false otherwise
            this means return false if the skiplist size is 0
    effect: if the element being looked for is in the skiplist, unlink the node containing
              it and return true (success); size decreases by one
            if the element being looked for is not in the skiplist, return false and
              make no change to the skiplist state
  contains:
    in: a string (the element to be seaarched for)
    return: boolean, return true if the string being looked for is in the skiplist;
            return false otherwise
            this means return false if skiplist size is 0
    effect: no change to the state of the skiplist

  findMin:
    in: none
    return: string, the element value from the skiplist that is smallest
    effect: no skiplist state change
    error: is skiplist size is 0, return null

  findMax:
    in: none
    return: string, the element value from the skiplist that is largest
    effect: no skiplist state change
    error: is skiplist size is 0, return null

  size:
    in: nothing
    return: number of elements stored in the skiplist
    effect: no change to skiplist state

  empty:
    in: nothing
    return: boolean, true if the skiplist has no elements in it, true if size is 0
            return false otherwise
    effect: no change to skiplist state

  level:
    in: none
    return: integer, the level of the highest node in the skiplist
    effect: no change in skiplist state
    error: return -1 if skiplist is empty (size is 0, only head and tail nodes are there)

  getRoot:
    in: none
    return: a skiplist node, the one that is the starter of the entire skiplist
            the skiplist starts with a sentinel, make in the list constructor.
            so getRoot returns the sentinel always, even if the skiplist is empty.
            If the list is empty, then level 0 of the senetinel link array would be null.
    effect: no change to skiplist state

*/

// ADT operations

public interface SkipList_Interface {
	public void setSeed(long seed);
	  public void setProbability(double probability);
	  public SkipList_Node getRoot();
	  public boolean insert(double value);
	  public boolean remove(double value);
	  public boolean contains(double value);
	  public double findMin();
	  public double findMax();
	  public boolean empty();
	  public void clear();
	  public int size();
	  public int level();
	  public int max();
	}
