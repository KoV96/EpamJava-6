package com.epam.rd.java.basic.practice6.part5;

public class Tree<E extends Comparable<E>> {
    private Node<E> rootNode;
    private Node<E> current;
    private Node<E> parent;
    private Node<E> node;
    boolean isLeft;
    boolean isRight;

    public boolean add(E element) {
        if (rootNode == null) {
            rootNode = new Node<>(element, null, null);
            return true;
        }
        return deepAdd(element, rootNode);
    }

    private boolean deepAdd(E element, Node<E> node) {
        if (element.compareTo(node.getValue()) < 0) {
            if (node.left == null) {
                node.left = new Node<>(element, null, null);
                return true;
            }
            return deepAdd(element, node.left);
        }
        if (element.compareTo(node.getValue()) > 0) {
            if (node.right == null) {
                node.right = new Node<>(element, null, null);
                return true;
            }
            return deepAdd(element, node.right);
        }
        return false;
    }

    public void add(E[] elements) {
        for (E element : elements) {
            add(element);
        }
    }

    public boolean remove(E element) {
        if (rootNode == null) {
            return false;
        }
        parent = null;
        current = rootNode;
        findElement(element);
        if (current == null) {
            return false;
        }
        deepRemove();
        return true;
    }

    private void findElement(E element) {
        if (current == null) return;
        if (element.compareTo(current.getValue()) < 0) {
            parent = current;
            current = current.left;
            isRight = false;
            isLeft = true;
            findElement(element);
        } else if (element.compareTo(current.getValue()) > 0) {
            parent = current;
            current = current.right;
            isRight = true;
            isLeft = false;
            findElement(element);
        }
    }

    private void deepRemove() {
        if (current.right == null && current.left == null) {
            removeNodeIfNoChild();
        } else if (current.left == null) {
            removeIfLeftNull();
        } else if (current.right == null) {
           removeIfRightNull();
        } else {
            parent = current;
            node = current.right;
            current.value = getMin().value;
            if (isRight) {
                parent.right = null;
            } else {
                parent.left = null;
            }
        }
    }

    private void removeIfRightNull() {
        if (current.equals(rootNode)) {
            rootNode = null;
        } else if (isLeft) {
            parent.left = current.left;
        } else {
            parent.right = current.left;
        }
    }

    private void removeIfLeftNull() {
        if (current.equals(rootNode)) {
            rootNode = null;
        } else if (isLeft) {
            parent.left = current.right;
        } else {
            parent.right = current.right;
        }
    }

    private void removeNodeIfNoChild() {
        if (current.equals(rootNode)){
            rootNode = null;
        } else if (isLeft) {
            parent.left = null;
        } else {
            parent.right = null;
        }
    }

    private Node<E> getMin() {
        if (node.left == null) {
            return node;
        } else {
            parent = node;
            node = node.left;
            return getMin();
        }
    }

    public void print() {
        if (rootNode != null) {
            printRecursive(rootNode, 0);
        }
    }

    private void printRecursive(Node<E> node, int depth) {
        if (node.left != null) {
            printRecursive(node.left, depth + 1);
        }
        for (int i = 0; i < depth; i++) {
            System.out.print("  ");
        }
        System.out.println(node.getValue());
        if (node.right != null) {
            printRecursive(node.right, depth + 1);
        }
    }

    private static final class Node<E> {
        Node<E> left;
        Node<E> right;
        private E value;

        public Node(E value, Node<E> leftNode, Node<E> rightNode) {
            this.value = value;
            this.left = leftNode;
            this.right = rightNode;
        }

        public void setLeft(Node<E> left) {
            this.left = left;
        }

        public E getValue() {
            return value;
        }
    }

}
