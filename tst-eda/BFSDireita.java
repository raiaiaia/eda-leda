import java.util.*;

public class BFSDireita {

    //falha em todos os testes por erro de formatação da saída

    static class Node {
        protected int value;
        protected Node left;
        protected Node right;
        protected Node parent;

        Node(int v){ this.value = v; }

        public Node getLeft() { return left; }

        public Node getParent() { return parent; }

        public Node getRight() { return right; }

        public int getValue() { return value; }

        public void setValue(int value) { this.value = value; }

        public void setLeft(Node left) { this.left = left; }

        public void setRight(Node right) { this.right = right; }

        public void setParent(Node parent) { this.parent = parent; }
    }

    static class BST {
        private Node root;

        public boolean isEmpty() { return this.root == null; }

        public boolean isLeaf(Node node) {
            return (node.getLeft() == null) && (node.getRight() == null);
        }

        public ArrayList<Node> printBFS() {
            Deque<Node> queue = new LinkedList<Node>();
            ArrayList<Node> out = new ArrayList<>();

            if(!isEmpty()) {
                queue.addLast(this.root);
                while(!queue.isEmpty()) {
                    Node current = queue.removeFirst();
                    out.add(current);

                    if(current.getRight() != null)
                        queue.addLast(current.getRight());
                    if(current.getLeft() != null)
                        queue.addLast(current.getLeft());
                }
            }
            return out;
        }

        public void add(int element) {
            if(isEmpty()) this.root = new Node(element);
            else {
                Node aux = this.root;
                while(aux != null) {
                    if(element < aux.getValue()) {
                        if(aux.getLeft() == null) {
                            Node newNode = new Node(element);
                            aux.setLeft(newNode);
                            newNode.setParent(aux);
                            return;
                        }
                        aux = aux.getLeft();
                    } else {
                        if(aux.getRight() == null) {
                            Node newNode = new Node(element);
                            aux.setRight(newNode);
                            newNode.setParent(aux);
                            return;
                        }
                        aux = aux.getRight();
                    }
                }
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nos = sc.nextLine().split(" "); //recebe os valores da bst
        sc.close();

        //transformar de string p int
        int[] values = new int[nos.length];
        for (int i = 0; i < nos.length; i++) {
            values[i] = Integer.parseInt(nos[i]);
        }

        BST newBst = new BST(); //cria uma nova bst
        for(int value: values) newBst.add(value); //adiciona os valores a bst
        
        ArrayList<Node> out = newBst.printBFS();
        String print = "";
        for(Node node: out) {
            print += node.getValue() + " ";
        }
        print.trim();
        System.out.println(print);
    }
}