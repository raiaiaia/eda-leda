package roteiroCurto1;

import java.util.Arrays;

public class SelectionSort {

    public static void sort (int[] array, int leftIndex, int rightIndex){
        for(int i = leftIndex; i <= rightIndex; i++){
            int menorIndice = leftIndex;
            for(int j=i+1; j < rightIndex; j++){
                if(array[j] < array[menorIndice]){
                    menorIndice = j;
                }
            }
            swap(array, i, menorIndice);
        }    
    }

    private static void swap(int[] array, int i, int j){
        int aux = array[i];
        array[i] = array[j];
        array[j] = aux;
    }

    public static void main(String[] args) {
        int[] array = {5, 9, 1, 6, 10, 3, 1, 0};
        sort(array, 0,  array.length-1);
        System.out.println(Arrays.toString(array));
    }
}