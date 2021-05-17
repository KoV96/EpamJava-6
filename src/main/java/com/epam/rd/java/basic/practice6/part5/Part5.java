package com.epam.rd.java.basic.practice6.part5;

public class Part5 {
    
    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>();
        tree.add(3);
        tree.add(1);
        tree.add(0);
        tree.add(2);
        tree.add(5);
        tree.add(6);
        tree.add(4);
        Tree<Integer> secondTree = new Tree<>();
        Integer[] arr = {3, 1, 0, 2, 5, 6, 4};
        secondTree.add(arr);
        System.out.println(tree.remove(5));
        System.out.println(tree.remove(1));
        System.out.println(tree.remove(5));
        System.out.println(tree.remove(5));
        System.out.println();
        tree.print();
    }
    
}
