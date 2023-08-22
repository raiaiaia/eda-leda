import java.util.Scanner;

public class Down_N {

    private static void menores(int[] array, int n){
        
        for(int i=0; i < n-1; i++){
            System.out.print(array[i] + " ");
        }

        System.out.println(array[n-1]);
    }

    private static void selectionSort(int[] array, int rightIndex){

        for(int i=0; i < rightIndex; i++){
            int smallestIndex = i;
            for(int j= i + 1; j <= rightIndex; j++){
                if(array[j] < array[smallestIndex]){
                    smallestIndex = j;
                }
            }
            swap(array, i, smallestIndex);
        }
    }

    private static void swap(int[] array, int i, int smallestIndex) {

        int aux = array[i];
    
        array[i] = array[smallestIndex];
        array[smallestIndex] = aux;
    } 

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] strings = sc.nextLine().split(" ");
        int n = Integer.parseInt(sc.nextLine());
        sc.close();

        int[] values = new int[strings.length];
         for (int i = 0; i < strings.length; i++) {
             values[i] = Integer.parseInt(strings[i]);
         }

         selectionSort(values, values.length-1);
         menores(values, n);
    }   
}