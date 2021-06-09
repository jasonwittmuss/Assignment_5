package com.ss.jb.five.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.ss.jb.five.Assignment_5_2.Assignment_5_2_1;
import com.ss.jb.five.Assignment_5_2.Functional;
import com.ss.jb.five.Assignment_5_2.SampleSingleton;

class FunctionalTest {

	@Test
	void test() {
		Functional func = new Functional();
		
		String[] args = {
				"6",
				"1", "4",
				"2", "5",
				"3", "898",
				"1", "3",
				"2", "12",
				"3", "1234"};
		
		String[] args2 = {};
		
		Assignment_5_2_1 assign = new Assignment_5_2_1(args);
		Assignment_5_2_1 assign2 = new Assignment_5_2_1(null);
		Assignment_5_2_1 assign3 = new Assignment_5_2_1(args2);
		
		args[0] = "2";
		
		Assignment_5_2_1 assign4 = new Assignment_5_2_1(args);
		
		args[0] = "6";
		args[1] = "4";
		
		Assignment_5_2_1 assign5 = new Assignment_5_2_1(args);
		
		SampleSingleton single = SampleSingleton.getInstance();
		SampleSingleton single2 = SampleSingleton.getInstance();
		
	}

}
