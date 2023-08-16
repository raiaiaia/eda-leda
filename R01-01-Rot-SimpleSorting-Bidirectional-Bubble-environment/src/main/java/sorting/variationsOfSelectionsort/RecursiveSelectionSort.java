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
	 * 
	 * 10 2 4 1 -1
	 */
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {

		if(array != null && array.length != 0 && leftIndex >= 0 && rightIndex <= array.length -1){

			int smallestIndex = leftIndex;
			
			for(int i= leftIndex; i <= rightIndex; i++){
				if(array[i].compareTo(array[smallestIndex]) < 0){
				smallestIndex = i;
				}
			}

			Util.swap(array,leftIndex,smallestIndex);

			if(leftIndex < rightIndex){
				sort(array, ++leftIndex, rightIndex);
			}
		
		}
	
	}

}
