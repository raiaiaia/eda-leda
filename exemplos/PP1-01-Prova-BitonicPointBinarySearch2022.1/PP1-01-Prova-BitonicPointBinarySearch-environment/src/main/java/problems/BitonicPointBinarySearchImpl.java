package problems;

public class BitonicPointBinarySearchImpl<T extends Comparable<T>> implements BitonicPointBinarySearch<T> {

	@Override
	public T bitonicPoint(T[] array) {
		T result = null;
		if(array.length > 0){
			result = searchBitonicPoint(array, 0, array.length-1);
		}

		return result;
	}

	private T searchBitonicPoint(T[] array, int leftIndex, int rightIndex){
		T result = null;

		if(leftIndex >= 0 && rightIndex <= array.length-1){
			if(leftIndex <= rightIndex){
				int middle = (leftIndex + rightIndex)/2;

				if(middle+1 <= rightIndex && array[middle+1].compareTo(array[middle]) < 0 && middle-1 >= leftIndex){
					result = searchBitonicPoint(array, leftIndex, middle-1);
				}else if(middle+1 <= rightIndex && array[middle+1].compareTo(array[middle]) > 0){
					result = searchBitonicPoint(array, middle+1, rightIndex);
				}else if(middle == rightIndex){
					result = array[middle];
				}else{
					result = searchBitonicPoint(array, middle+1, rightIndex);
				}
			}
		}
		return result;
	}
}