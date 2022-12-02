package pgdp.ds;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Stack {
	private Stack next;
	private int[] mem;
	private int top;

	public Stack(int capacity) {
		next = null;
		mem = new int[capacity];
		top = -1;
	}

	// TODO implement missing methods
	public boolean isEmpty() {
		return top == -1;
	}

	public boolean isFull() {
		return top == mem.length - 1;
	}

	public boolean push(int value) {
		if(isFull()) {
			if(next == null) {
				next = new Stack(mem.length*2);
			}

			return next.push(value);
		}

		top++;
		mem[top] = value;
		return true;
	}

	public int top() {
		Stack aux = this;
		while(aux.next != null)
			aux = aux.next;
		return aux.mem[aux.top];
	}

	public int pop() {

		int result = Integer.MIN_VALUE;

		if(this.next == null){
			result = (top == -1) ? Integer.MIN_VALUE : this.mem[0];
			top = -1;
			return result;
		}

		Stack aux = this;
		boolean hasToRemove = false;

		while(aux.next != null){
			if(aux.next.top == 0){
				hasToRemove = true;
				result = aux.next.top();
				break;
			}
			aux = aux.next;
		}

		if(hasToRemove) {
			aux.next = null;
			return result;
		}

		result = aux.mem[aux.top--];
		return result;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("{\ncapacity = ").append(mem.length).append(",\n");
		sb.append("mem = [")
				.append(IntStream.range(0, top + 1).mapToObj(x -> "" + mem[x]).collect(Collectors.joining(", ")))
				.append("],\n");
		sb.append("next = ").append(next == null ? "null" : "\n" + next.toString()).append("\n}\n");
		return sb.toString();
	}

	public static void main(String[] args) {

		Stack stack = new Stack(5);

		stack.push(3);
		stack.push(4);
		stack.push(5);

		System.out.println(stack.top());
		System.out.println(stack.pop());
		System.out.println(stack.top());

	}
}
