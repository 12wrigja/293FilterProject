package test.Filter;

import static org.junit.Assert.*;

import java.util.Comparator;

import main.filters.MaxFilter;
import main.filters.MinFilter;

import org.junit.Test;

public class MaxFilterTest {

	// Thoroughly tests the maximum filter in the various configurations you can
	// use it in.

	// Filter with no comparator - uses natural ordering.
	// - Tests to see if the lexicographical ordering works
	// - Tests to see if the reset function works.

	@Test
	public void testMaximumFilter() {
		// Test the Maximum filter's ability to work on comparable objects, sans
		// a comparator.
		MaxFilter<String> wordFilter = MaxFilter.newInstance();
		wordFilter.filter("Hello");
		assertEquals("Hello", wordFilter.getOutput());
		wordFilter.filter("Insect");
		assertEquals("Insect", wordFilter.getOutput());
		wordFilter.filter("Abacus");
		assertEquals("Insect", wordFilter.getOutput());
	}

	@Test
	public void testMaxFilterReset() {
		MaxFilter<String> wordFilter = MaxFilter.newInstance();
		wordFilter.filter("Hello");
		assertEquals("Hello", wordFilter.getOutput());
		wordFilter.filter("Insect");
		assertEquals("Insect", wordFilter.getOutput());
		wordFilter.filter("Abacus");
		assertEquals("Insect", wordFilter.getOutput());
		wordFilter.reset("Tests");
		assertEquals("Tests", wordFilter.getOutput());
		wordFilter.filter("Hello");
		assertEquals("Tests", wordFilter.getOutput());
		wordFilter.filter("Insect");
		assertEquals("Tests", wordFilter.getOutput());
		wordFilter.filter("Abacus");
		assertEquals("Tests", wordFilter.getOutput());
		wordFilter.filter("Venus");
		assertEquals("Venus", wordFilter.getOutput());
	}
	
	
	//Tests with the comparator in order to make sure that is used over natural ordering.
	//Test the ability of the comparator.
	@Test
	public void testMaximumFilterComparator() {
		MaxFilter<String> longestLengthWordFilter = MaxFilter
				.newComparatorInstance(new Comparator<String>() {
					@Override
					public int compare(String arg0, String arg1) {
						Integer length0 = new Integer(arg0.length());
						Integer length1 = new Integer(arg1.length());
						return length0.compareTo(length1);
					}
				});

		longestLengthWordFilter.filter("Hello");
		assertEquals("Hello", longestLengthWordFilter.getOutput());
		longestLengthWordFilter.filter("Insect");
		assertEquals("Insect", longestLengthWordFilter.getOutput());
		longestLengthWordFilter.filter("Aba");
		assertEquals("Insect", longestLengthWordFilter.getOutput());

	}

	//Test that the reset function works.
	@Test
	public void testMaximumFilterComparatorReset() {
		MaxFilter<String> longestLengthWordFilter = MaxFilter
				.newComparatorInstance(new Comparator<String>() {
					@Override
					public int compare(String arg0, String arg1) {
						Integer length0 = new Integer(arg0.length());
						Integer length1 = new Integer(arg1.length());
						return length0.compareTo(length1);
					}
				});

		longestLengthWordFilter.filter("Hello");
		assertEquals("Hello", longestLengthWordFilter.getOutput());
		longestLengthWordFilter.filter("Insect");
		assertEquals("Insect", longestLengthWordFilter.getOutput());
		longestLengthWordFilter.filter("Aba");
		assertEquals("Insect", longestLengthWordFilter.getOutput());
		longestLengthWordFilter.reset("Tests");
		assertEquals("Tests", longestLengthWordFilter.getOutput());
		longestLengthWordFilter.filter("Hello");
		assertEquals("Tests", longestLengthWordFilter.getOutput());
		longestLengthWordFilter.filter("Insect");
		assertEquals("Insect", longestLengthWordFilter.getOutput());
		longestLengthWordFilter.filter("Abacus");
		assertEquals("Insect", longestLengthWordFilter.getOutput());
	}
	
	
	//Test and make sure that it works with a class that does not implement comparable so long as you provide a comparator.
	@Test
	public void testMaximumFilterCustomClass() {
		class TempClass {
			private int a;

			public TempClass(int a) {
				this.a = a;
			}

			public int getA() {
				return this.a;
			}

			@Override
			public int hashCode() {
				return a;
			}

			@Override
			public boolean equals(Object obj) {
				if (null != obj && obj instanceof TempClass) {
					return this.getA() == ((TempClass) obj).getA();
				} else {
					return false;
				}
			}
		}
		TempClass val1 = new TempClass(100);
		TempClass val2 = new TempClass(50);
		MaxFilter<TempClass> smallestTempClassFilter = MaxFilter
				.newComparatorInstance(new Comparator<TempClass>() {

					@Override
					public int compare(TempClass arg0, TempClass arg1) {
						return ((Integer) arg0.getA())
								.compareTo(((Integer) arg1.getA()));
					}
				});

		smallestTempClassFilter.filter(val1);
		assertEquals(val1, smallestTempClassFilter.getOutput());
		smallestTempClassFilter.filter(val2);
		assertEquals(val1, smallestTempClassFilter.getOutput());
		smallestTempClassFilter.filter(val1);
		assertEquals(val1, smallestTempClassFilter.getOutput());
	}
}
