package com.restapi.restapi;

import com.restapi.model.RestAPIPojo;
import com.restapi.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class PostCreateNewdata extends TestBase {

    @Test
    public void PostNewData()
    {
        RestAPIPojo restAPIPojo =new RestAPIPojo();
        restAPIPojo.setEmployee_name("Divyar Patel");
        restAPIPojo.setEmployee_salary(320060);
        restAPIPojo.setEmployee_age(69);

        Response response = given()
                .header("Content-Type","application/json")
                .body(restAPIPojo)
                .when()
                .post("/create");
        response.then();
        response.prettyPrint();
    }
}
