package catolicasc.estruturadedados.sortalgorithms;
/**
 * Ordena usando o método da seleção
 * @author Glauco Vinicius Scheffel
 */
public class SelectionSortStrategy extends AbstractSortStrategy {
	/**
	 * Implementa a ordenação pelo método da seleção
	 */
	@Override
	public void sort() {
        int[] elementos = this.getElements();
        int tamanho = elementos.length;
        int ultimaPosição =tamanho-1;
        int min,max;
        for(int i=0;i<tamanho;i++) {
        	min=i;
        	for(int j=i+1;j<tamanho;j++) {
        		if(elementos[j]<elementos[min]){
        			min=j;
        		}
        	}
        	this.swap(i, min);
        	
        }
        
	}
	
	@Override
	public String toString() {
		return "SelectionSort";
	}
}
