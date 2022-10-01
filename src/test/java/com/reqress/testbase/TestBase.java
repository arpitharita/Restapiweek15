package com.reqress.testbase;


import io.restassured.RestAssured;
import org.junit.BeforeClass;


public class TestBase {

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI="https://reqres.in/";
        //RestAssured.basePath="/student"; //product hoy to aa na aave direct testbase ma get ma

    }
}
