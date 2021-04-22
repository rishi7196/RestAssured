package test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.Assert;

import files.Payloads;
import files.ResusableMethods;


public class StaticJson {
	public static void main(String[] args) throws IOException {
		
		//validate if add place Api is working as expected
		//Rest Assured based on three principle
		//given -- All input details 
		//when submit All Api like resource or http method
		//then -- validate the response
		//ctrl+shift+f
		//content of the file to string--> content of file can convert in to
		// byte-->byte data to string 

		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String response = given().log().all().queryParam("key", "qaclick123").header("Content-type", "application/json")
				.body(new String(Files.readAllBytes(Paths.get("E:\\addplace.json")))).when().post("maps/api/place/add/json").then().log().all().assertThat()
				.statusCode(200).body("scope", equalTo("APP")).header("Server", "Apache/2.4.18 (Ubuntu)").extract()
				.response().asString();

		System.out.println(response);

		JsonPath js = new JsonPath(response);// for parsing json

		String placeid = js.getString("place_id");
		System.out.println(placeid);
		// Add place--> Update place with new Adress--> get place to validate if new
		// adress is present
		// in response

		// Update place

		String newAddress = "70 Summer walk, USA";
		given().log().all().queryParam("key", "qaclick123").header("Content-type", "application/json")
				.body("{\r\n" + "\"place_id\":\"" + placeid + "\",\r\n" + "\"address\":\"" + newAddress + "\",\r\n"
						+ "\"key\":\"qaclick123\"\r\n" + "}")
				.when().put("maps/api/place/update/json").then().log().all().assertThat().statusCode(200)
				.body("msg", equalTo("Address successfully updated"));

		// Get place

		String getnewPlace = given().log().all().queryParam("key", "qaclick123").queryParam("place_id", placeid).when()
				.get("maps/api/place/get/json").then().log().all().assertThat().statusCode(200).extract().response()
				.asString();

		JsonPath js1 = ResusableMethods.rawToJson(getnewPlace);
		String actualadress = js1.getString("address");
		System.out.println(actualadress);
		Assert.assertEquals(actualadress, newAddress);
	
	
	
	
	
	
	  
	  
	  
		
	}

}
