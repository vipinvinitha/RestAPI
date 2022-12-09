package testcase;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import baseAPI.Base;
import io.restassured.response.Response;
import listeners.ExtentTestManager;

public class API extends Base {
	@BeforeTest
	public void setup() {
		initBase("Url", "Path");
	}

	@Test
	@Parameters({ "date" })
	public void dateToUnix(String data) {
		ExtentTestManager.startTest("Date to Unix Conversion");
		Response res = getReqSpec().when().queryParam("s", data).get();
		System.out.println(res.getBody().asString());
		if (assertStatusCode(res, 200)) {
			ExtentTestManager.getTest().log(LogStatus.PASS, "Assertion response code successfully with 200");
			ExtentTestManager.getTest().log(LogStatus.INFO,
					"Input Date :-> " + data + "  Output Data :-> " + res.getBody().asString());
		} else {
			ExtentTestManager.getTest().log(LogStatus.FAIL,
					"Assertion response code Failed with " + res.getStatusCode());
			ExtentTestManager.getTest().log(LogStatus.INFO,
					"Input Date :-> " + data + "  Output Data :-> " + res.getBody().asString());
		}
	}

	@Test
	@Parameters({ "unix" })
	public void unixToDate(String data) {
		ExtentTestManager.startTest("Unix to Data Conversion");
		Response res = getReqSpec().when().queryParam("s", data).get();
		if (assertStatusCode(res, 200)) {
			ExtentTestManager.getTest().log(LogStatus.PASS, "Assertion response code successfully with 200");
			ExtentTestManager.getTest().log(LogStatus.INFO,
					"Input Date :-> " + data + "  Output Data :-> " + res.getBody().asString());
		} else {
			ExtentTestManager.getTest().log(LogStatus.FAIL,
					"Assertion response code Failed with " + res.getStatusCode());
			ExtentTestManager.getTest().log(LogStatus.INFO,
					"Input Date :-> " + data + "  Output Data :-> " + res.getBody().asString());
		}
	}

	@Test
	@Parameters({ "data" })
	public void invalidDate(String data) {
		ExtentTestManager.startTest("Invalid data Conversion");
		Response res = getReqSpec().when().queryParam("s", data).get();
		if (assertStatusCode(res, 200)) {
			ExtentTestManager.getTest().log(LogStatus.PASS, "Assertion response code successfully with 200");
			ExtentTestManager.getTest().log(LogStatus.INFO,
					"Input Date :-> " + data + "  Output Data :-> " + res.getBody().asString());
		} else {
			ExtentTestManager.getTest().log(LogStatus.FAIL,
					"Assertion response code Failed with " + res.getStatusCode());
			ExtentTestManager.getTest().log(LogStatus.INFO,
					"Input Date :-> " + data + "  Output Data :-> " + res.getBody().asString());
		}
	}
}
