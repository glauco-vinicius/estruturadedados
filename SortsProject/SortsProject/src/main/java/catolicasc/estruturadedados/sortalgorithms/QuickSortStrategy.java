package catolicasc.estruturadedados.sortalgorithms;

import java.util.ArrayDeque;
import java.util.Stack;

/**
 * Ordena usando o método quicksort
 * 
 * javarevisited.blogspot.com/2016/09/iterative-quicksort-example-in-java-without-recursion.html#ixzz5i0V1Fj00
 * 
 * http://www.sonic.net/~jddarcy/Research/cs339-quicksort.pdf
 * 
 * http://www.java67.com/2014/07/quicksort-algorithm-in-java-in-place-example.html
 * 
 * @author Glauco Vinicius Scheffel
 */
public class QuickSortStrategy extends AbstractSortStrategy {
	/**
	 * Implementa a ordenação pelo método
	 */
	@Override
	public void sort() {
		final int[] data = this.getElements();
		final ArrayDeque<Integer> stack = new ArrayDeque<Integer>();
		stack.push(0);
		stack.push(data.length);
		while (! stack.isEmpty()) {
			int end = stack.pop();
			int start = stack.pop();
			if (end - start >= 2) {
				int p = start + ((end - start) / 2);
				p = partition(data, p, start, end);
				stack.push(p + 1);
				stack.push(end);
				stack.push(start);
				stack.push(p);
			}
		}
	}

	private final int partition(final int[] input, final int position, final int start, final int end) {
		int l = start;
		int h = end - 2;
		int piv = input[position];
		swap(input, position, end - 1);
		while (l < h) {
			if (input[l] < piv) {
				l++;
			} else if (input[h] >= piv) {
				h--;
			} else {
				swap(input, l, h);
			}
		}
		int idx = h;
		if (input[h] < piv) {
			idx++;
		}
		swap(input, end - 1, idx);
		return idx;
	}

	private final void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	@Override
	public String toString() {
		return "QuickSort";
	}
}
