package catolicasc.estruturadedados.sortalgorithms;

import java.util.Stack;

/**
 * Ordena usando o método quicksort
 * 
 * javarevisited.blogspot.com/2016/09/iterative-quicksort-example-in-java-without-recursion.html#ixzz5i0V1Fj00
 * 
 * @author Glauco Vinicius Scheffel
 */
public class QuickSortStrategy extends AbstractSortStrategy {
	/**
	 * Implementa a ordenação pelo método
	 */
	@Override
	public void sort() {
		int[] data = this.getElements();
		iterativeQsort(data);
	}

	private  int partition(int[] input, int position, int start, int end) {
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

	private void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public void iterativeQsort(int[] numbers) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(0);
		stack.push(numbers.length);
		while (!stack.isEmpty()) {
			int end = stack.pop();
			int start = stack.pop();
			if (end - start < 2) {
				continue;
			}
			int p = start + ((end - start) / 2);
			p = partition(numbers, p, start, end);
			stack.push(p + 1);
			stack.push(end);
			stack.push(start);
			stack.push(p);
		}
	}

	@Override
	public String toString() {
		return "QuickSort";
	}
}
