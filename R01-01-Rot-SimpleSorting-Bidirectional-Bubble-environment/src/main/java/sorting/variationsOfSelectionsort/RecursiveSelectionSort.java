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
		if(array != null && leftIndex >= 0 && rightIndex <= array.length-1){
			if(leftIndex < rightIndex){
				int smallestIndex = selectionMinimun(array, leftIndex, rightIndex, leftIndex);
				Util.swap(array, leftIndex, smallestIndex);
				sort(array, ++leftIndex, rightIndex);
			}
		}
	}

	private int selectionMinimun(T[] array, int leftIndex, int rightIndex, int smallestIndex){
		int result;
		if(leftIndex < rightIndex){
			if(array[smallestIndex].compareTo(array[leftIndex+1]) > 0){
				smallestIndex = leftIndex + 1;
			}
			result = selectionMinimun(array, ++leftIndex, rightIndex, smallestIndex);
		} else {
			result = smallestIndex;
		}

		return result;
	}

}
