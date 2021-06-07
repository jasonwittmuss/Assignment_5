package com.ss.jb.five.Assignment_5_2;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SampleSingleton {

	private static Connection conn = null;

	private static SampleSingleton instance = null;

	private SampleSingleton() {
	}

	// Added synchronized keyword and checks if instance is null, assigning a new
	// instance if it is, otherwise return the instance
	public static synchronized SampleSingleton getInstance() {
		if (instance == null) {
			instance = new SampleSingleton();
		}
		return instance;
	}

}
