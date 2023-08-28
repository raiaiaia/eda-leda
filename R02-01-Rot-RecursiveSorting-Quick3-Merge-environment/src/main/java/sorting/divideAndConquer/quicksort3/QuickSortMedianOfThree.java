package sorting.divideAndConquer.quicksort3;

import sorting.AbstractSorting;
import util.Util;

/**
 * A classe QuickSortMedianOfThree representa uma variação do QuickSort que
 * funciona de forma ligeiramente diferente. Relembre que quando o pivô
 * escolhido divide o array aproximadamente na metade, o QuickSort tem um
 * desempenho perto do ótimo. Para aproximar a entrada do caso ótimo, diversas
 * abordagens podem ser utilizadas. Uma delas é usar a mediana de 3 para achar o
 * pivô. Essa técnica consiste no seguinte:
 * 1. Comparar o elemento mais a esquerda, o central e o mais a direita do intervalo.
 * 2. Ordenar os elementos, tal que: A[left] < A[center] < A[right].
 * 3. Adotar o A[center] como pivô.
 * 4. Colocar o pivô na penúltima posição A[right-1].
 * 5. Aplicar o particionamento considerando o vetor menor, de A[left+1] até A[right-1].
 * 6. Aplicar o algoritmo na particao a esquerda e na particao a direita do pivô.
 */
public class QuickSortMedianOfThree<T extends Comparable<T>> extends
		AbstractSorting<T> {

	public void sort(T[] array, int leftIndex, int rightIndex) {
		if(leftIndex < rightIndex){
			int pivotIndex = partition(array, leftIndex, rightIndex);
			sort(array, leftIndex, pivotIndex - 1);
			sort(array, pivotIndex + 1, rightIndex);
		}
	}

	private int partition(T[] array, int leftIndex, int rightIndex) {
		pivotMedianOfThree(array, leftIndex, rightIndex);
		T pivot = array[leftIndex];
        int i = leftIndex;
        for(int j = i + 1; j <= rightIndex; j++){
            if(array[j].compareTo(pivot) < 0){
                i++;
                Util.swap(array, i, j);
            }
        }
        Util.swap(array, leftIndex, i);
        return i;
	}

	private void pivotMedianOfThree(T[] array, int leftIndex, int rightIndex){
		int middleIndex = (rightIndex + leftIndex)/2;
		T[] candidates = (T[]) new Comparable[]{array[leftIndex], array[middleIndex], array[rightIndex]};
		Integer[] candidatesIndex = new Integer[]{leftIndex, middleIndex, rightIndex};

		for(int i=0; i<candidates.length-1; i++){
			int smallestIndex = i;
			for(int j=i+1; j<candidates.length-1; j++){
				if(array[j].compareTo(array[smallestIndex]) < 0){
					smallestIndex = j;
				}
			}
			Util.swap(candidates, i, smallestIndex);
			Util.swap(candidatesIndex, i, smallestIndex);
		}
		Util.swap(array, candidatesIndex[1], rightIndex-1);
	}
}