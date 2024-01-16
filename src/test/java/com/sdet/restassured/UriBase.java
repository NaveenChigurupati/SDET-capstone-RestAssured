package com.sdet.restassured;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
public class UriBase {
	@BeforeClass
	public void setup() {
		RestAssured.baseURI="https://reqres.in";
	}

}
