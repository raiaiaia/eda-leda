public class MainBST {
    
    public static void main(String[] args) {
        System.out.println("INTERACTIVE ADD BST: ");
        BST newBst = new BST();
        System.out.println("isEmpty? " + newBst.isEmpty());
        newBst.add(10);
        System.out.println("isEmpty? " + newBst.isEmpty());
        System.out.println("isLeaf? " + newBst.isLeaf(newBst.getRoot()));
        newBst.add(5);
        newBst.add(15);
        System.out.println("isLeaf? " + newBst.isLeaf(newBst.getRoot()));
        System.out.println("root = " + newBst.printRoot());

        System.out.println("==============================");
        System.out.println("RECURSIVE ADD BST: ");
        BST newBst2 = new BST();
        System.out.println("isEmpty? " + newBst2.isEmpty());
        newBst2.recursiveAdd(10);
        System.out.println("isEmpty? " + newBst2.isEmpty());
        System.out.println("isLeaf? " + newBst2.isLeaf(newBst2.getRoot()));
        newBst2.recursiveAdd(5);
        newBst2.recursiveAdd(15);
        System.out.println("isLeaf? " + newBst2.isLeaf(newBst2.getRoot()));
        System.out.println("root = " + newBst2.printRoot());


        System.out.println("==============================");
        System.out.println("INTERACTIVE SEARCH");
        newBst.add(3);
        newBst.add(1);
        newBst.add(17);
        newBst.add(20);
        System.out.println(newBst.printRoot());
        System.out.println("20 is in the tree? " + (newBst.search(20) != null));
        System.out.println("16 is in the tree? " + (newBst.search(16) != null));

        
        System.out.println("==============================");
        System.out.println("RECURSIVE SEARCH");
        System.out.println(newBst.printRoot());
        System.out.println("20 is in the tree? " + (newBst.recursiveSearch(20) != null));
        System.out.println("16 is in the tree? " + (newBst.recursiveSearch(16) != null));


        System.out.println("==============================");
        System.out.println("INTERACTIVE MIN");
        System.out.println("min: " + newBst.min().getValue());
        
        
        System.out.println("==============================");
        System.out.println("RECURSIVE MIN");
        System.out.println("min: " + newBst.minRecursive().getValue());

        
        System.out.println("==============================");
        System.out.println("INTERACTIVE MAX");
        System.out.println("min: " + newBst.max().getValue());


        System.out.println("==============================");
        System.out.println("RECURSIVE MAX");
        System.out.println("min: " + newBst.maxRecursive().getValue());


        System.out.println("==============================");
        System.out.println("SUCESSOR");
        System.out.println("sucessor de 10 (raíz): " + newBst.sucessor(newBst.getRoot()));
        Node aux = newBst.getRoot();
        System.out.println("sucessor de 5: " +  newBst.sucessor(aux.getLeft()));
        System.out.println("sucessor de 15: " + newBst.sucessor(aux.getRight()));
        while(aux.getValue() != 1) aux = aux.getLeft();
        System.out.println("sucessor de 1: " + newBst.sucessor(aux));


        System.out.println("==============================");
        System.out.println("PREDECESSOR");
        Node aux1 = newBst.getRoot();
        System.out.println("predecessor de 10: " + newBst.predecessor(aux1));
        newBst.add(7);
        aux1 = aux1.getLeft();
        System.out.println("predecessor de 7: " + newBst.predecessor(aux1.getRight()));

        System.out.println("==============================");
        System.out.println("HEIGHT");
        System.out.println("altura da árvore: " +  newBst.height());
    }
}
