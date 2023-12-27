/**
 * 
 */
package com.vedha.lists;

import java.util.Arrays;
import java.util.Iterator;

/**
 * @author sarath.perumal
 *
 */

/*
 * O(1): Executes in the same time regardless of the size of the input.
 * O(n): Executes linearly and proportionally to the size of the input.
 * O(n²): Performance is directly proportional to the square of the size of the input (example: nested iterations, loops).
 */

/*
 * Search O(1) -> time complexity constants for searching it uses index to search.
 * insert O(n) -> time complexity linear increment because of 1000 inputs insert in first.
 * remove O(n) -> time complexity linear increment because of 1000 inputs remove in first.
 */

class DynamicArray<T> implements Iterable<T> { // Iterable -> for-each

	private T[] arr;
	private int size, capacity;
	private static final int initialCapacity = 4;

	@SuppressWarnings("unchecked")
	public DynamicArray() {

		size = 0; // To Track The Size Of Array
		arr = (T[]) new Object[initialCapacity]; // Initial Size
		capacity = initialCapacity; // Current Size
	}

	public void add(T data) {

		extendArray();
		arr[size] = data;
		size++;

	}

	public void display() {

		if (size > 0) {

			System.out.print("Array : [ ");
			for (int i = 0; i < size; i++) {

				if (i == 0) {

					System.out.print(arr[i]);
				} else {

					System.out.print(", " + arr[i]);
				}
			}
			System.out.println(" ]");
		} else {

			System.out.println("no data");
		}

	}

	public void insertAtPos(int pos, T data) {

		if (pos >= 0 && pos <= size) {

			extendArray();

			for (int i = size - 1; i >= pos; i--) {

				arr[i + 1] = arr[i];
			}
			arr[pos] = data;
			size++;
		} else {

			System.out.println("invalid position : " + pos);
		}

	}

	public void deleteAtPos(int pos) {

		if (pos >= 0 && pos < size) {

			for (int i = pos + 1; i < size; i++) {

				arr[i - 1] = arr[i];
			}
			size--;
		} else {

			System.out.println("invalid position : " + pos);
		}

		shrinkArray();

	}

	public void deleteAtEnd() {

		arr[size - 1] = null;
		size--;
	}

	public void deleteAtBeginning() {

		if (0 < size) {

			for (int i = 0 + 1; i < size; i++) {

				arr[i - 1] = arr[i];
			}

			size--;
		}

		shrinkArray();

	}

	public void insertAtFirst(T data) {

		if (size >= 0) {

			extendArray();

			for (int i = size - 1; i >= 0; i--) {

				arr[i + 1] = arr[i];
			}
			arr[0] = data;
			size++;
		}
	}

	public void get(int pos) {

		if (pos >= 0 && pos < size) {

			System.out.println(arr[pos]);
		} else {

			System.out.println("invalid position : " + pos);
		}
	}

	public void update(int pos, T data) {

		if (pos >= 0 && pos < size) {

			arr[pos] = data;
		} else {

			System.out.println("invalid position : " + pos);
		}
	}

	public void serach(T data) {

		int pos = -1;
		for (int i = 0; i < size; i++) {

			if (data.equals(arr[i])) {

				pos = i;
			}
		}

		System.out.println("position : " + pos);
	}

	public void contains(T data) {

		boolean flag = false;
		for (int i = 0; i < size; i++) {

			if (data.equals(arr[i])) {

				flag = true;
			}
		}

		System.out.println("contains : " + flag);
	}

	public void clear() {

		size = 0;
		shrinkArray();
		System.out.println("Array cleared");
	}

	public void capacity() {

		System.out.println("capacity : " + capacity);
	}

	public void size() {

		System.out.println("current insert position(starts at 0) : " + size);
	}

	private void extendArray() {

		if (size == capacity) {

			capacity *= 2;
			arr = Arrays.copyOf(arr, capacity);
		}

	}

	private void shrinkArray() {

		if (capacity > initialCapacity && capacity > size * 2) {

			capacity /= 2;
			arr = Arrays.copyOf(arr, capacity);
		}
	}

	// for-each and iterator
	@Override
	public Iterator<T> iterator() {

		return new Iterator<T>() {

			int index = 0;

			@Override
			public boolean hasNext() {

				if (index < size) {

					return true;
				} else {

					return false;
				}
			}

			@Override
			public T next() {

				return arr[index++];
			}
		};
	}

}

public class ArrayListDS {

	public static void main(String[] args) {

		DynamicArray<String> array = new DynamicArray<String>();
		array.add("vedha");
		array.add("leo");

		array.update(1, "Leo Das");

		array.insertAtPos(0, "Master");

		array.insertAtFirst("Vedha Da");

		array.insertAtFirst("Test");

		array.deleteAtBeginning();

		array.deleteAtEnd();

		array.display();

		Iterator<String> iterator = array.iterator();
		while (iterator.hasNext()) {
			String string = (String) iterator.next();
			System.out.println(string);

		}

		array.contains("vedha");

		array.get(0);

		array.serach("Master");

		// Using Iterator
		for (String string : array) {

			System.out.println(string);
		}
	}
}
