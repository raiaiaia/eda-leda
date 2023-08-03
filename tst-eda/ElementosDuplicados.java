import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class ElementosDuplicados {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] values = sc.nextLine().split(" ");
        System.out.println(verificaDuplicados(values));

    }

    public static boolean verificaDuplicados(String[] values){
        for(int i = 0; i< values.length; i++){
            for(int j = i + 1; j< values.length; j++){
                if(parseInt(values[i]) == parseInt(values[j])){
                    return true;
                }
            }
        }
        return false;
    }
}
