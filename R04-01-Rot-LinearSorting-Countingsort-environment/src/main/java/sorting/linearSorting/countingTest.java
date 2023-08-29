package sorting.linearSorting;

import java.util.Arrays;

public class countingTest {

    public static Integer[] sort(Integer[] array, int leftIndex, int rightIndex) {
		int k = encontraMaior(array, leftIndex, rightIndex);
		int[] c = new int[k+1];

		//frequencia 
		for(int i=leftIndex; i < rightIndex; i++)
			c[array[i]]++;
		

		//cumulativa
		for(int i=1; i < c.length; i++){
			c[i] += c[i-1];
		}
		int[] b = new int[rightIndex - leftIndex + 1];
		for(int i=b.length-1; i >= 0; i--){
			b[c[array[i]]] = array[i];
			c[array[i]]--;
		}

		int j = leftIndex;
		//copiar os valores ordenados de "b" para "array"
		for(int i=0; i<b.length; i++){
			if(i == j){
				array[i] = b[j++];
			}
		}

        return array;
	}

	public static int encontraMaior(Integer[] array, int leftIndex, int rightIndex){
		int maior = array[leftIndex];
		for(int i = leftIndex; i <= rightIndex; i++){
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

        System.out.println(Arrays.toString(sort(vetorValoresRepetidos, 0, vetorValoresRepetidos.length-1)));
	}   
}