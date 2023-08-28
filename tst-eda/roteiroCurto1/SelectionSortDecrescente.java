import java.util.Arrays;

public class SelectionSortDecrescente {

    public static void sort(int[] array, int leftIndex, int rightIndex){
        for(int i=rightIndex; i >= leftIndex; i--){
            int smallestIndex = i;
            for(int j = i-1; j >= leftIndex; j--){
                if(array[j] < array[smallestIndex]){
                    smallestIndex = j;
                }
            }

            swap(array, i, smallestIndex);
        }
    }

    private static void swap(int[] array, int i, int j){
        int aux = array[i];
        array[i] = array[j];
        array[j] = aux;
    }
    public static void main(String[] args) {
        int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        sort(array, 0,  array.length-1);
        System.out.println(Arrays.toString(array));
    } 
}
