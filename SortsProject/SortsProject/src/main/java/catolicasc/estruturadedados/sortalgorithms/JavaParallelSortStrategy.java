package catolicasc.estruturadedados.sortalgorithms;

import java.util.Arrays;

/**
 * Ordena usando ordenação paralela do Arrays
 * @author Glauco Vinicius Scheffel
 */
public class JavaParallelSortStrategy extends AbstractSortStrategy {
	/**
	 * Implementa a ordenação pelo método da inserção
	 */
	@Override
	public void sort() {
        int[] elementos = this.getElements();
        Arrays.parallelSort(elementos);

	}
	
	@Override
	public String toString() {
		return "Java Parallel Algorithm";
	}
}
