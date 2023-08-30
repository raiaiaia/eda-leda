package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa do Counting Sort vista em sala. Desta vez este
 * algoritmo deve satisfazer os seguitnes requisitos:
 * - Alocar o tamanho minimo possivel para o array de contadores (C)
 * - Ser capaz de ordenar arrays contendo numeros negativos
 */
public class ExtendedCountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {

		if(array.length > 0 && leftIndex >= 0 && rightIndex < array.length){
			int menor = encontraMenor(array, leftIndex, rightIndex);
			int maior = encontraMaior(array, leftIndex, rightIndex);

			int k = maior - menor;
			int[] c = new int[k+1];

			//frequencia 
			for(int i=leftIndex; i <= rightIndex; i++)	
				c[array[i] - menor]++;	
			
			//cumulativa
			for(int i=1; i < c.length; i++)
				c[i] += c[i-1];
		
			int[] b = new int[rightIndex - leftIndex + 1];

			for(int i=rightIndex; i >= leftIndex; i--){
				b[c[array[i] - menor] -1] = array[i];
				c[array[i]- menor]--;
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
	private int encontraMenor(Integer[] array, int leftIndex, int rightIndex){
		int menor = array[leftIndex];
		for(int i = leftIndex; i <= rightIndex; i++)
			if(array[i] < menor) menor = array[i];
		
		return menor;
	}
}