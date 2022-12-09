package baseAPI;

import static io.restassured.RestAssured.given;

import helper.Utils;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Base extends Utils {
	private RequestSpecification reqSpec;
	String url;
	Response resp;

	public void initBase(String url, String path) {
		try {
			RestAssured.baseURI = loadProperties(url) + loadProperties(path);
			setReqSpec(RestAssured.given().headers("User-Agent",
					"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11")
					.contentType(ContentType.JSON));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public RequestSpecification getReqSpec() {
		return reqSpec;
	}

	public void setReqSpec(RequestSpecification reqSpec) {
		this.reqSpec = reqSpec;
	}

}
