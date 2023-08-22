package prova1;

import java.util.Arrays;

public class q1 {
    public static int[] juntaArray(int[] maior, int[] menor){
        int[] c = new int[menor.length];
        int indice_c = 0;
        for(int i=0; i < maior.length; i++){
            for(int j=0; j < menor.length; j++){
                if(maior[i] == menor[j] && !contem(c, maior[i])){
                    c[indice_c++] = maior[i];
                }
            }
        }
        if(indice_c < c.length){
            int[] d = new int[indice_c];
            for(int i=0; i<indice_c; i++){
                d[i] = c[i];
            }
            return d;
        }else{
            return c;
        }
    }
    public static int[] ordena(int[] c){
        for(int i=0; i<c.length; i++){
            int i_menor =i;
            for(int j= i+1; j < c.length; j++){
                if(c[j] < c[i_menor]){
                    i_menor = j;
                }
            }
            int aux = c[i];
            c[i] = c[i_menor];
            c[i_menor] = aux;
        }
        return c;
    }
    public static boolean contem(int[] c, int n){
        boolean contem = false;
        for(int i=0; i<c.length; i++){
            if(c[i] == n){
                contem = true;
            }
        }
        return contem;
    }
    public static void main(String[] args) {
        int[] a = {3, 3, 1, 2};
        int[] b = {2, 2, 6, 3, 9, 1};
        int[] maior = ((a.length > b.length) ? a : b);
        int[] menor = ((a.length < b.length) ? a : b);
        System.out.println(Arrays.toString(ordena(juntaArray(maior, menor))));
    }
}