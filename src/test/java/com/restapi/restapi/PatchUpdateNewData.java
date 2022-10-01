package com.restapi.restapi;

import com.restapi.model.RestAPIPojo;
import com.restapi.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class PatchUpdateNewData extends TestBase {

    @Test
    public void PatchUpdate()
    {
        RestAPIPojo restAPIPojo =new RestAPIPojo();
        restAPIPojo.setEmployee_name("Div Patel");
        restAPIPojo.setEmployee_salary(56060);
        restAPIPojo.setEmployee_age(26);

        Response response = given()
                .header("Content-Type","application/json")
                .body(restAPIPojo)
                .when()
                .patch("/update/7196");
        response.then();
        response.prettyPrint();
    }
}
