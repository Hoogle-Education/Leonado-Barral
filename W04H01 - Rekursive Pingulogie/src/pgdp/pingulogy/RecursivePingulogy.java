package pgdp.pingulogy;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.InputMismatchException;

public class RecursivePingulogy {

	static int PADDING = 123;
	static long VALUE_NOT_CALCULATED = -1;
	static long[] pinguSequenceDp;
	static int LIST_SIZE = 268;
	static int intermediateResult = 0;

	// task 1
	public static long pinguSequenceRec(int n, int p0, int p1, int p2) {

		if (n < -122 || n > 145) return -1;

		// dinamic case
		if(pinguSequenceDp[n + PADDING] != VALUE_NOT_CALCULATED) {
			return pinguSequenceDp[n + PADDING];
		}

		// base cases
		if (n == 0) return pinguSequenceDp[n + PADDING] = p0;
		if (n == 1) return pinguSequenceDp[n + PADDING] = p1;
		if (n == 2) return pinguSequenceDp[n + PADDING] = p2;

		// recursive cases
		if (n < 0)
			return pinguSequenceDp[n + PADDING] = 2 * pinguSequenceRec(-n, p0, p1, p2);

		return pinguSequenceDp[n + PADDING]
				= pinguSequenceRec(n-1, p0, p1, p2)
				- pinguSequenceRec(n-2, p0, p1, p2)
				+ 2 * pinguSequenceRec(n-3, p0, p1, p2);
	}

	// task 2
	// Hint: pinguF and pinguM are not static (and must not be changed to it!)
	// more information in the main-method below
	public int pinguF(int n) {
		// base case
		if(n == 0) return 1;

		// recursive case
		return n - pinguM(pinguF(n-1));
	}

	public int pinguM(int n) {
		if(n == 0) return 0;

		return n - pinguF(pinguM((n-1)));
	}

	// task 3
	public static int pinguCode(int n, int m) {
		if (n == 0){
			int copy = intermediateResult;
			intermediateResult = 0;
			return m + copy;
		}

		if ((n + intermediateResult)%2 == 0){
			intermediateResult += (n/2);
			return pinguCode(m, n/2);
		}

		intermediateResult += m;
		return pinguCode(n-1, m/2);
	}

	static int numberOfAlgarismsBinary(int n, int i) {
		if(Math.pow(2, i) > n)
			return i;

		return numberOfAlgarismsBinary(n, i+1);
	}
	// task 4
	public static String pinguDNA(int f, int m) {
		if(f == 0 && m == 0) return "";

		if (f == 0) {
			int sizeOfF = numberOfAlgarismsBinary(m, 0);
			return "A".repeat(sizeOfF);
		}

		if (m == 0) {
			int sizeOfF = numberOfAlgarismsBinary(f, 0);
			return "T".repeat(sizeOfF);
		}

		String aux = "";

		if((f%2 == 0 && m%2 ==0) || (f%2 == 1 && m%2 == 1)) {
			if(f > m) aux += "GT";
			else if (f < m) aux += "GA";
			else aux += "GC";
		} else {
			if(f%2 == 1) aux += "TC";
			else aux += "AC";
		}

		return pinguDNA(f/2, m/2) + aux;
	}

	public static void main(String[] args) {
		// switch value to test other tasks
		int testTask = 4;
		pinguSequenceDp = new long[LIST_SIZE];
		Arrays.fill(pinguSequenceDp, VALUE_NOT_CALCULATED);

		switch (testTask) {
		case 1:
			System.out.println("Task 1 example output");
			for (int i = 0; i < 145; i++) {
				System.out.println(i + ": " + pinguSequenceRec(i, 1, 1, 2));
			}
			break;
		case 2:
			/**
			 * For better testing, pinguF and pinguM are not static. 
			 * Hence, you have to initialize a new RecursivePingulogy Object and 
			 * call the methods on that instance, as you can see below.
			 * You will learn more about object-oriented-programming in the lecture
			 * and week 05+.
			 */
			RecursivePingulogy rp = new RecursivePingulogy();
			System.out.print("Task 2 example output\npinguF: ");
			for (int i = 0; i < 10; i++) {
				System.out.print(rp.pinguF(i) + ", ");
			}
			System.out.print("\npingM: ");
			for (int i = 0; i < 10; i++) {
				System.out.print(rp.pinguM(i) + ", ");
			}
			break;
		case 3:
			System.out.println("Task 3 example output");
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					System.out.println(i + ", " + j + ": " + pinguCode(i, j));
				}
				System.out.println("----------");
			}
			break;
		case 4:
			System.out.println("Task 4 example output");
			System.out.println("pinguDNA(21, 25) = " + pinguDNA(21, 25));
			break;
		default:
			System.out.println("There are only 4 tasks!");
			break;
		}
	}
}
