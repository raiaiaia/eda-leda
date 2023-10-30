public class PopPilhaIndex {

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

        public boolean isFull() {
            return this.topo == (capacidade - 1);
        }

        public void push(int n) {
            if (this.isFull())
                throw new RuntimeException("FullStackException");
            this.topo += 1;
            this.stack[this.topo] = n;
        }

        public int pop() {
            if(this.isEmpty())
                throw new RuntimeException("Stack is empty");
            return this.stack[this.topo--];
        }
    }

    static class PilhaDupla {

        private Pilha pilha1;
        private Pilha pilha2;

        public PilhaDupla(int capacidade, int index) {
            pilha1 = new Pilha(capacidade);
            pilha2 = new Pilha(index);
        }

        public void push(int n) {
            pilha1.push(n);
        }

        public int popIndex(int index) {
            if(pilha1.isEmpty())
                throw new RuntimeException("Stack is empty");
            if(index < 0 || index > pilha1.topo) 
                throw new RuntimeException("Índice inválido");

            int i = pilha1.topo;
            while(i >= index) {
                int value = pilha1.pop();
                pilha2.push(value);
                i--;
            }

            int res = pilha1.pop();

            while(!pilha2.isEmpty()) {
                int elem = pilha2.pop();
                pilha1.push(elem);
            }
            return res;
        }

        public void pilha1Print() {
            while(!pilha1.isEmpty()) {
                int value = pilha1.pop();
                System.out.println(value);
            }
        }
    }

    public static void main(String[] args) {
        PilhaDupla pilhas = new PilhaDupla(5, 0);

        int[] elementos = new int[]{1, 2, 4, 8, 24};

        int i = elementos.length-1;
        while(i > 0){
            pilhas.push(elementos[i]);
            i--;
        }
        pilhas.pilha1Print();
    }
    
}
