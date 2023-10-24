import java.util.Scanner;

public class ContaNos {

    static class Node {
        protected int value;
        protected Node left;
        protected Node right;
        protected Node parent;

        Node(int v){
            this.value = v;
        }

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

        public Node getRoot() { return root; }

        public int contaNos() {
            return contaNos(this.root);
        }

        public int contaNos(Node node) {
            if(node == null) return 0;
            if(isLeaf(node)) return 0;
            return 1 + contaNos(node.getLeft()) + contaNos(node.getRight());
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
        
        System.out.println(newBst.contaNos());
    }
}