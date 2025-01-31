/**
 *
 */
package com.vedha.queues;

/**
 * @author sarath.perumal
 *
 */
public class LinkedListQueueDS<T> {

    Node head;
    Node tail;

    public LinkedListQueueDS() {

        head = null;
        tail = null;
    }

    public static void main(String[] args) {

        LinkedListQueueDS<String> linkedListQueueDS = new LinkedListQueueDS<>();
        linkedListQueueDS.enQueue("Vedha");
        linkedListQueueDS.enQueue("Vedha1");
        linkedListQueueDS.enQueue("Vedha2");
        linkedListQueueDS.display();
        linkedListQueueDS.deQueue();
        linkedListQueueDS.display();
        linkedListQueueDS.deQueue();
        linkedListQueueDS.deQueue();
        linkedListQueueDS.display();
        linkedListQueueDS.enQueue("Vedha Da");
        linkedListQueueDS.display();
        linkedListQueueDS.deQueue();
    }

    public void enQueue(T data) {

        Node newNode = new Node(data);

        if (head == null) {

            head = newNode;
        } else {

            tail.next = newNode;
        }
        tail = newNode;
    }

    public void deQueue() {

        if (head == null) {

            System.out.println("Empty List!!");
        } else {

            T data = head.data;
            System.out.println(data);
            head = head.next;

        }
    }

    public void display() {

        int i = 0;
        Node temp = head;
        System.out.print("Array : [ ");
        while (temp != null) {

            if (i == 0) {

                System.out.print("Node(" + temp.data + ", " + temp.next + ")");
            } else {

                System.out.print(", " + "Node(" + temp.data + ", " + temp.next + ")");
            }
            temp = temp.next;
            i++;
        }
        System.out.println(" ]");

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
