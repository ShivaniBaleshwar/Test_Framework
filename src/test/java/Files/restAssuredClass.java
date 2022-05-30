package Files;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class restAssuredClass {
@Test(enabled=false)
public static void getRequestTest1() {
	Response response=get("https://reqres.in/api/users?page=2");
//	System.out.println(response.getStatusCode());
//	System.out.println(response.getBody().asString());
//	System.out.println(response.getStatusLine());
//	System.out.println(response.getTimeIn(TimeUnit.MILLISECONDS));
}
@Test(enabled=false)
public static void getRequestTest2() {
	given()
	   .get("https://reqres.in/api/users?page=2")
	   .then().log().all().body("data.id[1]",equalTo(8))
	   .body("data.first_name",hasItems("Michael","Tobias"));
}

@Test(enabled=false)
public static void postRequest() {
//	Map<String, Object> mp=new HashMap<String,Object>();
//	mp.put("name","morpheus");
//	mp.put("job", "leader");
//	System.out.println(mp);
	
//	JSONObject bodyreq=new JSONObject(mp);
//	System.out.println(bodyreq.toJSONString());
	
	JSONObject postreqbody=new JSONObject();
	postreqbody.put("name","morpheus");
	postreqbody.put("job", "leader");
	
	given().body(postreqbody.toJSONString())
	.when().post("https://reqres.in/api/users")
	.then().log().all().statusCode(201).assertThat().statusCode(201);
}
@Test
public static void putRequest() {
	JSONObject putreqbody=new JSONObject();
	putreqbody.put("name", "morpheus");
	putreqbody.put("job", "zion resident");
	
	given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(putreqbody.toJSONString())
	.when().put("https://reqres.in/api/users/2")
	.then().log().all().assertThat().statusCode(200);
}
}
