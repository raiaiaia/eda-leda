import java.util.Arrays;
import java.util.Scanner;

public class InsertionSortRecursivo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] values = sc.nextLine().split(" ");

        sc.close();

        int[] array = new int[values.length];
         for (int i = 0; i < values.length; i++) {
             array[i] = Integer.parseInt(values[i]);
         }
        
        insertionSort(array, array.length);
        
    }

    public static void insertionSort(int[] array,int rightIndex){

        if(rightIndex <= 1){
            return;
        }

        insertionSort(array, rightIndex - 1);

        int last = array[rightIndex - 1];
        int j = rightIndex - 2;
    
		while(j >= 0 && array[j] > last){
            array[j+1] = array[j];
            j--;
        }

        array[j+1] = last;
        
        System.out.println(Arrays.toString(array));
    
    }
} 