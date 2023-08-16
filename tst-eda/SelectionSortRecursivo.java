import java.util.Arrays;
import java.util.Scanner;

public class SelectionSortRecursivo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] values = sc.nextLine().split(" ");

        sc.close();

        int[] array = new int[values.length];
         for (int i = 0; i < values.length; i++) {
             array[i] = Integer.parseInt(values[i]);
         }

        sort(array, 0,  array.length-1);
    }

    public static void sort(int[] array, int leftIndex, int rightIndex) {


        if(leftIndex == rightIndex){
            return;
        }

        sort(array, leftIndex + 1, rightIndex);

        int smallest = findMinimum(array, leftIndex, rightIndex);

        if(smallest != leftIndex){
            swap(array, leftIndex, smallest);
        }
        
        System.out.println(Arrays.toString(array));
    
    }

    public static int findMinimum(int[] array, int smallestIndex, int rightIndex){

        for(int i= smallestIndex; i <= rightIndex; i++){
            if(array[i] < array[smallestIndex]){
                smallestIndex = i;
            }
        }

        return smallestIndex;
    }


    public static void swap(int[] array, int i, int smallestIndex) {

        int aux = array[i];
    
        array[i] = array[smallestIndex];
        array[smallestIndex] = aux;
    } 
    
}
