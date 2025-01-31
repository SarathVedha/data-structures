/**
 *
 */
package com.vedha.stacks;

/**
 * @author sarath.perumal
 *
 */
public class LinkedListStackDS<T> {

    private Node head;

    public LinkedListStackDS() {

        head = null;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {

        LinkedListStackDS<String> linkedListStackDS = new LinkedListStackDS<>();
        linkedListStackDS.push("Vedha");
        linkedListStackDS.push("Vedha2");
        linkedListStackDS.push("Vedha3");
        linkedListStackDS.peek();
        linkedListStackDS.pop();
        linkedListStackDS.peek();
        System.out.println(linkedListStackDS.isEmpty());
    }

    // Inserting at beginning for O(1) for constant time
    private void insertAtBegining(T val) {

        Node newNode = new Node(val);
        if (head == null) {

            head = newNode;
        } else {

            newNode.next = head;
            head = newNode;
        }
    }

    public void push(T val) { // add

        insertAtBegining(val);
    }

    public T pop() { // delete

        T data = null;
        if (head == null) {

            System.out.println("Empty Stack");
            return data;
        } else {

            data = head.data;
            head = head.next;
            System.out.println(data);
            return data;
        }
    }

    public T peek() {

        T data = null;
        if (head == null) {

            System.out.println("Empty Stack");
            return null;
        } else {

            data = head.data;
            System.out.println(data);
            return data;
        }
    }

    public boolean isEmpty() {

        return head == null;
    }

    class Node {

        T data;
        Node next;

        public Node(T val) {

            data = val;
            next = null;
        }
    }

}
