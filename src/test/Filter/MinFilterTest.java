package test.Filter;

import static org.junit.Assert.*;

import java.util.Comparator;

import main.filters.MinFilter;

import org.junit.Test;

public class MinFilterTest {

	// Thoroughly tests the minimum filter in the various configurations you can
	// use it in.

	// Filter with no comparator - uses natural ordering.
	// - Tests to see if the lexicographical ordering works
	// - Tests to see if the reset function works.

	@Test
	public void testMinimumFilter() {
		// Test the Minimum filter's ability to work on comparable objects, sans
		// a comparator.
		MinFilter<String> wordFilter = MinFilter.newInstance();
		wordFilter.filter("Hello");
		assertEquals("Hello", wordFilter.getOutput());
		wordFilter.filter("Insect");
		assertEquals("Hello", wordFilter.getOutput());
		wordFilter.filter("Abacus");
		assertEquals("Abacus", wordFilter.getOutput());
	}

	@Test
	public void testMinimumFilterReset() {
		MinFilter<String> wordFilter = MinFilter.newInstance();
		wordFilter.filter("Hello");
		assertEquals("Hello", wordFilter.getOutput());
		wordFilter.filter("Insect");
		assertEquals("Hello", wordFilter.getOutput());
		wordFilter.filter("Abacus");
		assertEquals("Abacus", wordFilter.getOutput());
		wordFilter.reset("Tests");
		assertEquals("Tests", wordFilter.getOutput());
		wordFilter.filter("Hello");
		assertEquals("Hello", wordFilter.getOutput());
		wordFilter.filter("Insect");
		assertEquals("Hello", wordFilter.getOutput());
		wordFilter.filter("Abacus");
		assertEquals("Abacus", wordFilter.getOutput());
	}

	//Tests with the comparator in order to make sure that is used over natural ordering.
	//Test the ability of the comparator.
	@Test
	public void testMinimumFilterComparator() {
		MinFilter<String> smallestLengthWordFilter = MinFilter
				.newComparatorInstance(new Comparator<String>() {
					@Override
					public int compare(String arg0, String arg1) {
						Integer length0 = new Integer(arg0.length());
						Integer length1 = new Integer(arg1.length());
						return length0.compareTo(length1);
					}
				});

		smallestLengthWordFilter.filter("Hello");
		assertEquals("Hello", smallestLengthWordFilter.getOutput());
		smallestLengthWordFilter.filter("Insect");
		assertEquals("Hello", smallestLengthWordFilter.getOutput());
		smallestLengthWordFilter.filter("Aba");
		assertEquals("Aba", smallestLengthWordFilter.getOutput());

	}

	//Test that the reset function works.
	@Test
	public void testMinimumFilterComparatorReset() {
		MinFilter<String> smallestLengthWordFilter = MinFilter
				.newComparatorInstance(new Comparator<String>() {
					@Override
					public int compare(String arg0, String arg1) {
						Integer length0 = new Integer(arg0.length());
						Integer length1 = new Integer(arg1.length());
						return length0.compareTo(length1);
					}
				});

		smallestLengthWordFilter.filter("Hello");
		assertEquals("Hello", smallestLengthWordFilter.getOutput());
		smallestLengthWordFilter.filter("Insect");
		assertEquals("Hello", smallestLengthWordFilter.getOutput());
		smallestLengthWordFilter.filter("Aba");
		assertEquals("Aba", smallestLengthWordFilter.getOutput());
		smallestLengthWordFilter.reset("Tests");
		assertEquals("Tests", smallestLengthWordFilter.getOutput());
		smallestLengthWordFilter.filter("Hello");
		assertEquals("Tests", smallestLengthWordFilter.getOutput());
		smallestLengthWordFilter.filter("Insect");
		assertEquals("Tests", smallestLengthWordFilter.getOutput());
		smallestLengthWordFilter.filter("Abacus");
		assertEquals("Tests", smallestLengthWordFilter.getOutput());
	}

	//Test and make sure that it works with a class that does not implement comparable so long as you provide a comparator.
	@Test
	public void testMinimumFilterCustomClass() {
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
		MinFilter<TempClass> smallestTempClassFilter = MinFilter
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
		assertEquals(val2, smallestTempClassFilter.getOutput());
		smallestTempClassFilter.filter(val1);
		assertEquals(val2, smallestTempClassFilter.getOutput());
	}
}
