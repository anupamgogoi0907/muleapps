import java.io.IOException;

import org.springframework.web.client.RestTemplate;

import com.anupam.snake.model.Post;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Test {
	static String params = "ID,title,URL,author";

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		RestTemplate template = new RestTemplate();

		String url = "https://public-api.wordpress.com/rest/v1.1/sites/gocodeblog.wordpress.com/posts?firlds=" + params;

		String result = template.getForObject(url, String.class);

		ObjectMapper mapper = new ObjectMapper();
		Post post = mapper.readValue(result, Post.class);
		System.out.println(result);

	}

}
