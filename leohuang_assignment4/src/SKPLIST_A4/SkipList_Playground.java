package SKPLIST_A4;

import java.util.Random;

public class SkipList_Playground {
  public static void main(String[] args) {
	  test3();
  }
  
  private static void test2() {
	  SkipList_Interface list = new SkipList(5);
	    for(double i = 0; i < 5; i++) {
	    	list.remove(i);
	    	System.out.println(list.remove(i));
	    }
	    for(double i = 0; i < 5; i++) {
	    	list.insert(i);
	    	
	    }
  }
  private static void test3() {
	    SkipList_Interface list = new SkipList(5);
	    for(double i = 0; i < 5; i++) {
	    	list.remove(i);
	    	System.out.println(list.remove(i));
	    }
	    for(double i = 0; i < 5; i++) {
	    	
	    	System.out.println(list.insert(i));
	    }
	    
	    System.out.println(list);
	  }
  private static void randoms() {
		SkipList_Interface list = new SkipList(30);
		// Random insert:
		for (int i = 0; i < 15; i++) {
			Random r = new Random();
			int rand = r.nextInt(500);
			System.out.println("Inserting " + rand);
			list.insert(rand);
			if (!list.contains(rand)) {
				throw new RuntimeException("Why u NOT contains rand: " + rand);
			}
			System.out.println(list);
		}
		System.out.println("Nice insertion ;) Size is now: " + list.size());

		// Random remove:
		for (int i = 0; i < 15; i++) {
			Random r = new Random();
			int rand = r.nextInt(50);
			System.out.println("Removing " + rand);
			list.remove(rand);
			if (list.contains(rand)) {
				throw new RuntimeException("Why u contains rand: " + rand);
			}
			System.out.println(list);
		}
		System.out.println("Nice removing! Size is now: " + list.size());

		// Random max/min
		System.out.println(list);
		System.out.println("Max: " + list.findMax());
		System.out.println("Min: " + list.findMin());

		// Random clear/size/level
		System.out.println("Size: " + list.size());
		System.out.println("Highest level: " + list.level());
		System.out.println("CLEARING LIST...");
		list.clear();

		if (list.size() != 0) {
			throw new RuntimeException("Why ur list not cleared? The size is " + list.size());
		}
		System.out.println("LIST CLEAR SUCCESS");
		System.out.println("Highest level: " + list.level()); // **Check this manually

		checkOrder(list);
		System.out.println(list); // List should be empty at this point
	}
  private static void checkOrder(SkipList_Interface list) {
		SkipList_Node track = list.getRoot();
		while (track.getNext(0) != null) {
			if (track.getValue() != Double.NaN && track.getValue() > track.getNext(0).getValue()) {
				throw new RuntimeException("Not in order");
			}
			track = track.getNext(0);
		}
		System.out.println("NICEU YOUR LIST IS IN ORDER!");
	}

  
}