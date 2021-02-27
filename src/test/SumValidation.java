package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import files.Payloads;
import io.restassured.path.json.JsonPath;

public class SumValidation {
	
	@Test
	public void sumOfAmount() {
		// decalre one variable and initlize with 0

		int sum = 0;
		JsonPath js = new JsonPath(Payloads.coursePrice());
		int count = js.getInt("courses.size()");

		for (int i = 0; i < count; i++) {
			int price = js.getInt("courses[" + i + "].price");
			int copies = js.getInt("courses[" + i + "].copies");

			int amount = price * copies;
			System.out.println(amount);
			sum = sum + amount;
		}
		System.out.println(sum);
		int purchaseAmount = js.get("dashboard.purchaseAmount");
		Assert.assertEquals(sum, purchaseAmount);

	}

}
