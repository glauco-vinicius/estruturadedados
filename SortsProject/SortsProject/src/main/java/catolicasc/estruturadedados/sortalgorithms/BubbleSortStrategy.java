package catolicasc.estruturadedados.sortalgorithms;
/**
 * Ordena usando o método da bolha
 * @author Glauco Vinicius Scheffel
 */
public class BubbleSortStrategy extends AbstractSortStrategy {
	/**
	 * Implementa a ordenação pelo método da bolha
	 */
	@Override
	public void sort() {
        int[] elementos = this.getElements();
        int tamanho = elementos.length;
        int percorrerAtéPosição =tamanho-1;

        for (int aux = 0; aux < tamanho; aux++) {
        	for(int aux2 = 0; aux2 < percorrerAtéPosição; aux2++) {
        		if(elementos[aux2] > elementos [aux2+1]) {
        			this.swap(aux2,aux2+1);
        		}
        	}
        }
       
	}

	@Override
	public String toString() {
		return "BubbleSortStrategy";
	}
}