import Files.payload;
import io.restassured.path.json.JsonPath;

public class ComplexJsonPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
   JsonPath jsonpath=new JsonPath(payload.CoursePrice());
   //get the purchase amount
   int count=jsonpath.getInt("dashboard.purchaseAmount");
   System.out.println(count);
   
   //print number of courses
   System.out.println(jsonpath.getInt("courses.size()"));
   
   //print title of first course
   System.out.println(jsonpath.get("courses["+0+"].title"));
   
   //print title and price of all course
   for(int i=0;i<jsonpath.getInt("courses.size()");i++) {
	   System.out.println(jsonpath.get("courses["+i+"].title"));
	   System.out.println(jsonpath.get("courses["+i+"].price"));
   }
   
   //print copies of RPA
   for(int i=0;i<jsonpath.getInt("courses.size()");i++) {
	  String str=jsonpath.get("courses["+i+"].title");
	  if(str.equalsIgnoreCase("RPA")) {
		  System.out.println(jsonpath.get("courses["+i+"].copies"));
		  break;
	  }
	  
   }
	}

}
