package pgdp.datastructures.lists;

public class RecIntListElement {
	private int value;
	private RecIntListElement next;
	private RecIntListElement prev;

	private RecIntListElement p1;

	private RecIntListElement p2;

	public RecIntListElement(int value) {
		this(value, null);
	}

	public RecIntListElement(int value, RecIntListElement prev) {
		this.value = value;
		next = null;
		this.prev = prev;
	}

	public RecIntListElement append(int value) {
		if (next != null) {
			return next.append(value);
		} else {
			next = new RecIntListElement(value, this);
			return next;
		}
	}

	public int get(int idx) {
		if (idx == 0) {
			return value;
		}
		if (next == null) {
			System.out.println("Invalid index: list is to short!");
			return Integer.MIN_VALUE;
		}
		return next.get(idx - 1);
	}

	public int size() {
		if (next == null) {
			return 1;
		}
		return 1 + next.size();
	}

	public boolean insert(int value, int idx) {
		if (idx < 0) {
			System.out.println("Cannot insert at negative index!");
			return false;
		}
		if (idx <= 1) {
			RecIntListElement n = new RecIntListElement(value, this);
			n.next = next;
			if (next != null) {
				next.prev = n;
			}
			next = n;
			if (idx == 0) {
				next.value = this.value;
				this.value = value;
			}
			return true;
		}
		if (next == null) {
			System.out.println("List is to short to insert at given index!");
			return false;
		}
		return next.insert(value, idx - 1);
	}

	public void reverse(int limit) {

		if(limit == 0) {
			p1 = null;
			p2 = null;
			return;
		}

		if(p1 == null && p2 == null) {
			p1 = getRefference(0);
			p2 = getRefference(size()-1);
		} else {
			p1 = p1.next;
			p2 = p2.prev;
		}

		int aux = p1.value;
		p1.value = p2.value;
		p2.value = aux;

		reverse(limit - 1);
	}

	private RecIntListElement getRefference(int idx) {
		if (idx == 0) {
			return this;
		}

		return next.getRefference(idx - 1);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		RecIntListElement tmp = this;
		do {
			sb.append(tmp.value).append(", ");
			tmp = tmp.next;
		} while (tmp != null);
		sb.setLength(sb.length() - 2);
		return sb.toString();
	}

	public String toConnectionString() {
		StringBuilder sb = new StringBuilder();
		RecIntListElement tmp = this;
		do {
			if (tmp.prev != null) {
				sb.append("<-");
			}
			sb.append(tmp.value);
			if (tmp.next != null) {
				sb.append("->");
			}
			tmp = tmp.next;
		} while (tmp != null);
		return sb.toString();
	}
}
