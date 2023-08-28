package roteiroCurto1;

import java.util.Arrays;

public class SelectionSortRecursivo {

    public static void sort(int[] array, int leftIndex, int rightIndex){
        if(leftIndex < rightIndex){
            int menorIndice = encontraMenor(array, leftIndex, rightIndex);
            swap(array, leftIndex, menorIndice);
            sort(array, ++leftIndex, rightIndex);
        }
    }

    private static int encontraMenor(int[] array, int smallestIndex, int rightIndex){
        for(int i=smallestIndex; i<=rightIndex; i++){
            if(array[i] < array[smallestIndex]){
                smallestIndex = i;
            }
        }
        return smallestIndex;
    }
    
    private static void swap(int[] array, int i, int j){
        int aux = array[i];
        array[i] = array[j];
        array[j] = aux;
    }
    public static void main(String[] args) {
        int[] array = {10,9,8,7,6,5,4,3,2,1};
        sort(array, 0,  array.length-1);
        System.out.println(Arrays.toString(array));
    }
}