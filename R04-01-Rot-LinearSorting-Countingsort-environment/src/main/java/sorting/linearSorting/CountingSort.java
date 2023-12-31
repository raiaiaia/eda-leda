package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala.
 *
 * Procure evitar desperdício de memória: AO INVÉS de alocar o array de contadores
 * com um tamanho arbitrariamente grande (por exemplo, com o maior valor de entrada possível),
 * aloque este array com o tamanho sendo o máximo inteiro presente no array a ser ordenado.
 *
 * Seu algoritmo deve assumir que o array de entrada nao possui numeros negativos,
 * ou seja, possui apenas numeros inteiros positivos e o zero.
 *
 */
public class CountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {

		if(array.length > 0){
			int k = encontraMaior(array, leftIndex, rightIndex);
			int[] c = new int[k+1];

			//frequencia 
			for(int i=leftIndex; i <= rightIndex; i++)	
				c[array[i]]++;	
			
			//cumulativa
			for(int i=1; i < c.length; i++)
			    c[i] += c[i-1];
			
			int[] b = new int[rightIndex - leftIndex + 1];

			for(int i=rightIndex; i >= leftIndex; i--){
				b[c[array[i]]-1] = array[i];
				c[array[i]]--;
			}

			int j = leftIndex;
			//copiar os valores ordenados de "b" para "array"
			for(int i=0; i<b.length; i++)
				if(i == j) array[j++] = b[i];
		}
	}

	private int encontraMaior(Integer[] array, int leftIndex, int rightIndex){
		int maior = array[leftIndex];
		for(int i = leftIndex; i <= rightIndex; i++)
			if(array[i] > maior) maior = array[i];
		
		return maior;
	}
}