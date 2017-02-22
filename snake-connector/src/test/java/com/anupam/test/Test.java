package com.anupam.test;

import com.anupam.snake.connector.SnakeConnector;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.mule.common.Result;
import org.mule.common.metadata.MetaData;
import org.mule.common.metadata.MetaDataKey;
import org.mule.tools.devkit.ctf.mockup.ConnectorDispatcher;
import org.mule.tools.devkit.ctf.mockup.ConnectorTestContext;
import org.mule.util.scan.annotations.Meta;

import java.util.List;

/**
 * Created by ac-agogoi on 2/21/17.
 */
public class Test {

    @BeforeClass
    public static void setUp()
    {
        ConnectorTestContext.initialize(SnakeConnector.class);
    }

    @org.junit.Test
    public void test()
    {

        ConnectorDispatcher<SnakeConnector> dispatcher=getDispatcher();
        Result<List<MetaDataKey>> keys=dispatcher.fetchMetaDataKeys();
        List<MetaDataKey> listKeys=keys.get();

        MetaDataKey key_posts=listKeys.get(3);
        Result<MetaData> metaDataResult=dispatcher.fetchMetaData(key_posts);
        System.out.print("");
    }

    public ConnectorDispatcher<SnakeConnector> getDispatcher()
    {
        ConnectorTestContext<SnakeConnector> context=ConnectorTestContext.getInstance();
        ConnectorDispatcher<SnakeConnector> dispatcher=context.getConnectorDispatcher();
        return dispatcher;
    }


    @AfterClass
    public static void shutdownSuite() throws Exception{

        ConnectorTestContext.shutDown();
    }
}
