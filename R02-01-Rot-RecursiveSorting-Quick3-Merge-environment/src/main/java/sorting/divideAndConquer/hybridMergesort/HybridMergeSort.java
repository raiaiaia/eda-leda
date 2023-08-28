package sorting.divideAndConquer.hybridMergesort;

import sorting.AbstractSorting;

/**
 * A classe HybridMergeSort representa a implementação de uma variação do
 * MergeSort que pode fazer uso do InsertionSort (um algoritmo híbrido) da
 * seguinte forma: o MergeSort é aplicado a entradas maiores a um determinado
 * limite. Caso a entrada tenha tamanho menor ou igual ao limite o algoritmo usa
 * o InsertionSort.
 * 
 * A implementação híbrida deve considerar os seguintes detalhes:
 * - Ter contadores das quantidades de MergeSorts e InsertionSorts aplicados, de forma
 *   que essa informação possa ser capturada pelo teste.
 * - A cada chamado do método de sort(T[] array) esses contadores são resetados. E a cada chamada
 *   interna de um merge ou insertion, os contadores MERGESORT_APPLICATIONS e
 *   INSERTIONSORT_APPLICATIONS são incrementados.
 * - O InsertionSort utilizado no algoritmo híbrido deve ser in-place.
 */
public class HybridMergeSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	/**
	 * For inputs with size less or equal to this value, the insertionsort
	 * algorithm will be used instead of the mergesort.
	 */
	public static final int SIZE_LIMIT = 4;

	protected static int MERGESORT_APPLICATIONS = 0;
	protected static int INSERTIONSORT_APPLICATIONS = 0;

	public void sort(T[] array, int leftIndex, int rightIndex) {

		if(leftIndex < rightIndex && rightIndex > 4){
            int middle = (rightIndex + leftIndex)/2;
            sort(array, leftIndex, middle);
            sort(array, middle+1, rightIndex);
            merge(array, leftIndex, middle, rightIndex);
			MERGESORT_APPLICATIONS++;
		}else{
			insertionSort(array, leftIndex, rightIndex);
			INSERTIONSORT_APPLICATIONS++;
		}
	}

	private void merge(T[] array, int leftIndex, int middle, int rightIndex){
		T[] helper = (T[]) new Comparable[array.length];
        for(int i=leftIndex; i <= rightIndex; i++){
            helper[i] = array[i];
        }
        int i = leftIndex;
        int j = middle+1;
        int k = leftIndex;
        while(i <= middle && j <= rightIndex){
            if(helper[i].compareTo(helper[j]) <= 0){
                array[k++] = helper[i++];
            }else{
                array[k++] = helper[j++];
            }
        }
        while(i <= middle){
            array[k++] = helper[i++];
        }
        while(j <= rightIndex){
            array[k++] = helper[j++];
        }

	}

	private void insertionSort(T[] array, int leftIndex, int rightIndex){
        if(rightIndex > leftIndex){
        	insertionSort(array, leftIndex, rightIndex - 1);
        	T last = array[rightIndex];
        	int j = rightIndex - 1;
			while(j >= 0 && array[j].compareTo(last) > 0){
            	array[j+1] = array[j];
            	j--;
        	}
        	array[j+1] = last;
		}
    }
}