/**
 * 
 */
package com.vedha.lists;

import java.util.Iterator;

/**
 * @author sarath.perumal
 *
 */
public class LinkedListDS<T> implements Iterable<T> {

	Node head;
	Node tail;

	public LinkedListDS() {

		head = null;
		tail = null;

	}

	class Node {

		T data;
		Node next;

		public Node(T val) {

			data = val;
			next = null;

		}
	}

	public void add(T data) {

		if (head == null) {

			insertAtBegining(data);
		} else {

			Node newNode = new Node(data);
			tail.next = newNode;
			tail = newNode;
		}
	}

	public void insertAtBegining(T data) {

		Node newNode = new Node(data);

		if (head == null) {

			head = newNode;
			tail = newNode;
		} else {

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

					newNode.next = temp.next;
					temp.next = newNode;

					if (temp == tail) {

						tail = newNode;
					}

				}

			} else {

				System.out.println("Invalid Position : " + pos);
			}
		} catch (Exception e) {

			throw new IndexOutOfBoundsException("Invalid Position : " + pos);
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

					prev.next = temp.next;

					if (temp == tail) {

						tail = prev;
					}

				}

			} else {

				System.out.println("Invalid Position : " + pos);
			}

		} catch (Exception e) {

			throw new IndexOutOfBoundsException("Invalid Position : " + pos);
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

				System.out.print("Node(" + temp.data + ", " + temp.next + ")");
			} else {

				System.out.print(", " + "Node(" + temp.data + ", " + temp.next + ")");
			}
			temp = temp.next;
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
	}

	public void reverse() {

		Node prev = null;
		Node current = head;
		Node next = head.next;

		while (current != null) {

			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}

		head = prev;
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

		LinkedListDS<String> linList = new LinkedListDS<String>();
		linList.insertAtBegining("Vedha");
		linList.insertAtBegining("Sarath");
		linList.display();
//		linList.serach("Vedha");
		linList.insertAtPosition(2, "Master");
//		linList.insertAtPosition(3, "Leo");
		linList.display();
//		linList.size();
		linList.deleteAtPosition(2);
		linList.display();
		linList.add("Leo");
		linList.display();
		linList.deleteAtBegining();
		linList.deleteAtBegining();
		linList.display();
//		linList.add("Vedha Da");
		linList.deleteAtBegining();
		linList.display();
		linList.add("Vedha");
		linList.display();
		linList.insertAtPosition(1, "Hi");
		linList.display();
		linList.deleteAtPosition(1);
		linList.display();
		linList.add("Vedhaa");
		linList.display();
//		linList.contains("Leo");
//		linList.update(3, "Leos");
//		linList.display();
//		linList.size();
//		linList.get(2);
//		//linList.clear();
//		linList.reverse();
//
//		for (String string : linList) {
//
//			System.out.println(string);
//		}
	}

}
