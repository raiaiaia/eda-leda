import java.util.Arrays;
import java.util.Scanner;

public class LomutoUltimo {

    public static void quickSort(int[] array, int left, int right){
        if(left < right){
            int pivotIndex = partition(array, left, right);
            printArray(array);
            quickSort(array, left, pivotIndex -1);
            quickSort(array, pivotIndex+1, right);
        }
    }

    public static int partition(int[] array, int left, int right){

        int pivot = array[right];
        int i = right;

        for(int j = i - 1; j <= left; j--){
            if(array[j] < pivot){
                i--;
                swap(array, i, j);
            }
        }
        swap(array, left, i);
        return i;
    }

    private static void printArray(int[] array){
        System.out.println(Arrays.toString(array));
    }

    private static void swap(int[] array, int i, int j) {
        int aux = array[i];
        array[i] = array[j];
        array[j] = aux;
    }

    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       String[] strings = sc.nextLine().split(" ");
       sc.close();
       int[] values = new int[strings.length];
       for (int i = 0; i < strings.length; i++) {
         values[i] = Integer.parseInt(strings[i]);
       } 

       quickSort(values, 0, values.length-1);
    }
    
}