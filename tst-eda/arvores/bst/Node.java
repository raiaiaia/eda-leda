public class Node {
   
    protected int value;
    protected Node left;
    protected Node right;
    protected Node parent;

    Node(int v){
        this.value = v;
    }
    
    Node(int v, Node left, Node right, Node parent){
        this.value = v;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }

    public boolean isNIL() {
        return true;
    }

    public Node getLeft() {
        return left;
    }

    public Node getParent() {
        return parent;
    }

    public Node getRight() {
        return right;
    }

    public int getValue() {
        return value;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String toString(){
        return Integer.toString(this.value);
    }
}