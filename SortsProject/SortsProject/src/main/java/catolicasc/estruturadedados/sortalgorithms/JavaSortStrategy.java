package catolicasc.estruturadedados.sortalgorithms;

import java.util.Arrays;

/**
 * Ordena usando a ordenação do Java na classe Arrays
 * 
 * http://hg.openjdk.java.net/jdk8u/jdk8u/jdk/file/be44bff34df4/src/share/classes/java/util/Arrays.java
 * 
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
