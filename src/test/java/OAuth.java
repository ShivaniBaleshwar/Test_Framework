import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class OAuth {
@Test
public static void oauth() {
	
	String accesstokenResponse=given()
		.queryParams("code","")
		.queryParams("client_id","692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
		.queryParams("client_secret","erZOWM9g3UtwNRj340YYaK_W")
		.queryParams("redirect_uri","https://rahulshettyacademy.com/getCourse.php")
		.queryParams("grant_type","authorization_code")
	.when()
		.post("https://www.googleapis.com/oauth2/v4/token")
		.asString();
	JsonPath jsonpath=new JsonPath(accesstokenResponse);
	String accesstoken=jsonpath.getString("access_token");
	
	
	given().queryParam("access_token", accesstoken)
	.get("https://rahulshettyacademy.com/getCourse.php").asString();
}
}
