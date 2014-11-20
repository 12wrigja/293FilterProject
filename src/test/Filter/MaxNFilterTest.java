package test.Filter;

import static org.junit.Assert.assertEquals;

import java.util.Comparator;

import main.filters.MaxNFilter;
import main.filters.MinNFilter;

import org.junit.Test;

public class MaxNFilterTest {

	// Thoroughly tests the minimum N back filter in the various configurations you can
	// use it in.

	// Filter with no comparator - uses natural ordering.
	// - Tests to see if the lexicographical ordering works
	// - Tests to see if the reset function works.

	@Test
	public void testMaximumNFilter() {
		// Test the Minimum filter's ability to work on comparable objects, sans
		// a comparator.
		MaxNFilter<String> wordFilter = MaxNFilter.newInstance(5);
		wordFilter.filter("lug");
		assertEquals("lug", wordFilter.getOutput());
		wordFilter.filter("pru");
		assertEquals("pru", wordFilter.getOutput());
		wordFilter.filter("ens");
		assertEquals("pru", wordFilter.getOutput());
		wordFilter.filter("pen");
		assertEquals("pru", wordFilter.getOutput());
		wordFilter.filter("hod");
		assertEquals("pru", wordFilter.getOutput());
		wordFilter.filter("ivy");
		assertEquals("pru", wordFilter.getOutput());
		wordFilter.filter("fez");
		assertEquals("pen", wordFilter.getOutput());
		wordFilter.filter("dot");
		assertEquals("pen", wordFilter.getOutput());
		wordFilter.filter("pol");
		assertEquals("pol", wordFilter.getOutput());
	}

	@Test
	public void testMaximumFilterReset() {
		MaxNFilter<String> wordFilter = MaxNFilter.newInstance(5);
		wordFilter.filter("fro");
		assertEquals("fro",wordFilter.getOutput());
		wordFilter.filter("huh");
		assertEquals("huh",wordFilter.getOutput());
		wordFilter.filter("lux");
		assertEquals("lux",wordFilter.getOutput());
		wordFilter.filter("bin");
		assertEquals("lux",wordFilter.getOutput());
		wordFilter.filter("tpr");
		assertEquals("tpr",wordFilter.getOutput());
		wordFilter.filter("ehf");
		assertEquals("tpr",wordFilter.getOutput());
		wordFilter.filter("dom");
		assertEquals("tpr",wordFilter.getOutput());
		wordFilter.filter("cse");
		assertEquals("tpr",wordFilter.getOutput());
		wordFilter.filter("avo");
		assertEquals("tpr",wordFilter.getOutput());
		wordFilter.filter("peg");
		assertEquals("peg",wordFilter.getOutput());
		wordFilter.filter("nap");
		assertEquals("peg",wordFilter.getOutput());
		wordFilter.reset("frued");
		wordFilter.filter("wal");
		assertEquals("wal",wordFilter.getOutput());
		wordFilter.filter("sox");
		assertEquals("wal",wordFilter.getOutput());
		wordFilter.filter("mom");
		assertEquals("wal",wordFilter.getOutput());
		wordFilter.filter("ewe");
		assertEquals("wal",wordFilter.getOutput());
		wordFilter.filter("qsl");
		assertEquals("wal",wordFilter.getOutput());
		wordFilter.filter("ami");
		assertEquals("sox",wordFilter.getOutput());
		wordFilter.filter("sta");
		assertEquals("sta",wordFilter.getOutput());
		wordFilter.filter("nigeria");
		assertEquals("sta",wordFilter.getOutput());
		wordFilter.filter("lar");
		assertEquals("sta",wordFilter.getOutput());
	}

	//Tests with the comparator in order to make sure that is used over natural ordering.
	//Test the ability of the comparator.
	@Test
	public void testMaximumNFilterComparator() {
		MaxNFilter<String> wordFilter = MaxNFilter
				.newComparatorInstance(5,new Comparator<String>() {
					@Override
					public int compare(String arg0, String arg1) {
						Integer length0 = new Integer(arg0.length());
						Integer length1 = new Integer(arg1.length());
						return length0.compareTo(length1);
					}
				});

		wordFilter.filter("deliberately");
		assertEquals("deliberately",wordFilter.getOutput());
		wordFilter.filter("thioarsenite");
		assertEquals("deliberately",wordFilter.getOutput());
		wordFilter.filter("invocate");
		assertEquals("deliberately",wordFilter.getOutput());
		wordFilter.filter("gorgonise");
		assertEquals("deliberately",wordFilter.getOutput());
		wordFilter.filter("propublicity");
		assertEquals("deliberately",wordFilter.getOutput());
		wordFilter.filter("nonadjudication");
		assertEquals("nonadjudication",wordFilter.getOutput());
		wordFilter.filter("polaris");
		assertEquals("nonadjudication",wordFilter.getOutput());
		wordFilter.filter("granulation");
		assertEquals("nonadjudication",wordFilter.getOutput());
		wordFilter.filter("bucketful");
		assertEquals("nonadjudication",wordFilter.getOutput());
		wordFilter.filter("caterpillar");
		assertEquals("nonadjudication",wordFilter.getOutput());
		wordFilter.filter("anachronously");
		assertEquals("anachronously",wordFilter.getOutput());
		wordFilter.filter("undeplored");
		assertEquals("anachronously",wordFilter.getOutput());
		wordFilter.filter("pholidota");
		assertEquals("anachronously",wordFilter.getOutput());
		wordFilter.filter("unameliorative");
		assertEquals("unameliorative",wordFilter.getOutput());
		wordFilter.filter("associableness");
		assertEquals("unameliorative",wordFilter.getOutput());
		wordFilter.filter("iodopsin");
		assertEquals("unameliorative",wordFilter.getOutput());
		wordFilter.filter("steedlike");
		assertEquals("unameliorative",wordFilter.getOutput());
		wordFilter.filter("paracasein");
		assertEquals("unameliorative",wordFilter.getOutput());
		wordFilter.filter("queenliest");
		assertEquals("paracasein",wordFilter.getOutput());
		wordFilter.filter("rectifying");
		assertEquals("paracasein",wordFilter.getOutput());

	}

