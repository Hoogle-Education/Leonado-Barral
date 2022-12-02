package pgdp.datastructures.lists;

import java.util.Arrays;

public class RecIntList {
	private RecIntListElement head;

	public RecIntList() {
		head = null;
	}

	public void append(int value) {
		if (head == null) {
			head = new RecIntListElement(value);
		} else {
			head.append(value);
		}
	}

	public int get(int idx) {
		if (head == null) {
			System.out.println("Invalid index: list is empty!");
			return Integer.MAX_VALUE;
		}
		return head.get(idx);
	}

	public int size() {
	    /**
		 * can be rewritten as
		 * if(head==null)
		 * return 0;
		 * else
		 * return head.size();
		*/
		return head == null ? 0 : head.size();
	}

	public boolean insert(int value, int idx) {
		if (head == null) {
			if (idx == 0) {
				append(value);
				return true;
			} else {
				System.out.println("You may only insert at index 0 to a empty list!");
				return false;
			}
		}
		return head.insert(value, idx);
	}

	@Override
	public String toString() {
		if (head != null) {
			return "List: [" + head.toString() + "]";
		} else {
			return "Empty list";
		}
	}

	public String toConnectionString() {
		if (head != null) {
			return "List: [" + head.toConnectionString() + "]";
		} else {
			return "Empty list";
		}
	}

	public long[] countThresh(int threshold) {
		long[] sums = {0, 0, 0};

		if(head == null) return sums;

		return countTresh(0, sums, threshold);
	}

	private long[] countTresh(int index, long[] sums, int threshold) {

		// base case
		if(head.size() == index) return sums;

		int value = head.get(index);

		if(value > threshold) sums[2] += value;
		else if (value < threshold) sums[0] += value;
		else sums[1] += value;

		return countTresh(index + 1, sums, threshold);
	}

	public void kinguinSort(boolean increasing) {
		if(head == null) return;

		RecIntList temp = new RecIntList();

		head = kinguinSort(temp, head.get(0), 0, increasing).head;
	}

	private RecIntList kinguinSort(RecIntList temp, int setpoint, int index, boolean increasing) {

		if(head.size() == index) return temp;

		int value = head.get(index);

		if((increasing && value >= setpoint) || (!increasing && value <= setpoint) ) {
			temp.append(value);
			setpoint = value;
		}

		return kinguinSort(temp, setpoint, index + 1, increasing);
	}

	public void reverse() {
		if ( head == null ) return;

		int middle = head.size() / 2;
		head.reverse(middle);
	}


	public static void zip(RecIntList l1, RecIntList l2) {

		if(l1 == null || l2 == null) return;

		zip(l1, l2, true, 0, 0, 0, l1.size(), l2.size());
	}

	private static void zip(RecIntList l1, RecIntList l2, boolean left, int globalIndex,
							int index1, int index2, int s1, int s2) {

		if(index2 >= s2) return;

		System.out.println("gi = " + globalIndex + " | i1 = " + index1 + " | i2 = " + index2);

		if(index1 >= s1) {
			l1.insert(l2.get(index2), globalIndex);
			zip(l1, l2, false, globalIndex + 1,  index1, index2 + 1, s1, s2);
			return;
		}

		if(left) {
			zip(l1, l2, false, globalIndex + 1, index1 + 1, index2, s1, s2);
		} else {
			l1.insert(l2.get(index2), globalIndex);
			zip(l1, l2, true, globalIndex + 1, index1, index2 + 1, s1, s2);
		}

	}

	public static void main(String[] args) {
		// countThresh example
		RecIntList countThreshExample = new RecIntList();
		for (int i = 1; i <= 5; i++) {
			countThreshExample.append(i);
		}

		System.out.println(Arrays.toString(countThreshExample.countThresh(3)));

//		 kinguinSort example (1)
		RecIntList kinguinSortExample = new RecIntList();
		int[] kinguinSortvalues = new int[] { 3, 2, 4, 7, 1, 6, 5, 9, 8 };
		for (int i : kinguinSortvalues) {
			kinguinSortExample.append(i);
		}
		kinguinSortExample.kinguinSort(false); // false for example (2)
		System.out.println(kinguinSortExample);

		// reverse example
		RecIntList reverseExample = new RecIntList();
		for (int i = 0; i < 2; i++) {
			reverseExample.append(i);
		}

		reverseExample.reverse();
		System.out.println(reverseExample);

//		// zip example
		RecIntList l1 = new RecIntList();
		RecIntList l2 = new RecIntList();

		int[] v1 = new int[] { 1, 1, 1 };
		int[] v2 = new int[] { 1, 1 };

		for(int element : v1) {
			l1.append(element);
		}

		for(int element : v2) {
			l2.append(element);
		}

		RecIntList.zip(l1, l2);
		System.out.println(l1);
	}
}
