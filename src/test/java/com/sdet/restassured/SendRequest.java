package com.sdet.restassured;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.http.ContentType;
import static org.hamcrest.Matchers.*;

public class SendRequest extends UriBase{

	@Test
	public void registerUser() throws FileNotFoundException, IOException {
		String email=DataFromExcel.readDataFromExcel("src/test/resources/Data.xlsx","TestData",1,0);
		String password=DataFromExcel.readDataFromExcel("src/test/resources/Data.xlsx","TestData",1,0);
		
		String requestBody="{\n" +
		"\"email\": \""+ email + "\",\n" +
		"\"password\": \""+ password + "\"\n" +
		"}";
		Response response=RestAssured.given()
				.contentType(ContentType.JSON)
				.body(requestBody)
				.post("/api/register");
		
		        response.then()
		        .statusCode(200)
		        .contentType(ContentType.JSON)
				.body("id",isA(Integer.class))
				.body("token",isA(String.class))
						
		        .log().all();
		
	}
	@Test
	public void wrongPassword() throws FileNotFoundException, IOException {
		String email=DataFromExcel.readDataFromExcel("src/test/resources/Data.xlsx","TestData",1,0);
		String password="";
		String requestBody="{\n" +
		"\"email\": \""+ email + "\",\n" +
		"\"password\": \""+ password + "\"\n" +
		"}";
		Response response=RestAssured.given()
				.contentType(ContentType.JSON)
				.body(requestBody)
				.post("/api/register");
		
		        response.then()
		        .statusCode(400)
		        .contentType(ContentType.JSON)	
		        .body("error", isA(String.class))
		        .log().all();
		
		
	}

	
}
