/**
 * 
 */
package com.vedha.lists;

/**
 * @author sarath.perumal
 *
 */
public class CircularLinkedListDS<T> {

	Node last;

	class Node {

		T data;
		Node next;

		public Node(T val) {

			data = val;
			next = null;

		}

	}

	public void insertAtBegining(T val) {

		Node newNode = new Node(val);
		if (last == null) {

			newNode.next = newNode;
			last = newNode;
		} else {

			newNode.next = last.next;
			last.next = newNode;
		}
	}

	public void insertAtLast(T val) {

		Node newNode = new Node(val);
		if (last == null) {

			newNode.next = newNode;
			last = newNode;
		} else {

			newNode.next = last.next;
			last.next = newNode;
			last = newNode;
		}
	}

	public void deleteAtBegining() {

		if (last != null) {

			if (last == last.next) {

				last = null;
			} else {

				Node first = last.next;
				last.next = first.next;
				first = null;

				// last.next = last.next.next;
			}
		} else {

			System.out.println("Empty List");
		}
	}

	public void deleteAtLast() {

		if (last != null) {

			if (last == last.next) {

				last = null;
			} else {

				Node temp = last.next;
				while (temp.next != last) {

					temp = temp.next;
				}

				temp.next = last.next;
				last = temp;
			}
		} else {

			System.out.println("Empty List");
		}
	}

	public void size() {

		if (last == null) {

			System.out.println("Empty List");
		} else {

			Node temp = last.next;
			int i = 0;
			do {

				temp = temp.next;
				i++;
			} while (temp != last.next);
			System.out.println("Size : " + i);
		}
	}

	public void display() {

		if (last != null) {

			Node temp = last.next;
			int i = 0;

			System.out.print("Array : [ ");
			do {

				if (temp != null) {

					if (i == 0) {

						System.out.print("Node(" + temp.data + ", " + temp.next + ")");
					} else {

						System.out.print(", " + "Node(" + temp.data + ", " + temp.next + ")");
					}
					temp = temp.next;
					i++;
				}

			} while (temp != last.next);
			System.out.println(" ]");
		} else {

			System.out.print("Array : [ ");
			System.out.println(" ]");
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		CircularLinkedListDS<String> circularLinkedListDS = new CircularLinkedListDS<>();
		circularLinkedListDS.insertAtBegining("Vedha");
		circularLinkedListDS.display();
		circularLinkedListDS.insertAtBegining("Vedha2");
		circularLinkedListDS.display();
		circularLinkedListDS.insertAtLast("Vedha3");
		circularLinkedListDS.display();
		circularLinkedListDS.size();
		circularLinkedListDS.deleteAtLast();
		circularLinkedListDS.display();

	}

}
