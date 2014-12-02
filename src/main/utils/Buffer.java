package main.utils;

import java.util.Arrays;

/**
 * The buffer class is an implementation of a circular buffer that is
 * auto-evicting. If the capacity of the buffer is reached, the oldest element
 * is automatically evicted whenever a new element is added.
 * 
 * @author james
 *
 * @param <E>
 *            The type of object that this buffer can contain.
 */
public class Buffer<E> {

	private final E[] buffer;
	private final int size;

	private int startPointer = 0;
	private int endPointer = 0;

	private int fill_count = 0;

	/**
	 * Buffer Constructor. Sets the capacity of the buffer. Sets all the
	 * contents to be null objects.
	 * 
	 * @param capacity
	 *            The capacity of the buffer.
	 */
	public Buffer(int capacity) {
		this.size = capacity;
		buffer = (E[]) new Object[size];
	}

	/**
	 * Buffer constructor. Sets the capacity of the buffer and initializes the
	 * elements to be the specified default object.
	 * 
	 * @param capacity
	 *            The capacity of the buffer.
	 * @param defaultObject
	 *            The object to set the contents of the buffer to.
	 */
	public Buffer(int capacity, E defaultObject) {
		this(capacity);
		for (int i = 1; i < buffer.length; i++) {
			buffer[i] = defaultObject;
		}
	}

	/**
	 * Adds an element to the buffer. Returns the element that was evicted, if
	 * any.
	 * 
	 * @param obj
	 *            The object to add to the buffer.
	 * @return Returns the object that was evicted to make room for the provided
	 *         object.
	 */
	public E addFirst(E obj) {
		E returnItem = null;
		if (fill_count == size) {
			returnItem = removeLast();
		}
		buffer[startPointer] = obj;
		fill_count++;
		startPointer = wrapIndex(startPointer + 1);
		return returnItem;
	}

	/**
	 * Removes the last (oldest) object in the buffer. Will return null if there
	 * is nothing in the buffer.
	 * 
	 * @return Returns the oldest object, or null if the buffer is empty.
	 */
	public E removeLast() {
		if (isEmpty()) {
			return null;
		}
		E obj = buffer[endPointer];
		endPointer = wrapIndex(endPointer + 1);
		fill_count--;
		return obj;
	}

	/**
	 * Gets the object at index i, with index 0 being the newest element and
	 * going older as the index increases. Will throw an indexOutOfBounds
	 * exception if the provided index is invalid.
	 * 
	 * @param i
	 *            The index to retrieve the item from.
	 * @return The item at that index.
	 */
	public E get(int i) {
		return buffer[wrapIndex(startPointer - 1 - i)];
	}

	/**
	 * Returns the size of the buffer. Note that this is different from the
	 * provided capacity. This returns the number of objects currently in the
	 * buffer, which might be smaller than the capacity.
	 * 
	 * @return Returns the current size of the buffer.
	 */
	public int size() {
		return fill_count;
	}

	/**
	 * Determines if the buffer is at capacity.
	 * 
	 * @return Returns true if the buffer is at capacity, false otherwise.
	 */
	public boolean isFull() {
		return size == fill_count;
	}

	/**
	 * Determines if the buffer is empty.
	 * 
	 * @return Returns true if the buffer is empty, false otherwise.
	 */
	public boolean isEmpty() {
		return 0 == fill_count;
	}

	private int wrapIndex(int i) {
		int index = i % size;
		return (index < 0) ? index += size : index;
	}

	/**
	 * Clears the contents of the buffer and sets the objects to the default
	 * object provided. Will set the objects to null if null is provided as the
	 * object reference.
	 * 
	 * @param defaultObject
	 *            The object to set the contents of the buffer to. Can be null.
	 */
	public void clear(E defaultObject) {
		startPointer = 0;
		endPointer = 0;
		fill_count = 0;
		for (int i = 0; i < buffer.length; i++) {
			buffer[i] = defaultObject;
		}
	}

	@Override
	public String toString() {
		return Arrays.deepToString(toArray());
	}

	private E[] toArray() {
		int index = 0;
		E[] arr = (E[]) new Object[size];
		while (index < size) {
			arr[index] = get(index);
			index++;
		}
		return arr;
	}
}
