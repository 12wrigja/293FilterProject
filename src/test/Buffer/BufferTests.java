package test.Buffer;

import static org.junit.Assert.*;

import org.junit.Test;

import main.Buffer;

public class BufferTests {
	
	@Test
	public void testAdditionOfData(){
		Buffer<Double> testBuffer = new Buffer<>(5);
		testBuffer.push(new Double(6));
		testBuffer.push(new Double(7));
		testBuffer.push(new Double(8));
		testBuffer.push(new Double(9));
		testBuffer.push(new Double(32));
		testBuffer.push(new Double(54));
		testBuffer.push(new Double(323));
		testBuffer.push(new Double(75));
	}
	
	@Test
	public void testRetrievalOfData(){
		Buffer<Double> testBuffer = new Buffer<>(5);
		testBuffer.push(new Double(6));
		testBuffer.push(new Double(7));
		testBuffer.push(new Double(8));
		testBuffer.push(new Double(9));
		
		assertEquals(new Double(9),testBuffer.get(0));
		assertEquals(new Double(8),testBuffer.get(1));
		assertEquals(new Double(7),testBuffer.get(2));
		assertEquals(new Double(6),testBuffer.get(3));
		
		testBuffer.push(new Double(32));
		assertEquals(new Double(32),testBuffer.get(0));
		assertEquals(new Double(9),testBuffer.get(1));
		assertEquals(new Double(8),testBuffer.get(2));
		assertEquals(new Double(7),testBuffer.get(3));
		assertEquals(new Double(6),testBuffer.get(4));
		
		testBuffer.push(new Double(54));
		testBuffer.push(new Double(323));
		testBuffer.push(new Double(75));
		
		assertEquals(new Double(75),testBuffer.get(0));
		assertEquals(new Double(323),testBuffer.get(1));
		assertEquals(new Double(54),testBuffer.get(2));
		assertEquals(new Double(32),testBuffer.get(3));
		assertEquals(new Double(9),testBuffer.get(4));
	}
	
	@Test
	public void testSizeDetermination(){
		Buffer<Double> testBuffer = new Buffer<>(5);
		testBuffer.push(new Double(6));
		assertEquals(1,testBuffer.size());
		testBuffer.push(new Double(7));
		assertEquals(2,testBuffer.size());
		testBuffer.push(new Double(8));
		assertEquals(3,testBuffer.size());
		testBuffer.push(new Double(9));
		assertEquals(4,testBuffer.size());
		testBuffer.push(new Double(32));
		assertEquals(5,testBuffer.size());
		testBuffer.push(new Double(54));
		assertEquals(5,testBuffer.size());
		testBuffer.pop();
		testBuffer.pop();
		testBuffer.push(new Double(323));
		assertEquals(4,testBuffer.size());
		testBuffer.pop();
		testBuffer.pop();
		assertEquals(2,testBuffer.size());
		testBuffer.push(new Double(75));
		assertEquals(3,testBuffer.size());
	}
}
