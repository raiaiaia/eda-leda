import java.util.Scanner;

public class RemoveIndexLinkedList {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] numbers = sc.nextLine().split(" ");
        int index = Integer.parseInt(sc.nextLine());

        int[] int_numbers = new int[numbers.length];
        for(int i=0; i<int_numbers.length; i++)
            int_numbers[i] = Integer.parseInt(numbers[i]);
        
        sc.close();

        LinkedList lista = new LinkedList();

        for(int i=0; i<int_numbers.length; i++)
            lista.addLast(int_numbers[i]);
        
        lista.remove(index);
        System.out.println(lista.printLinkedList());
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

    public boolean isEmpty(){
        return (this.head == null) && (this.tail == null);
    }

    public void removeFirst(){
        if(!this.isEmpty()){
            if(this.head.next == null) {
                this.head = null;
                this.tail = null;
            } else {
                this.head = this.head.next;
                this.head.prev = null;
            }
        }
    }

    public void removeLast(){
        if(!this.isEmpty()){
            if (this.head.next == null) {
                this.head = null;
                this.tail = null;
            } else {
                this.tail = this.tail.prev;
                this.tail.next = null;
            }
            this.size--;
        }
    }

    public void remove(int index) {
        if(index > 0 || index < this.size-1){
            if(!this.isEmpty()) {
                if(index == 0) 
                    removeFirst();
                else if (index == this.size-1)
                    removeLast();
                else {
                    Node aux = this.head;

                    for(int i=0; i<index-1; i++)
                        aux = aux.next;
                    
                    aux.next = aux.next.next;
                    aux.next.prev = aux;
                }
            }
        }
    }

    public void addLast(int n) {
        Node newNode = new Node(n);

        if(this.isEmpty()){
            this.head = newNode;
            this.tail = newNode;
        } else {
            Node aux = this.head;

            for(int i=0; i < size; i++)
                aux = aux.next;
            
            this.tail.next = newNode;
            newNode.prev = this.tail;
            this.tail = newNode;  
        }

        this.size++;
    }

    public String printLinkedList() {
        String out = "";

        if(!this.isEmpty()){
            Node aux = this.head;

            while(aux.next != null){
                out += aux.value + " ";
                aux = aux.next;
            }
            out += aux.value; //ultimo valor da lista
        }
        return out;
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

