package comlexNexstedjson;

import org.testng.Assert;
import org.testng.annotations.Test;

import files.Payloads;
import io.restassured.path.json.JsonPath;
import pojoclasses.Courses;

public class ComplexJson {
	
	@Test
	public void SumValdation() {
		
		int sum=0;
		
		
		//1. print no of course returned by Api
		
		JsonPath js= new JsonPath(Payloads.course());
		int count=js.getInt("courses.size()");
		System.out.println(count);
		
		//2.print purchase amount
		
//		int amount=js.get("dashboard.PurchaseAmount");
//		System.out.println(amount);
//
		
	//3.PRINT THE TITLE OF main course
		
		String title=js.get("courses[0].title");
		System.out.println(title);
		System.out.println(js.get("courses[0].title").toString());
		
		
		//4.print all tile and respective price
		
		for(int i=0;i<count ;i++)
		{
			System.out.println(js.get("courses["+i+"].title").toString());
			System.out.println(js.get("courses["+i+"].price").toString());
		}
		
		//
		
		for(int i=0;i<count;i++)
		{
			int price=js.get("courses["+i+"].price");
			int copies=js.get("courses["+i+"].copies");
			
			int amount= price * copies;
			System.out.println(amount);
			
			sum=sum+amount;
		}
		System.out.println(sum);
		int purchaseAmount = js.get("dashboard.purchaseAmount");
		Assert.assertEquals(sum, purchaseAmount);
		}
	
	
		
		
		
	}


