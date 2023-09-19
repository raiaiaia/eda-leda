public class Floor {

    public static int buscaBinaria(int x, int[] array, int leftIndex, int rightIndex){
        int middle = (leftIndex + rightIndex)/2;

        if(rightIndex > 0 && leftIndex > 0 & array != null){

            if(x == array[middle]) 
                return middle;

            else if(x > array[middle])
                return buscaBinaria(x, array, middle+1, rightIndex);

            else if(x < array[middle])
                return buscaBinaria(x, array, leftIndex, middle-1);
        }

        return middle;
        
    }

    public static void sort(int[] array, int leftIndex, int rightIndex){
        for(int i=leftIndex; i<rightIndex; i++){
            int menor = i;
            for(int j= i+1; j<rightIndex; j++){
                if(array[j] <  array[menor]){
                    menor = j;
                }
            }
            swap(array, i, menor);
        }
    }

    public static void swap(int[] array, int i, int j){
        int aux = array[i];
        array[i] = array[j];
        array[j] = aux;
    }

    public static void main(String[] args) {
        int[] array = new int[]{2, 1, 0, -3, 5, 4, 2, 48, 53, 22};
        sort(array, 0, array.length-1);
        System.out.println(buscaBinaria(22, array, 0, array.length-1));
    }
}