package sorting.linearSorting;

import java.util.Arrays;

public class countingTest {

    public static Integer[] sort(Integer[] array, int leftIndex, int rightIndex) {
		int k = encontraMaior(array, leftIndex, rightIndex);
        System.out.println(k);
		int[] c = new int[k+1];

		//frequencia 
		for(int i=leftIndex; i < rightIndex; i++)
			c[array[i]]++;
		

		//cumulativa
		for(int i=1; i < c.length; i++){
			c[i] += c[i-1];
		}
		
		Integer[] b = Arrays.copyOf(array, array.length);

		for(int i=rightIndex-1; i >= leftIndex; i--){
			b[c[array[i]]-1] = array[i];
		}

		System.out.println(Arrays.toString(b));

		//copiar os valores ordenados de "b" para "array"
		for(int i=0; i<b.length; i++){
			array[i] = b[i];
		}
        return array;
	}

	public static int encontraMaior(Integer[] array, int leftIndex, int rightIndex){
		int maior = 0;

		for(int i = leftIndex; i < rightIndex; i++){
			if(array[i] > maior){
				maior = array[i];
			}
		}

		return maior;
	}

	public static void main(String[] args) {
		
		Integer[] vetorTamPar = new Integer[] { 30, 28, 7, 29, 11, 26, 4, 22, 23, 31};
		Integer[] vetorTamImpar = new Integer[] { 6, 41, 32, 7, 26, 4, 37, 49, 11, 18, 36 };
		Integer[] vetorVazio = {};
		Integer[] vetorValoresRepetidos = new Integer[] { 4, 9, 3, 4, 0, 5, 1, 4 };
		Integer[] vetorValoresIguais = 	new Integer[] { 6, 6, 6, 6, 6, 6 };


        System.out.println(Arrays.toString(sort(vetorValoresRepetidos, 0, vetorValoresRepetidos.length)));
	}   
}