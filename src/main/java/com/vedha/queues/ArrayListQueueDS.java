/**
 * 
 */
package com.vedha.queues;

import java.util.Arrays;

/**
 * @author sarath.perumal
 *
 */
public class ArrayListQueueDS<T> {

	private static final int MAX_SIZE = 10;
	private T[] arr;
	private int first;
	private int last;

	@SuppressWarnings("unchecked")
	public ArrayListQueueDS() {

		arr = (T[]) new Object[MAX_SIZE];
		first = -1;
		last = -1;
	}

	// Array is not suitable to queue because of memory and time complexity

	// enQueue no loop so time complexity is O(1)
	public void enQueue(T data) {

		if (last == MAX_SIZE - 1) {

			arr = Arrays.copyOf(arr, MAX_SIZE * 3);
		}

		if (first == -1) {

			first = 0;
		}

		arr[++last] = data;
	}

	// deQueue time complexity is O(1) but memory is increased because moving first
	// and last
//	public void deQueue() {
//
//		if (first == -1 || first > last) {
//
//			System.out.println("Queue Is Empty!!");
//		} else {
//
//			System.out.println(arr[first++]);
//		}
//	}

	// deQueue time complexity is O(n) loop is there but no extra memory used
	public void deQueue() {

		if (first == -1) {

			System.out.println("Queue Is Empty!!");
		} else {

			System.out.println(arr[0]);
			for (int i = 1; i <= last; i++) {

				arr[i - 1] = arr[i];
			}
			last--;
		}
	}

//	public void display() {
//
//		if (first == -1 || last == -1 || first > last) {
//
//			System.out.println("Queue Is Empty!!");
//		} else {
//
//			System.out.println("Queue : " + Arrays.toString(Arrays.copyOfRange(arr, first, last + 1)));
//		}
//	}

	public void display() {

		if (first == -1) {

			System.out.println("Queue Is Empty!!");
		} else {

			System.out.println("Queue : " + Arrays.toString(Arrays.copyOfRange(arr, 0, last + 1)));
		}
	}

	public static void main(String[] args) {

		ArrayListQueueDS<String> arrayListQueueDS = new ArrayListQueueDS<>();
		arrayListQueueDS.display();
		arrayListQueueDS.enQueue("Master");
		arrayListQueueDS.display();
		arrayListQueueDS.enQueue("Master0");
		arrayListQueueDS.display();
		arrayListQueueDS.deQueue();
		arrayListQueueDS.display();

		arrayListQueueDS.enQueue("Master1");
		arrayListQueueDS.enQueue("Master2");
		arrayListQueueDS.enQueue("Master3");
		arrayListQueueDS.enQueue("Master4");
		arrayListQueueDS.display();
		arrayListQueueDS.deQueue();
		arrayListQueueDS.deQueue();
		arrayListQueueDS.display();
	}

}
