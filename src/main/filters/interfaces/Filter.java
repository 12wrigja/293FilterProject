package main.filters.interfaces;


public interface Filter<I,O> {
	public void filter(I input);
	public O getOutput();
}
