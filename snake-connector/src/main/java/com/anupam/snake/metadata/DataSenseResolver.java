package com.anupam.snake.metadata;

import java.util.ArrayList;
import java.util.List;

import org.mule.api.annotations.MetaDataKeyRetriever;
import org.mule.api.annotations.MetaDataRetriever;
import org.mule.api.annotations.components.MetaDataCategory;
import org.mule.common.metadata.DefaultMetaData;
import org.mule.common.metadata.DefaultMetaDataKey;
import org.mule.common.metadata.MetaData;
import org.mule.common.metadata.MetaDataKey;
import org.mule.common.metadata.MetaDataModel;
import org.mule.common.metadata.builder.DefaultMetaDataBuilder;
import org.mule.common.metadata.builder.PojoMetaDataBuilder;

import com.anupam.snake.model.Author;
import com.anupam.snake.model.Book;

/**
 * Category which can differentiate between input or output MetaDataRetriever
 */
@MetaDataCategory
public class DataSenseResolver {

	@MetaDataKeyRetriever
	public List<MetaDataKey> getMetaDataKeys() throws Exception {
		List<MetaDataKey> keys = new ArrayList<MetaDataKey>();

		// Generate the keys
		keys.add(new DefaultMetaDataKey("author_id", "User"));
		keys.add(new DefaultMetaDataKey("book_id", "Book"));

		return keys;
	}

	@MetaDataRetriever
	public MetaData getMetaData(MetaDataKey entityKey) throws Exception {
		DefaultMetaDataBuilder builder = new DefaultMetaDataBuilder();
		PojoMetaDataBuilder<?> pojoObject = null;

		if ("author_id".equals(entityKey.getId())) {
			pojoObject = builder.createPojo(Author.class);

		}

		else if ("book_id".equals(entityKey.getId())) {
			pojoObject = builder.createPojo(Book.class);
		} else {
			pojoObject = builder.createPojo(Author.class);
		}

		MetaDataModel model = pojoObject.build();
		MetaData metaData = new DefaultMetaData(model);

		return metaData;
	}

}
