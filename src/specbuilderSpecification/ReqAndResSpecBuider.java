package specbuilderSpecification;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojoclasses.AddPlace;
import pojoclasses.Location;

public class ReqAndResSpecBuider {
	public static void main(String[] args) {
		
  //RestAssured.baseURI="https://rahulshettyacademy.com";
		
		AddPlace p= new AddPlace();
		p.setAccuracy(50);
		p.setAddress("29, side layout, cohen 09");
		p.setLanguage("French-IN");
		p.setName("Frontline house");
		p.setPhone_number("(+91) 983 893 3937");
		p.setWebsite("http://google.com");
		
		
		Location l= new Location();
		p.setLocation(l);
		l.setLat(-38.383494);
		l.setLng(-33.427362);
		
		List<String> myList= new ArrayList<String>();		
		p.setTypes(myList);
		myList.add("shoe park");
		myList.add("shop");
		
		RequestSpecification req=new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addQueryParam("key", "qaclick123").setContentType(ContentType.JSON).build();
		
		ResponseSpecification responseSpec=new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
	
		RequestSpecification res=given().spec(req)
		.body(p);
		String response=res.when().post("/maps/api/place/add/json")
		.then().spec(responseSpec).extract().asString();
		System.out.println(response);
		
		JsonPath js= new JsonPath(response);
		String paceID=js.get("place_id");
		System.out.println(paceID);
		
		
		
		
	}

}
