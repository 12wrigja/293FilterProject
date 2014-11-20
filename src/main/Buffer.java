package main;

import java.util.Arrays;

import main.filters.exceptions.BufferException;

public class Buffer<E> {
	
	private final E[] buffer;
	private final int size;
	
	private int startPointer = 0;
	private int endPointer = 0;
	
	private int fill_count = 0;
	
	public Buffer(int capacity){
		this.size = capacity;
		buffer = (E[]) new Object[size];
	}
	
	public Buffer(int capacity, E defaultObject){
		this(capacity);
		for(int i=1; i<buffer.length; i++){
			buffer[i] = defaultObject;
		}
	}
	
	public E addFirst(E obj){
		E returnItem = null;
		if(fill_count == size){
			returnItem = removeLast();
		}
		buffer[startPointer] = obj;
		fill_count ++;
		startPointer = wrapIndex(startPointer + 1);
		return returnItem;
	}
	
	public E removeLast(){	
		if(isEmpty()){
			return null;
		}
		E obj = buffer[endPointer];
		endPointer = wrapIndex(endPointer + 1);
		fill_count --;
		return obj;
	}
	
	public E get(int i){
		return buffer[wrapIndex(startPointer-1-i)];
	}
	
	public int size(){
		return fill_count;
	}
	
	public boolean isFull(){
		return  size == fill_count;
	}
	
	public boolean isEmpty(){
		return  0 == fill_count;
	}
	
	private int wrapIndex(int i){
		int index = i%size;
		return (index < 0)?index+=size:index;
	}
	
	public void clear(E defaultObject){
		startPointer = 0;
		endPointer = 0;
		fill_count = 0;
		for(int i=0; i<buffer.length; i++){
			buffer[i] = defaultObject;
		}
	}
	
	@Override
	public String toString() {
		return Arrays.deepToString(toArray());
	}
	
	private E[] toArray(){
		int index = 0;
		E[] arr = (E[]) new Object[size];
		while(index < size){
			arr[index] = get(index);
			index++;
		}
		return arr;
	}
}
