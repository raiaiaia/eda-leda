import java.util.*;

public class TrocaVizinhos {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        sc.close();

        String[] values = sc.nextLine().split(" ");

        for(int i=0; i< values.length-1; i+=2){
            String temp = values[i];
            values[i] = values[i+1];
            values[i+1] = temp;
        }
        System.out.println(Arrays.toString(values));
    }
}
