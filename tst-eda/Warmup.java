import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Warmup {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        sc.close();

        String line1 = sc.nextLine();
        int number = parseInt(line1);

        String[] line2 = sc.nextLine().split(" ");

        String out = "";

        for (String s : line2) {
            out += (parseInt(s) * number) + " ";
        }

        System.out.println(out.trim());
    }
}
