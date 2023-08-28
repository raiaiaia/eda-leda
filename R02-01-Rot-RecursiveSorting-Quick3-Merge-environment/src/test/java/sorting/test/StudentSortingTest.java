package sorting.test;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import sorting.AbstractSorting;
import sorting.divideAndConquer.MergeSort;
import sorting.divideAndConquer.QuickSort;
import sorting.divideAndConquer.hybridMergesort.HybridMergeSort;
import sorting.divideAndConquer.quicksort3.QuickSortMedianOfThree;

public class StudentSortingTest {

	private Integer[] vetorTamPar;
	private Integer[] vetorTamImpar;
	private Integer[] vetorVazio = {};
	private Integer[] vetorValoresRepetidos;
	private Integer[] vetorValoresIguais;


	//Meus testes
	private Integer[] vetorOrdenado;
	private Integer[] vetorOrdenadoCrescente;
	private Integer[] vetorOrdenadoDecrescente;
	private Integer[] vetorOrdenadoUltimoElemento;
	private Integer[] vetorOrdenadoPrimeiroElemento;
	private Integer[] vetorUmElemento;

	public AbstractSorting<Integer> implementation;

	@Before
	public void setUp() {
		populaVetorTamanhoPar(new Integer[] { 30, 28, 7, 29, 11, 26, 4, 22, 23,
				31 });
		populaVetorTamanhoImpar(new Integer[] { 6, 41, 32, 7, 26, 4, 37, 49,
				11, 18, 36 });
		populaVetorRepetido(new Integer[] { 4, 9, 3, 4, 0, 5, 1, 4 });
		populaVetorIgual(new Integer[] { 6, 6, 6, 6, 6, 6 });

		getImplementation();


		//Meus testes
		populaVetorOrdenado(new Integer[] {1, 7, 18, 29, 110});
		populaVetorOrdenadoCrescente(new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
		populaVetorOrdenadoDecrescente(new Integer[] {10, 5, 3, -1, -15});
		populaVetorOrdenadoUltimoElemento(new Integer[] {1, 2, 3, 4, 5, 0});
		populaVetorOrdenadoPrimeiroElemento(new Integer[] {10, 2, 3, 4});
		populaVetorUmElemento(new Integer[] { 1 });
	}

	// // MÉTODOS AUXILIARES DA INICIALIZAÇÃO
	/**
	 * Método que inicializa a implementação a ser testada com a implementação
	 * do aluno
	 */
	private void getImplementation() {
		// TODO O aluno deve instanciar sua implementação abaixo ao invés de
		// null
		this.implementation = new MergeSort<Integer>();
		//Assert.fail("Implementation not provided");
	}

	public void populaVetorTamanhoPar(Integer[] arrayPadrao) {
		this.vetorTamPar = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorTamanhoImpar(Integer[] arrayPadrao) {
		this.vetorTamImpar = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorRepetido(Integer[] arrayPadrao) {
		this.vetorValoresRepetidos = Arrays.copyOf(arrayPadrao,
				arrayPadrao.length);
	}

	public void populaVetorIgual(Integer[] arrayPadrao) {
		this.vetorValoresIguais = Arrays
				.copyOf(arrayPadrao, arrayPadrao.length);
	}

	//Meus testes
	private void populaVetorOrdenadoCrescente(Integer[] arrayPadrao) {
		this.vetorOrdenadoCrescente = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}
	private void populaVetorOrdenado(Integer[] arrayPadrao) {
		this.vetorOrdenado = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}
	private void populaVetorOrdenadoDecrescente(Integer[] arrayPadrao) {
		this.vetorOrdenadoDecrescente = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}
	private void populaVetorOrdenadoUltimoElemento(Integer[] arrayPadrao) {
		this.vetorOrdenadoUltimoElemento = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}
	private void populaVetorOrdenadoPrimeiroElemento(Integer[] arrayPadrao) {
		this.vetorOrdenadoPrimeiroElemento = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}
	public void populaVetorUmElemento(Integer[] arrayPadrao) {
		this.vetorUmElemento = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	// FIM DOS METODOS AUXILIARES DA INICIALIZAÇÃO

	// MÉTODOS DE TESTE

	public void genericTest(Integer[] array) {
		Integer[] copy1 = {};
		if(array.length > 0){
			copy1 = Arrays.copyOf(array, array.length);			
		}
		implementation.sort(array);
		Arrays.sort(copy1);
		Assert.assertArrayEquals(copy1, array);
	}



	@Test
	public void testSort01() {
		genericTest(vetorTamPar);
	}

	@Test
	public void testSort02() {
		genericTest(vetorTamImpar);
	}

	@Test
	public void testSort03() {
		genericTest(vetorVazio);
	}

	@Test
	public void testSort04() {
		genericTest(vetorValoresIguais);
	}

	@Test
	public void testSort05() {
		genericTest(vetorValoresRepetidos);
	}

	// MÉTODOS QUE OS ALUNOS PODEM CRIAR
	/**
	 * O ALUNO PODE IMPLEMENTAR METODOS DE ORDENAÇÃO TESTANDO O SORT COM TRES
	 * ARGUMENTOS PARA TESTAR A ORDENACAO EM UM PEDAÇO DO ARRAY. DICA: PROCUREM
	 * SEGUIR A ESTRUTURA DOS MÉTODOS DE TESTE ACIMA DESCRITOS, ORDENANDO APENAS
	 * UMA PARTE DO ARRAY.
	 */


	 @Test
	 public void testSort06(){
		genericTest(vetorOrdenado);
	 }

	 @Test
	 public void testSort07(){
		genericTest(vetorOrdenadoCrescente);
	 }

	 @Test
	 public void testSort08(){
		genericTest(vetorOrdenadoDecrescente);
	 }

	 @Test
	 public void testSort09(){
		genericTest(vetorOrdenadoPrimeiroElemento);
	 }

	 @Test
	 public void testSort10(){
		genericTest(vetorOrdenadoUltimoElemento);
	 }

	 public void sortToTheMiddle(Integer[] array) {
		Integer[] copy1 = new Integer[array.length];
		if (array.length > 0) {
			for (int i = 0; i <= (int) Math.ceil(array.length / 2); i++) {
				copy1[i] = array[i];
			}

			Arrays.sort(copy1, 0, (int) Math.ceil(array.length / 2) + 1);

			for (int i = (int) Math.ceil(array.length / 2) + 1; i < array.length; i++) {
				copy1[i] = array[i];
			}
			implementation.sort(array, 0, (int) Math.ceil(array.length / 2));
		}
		Assert.assertArrayEquals(copy1, array);
	}

	public void sortFromMiddleToTheEnd(Integer[] array) {
		Integer[] copy1 = new Integer[array.length];
		if (array.length > 0) {
			for (int i = (int) Math.ceil(array.length / 2); i < array.length; i++) {
				copy1[i] = array[i];
			}

			Arrays.sort(copy1, (int) Math.ceil(array.length / 2), array.length);

			for (int i = 0; i < (int) Math.ceil(array.length / 2); i++) {
				copy1[i] = array[i];
			}

			implementation.sort(array, (int) Math.ceil(array.length / 2), array.length - 1);
		}

		Assert.assertArrayEquals(copy1, array);
	}

	public void sortJustMiddle(Integer[] array) {
		Integer[] copy1 = new Integer[array.length];
		if (array.length > 1) {
			for (int i = 0; i < array.length; i++) {
				copy1[i] = array[i];
			}
			Arrays.sort(copy1, (int) Math.ceil(array.length / 2) - 2, array.length - 2);

			implementation.sort(array, (int) Math.ceil(array.length / 2) - 2, array.length - 3);
			
			Assert.assertArrayEquals(copy1, array);
		}
	}

	@Test
	public void testSort12() {
		sortToTheMiddle(vetorTamImpar);
	}

	@Test
	public void testSort13() {
		sortToTheMiddle(vetorVazio);
	}

	@Test
	public void testSort14() {
		sortToTheMiddle(vetorValoresIguais);
	}

	@Test
	public void testSort15() {
		sortToTheMiddle(vetorValoresRepetidos);
	}

	@Test
	public void testSort16() {
		sortToTheMiddle(vetorUmElemento);
	}

	@Test
	public void testSort24() {
		sortFromMiddleToTheEnd(vetorTamImpar);
	}

	@Test
	public void testSort25() {
		sortFromMiddleToTheEnd(vetorVazio);
	}

	@Test
	public void testSort26() {
		sortFromMiddleToTheEnd(vetorValoresIguais);
	}

	@Test
	public void testSort27() {
		sortFromMiddleToTheEnd(vetorValoresRepetidos);
	}

	@Test
	public void testSort28() {
		sortFromMiddleToTheEnd(vetorUmElemento);
	}

	@Test
	public void testSort29() {
		sortJustMiddle(vetorTamPar);
	}

	@Test
	public void testSort30() {
		sortJustMiddle(vetorTamImpar);
	}

	@Test
	public void testSort31() {
		sortJustMiddle(vetorVazio);
	}

	@Test
	public void testSort32() {
		sortJustMiddle(vetorValoresIguais);
	}

	@Test
	public void testSort33() {
		sortJustMiddle(vetorValoresRepetidos);
	}

	@Test
	public void testSort34() {
		sortJustMiddle(vetorUmElemento);
	}	
}