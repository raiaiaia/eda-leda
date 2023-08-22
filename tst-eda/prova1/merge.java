package prova1;

import java.util.Arrays;

public class merge {

    public static int[] junta(int[] fila1, int[] fila2){
        
        int[] ordenado = new int[fila1.length + fila2.length];
        int k = 0;
        int i = 0;
        int j = 0;

        while(i < fila1.length && j < fila2.length){
            if(fila1[i] <= fila2[j]){
                ordenado[k++] = fila1[i++];
            }
            if(fila1[i] > fila2[j]){
                ordenado[k++] = fila2[j++];
            }
        }

        while(i < fila1.length){
            ordenado[k++] = fila1[i++];
        }

        while(j < fila2.length){
            ordenado[k++] = fila2[j++];
        }

        return ordenado;
    }

    public static void main(String[] args) {
        int[] fila2 = {1,3,5,7,9};
        int[] fila1 = {2,4,6,8,10};
        System.out.println(Arrays.toString(junta(fila1, fila2)));   
    }
}