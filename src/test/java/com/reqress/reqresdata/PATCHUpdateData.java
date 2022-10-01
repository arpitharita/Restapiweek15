package com.reqress.reqresdata;

import com.reqress.model.ReqresPojo;
import com.reqress.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class PATCHUpdateData extends TestBase {

    @Test
    public void UpdateData()
    {
        ReqresPojo reqresPojo =new ReqresPojo();
        reqresPojo.setEmail("ketty@reqres.in");
        reqresPojo.setFirstname("michel");
        reqresPojo.setLastname("lawson");
        reqresPojo.setText("To keep ReqRes free, contributions towards server costs are appreciated!");

        Response response = given()
                .header("Content-Type","application/json")
                .body(reqresPojo)
                .when()
                .patch("/api/users/654");
        response.then().statusCode(200);
        response.prettyPrint();

    }
}
