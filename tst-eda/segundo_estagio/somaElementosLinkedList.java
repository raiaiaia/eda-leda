public class somaElementosLinkedList {

    public static void main(String[] args) {
        int[] values = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        LinkedList lista = new LinkedList();

        for(int i=0; i<values.length; i++)
            lista.addLast(values[i]);

        System.out.println(lista.soma());   
    }
}

class LinkedList {
    
    private Node head;
    private Node tail;
    private int size;

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public int soma(){
        if(this.isEmpty()) return 0;
        Node auxHead = this.head;
        Node auxTail = this.tail;
        return soma(auxHead, auxTail);
    }

    private int soma(Node node1, Node node2) {
        if(node1.value == node2.value) return node1.value;
        else if (node1.next.value == node2.value || node2.prev.value == node1.value) return node1.value + node2.value;
        return (node1.value + node2.value) + soma(node1.next, node2.prev);
    }

    public boolean isEmpty() {
        return this.head == null && this.tail == null;
    }

    public void addLast(int value) {
        Node newNode = new Node(value);
        if(isEmpty()) {
            this.head = newNode;
            this.tail = head;
        } else {
            this.tail.next = newNode;
            newNode.prev = tail;
            this.tail = newNode;
        }
        this.size += 1;
    }

    public String toString() {
        Node aux = this.head;
        String out = "";
        while (aux != null) {
            out += aux.value + " ";
            aux = aux.next;
        }
        return out;    
    }

    public int size() {
        return this.size;
    }
}  

class Node {
    
    int value;
    Node next;
    Node prev;  
    
    public Node(int value) {
        this.value = value;
        this.prev = null;
        this.next = null;
    }
}