package catolicasc.estruturadedados.sortalgorithms;

/**
 * Ordena usando o método ShellSort
 * 
 * @author Glauco Vinicius Scheffel
 */
public class ShellSortStrategy extends AbstractSortStrategy {
	/**
	 * Implementa a ordenação pelo método da seleção
	 */
	@Override
	public void sort() {
		int[] data = this.getElements();
		int len = data.length;
		int inner, outer;
		int temp;

		int h = 1;
		while (h <= len / 3)
			h = h * 3 + 1;

		while (h > 0) {

			for (outer = h; outer < len; outer++) {
				temp = data[outer];
				inner = outer;

				while (inner > h - 1 && data[inner - h] >= temp) {
					data[inner] = data[inner - h];
					inner -= h;
				}
				data[inner] = temp;
			}
			h = (h - 1) / 3;  
		}
	}

	@Override
	public String toString() {
		return "ShellSort";
	}
}
