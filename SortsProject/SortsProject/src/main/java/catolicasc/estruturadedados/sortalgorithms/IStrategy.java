package catolicasc.estruturadedados.sortalgorithms;

/**
 * Interface implementada pelos algoritmos de ordenação
 * @author Glauco Vinicius Scheffel
 */
public interface IStrategy {
	   /**
	    * Realiza a ordenação
	    */
	   public abstract void sort();
	   /**
	    * Retorna o array com os dados
	    * @return
	    */
	   public int[] getElements();
	   /**
	    * Registra os elementos que serão ordenados
	    * @param elements
	    */
       public void setElements(int[] elements);		
}