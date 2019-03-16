package catolicasc.estruturadedados.sortalgorithms;

import java.util.Arrays;

/**
 * Ordena usando a ordenação do Java na classe Arrays
 * @author Glauco Vinicius Scheffel
 */
public class JavaSortStrategy extends AbstractSortStrategy {
	/**
	 * Implementa a ordenação pelo método da inserção
	 */
	@Override
	public void sort() {
        int[] elementos = this.getElements();
        Arrays.sort(elementos);

	}
	
	@Override
	public String toString() {
		return "Java Sort Algorithm";
	}
}
