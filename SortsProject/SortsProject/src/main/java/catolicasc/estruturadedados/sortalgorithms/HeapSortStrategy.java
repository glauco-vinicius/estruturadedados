package catolicasc.estruturadedados.sortalgorithms;

/**
 * Ordena usando o método HeapSort
 * 
 * Com base em:
 * https://www.geeksforgeeks.org/java-program-for-heap-sort/
 * 
 * @author Glauco Vinicius Scheffel
 */
public class HeapSortStrategy extends AbstractSortStrategy {
	/**
	 * Implementa a ordenação pelo método do heapsort
	 */
	@Override
	public void sort() {
		int[] elementos = this.getElements();
		int n = elementos.length;

		for (int i = n / 2 - 1; i >= 0; i--)
			heapify(elementos, n, i);

		for (int i = n - 1; i >= 0; i--) {
			int temp = elementos[0];
			elementos[0] = elementos[i];
			elementos[i] = temp;

			heapify(elementos, i, 0);
		}
	}

	private final void heapify(final int elementos[], final int n, final int i) {
		int largest = i;
		int l = 2 * i + 1;
		int r = 2 * i + 2;

		if (l < n && elementos[l] > elementos[largest])
			largest = l;

		if (r < n && elementos[r] > elementos[largest])
			largest = r;

		if (largest != i) {
			int swap = elementos[i];
			elementos[i] = elementos[largest];
			elementos[largest] = swap;

			heapify(elementos, n, largest);
		}
	}

	@Override
	public String toString() {
		return "HeapSortStrategy";
	}
}