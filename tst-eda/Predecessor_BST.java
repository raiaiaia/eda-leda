import java.util.ArrayList;
import java.util.Scanner;

public class Predecessor_BST {

    //falhou em 1 teste

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
        public ArrayList<Integer> predecessor_path = new ArrayList<Integer>();

        public boolean isEmpty() {
            return this.root == null;
        }

        public boolean isLeaf(Node node) {
            return (node.getLeft() == null) && (node.getRight() == null);
        }

        public Node getRoot() { return root; }

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

        public ArrayList<Integer> predecessor(Node node) {

            if(node != null) {
                if(isEmpty()) return null;
                predecessor_path.add(node.getValue());

                if(node.getLeft() != null) {
                    maxRecursive(node.getLeft());
                } else {
                    Node aux = node.getParent();
                    while(aux != null && aux.getValue() > node.getValue()) { 
                        aux = aux.getParent();
                        predecessor_path.add(aux.getValue());
                    }
                    if(!predecessor_path.contains(aux.getValue()))
                        predecessor_path.add(aux.getValue());
                }
            }
            return predecessor_path;
        }

        private Node maxRecursive(Node node) {
            if(node.getRight() == null) {
                predecessor_path.add(node.getValue());
                return node;
            } else {
                predecessor_path.add(node.getValue());
                return maxRecursive(node.getRight());
            } 
        }

        public Node search(int element) {
                Node aux = this.root;
                while(aux != null) {
                    if(aux.getValue() == element) return aux;
                    else if(element < aux.getValue()) aux = aux.getLeft();
                    else if(element > aux.getValue()) aux = aux.getRight();
                }
                return aux;
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nos = sc.nextLine().split(" "); //recebe os valores da bst
        String predecessor_String = sc.nextLine(); //recebe o predecessor
        sc.close();

        //transformar de string p int
        int[] values = new int[nos.length];
        for (int i = 0; i < nos.length; i++) {
            values[i] = Integer.parseInt(nos[i]);
        }

        BST newBst = new BST(); //cria uma nova bst
        for(int value: values) newBst.add(value); //adiciona os valores a bst
        
        Node aux = newBst.search(Integer.parseInt(predecessor_String)); //procura o predecessor na bst
        ArrayList<Integer> nodes = newBst.predecessor(aux);
        System.out.println(nodes.toString());
    }

}


