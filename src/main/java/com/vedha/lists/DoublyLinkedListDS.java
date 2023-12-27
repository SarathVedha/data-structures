/**
 * 
 */
package com.vedha.lists;

import java.util.Iterator;

/**
 * @author sarath.perumal
 *
 */
public class DoublyLinkedListDS<T> implements Iterable<T> {

	Node head;
	Node tail;

	public DoublyLinkedListDS() {

		head = null;
		tail = null;

	}

	class Node {

		T data;
		Node next;
		Node prev;

		public Node(T val) {

			data = val;
			next = null;
			prev = null;

		}
	}

	public void insertAtBegining(T data) {

		Node newNode = new Node(data);

		if (head == null) {

			head = newNode;
			tail = newNode;
		} else {

			head.prev = newNode;
			newNode.next = head;
			head = newNode;

		}
	}

	public void insertAtPosition(int pos, T data) {

		try {

			if (pos >= 0) {

				if (pos == 0) {

					insertAtBegining(data);
				} else {

					Node newNode = new Node(data);
					Node temp = head;
					for (int i = 1; i < pos; i++) {

						temp = temp.next;
					}

					newNode.prev = temp;
					newNode.next = temp.next;

					if (temp == tail) {

						tail = newNode;
						temp.next = newNode;
					} else {

						temp.next.prev = newNode;
						temp.next = newNode;
					}

				}

			} else {

				System.out.println("Invalid Position : " + pos);
			}
		} catch (Exception e) {

			throw new IndexOutOfBoundsException("Invalid Position : " + pos);
		}

	}

	public void insertAtLast(T data) {

		if (head == null) {

			insertAtBegining(data);
		} else {

			Node newNode = new Node(data);
			Node temp = tail;
			newNode.prev = temp;
			temp.next = newNode;
			tail = newNode;
		}
	}

	public void deleteAtBegining() {

		if (head == null) {

			System.out.println("Empty List");
		} else {

			Node temp = head;
			head = temp.next;

			if (head == null) {

				tail = null;
			} else {

				head.prev = null;
				temp = null;
			}

		}

	}

	public void deleteAtPosition(int pos) {

		try {

			if (pos >= 0) {

				if (pos == 0) {

					deleteAtBegining();
				} else {

					Node temp = head;
					Node prev = null;

					for (int i = 1; i <= pos; i++) {

						prev = temp;
						temp = temp.next;
					}

					if (tail == temp) {

						prev.next = null;
						tail = prev;
					} else {

						prev.next = temp.next;
						temp.next.prev = prev;
					}
					temp = null;
				}

			} else {

				System.out.println("Invalid Position : " + pos);
			}

		} catch (Exception e) {

			throw new IndexOutOfBoundsException("Invalid Position : " + pos);
		}

	}

	public void deleteAtLast() {

		if (tail == null) {

			System.out.println("Empty List");
		} else {

			Node temp = tail;
			Node prev = temp.prev;
			prev.next = null;
			tail = prev;

		}
	}

	public void serach(T data) {

		int i = -1;
		int j = 0;
		Node temp = head;
		while (temp != null) {

			if (temp.data.equals(data)) {

				i = j;
			}
			temp = temp.next;
			j++;
		}

		System.out.println("Index : " + i);

	}

	public void get(int pos) {

		try {

			Node temp = head;
			T data = null;
			if (pos >= 0) {

				if (pos == 0) {

					data = temp.data;
				} else {

					for (int i = 1; i <= pos; i++) {

						data = temp.data;
						temp = temp.next;

					}
				}
			}

			System.out.println("Data : " + data);
		} catch (Exception e) {

			throw new IndexOutOfBoundsException("Invalid Position : " + pos);
		}

	}

	public void update(int pos, T data) {

		try {

			if (pos >= 0) {

				if (pos == 0) {

					head.data = data;
				} else {

					Node temp = head;
					for (int i = 1; i <= pos; i++) {

						if (i == pos) {

							temp.data = data;
						}

						temp = temp.next;
					}
				}
			} else {

				System.out.println("Invalid Position : " + pos);
			}

		} catch (Exception e) {

			throw new IndexOutOfBoundsException("Invalid Position : " + pos);
		}
	}

	public void contains(T data) {

		boolean flag = false;
		Node temp = head;
		while (temp != null) {

			if (temp.data.equals(data)) {

				flag = true;
			}
			temp = temp.next;
		}

		System.out.println("Contains : " + flag);
	}

	public void display() {

		int i = 0;
		Node temp = head;
		System.out.print("Array : [ ");
		while (temp != null) {

			if (i == 0) {

				System.out.print("Node(" + temp.prev + ", " + temp.data + ", " + temp.next + ")");
			} else {

				System.out.print(", " + "Node(" + temp.prev + ", " + temp.data + ", " + temp.next + ")");
			}
			temp = temp.next;
			i++;
		}
		System.out.println(" ]");
	}

	public void displayReverse() {

		int i = 0;
		Node temp = tail;
		System.out.print("Array : [ ");
		while (temp != null) {

			if (i == 0) {

				System.out.print("Node(" + temp.next + ", " + temp.data + ", " + temp.prev + ")");
			} else {

				System.out.print(", " + "Node(" + temp.next + ", " + temp.data + ", " + temp.prev + ")");
			}
			temp = temp.prev;
			i++;
		}
		System.out.println(" ]");
	}

	public void size() {

		int i = 0;
		Node temp = head;
		while (temp != null) {

			temp = temp.next;
			i++;
		}
		System.out.println("Size : " + i);
	}

	public void clear() {

		head = null;
		tail = null;
	}

	public void reverse() {

		Node prev = null;
		Node current = head;

		if (head == null) {

			System.out.println("Empty List");
		} else {

			Node next = head.next;
			int count = 0;
			while (current != null) {

				prev = current.prev;
				next = current.next;
				current.prev = next;
				current.next = prev;
				if (count == 0) {

					tail = current;
				}
				prev = current;
				current = next;
				count++;
			}

			head = prev;
		}

	}

	@Override
	public Iterator<T> iterator() {

		return new Iterator<T>() {

			Node temp = head;

			@Override
			public boolean hasNext() {

				if (temp != null) {

					return true;
				} else {

					return false;
				}
			}

			@Override
			public T next() {

				T val = temp.data;
				temp = temp.next;
				return val;
			}
		};
	}

	public static void main(String[] args) {

		DoublyLinkedListDS<String> linList = new DoublyLinkedListDS<String>();
		linList.insertAtBegining("Vedha1");
		linList.insertAtLast("Vedha2");
		linList.insertAtBegining("Vedha");

		linList.display();

		linList.reverse();

		linList.display();

		linList.displayReverse();

		linList.display();

		linList.reverse();

		linList.display();

		linList.size();
		linList.contains("Vedha5");

	}

}
