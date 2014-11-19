package main.filters.interfaces;

public interface ResetableFilter<I>{
	public void reset(I nextInput);
}
