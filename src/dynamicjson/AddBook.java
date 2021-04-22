package dynamicjson;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import files.Payloads;
import files.ResusableMethods;

public class AddBook {
	@Test(dataProvider="BookData")
	public  void Add(String isbn, String aisle) {	
		
		
		RestAssured.baseURI="http://216.10.245.166";
		
		String response=given().log().all().queryParam("Key", "qaclick123").header("content-type","application/json")
		.body(Payloads.Addbook(isbn, aisle))
		.when().post("Library/Addbook.php")
		.then().log().all().assertThat().statusCode(200).extract().response().asString()	;	
		JsonPath js=ResusableMethods.rawToJson(response);
		String id=js.get("ID");
		System.out.println(id);
	}
	
	@DataProvider(name="BookData")
public Object[][] getdata()
{
      return new Object[][] {{"abcdf","89466"},{"hdksuhd","6302"},{"hykjh","88999"}};
}
}



