import java.util.Scanner;

public class InvertePilhaIndex {
    
    static class Pilha {

        int[] stack;
        int capacidade;
        int topo;

        public Pilha(int capacidade) {
            this.capacidade = capacidade;
            this.stack = new int[capacidade];
            this.topo = -1;
        }

        //peek, pop, push e isEmpty

        public int peek() {
            if(this.isEmpty())
                throw new RuntimeException("Stack is empty");
            return this.stack[this.topo];
        }

        public boolean isEmpty() {
            return this.topo == -1;
        }

        public void push(int n) {
            this.stack[++this.topo] = n;
        }

        public int pop() {
            if(this.isEmpty())
                throw new RuntimeException("Stack is empty");
            return this.stack[this.topo--];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = Integer.parseInt(sc.nextLine());
        String[] numbers = sc.nextLine().split(" ");
        int index = Integer.parseInt(sc.nextLine());

        int[] int_numbers = new int[numbers.length];
        for(int i=0; i<int_numbers.length; i++)
            int_numbers[i] = Integer.parseInt(numbers[i]);
        
        sc.close();

        Pilha stack = new Pilha(size);
        Pilha stackReverse = new Pilha(size);
        
        int i=0;
        int times_push = size;
        while(times_push > 0) {
            stack.push(int_numbers[i]);
            times_push--;
            i++;
        }

        System.out.println("-");

        int j = index;
        while(j >= 0) {
            int elem = stack.pop();
            stackReverse.push(elem);
            j--;
        }

        //imprime
        int h = index;
        while(h >= 0) {
            int elem = stackReverse.pop();
            System.out.println(elem);
            h--;
        }

        int k = (size - index) -1;
        while(k > 0) {
            int elem = stack.pop();
            System.out.println(elem);
            k--;
        }
    }
}