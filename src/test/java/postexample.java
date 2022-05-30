import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

import Files.ReusableMethods;
import Files.payload;
public class postexample {

	public static void main(String[] args) {
		RestAssured.baseURI="https://rahulshettyacademy.com/";
		String actualaddress="70 Summer walk, USA";
		//Create a new address
		String jsonresponse=given().log().all().queryParam("key", "qaclick123").header(

				
				)
		.body(payload.bodyPOST())
		.when().post("maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200)
		.body("scope", equalTo("APP"))
		.header("Server","Apache/2.4.41 (Ubuntu)").extract().response().asString();
		
		System.out.println(jsonresponse);
		
		JsonPath js=new JsonPath(jsonresponse);
		String place=js.getString("place_id");
		
		//Update the address
		given().log().all().queryParam("place_id", place).queryParam("key","qaclick123")
		.body("{\r\n"
				+ "\"place_id\":\""+place+"\",\r\n"
				+ "\"address\":\"70 Summer walk, USA\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n"
				+ "}\r\n"
				+ "")
		.when().put("maps/api/place/update/json")
		.then().log().all().assertThat().statusCode(200)
		.body("msg", equalTo("Address successfully updated"));
		
		//get the updated address
		String getResponse=given().log().all().queryParam("place_id", place).queryParam("key", "qaclick123")
		.when().get("maps/api/place/get/json")
		.then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		System.out.println("Get executed successfully");
		
		String str=ReusableMethods.rawToJson(getResponse).getString("address");
		System.out.println(str);
		Assert.assertEquals(str, actualaddress);
	}

}
