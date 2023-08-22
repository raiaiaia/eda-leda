package prova1;

import java.util.Arrays;

public class q3 {

    public static void mergeSort(int[] array, int left, int right){
        if(left < right){
            int middle = (left+right)/2;
            mergeSort(array, left, middle);
            mergeSort(array, middle+1, right);
            merge(array, left, middle, right);
        }
    }

    public static void merge(int[] array, int left, int middle, int right){
        int[] helper = new int[array.length];
        for(int i=left; i <= right; i++){
            helper[i] = array[i];
        }
        int i = left;
        int j = middle+1;
        int k = left;
        while(i <= middle && j <= right){
            if(helper[i] <= helper[j]){
                array[k++] = helper[i++];
            }else{
                array[k++] = helper[j++];
            }
        }
        while(i <= middle){
            array[k++] = helper[i++];
        }
        while(j <= right){
            array[k++] = helper[j++];
        }
    }

    public static void main(String[] args) {
        int[] a = {2,4,6,8,10};
        int[] b = {1,3,5,7,9};
        int[] c = new int[a.length + b.length];

        for(int i=0; i<a.length; i++){
            c[i] = a[i];
        }
        int j=0;
        for(int i=a.length; i<c.length; i++){
            c[i] = b[j++];
        }
        int right = c.length-1;
        int left = 0;

        mergeSort(c, left, right);
        System.out.println(Arrays.toString(c));
    }
}
