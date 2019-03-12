package catolicasc.estruturadedados.sortalgorithms;
/**
 * Ordena usando o método da inserção
 * @author udesc
 */
public class InsertionSortStrategy extends AbstractSortStrategy {
	/**
	 * Implementa a ordenação pelo método da inserção
	 */
	@Override
	public void sort() {
        int[] elementos = this.getElements();
        int tamanho = elementos.length;
        int valor,j;
        
        for(int i = 1;i<= tamanho-1;i++) {
        	valor = elementos[i];
        	j = i-1;
        	while(j>=0 && elementos[j]>valor) {
        		elementos[j+1] = elementos[j];
        		j = j -1;
        		
        	}
        	elementos[j+1] = valor;
        }

	}
	
	@Override
	public String toString() {
		return "InsertionSort";
	}
}
