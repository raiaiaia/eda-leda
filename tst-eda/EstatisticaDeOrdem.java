import java.util.Arrays;
import java.util.Scanner;

public class EstatisticaDeOrdem {

    private static int ordem(int[] array){

        int primeiro = array[0];
        int maiores = 0;
        int ordem;

        for(int i=1; i < array.length; i++){
            if(primeiro < array[i]){
                maiores++;
            }
        }

        ordem = array.length - maiores;

        return ordem;
    }

    private static void divide(int[] array, int ordem){
        swap(array, ordem-1);
    }


    private static void swap(int[] array, int ordem){

        int aux = array[0];

        array[0] = array[ordem];
        array[ordem] = aux;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strings = sc.nextLine().split(" ");
        sc.close();
        int[] values = new int[strings.length];
         for (int i = 0; i < strings.length; i++) {
             values[i] = Integer.parseInt(strings[i]);
         }
        divide(values, ordem(values));

        System.out.println(Arrays.toString(values));
    }    
}