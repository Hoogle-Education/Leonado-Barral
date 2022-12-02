package pgdp.ds;

public class MultiStack {

	private final Stack stacks;

	public MultiStack() {
		stacks = new Stack(1);
	}

	// TODO implement missing methods

	public void push(int value) {
		stacks.push(value);
	}

	public int top() {
		return stacks.top();
	}

	public int pop(){
		return stacks.pop();
	}

	@Override
	public String toString() {
		return stacks.toString();
	}

	public static void main(String[] args) {

		MultiStack mstack = new MultiStack();

		mstack.push(5);
		mstack.push(15);
		mstack.push(3);
		mstack.push(2);
		mstack.push(9);

		System.out.println("should be 9: " + mstack.top());

		System.out.println("should be 9: " + mstack.pop());
		System.out.println("should be 2: " + mstack.pop());
		System.out.println("should be 3: " + mstack.pop());
		System.out.println("should be 15: " + mstack.pop());
		System.out.println("should be 5: " + mstack.pop());

		System.out.println(mstack);

		System.out.println("---------------------------------");

		System.out.println("should be 5: " + mstack.pop());

		System.out.println("---------------------------------");

		System.out.println(mstack);
	}

}