	//Test that the reset function works.
	@Test
	public void testMaximumFilterComparatorReset() {
		MaxNFilter<String> wordFilter = MaxNFilter
				.newComparatorInstance(5,new Comparator<String>() {
					@Override
					public int compare(String arg0, String arg1) {
						Integer length0 = new Integer(arg0.length());
						Integer length1 = new Integer(arg1.length());
						return length0.compareTo(length1);
					}
				});

		wordFilter.filter("deliberately");
		assertEquals("deliberately",wordFilter.getOutput());
		wordFilter.filter("thioarsenite");
		assertEquals("deliberately",wordFilter.getOutput());
		wordFilter.filter("invocate");
		assertEquals("deliberately",wordFilter.getOutput());
		wordFilter.filter("gorgonise");
		assertEquals("deliberately",wordFilter.getOutput());
		wordFilter.filter("propublicity");
		assertEquals("deliberately",wordFilter.getOutput());
		wordFilter.filter("nonadjudication");
		assertEquals("nonadjudication",wordFilter.getOutput());
		wordFilter.filter("polaris");
		assertEquals("nonadjudication",wordFilter.getOutput());
		wordFilter.filter("granulation");
		assertEquals("nonadjudication",wordFilter.getOutput());
		wordFilter.filter("bucketful");
		assertEquals("nonadjudication",wordFilter.getOutput());
		wordFilter.reset("Boo");
		assertEquals("Boo",wordFilter.getOutput());
		wordFilter.filter("caterpillar");
		assertEquals("caterpillar",wordFilter.getOutput());
		wordFilter.filter("anachronously");
		assertEquals("anachronously",wordFilter.getOutput());
		wordFilter.filter("undeplored");
		assertEquals("anachronously",wordFilter.getOutput());
		wordFilter.filter("pholidota");
		assertEquals("anachronously",wordFilter.getOutput());
		wordFilter.filter("unameliorative");
		assertEquals("unameliorative",wordFilter.getOutput());
		wordFilter.filter("associableness");
		assertEquals("unameliorative",wordFilter.getOutput());
		wordFilter.filter("iodopsin");
		assertEquals("unameliorative",wordFilter.getOutput());
		wordFilter.filter("steedlike");
		assertEquals("unameliorative",wordFilter.getOutput());
		wordFilter.filter("paracasein");
		assertEquals("unameliorative",wordFilter.getOutput());
		wordFilter.filter("queenliest");
		assertEquals("paracasein",wordFilter.getOutput());
		wordFilter.filter("rectifying");
		assertEquals("paracasein",wordFilter.getOutput());
		
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
		TempClass val3 = new TempClass(70);
		TempClass val5 = new TempClass(25);
		TempClass val6 = new TempClass(500);
		TempClass val7 = new TempClass(334);
		TempClass val8 = new TempClass(32459);
		MinNFilter<TempClass> smallestTempClassFilter = MinNFilter
				.newComparatorInstance(3,new Comparator<TempClass>() {

					@Override
					public int compare(TempClass arg0, TempClass arg1) {
						return ((Integer) arg0.getA())
								.compareTo(((Integer) arg1.getA()));
					}
				});
		
		smallestTempClassFilter.filter(val1);
		assertEquals(val1,smallestTempClassFilter.getOutput());
		
		smallestTempClassFilter.filter(val2);
		assertEquals(val2,smallestTempClassFilter.getOutput());
		
		smallestTempClassFilter.filter(val3);
		assertEquals(val2,smallestTempClassFilter.getOutput());
		
		smallestTempClassFilter.filter(val5);
		assertEquals(val5,smallestTempClassFilter.getOutput());
		
		smallestTempClassFilter.filter(val6);
		assertEquals(val5,smallestTempClassFilter.getOutput());
		
		smallestTempClassFilter.filter(val7);
		assertEquals(val5,smallestTempClassFilter.getOutput());
		
		smallestTempClassFilter.filter(val8);
		assertEquals(val7,smallestTempClassFilter.getOutput());
		
	}
}
