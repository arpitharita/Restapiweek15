package com.reqress.assertion;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class AssertionData {


    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "https://reqres.in/";
        response = given()
                .when()
                .get("/api/users")
                .then().statusCode(200);
    }
    //1.page = 1
    @Test
    public void test001() {

        response.body("page",equalTo(1));

    }
    //2.per_page = 6
    @Test
    public void test002() {

        response.body("per_page",equalTo(6));

    }
    //3.data[1].id = 2
    @Test
    public void test003() {

        response.body("data[1].id",equalTo(2));

    }

    //4.data[3].first_name = Eve
    @Test
    public void test004() {

        response.body("data[3].first_name",equalTo("Eve"));

    }

    //5.list of data = 6
    @Test
    public void DataSize()
    {
        List<Integer> datasize = response.extract().path("data");
    }
    //6.data[5].avatar="https://reqres.in/img/faces/11-image.jpg"
    @Test
    public void test005() {

        response.body("data[5].avatar",equalTo("https://reqres.in/img/faces/6-image.jpg"));

    }
    //7. support.url = "https://reqres.in/#support-heading"
    @Test
    public void test006() {

        response.body("support.url",equalTo("https://reqres.in/#support-heading"));

    }

    //8. support.text = "To keep ReqRes free, contributions towards server costs are appreciated!"
    @Test
    public void test007() {

        response.body("support.text",equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"));

    }
}