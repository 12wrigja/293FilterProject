package test.Filter;

import static org.junit.Assert.assertEquals;
import main.filters.AverageFilter;
import main.filters.AverageNFilter;

import org.junit.Test;

public class AverageNFilterTest {
	
	private static final Double tolerance = new Double(0.00001);
	
	@Test
	public void testAverageFilter(){
		AverageNFilter<Double> avgFilter = new AverageNFilter<>(5);
		avgFilter.filter(5.0);
		assertEquals(new Double(5.0),avgFilter.getOutput(),tolerance);
		avgFilter.filter(6.0);
		assertEquals(new Double(5.5),avgFilter.getOutput(),tolerance);
		avgFilter.filter(7.0);
		assertEquals(new Double(6.0),avgFilter.getOutput(),tolerance);
		avgFilter.filter(8.0);
		assertEquals(new Double(6.5),avgFilter.getOutput(),tolerance);
		avgFilter.filter(9.0);
		assertEquals(new Double(7.0),avgFilter.getOutput(),tolerance);
		avgFilter.filter(6.0);
		assertEquals(new Double(7.2),avgFilter.getOutput(),tolerance);
		avgFilter.filter(7.0);
		assertEquals(new Double(7.4),avgFilter.getOutput(),tolerance);
		avgFilter.filter(8.0);
		assertEquals(new Double(7.6),avgFilter.getOutput(),tolerance);
		avgFilter.filter(9.0);
		assertEquals(new Double(7.8),avgFilter.getOutput(),tolerance);
	}
	
	@Test
	public void testAverageFilterReset(){
		AverageNFilter<Double> avgFilter = new AverageNFilter<>(5);
		avgFilter.filter(5.0);
		assertEquals(new Double(5.0),avgFilter.getOutput(),tolerance);
		avgFilter.filter(6.0);
		assertEquals(new Double(5.5),avgFilter.getOutput(),tolerance);
		avgFilter.filter(7.0);
		assertEquals(new Double(6.0),avgFilter.getOutput(),tolerance);
		avgFilter.filter(8.0);
		assertEquals(new Double(6.5),avgFilter.getOutput(),tolerance);
		avgFilter.filter(9.0);
		assertEquals(new Double(7.0),avgFilter.getOutput(),tolerance);
		avgFilter.filter(6.0);
		assertEquals(new Double(7.2),avgFilter.getOutput(),tolerance);
		avgFilter.filter(7.0);
		assertEquals(new Double(7.4),avgFilter.getOutput(),tolerance);
		avgFilter.filter(8.0);
		assertEquals(new Double(7.6),avgFilter.getOutput(),tolerance);
		avgFilter.filter(9.0);
		assertEquals(new Double(7.8),avgFilter.getOutput(),tolerance);
		
		avgFilter.reset(20.0);
		avgFilter.filter(8.0);
		assertEquals(new Double(14.0),avgFilter.getOutput(),tolerance);
		avgFilter.filter(9.0);
		assertEquals(new Double(12.3333333333),avgFilter.getOutput(),tolerance);
		avgFilter.filter(6.0);
		assertEquals(new Double(10.750),avgFilter.getOutput(),tolerance);
		avgFilter.filter(7.0);
		assertEquals(new Double(10),avgFilter.getOutput(),tolerance);
		avgFilter.filter(8.0);
		assertEquals(new Double(7.6),avgFilter.getOutput(),tolerance);
		avgFilter.filter(9.0);
		assertEquals(new Double(7.8),avgFilter.getOutput(),tolerance);
	}
}
