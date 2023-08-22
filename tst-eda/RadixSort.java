import java.util.Scanner;

public class RadixSort {


    public static void radixSort(int[] array, int d){

        int[] aux = new int[array.length];
        int divisor = 1;
        int modulo = 10;

        while(d > 0){ 

            //separa dos valores numa lista auxiliar
            int maiorIndice = 0;
            for(int i = 0; i< aux.length; i++){
                aux[i] = ((array[i]/divisor) % modulo);

                if(aux[maiorIndice] > aux[i]){
                    maiorIndice = aux[i];
                }
            }
            divisor *= 10;

            //radix sort
            int[] c = new int[maiorIndice];
            //frequencia
            for(int j=0; j< aux.length; j++){
                c[aux[j] -1] += 1;
            }
            //cumulativa
            for(int j=1; j < c.length; j++){
                c[j] += c[j-1];
            }

            for(int j=aux.length-1; j >=0; j++){
                array[c[aux[j]-1]-1] = aux[j];
            }
            
            d--;
        }


    }

    public static void countingSort(int[] array){

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strings = sc.nextLine().split(" ");
        int d = Integer.parseInt(sc.nextLine());
        sc.close();
        int[] values = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            values[i] = Integer.parseInt(strings[i]);
        }

        radixSort(values, d);
    }
    
}
