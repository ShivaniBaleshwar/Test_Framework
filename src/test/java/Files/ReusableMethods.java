package Files;

import io.restassured.path.json.JsonPath;

public class ReusableMethods {
	
public static JsonPath rawToJson(String Jsonresponse){
	JsonPath js=new JsonPath(Jsonresponse);
	return js;
}
}
