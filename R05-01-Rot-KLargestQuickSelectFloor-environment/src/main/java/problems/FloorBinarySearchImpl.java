package problems;

import util.Util;

public class FloorBinarySearchImpl implements Floor {

	@Override
	public Integer floor(Integer[] array, Integer x) {
		Integer result = null;
		if(array.length > 0){
			quickSort(array, 0, array.length-1);
			result = binarySearch(array, x, 0, array.length-1);
		}
		return result;
	}

	private Integer binarySearch(Integer[] array, Integer x, int leftIndex, int rightIndex) {
		Integer out = null;
		if(leftIndex <= rightIndex){
			Integer middle = (leftIndex + rightIndex)/2;

			if(middle+1 <= rightIndex && array[middle+1] <= x){
				out = binarySearch(array,x, middle+1, rightIndex);
			}else if(array[middle] <= x){
				out = array[middle];
			}else{
				out = binarySearch(array, x, leftIndex, middle-1);
			}
		}
		return out;
	}

	private void quickSort(Integer[] array, Integer leftIndex, Integer rightIndex){
		if(array.length > 0 && leftIndex >=0 && rightIndex <= array.length-1){
			if(leftIndex < rightIndex){
				int pivotIndex = partition(array, leftIndex, rightIndex);
				quickSort(array, leftIndex, pivotIndex-1);
				quickSort(array, pivotIndex+1, rightIndex);
			}
		}
	}

	private Integer partition(Integer[] array, Integer leftIndex, Integer rightIndex) {
		Integer pivot = array[leftIndex];
		int i = leftIndex;
		for(int j = i+1; j<= rightIndex; j++){
			if(array[j] < pivot) {
				Util.swap(array, ++i, j);
			}
		}
		Util.swap(array, leftIndex, i);
		return i;
	}
}