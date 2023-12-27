package com.vedha.stacks;

import java.util.Arrays;

public class ArrayListStackDS<T> {

	private final static int MAX_SIZE = 30;
	private T[] arr;
	private int top;

	@SuppressWarnings("unchecked")
	public ArrayListStackDS() {

		arr = (T[]) new Object[MAX_SIZE];
		top = -1; // should me -1 while adding 1st data it will change to 0
	}

	// Push it at end it will be no loop and O(1) Constant time
	public void push(T data) { // add

		if (top == MAX_SIZE - 1) {

			arr = Arrays.copyOf(arr, MAX_SIZE * 2);
		}
		arr[++top] = data; // ++top before increment
	}

	// Push it at end it will be no loop and O(1) Constant time
	// Memory also managed because while pop will top --, so while push data will
	// replace
	public T pop() { // delete

		T data = null;
		if (top == -1) {

			System.out.println("Empty Stack");
			return data;
		} else {

			data = arr[top--]; // --top after returning top and decrementing
			System.out.println(data);
			return data;
		}

	}

	public boolean isEmpty() {

		if (top == -1) {

			return true;
		} else {

			return false;
		}
	}

	public T peek() {

		T data = null;
		if (top == -1) {

			System.out.println("Empty Stack");
			return data;
		} else {

			data = arr[top];
			System.out.println(data);
			return data;
		}
	}

	public void display() {

		System.out.println(Arrays.toString(Arrays.copyOfRange(arr, 0, top + 1)));
	}

	public static void main(String[] args) {

		ArrayListStackDS<String> arrayListStackDS = new ArrayListStackDS<>();
		arrayListStackDS.push("Vedha");
		arrayListStackDS.push("Vedha1");
		arrayListStackDS.push("Vedha2");
		arrayListStackDS.push("Vedha3");
		arrayListStackDS.peek();
		arrayListStackDS.pop();
		arrayListStackDS.push("Vedha3");
		arrayListStackDS.peek();
		arrayListStackDS.display();

	}

}
