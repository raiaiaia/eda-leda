package adt.heap.extended;

import java.util.Comparator;

import adt.heap.ComparatorMaxHeap;
import adt.heap.ComparatorMinHeap;
import adt.heap.HeapImpl;

public class FloorCeilHeapImpl extends HeapImpl<Integer> implements FloorCeilHeap {

	public FloorCeilHeapImpl(Comparator<Integer> comparator) {
		super(comparator);
	}


	//* 	 * Restricoes
	//* - Da heap voce pode usar apenas os metodos insert, rootElement e extractRootElement
	//* - Voce nao pode ordenar o array
	//* - Voce nao pode tirar uma copia do array e trabalhar nela

	@Override
	public Integer floor(Integer[] array, double numero) {
		if(array != null) {
			for (Integer element : array) 
    			insert(element);	 
		}
		return floor(numero, null);	
	}

	private Integer floor(double numero, Integer floor) {
		Integer root = extractRootElement();
		if (root != null) {
			if (numero >= root && (floor == null || root >= floor))
				floor = floor(numero, root);
			else
				floor = floor(numero, floor);
		}
		return floor;
	}

	
	@Override
	public Integer ceil(Integer[] array, double numero) {
		if(array != null) {
			for (Integer element : array) 
    			insert(element);
		}
		return ceil(numero, null);
	}

	private Integer ceil(double numero, Integer ceil) {
		Integer root = extractRootElement();
		if (root != null) {
			if (numero <= root && (ceil == null || root <= ceil))
				ceil = ceil(numero, root);
			else
				ceil = ceil(numero, ceil);
		}
		return ceil;
	}
}
