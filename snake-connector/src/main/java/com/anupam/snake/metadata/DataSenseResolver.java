package com.anupam.snake.metadata;

import java.util.ArrayList;
import java.util.List;

import org.mule.api.annotations.MetaDataKeyRetriever;
import org.mule.api.annotations.MetaDataRetriever;
import org.mule.api.annotations.components.MetaDataCategory;
import org.mule.common.metadata.DefaultListMetaDataModel;
import org.mule.common.metadata.DefaultMetaData;
import org.mule.common.metadata.DefaultMetaDataKey;
import org.mule.common.metadata.MetaData;
import org.mule.common.metadata.MetaDataKey;
import org.mule.common.metadata.MetaDataModel;
import org.mule.common.metadata.builder.DefaultMetaDataBuilder;

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
		keys.add(new DefaultMetaDataKey("author_id", "Author"));
		keys.add(new DefaultMetaDataKey("book_id", "Book"));
		keys.add(new DefaultMetaDataKey("book_list_id", "List Book"));
		return keys;
	}

	@MetaDataRetriever
	public MetaData getMetaData(MetaDataKey entityKey) throws Exception {
		if ("author_id".equals(entityKey.getId())) {
			MetaDataModel authorModel = new DefaultMetaDataBuilder().createPojo(Author.class).build();
			return new DefaultMetaData(authorModel);
		} else if ("book_id".equals(entityKey.getId())) {
			MetaDataModel bookModel = new DefaultMetaDataBuilder().createPojo(Book.class).build();
			return new DefaultMetaData(bookModel);
		} else if ("book_list_id".equals(entityKey.getId())) {
//			MetaDataModel bookListModel = new DefaultMetaDataBuilder().createList().ofPojo(Book.class).build();
			MetaDataModel mm = new DefaultMetaDataBuilder().createPojo(Book.class).build();
			DefaultListMetaDataModel listModel = new DefaultListMetaDataModel(mm);
			return new DefaultMetaData(listModel);
		} else {
			MetaDataModel defaultModel = new DefaultMetaDataBuilder().createPojo(String.class).build();
			return new DefaultMetaData(defaultModel);
		}
	}

}
