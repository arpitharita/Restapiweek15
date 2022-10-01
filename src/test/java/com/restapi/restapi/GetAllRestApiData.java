package com.restapi.restapi;

import com.restapi.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetAllRestApiData extends TestBase {

    @Test
    public void GetAllData()
    {
        Response response = given()
                .when()
                .get("/employees");
        response.then().statusCode(200);
        response.prettyPrint();

    }
    @Test
    public void GetSingleData()
    {
        Response response = given()
                .when()
                //.basePath("/employee")
                .get("/employee/1");
        response.then().statusCode(200);
        response.prettyPrint();

    }

}
