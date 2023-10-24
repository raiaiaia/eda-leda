public class BST {
    
    private Node root;

    public boolean isEmpty() {
        return this.root == null;
    }

    public boolean isLeaf(Node node) {
        return (node.getLeft() == null) && (node.getRight() == null);
    }

    public Node getRoot() {
        return root;
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

    public String printRoot(){
        String out = null;
        Node aux = this.root;
        if(!isEmpty()) 
            out = "value: " + aux.getValue() + " left: " + aux.getLeft().getValue() +  " right: " +  aux.getRight().getValue(); 
        return out;
    }

    public void recursiveAdd(int element) {
        if(isEmpty()) this.root = new Node(element);
        else recursiveAdd(this.root, element);
    }

    private void recursiveAdd(Node node, int element) {
        if(element < node.getValue()) {
            if(node.getLeft() == null) {
                Node newNode = new Node(element);
                node.setLeft(newNode);
                node.setParent(node);
                return;
            }
            recursiveAdd(node.getLeft(), element);
        } else {
            if(node.getRight() == null) {
                Node newNode = new Node(element);
                node.setRight(newNode);
                node.setParent(node);
                return;
            }
            recursiveAdd(node.getRight(), element);
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

    public Node recursiveSearch(int element) {
        return recursiveSearch(this.root, element);
    }

    private Node recursiveSearch(Node node, int element) {
        if(node != null) {
            if(node.getValue() == element) return node;
            else if(element < node.getValue()) return recursiveSearch(node.getLeft(), element);
            else if(element > node.getValue()) return recursiveSearch(node.getRight(), element);
        }
        return null;
    }

    public Node min() {
        if(isEmpty()) return null;
        Node aux = this.root;
        while(aux != null && !isLeaf(aux)) {
            aux = aux.getLeft();
        }
        return aux;
    }

    public Node minRecursive() {
        if(isEmpty()) return null;
        return minRecursive(this.root);
    }

    private Node minRecursive(Node node) {
        if(node.getLeft() == null) return node;
        return minRecursive(node.getLeft());
    }

    public Node max() {
        if(isEmpty()) return null;
        Node aux = this.root;
        while(aux != null && !isLeaf(aux)) {
            aux = aux.getRight();
        }
        return aux;
    }

    public Node maxRecursive() {
        if(isEmpty()) return null;
        return maxRecursive(this.root);
    }

    private Node maxRecursive(Node node) {
        if(node.getRight() == null) return node;
        return maxRecursive(node.getRight());
    }

    public Node sucessor(Node node) {
        if(isEmpty()) return null;
        else if (node == null) return null;
        
        if(node.getRight() != null) 
            return minRecursive(node.getRight());
        else {
            Node aux = node.getParent();
            while(aux != null && aux.getValue() < node.getValue())
                aux = aux.getParent();
            
            return aux;
        }
    }

    public Node predecessor(Node node) {
        if(isEmpty()) return null;

        if(node.getLeft() != null)
            return maxRecursive(node.getLeft());
        else {
            Node aux = node.getParent();
            while(aux != null && aux.getValue() > node.getValue())
                aux = aux.getParent();
            return aux;
        }
    }

    public int height() {
        return height(this.root);
    }

    private int height(Node node) {
        if(node ==  null) return -1;
        else return 1 + Math.max(height(node.getLeft()), height(node.getRight()));
    }
   
}