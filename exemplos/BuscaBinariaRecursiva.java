public class BuscaBinariaRecursiva {

    public static int buscaBinaria(int x, int[] array, int leftIndex, int rightIndex, int indice){
        int middle = (leftIndex + rightIndex)/2;

        if(leftIndex < rightIndex && array.length > 0 && array != null){
            if(x == array[middle])
                indice = middle;

            else if(x < array[middle]) 
                return buscaBinaria(x, array, leftIndex, middle-1, indice);
            
            else if(x > array[middle])
                return buscaBinaria(x, array, middle+1, rightIndex, indice);
        }
        return indice;
    }

    public static void main(String[] args) {
        int[] array = {0,1,2,3,4,5,6,7,8,9,10};
        System.out.println(buscaBinaria(3, array, 0, array.length-1, 0));
    }
}