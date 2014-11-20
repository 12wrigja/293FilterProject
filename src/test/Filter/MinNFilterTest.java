package test.Filter;

import static org.junit.Assert.assertEquals;

import java.util.Comparator;

import main.filters.MinNFilter;

import org.junit.Test;

public class MinNFilterTest {

	// Thoroughly tests the minimum N back filter in the various configurations you can
	// use it in.

	// Filter with no comparator - uses natural ordering.
	// - Tests to see if the lexicographical ordering works
	// - Tests to see if the reset function works.

	@Test
	public void testMinimumNFilter() {
		// Test the Minimum filter's ability to work on comparable objects, sans
		// a comparator.
		MinNFilter<String> wordFilter = MinNFilter.newInstance(5);
		wordFilter.filter("lug");
		assertEquals("lug", wordFilter.getOutput());
		wordFilter.filter("pru");
		assertEquals("lug", wordFilter.getOutput());
		wordFilter.filter("ens");
		assertEquals("ens", wordFilter.getOutput());
		wordFilter.filter("pen");
		assertEquals("ens", wordFilter.getOutput());
		wordFilter.filter("hod");
		assertEquals("ens", wordFilter.getOutput());
		wordFilter.filter("ivy");
		assertEquals("ens", wordFilter.getOutput());
		wordFilter.filter("fez");
		assertEquals("ens", wordFilter.getOutput());
		wordFilter.filter("dot");
		assertEquals("dot", wordFilter.getOutput());
		wordFilter.filter("pol");
		assertEquals("dot", wordFilter.getOutput());
	}

	@Test
	public void testMinimumFilterReset() {
		MinNFilter<String> wordFilter = MinNFilter.newInstance(5);
		wordFilter.filter("fro");
		assertEquals("fro",wordFilter.getOutput());
		wordFilter.filter("huh");
		assertEquals("fro",wordFilter.getOutput());
		wordFilter.filter("lux");
		assertEquals("fro",wordFilter.getOutput());
		wordFilter.filter("bin");
		assertEquals("bin",wordFilter.getOutput());
		wordFilter.filter("tpr");
		assertEquals("bin",wordFilter.getOutput());
		wordFilter.filter("ehf");
		assertEquals("bin",wordFilter.getOutput());
		wordFilter.filter("dom");
		assertEquals("bin",wordFilter.getOutput());
		wordFilter.filter("cse");
		assertEquals("bin",wordFilter.getOutput());
		wordFilter.filter("avo");
		assertEquals("avo",wordFilter.getOutput());
		wordFilter.filter("peg");
		assertEquals("avo",wordFilter.getOutput());
		wordFilter.filter("nap");
		assertEquals("avo",wordFilter.getOutput());
		wordFilter.reset("frued");
		wordFilter.filter("wal");
		assertEquals("frued",wordFilter.getOutput());
		wordFilter.filter("sox");
		assertEquals("frued",wordFilter.getOutput());
		wordFilter.filter("mom");
		assertEquals("frued",wordFilter.getOutput());
		wordFilter.filter("ewe");
		assertEquals("ewe",wordFilter.getOutput());
		wordFilter.filter("qsl");
		assertEquals("ewe",wordFilter.getOutput());
		wordFilter.filter("ami");
		assertEquals("ami",wordFilter.getOutput());
		wordFilter.filter("sta");
		assertEquals("ami",wordFilter.getOutput());
		wordFilter.filter("nigeria");
		assertEquals("ami",wordFilter.getOutput());
		wordFilter.filter("lar");
		assertEquals("ami",wordFilter.getOutput());
	}

	//Tests with the comparator in order to make sure that is used over natural ordering.
	//Test the ability of the comparator.
	@Test
	public void testMinimumNFilterComparator() {
		MinNFilter<String> wordFilter = MinNFilter
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
		assertEquals("invocate",wordFilter.getOutput());
		wordFilter.filter("gorgonise");
		assertEquals("invocate",wordFilter.getOutput());
		wordFilter.filter("propublicity");
		assertEquals("invocate",wordFilter.getOutput());
		wordFilter.filter("nonadjudication");
		assertEquals("invocate",wordFilter.getOutput());
		wordFilter.filter("polaris");
		assertEquals("polaris",wordFilter.getOutput());
		wordFilter.filter("granulation");
		assertEquals("polaris",wordFilter.getOutput());
		wordFilter.filter("bucketful");
		assertEquals("polaris",wordFilter.getOutput());
		wordFilter.filter("caterpillar");
		assertEquals("polaris",wordFilter.getOutput());
		wordFilter.filter("anachronously");
		assertEquals("polaris",wordFilter.getOutput());
		wordFilter.filter("undeplored");
		assertEquals("bucketful",wordFilter.getOutput());
		wordFilter.filter("pholidota");
		assertEquals("bucketful",wordFilter.getOutput());
		wordFilter.filter("unameliorative");
		assertEquals("undeplored",wordFilter.getOutput());
		wordFilter.filter("associableness");
		assertEquals("undeplored",wordFilter.getOutput());
		wordFilter.filter("iodopsin");
		assertEquals("iodopsin",wordFilter.getOutput());
		wordFilter.filter("steedlike");
		assertEquals("iodopsin",wordFilter.getOutput());
		wordFilter.filter("paracasein");
		assertEquals("iodopsin",wordFilter.getOutput());
		wordFilter.filter("queenliest");
		assertEquals("iodopsin",wordFilter.getOutput());
		wordFilter.filter("rectifying");
		assertEquals("iodopsin",wordFilter.getOutput());

	}

	//Test that the reset function works.
	@Test
	public void testMinimumFilterComparatorReset() {
		MinNFilter<String> wordFilter = MinNFilter
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
		assertEquals("invocate",wordFilter.getOutput());
		wordFilter.filter("gorgonise");
		assertEquals("invocate",wordFilter.getOutput());
		wordFilter.filter("propublicity");
		assertEquals("invocate",wordFilter.getOutput());
		wordFilter.filter("nonadjudication");
		assertEquals("invocate",wordFilter.getOutput());
		wordFilter.filter("polaris");
		assertEquals("polaris",wordFilter.getOutput());
		wordFilter.filter("granulation");
		assertEquals("polaris",wordFilter.getOutput());
		wordFilter.filter("bucketful");
		wordFilter.reset("Boo");
		assertEquals("Boo",wordFilter.getOutput());
		wordFilter.filter("caterpillar");
		assertEquals("Boo",wordFilter.getOutput());
		wordFilter.filter("anachronously");
		assertEquals("Boo",wordFilter.getOutput());
		wordFilter.filter("undeplored");
		assertEquals("Boo",wordFilter.getOutput());
		wordFilter.filter("pholidota");
		assertEquals("Boo",wordFilter.getOutput());
		wordFilter.filter("unameliorative");
		assertEquals("pholidota",wordFilter.getOutput());
		wordFilter.filter("associableness");
		assertEquals("pholidota",wordFilter.getOutput());
		wordFilter.filter("iodopsin");
		assertEquals("iodopsin",wordFilter.getOutput());
		wordFilter.filter("steedlike");
		assertEquals("iodopsin",wordFilter.getOutput());
		wordFilter.filter("paracasein");
		assertEquals("iodopsin",wordFilter.getOutput());
		wordFilter.filter("queenliest");
		assertEquals("iodopsin",wordFilter.getOutput());
		wordFilter.filter("rectifying");
		assertEquals("iodopsin",wordFilter.getOutput());
		
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
