package com.amith;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.amith.processor.british.BritishTimeProcessor;
import com.amith.utils.Time;

public class BritishTimeProcessorTest {
	
	
	    private final BritishTimeProcessor converter = new BritishTimeProcessor();

	    @Test
	    public void converts_00_00_to_midnight() {
	    	Time time = new Time(00,00);
	        assertEquals("midnight", converter.convert(time));
	    }

	    @Test
	    public void converts_12_00_to_noon() {
	    	Time time = new Time(12,00);
	        assertEquals("noon", converter.convert(time));
	    }

	    @Test
	    public void converts_01_00_to_one_o_clock() {
	    	Time time = new Time(01,00);
	        assertEquals("one o'clock", converter.convert(time));
	    }

	    @Test
	    public void converts_02_05_to_five_past_two() {
	    	Time time = new Time(2,05);
	        assertEquals("five past two", converter.convert(time));
	    }

	    @Test
	    public void converts_03_10_to_ten_past_three() {
	    	Time time = new Time(3,10);
	        assertEquals("ten past three", converter.convert(time));
	    }
}
