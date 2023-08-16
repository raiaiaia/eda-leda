import java.util.Scanner;
import static java.lang.Integer.parseInt;

public class VetorCircular {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] values = sc.nextLine().split(" ");
        int rep = parseInt(sc.nextLine());

        sc.close();

        String out = "";

        int i = 0;

        while(rep > 0){
            out += values[i] + " ";

            if(i == values.length - 1){
                i = 0;
            } else{
                i++;
            }
            rep--;

        }

        System.out.println(out.trim());
    }
}
