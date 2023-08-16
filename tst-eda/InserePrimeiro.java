import java.util.Arrays;
import java.util.Scanner;


public class InserePrimeiro{

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        String[] strings = sc.nextLine().split(" ");
        
        sc.close();

        int[] values = new int[strings.length];
         for (int i = 0; i < strings.length; i++) {
             values[i] = Integer.parseInt(strings[i]);
         }
        
        
        insertion(values, 0, values.length-1);
        System.out.println(Arrays.toString(values));

    }


    public static int[] insertion(int[] values, int leftIndex, int lastIndex){

        int i = leftIndex;

        while(i < lastIndex && values[i] > values[i + 1]){
             swap(values, i, i+1);
             i++;
        }
           

        return values;
    }


    private static void swap(int[] values, int i, int j) {
        
        int aux = values[i];
        
        values[i] =  values[j];
        values[j] = aux;
    }

    
}
