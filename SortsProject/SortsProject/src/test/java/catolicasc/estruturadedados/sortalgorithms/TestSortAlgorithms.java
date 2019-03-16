package catolicasc.estruturadedados.sortalgorithms;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import junit.framework.TestCase;

import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import catolicasc.estruturadedados.sortalgorithms.BubbleSortStrategy;
import catolicasc.estruturadedados.sortalgorithms.IStrategy;
import catolicasc.estruturadedados.sortalgorithms.InsertionSortStrategy;
import catolicasc.estruturadedados.sortalgorithms.SelectionSortStrategy;
import catolicasc.estruturadedados.sortalgorithms.StrategyCommand;

import org.junit.runner.RunWith;

/**
 * Unit test for sort methods using Strategy as technique for separation of
 * concerns.
 * 
 * O programa de testes usa o modelo de testes parametrizáveis do JUnit para que
 * a lógica de teste seja mais simples.
 * 
 * @author Glauco Vinicius Scheffel
 */

@RunWith(Parameterized.class)
public final class TestSortAlgorithms extends TestCase {
	final static int SIZE = 680000;
	final static int[] data = new int[SIZE];

	@Parameter
	public IStrategy strategy;

	@Parameter(1)
	public int tamanho;

	static {
		try {
			SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
			sr.generateSeed(8);
			Arrays.stream(data).forEach(
				(e) -> {
							e =  sr.nextInt(); 
					   }
				);
		} catch (NoSuchAlgorithmException e) {
			System.out.println("Exception thrown : " + e);
		}

	}

	@Parameters(name = "{index}: algoritmo {0}({1})")
	public static Collection<Object[]> data() {
		Collection<Object[]> tests = new ArrayList<Object[]>();
		IStrategy strategies[] = new IStrategy[7];
		strategies[0] = new BubbleSortStrategy();
		strategies[1] = new SelectionSortStrategy();
		strategies[2] = new ShellSortStrategy();
		strategies[3] = new InsertionSortStrategy();
		strategies[4] = new HeapSortStrategy();
		strategies[5] = new MergeSortStrategy();
		strategies[6] = new QuickSortStrategy();
		int value = 80000;
		while( value <= SIZE  ) {
			for (int i = 0; i < strategies.length; i++) {
				Object o[] = {strategies[i],value};
				tests.add(o);
			}
			value *= 2;
		}
		return tests;
	}

	/**
	 * Verifica se o conjunto esta ordenado pela estratégia passada
	 * 
	 * @param strategy
	 * @return
	 */
	private boolean isSorted(int elements[]) {
		for (int i = 0; i < elements.length - 1; i++) {
			int j = elements[i];
			boolean cond = (j <= elements[i + 1]);
			if (cond == false) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Organiza os elementos de acordo com o tamanho especificado e o algoritmo
	 * escolhido
	 * 
	 * @param strategy
	 * @param elements
	 * @return
	 */
	private int[] sort(IStrategy strategy, int[] elements) {
		System.arraycopy(elements, 0, data, 0, elements.length);
		StrategyCommand.execute(elements, strategy);
		return elements;
	}

	/**
	 * Verifica se o BubbleSort foi executado corretamente
	 */
	@org.junit.Test
	public void testSortAlgorithms() {
		int[] elements = new int[tamanho];
		elements = this.sort(strategy, elements);
		boolean sorted = isSorted(elements);
		assertTrue(sorted);
	}

}
