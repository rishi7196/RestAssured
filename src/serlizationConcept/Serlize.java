package serlizationConcept;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import pojoclasses.AddPlace;
import pojoclasses.Location;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;



public class Serlize {
	public static void main(String[] args) {
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		
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
		
	
		String res=given().queryParam("key", "qaclick")
		.body(p)
		.when().post("/maps/api/place/add/json")
		.then().assertThat().statusCode(200).extract().response().asString();
		System.out.println(res);
		
		JsonPath js= new JsonPath(res);
		String paceID=js.get("place_id");
		System.out.println(paceID);
		
		
	}

}
