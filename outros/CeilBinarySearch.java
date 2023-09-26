public class CeilBinarySearch {
    
    public static Integer ceil(Integer[] array, int k){
        int result = -1;

        if(array.length > 0){
            quickSort(array, 0, array.length-1);
            result = ceilSearch(array, k, 0, array.length-1);
        }
        return result;
    }

    private static int ceilSearch(Integer[] array, int k, int leftIndex, int rightIndex){
        int res = -1;
        
        if(leftIndex <= rightIndex){
            int middle = (leftIndex + rightIndex)/2;

            //se middle estiver dentro do limite e o proximo valor for maior ou igual ao k pesquisa na parte direita
            if(middle+1 <= rightIndex && array[middle+1] <= k){
                res = ceilSearch(array, k, middle+1, rightIndex);
            //se middle-1 estiver dentro do limite e o valor atual for maior que k mas o valor anterior tambem for maior ou igual a k pesquisa na parte esquerda    
            }else if(array[middle] > k && middle-1 >= 0 && array[middle-1] >= k){
                res = ceilSearch(array, k, leftIndex, middle-1);
            //se o valor for maior ou igual a k retorna ele
            } else if(array[middle] >= k){
                res = array[middle];
            //se nao for nenhuma das opções retorna a pesquisa na parte esquerda
            }else{
                res = ceilSearch(array, k, leftIndex, middle-1);
            }
        }

        return res;

    }
    //2 4 6 8 10 12 14
    private static void quickSort(Integer[] array, int leftIndex, int rightIndex){
        if(leftIndex >=0 && rightIndex <= array.length-1){
            if(leftIndex <= rightIndex){
                int pivotIndex = partition(array, leftIndex, rightIndex);
                quickSort(array, leftIndex, pivotIndex-1);
                quickSort(array, pivotIndex+1, rightIndex);
            }
        }
    }
    private static int partition(Integer[] array, int leftIndex, int rightIndex){
        int pivot = array[leftIndex];
        int i = leftIndex;

        for(int j = i+1; j <= rightIndex; j++){
            if(array[j] < pivot){
                swap(array, j, ++i);
            }
        }

        swap(array, leftIndex, i);

        return i;
    }

    private static void swap(Integer[] array, int i, int j){
        int aux = array[i];

        array[i] = array[j];
        array[j] = aux;
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{ 8, 4, 12, 2, 6, 10, 14};

        System.out.println("Ceil de 11: " + ceil(arr, 11));
        System.out.println("Ceil de -1: " + ceil(arr, -1));
        System.out.println("Ceil de 6: " + ceil(arr, 6));
        System.out.println("Ceil de 15: " + ceil(arr, 15));
    }
}