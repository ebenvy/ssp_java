package HttpServerClient;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.client.api.ContentResponse;
import org.eclipse.jetty.client.api.Request;
import org.eclipse.jetty.http.HttpMethod;

public class MyHttpClient {

	private HttpClient client;
	public MyHttpClient() {
		this.client = new HttpClient();
		try {
			this.client.start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public ContentResponse sendRequest(String url, String method, HashMap<Object, Object> headers, String body) {
		
		ContentResponse contentRes;
		HttpMethod httpMethod = HttpMethod.fromString(method);
		Request request = client.newRequest(url).method(httpMethod);
		try {
			//setting header
			for(Entry<Object,Object> o:headers.entrySet()){
				request.header(o.getKey().toString(), o.getValue().toString());
			}
			
			contentRes= request.send();
			return contentRes;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
}
