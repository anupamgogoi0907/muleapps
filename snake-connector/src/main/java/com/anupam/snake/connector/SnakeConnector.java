package com.anupam.snake.connector;

import java.util.ArrayList;
import java.util.List;

import org.mule.api.annotations.Config;
import org.mule.api.annotations.Connector;
import org.mule.api.annotations.MetaDataScope;
import org.mule.api.annotations.Processor;
import org.mule.api.annotations.lifecycle.Start;
import org.mule.api.annotations.param.Default;
import org.mule.api.annotations.param.MetaDataKeyParam;
import org.mule.api.annotations.param.MetaDataKeyParamAffectsType;
import org.mule.api.annotations.param.MetaDataStaticKey;

import com.anupam.snake.config.ConnectorConfig;
import com.anupam.snake.metadata.DataSenseResolver;
import com.anupam.snake.model.Book;

@Connector(name = "snake", friendlyName = "Snake")
@MetaDataScope(DataSenseResolver.class)
public class SnakeConnector {

	@Config
	ConnectorConfig config;

	@Start
	public void init() {

	}

	@Processor
	public Object addEntity(@MetaDataKeyParam(affects = MetaDataKeyParamAffectsType.BOTH) String key,
			@Default("#[payload]") Object entityData) {
		Book book = new Book();
		book.setBookTitle("Java");
		book.setIsbn("B1234");
		return book;
	}

	@Processor
	@MetaDataStaticKey(type = "book_list_id")
	public Object test(@Default("#[payload]") String bookTitle) {
		List<Book> list = new ArrayList<>();
		list.add(new Book(bookTitle, "ISBN-1234"));
		list.add(new Book(bookTitle, "ISBN-3333"));
		list.add(new Book(bookTitle, "ISBN-4454"));
		return list;
	}

	public ConnectorConfig getConfig() {
		return config;
	}

	public void setConfig(ConnectorConfig config) {
		this.config = config;
	}

}