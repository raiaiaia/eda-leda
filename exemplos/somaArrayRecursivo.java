public class somaArrayRecursivo{

    public static void main(String[] args) {
        
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(somaArray(arr, 0));
    }


    public static int somaArray(int[] arr, int indice){
        int soma = 0;

        if(indice <= arr.length - 1){
            soma += arr[indice] + somaArray(arr, indice + 1);
        }

        return soma;
    }
}