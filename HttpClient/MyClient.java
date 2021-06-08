package dap;
import org.eclipse.jetty.client.HttpClient;

import org.eclipse.jetty.client.api.ContentResponse;
import org.eclipse.jetty.http.HttpMethod;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.JsonObject;
import com.google.gson.JsonNull;
import com.google.gson.JsonArray;
import com.google.gson.JsonPrimitive;
public class MyClient {
	

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		HttpClient httpClient = new HttpClient();
		httpClient.start();
		ContentResponse contentRes = httpClient.newRequest("http://127.0.0.1:8081/mypath").method(HttpMethod.GET).send();
		System.out.println(contentRes.getContentAsString());
	    String json =
	            "{" +
	                    "    strKey : strValue, " +
	                    "    numKey: 235.3, " +
	                    "    arrKey: [arrV1, arrV2, arrV3]," +
	                    "    objKey: {subKey: subValue}," +
	                    "    numArrKey: [100, 200, 300]," +
	                    "    nullKey: null" +
	                    "}";
		JsonElement jsonElement = JsonParser.parseString(json);
		printJson(jsonElement);
	}
	public static void printJson(JsonElement jsonElement) {
		
		if (jsonElement.isJsonPrimitive()) {
	        JsonPrimitive primitive = jsonElement.getAsJsonPrimitive();

	        System.out.println(primitive.isNumber());
	        System.out.println(primitive.isString());
	        System.out.println(primitive.toString());
	        
	        // logic for JsonPrimitive
	    } else if (jsonElement.isJsonArray()) {
	        JsonArray array = jsonElement.getAsJsonArray();
	        for(JsonElement el: array) {
	        	System.out.println(el.toString());
	        }
	        // logic for JsonArray
	    } else if (jsonElement.isJsonObject()) {
	        JsonObject object = jsonElement.getAsJsonObject();
	    
	        System.out.println(object.toString());
	        for(String key: object.keySet()) {
	        	printJson(object.get(key));
	        }
	        // logic for JsonObject
	    } else if (jsonElement.isJsonNull()) {
	        JsonNull jsonNull = jsonElement.getAsJsonNull();
	        // logic for JsonNull
	    }
	}
	 
	

}
