import java.util.Arrays;
import java.util.Scanner;

public class SelectionSort {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] values = sc.nextLine().split(" ");

        sc.close();

        int[] array = new int[values.length];
         for (int i = 0; i < values.length; i++) {
             array[i] = Integer.parseInt(values[i]);
         }

        sort(array, 0, array.length-1);
    }

    public static void sort(int[] array, int leftIndex, int rightIndex) {

		
		for(int i = leftIndex; i < rightIndex; i++){
			int smallestIndex = i;

			for(int j = i + 1; j <= rightIndex; j++){
				if(array[j] < array[smallestIndex]){
					smallestIndex = j;
				}
			}

		    swap(array, i, smallestIndex);

            System.out.println(Arrays.toString(array));

            if(isOrdenaded(array)){
                return;
            }
            
        }
        
	}

    private static void swap(int[] array, int i, int smallestIndex) {

        int aux = array[i];
    
        array[i] = array[smallestIndex];
        array[smallestIndex] = aux;
    } 

    public static boolean isOrdenaded(int[] array){

        boolean ordenaded = true;

        for(int i = 0; i < array.length-1; i++){
            if(array[i] > array[i+1]){
                return ordenaded = false;
            }
        }

        return ordenaded;
    }
}