import org.mule.api.annotations.display.Summary;
import org.springframework.web.client.RestTemplate;

public class Test {

	public static void main(String[] a) {
		new Test().getPosts("ID,title");

	}

	public void getPosts(String field) {
		RestTemplate template = new RestTemplate();

		String url = "https://public-api.wordpress.com/rest/v1.1/sites/";
		url = url.concat("gocodeblog.wordpress.com").concat("/posts?fields=").concat(field);
		String result = template.getForObject(url, String.class);
		System.out.print(result);
	}
}
