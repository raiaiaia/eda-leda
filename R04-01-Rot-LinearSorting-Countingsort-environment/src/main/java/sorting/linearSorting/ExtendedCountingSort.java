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

		if(array.length > 0){
			int k = encontraMaior(array, leftIndex, rightIndex);
			int menor = encontraMenor(array, leftIndex, rightIndex);

			int[] c = new int[k - menor + 1];

			//frequencia
			if(menor < 0){
			  for(int i=leftIndex; i <= rightIndex; i++)
				c[array[i] - menor]++;
			}else{
			  for(int i=leftIndex; i <= rightIndex; i++)	
				c[array[i]]++;
			}
			
			//cumulativa
			for(int i=1; i < c.length; i++)
				c[i] += c[i-1];

			int[] b = new int[rightIndex - leftIndex + 1];

			if(menor < 0){
				for(int i=rightIndex; i >= leftIndex; i--){
					b[c[array[i]]- menor] = array[i];
					c[array[i]]--;
				}
			}else{
				for(int i=rightIndex; i >= leftIndex; i--){
					b[c[array[i]]-1] = array[i];
					c[array[i]]--;
				}
			}
			

			int j = leftIndex;
			//copiar os valores ordenados de "b" para "array"
			for(int i=0; i<b.length; i++)
				if(i == j) array[i] = b[j++];
		}
	}

	private int encontraMaior(Integer[] array, int leftIndex, int rightIndex) {
		int maior = array[leftIndex];
		for(int i = leftIndex; i <= rightIndex; i++)
			if(array[i] > maior) maior = array[i];

		return maior;
	}

	private int encontraMenor(Integer[] array, int leftIndex, int rightIndex) {
		int menor = array[leftIndex];
		for(int i = leftIndex; i <= rightIndex; i++)
			if(array[i] < menor) menor = array[i];
		
		return menor;
	}
}