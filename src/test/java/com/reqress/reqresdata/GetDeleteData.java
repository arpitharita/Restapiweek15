package com.reqress.reqresdata;

import com.reqress.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetDeleteData extends TestBase {
    @Test
    public void GetDeleteData()
    {
        Response response= given()
                .when()
                .get("/api/users/932");
        response.then().statusCode(404);
        response.prettyPrint();
    }
}

