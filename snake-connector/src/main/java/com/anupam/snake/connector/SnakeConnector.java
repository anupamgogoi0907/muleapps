package com.anupam.snake.connector;

import org.mule.api.annotations.Config;
import org.mule.api.annotations.Connector;
import org.mule.api.annotations.MetaDataScope;
import org.mule.api.annotations.Processor;
import org.mule.api.annotations.lifecycle.Start;
import org.mule.api.annotations.param.Default;
import org.mule.api.annotations.param.MetaDataKeyParam;
import org.mule.api.annotations.param.MetaDataKeyParamAffectsType;
import org.mule.api.annotations.param.MetaDataStaticKey;
import org.springframework.web.client.RestTemplate;

import com.anupam.snake.config.ConnectorConfig;
import com.anupam.snake.metadata.DataSenseResolver;
import com.anupam.snake.model.Book;
import com.anupam.snake.model.Post;
import com.fasterxml.jackson.databind.ObjectMapper;

@Connector(name = "snake", friendlyName = "Snake")
@MetaDataScope(DataSenseResolver.class)
public class SnakeConnector {

	@Config
	ConnectorConfig config;

	private String params;

	@Start
	public void init() {
		params = "ID,title,URL,author";
	}

	@Processor
	@MetaDataStaticKey(type = "posts_id")
	public Object getPosts() throws Exception {
		RestTemplate template = new RestTemplate();

		String url = "https://public-api.wordpress.com/rest/v1.1/sites/";
		url = url.concat("/posts?fields=").concat(params);
		String result = template.getForObject(url, String.class);

		ObjectMapper mapper = new ObjectMapper();
		Post post = mapper.readValue(result, Post.class);
		return post.getPosts();
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
	@MetaDataStaticKey(type = "author_id")
	public Object test(@Default("#[payload]") String bookTitle) {
		Book out = new Book();
		out.setBookTitle(bookTitle);
		out.setIsbn("ISBN-1221");
		return out;
	}

	public ConnectorConfig getConfig() {
		return config;
	}

	public void setConfig(ConnectorConfig config) {
		this.config = config;
	}

}