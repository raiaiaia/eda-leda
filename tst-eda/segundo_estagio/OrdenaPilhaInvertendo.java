import java.util.Scanner;
import pilha.Stack;

public class OrdenaPilhaInvertendo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = Integer.parseInt(sc.nextLine());
        String[] numbers = sc.nextLine().split(" ");

        int[] int_numbers = new int[numbers.length];
        for(int i=0; i<int_numbers.length; i++)
            int_numbers[i] = Integer.parseInt(numbers[i]);

        PilhaDupla s1 = new PilhaDupla(size);
        for(int i=0; i<size-1; i++)
            s1.push(int_numbers[i]);

        sc.close();
        
        System.out.println("-");
        s1.ordenaPilha();
        
    }
}

class PilhaDupla {

        private Stack pilha1;
        private Stack pilha2;

        public PilhaDupla(int capacidade) {
            pilha1 = new Stack(capacidade);
            pilha2 = new Stack(capacidade);
        }

        public void push(int n) {
            pilha1.push(n);
        }

        public int maiorElemento(){
            int maiorElemento = 0;

            if(!pilha1.isEmpty()){

                while(!pilha1.isEmpty()){
                    int value = pilha1.pop();
                    pilha2.push(value);

                    if(value > maiorElemento)
                        maiorElemento = value;
                }

                while(!pilha2.isEmpty()){
                    int value = pilha2.pop();
                    pilha1.push(value);
                }
            }

            return maiorElemento;
        }

        public void ordenaPilha(){
            while(!pilha1.isEmpty()){
                int currentValue = maiorElemento();
                pilha2.push(currentValue);
            }
            pilha2Print();
        }

        public void pilha2Print() {
            while(!pilha2.isEmpty()) {
                int value = pilha2.pop();
                System.out.println(value);
            }
        }
        
}
