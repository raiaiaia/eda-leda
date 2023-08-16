import java.util.Arrays;
import java.util.Scanner;


public class InsertionSort{

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        String[] strings = sc.nextLine().split(" ");
        
        sc.close();

        int[] values = new int[strings.length];
         for (int i = 0; i < strings.length; i++) {
             values[i] = Integer.parseInt(strings[i]);
         }
        
        
        insertionSort(values, 0, values.length-1);
        System.out.println(Arrays.toString(values));

    }


    public static int[] insertionSort(int[] values, int leftIndex, int lastIndex){

        for(int i = leftIndex + 1; i < lastIndex; i++){

            int j = i;
            while(j > 0 && values[j] < values[j - 1]){
             swap(values, j, j-1);
             j--;
            }
        }

        return values;
    }


    private static void swap(int[] values, int i, int j) {
        
        int aux = values[i];
        
        values[i] =  values[j];
        values[j] = aux;
    }
    
}