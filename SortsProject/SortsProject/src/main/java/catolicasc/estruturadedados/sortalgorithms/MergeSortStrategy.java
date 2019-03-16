package catolicasc.estruturadedados.sortalgorithms;

/**
 * Ordena usando o método merge sort
 * 
 * first version based on https://www.baeldung.com/java-merge-sort
 * 
 * @author Glauco Vinicius Scheffel
 */
public class MergeSortStrategy extends AbstractSortStrategy {
	/**
	 * Implementa a ordenação pelo método da bolha
	 */
	@Override
	public void sort() {
		int[] elementos = this.getElements();
		int tamanho = elementos.length;
		int percorrerAtéPosição = tamanho - 1;

        mergeSort(elementos,percorrerAtéPosição );

	}

	private final void mergeSort(int[] data, int size) {
		if (size < 2) {
			return;
		}
		int mid = size / 2;
		int[] l = new int[mid];
		int[] r = new int[size - mid];

		for (int i = 0; i < mid; i++) {
			l[i] = data[i];
		}
		for (int i = mid; i < size; i++) {
			r[i - mid] = data[i];
		}
		mergeSort(l, mid);
		mergeSort(r, size - mid);

		merge(data, l, r, mid, size - mid);
	}

	public final void merge(int[] data, int[] leftPartition, int[] rightPartition, int left, int right) {

		int i = 0, j = 0, position = 0;
		while (i < left && j < right) {
			if (leftPartition[i] <= rightPartition[j]) {
				data[position++] = leftPartition[i++];
			} else {
				data[position++] = rightPartition[j++];
			}
		}
		while (i < left) {
			data[position++] = leftPartition[i++];
		}
		while (j < right) {
			data[position++] = rightPartition[j++];
		}
	}

	@Override
	public String toString() {
		return "MergeSortStrategy";
	}
}