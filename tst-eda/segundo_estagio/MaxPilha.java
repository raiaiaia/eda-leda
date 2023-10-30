import java.util.Scanner;

public class MaxPilha {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] numbers = sc.nextLine().split(" ");

        int[] int_numbers = new int[numbers.length];
        for(int i=0; i<int_numbers.length; i++)
            int_numbers[i] = Integer.parseInt(numbers[i]);
        
        sc.close();

        PilhaDupla s1 = new PilhaDupla(int_numbers.length);
        for(int i=0; i<int_numbers.length; i++)
            s1.push(int_numbers[i]);
        
        System.out.println(s1.maiorElemento());
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
}

class Stack {
    private int[] pilha;
    private int capacidade;
    private int topo;

    public Stack(int capacidade) {
        this.capacidade = capacidade;
        this.topo = -1;
        this.pilha = new int[capacidade];
    }

    public boolean isEmpty() {
        return this.topo == -1;
    }

    public boolean isFull() {
        return this.topo == (capacidade - 1);
    }

    public void push(int n) {
        
        if (this.isFull())
            throw new RuntimeException("FullStackException");
        this.topo += 1;
        this.pilha[topo] = n;
    }
    
    public int pop() {
        if (this.isEmpty())
            throw new RuntimeException("EmptyStackException");
        int valor_topo = this.pilha[topo];
        topo -= 1;
        return valor_topo; 
    }

    public int peek() {
        if (this.isEmpty())
            throw new RuntimeException("EmptyStackException");
        return this.pilha[topo];
    }

    public int size() {
        return this.topo + 1;
    }

}
