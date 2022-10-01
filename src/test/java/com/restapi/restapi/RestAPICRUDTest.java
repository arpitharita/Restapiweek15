package com.restapi.restapi;

import com.restapi.model.RestAPIPojo;
import com.restapi.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class RestAPICRUDTest extends TestBase {

    @Test
    public void GetAllData()
    {
        Response response = given()
                .when()
                .get("/employees");
        response.then();
        response.prettyPrint();

    }
    @Test
    public void PostNewData() {
        RestAPIPojo restAPIPojo = new RestAPIPojo();
        restAPIPojo.setEmployee_name("Divyartt Patel");
        restAPIPojo.setEmployee_salary(320870);
        restAPIPojo.setEmployee_age(26);

        Response response = given()
                .header("Content-Type", "application/json")
                .body(restAPIPojo)
                .when()
                .post("/create");
        response.then();
        response.prettyPrint();
    }
    @Test
    public void PatchUpdateNewdata()
    {
        RestAPIPojo restAPIPojo =new RestAPIPojo();
        restAPIPojo.setEmployee_name("Divs Patel");
        restAPIPojo.setEmployee_salary(326860);
        restAPIPojo.setEmployee_age(24);

        Response response = given()
                .header("Content-Type","application/json")
                .body(restAPIPojo)
                .when()
                .patch("/update/2664");
        response.then();
        response.prettyPrint();

    }
    @Test
    public void DeleteData()
    {
        Response response = given()
                .header("Content-Type","application/json")
                .when()
                .delete("/delete/2");
        response.then();
        response.prettyPrint();


    }
    @Test
    public void GetDeleteData()
    {
        Response response = given()
                .when()
                .get("/employees");
        response.then();
        response.prettyPrint();
    }
}
