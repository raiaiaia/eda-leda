import java.util.Scanner;

public class CountingSort {

    public static int[] countingSort(int[] a, int k){
        int[] c = new int[k+1];
        //frequencia
        for(int i=0; i < a.length; i++){
            c[a[i]] += 1; 
            System.out.println(printArray(c)); 
        }
        //cumulativa
        for(int i=1; i < c.length; i++){
            c[i] += c[i - 1];
        }
        System.out.println("Cumulativa do vetor de contagem - " + printArray(c));
    
        int[] b = new int[a.length];
        for(int i=a.length-1; i >= 0; i--){
            b[c[a[i]]-1] = a[i];
            c[a[i]] -= 1;
        }

        System.out.println(printArray(c));

        return b;
    }

    public static String printArray(int[] array){
        String out ="";
        
        for(int n: array){
            out += n + " ";
        }
        return out.trim();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strings = sc.nextLine().split(" ");
        int k = Integer.parseInt(sc.nextLine());
        sc.close();
        int[] values = new int[strings.length];
         for (int i = 0; i < strings.length; i++) {
             values[i] = Integer.parseInt(strings[i]);
         }
         values = countingSort(values, k);
         System.out.println(printArray(values));
    }
}