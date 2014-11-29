package test.Filter;

import static org.junit.Assert.assertEquals;
import main.filters.AverageFilter;

import org.junit.Test;

public class AverageFilterTest {
	
	private static final Double tolerance = new Double(0.00001);
	
	@Test
	public void testAverageFilter(){
		AverageFilter avgFilter = new AverageFilter();
		avgFilter.filter(new Double(5.0));
		avgFilter.filter(new Double(6.0));
		avgFilter.filter(new Double(7.0));
		avgFilter.filter(new Double(8.0));
		avgFilter.filter(new Double(9.0));
		assertEquals(new Double(7.0),avgFilter.getOutput());
	}
	
	@Test
	public void testAverageFilterReset(){
		AverageFilter avgFilter = new AverageFilter();
		avgFilter.filter(new Double(5.0));
		avgFilter.filter(new Double(6.0));
		avgFilter.filter(new Double(7.0));
		avgFilter.reset(new Double(5.0));
		avgFilter.filter(new Double(8.0));
		avgFilter.filter(new Double(9.0));
		assertEquals(new Double(7.33333333),avgFilter.getOutput(),tolerance);
	}
}
