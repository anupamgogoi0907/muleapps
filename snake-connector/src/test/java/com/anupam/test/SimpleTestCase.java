package com.anupam.test;

import org.mule.tools.devkit.ctf.junit.AbstractTestCase;

import com.anupam.snake.connector.SnakeConnector;
import com.anupam.snake.model.Book;

/**
 * Created by ac-agogoi on 2/23/17.
 */
public class SimpleTestCase extends AbstractTestCase<SnakeConnector> {

	public SimpleTestCase() {
		super(SnakeConnector.class);
	}

	@org.junit.Test
	public void test() {
		SnakeConnector snakeConnector = getConnector();
		Object res = snakeConnector.getByType("Book", null);
		org.junit.Assert.assertTrue(res instanceof Book);
	}
}
