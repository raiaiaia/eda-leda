package sorting.variationsOfSelectionsort;
import util.Util;

import sorting.AbstractSorting;

public class RecursiveSelectionSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	/**
	 * Implementação recursiva do selection sort. Você deve implementar apenas
	 * esse método sem usar nenhum outro método auxiliar (exceto
	 * Util.swap(array,int,int)). Para isso, tente definir o caso base do
	 * algoritmo e depois o caso indutivo, que reduz o problema para uma entrada
	 * menor em uma chamada recursiva. Seu algoritmo deve ter complexidade
	 * quadrática O(n^2).
	 */
	
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {

		if(array != null && array.length != 0 && leftIndex >= 0 && rightIndex <= array.length -1){

			if(leftIndex < rightIndex){
				selectionMinimun(array, leftIndex, rightIndex);
				sort(array, ++leftIndex, rightIndex);
			}
		
		}
	
	}

	public void selectionMinimun(T[] array, int leftIndex, int rightIndex){

		if(leftIndex >= rightIndex){
			return;
		}

		if(array[leftIndex].compareTo(array[leftIndex+1]) > 0){
			Util.swap(array, leftIndex, leftIndex+1);
		}

		selectionMinimun(array, ++leftIndex, rightIndex);
	}

}
