package com.restapi.restapi;

import com.restapi.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class DeleteNewData extends TestBase {

    @Test
    public void DeleteNewData()
    {
            Response response = given()
                    .header("Content-Type","application/json")
                    .when()
                    .delete("/delete/7196");
            response.then();
            response.prettyPrint();
    }
}
