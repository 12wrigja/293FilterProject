package test.Filter;

import static org.junit.Assert.*;

import org.junit.Test;

import main.filters.AverageFilter;

public class AverageFilterTest {
	
	private static final Double tolerance = new Double(0.00001);
	
	@Test
	public void testAverageFilter(){
		AverageFilter<Double> avgFilter = new AverageFilter<>();
		avgFilter.filter(5.0);
		avgFilter.filter(6.0);
		avgFilter.filter(7.0);
		avgFilter.filter(8.0);
		avgFilter.filter(9.0);
		assertEquals(new Double(7.0),avgFilter.getOutput());
	}
	
	@Test
	public void testAverageFilterReset(){
		AverageFilter<Double> avgFilter = new AverageFilter<>();
		avgFilter.filter(5.0);
		avgFilter.filter(6.0);
		avgFilter.filter(7.0);
		avgFilter.reset(5.0);
		avgFilter.filter(8.0);
		avgFilter.filter(9.0);
		assertEquals(new Double(7.33333333),avgFilter.getOutput(),tolerance);
	}
}
