import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Files.ReusableMethods;
import Files.payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
public class DynamicJson {

	
	@Test
	public static void dynamicJson() throws IOException
	{
		RestAssured.baseURI="http://216.10.245.166";
		int statusCode=given().log().all().header("Content-Type","application/json")
				.body(new String(Files.readAllBytes(Paths.get("C:\\Users\\sivani\\OneDrive\\Documents\\test-framwork\\body.json"))))
				.when().post("Library/Addbook.php").getStatusCode()
		String str=given().when().post("Library/Addbook.php").then().assertThat().statusCode(200).extract().response().asString();
		
		JsonPath js=ReusableMethods.rawToJson(str1);
		System.out.println(js.get("ID"));
		
	}
	
//	@DataProvider(name="datas")
//	public static Object[][] data() {
//		return new Object[][] {{"sadf","asdf"},{"dg","rftg"},{"tyui","fgh"},{"bhj","byuu"}};
//	}
				
}
