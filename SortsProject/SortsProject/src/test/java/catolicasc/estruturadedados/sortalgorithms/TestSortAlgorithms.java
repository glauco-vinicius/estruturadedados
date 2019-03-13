package catolicasc.estruturadedados.sortalgorithms;

import java.util.Arrays;
import java.util.Collection;
import java.util.Random;

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
 * O programa de testes usa o modelo de testes parametrizáveis do JUnit para
 * que a lógica de teste seja mais simples.
 * 
 * @author Glauco Vinicius Scheffel
 */

@RunWith(Parameterized.class)
public final class TestSortAlgorithms extends TestCase {
	final static int SIZE = 340000;
	final static int[] data = new int[SIZE];
	
	@Parameter  
	public IStrategy strategy;

    @Parameter(1)
    public int tamanho;
	
	static {
		Random rnd = new Random();
		for (int i = 0; i < SIZE; i++) {
			data[i] = rnd.nextInt();
		}
	}
	
	@Parameters(name = "{index}: algoritmo {0}({1})")
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] 
		    {
			{ new InsertionSortStrategy(), 20000 }, { new InsertionSortStrategy(), 40000 }, 
			{ new InsertionSortStrategy(), 80000 }, { new InsertionSortStrategy(), 160000 },{ new InsertionSortStrategy(), SIZE },
				{ new BubbleSortStrategy(), 20000 }, { new BubbleSortStrategy(), 40000 }, 
				{ new BubbleSortStrategy(), 80000 }, { new BubbleSortStrategy(), 160000 },{ new BubbleSortStrategy(), SIZE },
				{ new SelectionSortStrategy(), 20000 }, { new SelectionSortStrategy(), 40000 }, 
				{ new SelectionSortStrategy(), 80000 }, { new SelectionSortStrategy(), 160000 },{ new SelectionSortStrategy(), SIZE },
				{ new ShellSortStrategy(), 20000 }, { new ShellSortStrategy(), 40000 }, 
				{ new ShellSortStrategy(), 80000 }, { new ShellSortStrategy(), 160000 },{ new ShellSortStrategy(), SIZE },				
				{ new HeapSortStrategy(), 20000 }, { new HeapSortStrategy(), 40000 }, 
				{ new HeapSortStrategy(), 80000 }, { new HeapSortStrategy(), 160000 },{ new HeapSortStrategy(), SIZE },
				{ new QuickSortStrategy(), 20000 }, { new QuickSortStrategy(), 40000 }, 
				{ new QuickSortStrategy(), 80000 }, { new QuickSortStrategy(), 160000 },{ new QuickSortStrategy(), SIZE },				
			});
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
	 * Organiza os elementos de acordo com o tamanho especificado e o algoritmo escolhido
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
