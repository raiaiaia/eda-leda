import java.util.Scanner;

public class FilaComArray {

    //fail: ...F

    private int[] queue;
    private int capacity;
    private int head;
    private int tail;

    public FilaComArray(int capacity) {
        this.queue = new int[capacity]; 
        this.capacity = capacity;
        this.head = -1;
        this.tail = -1;
    }
    
    public void enqueue(int n) {
        if(this.isFull()){
            System.out.println("full");
        }
        if(this.isEmpty()){
            this.head = 0;
            this.tail = 0;  
            this.queue[0] = n; 
        } else if (!this.isEmpty() && !this.isFull()) {
            this.tail = (this.tail + 1) % capacity;
            this.queue[this.tail] = n;
        }
    }

    public void dequeue() {
        if(this.isEmpty())
            System.out.println("empty");

         if (this.head == this.tail) {
            this.head = -1;
            this.tail = -1;
        } else {
            this.head = ((this.head + 1) % capacity);
        }
    }

    public String head() {
        String out = "";
        if(this.isEmpty()) 
            out = "empty";
        else 
            out =  String.valueOf(this.queue[this.head]);
        return out;
    }

    public String print() {
        String out = "";
        if(this.isEmpty()) {
            out = "empty";
        } else {
            for(int i = this.head; i <= this.tail; i++)
                out += this.queue[i] + " ";
        }
        return out.trim();
    }

    private boolean isFull(){
        return ((this.tail + 1) % capacity) == this.head;
    }

    private boolean isEmpty(){
        return (this.head == -1) && (this.tail == -1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String capacity = sc.nextLine();
        FilaComArray queue = new FilaComArray(Integer.parseInt(capacity));
        String[] operations = sc.nextLine().split(" ");

        while(!operations[0].equals("end")) {
            switch (operations[0]) {
                case "print": 
                    System.out.println(queue.print()); 
                    break; 
                case "add":
                    queue.enqueue(Integer.parseInt(operations[1]));
                    break;
                case "element":
                    System.out.println( queue.head());
                    break;
                case "remove":
                    queue.dequeue();
                    break;
            }

            operations = sc.nextLine().split(" ");
        }
        sc.close();
    }
}
