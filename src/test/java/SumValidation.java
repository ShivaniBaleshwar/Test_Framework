import org.testng.Assert;
import org.testng.annotations.Test;

import Files.payload;
import io.restassured.path.json.JsonPath;

public class SumValidation {
 static int sum=0;
	@Test
	public static void sumCal() {
		//comments
		 JsonPath jsonpath=new JsonPath(payload.CoursePrice());
		 int count=jsonpath.getInt("courses.size())");
		 for(int i=0;i<count;i++) {
			 int prices=jsonpath.getInt("courses["+i+"].price");
			 int copies=jsonpath.getInt("courses["+i+"].copies");
			 int amount=prices*copies;
			 sum =sum +amount;
		 }
		 System.out.println(sum);
		 int purchaseAmount=jsonpath.getInt("dashboard.purchaseAmount");
		 Assert.assertEquals(sum, purchaseAmount);
	}
}
