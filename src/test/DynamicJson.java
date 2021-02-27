package test;

import org.testng.annotations.Test;

import files.Payloads;
import files.ResusableMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public class DynamicJson {
	
	
	@Test
	public void Addbook()
	{
		
		RestAssured.baseURI="http://216.10.245.166";
		
		String response=given().log().all().header("Content-Type","application/json").body(Payloads.Addbook())
		.when().post("Library/Addbook.php")
		.then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		System.out.println(response);
		
//		JsonPath js=ResusableMethods.rawToJson(response);
//		String id=js.get("ID");
//		System.out.println(id);
//		
		
	}

}