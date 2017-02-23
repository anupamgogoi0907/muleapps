package com.anupam.test;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.mule.common.Result;
import org.mule.common.metadata.MetaData;
import org.mule.common.metadata.MetaDataKey;
import org.mule.common.metadata.datatype.DataType;
import org.mule.tools.devkit.ctf.mockup.ConnectorDispatcher;
import org.mule.tools.devkit.ctf.mockup.ConnectorTestContext;

import com.anupam.snake.connector.SnakeConnector;

/**
 * Created by ac-agogoi on 2/21/17.
 */
public class Test {

	@BeforeClass
	public static void setUp() {
		ConnectorTestContext.initialize(SnakeConnector.class);
	}

	@org.junit.Test
	public void test() {

		ConnectorDispatcher<SnakeConnector> dispatcher = getDispatcher();
		Result<List<MetaDataKey>> keys = dispatcher.fetchMetaDataKeys();
		List<MetaDataKey> listKeys = keys.get();
		
		// Test MetaDataKey.
		MetaDataKey key_book_list = listKeys.get(2);
		Assert.assertTrue(key_book_list.getId().equals("book_list_id"));
		
		// Test MetaData.
		Result<MetaData> metaDataResult = dispatcher.fetchMetaData(key_book_list);
		MetaData metadata_book_list=metaDataResult.get();
		
		Assert.assertTrue(metadata_book_list.getPayload().getDataType().equals(DataType.LIST));
	}

	public ConnectorDispatcher<SnakeConnector> getDispatcher() {
		ConnectorTestContext<SnakeConnector> context = ConnectorTestContext.getInstance();
		ConnectorDispatcher<SnakeConnector> dispatcher = context.getConnectorDispatcher();
		return dispatcher;
	}

	@AfterClass
	public static void shutdownSuite() throws Exception {

		ConnectorTestContext.shutDown();
	}
}
