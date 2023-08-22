import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {

    private static void mergeSort(int[] array, int left, int right){
        if(left < right){
            printArray(array, left, right);
            int middle = (right + left)/2;
            mergeSort(array, left, middle);
            mergeSort(array, middle+1, right);
            merge(array, left, middle, right);
        }else{
            printArray(array, left, right);
        }
    }

    private static void merge(int[] array, int left,int middle, int right){
        int[] helper = new int[array.length];
        for(int i=left; i <= right; i++){
            helper[i] = array[i];
        }
        int i = left;
        int j = middle+1;
        int k = left;
        while(i <= middle && j <= right){
            if(helper[i] <= helper[j]){
                array[k++] = helper[i++];
            }else{
                array[k++] = helper[j++];
            }
        }
        while(i <= middle){
            array[k++] = helper[i++];
        }
        while(j <= right){
            array[k++] = helper[j++];
        }
        printArray(array, left, right);
    }

    private static void printArray(int[] numeros, int left, int right){
        System.out.println(Arrays.toString(Arrays.copyOfRange(numeros, left, right+1)));
      }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strings = sc.nextLine().split(" ");
        sc.close();
        int[] values = new int[strings.length];
         for (int i = 0; i < strings.length; i++) {
             values[i] = Integer.parseInt(strings[i]);
         }
         mergeSort(values, 0, values.length-1); 
    }
    
}