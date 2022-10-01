package com.reqress.reqresdata;

import com.reqress.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetAllData extends TestBase {

    @Test
    public void GetAllReqresData()
    {
        Response response = given()
                .when()
                .get("/api/users");
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void GetAllSingleData() {

        Response response = given()
                .get("/api/users/5");
        response.then().statusCode(200);
        response.prettyPrint();

    }
}
