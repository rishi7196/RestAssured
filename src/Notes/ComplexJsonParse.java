package Notes;

import files.Payloads;
import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {
	
	public static void main(String[] args) {
		
		JsonPath js= new JsonPath(Payloads.coursePrice());
		
		//Print the no of course returned by Api
		
		int count=js.getInt("courses.size()");
		System.out.println(count);
		//2. Print Purchase Amount
		
//		int totalAmount=js.getInt("dashboard.purchaseAmount");
//		System.out.println(totalAmount);
//		
		//3. Print title of the first course
		String titleoffirst=js.get("courses[1].title");
		System.out.println(titleoffirst);
		
		//4. Print all courses title and their respective prices
		for(int i=0;i<count;i++) {
		String AllTitle=js.get("courses["+i+"].title");
		System.out.println(AllTitle);
		System.out.println(js.get("courses["+i+"].price").toString());
		System.out.println(js.get("courses["+i+"].copies").toString());
		}
		
		//. Print no of copies sold by RPA courses
		
		System.out.println(" Print no of copies sold by RPA courses");
		for(int i=0;i<count;i++)
		{
			String Coursestitle=js.get("courses["+i+"].title");
			if(Coursestitle.equalsIgnoreCase("RPA"))
			{
				int copies=js.get("courses["+i+"].copies");
				System.out.println(copies);
				break;
			
		}
		
		
		
		}
	}
}