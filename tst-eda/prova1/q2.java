package prova1;

import java.util.Arrays;

public class q2 {

    public static void insereUltimo(int[] a){

        for(int i=a.length-1; i > 0; i--){
            if(a[i] < a[i-1]){
                swap(a, i, i-1);
            }
        }
    }

    public static void swap(int[] a, int i, int j){
        int aux = a[i];
        a[i] = a[j];
        a[j] = aux;
    }

    public static void main(String[] args) {
        
        int[] a = {1,2,3,4,0};

        insereUltimo(a);
        System.out.println(Arrays.toString(a));
    }
    
}
